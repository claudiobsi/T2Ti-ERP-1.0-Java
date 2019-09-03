package com.t2tierp.cadastros.servidor;

import com.t2tierp.cadastros.empresa.Dados;
import com.t2tierp.cadastros.empresa.Empresa;
import com.t2tierp.cadastros.empresa.Tabela;
import com.t2tierp.cadastros.java.ContatoVO;
import com.t2tierp.padrao.java.Constantes;
import com.t2tierp.padrao.servidor.HibernateUtil;
import com.t2tierp.cadastros.java.EmpresaVO;
import com.t2tierp.cadastros.java.EnderecoVO;
import com.t2tierp.padrao.java.Biblioteca;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
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
 * <p>Description: Classe que realiza a persistência dos dados de EmpresaDetalhe.</p>
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
public class EmpresaDetalheAction implements Action {

    public EmpresaDetalheAction() {
    }

    public String getRequestName() {
        return "empresaDetalheAction";
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
            Criteria criteria = session.createCriteria(EmpresaVO.class);
            criteria.add(Restrictions.eq("id", Integer.valueOf(pk)));

            EmpresaVO empresa = (EmpresaVO) criteria.uniqueResult();

            if (empresa.getImagemLogotipo() != null) {
                File imagem = new File(empresa.getImagemLogotipo());
                if (imagem.exists()) {
                    empresa.setImagem(Biblioteca.getBytesFromFile(imagem));
                }
            }

            return new VOResponse(empresa);
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
            EmpresaVO empresa = (EmpresaVO) pars[1];
            List<ContatoVO> contatos = (Vector) pars[2];
            List<EnderecoVO> enderecos = (Vector) pars[3];

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(EmpresaVO.class);
            criteria.add(Restrictions.eq("cnpj", empresa.getCnpj()));
            if (criteria.uniqueResult() != null) {
                return new ErrorResponse("Cadastro da empresa não permitido. O CNPJ já está cadastrado!");
            }

            if (empresa.getEmpresa().getId() == null) {
                empresa.setEmpresa(null);
            }

            if (empresa.getSindicato().getId() == null) {
                empresa.setSindicato(null);
            }

            if (empresa.getFpas().getId() == null) {
                empresa.setFpas(null);
            }

            if (empresa.getContador().getId() == null) {
                empresa.setContador(null);
            }

            if (empresa.getImagem() != null) {
                String caminhoArquivo = context.getRealPath("/imagens")
                        + System.getProperty("file.separator")
                        + "empresa"
                        + System.getProperty("file.separator")
                        + empresa.getCnpj() + ".jpg";
                empresa.setImagemLogotipo(caminhoArquivo);
                Biblioteca.salvaArquivo(caminhoArquivo, empresa.getImagem());
            }

            session.save(empresa);

            for (int i = 0; i < contatos.size(); i++) {
                contatos.get(i).setEmpresa(empresa);
                session.save(contatos.get(i));
            }

            for (int i = 0; i < enderecos.size(); i++) {
                enderecos.get(i).setEmpresa(empresa);
                session.save(enderecos.get(i));
            }

            //dados padrões
            InputStream arquivoXml = this.getClass().getResourceAsStream("/com/t2tierp/cadastros/empresa/empresa.xml");
            JAXBContext jc = JAXBContext.newInstance("com.t2tierp.cadastros.empresa");
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Empresa dadosEmpresa = (Empresa) unmarshaller.unmarshal(arquivoXml);
            List<Tabela> tabelas = dadosEmpresa.getTabelas().getTabela();
            List<Dados> dados;
            String sql;
            Query query;
            for (int i = 0; i < tabelas.size(); i++) {
                dados = tabelas.get(i).getDados();
                for (int j = 0; j < dados.size(); j++) {
                    sql = "INSERT INTO " + tabelas.get(i).getNome() + " (ID_EMPRESA, "
                            + dados.get(j).getCampo1() + ", " + dados.get(j).getCampo2() + ") "
                            + "VALUES (" + empresa.getId() + ", '" + dados.get(j).getValor1() + "', '" + dados.get(j).getValor2() + "')";
                    query = session.createSQLQuery(sql);
                    query.executeUpdate();
                }
            }

            session.getTransaction().commit();

            return new VOResponse(empresa);
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
            EmpresaVO empresa = (EmpresaVO) pars[2];
            List<ContatoVO> contatos = (Vector) pars[3];
            List<EnderecoVO> enderecos = (Vector) pars[4];

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(EmpresaVO.class);
            criteria.add(Restrictions.eq("cnpj", empresa.getCnpj()));
            criteria.add(Restrictions.ne("id", empresa.getId()));
            if (criteria.uniqueResult() != null) {
                return new ErrorResponse("Cadastro da empresa não permitido. O CNPJ já está cadastrado!");
            }

            if (empresa.getEmpresa().getId() == null) {
                empresa.setEmpresa(null);
            }

            if (empresa.getSindicato().getId() == null) {
                empresa.setSindicato(null);
            }

            if (empresa.getFpas().getId() == null) {
                empresa.setFpas(null);
            }

            if (empresa.getContador().getId() == null) {
                empresa.setContador(null);
            }

            if (empresa.getImagem() != null) {
                String caminhoArquivo = context.getRealPath("/imagens")
                        + System.getProperty("file.separator")
                        + "empresa"
                        + System.getProperty("file.separator")
                        + empresa.getCnpj() + ".jpg";
                empresa.setImagemLogotipo(caminhoArquivo);
                Biblioteca.salvaArquivo(caminhoArquivo, empresa.getImagem());
            }

            session.update(empresa);

            String sqlExcluir = "delete from CONTATO where ID not in (0";
            for (int i = 0; i < contatos.size(); i++) {
                contatos.get(i).setEmpresa(empresa);
                session.saveOrUpdate(contatos.get(i));
                sqlExcluir += "," + contatos.get(i).getId();
            }
            if (!contatos.isEmpty()) {
                sqlExcluir += ") and ID_EMPRESA = :id";
                Query query = session.createSQLQuery(sqlExcluir);
                query.setInteger("id", empresa.getId());
                query.executeUpdate();
            }

            sqlExcluir = "delete from ENDERECO where ID not in (0";
            for (int i = 0; i < enderecos.size(); i++) {
                enderecos.get(i).setEmpresa(empresa);
                session.saveOrUpdate(enderecos.get(i));
                sqlExcluir += "," + enderecos.get(i).getId();
            }
            if (!enderecos.isEmpty()) {
                sqlExcluir += ") and ID_EMPRESA = :id";
                Query query = session.createSQLQuery(sqlExcluir);
                query.setInteger("id", empresa.getId());
                query.executeUpdate();
            }

            session.getTransaction().commit();

            return new VOResponse(empresa);
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
