/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Regras de negócio/persistência da Impressora.</p>
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
import com.t2tierp.pafecf.vo.ImpressoraVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImpressoraController {

    String consultaSQL;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    AcessoBanco bd = new AcessoBanco();

    public ImpressoraVO pegaImpressora(Integer pId) {
        ImpressoraVO impressora = new ImpressoraVO();
        consultaSQL =
                "select * from ECF_IMPRESSORA where ID=" + pId;
        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(consultaSQL);
            rs.beforeFirst();
            if (rs.next()) {
                impressora.setId(rs.getInt("ID"));
                impressora.setSerie(rs.getString("SERIE"));
                impressora.setTipo(rs.getString("TIPO"));
                impressora.setMarca(rs.getString("MARCA"));
                impressora.setModelo(rs.getString("MODELO"));
                impressora.setMFD(rs.getString("MFD"));
                return impressora;
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

    public List<ImpressoraVO> tabelaImpressora() {
        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery("select count(*) as TOTAL from ECF_IMPRESSORA");
            rs.first();
            Integer totalRegistros = rs.getInt("TOTAL");

            if (totalRegistros > 0) {
                List<ImpressoraVO> listaImpressora = new ArrayList<ImpressoraVO>();
                consultaSQL = "select * from ECF_IMPRESSORA";

                stm = bd.conectar().createStatement();
                rs = stm.executeQuery(consultaSQL);
                rs.beforeFirst();
                while (rs.next()) {
                    ImpressoraVO impressora = new ImpressoraVO();
                    impressora.setId(rs.getInt("ID"));
                    impressora.setSerie(rs.getString("SERIE"));
                    impressora.setTipo(rs.getString("TIPO"));
                    impressora.setMarca(rs.getString("MARCA"));
                    impressora.setModelo(rs.getString("MODELO"));
                    impressora.setMFD(rs.getString("MFD"));
                    impressora.setIdentificacao(rs.getString("identificacao"));
                    listaImpressora.add(impressora);
                }
                return listaImpressora;
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
