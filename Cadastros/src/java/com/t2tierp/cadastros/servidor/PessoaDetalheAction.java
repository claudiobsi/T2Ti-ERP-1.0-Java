package com.t2tierp.cadastros.servidor;

import com.t2tierp.cadastros.java.ContatoVO;
import com.t2tierp.cadastros.java.EmpresaPessoaVO;
import com.t2tierp.cadastros.java.EmpresaVO;
import com.t2tierp.cadastros.java.EnderecoVO;
import com.t2tierp.cadastros.java.PessoaFisicaVO;
import com.t2tierp.cadastros.java.PessoaJuridicaVO;
import com.t2tierp.padrao.java.Constantes;
import com.t2tierp.padrao.servidor.HibernateUtil;
import com.t2tierp.cadastros.java.PessoaVO;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.server.Action;
import org.openswing.swing.server.UserSessionParameters;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Classe que realiza a persistência dos dados de PessoaDetalhe.</p>
 *
 * <p>The MIT License</p>
 *
 * <p>Copyright: Copyright (C) 2010 T2Ti.COM
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
 *        The author may be contacted at:
 *            t2ti.com@gmail.com</p>
 *
 * @author Claudio de Barros (t2ti.com@gmail.com)
 * @version 1.0
 */
public class PessoaDetalheAction implements Action {

    public PessoaDetalheAction() {
    }

    public String getRequestName() {
        return "pessoaDetalheAction";
    }

    public Response executeCommand(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Object[] pars = (Object[]) inputPar;
        Integer acao = (Integer) pars[0];

        switch (acao) {
            case Constantes.LOAD: {
                return load(inputPar, userSessionPars, request, response, userSession, context);
            }
            case Constantes.INSERT: {
                return insert(inputPar, userSessionPars, request, response, userSession, context);
            }
            case Constantes.UPDATE: {
                return update(inputPar, userSessionPars, request, response, userSession, context);
            }
            case Constantes.DELETE: {
                return delete(inputPar, userSessionPars, request, response, userSession, context);
            }
        }
        return null;
    }

    private Response load(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        Object[] pars = (Object[]) inputPar;
        String pk = (String) pars[1];

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(PessoaVO.class);
            criteria.add(Restrictions.eq("id", Integer.valueOf(pk)));

            PessoaVO pessoa = (PessoaVO) criteria.uniqueResult();

            return new VOResponse(pessoa);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception ex1) {
            }
        }
    }

    public Response insert(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        try {
            Object[] pars = (Object[]) inputPar;
            PessoaVO pessoa = (PessoaVO) pars[1];
            EmpresaVO empresa = (EmpresaVO) pars[2];
            PessoaFisicaVO pessoaFisica = (PessoaFisicaVO) pars[3];
            PessoaJuridicaVO pessoaJuridica = (PessoaJuridicaVO) pars[4];
            List<ContatoVO> listaContato = (Vector) pars[5];
            List<EnderecoVO> listaEndereco = (Vector) pars[6];

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            if (pessoa.getTipo().equals("F")) {
                Criteria criteria = session.createCriteria(PessoaFisicaVO.class);
                criteria.add(Restrictions.eq("cpf", pessoaFisica.getCpf()));
                if (criteria.uniqueResult() != null) {
                    throw new Exception("CPF já cadastrado na base.");
                }
            } else {
                Criteria criteria = session.createCriteria(PessoaJuridicaVO.class);
                criteria.add(Restrictions.eq("cnpj", pessoaJuridica.getCnpj()));
                if (criteria.uniqueResult() != null) {
                    throw new Exception("CNPJ já cadastrado na base.");
                }
            }

            session.save(pessoa);

            if (pessoa.getTipo().equals("F")) {
                pessoaFisica.setPessoa(pessoa);
                session.save(pessoaFisica);
                pessoa.setPessoaFisica(pessoaFisica);
            } else {
                pessoaJuridica.setPessoa(pessoa);
                session.save(pessoaJuridica);
                pessoa.setPessoaJuridica(pessoaJuridica);
            }

            EmpresaPessoaVO empresaPessoa = new EmpresaPessoaVO();
            empresaPessoa.setEmpresa(empresa);
            empresaPessoa.setPessoa(pessoa);
            empresaPessoa.setResponsavelLegal("N");
            session.save(empresaPessoa);

            for (int i = 0; i < listaContato.size(); i++) {
                listaContato.get(i).setPessoa(pessoa);
                session.save(listaContato.get(i));
            }

            for (int i = 0; i < listaEndereco.size(); i++) {
                listaEndereco.get(i).setPessoa(pessoa);
                session.save(listaEndereco.get(i));
            }

            session.getTransaction().commit();

            return new VOResponse(pessoa);
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
        }
    }

    public Response update(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        try {
            Object[] pars = (Object[]) inputPar;
            PessoaVO pessoa = (PessoaVO) pars[2];
            PessoaFisicaVO pessoaFisica = (PessoaFisicaVO) pars[3];
            PessoaJuridicaVO pessoaJuridica = (PessoaJuridicaVO) pars[4];
            List<ContatoVO> listaContato = (Vector) pars[5];
            List<EnderecoVO> listaEndereco = (Vector) pars[6];

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            if (pessoa.getTipo().equals("F")) {
                Criteria criteria = session.createCriteria(PessoaFisicaVO.class);
                criteria.add(Restrictions.eq("cpf", pessoaFisica.getCpf()));
                criteria.add(Restrictions.ne("pessoa", pessoa));
                if (criteria.uniqueResult() != null) {
                    throw new Exception("CPF já cadastrado na base.");
                }
            } else {
                Criteria criteria = session.createCriteria(PessoaJuridicaVO.class);
                criteria.add(Restrictions.eq("cnpj", pessoaJuridica.getCnpj()));
                criteria.add(Restrictions.ne("pessoa", pessoa));
                if (criteria.uniqueResult() != null) {
                    throw new Exception("CNPJ já cadastrado na base.");
                }
            }

            if (pessoa.getTipo().equals("F")) {
                pessoa.setPessoaFisica(pessoaFisica);
            } else {
                pessoa.setPessoaJuridica(pessoaJuridica);
            }

            session.update(pessoa);

            if (pessoa.getTipo().equals("F")) {
                session.update(pessoaFisica);
            } else {
                session.update(pessoaJuridica);
            }

            //CONTATOS
            String sqlExcluir = "delete from CONTATO where ID not in (0";
            for (int i = 0; i < listaContato.size(); i++) {
                listaContato.get(i).setPessoa(pessoa);
                session.saveOrUpdate(listaContato.get(i));
                sqlExcluir += "," + listaContato.get(i).getId();
            }
            if (!listaContato.isEmpty()) {
                sqlExcluir += ") and ID_PESSOA = :id";
                Query query = session.createSQLQuery(sqlExcluir);
                query.setInteger("id", pessoa.getId());
                query.executeUpdate();
            } else {
                sqlExcluir = "delete from CONTATO where ID_PESSOA = :id";
                Query query = session.createSQLQuery(sqlExcluir);
                query.setInteger("id", pessoa.getId());
                query.executeUpdate();
            }

            //ENDERECOS
            sqlExcluir = "delete from ENDERECo where ID not in (0";
            for (int i = 0; i < listaEndereco.size(); i++) {
                listaEndereco.get(i).setPessoa(pessoa);
                session.saveOrUpdate(listaEndereco.get(i));
                sqlExcluir += "," + listaEndereco.get(i).getId();
            }
            if (!listaEndereco.isEmpty()) {
                sqlExcluir += ") and ID_PESSOA = :id";
                Query query = session.createSQLQuery(sqlExcluir);
                query.setInteger("id", pessoa.getId());
                query.executeUpdate();
            } else {
                sqlExcluir = "delete from ENDERECO where ID_PESSOA = :id";
                Query query = session.createSQLQuery(sqlExcluir);
                query.setInteger("id", pessoa.getId());
                query.executeUpdate();
            }

            session.getTransaction().commit();

            return new VOResponse(pessoa);
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
        }
    }

    public Response delete(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        return null;
    }
}
