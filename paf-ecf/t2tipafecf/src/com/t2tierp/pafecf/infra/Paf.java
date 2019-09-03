/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Classe de controle do PAF.</p>
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

import com.t2tierp.pafecf.controller.ProdutoController;
import com.t2tierp.pafecf.controller.RegistroRController;
import com.t2tierp.pafecf.controller.SintegraController;
import com.t2tierp.pafecf.controller.TotalTipoPagamentoController;
import com.t2tierp.pafecf.controller.VendaController;
import com.t2tierp.pafecf.view.Caixa;
import com.t2tierp.pafecf.vo.MeiosPagamentoVO;
import com.t2tierp.pafecf.vo.R01VO;
import com.t2tierp.pafecf.vo.R02VO;
import com.t2tierp.pafecf.vo.R03VO;
import com.t2tierp.pafecf.vo.R06VO;
import com.t2tierp.pafecf.vo.Sintegra60AVO;
import com.t2tierp.pafecf.vo.Sintegra60MVO;
import com.t2tierp.pafecf.vo.VendaCabecalhoVO;
import com.t2tierp.pafecf.vo.VendaDetalheVO;
import jACBr.ACBrException;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Paf {

    public static void identificacaoPafEcf() {
        //TODO : Relatorio dentro das especificações?
        try {
            RegistroRController rControl = new RegistroRController();
            R01VO r01 = rControl.tabelaR01();
            String md5;

            Caixa.aCBrECF.abreRelatorioGerencial(Caixa.configuracao.getGerencialIdentificacaoPaf());
            Caixa.aCBrECF.linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("IDENTIFICACAO DO PAF-ECF", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("NU. LAUDO.........: " + r01.getNumeroLaudoPaf(), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("C.N.P.J. .........: " + r01.getCnpjSh(), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("RAZAO SOCIAL......: " + r01.getDenominacaoSh(), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("ENDERECO..........: " + r01.getEnderecoSh(), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("NUMERO............: " + r01.getNumeroSh(), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("COMPLEMENTO.......: " + r01.getComplementoSh(), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("BAIRRO............: " + r01.getBairroSh(), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("CIDADE............: " + r01.getCidadeSh(), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("CEP...............: " + r01.getCepSh(), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("UF................: " + r01.getUfSh(), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("TELEFONE..........: " + r01.getTelefoneSh(), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("CONTATO...........: " + r01.getContatoSh(), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("************IDENTIFICACAO DO PAF-ECF************", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("NOME COMERCIAL....: " + r01.getNomePafEcf(), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("VERSAO DO PAF-ECF.: " + r01.getVersaoPafEcf(), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("**********PRINCIPAL ARQUIVO EXECUTAVEL**********", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("NOME..........: " + r01.getPrincipalExecutavel(), 0);
            md5 = Biblioteca.MD5File("t2tipafecf.jar");
            Caixa.aCBrECF.linhaRelatorioGerencial("MD5...........: " + md5, 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("****************DEMAIS ARQUIVOS*****************", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("NOME..........: BINARIO.EXE", 0);
            md5 = Biblioteca.MD5File("binario/binario.exe");
            Caixa.aCBrECF.linhaRelatorioGerencial("MD5...........: " + md5, 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("NOME..........: BALCAO.JAR", 0);
            md5 = Biblioteca.MD5File("balcao/balcao.jar");
            Caixa.aCBrECF.linhaRelatorioGerencial("MD5...........: " + md5, 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("**************NOME DO ARQUIVO TEXTO*************", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("NOME..........: ArquivoMD5.txt", 0);
            md5 = Biblioteca.MD5File("ArquivoMD5.txt");
            Caixa.aCBrECF.linhaRelatorioGerencial("MD5...........: " + md5, 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("VERSAO ER PAF-ECF.: " + r01.getVersaoEr(), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("**********RELACAO DOS ECF AUTORIZADOS***********", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("SERIE............: " + r01.getSerieEcf(), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);
            Caixa.aCBrECF.fechaRelatorio();

            gravaR06("RG");
        } catch (Throwable t) {
            JOptionPane.showMessageDialog(null, t.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    //TODO : Está correto esse procedimento para gerar verificar se o ECF é autorizado?
    public static boolean ECFAutorizado() {
        try {
            Properties arquivoAuxiliar = new Properties();
            arquivoAuxiliar.load(new FileInputStream(new File(System.getProperty("user.dir")
                    + System.getProperty("file.separator")
                    + "arquivoauxiliar.properties")));
            String MD5Serie = Biblioteca.MD5String(Caixa.aCBrECF.getNumSerie());
            String serieEcf = arquivoAuxiliar.getProperty("ecf.serie");
            if (MD5Serie.equals(serieEcf)) {
                return true;
            }
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        } catch (UnsupportedEncodingException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        } catch (ACBrException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o arquivo de configuração!", "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    //TODO : Está correto esse procedimento para gerar o MD5?
    public static String geraMD5() {
        try {
            //TODO : quais serão os nossos arquivos executáveis?
            //vrifica ser a aplicaçao esta sendo executada pelo jar
            File arquivo = new File(System.getProperty("user.dir") + "\\t2tipafecf.jar");
            if (arquivo.exists()) {
                String comando =
                        System.getProperty("user.dir") + "\\binario\\binario.exe "
                        + "ArquivoMD5 "
                        + Caixa.configuracao.getIdEmpresa() + " "
                        + "0 "
                        + "0 "
                        + Caixa.configuracao.getImpressoraVO().getId() + " "
                        + Caixa.configuracao.getPortaECF() + " "
                        + Caixa.configuracao.getTimeOutECF() + " "
                        + Caixa.configuracao.getIntervaloECF() + " "
                        + Caixa.configuracao.getImpressoraVO().getModeloACBr() + " "
                        + "\"" + System.getProperty("user.dir") + "\\t2tipafecf.jar\" "
                        + "\"" + System.getProperty("user.dir") + "\\balcao\\Balcao.jar\" "
                        + "\"" + System.getProperty("user.dir") + "\\binario\\binario.exe\" ";
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

                String md5 = Biblioteca.MD5File(System.getProperty("user.dir") + "\\ArquivoMD5.txt");

                Properties arquivoAuxiliar = new Properties();
                arquivoAuxiliar.load(new FileInputStream(new File(System.getProperty("user.dir")
                        + System.getProperty("file.separator")
                        + "arquivoauxiliar.properties")));

                arquivoAuxiliar.setProperty("md5.arquivos", md5);
                arquivoAuxiliar.setProperty("shouse.md5principalexe", Biblioteca.MD5File(System.getProperty("user.dir") + "\\t2tipafecf.jar"));
                
                RegistroRController rControl = new RegistroRController();
                R01VO r01 = rControl.tabelaR01();
                
                arquivoAuxiliar.setProperty("shouse.cnpj", Biblioteca.MD5String(r01.getCnpjSh()));
                arquivoAuxiliar.setProperty("estabelecimento.cnpj", Biblioteca.MD5String(r01.getCnpjEmpresa()));
                arquivoAuxiliar.setProperty("shouse.nome", Biblioteca.MD5String(r01.getDenominacaoSh()));

                FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir")
                        + System.getProperty("file.separator")
                        + "arquivoauxiliar.properties"));

                arquivoAuxiliar.store(out, "Arquivo auxiliar do PAF");

                out.close();

                JOptionPane.showMessageDialog(Caixa.getCaixa(), "Arquivo armazenado em: " + System.getProperty("user.dir") + "\\ArquivoMD5.txt", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);

                return md5;
            }
            //somente para uso em desenvolvimento
            return Biblioteca.MD5String("T2TiPAFECF");
        } catch (Exception e) {
            return null;
        }
    }

    public static void meiosPagamento(String dataIni, String dataFim) {
        TotalTipoPagamentoController totalTipoPagamentoControl = new TotalTipoPagamentoController();
        List<MeiosPagamentoVO> listaMeiosPagamento = new ArrayList<MeiosPagamentoVO>();
        listaMeiosPagamento = totalTipoPagamentoControl.meiosPagamento(dataIni, dataFim, Caixa.configuracao.getImpressoraVO().getId());
        String meio, tipoDoc, valor, data = "";

        //TODO : Esse relatório está de acordo com as especificações do PAF-ECF?
        try {
            Caixa.aCBrECF.abreRelatorioGerencial(0);
            Caixa.aCBrECF.linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("MEIOS DE PAGAMENTO", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("PERIODO: " + dataIni + " A " + dataFim, 0);
            Caixa.aCBrECF.linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("MEIO DE PGTO.  TIPO DOC. VLR.ACUMUL.  DT.ACUMUL.", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);
            for (int i = 0; i < listaMeiosPagamento.size(); i++) {
                meio = listaMeiosPagamento.get(i).getDescricao();
                meio = meio + Biblioteca.repete(" ", 15 - meio.length());
                tipoDoc = "FISCAL ";
                NumberFormat formatter = new DecimalFormat("0.00");
                valor = formatter.format(listaMeiosPagamento.get(i).getTotal());
                valor = Biblioteca.repete(" ", 13 - valor.length()) + valor;
                data = " " + listaMeiosPagamento.get(i).getDataHora().toString().substring(0, 10);
                Caixa.aCBrECF.linhaRelatorioGerencial(meio + tipoDoc + valor + data, 0);
            }
            Caixa.aCBrECF.linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);
            Caixa.aCBrECF.fechaRelatorio();

            gravaR06("RG");
        } catch (Throwable t) {
            JOptionPane.showMessageDialog(null, t.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void geraMovimentoECF() {
        String comando =
                System.getProperty("user.dir") + "\\binario\\binario.exe "
                + "geraMovimentoECF "
                + Caixa.configuracao.getIdEmpresa() + " "
                + Caixa.movimento.getIdCaixa() + " "
                + Caixa.movimento.getIdOperador() + " "
                + Caixa.movimento.getIdImpressora() + " "
                + Caixa.configuracao.getPortaECF() + " "
                + Caixa.configuracao.getTimeOutECF() + " "
                + Caixa.configuracao.getIntervaloECF() + " "
                + Caixa.configuracao.getImpressoraVO().getModeloACBr();
        try {
            Caixa.aCBrECF.desativar();
            //TODO : atualizar binário
            /*
            Process p = Runtime.getRuntime().exec(comando);
            p.waitFor();
             */
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                Caixa.aCBrECF.ativar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void geraTabelaProdutos() {
        String comando =
                System.getProperty("user.dir") + "\\binario\\binario.exe "
                + "geraTabelaProdutos "
                + Caixa.configuracao.getIdEmpresa() + " "
                + Caixa.movimento.getIdCaixa() + " "
                + Caixa.movimento.getIdOperador() + " "
                + Caixa.movimento.getIdImpressora() + " "
                + Caixa.configuracao.getPortaECF() + " "
                + Caixa.configuracao.getTimeOutECF() + " "
                + Caixa.configuracao.getIntervaloECF() + " "
                + Caixa.configuracao.getImpressoraVO().getModeloACBr();
        try {
            Caixa.aCBrECF.desativar();
            //TODO : atualizar binário
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
    }

    public static void geraArquivoEstoque() {
        String comando =
                System.getProperty("user.dir") + "\\binario\\binario.exe "
                + "geraArquivoEstoque "
                + Caixa.configuracao.getIdEmpresa() + " "
                + Caixa.movimento.getIdCaixa() + " "
                + Caixa.movimento.getIdOperador() + " "
                + Caixa.movimento.getIdImpressora() + " "
                + Caixa.configuracao.getPortaECF() + " "
                + Caixa.configuracao.getTimeOutECF() + " "
                + Caixa.configuracao.getIntervaloECF() + " "
                + Caixa.configuracao.getImpressoraVO().getModeloACBr();
        try {
            Caixa.aCBrECF.desativar();
            //TODO : Atualizar binário
            /*
            Process p = Runtime.getRuntime().exec(comando);
            p.waitFor();
             */
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                Caixa.aCBrECF.ativar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void gravaR02R03() {
        try {
            List<R03VO> listaR03 = new ArrayList<R03VO>();
            RegistroRController registroRControl = new RegistroRController();

            //Dados para o registro R02
            R02VO R02 = new R02VO();
            R02.setIdCaixa(Caixa.movimento.getIdCaixa());
            R02.setIdOperador(Caixa.movimento.getIdOperador());
            R02.setIdImpressora(Caixa.movimento.getIdImpressora());
            R02.setCRZ(Integer.valueOf(Caixa.aCBrECF.getNumCRZ()));
            R02.setCOO(Integer.valueOf(Caixa.aCBrECF.getNumCOO()));
            R02.setCRO(Integer.valueOf(Caixa.aCBrECF.getNumCRO()));

            java.util.Date data = Ecf.getDataMovimento();
            java.sql.Date dataSQL = new java.sql.Date(data.getTime());
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

            R02.setDataMovimento(dataSQL);
            R02.setDataEmissao(dataSQL);
            R02.setHoraEmissao(formatoHora.format(data));
            R02.setValorVendaBruta(Caixa.aCBrECF.getVendaBruta());
            R02.setValorGrandeTotal(Caixa.aCBrECF.getGrandeTotal());
            R02 = registroRControl.gravaR02(R02);

            //Dados para o registro R03
            //TODO : Qual o procedimento para gerar o R03?
            //TODO : O exemplo abaixo para geração do R03 está dentro da especificação?
            R03VO R03 = new R03VO();

            //Isento - ICMS
            R03 = new R03VO();
            R03.setIdR02(R02.getId());
            R03.setTotalizadorParcial("I1");
            R03.setValorAcumulado(1.0);
            listaR03.add(R03);

            //Não-incidência - ICMS
            R03 = new R03VO();
            R03.setIdR02(R02.getId());
            R03.setTotalizadorParcial("N1");
            R03.setValorAcumulado(1.0);
            listaR03.add(R03);

            //Substituição Tributária - ISSQN
            R03 = new R03VO();
            R03.setIdR02(R02.getId());
            R03.setTotalizadorParcial("FS1");
            R03.setValorAcumulado(1.0);
            listaR03.add(R03);

            //Isento - ISSQN
            R03 = new R03VO();
            R03.setIdR02(R02.getId());
            R03.setTotalizadorParcial("IS1");
            R03.setValorAcumulado(1.0);
            listaR03.add(R03);

            //Não-incidência - ISSQN
            R03 = new R03VO();
            R03.setIdR02(R02.getId());
            R03.setTotalizadorParcial("NS1");
            R03.setValorAcumulado(1.0);
            listaR03.add(R03);

            //Operações Não Fiscais
            R03 = new R03VO();
            R03.setIdR02(R02.getId());
            R03.setTotalizadorParcial("OPNF");
            R03.setValorAcumulado(1.0);
            listaR03.add(R03);

            //Desconto - ICMS
            R03 = new R03VO();
            R03.setIdR02(R02.getId());
            R03.setTotalizadorParcial("DT");
            R03.setValorAcumulado(1.0);
            listaR03.add(R03);

            //Desconto - ISSQN
            R03 = new R03VO();
            R03.setIdR02(R02.getId());
            R03.setTotalizadorParcial("DS");
            R03.setValorAcumulado(1.0);
            listaR03.add(R03);

            //Acréscimo - ICMS
            R03 = new R03VO();
            R03.setIdR02(R02.getId());
            R03.setTotalizadorParcial("AT");
            R03.setValorAcumulado(1.0);
            listaR03.add(R03);

            //Acréscimo - ISSQN
            R03 = new R03VO();
            R03.setIdR02(R02.getId());
            R03.setTotalizadorParcial("AS");
            R03.setValorAcumulado(1.0);
            listaR03.add(R03);

            //Cancelamento - ICMS
            R03 = new R03VO();
            R03.setIdR02(R02.getId());
            R03.setTotalizadorParcial("Can-T");
            R03.setValorAcumulado(1.0);
            listaR03.add(R03);

            //Cancelamento - ISSQN
            R03 = new R03VO();
            R03.setIdR02(R02.getId());
            R03.setTotalizadorParcial("Can-S");
            R03.setValorAcumulado(1.0);
            listaR03.add(R03);

            registroRControl.gravaR03(listaR03);
        } catch (Throwable t) {
            JOptionPane.showMessageDialog(null, t.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void grava60M60A() {
        try {
            //TODO : Está correto o procedimento para gravação do 60M?
            SintegraController sintegraControl = new SintegraController();
            Sintegra60MVO sintegra60M = new Sintegra60MVO();
            List<Sintegra60AVO> lista60A = new ArrayList<Sintegra60AVO>();

            java.util.Date data = Ecf.getDataMovimento();
            java.sql.Date dataSQL = new java.sql.Date(data.getTime());

            sintegra60M.setDataEmissao(dataSQL);
            sintegra60M.setNumeroSerieECF(Caixa.aCBrECF.getNumSerie());
            sintegra60M.setNumeroEquipamento(Integer.valueOf(Caixa.aCBrECF.getNumECF()));
            //TODO : O que informar no modelo do documento fiscal?
            sintegra60M.setModeloDocumentoFiscal("2D");
            sintegra60M.setCOOInicial(Integer.valueOf(Caixa.aCBrECF.getNumCOOInicial()));
            sintegra60M.setCOOFinal(Integer.valueOf(Caixa.aCBrECF.getNumCOO()));
            sintegra60M.setCRZ(Integer.valueOf(Caixa.aCBrECF.getNumCRZ()));
            sintegra60M.setCRO(Integer.valueOf(Caixa.aCBrECF.getNumCRO()));
            sintegra60M.setValorVendaBruta(Caixa.aCBrECF.getVendaBruta());
            sintegra60M.setValorGrandeTotal(Caixa.aCBrECF.getGrandeTotal());

            sintegraControl.Grava60M(sintegra60M);
        } catch (Throwable t) {
            t.printStackTrace();
            JOptionPane.showMessageDialog(null, t.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }

        //TODO : Qual o procedimento para a gravação do 60A?
    }

    public static boolean confereGT() {
        try {
            Properties arquivoAuxiliar = new Properties();
            arquivoAuxiliar.load(new FileInputStream(new File(System.getProperty("user.dir")
                    + System.getProperty("file.separator")
                    + "arquivoauxiliar.properties")));

            String gtArquivo = arquivoAuxiliar.getProperty("ecf.gt");

            String gtEcf = String.valueOf(Caixa.aCBrECF.getGrandeTotal());
            gtEcf = Biblioteca.MD5String(gtEcf);

            if (gtArquivo.equals(gtEcf)) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void atualizaGT() {
        try {
            Properties arquivoAuxiliar = new Properties();
            arquivoAuxiliar.load(new FileInputStream(new File(System.getProperty("user.dir")
                    + System.getProperty("file.separator")
                    + "arquivoauxiliar.properties")));

            String gtEcf = String.valueOf(Caixa.aCBrECF.getGrandeTotal());
            gtEcf = Biblioteca.MD5String(gtEcf);

            arquivoAuxiliar.setProperty("ecf.gt", gtEcf);

            FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir")
                    + System.getProperty("file.separator")
                    + "arquivoauxiliar.properties"));

            arquivoAuxiliar.store(out, "Arquivo auxiliar do PAF");

            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void parametrosConfiguracao() {
        try {
            Caixa.aCBrECF.abreRelatorioGerencial(Caixa.configuracao.getGerencialParametrosConfiguracao());

            Caixa.aCBrECF.linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("***********PARAMETROS DE CONFIGURACAO***********", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("CONFIGURACAO:", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);

            Caixa.aCBrECF.linhaRelatorioGerencial("Funcionalidades:", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("TIPO DE FUNCIONAMENTO: ......... Stand Alone", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("TIPO DE FUNCIONAMENTO: ......... Comercializavel", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("INTEGRACAO DO PAF-ECF: ......... Balcao", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);

            Caixa.aCBrECF.linhaRelatorioGerencial("Parâmetros Para Nao Concomitancia:", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("PRE-VENDA: ................................. SIM", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("DAV POR ECF: ............................... NAO", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("DAV IMPRESSORA NAO FISCAL: ................. SIM", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("DAV-OS: .................................... NAO", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);

            Caixa.aCBrECF.linhaRelatorioGerencial("Aplicacoes Especiais:", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("TAB. INDICE TECNICO DE PRODUCAO: ........... SIM", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("POSTO REVENDEDOR DE COMBUSTIVEIS: .......... NAO", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("Bar, Restaurante e Similar - ECF-Restaurante:NAO", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("Bar, Restaurante e Similar - ECF-Comum: .... NAO", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("FARMACIA DE MANIPULACAO: ................... NAO", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("OFICINA DE CONSERTO: ....................... NAO", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("TRANSPORTE DE PASSAGEIROS: ................. NAO", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);

            Caixa.aCBrECF.linhaRelatorioGerencial("Criterios por Unidade Federada:", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("REQUISITO XVIII - Tela Consulta de Preco:", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("TOTALIZACAO DOS VALORES DA LISTA: .......... NAO", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("TRANSFORMACAO DAS INFORMACOES EM PRE-VENDA:. NAO", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("TRANSFORMACAO DAS INFORMACOES EM DAV: ...... NAO", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);

            Caixa.aCBrECF.linhaRelatorioGerencial("REQUISITO XXII - PAF-ECF Integrado ao ECF:", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("NAO COINCIDENCIA GT(ECF) x ARQUIVO CRIPTOGRAFADO", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("RECOMPOE VALOR DO GT ARQUIVO CRIPTOGRAFADO:  NAO", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);

            Caixa.aCBrECF.linhaRelatorioGerencial("REQUISITO XXXVI - A - PAF-ECF Combustivel:", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("Impedir Registro de Venda com Valor Zero ou", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial("Negativo: .................................. SIM", 0);
            Caixa.aCBrECF.linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);

            Caixa.aCBrECF.fechaRelatorio();

            gravaR06("RG");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Caixa.getCaixa(), e.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void gravaR06(String simbolo) {
        try {
            R06VO r06;
            SimpleDateFormat formatohora = new SimpleDateFormat("HH:mm:ss");
            RegistroRController registroRControl = new RegistroRController();
            boolean primeiroDocumentoDia = false;

            //verifica se é o primeiro documento do dia
            r06 = registroRControl.ultimoRegistroR06();
            Calendar dataEcf = Calendar.getInstance();
            Calendar dataUltimoRegistro = Calendar.getInstance();
            dataEcf.setTime(Ecf.getDataHoraEcf());
            dataEcf.set(Calendar.HOUR_OF_DAY, 0);
            dataEcf.set(Calendar.MINUTE, 0);
            dataEcf.set(Calendar.SECOND, 0);
            if (r06.getDataEmissao() != null) {
                dataUltimoRegistro.setTime(r06.getDataEmissao());
            } else {
                primeiroDocumentoDia = true;
            }
            dataUltimoRegistro.set(Calendar.HOUR_OF_DAY, 0);
            dataUltimoRegistro.set(Calendar.MINUTE, 0);
            dataUltimoRegistro.set(Calendar.SECOND, 0);
            if (dataEcf.after(dataUltimoRegistro)) {
                primeiroDocumentoDia = true;
            }

            if (Caixa.movimento != null) {
                r06.setIdOperador(Caixa.movimento.getIdOperador());
                r06.setIdImpressora(Caixa.movimento.getIdImpressora());
                r06.setIdCaixa(Caixa.movimento.getIdCaixa());
            } else {
                r06.setIdOperador(0);
                r06.setIdImpressora(Caixa.configuracao.getImpressoraVO().getId());
                r06.setIdCaixa(0);
            }

            r06.setSerieEcf(Caixa.configuracao.getImpressoraVO().getSerie());
            r06.setCOO(Integer.valueOf(Caixa.aCBrECF.getNumCOO()));
            r06.setGNF(Integer.valueOf(Caixa.aCBrECF.getNumGNF()));
            if (simbolo.equals("RG")) {
                r06.setGRG(Integer.valueOf(Caixa.aCBrECF.getNumGRG()));
            }
            if (simbolo.equals("CC")) {
                r06.setCDC(Integer.valueOf(Caixa.aCBrECF.getNumCDC()));
            }
            r06.setDenominacao(simbolo);
            r06.setDataEmissao(new java.sql.Date(Ecf.getDataHoraEcf().getTime()));
            r06.setHoraEmissao(formatohora.format(Ecf.getDataHoraEcf()));

            registroRControl.gravaR06(r06);

            if (primeiroDocumentoDia) {
                atualizaEstoqueGeral(simbolo);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void atualizaEstoqueGeral(String denominacaoUltimoDocumento) {
        List<VendaDetalheVO> listaVendaDetalhe = null;
        if (denominacaoUltimoDocumento.equals("RV")) {
            VendaController vendaControl = new VendaController();
            VendaCabecalhoVO vendaCabecablho = vendaControl.ultimaVenda();
            listaVendaDetalhe = vendaControl.vendaDetalhe(vendaCabecablho.getId());
        }
        ProdutoController produtoControl = new ProdutoController();
        produtoControl.atualizaEstoqueGeral(listaVendaDetalhe, Ecf.getDataHoraEcf());
    }
}
