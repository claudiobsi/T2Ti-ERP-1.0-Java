package com.t2tierp.ged.cliente;

import com.t2tierp.cadastros.java.EmpresaVO;
import com.t2tierp.cadastros.java.UsuarioVO;
import com.t2tierp.ged.java.ArquivoVO;
import com.t2tierp.ged.java.GedDocumentoVO;
import com.t2tierp.padrao.cliente.Container;
import com.t2tierp.padrao.cliente.SelecionaCertificado;
import com.t2tierp.padrao.cliente.Util;
import com.t2tierp.padrao.java.Constantes;
import java.io.File;
import java.math.BigDecimal;
import java.util.Map;
import javax.swing.JOptionPane;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.client.ClientUtils;
import org.openswing.swing.util.java.Consts;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Classe de controle da tela GedDocumentoDetalhe.</p>
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
public class GedDocumentoDetalheController extends FormController {

    private GedDocumentoDetalhe gedDocumentoDetalhe = null;
    private String pk = null;
    private GedDocumentoGrid gedDocumentoGrid = null;
    private String acaoServidor;

    public GedDocumentoDetalheController(GedDocumentoGrid gedDocumentoGrid, String pk) {
        this.gedDocumentoGrid = gedDocumentoGrid;
        this.pk = pk;
        this.acaoServidor = "gedDocumentoDetalheAction";
        gedDocumentoDetalhe = new GedDocumentoDetalhe(this);
        gedDocumentoDetalhe.setParentFrame(this.gedDocumentoGrid);
        this.gedDocumentoGrid.pushFrame(gedDocumentoDetalhe);
        MDIFrame.add(gedDocumentoDetalhe);

        if (pk != null) {
            gedDocumentoDetalhe.getForm1().setMode(Consts.READONLY);
            gedDocumentoDetalhe.getForm1().reload();
        } else {
            gedDocumentoDetalhe.getForm1().setMode(Consts.INSERT);
        }
    }

    @Override
    public Response loadData(Class valueObjectClass) {
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.LOAD, pk});
    }

    @Override
    public void loadDataCompleted(boolean error) {
        GedDocumentoVO documento = (GedDocumentoVO) gedDocumentoDetalhe.getForm1().getVOModel().getValueObject();
        gedDocumentoDetalhe.atualizaDocumento(documento.getArquivo());
    }

    @Override
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        EmpresaVO empresa = (EmpresaVO) Container.getContainer().get("empresa");
        UsuarioVO usuario = (UsuarioVO) Container.getContainer().get("usuario");

        ArquivoVO arquivo = getArquivo();

        if (arquivo.getFile() == null) {
            return new ErrorResponse("Selecione um arquivo ou obtenha uma imagem do scanner!");
        }

        GedDocumentoVO documento = (GedDocumentoVO) newPersistentObject;
        documento.setEmpresa(empresa);
        documento.setArquivo(arquivo);

        if (arquivo.getTamanho() > (documento.getGedTipoDocumento().getTamanhoMaximo().multiply(BigDecimal.valueOf(1000000)).intValue())) {
            return new ErrorResponse("Arquivo muito grande. Tamanho máximo permitido: " + documento.getGedTipoDocumento().getTamanhoMaximo() + " MB");
        }

        if (documento.getAssinado().equals("S")) {
            documento.getArquivo().setAssinatura(getAssinaturaDocumento(documento.getArquivo()));
            if (documento.getArquivo().getAssinatura() == null) {
                return new ErrorResponse("Assinatura do documento inválida!");
            }
        }

        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.INSERT, newPersistentObject, usuario});
    }

    @Override
    public void afterInsertData() {
        gedDocumentoGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(gedDocumentoDetalhe, "Dados salvos com sucesso!", "Informacao do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        UsuarioVO usuario = (UsuarioVO) Container.getContainer().get("usuario");
        ArquivoVO arquivo = getArquivo();

        if (arquivo.getFile() == null) {
            return new ErrorResponse("Selecione um arquivo ou obtenha uma imagem do scanner!");
        }

        GedDocumentoVO documento = (GedDocumentoVO) persistentObject;
        GedDocumentoVO documentoOld = (GedDocumentoVO) oldPersistentObject;
        documento.setArquivo(arquivo);

        if (documentoOld.getPodeAlterar().equals("N")) {
            return new ErrorResponse("Este documento não pode ser alterado");
        }

        if (arquivo.getTamanho() > (documento.getGedTipoDocumento().getTamanhoMaximo().multiply(BigDecimal.valueOf(1000000)).intValue())) {
            return new ErrorResponse("Arquivo muito grande. Tamanho máximo permitido: " + documento.getGedTipoDocumento().getTamanhoMaximo() + " MB");
        }

        if (documento.getAssinado().equals("S")) {
            documento.getArquivo().setAssinatura(getAssinaturaDocumento(documento.getArquivo()));
            if (documento.getArquivo().getAssinatura() == null) {
                return new ErrorResponse("Assinatura do documento inválida!");
            }
        }

        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.UPDATE, oldPersistentObject, persistentObject, usuario});
    }

    @Override
    public void afterEditData() {
        gedDocumentoGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(gedDocumentoDetalhe, "Dados alterados com sucesso!", "Informacao do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public Response deleteRecord(ValueObject persistentObject) throws Exception {
        GedDocumentoVO gedDocumento = (GedDocumentoVO) persistentObject;
        UsuarioVO usuario = (UsuarioVO) Container.getContainer().get("usuario");

        if (gedDocumento.getPodeExcluir().equals("N")) {
            return new ErrorResponse("Este documento não pode ser excluído");
        }

        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.DELETE, persistentObject, usuario});
    }

    @Override
    public void afterDeleteData() {
        gedDocumentoGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(gedDocumentoDetalhe, "Documento excluido com sucesso!", "Informacao do Sistema", JOptionPane.INFORMATION_MESSAGE);
        gedDocumentoDetalhe.dispose();
    }

    private ArquivoVO getArquivo() {
        //seta os dados do arquivo
        ArquivoVO arquivo = new ArquivoVO();
        if (gedDocumentoDetalhe.getDocumentoSelecionado() != null) {
            arquivo.setFile(gedDocumentoDetalhe.getDocumentoSelecionado());
            arquivo.setExtensao(gedDocumentoDetalhe.getExtensaoArquivo());
        } else {
            arquivo.setFile(gedDocumentoDetalhe.getImagem());
            arquivo.setExtensao(".jpg");
        }

        if (arquivo.getFile() != null) {
            arquivo.setHash(gedDocumentoDetalhe.getHashDocumento());
            arquivo.setTamanho(arquivo.getFile().length);
        }
        return arquivo;
    }

    private byte[] getAssinaturaDocumento(ArquivoVO arquivo) {
        try {
            SelecionaCertificado selecionaCertificado = new SelecionaCertificado(null, true);
            selecionaCertificado.setVisible(true);
            Map map = selecionaCertificado.getDadosCertificado();
            String caminhoCertificado = (String) map.get("caminhoCertificado");
            char[] senha = (char[]) map.get("senha");

            return Util.geraAssinaturaArquivo(arquivo.getFile(), new File(caminhoCertificado), senha);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
