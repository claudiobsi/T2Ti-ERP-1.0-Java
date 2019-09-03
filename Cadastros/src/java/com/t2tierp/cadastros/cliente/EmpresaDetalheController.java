package com.t2tierp.cadastros.cliente;

import com.t2tierp.cadastros.java.ContatoVO;
import com.t2tierp.cadastros.java.EmpresaVO;
import com.t2tierp.cadastros.java.EnderecoVO;
import com.t2tierp.padrao.java.Biblioteca;
import com.t2tierp.padrao.java.Constantes;
import java.util.List;
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
 * <p>Description: Classe de controle da tela EmpresaDetalhe.</p>
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
public class EmpresaDetalheController extends FormController {

    private EmpresaDetalhe empresaDetalhe = null;
    private String pk = null;
    private EmpresaGrid empresaGrid = null;
    private String acaoServidor;

    public EmpresaDetalheController(EmpresaGrid empresaGrid, String pk) {
        this.empresaGrid = empresaGrid;
        this.pk = pk;
        this.acaoServidor = "empresaDetalheAction";
        empresaDetalhe = new EmpresaDetalhe(this);
        empresaDetalhe.setParentFrame(this.empresaGrid);
        this.empresaGrid.pushFrame(empresaDetalhe);
        MDIFrame.add(empresaDetalhe);

        if (pk != null) {
            empresaDetalhe.getForm1().setMode(Consts.READONLY);
            empresaDetalhe.getForm1().reload();
        } else {
            empresaDetalhe.getForm1().setMode(Consts.INSERT);
            empresaDetalhe.getGridControlContato().reloadData();
            empresaDetalhe.getGridControlEndereco().reloadData();
        }
    }

    @Override
    public Response loadData(Class valueObjectClass) {
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.LOAD, pk});
    }

    @Override
    public void loadDataCompleted(boolean error) {
        empresaDetalhe.getContatoController().setPk(pk);
        empresaDetalhe.getGridControlContato().reloadData();

        empresaDetalhe.getEnderecoController().setPk(pk);
        empresaDetalhe.getGridControlEndereco().reloadData();
    }

    @Override
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        EmpresaVO empresa = (EmpresaVO) newPersistentObject;
        if (!Biblioteca.cnpjValido(empresa.getCnpj())) {
            return new ErrorResponse("CNPJ inválido!");
        }

        try {
            if (!verificaEnderecoPrincipal()) {
                return new ErrorResponse("É necessário informar o endereço principal da empresa");
            }
        } catch (Exception e) {
            return new ErrorResponse(e.getMessage());
        }

        List<ContatoVO> contatos = empresaDetalhe.getGridControlContato().getVOListTableModel().getDataVector();
        List<EnderecoVO> enderecos = empresaDetalhe.getGridControlEndereco().getVOListTableModel().getDataVector();

        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.INSERT, newPersistentObject, contatos, enderecos});
    }

    @Override
    public void afterInsertData() {
        empresaGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(empresaDetalhe, "Dados salvos com sucesso!", "Informacao do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        EmpresaVO empresa = (EmpresaVO) persistentObject;
        if (!Biblioteca.cnpjValido(empresa.getCnpj())) {
            return new ErrorResponse("CNPJ inválido!");
        }

        try {
            if (!verificaEnderecoPrincipal()) {
                return new ErrorResponse("É necessário informar o endereço principal da empresa");
            }
        } catch (Exception e) {
            return new ErrorResponse(e.getMessage());
        }

        List<ContatoVO> contatos = empresaDetalhe.getGridControlContato().getVOListTableModel().getDataVector();
        List<EnderecoVO> enderecos = empresaDetalhe.getGridControlEndereco().getVOListTableModel().getDataVector();

        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.UPDATE, oldPersistentObject, persistentObject, contatos, enderecos});
    }

    @Override
    public void afterEditData() {
        empresaGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(empresaDetalhe, "Dados alterados com sucesso!", "Informacao do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean verificaEnderecoPrincipal() throws Exception {
        boolean cadastrado = false;
        List<EnderecoVO> enderecos = empresaDetalhe.getGridControlEndereco().getVOListTableModel().getDataVector();
        for (int i = 0; i < enderecos.size(); i++) {
            if (enderecos.get(i).getPrincipal().equals("S")) {
                if (cadastrado) {
                    throw new Exception("Somente 1(um) endereço pode ser cadastrado como principal.");
                } else {
                    cadastrado = true;
                }
            }
        }
        return cadastrado;
    }
}
