/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Regras de negócio/persistência do Operador.</p>
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
import com.t2tierp.pafecf.vo.FuncionarioVO;
import com.t2tierp.pafecf.vo.OperadorVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperadorController {

    String consultaSQL;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    AcessoBanco bd = new AcessoBanco();

    public OperadorVO consultaUsuario(String pLogin, String pSenha) {
        OperadorVO operador = new OperadorVO();
        FuncionarioVO funcionario = new FuncionarioVO();
        operador.setFuncionarioVO(funcionario);
        consultaSQL =
                "select O.ID,O.ID_ECF_FUNCIONARIO,O.LOGIN,O.SENHA,F.NIVEL_AUTORIZACAO "
                + "from ECF_OPERADOR O, ECF_FUNCIONARIO F where O.ID_ECF_FUNCIONARIO=F.ID "
                + "AND LOGIN='" + pLogin + "' and SENHA='" + pSenha + "'";
        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(consultaSQL);
            rs.beforeFirst();
            if (rs.next()) {
                operador.setId(rs.getInt("ID"));
                operador.setLogin(rs.getString("LOGIN"));
                operador.setSenha(rs.getString("SENHA"));
                operador.getFuncionarioVO().setId(rs.getInt("ID_ECF_FUNCIONARIO"));
                operador.getFuncionarioVO().setNivelAutorizacao(rs.getString("NIVEL_AUTORIZACAO"));
                return operador;
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
