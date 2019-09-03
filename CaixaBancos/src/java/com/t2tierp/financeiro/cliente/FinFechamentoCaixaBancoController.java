package com.t2tierp.financeiro.cliente;

import com.t2tierp.financeiro.java.FinFechamentoCaixaBancoVO;
import com.t2tierp.financeiro.java.ViewFinChequeNaoCompensadoID;
import com.t2tierp.financeiro.java.ViewFinMovimentoCaixaBancoID;
import com.t2tierp.padrao.java.Constantes;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.swing.JOptionPane;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.client.ClientUtils;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Classe de controle do form FinFechamentoCaixaBanco.</p>
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
public class FinFechamentoCaixaBancoController extends FormController {

    private FinMovimentoCaixaBancoDetalhe finMovimentoCaixaBancoDetalhe;
    private String acaoServidor;
    private Integer idContaCaixa;
    private Integer mes;
    private Integer ano;

    public FinFechamentoCaixaBancoController(FinMovimentoCaixaBancoDetalhe finMovimentoCaixaBancoDetalhe) {
        this.acaoServidor = "finFechamentoCaixaBancoAction";
        this.finMovimentoCaixaBancoDetalhe = finMovimentoCaixaBancoDetalhe;
    }

    @Override
    public Response loadData(Class valueObjectClass) {
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.LOAD, idContaCaixa, mes, ano});
    }

    @Override
    public void loadDataCompleted(boolean error) {
        calculaTotais();
    }

    @Override
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.INSERT, newPersistentObject, mes, ano});
    }

    @Override
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.UPDATE, oldPersistentObject, persistentObject});
    }

    private void calculaTotais() {
        FinFechamentoCaixaBancoVO fechamento = (FinFechamentoCaixaBancoVO) finMovimentoCaixaBancoDetalhe.getFormFechamento().getVOModel().getValueObject();

        List<ViewFinMovimentoCaixaBancoID> movimento = finMovimentoCaixaBancoDetalhe.getGrid1().getVOListTableModel().getDataVector();
        BigDecimal recebimentos = new BigDecimal(BigInteger.ZERO);
        BigDecimal pagamentos = new BigDecimal(BigInteger.ZERO);
        BigDecimal chequesNaoCompensados = new BigDecimal(BigInteger.ZERO);
        for (int i = 0; i < movimento.size(); i++) {
            if (movimento.get(i).getViewFinMovimentoCaixaBanco().getOperacao().equals("E")) {
                recebimentos = recebimentos.add(movimento.get(i).getViewFinMovimentoCaixaBanco().getValor());
            }
            if (movimento.get(i).getViewFinMovimentoCaixaBanco().getOperacao().equals("S")) {
                pagamentos = pagamentos.add(movimento.get(i).getViewFinMovimentoCaixaBanco().getValor());
            }
        }
        fechamento.setPagamentos(pagamentos);
        fechamento.setRecebimentos(recebimentos);
        fechamento.setSaldoConta(fechamento.getSaldoAnterior().subtract(pagamentos).add(recebimentos));

        //busca os cheques não compensados
        Response res = ClientUtils.getData(acaoServidor, new Object[]{5, idContaCaixa});
        if (res.isError()) {
            JOptionPane.showMessageDialog(finMovimentoCaixaBancoDetalhe, "Ocorreu um erro ao buscar os cheques não compensados.\n" + res.getErrorMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
            return;
        }
        List<ViewFinChequeNaoCompensadoID> cheques = ((VOListResponse) res).getRows();
        for (int i = 0; i < cheques.size(); i++) {
            if (cheques.get(i).getViewFinChequeNaoCompensado().getValor() != null) {
                chequesNaoCompensados = chequesNaoCompensados.add(cheques.get(i).getViewFinChequeNaoCompensado().getValor());
            }
        }

        fechamento.setChequeNaoCompensado(chequesNaoCompensados);
        fechamento.setSaldoDisponivel(fechamento.getSaldoConta().subtract(fechamento.getChequeNaoCompensado()));
        finMovimentoCaixaBancoDetalhe.getFormFechamento().pull();
    }

    public void setIdContaCaixa(Integer idContaCaixa) {
        this.idContaCaixa = idContaCaixa;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
