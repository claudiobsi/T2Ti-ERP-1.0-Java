/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Regras de negócio/persistência para o Registro R
 * do PAF-ECF.</p>
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
package com.t2tierp.pafecf.controller;

import com.t2tierp.pafecf.bd.AcessoBanco;
import com.t2tierp.pafecf.infra.Biblioteca;
import com.t2tierp.pafecf.vo.R01VO;
import com.t2tierp.pafecf.vo.R02VO;
import com.t2tierp.pafecf.vo.R03VO;
import com.t2tierp.pafecf.vo.R04VO;
import com.t2tierp.pafecf.vo.R05VO;
import com.t2tierp.pafecf.vo.R06VO;
import com.t2tierp.pafecf.vo.R07VO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistroRController {

    String consultaSQL;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    AcessoBanco bd = new AcessoBanco();

    public R02VO gravaR02(R02VO pR02) {
        consultaSQL =
                "insert into R02 ("
                + "ID_ECF_CAIXA,"
                + "ID_OPERADOR,"
                + "ID_IMPRESSORA,"
                + "CRZ,"
                + "COO,"
                + "CRO,"
                + "DATA_MOVIMENTO,"
                + "DATA_EMISSAO,"
                + "HORA_EMISSAO,"
                + "VENDA_BRUTA,"
                + "GRANDE_TOTAL) values ("
                + "?,?,?,?,?,?,?,?,?,?,?)";

        try {
            pstm = bd.conectar().prepareStatement(consultaSQL);

            pstm.setInt(1, pR02.getIdCaixa());
            pstm.setInt(2, pR02.getIdOperador());
            pstm.setInt(3, pR02.getIdImpressora());
            pstm.setInt(4, pR02.getCRZ());
            pstm.setInt(5, pR02.getCOO());
            pstm.setInt(6, pR02.getCRO());
            pstm.setDate(7, pR02.getDataMovimento());
            pstm.setDate(8, pR02.getDataEmissao());
            pstm.setString(9, pR02.getHoraEmissao());
            pstm.setDouble(10, pR02.getValorVendaBruta());
            pstm.setDouble(11, pR02.getValorGrandeTotal());
            pstm.executeUpdate();

            try {
                stm = bd.conectar().createStatement();
                rs = stm.executeQuery("select max(ID) as ID from R02");
                rs.first();
                pR02.setId(rs.getInt("ID"));

                SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
                String tripa = ""
                        + pR02.getId()
                        + pR02.getCRZ()
                        + pR02.getCOO()
                        + pR02.getCRO()
                        + pR02.getDataMovimento()
                        + formatoData.format(pR02.getDataEmissao())
                        + pR02.getHoraEmissao()
                        + Biblioteca.formatoDecimal("V", pR02.getValorVendaBruta());
                pR02.setHashTripa(Biblioteca.MD5String(tripa));

                consultaSQL =
                        "update R02 set "
                        + "HASH_TRIPA=? "
                        + "where ID=? ";

                pstm = bd.conectar().prepareStatement(consultaSQL);
                pstm.setString(1, pR02.getHashTripa());
                pstm.setInt(2, pR02.getId());
                pstm.executeUpdate();

                return pR02;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            bd.desconectar();
        }
    }

    public void gravaR03(List<R03VO> pListaR03) {

        R03VO r03;
        String tripa;

        for (int i = 0; i < pListaR03.size() - 1; i++) {
            try {
                consultaSQL =
                        "insert into R03 ("
                        + "ID_R02,"
                        + "TOTALIZADOR_PARCIAL,"
                        + "VALOR_ACUMULADO,"
                        + "HASH_TRIPA) values ("
                        + "?,?,?,?)";

                r03 = pListaR03.get(i);
                tripa = r03.getTotalizadorParcial()
                        + Biblioteca.formatoDecimal("V", r03.getValorAcumulado());
                r03.setHashTripa(Biblioteca.MD5String(tripa));


                pstm = bd.conectar().prepareStatement(consultaSQL);
                pstm.setInt(1, r03.getIdR02());
                pstm.setString(2, r03.getTotalizadorParcial());
                pstm.setDouble(3, r03.getValorAcumulado());
                pstm.setString(4, r03.getHashTripa());
                pstm.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                bd.desconectar();
            }
        }
    }

    public void gravaR06(R06VO pR06) {
        consultaSQL =
                "insert into R06 ("
                + "ID_ECF_CAIXA,"
                + "ID_OPERADOR,"
                + "ID_IMPRESSORA,"
                + "COO,"
                + "GNF,"
                + "GRG,"
                + "CDC,"
                + "DENOMINACAO,"
                + "DATA_EMISSAO,"
                + "HORA_EMISSAO,"
                + "SERIE_ECF, "
                + "HASH_TRIPA, "
                + "HASH_INCREMENTO) values ("
                + "?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            pstm = bd.conectar().prepareStatement(consultaSQL);

            pstm.setInt(1, pR06.getIdCaixa());
            pstm.setInt(2, pR06.getIdOperador());
            pstm.setInt(3, pR06.getIdImpressora());
            pstm.setInt(4, pR06.getCOO());
            pstm.setInt(5, pR06.getGNF());
            if (pR06.getGRG() == null) {
                pstm.setNull(6, java.sql.Types.INTEGER);
            } else {
                pstm.setInt(6, pR06.getGRG());
            }
            if (pR06.getCDC() == null) {
                pstm.setNull(7, java.sql.Types.INTEGER);
            } else {
                pstm.setInt(7, pR06.getCDC());
            }
            pstm.setString(8, pR06.getDenominacao());
            pstm.setDate(9, pR06.getDataEmissao());
            pstm.setString(10, pR06.getHoraEmissao());

            SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
            String tripa = ""
                    + pR06.getCOO()
                    + pR06.getGNF()
                    + pR06.getDenominacao()
                    + formatoData.format(pR06.getDataEmissao())
                    + pR06.getHoraEmissao()
                    + pR06.getSerieEcf()
                    + "0";
            pR06.setHashTripa(Biblioteca.MD5String(tripa));
            pstm.setString(11, pR06.getSerieEcf());
            pstm.setString(12, pR06.getHashTripa());
            pstm.setInt(13, 0);

            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    /*TODO : R07 tem vinculo com R04 e R06. R04 são os cupons fiscais.
    Seria interessante criar a tabela R04 e armazenar os dados dos cupons?
    Ou é melhor pegar esses dados da tabela VendaCabecalho mesmo? */
    public void gravaR07(R07VO pR07) {
        consultaSQL =
                "insert into R07 ("
                + "MEIO_PAGAMENTO,"
                + "VALOR_PAGAMENTO,"
                + "ESTORNO,"
                + "VALOR_ESTORNO) values ("
                + "?,?,?,?)";
        try {
            pstm = bd.conectar().prepareStatement(consultaSQL);

            pstm.setString(1, pR07.getMeioPagamento());
            pstm.setDouble(2, pR07.getValorPagamento());
            pstm.setString(3, pR07.getIndicadorEstorno());
            pstm.setDouble(4, pR07.getValorEstorno());
            pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bd.desconectar();
        }

    }

    public List<R02VO> tabelaR02() {
        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery("select count(*) as TOTAL from R02");
            rs.first();
            Integer totalRegistros = rs.getInt("TOTAL");

            if (totalRegistros > 0) {
                List<R02VO> listaR02 = new ArrayList<R02VO>();
                consultaSQL = "select * from R02";

                stm = bd.conectar().createStatement();
                rs = stm.executeQuery(consultaSQL);
                rs.beforeFirst();
                while (rs.next()) {
                    R02VO R02 = new R02VO();
                    R02.setId(rs.getInt("ID"));
                    R02.setIdCaixa(rs.getInt("ID_ECF_CAIXA"));
                    R02.setIdOperador(rs.getInt("ID_OPERADOR"));
                    R02.setIdImpressora(rs.getInt("ID_IMPRESSORA"));
                    R02.setCRZ(rs.getInt("CRZ"));
                    R02.setCOO(rs.getInt("COO"));
                    R02.setCRO(rs.getInt("CRO"));
                    R02.setDataMovimento(rs.getDate("DATA_MOVIMENTO"));
                    R02.setDataEmissao(rs.getDate("DATA_EMISSAO"));
                    R02.setHoraEmissao(rs.getString("HORA_EMISSAO"));
                    R02.setValorVendaBruta(rs.getDouble("VENDA_BRUTA"));
                    R02.setValorGrandeTotal(rs.getDouble("GRANDE_TOTAL"));
                    listaR02.add(R02);
                }
                return listaR02;
            } else {
                //caso nao existam registros retorna nulo
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            bd.desconectar();
        }
    }

    public List<R02VO> tabelaR02Id(Integer pId) {
        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery("select count(*) as TOTAL from R02 where ID_IMPRESSORA=" + pId);
            rs.first();
            Integer totalRegistros = rs.getInt("TOTAL");

            if (totalRegistros > 0) {
                List<R02VO> listaR02 = new ArrayList<R02VO>();
                consultaSQL = "select * from R02 where ID_IMPRESSORA=" + pId;

                stm = bd.conectar().createStatement();
                rs = stm.executeQuery(consultaSQL);
                rs.beforeFirst();
                while (rs.next()) {
                    R02VO R02 = new R02VO();
                    R02.setId(rs.getInt("ID"));
                    R02.setIdCaixa(rs.getInt("ID_ECF_CAIXA"));
                    R02.setIdOperador(rs.getInt("ID_OPERADOR"));
                    R02.setIdImpressora(rs.getInt("ID_IMPRESSORA"));
                    R02.setCRZ(rs.getInt("CRZ"));
                    R02.setCOO(rs.getInt("COO"));
                    R02.setCRO(rs.getInt("CRO"));
                    R02.setDataMovimento(rs.getDate("DATA_MOVIMENTO"));
                    R02.setDataEmissao(rs.getDate("DATA_EMISSAO"));
                    R02.setHoraEmissao(rs.getString("HORA_EMISSAO"));
                    R02.setValorVendaBruta(rs.getDouble("VENDA_BRUTA"));
                    R02.setValorGrandeTotal(rs.getDouble("GRANDE_TOTAL"));
                    listaR02.add(R02);
                }
                return listaR02;
            } else {
                //caso nao existam registros retorna nulo
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            bd.desconectar();
        }
    }

    public List<R03VO> tabelaR03(Integer pId) {
        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery("select count(*) AS TOTAL from R03 where ID_R02=" + pId);
            rs.first();
            Integer totalRegistros = rs.getInt("TOTAL");

            if (totalRegistros > 0) {
                List<R03VO> listaR03 = new ArrayList<R03VO>();
                consultaSQL = "select * from R03 where ID_R02=" + pId;

                stm = bd.conectar().createStatement();
                rs = stm.executeQuery(consultaSQL);
                rs.beforeFirst();
                while (rs.next()) {
                    R03VO R03 = new R03VO();
                    R03.setId(rs.getInt("ID"));
                    R03.setIdR02(rs.getInt("ID_R02"));
                    R03.setTotalizadorParcial(rs.getString("TOTALIZADOR_PARCIAL"));
                    R03.setValorAcumulado(rs.getDouble("VALOR_ACUMULADO"));
                    listaR03.add(R03);
                }
                return listaR03;
            } else {
                //caso nao existam registros retorna nulo
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            bd.desconectar();
        }
    }

    public List<R04VO> tabelaR04() {
        try {
            consultaSQL =
                    "select count(*) as TOTAL "
                    + "from ECF_VENDA_CABECALHO VC, ECF_MOVIMENTO M "
                    + "where VC.ID_ECF_MOVIMENTO=M.ID";

            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(consultaSQL);
            rs.first();
            Integer totalRegistros = rs.getInt("TOTAL");

            if (totalRegistros > 0) {
                List<R04VO> listaR04 = new ArrayList<R04VO>();
                consultaSQL =
                        "select VC.ID AS VCID, VC.ID_ECF_MOVIMENTO, VC.CCF, VC.COO, VC.DATA_VENDA, VC.VALOR_VENDA, "
                        + "VC.DESCONTO, VC.ACRESCIMO, VC.VALOR_FINAL, VC.STATUS_VENDA, VC.NOME_CLIENTE, "
                        + "VC.CPF_CNPJ_CLIENTE, M.ID AS MID, M.ID_ECF_IMPRESSORA, M.ID_ECF_OPERADOR "
                        + "from ECF_VENDA_CABECALHO VC, ECF_MOVIMENTO M "
                        + "where VC.ID_ECF_MOVIMENTO=M.ID";


                stm = bd.conectar().createStatement();
                rs = stm.executeQuery(consultaSQL);
                rs.beforeFirst();
                while (rs.next()) {
                    R04VO R04 = new R04VO();
                    R04.setId(rs.getInt("VCID"));
                    R04.setIdOperador(rs.getInt("ID_ECF_OPERADOR"));
                    R04.setCCF(rs.getInt("CCF"));
                    R04.setCOO(rs.getInt("COO"));
                    R04.setDataEmissao(rs.getDate("DATA_VENDA"));
                    R04.setSubTotal(rs.getDouble("VALOR_VENDA"));
                    R04.setDesconto(rs.getDouble("DESCONTO"));
                    //TODO : Deixar sempre o indicador como V, visto que sempre gravamos o valor do desconto independente da taxa?
                    R04.setIndicadorDesconto("V");
                    R04.setAcrescimo(rs.getDouble("ACRESCIMO"));
                    //TODO : Deixar sempre o indicador como V, visto que sempre gravamos o valor do desconto independente da taxa?
                    R04.setIndicadorAcrescimo("V");
                    R04.setValorLiquido(rs.getDouble("VALOR_FINAL"));
                    if (rs.getString("STATUS_VENDA").equals("C")) {
                        R04.setCancelado("S");
                    } else {
                        R04.setCancelado("N");
                    }
                    //TODO : Onde armazenar o valor do cancelamento do acrescimo? Permitir isso no sistema? Cancelar acrescimo e desconto?
                    R04.setCancelamentoAcrescimo(0.0);
                    //TODO : Permitir desconto e acrescimo no mesmo cupom?
                    R04.setOrdemDescontoAcrescimo("D");
                    R04.setCliente(rs.getString("NOME_CLIENTE"));
                    R04.setCPFCNPJ(rs.getString("CPF_CNPJ_CLIENTE"));
                    listaR04.add(R04);
                }
                return listaR04;
            } else {
                //caso nao existam registros retorna nulo
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            bd.desconectar();
        }
    }

    public List<R05VO> tabelaR05(Integer pId) {
        consultaSQL =
                "select count(*) as TOTAL "
                + "from ECF_VENDA_DETALHE V, PRODUTO P, UNIDADE_PRODUTO U "
                + "where V.ID_ECF_PRODUTO=P.ID and P.ID_UNIDADE_PRODUTO=U.ID "
                + "and V.ID_ECF_VENDA_CABECALHO=" + pId;

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(consultaSQL);
            rs.first();
            Integer totalRegistros = rs.getInt("TOTAL");

            if (totalRegistros > 0) {
                List<R05VO> listaR05 = new ArrayList<R05VO>();
                consultaSQL =
                        "select V.ID AS VID, V.ITEM, P.GTIN, P.DESCRICAO_PDV, V.QUANTIDADE, "
                        + "U.NOME AS SIGLA_UNIDADE, V.VALOR_UNITARIO, V.DESCONTO, V.ACRESCIMO, "
                        + "V.TOTAL_ITEM, V.TOTALIZADOR_PARCIAL, V.CANCELADO, P.IAT, P.IPPT "
                        + "from ECF_VENDA_DETALHE V, PRODUTO P, UNIDADE_PRODUTO U "
                        + "where V.ID_ECF_PRODUTO=P.ID and P.ID_UNIDADE_PRODUTO=U.ID "
                        + "and V.ID_ECF_VENDA_CABECALHO=" + pId;

                stm = bd.conectar().createStatement();
                rs = stm.executeQuery(consultaSQL);
                rs.beforeFirst();
                while (rs.next()) {
                    R05VO R05 = new R05VO();
                    R05.setId(rs.getInt("VID"));
                    R05.setItem(rs.getInt("ITEM"));
                    R05.setGTIN(rs.getString("GTIN"));
                    //TODO : Usar mesmo a descricaoPDV para esses registros R?
                    R05.setDescricaoPDV(rs.getString("DESCRICAO_PDV"));
                    R05.setQuantidade(rs.getDouble("QUANTIDADE"));
                    R05.setSiglaUnidade(rs.getString("SIGLA_UNIDADE"));
                    R05.setValorUnitario(rs.getDouble("VALOR_UNITARIO"));
                    //TODO : Desconto e acrescimo no item? Como controlar isso?
                    R05.setDesconto(rs.getDouble("DESCONTO"));
                    R05.setAcrescimo(rs.getDouble("ACRESCIMO"));
                    R05.setTotalItem(rs.getDouble("TOTAL_ITEM"));
                    R05.setTotalizadorParcial(rs.getString("TOTALIZADOR_PARCIAL"));
                    R05.setIndicadorCancelamento(rs.getString("CANCELADO"));
                    /* TODO :
                    Quantidade cancelada, no caso de cancelamento parcial de item.
                    Vamos implementar isso? */
                    if (R05.getIndicadorCancelamento().equals("S")) {
                        R05.setQuantidadeCancelada(1.0);
                    } else {
                        R05.setQuantidadeCancelada(0.0);
                    }
                    /* TODO :
                    Valor cancelado, no caso de cancelamento parcial de item.
                    Vamos implementar isso? */
                    if (R05.getIndicadorCancelamento().equals("S")) {
                        R05.setValorCancelado(rs.getDouble("TOTAL_ITEM"));
                    } else {
                        R05.setValorCancelado(0.0);
                    }
                    //TODO : Cancelamento do acrescimo do item? Vamos implementar isso?
                    R05.setCancelamentoAcrescimo(0.0);
                    R05.setIAT(rs.getString("IAT"));
                    R05.setIPPT(rs.getString("IPPT"));
                    //TODO : Deixar a opção de configurar essas casas decimais?
                    R05.setCasasDecimaisQuantidade(3);
                    R05.setCasasDecimaisValor(2);

                    listaR05.add(R05);
                }
                return listaR05;
            } else {
                //caso nao existam registros retorna nulo
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            bd.desconectar();
        }
    }

    public List<R06VO> tabelaR06() {
        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery("select count(*) as TOTAL from R06");
            rs.first();
            Integer totalRegistros = rs.getInt("TOTAL");

            if (totalRegistros > 0) {
                List<R06VO> listaR06 = new ArrayList<R06VO>();
                consultaSQL = "select * from R06";

                stm = bd.conectar().createStatement();
                rs = stm.executeQuery(consultaSQL);
                rs.beforeFirst();
                while (rs.next()) {
                    R06VO R06 = new R06VO();
                    R06.setId(rs.getInt("ID"));
                    R06.setIdCaixa(rs.getInt("ID_ECF_CAIXA"));
                    R06.setIdOperador(rs.getInt("ID_OPERADOR"));
                    R06.setIdImpressora(rs.getInt("ID_IMPRESSORA"));
                    R06.setCOO(rs.getInt("COO"));
                    R06.setGNF(rs.getInt("GNF"));
                    R06.setGRG(rs.getInt("GRG"));
                    R06.setCDC(rs.getInt("CDC"));
                    R06.setDenominacao(rs.getString("DENOMINACAO"));
                    R06.setDataEmissao(rs.getDate("DATA_EMISSAO"));
                    R06.setHoraEmissao(rs.getString("HORA_EMISSAO"));
                    listaR06.add(R06);
                }
                return listaR06;
            } else {
                //caso nao existam registros retorna nulo
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            bd.desconectar();
        }
    }

    public List<R07VO> tabelaR07(Integer pId) {
        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery("select count(*) as TOTAL from R07 where ID_R06=" + pId);
            rs.first();
            Integer totalRegistros = rs.getInt("TOTAL");

            if (totalRegistros > 0) {
                List<R07VO> listaR07 = new ArrayList<R07VO>();
                consultaSQL = "select * from R07 where ID_R06=" + pId;

                stm = bd.conectar().createStatement();
                rs = stm.executeQuery(consultaSQL);
                rs.beforeFirst();
                while (rs.next()) {
                    R07VO R07 = new R07VO();
                    R07.setId(rs.getInt("ID"));
                    R07.setCCF(rs.getInt("CCF"));
                    R07.setMeioPagamento(rs.getString("MEIO_PAGAMENTO"));
                    R07.setValorPagamento(rs.getDouble("VALOR_PAGAMENTO"));
                    R07.setIndicadorEstorno(rs.getString("ESTORNO"));
                    R07.setValorEstorno(rs.getDouble("VALOR_ESTORNO"));
                    listaR07.add(R07);
                }
                return listaR07;
            } else {
                //caso nao existam registros retorna nulo
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            bd.desconectar();
        }
    }

    public R01VO tabelaR01() {
        try {
            R01VO r01 = null;
            consultaSQL = "select * from R01";

            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(consultaSQL);
            if (rs.first()) {
                r01 = new R01VO();
                r01.setId(rs.getInt("ID"));
                r01.setSerieEcf(rs.getString("SERIE_ECF"));
                r01.setCnpjEmpresa(rs.getString("CNPJ_EMPRESA"));
                r01.setCnpjSh(rs.getString("CNPJ_SH"));
                r01.setInscricaoEstadualSh(rs.getString("INSCRICAO_ESTADUAL_SH"));
                r01.setInscricaoMunicipalSh(rs.getString("INSCRICAO_MUNICIPAL_SH"));
                r01.setDenominacaoSh(rs.getString("DENOMINACAO_SH"));
                r01.setNomePafEcf(rs.getString("NOME_PAF_ECF"));
                r01.setVersaoPafEcf(rs.getString("VERSAO_PAF_ECF"));
                r01.setMd5PafEcf(rs.getString("MD5_PAF_ECF"));
                r01.setDataInicial(rs.getDate("DATA_INICIAL"));
                r01.setDataFinal(rs.getDate("DATA_FINAL"));
                r01.setVersaoEr(rs.getString("VERSAO_ER"));
                r01.setNumeroLaudoPaf(rs.getString("NUMERO_LAUDO_PAF"));
                r01.setRazaoSocialSh(rs.getString("RAZAO_SOCIAL_SH"));
                r01.setEnderecoSh(rs.getString("ENDERECO_SH"));
                r01.setNumeroSh(rs.getString("NUMERO_SH"));
                r01.setComplementoSh(rs.getString("COMPLEMENTO_SH"));
                r01.setBairroSh(rs.getString("BAIRRO_SH"));
                r01.setCidadeSh(rs.getString("CIDADE_SH"));
                r01.setCepSh(rs.getString("CEP_SH"));
                r01.setUfSh(rs.getString("UF_SH"));
                r01.setTelefoneSh(rs.getString("TELEFONE_SH"));
                r01.setContatoSh(rs.getString("CONTATO_SH"));
                r01.setPrincipalExecutavel(rs.getString("PRINCIPAL_EXECUTAVEL"));
                r01.setHashTripa(rs.getString("HASH_TRIPA"));
                r01.setHashIncremento(rs.getInt("HASH_INCREMENTO"));
            }
            return r01;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            bd.desconectar();
        }
    }

    public R06VO ultimoRegistroR06() {
        try {
            R06VO r06 = new R06VO();
            consultaSQL = "select * from R06 where ID = (select max(ID) as ULTIMO from R06)";

            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(consultaSQL);
            rs.beforeFirst();
            if (rs.next()) {
                r06.setId(rs.getInt("ID"));
                r06.setIdCaixa(rs.getInt("ID_ECF_CAIXA"));
                r06.setIdOperador(rs.getInt("ID_OPERADOR"));
                r06.setIdImpressora(rs.getInt("ID_IMPRESSORA"));
                r06.setCOO(rs.getInt("COO"));
                r06.setGNF(rs.getInt("GNF"));
                r06.setGRG(rs.getInt("GRG"));
                r06.setCDC(rs.getInt("CDC"));
                r06.setDenominacao(rs.getString("DENOMINACAO"));
                r06.setDataEmissao(rs.getDate("DATA_EMISSAO"));
                r06.setHoraEmissao(rs.getString("HORA_EMISSAO"));
            }
            return r06;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            bd.desconectar();
        }
    }

    public boolean verificaMovimentoPeriodo(Date dataInicio, Date dataFim) {
        try {
            consultaSQL = "select * from R02 where DATA_MOVIMENTO between ? and ?";

            pstm = bd.conectar().prepareStatement(consultaSQL);
            pstm.setDate(1, new java.sql.Date(dataInicio.getTime()));
            pstm.setDate(2, new java.sql.Date(dataFim.getTime()));
            rs = pstm.executeQuery();
            if (rs.first()){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            bd.desconectar();
        }
    }
}
