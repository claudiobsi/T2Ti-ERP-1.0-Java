/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Regras de negócio/persistência dos processos
 * do Sintegra.</p>
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
import com.t2tierp.pafecf.vo.Sintegra60AVO;
import com.t2tierp.pafecf.vo.Sintegra60DVO;
import com.t2tierp.pafecf.vo.Sintegra60MVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SintegraController {

    String consultaSQL;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    AcessoBanco bd = new AcessoBanco();

    public Sintegra60MVO Grava60M(Sintegra60MVO pSintegra60M) {

        consultaSQL =
                "insert into SINTEGRA_60M ("
                + "DATA_EMISSAO,"
                + "NUMERO_SERIE_ECF,"
                + "NUMERO_EQUIPAMENTO,"
                + "MODELO_DOCUMENTO_FISCAL,"
                + "COO_INICIAL,"
                + "COO_FINAL,"
                + "CRZ,"
                + "CRO,"
                + "VALOR_VENDA_BRUTA,"
                + "VALOR_GRANDE_TOTAL) values ("
                + "?,?,?,?,?,?,?,?,?,?)";

        try {
            pstm = bd.conectar().prepareStatement(consultaSQL);

            pstm.setDate(1, pSintegra60M.getDataEmissao());
            pstm.setString(2, pSintegra60M.getNumeroSerieECF());
            pstm.setInt(3, pSintegra60M.getNumeroEquipamento());
            pstm.setString(4, pSintegra60M.getModeloDocumentoFiscal());
            pstm.setInt(5, pSintegra60M.getCOOInicial());
            pstm.setInt(6, pSintegra60M.getCOOFinal());
            pstm.setInt(7, pSintegra60M.getCRZ());
            pstm.setInt(8, pSintegra60M.getCRO());
            pstm.setDouble(9, pSintegra60M.getValorVendaBruta());
            pstm.setDouble(10, pSintegra60M.getValorGrandeTotal());
            pstm.executeUpdate();

            try {
                stm = bd.conectar().createStatement();
                rs = stm.executeQuery("select max(ID) as ID from SINTEGRA_60M");
                rs.first();
                pSintegra60M.setId(rs.getInt("ID"));
                return pSintegra60M;
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

    public List<Sintegra60MVO> tabela60M() {
        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery("select count(*) as TOTAL from SINTEGRA_60M");
            rs.first();
            Integer totalRegistros = rs.getInt("TOTAL");

            if (totalRegistros > 0) {
                List<Sintegra60MVO> lista60M = new ArrayList<Sintegra60MVO>();
                consultaSQL = "select * from SINTEGRA_60M";

                stm = bd.conectar().createStatement();
                rs = stm.executeQuery(consultaSQL);
                rs.beforeFirst();
                while (rs.next()) {
                    Sintegra60MVO sintegra60M = new Sintegra60MVO();
                    sintegra60M.setId(rs.getInt("ID"));
                    sintegra60M.setDataEmissao(rs.getDate("DATA_EMISSAO"));
                    sintegra60M.setNumeroSerieECF(rs.getString("NUMERO_SERIE_ECF"));
                    sintegra60M.setNumeroEquipamento(rs.getInt("NUMERO_EQUIPAMENTO"));
                    sintegra60M.setModeloDocumentoFiscal(rs.getString("MODELO_DOCUMENTO_FISCAL"));
                    sintegra60M.setCOOInicial(rs.getInt("COO_INICIAL"));
                    sintegra60M.setCOOFinal(rs.getInt("COO_FINAL"));
                    sintegra60M.setCRZ(rs.getInt("CRZ"));
                    sintegra60M.setCRO(rs.getInt("CRO"));
                    sintegra60M.setValorVendaBruta(rs.getDouble("VALOR_VENDA_BRUTA"));
                    sintegra60M.setValorGrandeTotal(rs.getDouble("VALOR_GRANDE_TOTAL"));
                    lista60M.add(sintegra60M);
                }
                return lista60M;
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

    public void Grava60A(ArrayList<Sintegra60AVO> pListaSintegra60A) {

        Sintegra60AVO sintegra60A;

        for (int i = 0; i < pListaSintegra60A.size() - 1; i++) {
            consultaSQL =
                    "insert into SINTEGRA_60A ("
                    + "ID_SINTEGRA_60M,"
                    + "SITUACAO_TRIBUTARIA,"
                    + "VALOR) values ("
                    + "?,?,?)";

            sintegra60A = pListaSintegra60A.get(i);

            try {
                pstm = bd.conectar().prepareStatement(consultaSQL);
                pstm.setInt(1, sintegra60A.getId60M());
                pstm.setString(2, sintegra60A.getSituacaoTributaria());
                pstm.setDouble(3, sintegra60A.getValor());
                pstm.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                bd.desconectar();
            }
        }
    }

    public List<Sintegra60AVO> tabela60A(Integer pId) {
        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery("select count(*) AS TOTAL from SINTEGRA_60A where ID_SINTEGRA_60M=" + pId);
            rs.first();
            Integer totalRegistros = rs.getInt("TOTAL");

            if (totalRegistros > 0) {
                List<Sintegra60AVO> lista60A = new ArrayList<Sintegra60AVO>();
                consultaSQL = "select * from SINTEGRA_60A where ID_SINTEGRA_60M=" + pId;

                stm = bd.conectar().createStatement();
                rs = stm.executeQuery(consultaSQL);
                rs.beforeFirst();
                while (rs.next()) {
                    Sintegra60AVO sintegra60A = new Sintegra60AVO();
                    sintegra60A.setId(rs.getInt("ID"));
                    sintegra60A.setId60M(rs.getInt("ID_SINTEGRA_60M"));
                    sintegra60A.setSituacaoTributaria(rs.getString("SITUACAO_TRIBUTARIA"));
                    sintegra60A.setValor(rs.getDouble("VALOR"));
                    lista60A.add(sintegra60A);
                }
                return lista60A;
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

    public List<Sintegra60DVO> tabela60D() {
        consultaSQL =
                "select "
                + "P.GTIN, P.DESCRICAO_PDV, U.NOME, VD.QUANTIDADE, VD.TOTAL_ITEM, "
                + "VD.BASE_ICMS, VD.CST, VD.ICMS, VD.TAXA_ICMS "
                + "from ECF_VENDA_DETALHE VD, PRODUTO P, UNIDADE_PRODUTO U "
                + "where VD.ID_ECF_PRODUTO=P.ID and P.ID_UNIDADE_PRODUTO=U.ID";
        try {

            List<Sintegra60DVO> lista60D = new ArrayList<Sintegra60DVO>();

            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(consultaSQL);
            rs.beforeFirst();
            while (rs.next()) {
                Sintegra60DVO sintegra60D = new Sintegra60DVO();
                sintegra60D.setGTIN(rs.getString("GTIN"));
                sintegra60D.setDescricao(rs.getString("DESCRICAO_PDV"));
                sintegra60D.setSiglaUnidade(rs.getString("NOME"));
                sintegra60D.setQuantidade(rs.getDouble("QUANTIDADE"));
                sintegra60D.setValorLiquido(rs.getDouble("TOTAL_ITEM"));
                sintegra60D.setBaseICMS(rs.getDouble("BASE_ICMS"));
                sintegra60D.setSituacaoTributaria(rs.getString("CST"));
                sintegra60D.setValorICMS(rs.getDouble("ICMS"));
                sintegra60D.setAliquotaICMS(rs.getDouble("TAXA_ICMS"));
                lista60D.add(sintegra60D);
            }
            return lista60D;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            bd.desconectar();
        }
    }
}
