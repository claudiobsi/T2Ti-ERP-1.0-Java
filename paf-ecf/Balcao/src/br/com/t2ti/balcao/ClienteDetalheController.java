/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.t2ti.balcao;

import br.com.t2ti.principal.HibernateUtil;
import br.com.t2ti.vo.ClienteVO;
import java.util.Date;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.java.Consts;

/**
 * <p>Title: T2Ti Balcao</p>
 * <p>Description: Classe controller do detalhe do cliente.</p>
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
public class ClienteDetalheController extends FormController {

    private ClienteDetalhe clienteDetalhe;
    private ClienteGrid clienteGrid = null;
    private int pk;

    public ClienteDetalheController(ClienteGrid clienteGrid, int pk) {
        this.clienteGrid = clienteGrid;
        this.pk = pk;

        clienteDetalhe = new ClienteDetalhe(this);
        clienteDetalhe.setParentFrame(this.clienteGrid);
        this.clienteGrid.pushFrame(clienteDetalhe);
        MDIFrame.add(clienteDetalhe);

        if (pk != 0) {
            clienteDetalhe.getForm1().setMode(Consts.READONLY);
            clienteDetalhe.getForm1().reload();

        } else {
            clienteDetalhe.getForm1().setMode(Consts.INSERT);
        }
    }

    @Override
    public Response loadData(Class valueObjectClass) {
        Session session = null;
        try {
            String sql = "select CLIENTE from br.com.t2ti.vo.ClienteVO as CLIENTE where CLIENTE.id = " + pk;
            session = HibernateUtil.getSessionFactory().openSession();
            ClienteVO cliente = (ClienteVO) session.createQuery(sql).uniqueResult();
            return new VOResponse(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorResponse("Erro ao buscar os dados do cliente!");
        } finally {
            session.close();
        }
    }

    @Override
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            ClienteVO cliente = (ClienteVO) newPersistentObject;
            cliente.setDataCadastro(new Date());
            session.save(cliente);
            session.getTransaction().commit();
            return new VOResponse(newPersistentObject);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return new ErrorResponse("Erro ao cadastrar o cliente!");
        } finally {
            session.close();
        }
    }

    @Override
    public void afterInsertData() {
        JOptionPane.showMessageDialog(clienteDetalhe, "Cliente cadastrado com sucesso!", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
        clienteDetalhe.dispose();
        clienteGrid.getGrid1().reloadData();
    }

    @Override
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            ClienteVO cliente = (ClienteVO) persistentObject;
            session.update(cliente);
            session.getTransaction().commit();
            return new VOResponse(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return new ErrorResponse("Erro ao salvar os dados do cliente!");
        } finally {
            session.close();
        }
    }

    @Override
    public void afterEditData() {
        JOptionPane.showMessageDialog(clienteDetalhe, "Dados do cliente salvos com sucesso!", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
        clienteDetalhe.dispose();
        clienteGrid.getGrid1().reloadData();
    }

}
