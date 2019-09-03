/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Regras de negócio/persistência da NF2.</p>
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
import com.t2tierp.pafecf.vo.NF2CabecalhoVO;
import com.t2tierp.pafecf.vo.NF2DetalheVO;
import com.t2tierp.pafecf.vo.NotaFiscalCabecalhoVO;
import com.t2tierp.pafecf.vo.NotaFiscalDetalheVO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NotaFiscalController {

    String consultaSQL;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    AcessoBanco bd = new AcessoBanco();

    public List<NF2CabecalhoVO> tabelaNF2Cabecalho() {
        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery("select count(*) as TOTAL from NF2_CABECALHO");
            rs.first();
            Integer totalRegistros = rs.getInt("TOTAL");

            if (totalRegistros > 0) {
                List<NF2CabecalhoVO> listaNF2Cabecalho = new ArrayList<NF2CabecalhoVO>();
                consultaSQL = "select * from NF2_CABECALHO";

                stm = bd.conectar().createStatement();
                rs = stm.executeQuery(consultaSQL);
                rs.beforeFirst();
                while (rs.next()) {
                    NF2CabecalhoVO NF2Cabecalho = new NF2CabecalhoVO();
                    NF2Cabecalho.setId(rs.getInt("ID"));
                    NF2Cabecalho.setCfop(rs.getInt("CFOP"));
                    NF2Cabecalho.setIdVendedor(rs.getInt("ID_ECF_FUNCIONARIO"));
                    NF2Cabecalho.setIdCliente(rs.getInt("ID_CLIENTE"));
                    NF2Cabecalho.setNumero(rs.getString("NUMERO"));
                    NF2Cabecalho.setDataEmissao(rs.getDate("DATA_EMISSAO"));
                    NF2Cabecalho.setHoraEmissao(rs.getString("HORA_EMISSAO"));
                    NF2Cabecalho.setSerie(rs.getString("SERIE"));
                    NF2Cabecalho.setSubserie(rs.getString("SUBSERIE"));
                    NF2Cabecalho.setTotalProdutos(rs.getDouble("TOTAL_PRODUTOS"));
                    NF2Cabecalho.setTotalNF(rs.getDouble("TOTAL_NF"));
                    NF2Cabecalho.setBaseICMS(rs.getDouble("BASE_ICMS"));
                    NF2Cabecalho.setICMS(rs.getDouble("ICMS"));
                    NF2Cabecalho.setICMSOutras(rs.getDouble("ICMS_OUTRAS"));
                    NF2Cabecalho.setISSQN(rs.getDouble("ISSQN"));
                    NF2Cabecalho.setPIS(rs.getDouble("PIS"));
                    NF2Cabecalho.setCOFINS(rs.getDouble("COFINS"));
                    NF2Cabecalho.setIPI(rs.getDouble("IPI"));
                    NF2Cabecalho.setTaxaAcrescimo(rs.getDouble("TAXA_ACRESCIMO"));
                    NF2Cabecalho.setAcrescimo(rs.getDouble("ACRESCIMO"));
                    NF2Cabecalho.setAcrescimoItens(rs.getDouble("ACRESCIMO_ITENS"));
                    NF2Cabecalho.setTaxaDesconto(rs.getDouble("TAXA_DESCONTO"));
                    NF2Cabecalho.setDesconto(rs.getDouble("DESCONTO"));
                    NF2Cabecalho.setDescontoItens(rs.getDouble("DESCONTO_ITENS"));
                    NF2Cabecalho.setCancelada(rs.getString("CANCELADA"));
                    listaNF2Cabecalho.add(NF2Cabecalho);
                }
                return listaNF2Cabecalho;
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

    public List<NF2DetalheVO> tabelaNF2Detalhe(Integer pId) {
        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery("select count(*) as TOTAL from NF2_DETALHE where ID_NF2_CABECALHO=" + pId);
            rs.first();
            Integer totalRegistros = rs.getInt("TOTAL");

            if (totalRegistros > 0) {
                List<NF2DetalheVO> listaNF2Detalhe = new ArrayList<NF2DetalheVO>();
                consultaSQL = "select * from NF2_DETALHE where ID_NF2_CABECALHO=" + pId;

                stm = bd.conectar().createStatement();
                rs = stm.executeQuery(consultaSQL);
                rs.beforeFirst();
                while (rs.next()) {
                    NF2DetalheVO NF2Detalhe = new NF2DetalheVO();
                    NF2Detalhe.setId(rs.getInt("ID"));
                    NF2Detalhe.setCfop(rs.getInt("CFOP"));
                    NF2Detalhe.setIdProduto(rs.getInt("ID_PRODUTO"));
                    NF2Detalhe.setIdNF2Cabecalho(rs.getInt("ID_NF2_CABECALHO"));
                    NF2Detalhe.setItem(rs.getInt("ITEM"));
                    NF2Detalhe.setQuantidade(rs.getDouble("QUANTIDADE"));
                    NF2Detalhe.setValorUnitario(rs.getDouble("VALOR_UNITARIO"));
                    NF2Detalhe.setValorTotal(rs.getDouble("VALOR_TOTAL"));
                    NF2Detalhe.setBaseICMS(rs.getDouble("BASE_ICMS"));
                    NF2Detalhe.setTaxaICMS(rs.getDouble("TAXA_ICMS"));
                    NF2Detalhe.setICMS(rs.getDouble("ICMS"));
                    NF2Detalhe.setICMSOutras(rs.getDouble("ICMS_OUTRAS"));
                    NF2Detalhe.setICMSIsento(rs.getDouble("ICMS_ISENTO"));
                    NF2Detalhe.setTaxaDesconto(rs.getDouble("TAXA_DESCONTO"));
                    NF2Detalhe.setDesconto(rs.getDouble("DESCONTO"));
                    NF2Detalhe.setTaxaISSQN(rs.getDouble("TAXA_ISSQN"));
                    NF2Detalhe.setISSQN(rs.getDouble("ISSQN"));
                    NF2Detalhe.setTaxaPIS(rs.getDouble("TAXA_PIS"));
                    NF2Detalhe.setPIS(rs.getDouble("PIS"));
                    NF2Detalhe.setTaxaCOFINS(rs.getDouble("TAXA_COFINS"));
                    NF2Detalhe.setCOFINS(rs.getDouble("COFINS"));
                    NF2Detalhe.setTaxaAcrescimo(rs.getDouble("TAXA_ACRESCIMO"));
                    NF2Detalhe.setAcrescimo(rs.getDouble("ACRESCIMO"));
                    NF2Detalhe.setTaxaIPI(rs.getDouble("TAXA_IPI"));
                    NF2Detalhe.setIPI(rs.getDouble("IPI"));
                    NF2Detalhe.setCancelado(rs.getString("CANCELADO"));
                    NF2Detalhe.setMovimentaEstoque(rs.getString("MOVIMENTA_ESTOQUE"));
                    listaNF2Detalhe.add(NF2Detalhe);
                }
                return listaNF2Detalhe;
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

    public boolean gravaNota(NotaFiscalCabecalhoVO notaCabecalho, List<NotaFiscalDetalheVO> listaNotaDetalhe) {
        Connection con = null;
        try {
            consultaSQL = "insert into NOTA_FISCAL_CABECALHO ("
                    + "ID_ECF_FUNCIONARIO,"
                    + "ID_CLIENTE,"
                    + "CFOP,"
                    + "NUMERO,"
                    + "DATA_EMISSAO,"
                    + "HORA_EMISSAO,"
                    + "SERIE,"
                    + "SUBSERIE,"
                    + "TOTAL_PRODUTOS,"
                    + "TOTAL_NF,"
                    + "BASE_ICMS,"
                    + "ICMS,"
                    + "ICMS_OUTRAS,"
                    + "ISSQN,"
                    + "PIS,"
                    + "COFINS,"
                    + "IPI,"
                    + "TAXA_ACRESCIMO,"
                    + "ACRESCIMO,"
                    + "ACRESCIMO_ITENS,"
                    + "TAXA_DESCONTO,"
                    + "DESCONTO,"
                    + "DESCONTO_ITENS,"
                    + "CANCELADA,"
                    + "TIPO_NOTA)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            con = bd.conectar();
            pstm = con.prepareStatement(consultaSQL);
            pstm.setInt(1, notaCabecalho.getIdFuncionario());
            pstm.setInt(2, notaCabecalho.getIdCliente());
            pstm.setInt(3, notaCabecalho.getCfop());
            pstm.setString(4, notaCabecalho.getNumero());
            pstm.setDate(5, new java.sql.Date(notaCabecalho.getDataEmissao().getTime()));
            pstm.setString(6, notaCabecalho.getHoraEmissao());
            pstm.setString(7, notaCabecalho.getSerie());
            pstm.setString(8, notaCabecalho.getSubserie());
            pstm.setBigDecimal(9, notaCabecalho.getTotalProdutos());
            pstm.setBigDecimal(10, notaCabecalho.getTotalNf());
            pstm.setBigDecimal(11, notaCabecalho.getBaseIcms());
            pstm.setBigDecimal(12, notaCabecalho.getIcms());
            pstm.setBigDecimal(13, notaCabecalho.getIcmsOutras());
            pstm.setBigDecimal(14, notaCabecalho.getIssqn());
            pstm.setBigDecimal(15, notaCabecalho.getPis());
            pstm.setBigDecimal(16, notaCabecalho.getCofins());
            pstm.setBigDecimal(17, notaCabecalho.getIpi());
            pstm.setBigDecimal(18, notaCabecalho.getTaxaAcrescimo());
            pstm.setBigDecimal(19, notaCabecalho.getAcrescimo());
            pstm.setBigDecimal(20, notaCabecalho.getAcrescimoItens());
            pstm.setBigDecimal(21, notaCabecalho.getTaxaDesconto());
            pstm.setBigDecimal(22, notaCabecalho.getDesconto());
            pstm.setBigDecimal(23, notaCabecalho.getDescontoItens());
            pstm.setString(24, notaCabecalho.getCancelada());
            pstm.setString(25, notaCabecalho.getTipoNota());

            pstm.executeUpdate();

            consultaSQL = "select max(ID) as ID from NOTA_FISCAL_CABECALHO";
            pstm = con.prepareStatement(consultaSQL);
            rs = pstm.executeQuery();

            if (rs.first()) {
                notaCabecalho.setId(rs.getInt("ID"));
            }

            consultaSQL = "insert into NOTA_FISCAL_DETALHE ("
                    + "ID_NF_CABECALHO,"
                    + "ID_PRODUTO,"
                    + "CFOP,"
                    + "ITEM,"
                    + "QUANTIDADE,"
                    + "VALOR_UNITARIO,"
                    + "VALOR_TOTAL,"
                    + "BASE_ICMS,"
                    + "TAXA_ICMS,"
                    + "ICMS,"
                    + "ICMS_OUTRAS,"
                    + "ICMS_ISENTO,"
                    + "TAXA_DESCONTO,"
                    + "DESCONTO,"
                    + "TAXA_ISSQN,"
                    + "ISSQN,"
                    + "TAXA_PIS,"
                    + "PIS,"
                    + "TAXA_COFINS,"
                    + "COFINS,"
                    + "TAXA_ACRESCIMO,"
                    + "ACRESCIMO,"
                    + "TAXA_IPI,"
                    + "IPI,"
                    + "CANCELADO,"
                    + "CST,"
                    + "ECF_ICMS_ST,"
                    + "MOVIMENTA_ESTOQUE) "
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            NotaFiscalDetalheVO notaDetalhe;
            for (int i = 0; i < listaNotaDetalhe.size(); i++) {
                notaDetalhe = listaNotaDetalhe.get(i);

                pstm = con.prepareStatement(consultaSQL);
                pstm.setInt(1, notaCabecalho.getId());
                pstm.setInt(2, notaDetalhe.getIdProduto());
                pstm.setInt(3, notaDetalhe.getCfop());
                pstm.setInt(4, notaDetalhe.getItem());
                pstm.setBigDecimal(5, notaDetalhe.getQuantidade());
                pstm.setBigDecimal(6, notaDetalhe.getValorUnitario());
                pstm.setBigDecimal(7, notaDetalhe.getValorTotal());
                pstm.setBigDecimal(8, notaDetalhe.getBaseIcms());
                pstm.setBigDecimal(9, notaDetalhe.getTaxaIcms());
                pstm.setBigDecimal(10, notaDetalhe.getIcms());
                pstm.setBigDecimal(11, notaDetalhe.getIcmsOutras());
                pstm.setBigDecimal(12, notaDetalhe.getIcmsIsento());
                pstm.setBigDecimal(13, notaDetalhe.getTaxaDesconto());
                pstm.setBigDecimal(14, notaDetalhe.getDesconto());
                pstm.setBigDecimal(15, notaDetalhe.getTaxaIssqn());
                pstm.setBigDecimal(16, notaDetalhe.getIssqn());
                pstm.setBigDecimal(17, notaDetalhe.getTaxaPis());
                pstm.setBigDecimal(18, notaDetalhe.getPis());
                pstm.setBigDecimal(19, notaDetalhe.getTaxaCofins());
                pstm.setBigDecimal(20, notaDetalhe.getCofins());
                pstm.setBigDecimal(21, notaDetalhe.getTaxaAcrescimo());
                pstm.setBigDecimal(22, notaDetalhe.getAcrescimo());
                pstm.setBigDecimal(23, notaDetalhe.getTaxaIpi());
                pstm.setBigDecimal(24, notaDetalhe.getIpi());
                pstm.setString(25, notaDetalhe.getCancelado());
                pstm.setString(26, notaDetalhe.getCst());
                pstm.setString(27, notaDetalhe.getEcfIcmsSt());
                pstm.setString(28, notaDetalhe.getMovimentaEstoque());

                pstm.executeUpdate();
            }

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        } finally {
            bd.desconectar();
        }
    }

    public NotaFiscalCabecalhoVO consultaNota(String numeroNota) {
        try {
            consultaSQL = "select * from NOTA_FISCAL_CABECALHO where NUMERO = ?";
            pstm = bd.conectar().prepareStatement(consultaSQL);
            pstm.setString(1, numeroNota);
            rs = pstm.executeQuery();
            if (rs.first()){
                NotaFiscalCabecalhoVO notaCabecalho = new NotaFiscalCabecalhoVO();
                notaCabecalho.setId(rs.getInt("ID"));
                notaCabecalho.setNumero(rs.getString("NUMERO"));
                return notaCabecalho;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bd.desconectar();
        }
        return null;
    }
}
