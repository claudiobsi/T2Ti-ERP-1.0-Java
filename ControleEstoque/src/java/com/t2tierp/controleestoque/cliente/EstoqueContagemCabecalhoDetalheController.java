package com.t2tierp.controleestoque.cliente;

import com.t2tierp.cadastros.java.EmpresaVO;
import com.t2tierp.cadastros.java.ProdutoVO;
import com.t2tierp.controleestoque.java.EstoqueContagemCabecalhoVO;
import com.t2tierp.controleestoque.java.EstoqueContagemDetalheVO;
import com.t2tierp.padrao.cliente.Container;
import com.t2tierp.padrao.java.Constantes;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.swing.JOptionPane;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.client.ClientUtils;
import org.openswing.swing.util.java.Consts;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Classe de controle da tela EstoqueContagemCabecalhoDetalhe.</p>
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
public class EstoqueContagemCabecalhoDetalheController extends FormController {

    private EstoqueContagemCabecalhoDetalhe estoqueContagemCabecalhoDetalhe = null;
    private String pk = null;
    private EstoqueContagemCabecalhoGrid estoqueContagemCabecalhoGrid = null;
    private String acaoServidor;

    public EstoqueContagemCabecalhoDetalheController(EstoqueContagemCabecalhoGrid estoqueContagemCabecalhoGrid, String pk) {
        this.estoqueContagemCabecalhoGrid = estoqueContagemCabecalhoGrid;
        this.pk = pk;
        this.acaoServidor = "estoqueContagemCabecalhoDetalheAction";
        estoqueContagemCabecalhoDetalhe = new EstoqueContagemCabecalhoDetalhe(this);
        estoqueContagemCabecalhoDetalhe.setParentFrame(this.estoqueContagemCabecalhoGrid);
        this.estoqueContagemCabecalhoGrid.pushFrame(estoqueContagemCabecalhoDetalhe);
        MDIFrame.add(estoqueContagemCabecalhoDetalhe);

        if (pk != null) {
            estoqueContagemCabecalhoDetalhe.getForm1().setMode(Consts.READONLY);
            estoqueContagemCabecalhoDetalhe.getForm1().reload();
        } else {
            estoqueContagemCabecalhoDetalhe.getForm1().setMode(Consts.INSERT);
            estoqueContagemCabecalhoDetalhe.getGridControl1().reloadData();
        }
    }

    @Override
    public Response loadData(Class valueObjectClass) {
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.LOAD, pk});
    }

    @Override
    public void loadDataCompleted(boolean error) {
        estoqueContagemCabecalhoDetalhe.getItensController().setPk(pk);
        estoqueContagemCabecalhoDetalhe.getGridControl1().reloadData();
    }

    @Override
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        List<EstoqueContagemDetalheVO> itensContagem = estoqueContagemCabecalhoDetalhe.getGridControl1().getVOListTableModel().getDataVector();

        if (itensContagem.isEmpty()) {
            return new ErrorResponse("Nenhum produto foi selecionado para contagem");
        }

        EmpresaVO empresa = (EmpresaVO) Container.getContainer().get("empresa");
        ((EstoqueContagemCabecalhoVO) newPersistentObject).setEmpresa(empresa);

        if (estoqueContagemCabecalhoDetalhe.atualizarEstoque()) {
            ((EstoqueContagemCabecalhoVO) newPersistentObject).setEstoqueAtualizado("S");
        } else {
            ((EstoqueContagemCabecalhoVO) newPersistentObject).setEstoqueAtualizado("N");
        }

        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.INSERT, newPersistentObject, itensContagem});
    }

    @Override
    public void afterInsertData() {
        estoqueContagemCabecalhoGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(estoqueContagemCabecalhoDetalhe, "Dados salvos com sucesso!", "Informacao do Sistema", JOptionPane.INFORMATION_MESSAGE);
        estoqueContagemCabecalhoDetalhe.dispose();
    }

    @Override
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        if (((EstoqueContagemCabecalhoVO) persistentObject).getEstoqueAtualizado().equals("S")) {
            return new ErrorResponse("Estoque já atualizado nesta contagem. Alteração não permitida");
        }

        List<EstoqueContagemDetalheVO> itensContagem = estoqueContagemCabecalhoDetalhe.getGridControl1().getVOListTableModel().getDataVector();

        if (itensContagem.isEmpty()) {
            return new ErrorResponse("Nenhum produto foi selecionado para contagem");
        }

        if (estoqueContagemCabecalhoDetalhe.atualizarEstoque()) {
            ((EstoqueContagemCabecalhoVO) persistentObject).setEstoqueAtualizado("S");
        }

        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.UPDATE, oldPersistentObject, persistentObject, itensContagem});
    }

    @Override
    public void afterEditData() {
        estoqueContagemCabecalhoGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(estoqueContagemCabecalhoDetalhe, "Dados alterados com sucesso!", "Informacao do Sistema", JOptionPane.INFORMATION_MESSAGE);
        estoqueContagemCabecalhoDetalhe.dispose();
    }

    public void buscaGrupoProdutos() {
        EstoqueContagemCabecalhoVO contagem = (EstoqueContagemCabecalhoVO) estoqueContagemCabecalhoDetalhe.getForm1().getVOModel().getValueObject();
        if (contagem.getProdutoSubGrupo().getId() != null) {
            Response res = ClientUtils.getData(acaoServidor, new Object[]{99, contagem.getProdutoSubGrupo()});
            if (res.isError()) {
                JOptionPane.showMessageDialog(estoqueContagemCabecalhoDetalhe, "Ocorreu um erro ao buscar os produtos do sub grupo.\n" + res.getErrorMessage(), "Errro do Sistema", JOptionPane.ERROR_MESSAGE);
                return;
            }
            List<ProdutoVO> produtos = ((VOListResponse) res).getRows();
            EstoqueContagemDetalheVO contagemDetalhe;
            for (int i = 0; i < produtos.size(); i++) {
                contagemDetalhe = new EstoqueContagemDetalheVO();
                contagemDetalhe.setProduto(produtos.get(i));
                contagemDetalhe.setQuantidadeSistema(produtos.get(i).getQuantidadeEstoque());

                estoqueContagemCabecalhoDetalhe.getGridControl1().getVOListTableModel().addObject(contagemDetalhe);
            }
            if (produtos.isEmpty()) {
                JOptionPane.showMessageDialog(estoqueContagemCabecalhoDetalhe, "Nenhum produto encontrado para o grupo selecinado.", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(estoqueContagemCabecalhoDetalhe, "Selecione um grupo.", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void efetuarCalculos() {
        List<EstoqueContagemDetalheVO> itensContagem = estoqueContagemCabecalhoDetalhe.getGridControl1().getVOListTableModel().getDataVector();
        if (itensContagem.isEmpty()) {
            JOptionPane.showMessageDialog(estoqueContagemCabecalhoDetalhe, "Nenhum item para calcular.", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        EstoqueContagemDetalheVO item;
        for (int i = 0; i < itensContagem.size(); i++) {
            item = itensContagem.get(i);
            if (item.getQuantidadeContada() != null && item.getQuantidadeSistema() != null) {
                //acuracidade dos registros = (registros sistema / registros contados) X 100 }
                if (item.getQuantidadeContada().compareTo(BigDecimal.ZERO) != 0) {
                    item.setAcuracidade(item.getQuantidadeSistema().divide(item.getQuantidadeContada(), RoundingMode.HALF_DOWN).multiply(BigDecimal.valueOf(100)));
                } else {
                    item.setAcuracidade(BigDecimal.ZERO);
                }
                //divergencia dos registros = ((registros contados - registros sistema) / registros sistema) X 100 }
                item.setDivergencia(item.getQuantidadeContada().subtract(item.getQuantidadeSistema()).divide(item.getQuantidadeSistema(), RoundingMode.HALF_DOWN).multiply(BigDecimal.valueOf(100)));
            }
            estoqueContagemCabecalhoDetalhe.getGridControl1().getVOListTableModel().updateObjectAt(i);
        }
    }
}
