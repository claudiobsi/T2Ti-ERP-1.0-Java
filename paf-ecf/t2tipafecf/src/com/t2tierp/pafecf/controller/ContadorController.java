/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Regras de negócio/persistência do Contador.</p>
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
import com.t2tierp.pafecf.vo.ContadorVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ContadorController {

    String consultaSQL;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    AcessoBanco bd = new AcessoBanco();

    public ContadorVO pegaContador() {
        ContadorVO contador = new ContadorVO();
        consultaSQL =
                "select * from ECF_CONTADOR";
        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(consultaSQL);
            rs.beforeFirst();
            if (rs.next()) {
                contador.setId(rs.getInt("ID"));
                contador.setCPF(rs.getString("CPF"));
                contador.setCNPJ(rs.getString("CNPJ"));
                contador.setNome(rs.getString("NOME"));
                contador.setCRC(rs.getString("INSCRICAO_CRC"));
                contador.setFone(rs.getString("FONE"));
                contador.setFax(rs.getString("FAX"));
                contador.setLogradouro(rs.getString("LOGRADOURO"));
                contador.setNumero(rs.getInt("NUMERO"));
                contador.setComplemento(rs.getString("COMPLEMENTO"));
                contador.setBairro(rs.getString("BAIRRO"));
                contador.setCEP(rs.getString("CEP"));
                contador.setCodigoMunicipio(rs.getInt("CODIGO_MUNICIPIO"));
                contador.setUF(rs.getString("UF"));
                contador.setEmail(rs.getString("EMAIL"));
                return contador;
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
