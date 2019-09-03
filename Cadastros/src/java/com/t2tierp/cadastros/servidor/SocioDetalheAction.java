package com.t2tierp.cadastros.servidor;

import com.t2tierp.cadastros.java.SocioDependenteVO;
import com.t2tierp.cadastros.java.SocioParticipacaoSocietariaVO;
import com.t2tierp.padrao.java.Constantes;
import com.t2tierp.padrao.servidor.HibernateUtil;
import com.t2tierp.cadastros.java.SocioVO;
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
 * <p>Description: Classe que realiza a persistência dos dados de SocioDetalhe.</p>
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
public class SocioDetalheAction implements Action {

    public SocioDetalheAction() {
    }

    public String getRequestName() {
        return "socioDetalheAction";
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
            Criteria criteria = session.createCriteria(SocioVO.class);
            criteria.add(Restrictions.eq("id", Integer.valueOf(pk)));

            SocioVO socio = (SocioVO) criteria.uniqueResult();

            return new VOResponse(socio);
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
            SocioVO socio = (SocioVO) pars[1];
            List<SocioDependenteVO> dependentes = (Vector) pars[2];
            List<SocioParticipacaoSocietariaVO> participacaoSocietaria = (Vector) pars[3];

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(socio);

            for (int i = 0; i < dependentes.size(); i++) {
                dependentes.get(i).setSocio(socio);
                session.save(dependentes.get(i));
            }

            for (int i = 0; i < participacaoSocietaria.size(); i++) {
                participacaoSocietaria.get(i).setSocio(socio);
                session.save(participacaoSocietaria.get(i));
            }

            session.getTransaction().commit();

            return new VOResponse(socio);
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
            SocioVO socio = (SocioVO) pars[2];
            List<SocioDependenteVO> dependentes = (Vector) pars[3];
            List<SocioParticipacaoSocietariaVO> participacaoSocietaria = (Vector) pars[4];

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(socio);

            String sqlExcluir = "delete from SOCIO_DEPENDENTE where ID not in (0";
            for (int i = 0; i < dependentes.size(); i++) {
                dependentes.get(i).setSocio(socio);
                session.save(dependentes.get(i));
                sqlExcluir += "," + dependentes.get(i).getId();
            }
            if (!dependentes.isEmpty()) {
                sqlExcluir += ") and ID_SOCIO = :id";
                Query query = session.createSQLQuery(sqlExcluir);
                query.setInteger("id", socio.getId());
                query.executeUpdate();
            }

            sqlExcluir = "delete from SOCIO_PARTICIPACAO_SOCIETARIA where ID not in (0";
            for (int i = 0; i < participacaoSocietaria.size(); i++) {
                participacaoSocietaria.get(i).setSocio(socio);
                session.save(participacaoSocietaria.get(i));
                sqlExcluir += "," + participacaoSocietaria.get(i).getId();
            }
            if (!participacaoSocietaria.isEmpty()) {
                sqlExcluir += ") and ID_SOCIO = :id";
                Query query = session.createSQLQuery(sqlExcluir);
                query.setInteger("id", socio.getId());
                query.executeUpdate();
            }

            session.getTransaction().commit();

            return new VOResponse(socio);
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
