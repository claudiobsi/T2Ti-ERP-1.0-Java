/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Regras de negócio/persistência do Produto.</p>
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
import com.t2tierp.pafecf.view.Caixa;
import com.t2tierp.pafecf.vo.FichaTecnicaVO;
import com.t2tierp.pafecf.vo.ProdutoVO;
import com.t2tierp.pafecf.vo.VendaDetalheVO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProdutoController {

    String consultaSQL;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    AcessoBanco bd = new AcessoBanco();

    public ProdutoVO consulta(String codigo) {
        ProdutoVO produtoVO = new ProdutoVO();
        consultaSQL =
                "select P.ID, P.ID_UNIDADE_PRODUTO, P.GTIN, P.CODIGO_INTERNO, "
                + "P.NOME AS NOME_PRODUTO, P.DESCRICAO, P.DESCRICAO_PDV, P.VALOR_VENDA, P.QTD_ESTOQUE, "
                + "P.ESTOQUE_MIN, P.ESTOQUE_MAX, P.IAT, P.IPPT, P.NCM, U.NOME AS NOME_UNIDADE, "
                + "U.PODE_FRACIONAR, P.ECF_ICMS_ST, P.CST, P.TAXA_ICMS, P.TOTALIZADOR_PARCIAL, U.PODE_FRACIONAR, "
                + "P.TAXA_IPI, P.TAXA_COFINS, P.TAXA_PIS, P.TAXA_ISSQN "
                + "from "
                + "PRODUTO P, "
                + "UNIDADE_PRODUTO U "
                + "where "
                + "P.GTIN = '" + codigo + "' "
                + "and P.ID_UNIDADE_PRODUTO = U.ID ";
        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(consultaSQL);
            rs.beforeFirst();
            if (rs.next()) {
                produtoVO.setId(rs.getInt("ID"));
                produtoVO.setGTIN(rs.getString("GTIN"));
                produtoVO.setDescricaoPDV(rs.getString("DESCRICAO_PDV"));
                produtoVO.setValorVenda(rs.getDouble("VALOR_VENDA"));
                produtoVO.setIdUnidade(rs.getInt("ID_UNIDADE_PRODUTO"));
                produtoVO.setCodigoInterno(rs.getString("CODIGO_INTERNO"));
                produtoVO.setNome(rs.getString("NOME_PRODUTO"));
                produtoVO.setDescricao(rs.getString("DESCRICAO"));
                produtoVO.setQuantidadeEstoque(rs.getDouble("QTD_ESTOQUE"));
                produtoVO.setEstoqueMaximo(rs.getDouble("ESTOQUE_MAX"));
                produtoVO.setEstoqueMinimo(rs.getDouble("ESTOQUE_MIN"));
                produtoVO.setIAT(rs.getString("IAT"));
                produtoVO.setIPPT(rs.getString("IPPT"));
                produtoVO.setNCM(rs.getString("NCM"));
                produtoVO.setUnidadeProduto(rs.getString("NOME_UNIDADE"));
                produtoVO.setSituacaoTributaria(rs.getString("CST"));
                produtoVO.setECFICMS(rs.getString("ECF_ICMS_ST"));
                produtoVO.setTotalizadorParcial(rs.getString("TOTALIZADOR_PARCIAL"));
                produtoVO.setPodeFracionar(rs.getString("PODE_FRACIONAR"));
                produtoVO.setTaxaICMS(rs.getDouble("TAXA_ICMS"));
                produtoVO.setTaxaIPI(rs.getDouble("TAXA_IPI"));
                produtoVO.setTaxaCOFINS(rs.getDouble("TAXA_COFINS"));
                produtoVO.setTaxaPIS(rs.getDouble("TAXA_PIS"));
                produtoVO.setTaxaISSQN(rs.getDouble("TAXA_ISSQN"));
                produtoVO.setCST(rs.getString("CST"));
                return produtoVO;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            bd.desconectar();
        }
    }

    public ProdutoVO consultaId(Integer pId) {
        ProdutoVO produto = new ProdutoVO();
        consultaSQL =
                "select P.ID, P.ID_UNIDADE_PRODUTO, P.GTIN, P.CODIGO_INTERNO, "
                + "P.NOME AS NOME_PRODUTO, P.DESCRICAO, P.DESCRICAO_PDV, P.VALOR_VENDA, P.QTD_ESTOQUE, P.ESTOQUE_MIN, P.DATA_ESTOQUE, "
                + "P.ESTOQUE_MAX, P.IAT, P.IPPT, P.NCM, P.TAXA_ICMS, U.NOME AS NOME_UNIDADE, P.ECF_ICMS_ST, P.CST, P.TOTALIZADOR_PARCIAL "
                + "from "
                + "PRODUTO P, UNIDADE_PRODUTO U "
                + "where P.ID=" + pId + " "
                + "and P.ID_UNIDADE_PRODUTO = U.ID ";

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(consultaSQL);
            rs.beforeFirst();
            if (rs.next()) {
                produto.setId(rs.getInt("ID"));
                produto.setGTIN(rs.getString("GTIN"));
                produto.setDescricaoPDV(rs.getString("DESCRICAO_PDV"));
                produto.setValorVenda(rs.getDouble("VALOR_VENDA"));
                produto.setIdUnidade(rs.getInt("ID_UNIDADE_PRODUTO"));
                produto.setCodigoInterno(rs.getString("CODIGO_INTERNO"));
                produto.setNome(rs.getString("NOME_PRODUTO"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setQuantidadeEstoque(rs.getDouble("QTD_ESTOQUE"));
                produto.setEstoqueMaximo(rs.getDouble("ESTOQUE_MAX"));
                produto.setEstoqueMinimo(rs.getDouble("ESTOQUE_MIN"));
                produto.setIAT(rs.getString("IAT"));
                produto.setIPPT(rs.getString("IPPT"));
                produto.setNCM(rs.getString("NCM"));
                produto.setUnidadeProduto(rs.getString("NOME_UNIDADE"));
                produto.setSituacaoTributaria(rs.getString("CST"));
                produto.setECFICMS(rs.getString("ECF_ICMS_ST"));
                produto.setTotalizadorParcial(rs.getString("TOTALIZADOR_PARCIAL"));
                produto.setTaxaICMS(rs.getDouble("TAXA_ICMS"));
                produto.setDataEstoque(rs.getDate("DATA_ESTOQUE"));
                return produto;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            bd.desconectar();
        }
    }

    public List<ProdutoVO> tabelaProduto() {
        consultaSQL =
                "select count(*) as TOTAL "
                + "from PRODUTO P, UNIDADE_PRODUTO U "
                + "where P.ID_UNIDADE_PRODUTO = U.ID ";

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(consultaSQL);
            rs.first();
            Integer totalRegistros = rs.getInt("TOTAL");

            if (totalRegistros > 0) {
                List<ProdutoVO> listaProduto = new ArrayList<ProdutoVO>();
                consultaSQL =
                        "select P.ID AS PID,P.ID_UNIDADE_PRODUTO,P.GTIN,P.DESCRICAO_PDV, "
                        + "P.IAT,P.IPPT,P.VALOR_VENDA,P.QTD_ESTOQUE,P.DESCRICAO,P.NOME AS PNOME, "
                        + "U.ID AS UID, U.NOME AS UNOME, P.CST, P.ECF_ICMS_ST, "
                        + "P.TOTALIZADOR_PARCIAL, P.TAXA_ICMS, P.DATA_ESTOQUE, P.HORA_ESTOQUE "
                        + "from PRODUTO P, UNIDADE_PRODUTO U "
                        + "where P.ID_UNIDADE_PRODUTO = U.ID";


                stm = bd.conectar().createStatement();
                rs = stm.executeQuery(consultaSQL);
                rs.beforeFirst();
                while (rs.next()) {
                    ProdutoVO produto = new ProdutoVO();
                    produto.setId(rs.getInt("PID"));
                    produto.setGTIN(rs.getString("GTIN"));
                    produto.setDescricaoPDV(rs.getString("DESCRICAO_PDV"));
                    produto.setDescricao(rs.getString("DESCRICAO"));
                    produto.setNome(rs.getString("PNOME"));
                    produto.setUnidadeProduto(rs.getString("UNOME"));
                    produto.setIAT(rs.getString("IAT"));
                    produto.setIPPT(rs.getString("IPPT"));
                    produto.setSituacaoTributaria(rs.getString("CST"));
                    produto.setECFICMS(rs.getString("ECF_ICMS_ST"));
                    produto.setAliquotaICMS(rs.getDouble("TAXA_ICMS"));
                    produto.setTotalizadorParcial(rs.getString("TOTALIZADOR_PARCIAL"));
                    produto.setQuantidadeEstoque(rs.getDouble("QTD_ESTOQUE"));
                    produto.setValorVenda(rs.getDouble("VALOR_VENDA"));
                    produto.setTaxaICMS(rs.getDouble("TAXA_ICMS"));
                    produto.setDataEstoque(rs.getDate("DATA_ESTOQUE"));
                    produto.setHoraEstoque(rs.getString("HORA_ESTOQUE"));
                    listaProduto.add(produto);
                }
                return listaProduto;
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

    public List<ProdutoVO> produtoFiltro(String filtroNome) {
        String procurePor = "%" + filtroNome + "%";
        consultaSQL =
                "SELECT COUNT(*) as TOTAL FROM PRODUTO "
                + "WHERE NOME LIKE '" + procurePor + "'";

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(consultaSQL);
            rs.first();
            Integer totalRegistros = rs.getInt("TOTAL");

            if (totalRegistros > 0) {
                List<ProdutoVO> listaProduto = new ArrayList<ProdutoVO>();
                consultaSQL =
                        "SELECT P.*, U.NOME FROM PRODUTO P JOIN UNIDADE_PRODUTO U "
                        + "ON P.ID_UNIDADE_PRODUTO = U.ID "
                        + "WHERE P.NOME LIKE '" + procurePor + "'"
                        + " ORDER BY P.NOME";

                stm = bd.conectar().createStatement();
                rs = stm.executeQuery(consultaSQL);
                rs.beforeFirst();
                while (rs.next()) {
                    ProdutoVO produto = new ProdutoVO();
                    produto.setNome(rs.getString("P.NOME"));
                    produto.setValorVenda(rs.getDouble("P.VALOR_VENDA"));
                    produto.setDescricaoPDV(rs.getString("P.DESCRICAO_PDV"));
                    produto.setGTIN(rs.getString("P.GTIN"));
                    produto.setCodigoInterno(rs.getString("P.CODIGO_INTERNO"));
                    produto.setQuantidadeEstoque(rs.getDouble("P.QTD_ESTOQUE"));
                    produto.setEstoqueMinimo(rs.getDouble("P.ESTOQUE_MIN"));
                    produto.setEstoqueMaximo(rs.getDouble("P.ESTOQUE_MAX"));
                    produto.setUnidadeProduto(rs.getString("U.NOME"));
                    produto.setECFICMS(rs.getString("P.ECF_ICMS_ST"));
                    produto.setCST(rs.getString("P.CST"));
                    produto.setIAT(rs.getString("P.IAT"));
                    produto.setIPPT(rs.getString("P.IPPT"));
                    listaProduto.add(produto);
                }
                return listaProduto;
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

    public void atualizaEstoque(List<VendaDetalheVO> listaVendaDetalhe, boolean vendaCancelada) {
        ProdutoVO produto;
        BigDecimal quantidade;
        BigDecimal quantidadeFichaTecnica;
        for (int i = 0; i < listaVendaDetalhe.size(); i++) {
            if (listaVendaDetalhe.get(i).getCancelado().equals("N")) {
                produto = consultaId(listaVendaDetalhe.get(i).getIdProduto());

                if (produto.getIPPT().equals("P")) {
                    FichaTecnicaController fichaControl = new FichaTecnicaController();
                    List<FichaTecnicaVO> listaFichaTecnica = fichaControl.consultaFichaTecnica(produto.getId());

                    for (int j = 0; j < listaFichaTecnica.size(); j++) {
                        produto = consultaId(listaFichaTecnica.get(j).getIdProdutoFilho());
                        quantidade = BigDecimal.valueOf(listaVendaDetalhe.get(i).getQuantidade());
                        quantidadeFichaTecnica = BigDecimal.valueOf(listaFichaTecnica.get(j).getQuantidade());

                        quantidade = quantidade.multiply(quantidadeFichaTecnica).setScale(Caixa.configuracao.getDecimaisQuantidade(), RoundingMode.DOWN);

                        atualizaEstoque(produto, quantidade, vendaCancelada);
                    }
                } else {
                    quantidade = BigDecimal.valueOf(listaVendaDetalhe.get(i).getQuantidade());
                    atualizaEstoque(produto, quantidade, vendaCancelada);
                }
            }
        }
    }

    private void atualizaEstoque(ProdutoVO produto, BigDecimal quantidade, boolean vendaCancelada) {
        try {
            String atualizaProduto = "update PRODUTO set "
                    + "QTD_ESTOQUE = ?, "
                    + "HASH_TRIPA = ?, "
                    + "HASH_INCREMENTO = ? "
                    + "where ID = ? ";

            Connection con = bd.conectar();
            BigDecimal estoqueAtual;
            String tripa;
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

            estoqueAtual = BigDecimal.valueOf(produto.getQuantidadeEstoque());
            if (vendaCancelada) {
                estoqueAtual = estoqueAtual.add(quantidade);
            } else {
                estoqueAtual = estoqueAtual.subtract(quantidade);
            }
            estoqueAtual = estoqueAtual.setScale(Caixa.configuracao.getDecimaisQuantidade(), RoundingMode.DOWN);

            //produto.setQuantidadeEstoqueAnterior(produto.getQuantidadeEstoque());
            produto.setQuantidadeEstoque(estoqueAtual.doubleValue());
            //produto.setDataEstoque(new Date());

            tripa = produto.getGTIN()
                    + produto.getDescricao()
                    + produto.getDescricaoPDV()
                    + Biblioteca.formatoDecimal("Q", produto.getQuantidadeEstoque())
                    + formatoData.format(produto.getDataEstoque())
                    + produto.getSituacaoTributaria()
                    + Biblioteca.formatoDecimal("V", produto.getTaxaICMS())
                    + Biblioteca.formatoDecimal("V", produto.getValorVenda())
                    + "0";
            produto.setHashTripa(Biblioteca.MD5String(tripa));
            produto.setHashIncremento(-1);

            pstm = con.prepareStatement(atualizaProduto);
            pstm.setDouble(1, produto.getQuantidadeEstoque());
            //pstm.setDouble(2, produto.getQuantidadeEstoqueAnterior());
            //pstm.setDate(3, new java.sql.Date(produto.getDataEstoque().getTime()));
            pstm.setString(2, produto.getHashTripa());
            pstm.setInt(3, produto.getHashIncremento());
            pstm.setInt(4, produto.getId());

            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bd.desconectar();
        }
    }

    public void atualizaEstoqueGeral(List<VendaDetalheVO> listaVendaDetalhe, Date dataEstoque) {
        Connection con = null;
        try {
            String atualizaProduto = "update PRODUTO set "
                    + "QTD_ESTOQUE_ANTERIOR = ?, "
                    + "DATA_ESTOQUE = ?, "
                    + "HORA_ESTOQUE = ?, "
                    + "HASH_TRIPA = ?, "
                    + "HASH_INCREMENTO = ? "
                    + "where ID = ? ";

            con = bd.conectar();
            String tripa;
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

            List<ProdutoVO> listaProduto = tabelaProduto();
            ProdutoVO produto;
            for (int i = 0; i < listaProduto.size(); i++) {
                produto = listaProduto.get(i);
                produto.setQuantidadeEstoqueAnterior(produto.getQuantidadeEstoque());
                //se o primeiro documento do dia for uma venda, desconsidera as quantidades vendidas para atualizar o estoque
                if (listaVendaDetalhe != null) {
                    for (int j = 0; j < listaVendaDetalhe.size(); j++) {
                        if (produto.getId() == listaVendaDetalhe.get(j).getIdProduto()) {
                            produto.setQuantidadeEstoqueAnterior(produto.getQuantidadeEstoque() + listaVendaDetalhe.get(j).getQuantidade());
                            break;
                        }
                    }
                }

                produto.setDataEstoque(dataEstoque);
                produto.setHoraEstoque(formatoHora.format(dataEstoque));

                tripa = produto.getGTIN()
                        + produto.getDescricao()
                        + produto.getDescricaoPDV()
                        + Biblioteca.formatoDecimal("Q", produto.getQuantidadeEstoque())
                        + formatoData.format(produto.getDataEstoque())
                        + produto.getSituacaoTributaria()
                        + Biblioteca.formatoDecimal("V", produto.getTaxaICMS())
                        + Biblioteca.formatoDecimal("V", produto.getValorVenda())
                        + "0";
                produto.setHashTripa(Biblioteca.MD5String(tripa));
                produto.setHashIncremento(-1);

                pstm = con.prepareStatement(atualizaProduto);
                pstm.setDouble(1, produto.getQuantidadeEstoqueAnterior());
                pstm.setDate(2, new java.sql.Date(produto.getDataEstoque().getTime()));
                pstm.setString(3, produto.getHoraEstoque());
                pstm.setString(4, produto.getHashTripa());
                pstm.setInt(5, produto.getHashIncremento());
                pstm.setInt(6, produto.getId());

                pstm.executeUpdate();
            }
            String atualizaEstoque = "update ECF_ESTOQUE set "
                    + "ID_ECF_EMPRESA = ?, "
                    + "ID_ECF_IMPRESSORA = ?, "
                    + "NUMERO_SERIE_ECF = ?, "
                    + "DATA_ATUALIZACAO = ?, "
                    + "HORA_ATUALIZACAO = ?, "
                    + "HASH_TRIPA = ?, "
                    + "HASH_INCREMENTO = ? ";
            tripa = Caixa.configuracao.getImpressoraVO().getSerie()
                    + formatoData.format(dataEstoque)
                    + formatoHora.format(dataEstoque)
                    + "0";
            pstm = con.prepareStatement(atualizaEstoque);
            pstm.setInt(1, Caixa.configuracao.getIdEmpresa());
            pstm.setInt(2, Caixa.configuracao.getImpressoraVO().getId());
            pstm.setString(3, Caixa.configuracao.getImpressoraVO().getSerie());
            pstm.setDate(4, new java.sql.Date(dataEstoque.getTime()));
            pstm.setString(5, formatoHora.format(dataEstoque));
            pstm.setString(6, Biblioteca.MD5String(tripa));
            pstm.setInt(7, -1);

            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            bd.desconectar();
        }
    }

    public List<ProdutoVO> produtoFiltro(String filtroNome, String ippt) {
        String procurePor = "%" + filtroNome + "%";
        consultaSQL =
                "SELECT COUNT(*) as TOTAL FROM PRODUTO "
                + "WHERE NOME LIKE '" + procurePor + "' and IPPT = '" + ippt + "'";

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(consultaSQL);
            rs.first();
            Integer totalRegistros = rs.getInt("TOTAL");

            if (totalRegistros > 0) {
                List<ProdutoVO> listaProduto = new ArrayList<ProdutoVO>();
                consultaSQL =
                        "SELECT P.*, U.NOME FROM PRODUTO P JOIN UNIDADE_PRODUTO U "
                        + "ON P.ID_UNIDADE_PRODUTO = U.ID "
                        + "WHERE P.NOME LIKE '" + procurePor + "' and IPPT = '" + ippt + "' "
                        + " ORDER BY P.NOME";

                stm = bd.conectar().createStatement();
                rs = stm.executeQuery(consultaSQL);
                rs.beforeFirst();
                while (rs.next()) {
                    ProdutoVO produto = new ProdutoVO();
                    produto.setId(rs.getInt("ID"));
                    produto.setNome(rs.getString("P.NOME"));
                    produto.setValorVenda(rs.getDouble("P.VALOR_VENDA"));
                    produto.setDescricaoPDV(rs.getString("P.DESCRICAO_PDV"));
                    produto.setGTIN(rs.getString("P.GTIN"));
                    produto.setCodigoInterno(rs.getString("P.CODIGO_INTERNO"));
                    produto.setQuantidadeEstoque(rs.getDouble("P.QTD_ESTOQUE"));
                    produto.setEstoqueMinimo(rs.getDouble("P.ESTOQUE_MIN"));
                    produto.setEstoqueMaximo(rs.getDouble("P.ESTOQUE_MAX"));
                    produto.setUnidadeProduto(rs.getString("U.NOME"));
                    produto.setECFICMS(rs.getString("P.ECF_ICMS_ST"));
                    produto.setCST(rs.getString("P.CST"));
                    produto.setIAT(rs.getString("P.IAT"));
                    produto.setIPPT(rs.getString("P.IPPT"));
                    listaProduto.add(produto);
                }
                return listaProduto;
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
}
