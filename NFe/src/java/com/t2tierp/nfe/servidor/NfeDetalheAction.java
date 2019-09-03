package com.t2tierp.nfe.servidor;

import com.t2tierp.cadastros.java.ProdutoVO;
import com.t2tierp.controleestoque.servidor.ControleEstoqueAction;
import com.t2tierp.ged.java.ArquivoVO;
import com.t2tierp.padrao.java.Constantes;
import com.t2tierp.padrao.servidor.HibernateUtil;
import com.t2tierp.nfe.java.NfeCabecalhoVO;
import com.t2tierp.nfe.java.NfeConfiguracaoVO;
import com.t2tierp.nfe.java.NfeCteReferenciadoVO;
import com.t2tierp.nfe.java.NfeCupomFiscalReferenciadoVO;
import com.t2tierp.nfe.java.NfeDestinatarioVO;
import com.t2tierp.nfe.java.NfeDetalheVO;
import com.t2tierp.nfe.java.NfeDuplicataVO;
import com.t2tierp.nfe.java.NfeFaturaVO;
import com.t2tierp.nfe.java.NfeLocalEntregaVO;
import com.t2tierp.nfe.java.NfeLocalRetiradaVO;
import com.t2tierp.nfe.java.NfeNfReferenciadaVO;
import com.t2tierp.nfe.java.NfeNumeroVO;
import com.t2tierp.nfe.java.NfeProdRuralReferenciadaVO;
import com.t2tierp.nfe.java.NfeReferenciadaVO;
import com.t2tierp.nfe.java.NfeTransporteReboqueVO;
import com.t2tierp.nfe.java.NfeTransporteVO;
import com.t2tierp.nfe.java.NfeTransporteVolumeLacreVO;
import com.t2tierp.nfe.java.NfeTransporteVolumeVO;
import com.t2tierp.padrao.cliente.Util;
import com.t2tierp.padrao.java.Biblioteca;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.server.Action;
import org.openswing.swing.server.UserSessionParameters;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Classe que realiza a persistência dos dados de NfeDetalhe.</p>
 *
 * <p>The MIT License</p>
 *
 * <p>Copyright: Copyright (C) 2010 T2Ti.COM
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
 *        The author may be contacted at:
 *            t2ti.com@gmail.com</p>
 *
 * @author Claudio de Barros (t2ti.com@gmail.com)
 * @version 1.0
 */
public class NfeDetalheAction implements Action {

    public NfeDetalheAction() {
    }

    public String getRequestName() {
        return "nfeDetalheAction";
    }

    public Response executeCommand(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Object[] pars = (Object[]) inputPar;
        Integer acao = (Integer) pars[0];

        switch (acao) {
            case Constantes.LOAD: {
                return load(inputPar, userSessionPars, request, response, userSession, context);
            }
            case Constantes.INSERT: {
                return insert(inputPar, userSessionPars, request, response, userSession, context);
            }
            case Constantes.UPDATE: {
                return update(inputPar, userSessionPars, request, response, userSession, context);
            }
            case Constantes.DELETE: {
                return delete(inputPar, userSessionPars, request, response, userSession, context);
            }
            case 99: {
                return verificaProdutoCadastrado(inputPar, userSessionPars, request, response, userSession, context);
            }
            case 100: {
                return salvaXml(inputPar, context);
            }
            case 101: {
                return danfe(inputPar, context);
            }
            case 102: {
                return cancelaNfe(inputPar, context);
            }
            case 103: {
                return enviaEmail(inputPar, context);
            }
        }
        return null;
    }

    private Response load(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        Object[] pars = (Object[]) inputPar;
        String pk = (String) pars[1];

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(NfeCabecalhoVO.class);
            criteria.add(Restrictions.eq("id", Integer.valueOf(pk)));

            NfeCabecalhoVO nfeCabecalho = (NfeCabecalhoVO) criteria.uniqueResult();

            return new VOResponse(nfeCabecalho);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception ex1) {
            }
        }
    }

    public Response insert(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        try {
            Object[] pars = (Object[]) inputPar;
            NfeCabecalhoVO nfeCabecalho = (NfeCabecalhoVO) pars[1];
            NfeDestinatarioVO destinatario = (NfeDestinatarioVO) pars[2];
            List<NfeDetalheVO> listaNfeDetalhe = (Vector) pars[3];
            List<NfeCupomFiscalReferenciadoVO> listaCuponsFiscais = (Vector) pars[4];
            NfeLocalEntregaVO localEntrega = (NfeLocalEntregaVO) pars[5];
            NfeLocalRetiradaVO localRetirada = (NfeLocalRetiradaVO) pars[6];
            NfeTransporteVO transporte = (NfeTransporteVO) pars[7];
            List<NfeTransporteReboqueVO> transporteReboque = (Vector) pars[8];
            List<NfeTransporteVolumeVO> transporteVolume = (Vector) pars[9];
            NfeFaturaVO fatura = (NfeFaturaVO) pars[10];
            List<NfeDuplicataVO> listaDuplicata = (Vector) pars[11];
            List<NfeReferenciadaVO> listaNfeReferenciada = (Vector) pars[12];
            List<NfeNfReferenciadaVO> listaNf1Referenciada = (Vector) pars[13];
            List<NfeCteReferenciadoVO> listaCte = (Vector) pars[14];
            List<NfeProdRuralReferenciadaVO> prodRuralReferenciada = (Vector) pars[15];

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            if (nfeCabecalho.getVendaCabecalho().getId() == null) {
                nfeCabecalho.setVendaCabecalho(null);
            }

            Date dataAtual = new Date();
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

            nfeCabecalho.setUfEmitente(nfeCabecalho.getEmpresa().getCodigoIbgeUf());
            nfeCabecalho.setDataEmissao(dataAtual);
            nfeCabecalho.setDataEntradaSaida(dataAtual);
            nfeCabecalho.setHoraEntradaSaida(formatoHora.format(dataAtual));
            nfeCabecalho.setCodigoMunicipio(destinatario.getCodigoMunicipio());

            nfeCabecalho = numeroNfe(nfeCabecalho, session);

            nfeCabecalho = configuraNfe(nfeCabecalho, session);

            session.save(nfeCabecalho);

            destinatario.setNfeCabecalho(nfeCabecalho);
            destinatario.setCodigoPais(1058);
            destinatario.setNomePais("Brazil");
            session.save(destinatario);

            for (int i = 0; i < listaNfeDetalhe.size(); i++) {
                listaNfeDetalhe.get(i).setNfeCabecalho(nfeCabecalho);
                listaNfeDetalhe.get(i).setNumeroItem(i + 1);
                session.save(listaNfeDetalhe.get(i));

                ControleEstoqueAction.atualizaEstoque(session, listaNfeDetalhe.get(i).getProduto().getId(), listaNfeDetalhe.get(i).getQuantidadeComercial().negate());

                for (int j = 0; j < listaNfeDetalhe.get(i).getListaArmamento().size(); j++) {
                    listaNfeDetalhe.get(i).getListaArmamento().get(j).setNfeDetalhe(listaNfeDetalhe.get(i));
                    session.save(listaNfeDetalhe.get(i).getListaArmamento().get(j));
                }

                for (int j = 0; j < listaNfeDetalhe.get(i).getListaDeclaracaoImportacao().size(); j++) {
                    listaNfeDetalhe.get(i).getListaDeclaracaoImportacao().get(j).setNfeDetalhe(listaNfeDetalhe.get(i));
                    session.save(listaNfeDetalhe.get(i).getListaDeclaracaoImportacao().get(j));
                    for (int k = 0; k < listaNfeDetalhe.get(i).getListaDeclaracaoImportacao().get(j).getListaImportacaoDetalhe().size(); k++) {
                        listaNfeDetalhe.get(i).getListaDeclaracaoImportacao().get(j).getListaImportacaoDetalhe().get(k).setNfeDeclaracaoImportacao(listaNfeDetalhe.get(i).getListaDeclaracaoImportacao().get(j));
                        session.save(listaNfeDetalhe.get(i).getListaDeclaracaoImportacao().get(j).getListaImportacaoDetalhe().get(k));
                    }
                }

                for (int j = 0; j < listaNfeDetalhe.get(i).getListaMedicamento().size(); j++) {
                    listaNfeDetalhe.get(i).getListaMedicamento().get(j).setNfeDetalhe(listaNfeDetalhe.get(i));
                    session.save(listaNfeDetalhe.get(i).getListaMedicamento().get(j));
                }
            }

            for (int i = 0; i < listaCuponsFiscais.size(); i++) {
                listaCuponsFiscais.get(i).setNfeCabecalho(nfeCabecalho);
                session.save(listaCuponsFiscais.get(i));
            }

            localEntrega.setNfeCabecalho(nfeCabecalho);
            session.save(localEntrega);

            localRetirada.setNfeCabecalho(nfeCabecalho);
            session.save(localRetirada);

            transporte.setNfeCabecalho(nfeCabecalho);
            if (transporte.getTransportadora().getId() == null) {
                transporte.setTransportadora(null);
            }
            session.save(transporte);

            for (int i = 0; i < transporteReboque.size(); i++) {
                transporteReboque.get(i).setNfeTransporte(transporte);
                session.save(transporteReboque.get(i));
            }

            for (int i = 0; i < transporteVolume.size(); i++) {
                transporteVolume.get(i).setNfeTransporte(transporte);
                session.save(transporteVolume.get(i));

                for (int j = 0; j < transporteVolume.get(i).getListaTransporteVolumeLacre().size(); j++) {
                    transporteVolume.get(i).getListaTransporteVolumeLacre().get(j).setNfeTransporteVolume(transporteVolume.get(i));
                    session.save(transporteVolume.get(i).getListaTransporteVolumeLacre().get(j));
                }
            }

            fatura.setNfeCabecalho(nfeCabecalho);
            session.save(fatura);

            for (int i = 0; i < listaDuplicata.size(); i++) {
                listaDuplicata.get(i).setNfeCabecalho(nfeCabecalho);
                session.save(listaDuplicata.get(i));
            }

            for (int i = 0; i < listaNfeReferenciada.size(); i++) {
                listaNfeReferenciada.get(i).setNfeCabecalho(nfeCabecalho);
                session.save(listaNfeReferenciada.get(i));
            }

            for (int i = 0; i < listaNf1Referenciada.size(); i++) {
                listaNf1Referenciada.get(i).setNfeCabecalho(nfeCabecalho);
                session.save(listaNf1Referenciada.get(i));
            }

            for (int i = 0; i < listaCte.size(); i++) {
                listaCte.get(i).setNfeCabecalho(nfeCabecalho);
                session.save(listaCte.get(i));
            }

            for (int i = 0; i < prodRuralReferenciada.size(); i++) {
                prodRuralReferenciada.get(i).setNfeCabecalho(nfeCabecalho);
                session.save(prodRuralReferenciada.get(i));
            }

            session.getTransaction().commit();

            return new VOResponse(nfeCabecalho);
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
        }
    }

    public Response update(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        try {
            Object[] pars = (Object[]) inputPar;
            NfeCabecalhoVO nfeCabecalho = (NfeCabecalhoVO) pars[1];
            NfeDestinatarioVO destinatario = (NfeDestinatarioVO) pars[2];
            List<NfeDetalheVO> listaNfeDetalhe = (Vector) pars[3];
            List<NfeCupomFiscalReferenciadoVO> listaCuponsFiscais = (Vector) pars[4];
            NfeLocalEntregaVO localEntrega = (NfeLocalEntregaVO) pars[5];
            NfeLocalRetiradaVO localRetirada = (NfeLocalRetiradaVO) pars[6];
            NfeTransporteVO transporte = (NfeTransporteVO) pars[7];
            List<NfeTransporteReboqueVO> transporteReboque = (Vector) pars[8];
            List<NfeTransporteVolumeVO> transporteVolume = (Vector) pars[9];
            NfeFaturaVO fatura = (NfeFaturaVO) pars[10];
            List<NfeDuplicataVO> listaDuplicata = (Vector) pars[11];
            List<NfeReferenciadaVO> listaNfeReferenciada = (Vector) pars[12];
            List<NfeNfReferenciadaVO> listaNf1Referenciada = (Vector) pars[13];
            List<NfeCteReferenciadoVO> listaCte = (Vector) pars[14];
            List<NfeProdRuralReferenciadaVO> prodRuralReferenciada = (Vector) pars[15];

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            if (nfeCabecalho.getVendaCabecalho().getId() == null) {
                nfeCabecalho.setVendaCabecalho(null);
            }

            session.update(nfeCabecalho);

            session.update(destinatario);

            String sqlExcluir;
            Query query;

            Criteria criteria = session.createCriteria(NfeDetalheVO.class);
            criteria.add(Restrictions.eq("nfeCabecalho", nfeCabecalho));
            List<NfeDetalheVO> listaNfeDetOld = criteria.list();
            for (int i = 0; i < listaNfeDetOld.size(); i++) {
                ControleEstoqueAction.atualizaEstoque(session, listaNfeDetOld.get(i).getProduto().getId(), listaNfeDetOld.get(i).getQuantidadeComercial());
            }

            criteria = session.createCriteria(NfeDetalheVO.class);
            criteria.add(Restrictions.eq("nfeCabecalho", nfeCabecalho));
            for (int i = 0; i < listaNfeDetalhe.size(); i++) {
                listaNfeDetalhe.get(i).setNfeCabecalho(nfeCabecalho);
                listaNfeDetalhe.get(i).setNumeroItem(i + 1);
                session.saveOrUpdate(listaNfeDetalhe.get(i));
                criteria.add(Restrictions.ne("id", listaNfeDetalhe.get(i).getId()));

                ControleEstoqueAction.atualizaEstoque(session, listaNfeDetalhe.get(i).getProduto().getId(), listaNfeDetalhe.get(i).getQuantidadeComercial().negate());
            }
            List<NfeDetalheVO> detalheExcluir = criteria.list();
            for (int i = 0; i < detalheExcluir.size(); i++) {
                session.delete(detalheExcluir.get(i));
            }

            if (!listaCuponsFiscais.isEmpty()) {
                sqlExcluir = "delete from NFE_CUPOM_FISCAL_REFERENCIADO where ID not in (0";
                for (int i = 0; i < listaCuponsFiscais.size(); i++) {
                    listaCuponsFiscais.get(i).setNfeCabecalho(nfeCabecalho);
                    session.saveOrUpdate(listaCuponsFiscais.get(i));
                    sqlExcluir += "," + listaCuponsFiscais.get(i).getId();
                }
                sqlExcluir += ") and ID_NFE_CABECALHO = :id";
                query = session.createSQLQuery(sqlExcluir);
                query.setInteger("id", nfeCabecalho.getId());
                query.executeUpdate();
            }

            session.update(localEntrega);

            session.update(localRetirada);

            if (transporte.getTransportadora().getId() == null) {
                transporte.setTransportadora(null);
            }
            session.update(transporte);

            if (!transporteReboque.isEmpty()) {
                sqlExcluir = "delete from NFE_TRANSPORTE_REBOQUE where ID not in (0";
                for (int i = 0; i < transporteReboque.size(); i++) {
                    transporteReboque.get(i).setNfeTransporte(transporte);
                    session.saveOrUpdate(transporteReboque.get(i));
                    sqlExcluir += "," + transporteReboque.get(i).getId();
                }
                sqlExcluir += ") and ID_NFE_TRANSPORTE = :id";
                query = session.createSQLQuery(sqlExcluir);
                query.setInteger("id", transporte.getId());
                query.executeUpdate();
            }

            if (!transporteVolume.isEmpty()) {
                sqlExcluir = "delete from NFE_TRANSPORTE_VOLUME where ID not in (0";
                for (int i = 0; i < transporteVolume.size(); i++) {
                    transporteVolume.get(i).setNfeTransporte(transporte);
                    session.saveOrUpdate(transporteVolume.get(i));
                    List<NfeTransporteVolumeLacreVO> transporteVolumeLacre = transporteVolume.get(i).getListaTransporteVolumeLacre();
                    sqlExcluir += "," + transporteVolume.get(i).getId();

                    if (!transporteVolumeLacre.isEmpty()) {
                        String sqlExcluirLacre = "delete from NFE_TRANSPORTE_VOLUME_LACRE where ID not in (0";
                        for (int j = 0; j < transporteVolumeLacre.size(); j++) {
                            transporteVolumeLacre.get(j).setNfeTransporteVolume(transporteVolume.get(i));
                            session.saveOrUpdate(transporteVolumeLacre.get(j));
                            sqlExcluirLacre += "," + listaCuponsFiscais.get(i).getId();
                        }
                        sqlExcluirLacre += ") and ID_NFE_TRANSPORTE_VOLUME = :id";
                        query = session.createSQLQuery(sqlExcluirLacre);
                        query.setInteger("id", transporteVolume.get(i).getId());
                        query.executeUpdate();
                    }
                }
                sqlExcluir += ") and ID_NFE_TRANSPORTE = :id";
                query = session.createSQLQuery(sqlExcluir);
                query.setInteger("id", transporte.getId());
                query.executeUpdate();
            }

            session.update(fatura);

            if (!listaDuplicata.isEmpty()) {
                sqlExcluir = "delete from NFE_DUPLICATA where ID not in (0";
                for (int i = 0; i < listaDuplicata.size(); i++) {
                    listaDuplicata.get(i).setNfeCabecalho(nfeCabecalho);
                    session.saveOrUpdate(listaDuplicata.get(i));
                    sqlExcluir += "," + listaDuplicata.get(i).getId();
                }
                sqlExcluir += ") and ID_NFE_CABECALHO = :id";
                query = session.createSQLQuery(sqlExcluir);
                query.setInteger("id", nfeCabecalho.getId());
                query.executeUpdate();
            }

            if (!listaNfeReferenciada.isEmpty()) {
                sqlExcluir = "delete from NFE_REFERENCIADA where ID not in (0";
                for (int i = 0; i < listaNfeReferenciada.size(); i++) {
                    listaNfeReferenciada.get(i).setNfeCabecalho(nfeCabecalho);
                    session.saveOrUpdate(listaNfeReferenciada.get(i));
                    sqlExcluir += "," + listaNfeReferenciada.get(i).getId();
                }
                sqlExcluir += ") and ID_NFE_CABECALHO = :id";
                query = session.createSQLQuery(sqlExcluir);
                query.setInteger("id", nfeCabecalho.getId());
                query.executeUpdate();
            }

            if (!listaNf1Referenciada.isEmpty()) {
                sqlExcluir = "delete from NFE_NF_REFERENCIADA where ID not in (0";
                for (int i = 0; i < listaNf1Referenciada.size(); i++) {
                    listaNf1Referenciada.get(i).setNfeCabecalho(nfeCabecalho);
                    session.saveOrUpdate(listaNf1Referenciada.get(i));
                    sqlExcluir += "," + listaNf1Referenciada.get(i).getId();
                }
                sqlExcluir += ") and ID_NFE_CABECALHO = :id";
                query = session.createSQLQuery(sqlExcluir);
                query.setInteger("id", nfeCabecalho.getId());
                query.executeUpdate();
            }

            if (!listaCte.isEmpty()) {
                sqlExcluir = "delete from NFE_CTE_REFERENCIADO where ID not in (0";
                for (int i = 0; i < listaCte.size(); i++) {
                    listaCte.get(i).setNfeCabecalho(nfeCabecalho);
                    session.saveOrUpdate(listaCte.get(i));
                    sqlExcluir += "," + listaCte.get(i).getId();
                }
                sqlExcluir += ") and ID_NFE_CABECALHO = :id";
                query = session.createSQLQuery(sqlExcluir);
                query.setInteger("id", nfeCabecalho.getId());
                query.executeUpdate();
            }

            if (!prodRuralReferenciada.isEmpty()) {
                sqlExcluir = "delete from NFE_PROD_RURAL_REFERENCIADA where ID not in (0";
                for (int i = 0; i < prodRuralReferenciada.size(); i++) {
                    prodRuralReferenciada.get(i).setNfeCabecalho(nfeCabecalho);
                    session.saveOrUpdate(prodRuralReferenciada.get(i));
                    sqlExcluir += "," + prodRuralReferenciada.get(i).getId();
                }
                sqlExcluir += ") and ID_NFE_CABECALHO = :id";
                query = session.createSQLQuery(sqlExcluir);
                query.setInteger("id", nfeCabecalho.getId());
                query.executeUpdate();
            }

            session.getTransaction().commit();

            return new VOResponse(nfeCabecalho);
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
        }
    }

    public Response delete(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        return null;
    }

    public Response verificaProdutoCadastrado(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        Object[] pars = (Object[]) inputPar;
        List<NfeDetalheVO> listaNfeDetalhe = (Vector) pars[1];

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            Criteria criteria = session.createCriteria(ProdutoVO.class);

            ProdutoVO produto;
            for (int i = 0; i < listaNfeDetalhe.size(); i++) {
                criteria.add(Restrictions.eq("gtin", listaNfeDetalhe.get(i).getGtin()));
                produto = (ProdutoVO) criteria.uniqueResult();
                if (produto != null) {
                    listaNfeDetalhe.get(i).setProduto(produto);
                    listaNfeDetalhe.get(i).setProdutoCadastrado(true);
                } else {
                    listaNfeDetalhe.get(i).setProdutoCadastrado(false);
                }
            }

            return new VOListResponse(listaNfeDetalhe, false, listaNfeDetalhe.size());
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception ex1) {
            }
        }
    }

    private NfeCabecalhoVO numeroNfe(NfeCabecalhoVO nfeCabecalho, Session session) throws Exception {
        DecimalFormat formatoNumero = new DecimalFormat("000000000");
        DecimalFormat formatoCodigoNumerico = new DecimalFormat("00000000");
        SimpleDateFormat formatoAno = new SimpleDateFormat("yy");
        SimpleDateFormat formatoMes = new SimpleDateFormat("MM");

        Criteria criteria = session.createCriteria(NfeNumeroVO.class);
        NfeNumeroVO numero = (NfeNumeroVO) criteria.uniqueResult();
        if (numero == null) {
            numero = new NfeNumeroVO();
            numero.setEmpresa(nfeCabecalho.getEmpresa());
            numero.setSerie("001");
            numero.setNumero(1);
        } else {
            numero.setNumero(numero.getNumero() + 1);
        }
        session.saveOrUpdate(numero);

        nfeCabecalho.setNumero(formatoNumero.format(numero.getNumero()));
        nfeCabecalho.setCodigoNumerico(formatoCodigoNumerico.format(numero.getNumero()));
        nfeCabecalho.setSerie(numero.getSerie());

        nfeCabecalho.setChaveAcesso("" + nfeCabecalho.getEmpresa().getCodigoIbgeUf()
                + formatoAno.format(nfeCabecalho.getDataEmissao())
                + formatoMes.format(nfeCabecalho.getDataEmissao())
                + nfeCabecalho.getEmpresa().getCnpj()
                + nfeCabecalho.getCodigoModelo()
                + nfeCabecalho.getSerie()
                + nfeCabecalho.getNumero()
                + "1"
                + nfeCabecalho.getCodigoNumerico());
        nfeCabecalho.setDigitoChaveAcesso(Util.modulo11(nfeCabecalho.getChaveAcesso()).toString());

        return nfeCabecalho;
    }

    private NfeCabecalhoVO configuraNfe(NfeCabecalhoVO nfeCabecalho, Session session) throws Exception {
        Criteria criteria = session.createCriteria(NfeConfiguracaoVO.class);
        NfeConfiguracaoVO configuracao = (NfeConfiguracaoVO) criteria.uniqueResult();

        nfeCabecalho.setAmbiente(configuracao.getWebserviceAmbiente());
        nfeCabecalho.setProcessoEmissao(configuracao.getProcessoEmissao());
        nfeCabecalho.setVersaoProcessoEmissao(configuracao.getVersaoProcessoEmissao());

        return nfeCabecalho;
    }

    public Response salvaXml(Object inputPar, ServletContext context) {
        Session session = null;
        Object[] pars = (Object[]) inputPar;
        NfeCabecalhoVO nfeCabecalho = (NfeCabecalhoVO) pars[1];
        String xml = (String) pars[2];

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            nfeCabecalho.setStatusNota("5");
            if (nfeCabecalho.getVendaCabecalho().getId() == null) {
                nfeCabecalho.setVendaCabecalho(null);
            }
            session.update(nfeCabecalho);

            //salva o xml
            String caminhoArquivo = context.getRealPath("/xmlnfe") + System.getProperty("file.separator") + nfeCabecalho.getChaveAcesso() + nfeCabecalho.getDigitoChaveAcesso() + "-nfeproc.xml";
            OutputStream out = new FileOutputStream(new File(caminhoArquivo));
            out.write(xml.getBytes());
            out.close();

            session.getTransaction().commit();

            return new VOResponse(nfeCabecalho);
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception ex1) {
            }
        }
    }

    public Response danfe(Object inputPar, ServletContext context) {
        Object[] pars = (Object[]) inputPar;
        NfeCabecalhoVO nfeCabecalho = (NfeCabecalhoVO) pars[1];

        try {
            File file = new File(context.getRealPath("/xmlnfe") + System.getProperty("file.separator") + nfeCabecalho.getChaveAcesso() + nfeCabecalho.getDigitoChaveAcesso() + "-nfeproc.xml");
            ArquivoVO arquivo = new ArquivoVO();
            arquivo.setFile(Biblioteca.getBytesFromFile(file));

            return new VOResponse(arquivo);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        }
    }

    public Response cancelaNfe(Object inputPar, ServletContext context) {
        Session session = null;
        Object[] pars = (Object[]) inputPar;
        NfeCabecalhoVO nfeCabecalho = (NfeCabecalhoVO) pars[1];
        String xml = (String) pars[2];

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            nfeCabecalho.setStatusNota("6");
            if (nfeCabecalho.getVendaCabecalho().getId() == null) {
                nfeCabecalho.setVendaCabecalho(null);
            }
            session.update(nfeCabecalho);

            //atualiza o estoque
            Criteria criteria = session.createCriteria(NfeDetalheVO.class);
            criteria.add(Restrictions.eq("nfeCabecalho", nfeCabecalho));
            List<NfeDetalheVO> listaNfeDetalhe = criteria.list();
            for (int i = 0; i < listaNfeDetalhe.size(); i++) {
                ControleEstoqueAction.atualizaEstoque(session, listaNfeDetalhe.get(i).getProduto().getId(), listaNfeDetalhe.get(i).getQuantidadeComercial());
            }

            //salva o xml
            String caminhoArquivo = context.getRealPath("/xmlnfe") + System.getProperty("file.separator") + nfeCabecalho.getChaveAcesso() + nfeCabecalho.getDigitoChaveAcesso() + "-nfeCanc.xml";
            OutputStream out = new FileOutputStream(new File(caminhoArquivo));
            out.write(xml.getBytes());
            out.close();

            session.getTransaction().commit();

            return new VOResponse(nfeCabecalho);
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception ex1) {
            }
        }
    }

    public Response enviaEmail(Object inputPar, ServletContext context) {
        Session session = null;
        Object[] pars = (Object[]) inputPar;
        NfeCabecalhoVO nfeCabecalho = (NfeCabecalhoVO) pars[1];
        NfeDestinatarioVO nfeDestinatario = (NfeDestinatarioVO) pars[2];

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            Criteria criteria = session.createCriteria(NfeConfiguracaoVO.class);
            NfeConfiguracaoVO configuracao = (NfeConfiguracaoVO) criteria.uniqueResult();

            if (configuracao == null) {
                return new ErrorResponse("Configuração NFe não definida");
            }
            if (configuracao.getEmailAssunto() == null
                    || configuracao.getEmailSenha() == null
                    || configuracao.getEmailServidorSmtp() == null
                    || configuracao.getEmailTexto() == null
                    || configuracao.getEmailUsuario() == null) {
                return new ErrorResponse("Configuração de envio de email não definida");
            }

            MultiPartEmail email = new MultiPartEmail();
            email.setHostName(configuracao.getEmailServidorSmtp());
            email.setFrom(configuracao.getEmpresa().getEmail());
            email.addTo(nfeDestinatario.getEmail());
            email.setSubject(configuracao.getEmailAssunto());
            email.setMsg(configuracao.getEmailTexto());

            email.setAuthentication(configuracao.getEmailUsuario(), configuracao.getEmailSenha());
            if (configuracao.getEmailPorta() != null) {
                email.setSmtpPort(configuracao.getEmailPorta());
            }

            EmailAttachment anexo = new EmailAttachment();
            anexo.setPath(context.getRealPath("/xmlnfe") + System.getProperty("file.separator") + nfeCabecalho.getChaveAcesso() + nfeCabecalho.getDigitoChaveAcesso() + "-nfeproc.xml");
            anexo.setDisposition(EmailAttachment.ATTACHMENT);
            anexo.setDescription("Nota Fiscal Eletronica");
            anexo.setName(nfeCabecalho.getChaveAcesso() + nfeCabecalho.getDigitoChaveAcesso() + "-nfeproc.xml");

            email.attach(anexo);

            email.send();

            return new VOResponse(nfeCabecalho);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception ex1) {
            }
        }
    }
}
