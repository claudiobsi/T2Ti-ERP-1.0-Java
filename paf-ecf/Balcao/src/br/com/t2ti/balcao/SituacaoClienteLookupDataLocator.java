/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.t2ti.balcao;

import br.com.t2ti.principal.HibernateUtil;
import java.util.ArrayList;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.openswing.swing.lookup.client.LookupServerDataLocator;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.util.server.HibernateUtils;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Controller do lookup da situação do cliente.</p>
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
 * @author Claudio de Barros (T2Ti.COM)
 * @version 1.0
 */
public class SituacaoClienteLookupDataLocator extends LookupServerDataLocator {

    public SituacaoClienteLookupDataLocator() {
    }

    @Override
    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType) {
        try {
            String sql = "select SITUACAO_CLIENTE from br.com.t2ti.vo.SituacaoClienteVO as SITUACAO_CLIENTE";
            Session session = HibernateUtil.getSessionFactory().openSession();

            Response res = HibernateUtils.getAllFromQuery(
                    filteredColumns,
                    currentSortedColumns,
                    currentSortedVersusColumns,
                    br.com.t2ti.vo.SituacaoClienteVO.class,
                    sql,
                    new Object[0],
                    new Type[0],
                    "SITUACAO_CLIENTE",
                    HibernateUtil.getSessionFactory(),
                    session);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Response validateCode(String code) {
        try {
            String sql = "select SITUACAO_CLIENTE from br.com.t2ti.vo.SituacaoClienteVO as SITUACAO_CLIENTE where SITUACAO_CLIENTE.id =" + code;
            Session session = HibernateUtil.getSessionFactory().openSession();

            return new VOListResponse(session.createQuery(sql).list(), false, 1);
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorResponse("Erro ao validar!");
        }
    }

}
