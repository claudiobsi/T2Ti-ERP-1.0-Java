/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Regras de negócio/persistência do Cliente.</p>
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
import com.t2tierp.pafecf.vo.ClienteVO;
import com.t2tierp.pafecf.vo.SituacaoClienteVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    String consultaSQL;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    AcessoBanco bd = new AcessoBanco();

    public ClienteVO consultaCPFCNPJ(String pCPFouCNPJ) {
        ClienteVO cliente = new ClienteVO();
        consultaSQL =
                "select ID, NOME, CPF_CNPJ from CLIENTE where CPF_CNPJ=" + pCPFouCNPJ;
        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(consultaSQL);
            rs.beforeFirst();
            if (rs.next()) {
                cliente.setId(rs.getInt("ID"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setCPFOuCNPJ(rs.getString("CPF_CNPJ"));
                return cliente;
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

    public List<ClienteVO> clienteFiltro(String filtroNome) {
        String procurePor = "%" + filtroNome + "%";
        consultaSQL =
                "SELECT COUNT(*) as TOTAL "
                + "FROM CLIENTE C JOIN SITUACAO_CLIENTE S ON C.ID_SITUACAO_CLIENTE = S.ID "
                + "WHERE C.NOME LIKE '" + procurePor + "'";

        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(consultaSQL);
            rs.first();
            Integer totalRegistros = rs.getInt("TOTAL");

            if (totalRegistros > 0) {
                List<ClienteVO> listaCliente = new ArrayList<ClienteVO>();
                consultaSQL =
                        "SELECT C.ID, C.ID_SITUACAO_CLIENTE, C.NOME, S.ID, S.NOME as SITUACAO, C.CPF_CNPJ, "
                        + "C.RG, C.ORGAO_RG, C.INSCRICAO_ESTADUAL, C.INSCRICAO_MUNICIPAL, C.DATA_CADASTRO, C.UF "
                        + "FROM CLIENTE C JOIN SITUACAO_CLIENTE S ON C.ID_SITUACAO_CLIENTE = S.ID "
                        + "WHERE C.NOME LIKE '" + procurePor + "'";

                stm = bd.conectar().createStatement();
                rs = stm.executeQuery(consultaSQL);
                rs.beforeFirst();
                while (rs.next()) {
                    ClienteVO cliente = new ClienteVO();
                    cliente.setSituacaoClienteVO(new SituacaoClienteVO());
                    cliente.setNome(rs.getString("NOME"));
                    cliente.getSituacaoClienteVO().setDescricao(rs.getString("SITUACAO"));
                    cliente.setCPFOuCNPJ(rs.getString("CPF_CNPJ"));
                    cliente.setRG(rs.getString("RG"));
                    cliente.setOrgaoRG(rs.getString("ORGAO_RG"));
                    cliente.setInscricaoMunicipal(rs.getString("INSCRICAO_MUNICIPAL"));
                    cliente.setInscricaoEstadual(rs.getString("INSCRICAO_ESTADUAL"));
                    cliente.setDesde(rs.getDate("DATA_CADASTRO"));
                    cliente.setUf(rs.getString("UF"));
                    cliente.setId(rs.getInt("C.ID"));
                    listaCliente.add(cliente);
                }
                return listaCliente;
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
