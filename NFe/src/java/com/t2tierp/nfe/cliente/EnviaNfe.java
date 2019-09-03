package com.t2tierp.nfe.cliente;

import br.inf.portalfiscal.www.nfe.wsdl.nferecepcao2.NfeRecepcao2Stub;
import br.inf.portalfiscal.www.nfe.wsdl.nferetrecepcao2.NfeRetRecepcao2Stub;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.httpclient.protocol.Protocol;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Classe que realiza o envio da NF-e.</p>
 *
 * <p>The MIT License</p>
 *
 * <p>Copyright: Copyright (C) 2010 T2Ti.COM</p>
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 *       The author may be contacted at:
 *           t2ti.com@gmail.com</p>
 *
 * @author Claudio de Barros (T2Ti.COM)
 * @version 1.0
 */
public class EnviaNfe {

    public Map enviaNfe(String xml, String alias, KeyStore ks, char[] senha, String codigoUf, String ambiente) throws Exception {
        String versaoDados = "2.00";
        String url = "";
        if (codigoUf.equals("53")) {
            if (ambiente.equals("1")) {
                url = "https://nfe.sefazvirtual.rs.gov.br/ws/nferecepcao/NfeRecepcao2.asmx";
            } else if (ambiente.equals("2")) {
                url = "https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/nferecepcao/NfeRecepcao2.asmx";
            }
        }
        /* fica a cargo de cada participante definir a url que será utiizada de acordo com o código da UF
         * URLs disponíveis em:
         * Homologação: http://hom.nfe.fazenda.gov.br/PORTAL/WebServices.aspx
         * Produção: http://www.nfe.fazenda.gov.br/portal/WebServices.aspx
         */

        if (url.equals("")) {
            throw new Exception("URL da sefaz não definida para o código de UF = " + codigoUf);
        }

        X509Certificate certificate = (X509Certificate) ks.getCertificate(alias);
        PrivateKey privatekey = (PrivateKey) ks.getKey(alias, senha);
        SocketFactoryDinamico socketFactory = new SocketFactoryDinamico(certificate, privatekey);
        //arquivo que contém a cadeia de certificados do serviço a ser consumido
        socketFactory.setFileCacerts(this.getClass().getResourceAsStream("/br/inf/portalfiscal/nfe/jssecacerts"));

        //define o protocolo a ser utilizado na conexão
        Protocol protocol = new Protocol("https", socketFactory, 443);
        Protocol.registerProtocol("https", protocol);

        OMElement omElement = AXIOMUtil.stringToOM(xml);

        NfeRecepcao2Stub.NfeDadosMsg dadosMsg = new NfeRecepcao2Stub.NfeDadosMsg();
        dadosMsg.setExtraElement(omElement);

        NfeRecepcao2Stub.NfeCabecMsg cabecMsg = new NfeRecepcao2Stub.NfeCabecMsg();
        cabecMsg.setCUF(codigoUf);
        cabecMsg.setVersaoDados(versaoDados);

        NfeRecepcao2Stub.NfeCabecMsgE cabecMsgE = new NfeRecepcao2Stub.NfeCabecMsgE();
        cabecMsgE.setNfeCabecMsg(cabecMsg);

        NfeRecepcao2Stub stub = new NfeRecepcao2Stub(url);

        NfeRecepcao2Stub.NfeRecepcaoLote2Result result = stub.nfeRecepcaoLote2(dadosMsg, cabecMsgE);

        //System.out.println(result.getExtraElement().toString());

        ByteArrayInputStream in = new ByteArrayInputStream(result.getExtraElement().toString().getBytes());

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        Document doc = dbf.newDocumentBuilder().parse(in);

        String recibo = "";
        NodeList nodeList = doc.getDocumentElement().getElementsByTagName("nRec");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            recibo = element.getTextContent();
        }

        Thread.sleep(3000);
        Map map = consultaEnvioNfe(recibo, xml, codigoUf, ambiente);
        int contador = 0;
        while (map.get("resposta").toString().contains("Lote em processamento")) {//Lote em processamento
            Thread.sleep(3000);
            map = consultaEnvioNfe(recibo, xml, codigoUf, ambiente);
            contador += 1;
            if (contador == 3) {
                if (JOptionPane.showConfirmDialog(null, "Já foram realizadas 3 tentativas de consulta do lote. Nr recibo: " + recibo + "\nLote ainda está em Processamento. Consultar novamente?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                    break;
                }
            }
        }

        return map;
    }

    public Map consultaEnvioNfe(String numeroRecibo, String xmlEnviNfe, String codigoUf, String ambiente) throws Exception {
        Map map = new HashMap();

        String url = "";
        if (codigoUf.equals("53")) {
            if (ambiente.equals("1")) {
                url = "https://nfe.sefazvirtual.rs.gov.br/ws/NfeRetRecepcao/NfeRetRecepcao2.asmx";
            } else if (ambiente.equals("2")) {
                url = "https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/nferetrecepcao/NfeRetRecepcao2.asmx";
            }
        }
        /* fica a cargo de cada participante definir a url que será utiizada de acordo com o código da UF
         * URLs disponíveis em:
         * Homologação: http://hom.nfe.fazenda.gov.br/PORTAL/WebServices.aspx
         * Produção: http://www.nfe.fazenda.gov.br/portal/WebServices.aspx
         */

        if (url.equals("")) {
            throw new Exception("URL da sefaz não definida para o código de UF = " + codigoUf);
        }

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<consReciNFe versao=\"2.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">"
                + "<tpAmb>" + ambiente + "</tpAmb>"
                + "<nRec>" + numeroRecibo + "</nRec>"
                + "</consReciNFe>";

        OMElement omeElement = AXIOMUtil.stringToOM(xml);

        NfeRetRecepcao2Stub.NfeDadosMsg dadosMsg = new NfeRetRecepcao2Stub.NfeDadosMsg();
        dadosMsg.setExtraElement(omeElement);

        NfeRetRecepcao2Stub.NfeCabecMsg cabecMsg = new NfeRetRecepcao2Stub.NfeCabecMsg();
        cabecMsg.setCUF(codigoUf);
        cabecMsg.setVersaoDados("2.00");

        NfeRetRecepcao2Stub.NfeCabecMsgE cabecMsgE = new NfeRetRecepcao2Stub.NfeCabecMsgE();
        cabecMsgE.setNfeCabecMsg(cabecMsg);

        NfeRetRecepcao2Stub stub = new NfeRetRecepcao2Stub(url);

        NfeRetRecepcao2Stub.NfeRetRecepcao2Result result = stub.nfeRetRecepcao2(dadosMsg, cabecMsgE);

        //System.out.println(result.getExtraElement().toString());

        ByteArrayInputStream in = new ByteArrayInputStream(result.getExtraElement().toString().getBytes());
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        Document docResposta = dbf.newDocumentBuilder().parse(in);

        NodeList nodeListMotivo = docResposta.getDocumentElement().getElementsByTagName("xMotivo");
        NodeList nodeListProt = docResposta.getDocumentElement().getElementsByTagName("protNFe");
        String respostaSefaz = "";
        String xmlProt = "";
        String xmlProc = "";
        String xmlNfe = "";
        boolean autorizado = false;

        for (int i = 0; i < nodeListMotivo.getLength(); i++) {
            Element element = (Element) nodeListMotivo.item(i);
            respostaSefaz += element.getTextContent() + "\n";
            if (element.getTextContent().startsWith("Autorizado")) {
                autorizado = true;
            }
        }

        map.put("autorizado", autorizado);
        map.put("resposta", respostaSefaz);

        if (autorizado) {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer trans = tf.newTransformer();

            ByteArrayOutputStream outProt = new ByteArrayOutputStream();
            trans.transform(new DOMSource(nodeListProt.item(0)), new StreamResult(outProt));
            xmlProt = outProt.toString().replaceAll("<\\?xml version=\"1.0\" encoding=\"UTF-8\"\\?>", "");

            ByteArrayInputStream inEnviNfe = new ByteArrayInputStream(xmlEnviNfe.getBytes());
            Document docEnviNfe = dbf.newDocumentBuilder().parse(inEnviNfe);
            ByteArrayOutputStream outNfe = new ByteArrayOutputStream();
            trans.transform(new DOMSource(docEnviNfe.getElementsByTagName("NFe").item(0)), new StreamResult(outNfe));
            xmlNfe = outNfe.toString().replaceAll("<\\?xml version=\"1.0\" encoding=\"UTF-8\"\\?>", "");

            xmlProc = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
            xmlProc += "<nfeProc versao=\"2.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">";
            xmlProc += xmlNfe;
            xmlProc += xmlProt;
            xmlProc += "</nfeProc>";

            map.put("xmlProc", xmlProc);
        }

        return map;
    }
}
