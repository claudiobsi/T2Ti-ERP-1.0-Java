/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Classe de controle do ECF.</p>
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
 * @author Albert Eije (T2Ti.COM)
 * @version 1.0
 */
package com.t2tierp.pafecf.infra;

import com.t2tierp.pafecf.controller.PreVendaController;
import com.t2tierp.pafecf.view.Caixa;
import com.t2tierp.pafecf.vo.PreVendaCabecalhoVO;
import com.t2tierp.pafecf.vo.TotalTipoPagamentoVO;
import com.t2tierp.pafecf.vo.VendaDetalheVO;
import jACBr.ACBrException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class Ecf {

    public static void suprimento(Double valor, String descricao) throws ACBrException {
        Caixa.aCBrECF.suprimento(valor, descricao);
    }

    public static void sangria(Double valor, String descricao) throws ACBrException {
        Caixa.aCBrECF.sangria(valor, descricao);
    }

    public static void cancelaCupom() throws ACBrException {
        Caixa.aCBrECF.cancelaCupom();
    }

    public static void reducaoZ() {
        try {
            PreVendaController preVendaControl = new PreVendaController();
            boolean reducaoZEmitida = false;
            Date dataMovimento = getDataMovimento();
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            //TODO : Devo cancelar as pre-vendas antes da redução Z do dia?

            List<PreVendaCabecalhoVO> listaPreVendas = preVendaControl.cancelaPreVendasPendentes();
            if (listaPreVendas != null) {
                if (Caixa.aCBrECF.getEstado() == Caixa.REQUER_Z) {
                    Caixa.aCBrECF.reducaoZ();
                    reducaoZEmitida = true;
                }
                Caixa caixa = Caixa.getCaixa();
                caixa.cancelaPreVendas(listaPreVendas);
                caixa.telaPadrao();
            }
            if (!reducaoZEmitida) {
                Caixa.aCBrECF.reducaoZ();
            }

            //TODO : Devemos gravar o 60M (sintegra) neste momento?
            //Paf.gravaR02R03();
            //Paf.grava60M60A();
            //Paf.geraArquivoEstoque();

            String comando = System.getProperty("user.dir") + "\\binario\\binario.exe "
                    + "DadosReduzaoZ "
                    + Caixa.configuracao.getIdEmpresa() + " "
                    + Caixa.movimento.getIdCaixa() + " "
                    + Caixa.movimento.getIdOperador() + " "
                    + Caixa.movimento.getIdImpressora() + " "
                    + Caixa.configuracao.getPortaECF() + " "
                    + Caixa.configuracao.getTimeOutECF() + " "
                    + Caixa.configuracao.getIntervaloECF() + " "
                    + Caixa.configuracao.getImpressoraVO().getModeloACBr() + " "
                    + formatoData.format(dataMovimento) + " "
                    + formatoData.format(dataMovimento) + " "
                    + formatoData.format(dataMovimento);
            try {
                Caixa.aCBrECF.desativar();
                Process p = Runtime.getRuntime().exec(comando);
                p.waitFor();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    Caixa.aCBrECF.ativar();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
            JOptionPane.showMessageDialog(null, t.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void leituraX() {
        try {
            Caixa.aCBrECF.leituraX();
        } catch (Throwable t) {
            JOptionPane.showMessageDialog(null, t.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void abreCupom(String CPFouCNPJ, String nome, String endereco) throws ACBrException {
        Caixa.aCBrECF.abreCupom(CPFouCNPJ, nome, endereco);
    }

    public static void abreCupom(String CPFouCNPJ) throws ACBrException {
        Caixa.aCBrECF.abreCupom(CPFouCNPJ, "", "");
    }

    public static void vendeItem(VendaDetalheVO vendaDetalhe) throws ACBrException {
        Caixa.aCBrECF.vendeItem(vendaDetalhe.getGTIN(), vendaDetalhe.getDescricaoPDV(), vendaDetalhe.getECFICMS(), vendaDetalhe.getQuantidade(), vendaDetalhe.getValorUnitario(), 0.0, vendaDetalhe.getUnidadeProduto(), "", "");
    }

    public static void efetuaFormaPagamento(TotalTipoPagamentoVO totalTipoPagamento) {
        try {
            Caixa.aCBrECF.efetuaPagamento(totalTipoPagamento.getTipoPagamentoVO().getCodigo(), totalTipoPagamento.getValor(), "", false);
        } catch (Throwable t) {
            JOptionPane.showMessageDialog(null, t.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void subTotalizaCupom(Double AscDesc) {
        try {
            Caixa.aCBrECF.subtotalizaCupom(AscDesc, "");
        } catch (Throwable t) {
            JOptionPane.showMessageDialog(null, t.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void fechaCupom(String observacao) {
        try {
            Caixa.aCBrECF.fechaCupom(observacao);
        } catch (Throwable t) {
            JOptionPane.showMessageDialog(null, t.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void cancelaItem(Integer item) {
        try {
            Caixa.aCBrECF.cancelaItemVendido(item);
        } catch (Throwable t) {
            JOptionPane.showMessageDialog(null, t.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    //método implementado por Douglas Morato
    public static boolean impressoraAtiva() {
        boolean result = true;
        try {
            Caixa.aCBrECF.getEstado();
        } catch (Exception t) {
            result = false;
        }
        return result;
    }

    public static Date getDataHoraEcf() {
        try {
            Calendar dataEcf = Calendar.getInstance();
            dataEcf.setTime(Caixa.aCBrECF.getDataHora());
            dataEcf.add(Calendar.YEAR, -1600);

            return dataEcf.getTime();
        } catch (ACBrException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Date getDataMovimento() {
        try {
            Calendar dataMovimento = Calendar.getInstance();
            dataMovimento.setTime(Caixa.aCBrECF.getDataMovimento());
            dataMovimento.add(Calendar.YEAR, -1600);

            return dataMovimento.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
