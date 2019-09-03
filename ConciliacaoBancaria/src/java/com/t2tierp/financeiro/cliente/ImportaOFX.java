package com.t2tierp.financeiro.cliente;

import com.t2tierp.financeiro.java.FinExtratoContaBancoVO;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import net.sf.ofx4j.domain.data.MessageSetType;
import net.sf.ofx4j.domain.data.ResponseEnvelope;
import net.sf.ofx4j.domain.data.ResponseMessageSet;
import net.sf.ofx4j.domain.data.banking.BankStatementResponseTransaction;
import net.sf.ofx4j.domain.data.banking.BankingResponseMessageSet;
import net.sf.ofx4j.domain.data.common.Transaction;
import net.sf.ofx4j.io.AggregateUnmarshaller;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Classe que realiza a importação de arquivo OFX.</p>
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
public class ImportaOFX {

    public List<FinExtratoContaBancoVO> importaArquivoOFX(File arquivo) {
        try {
            AggregateUnmarshaller a = new AggregateUnmarshaller(ResponseEnvelope.class);
            ResponseEnvelope re = (ResponseEnvelope) a.unmarshal(new FileInputStream(arquivo));

            //define o tipo de mensagem
            MessageSetType type = MessageSetType.banking;
            ResponseMessageSet message = re.getMessageSet(type);

            if (message != null) {
                //busca a lista de contas no arquivo
                FinExtratoContaBancoVO extrato;
                List<FinExtratoContaBancoVO> listaExtrato = new ArrayList<FinExtratoContaBancoVO>();
                List bank = ((BankingResponseMessageSet) message).getStatementResponses();
                for (int i = 0; i < bank.size(); i++) {
                    //objeto que contém os dados das contas
                    BankStatementResponseTransaction conta = (BankStatementResponseTransaction) bank.get(i);

                    //busca os dados das transações
                    List transacoes = conta.getMessage().getTransactionList().getTransactions();
                    for (int j = 0; j < transacoes.size(); j++) {
                        Transaction transaction = (Transaction) transacoes.get(j);

                        extrato = new FinExtratoContaBancoVO();
                        extrato.setDataMovimento(transaction.getDatePosted());
                        extrato.setDataBalancete(transaction.getDatePosted());
                        extrato.setDocumento(transaction.getCheckNumber());
                        extrato.setHistorico(transaction.getMemo());
                        extrato.setValor(transaction.getBigDecimalAmount());

                        listaExtrato.add(extrato);
                    }
                }
                return listaExtrato;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
