/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Regras de negócio/persistência da Empresa.</p>
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
import com.t2tierp.pafecf.vo.EmpresaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpresaController {

    String consultaSQL;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    AcessoBanco bd = new AcessoBanco();

    public EmpresaVO pegaEmpresa(Integer pId) {
        EmpresaVO empresa = new EmpresaVO();
        consultaSQL =
                "select * from ECF_EMPRESA where ID=" + pId;
        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(consultaSQL);
            rs.beforeFirst();
            if (rs.next()) {
                empresa.setId(rs.getInt("ID"));
                empresa.setCNPJ(rs.getString("CNPJ"));
                empresa.setInscricaoEstadual(rs.getString("INSCRICAO_ESTADUAL"));
                empresa.setInscricaoMunicipal(rs.getString("INSCRICAO_MUNICIPAL"));
                empresa.setRazaoSocial(rs.getString("RAZAO_SOCIAL"));
                empresa.setNomeFantasia(rs.getString("NOME_FANTASIA"));
                empresa.setDataCadastro(rs.getDate("DATA_CADASTRO"));
                empresa.setEndereco(rs.getString("LOGRADOURO"));
                empresa.setComplemento(rs.getString("COMPLEMENTO"));
                empresa.setBairro(rs.getString("BAIRRO"));
                empresa.setCidade(rs.getString("CIDADE"));
                empresa.setCEP(rs.getString("CEP"));
                empresa.setCodigoMunicipioIBGE(rs.getInt("CODIGO_IBGE_CIDADE"));
                empresa.setFone1(rs.getString("FONE"));
                empresa.setFone2(rs.getString("FAX"));
                empresa.setContato(rs.getString("CONTATO"));
                empresa.setUF(rs.getString("UF"));
                return empresa;
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
}
