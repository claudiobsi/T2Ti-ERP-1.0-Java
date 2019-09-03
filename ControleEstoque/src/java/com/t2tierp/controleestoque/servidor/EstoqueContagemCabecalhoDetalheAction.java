package com.t2tierp.controleestoque.servidor;

import com.t2tierp.cadastros.java.ProdutoSubGrupoVO;
import com.t2tierp.cadastros.java.ProdutoVO;
import com.t2tierp.padrao.java.Constantes;
import com.t2tierp.padrao.servidor.HibernateUtil;
import com.t2tierp.controleestoque.java.EstoqueContagemCabecalhoVO;
import com.t2tierp.controleestoque.java.EstoqueContagemDetalheVO;
import java.math.BigDecimal;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.server.Action;
import org.openswing.swing.server.UserSessionParameters;

/**
* <p>Title: T2Ti ERP</p>
* <p>Description: Classe que realiza a persistência dos dados de EstoqueContagemCabecalhoDetalhe.</p>
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
public class EstoqueContagemCabecalhoDetalheAction implements Action {

    public EstoqueContagemCabecalhoDetalheAction() {
    }

    public String getRequestName() {
        return "estoqueContagemCabecalhoDetalheAction";
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
            case 99: {
                return produtoSubGrupo(inputPar, userSessionPars, request, response, userSession, context);
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
            Criteria criteria = session.createCriteria(EstoqueContagemCabecalhoVO.class);
            criteria.add(Restrictions.eq("id", Integer.valueOf(pk)));

            EstoqueContagemCabecalhoVO estoqueContagemCabecalho = (EstoqueContagemCabecalhoVO) criteria.uniqueResult();

            return new VOResponse(estoqueContagemCabecalho);
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
            EstoqueContagemCabecalhoVO estoqueContagemCabecalho = (EstoqueContagemCabecalhoVO) pars[1];
            List<EstoqueContagemDetalheVO> itensContagem = (Vector) pars[2];

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(estoqueContagemCabecalho);

            for(int i = 0; i < itensContagem.size(); i++) {
                itensContagem.get(i).setEstoqueContagemCabecalho(estoqueContagemCabecalho);
                session.save(itensContagem.get(i));

                if(estoqueContagemCabecalho.getEstoqueAtualizado().equals("S")){
                    itensContagem.get(i).getProduto().setQuantidadeEstoque(itensContagem.get(i).getQuantidadeContada());
                    session.update(itensContagem.get(i).getProduto());
                }
            }

            session.getTransaction().commit();

            return new VOResponse(estoqueContagemCabecalho);
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
            EstoqueContagemCabecalhoVO estoqueContagemCabecalho = (EstoqueContagemCabecalhoVO) pars[2];
            List<EstoqueContagemDetalheVO> itensContagem = (Vector) pars[3];

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(estoqueContagemCabecalho);

            for(int i = 0; i < itensContagem.size(); i++) {
                itensContagem.get(i).setEstoqueContagemCabecalho(estoqueContagemCabecalho);
                session.saveOrUpdate(itensContagem.get(i));

                if(estoqueContagemCabecalho.getEstoqueAtualizado().equals("S")){
                    itensContagem.get(i).getProduto().setQuantidadeEstoque(itensContagem.get(i).getQuantidadeContada());
                    session.update(itensContagem.get(i).getProduto());
                }
            }

            session.getTransaction().commit();

            return new VOResponse(estoqueContagemCabecalho);
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

    public Response produtoSubGrupo(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        Object[] pars = (Object[]) inputPar;
        ProdutoSubGrupoVO produtoSubGrupo = (ProdutoSubGrupoVO) pars[1];

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(ProdutoVO.class);
            criteria.add(Restrictions.eq("produtoSubGrupo", produtoSubGrupo));

            List<ProdutoVO> produtos = criteria.list();

            return new VOListResponse(produtos, false, produtos.size());
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

}
