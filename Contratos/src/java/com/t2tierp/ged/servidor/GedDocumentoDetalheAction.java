package com.t2tierp.ged.servidor;

import com.t2tierp.cadastros.java.UsuarioVO;
import com.t2tierp.ged.java.ArquivoVO;
import com.t2tierp.padrao.java.Constantes;
import com.t2tierp.padrao.servidor.HibernateUtil;
import com.t2tierp.ged.java.GedDocumentoVO;
import com.t2tierp.ged.java.GedVersaoDocumentoVO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.server.Action;
import org.openswing.swing.server.UserSessionParameters;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Classe que realiza a persistência dos dados de GedDocumentoDetalhe.</p>
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
public class GedDocumentoDetalheAction implements Action {

    public GedDocumentoDetalheAction() {
    }

    public String getRequestName() {
        return "gedDocumentoDetalheAction";
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
                return integracao(inputPar, userSessionPars, request, response, userSession, context);
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
            Criteria criteria = session.createCriteria(GedDocumentoVO.class);
            criteria.add(Restrictions.eq("id", Integer.valueOf(pk)));
            GedDocumentoVO gedDocumento = (GedDocumentoVO) criteria.uniqueResult();

            criteria = session.createCriteria(GedVersaoDocumentoVO.class);
            criteria.add(Restrictions.eq("gedDocumento", gedDocumento));
            criteria.addOrder(Order.desc("versao"));
            criteria.setMaxResults(1);
            GedVersaoDocumentoVO gedVersaoDocumento = (GedVersaoDocumentoVO) criteria.uniqueResult();

            File file = new File(gedVersaoDocumento.getCaminho());
            ArquivoVO arquivo = new ArquivoVO();
            arquivo.setFile(getBytesFromFile(file));
            arquivo.setExtensao(getExtensaoArquivo(gedVersaoDocumento.getCaminho()));
            arquivo.setHash(gedVersaoDocumento.getHashArquivo());

            gedDocumento.setArquivo(arquivo);

            return new VOResponse(gedDocumento);
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
            GedDocumentoVO gedDocumento = (GedDocumentoVO) pars[1];
            UsuarioVO usuario = (UsuarioVO) pars[2];

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            //salva arquivo relacionado ao documento
            String caminhoArquivo = context.getRealPath("/ged") + System.getProperty("file.separator") + gedDocumento.getArquivo().getHash() + gedDocumento.getArquivo().getExtensao();
            File file = new File(caminhoArquivo);
            if (file.createNewFile()) {
                salvaArquivo(caminhoArquivo, gedDocumento.getArquivo().getFile());
            }

            //se o documento for assinado, salva a assinatura
            if (gedDocumento.getAssinado().equals("S")) {
                String caminhoAssinatura = context.getRealPath("/ged") + System.getProperty("file.separator") + gedDocumento.getArquivo().getHash();
                File fileAssinatura = new File(caminhoAssinatura);
                if (fileAssinatura.createNewFile()) {
                    salvaArquivo(caminhoAssinatura, gedDocumento.getArquivo().getAssinatura());
                }
            }

            session.save(gedDocumento);

            //salva os dados da versao do documento
            //Timestamp dataAtual = new Timestamp(new Date().getTime());
            Date dataAtual = new Date();
            GedVersaoDocumentoVO gedVersaoDocumento = new GedVersaoDocumentoVO();
            gedVersaoDocumento.setAcao("I");
            gedVersaoDocumento.setCaminho(caminhoArquivo);
            gedVersaoDocumento.setDataHora(dataAtual);
            gedVersaoDocumento.setGedDocumento(gedDocumento);
            gedVersaoDocumento.setHashArquivo(gedDocumento.getArquivo().getHash());
            gedVersaoDocumento.setColaborador(usuario.getColaborador());
            gedVersaoDocumento.setVersao(1);

            session.save(gedVersaoDocumento);

            session.getTransaction().commit();

            return new VOResponse(gedDocumento);
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
        }
    }

    public Response update(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        try {
            Object[] pars = (Object[]) inputPar;
            GedDocumentoVO gedDocumento = (GedDocumentoVO) pars[2];
            UsuarioVO usuario = (UsuarioVO) pars[3];

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            //salva arquivo relacionado ao documento
            String caminhoArquivo = context.getRealPath("/ged") + System.getProperty("file.separator") + gedDocumento.getArquivo().getHash() + gedDocumento.getArquivo().getExtensao();
            File file = new File(caminhoArquivo);
            if (file.createNewFile()) {
                salvaArquivo(caminhoArquivo, gedDocumento.getArquivo().getFile());
            }

            //se o documento for assinado, salva a assinatura
            if (gedDocumento.getAssinado().equals("S")) {
                String caminhoAssinatura = context.getRealPath("/ged") + System.getProperty("file.separator") + gedDocumento.getArquivo().getHash();
                File fileAssinatura = new File(caminhoAssinatura);
                if (fileAssinatura.createNewFile()) {
                    salvaArquivo(caminhoAssinatura, gedDocumento.getArquivo().getAssinatura());
                }
            }

            session.update(gedDocumento);

            Criteria criteria = session.createCriteria(GedVersaoDocumentoVO.class);
            criteria.add(Restrictions.eq("gedDocumento", gedDocumento));
            criteria.addOrder(Order.desc("versao"));
            criteria.setMaxResults(1);
            GedVersaoDocumentoVO gedVersaoDocumento = (GedVersaoDocumentoVO) criteria.uniqueResult();

            //se o hash do arquivo mudar, será salvo nova versao do arquivo
            if (!gedVersaoDocumento.getHashArquivo().equals(gedDocumento.getArquivo().getHash())) {
                Date dataAtual = new Date();
                GedVersaoDocumentoVO novaVersao = new GedVersaoDocumentoVO();
                novaVersao.setAcao("A");
                novaVersao.setCaminho(caminhoArquivo);
                novaVersao.setDataHora(dataAtual);
                novaVersao.setGedDocumento(gedDocumento);
                novaVersao.setHashArquivo(gedDocumento.getArquivo().getHash());
                novaVersao.setColaborador(usuario.getColaborador());
                novaVersao.setVersao(gedVersaoDocumento.getVersao() + 1);

                session.save(novaVersao);
            }

            session.getTransaction().commit();

            return new VOResponse(gedDocumento);
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
        }
    }

    public Response delete(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        try {
            Object[] pars = (Object[]) inputPar;
            GedDocumentoVO gedDocumento = (GedDocumentoVO) pars[1];
            UsuarioVO usuario = (UsuarioVO) pars[2];

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            gedDocumento.setDataExclusao(new Date());
            session.update(gedDocumento);

            Criteria criteria = session.createCriteria(GedVersaoDocumentoVO.class);
            criteria.add(Restrictions.eq("gedDocumento", gedDocumento));
            criteria.addOrder(Order.desc("versao"));
            criteria.setMaxResults(1);
            GedVersaoDocumentoVO gedVersaoDocumento = (GedVersaoDocumentoVO) criteria.uniqueResult();

            Date dataAtual = new Date();
            GedVersaoDocumentoVO novaVersao = new GedVersaoDocumentoVO();
            novaVersao.setAcao("E");
            novaVersao.setCaminho(gedVersaoDocumento.getCaminho());
            novaVersao.setDataHora(dataAtual);
            novaVersao.setGedDocumento(gedDocumento);
            novaVersao.setHashArquivo(gedVersaoDocumento.getHashArquivo());
            novaVersao.setColaborador(usuario.getColaborador());
            novaVersao.setVersao(gedVersaoDocumento.getVersao() + 1);

            session.save(novaVersao);

            session.getTransaction().commit();

            return new VOResponse(gedDocumento);
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
        }
    }

    public Response integracao(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        try {
            Object[] pars = (Object[]) inputPar;
            String nomeDocumento = (String) pars[1];

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(GedDocumentoVO.class);
            criteria.add(Restrictions.eq("nome", nomeDocumento));

            GedDocumentoVO gedDocumento = (GedDocumentoVO) criteria.uniqueResult();

            return new VOResponse(gedDocumento);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
        }
    }

    private byte[] getBytesFromFile(File file) throws Exception {
        //converte o arquio em array de bytes
        InputStream is = new FileInputStream(file);
        // Get the size of the file
        long length = file.length();
        // Create the byte array to hold the data
        byte[] documento = new byte[(int) length];
        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < documento.length
                && (numRead = is.read(documento, offset, documento.length - offset)) >= 0) {
            offset += numRead;
        }
        // Ensure all the bytes have been read in
        if (offset < documento.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }
        // Close the input stream and return bytes
        is.close();
        return documento;
    }

    private String getExtensaoArquivo(String nomeArquivo) {
        int indiceExtensao = nomeArquivo.lastIndexOf(".");
        if (indiceExtensao > -1) {
            return nomeArquivo.substring(indiceExtensao, nomeArquivo.length());
        }
        return "";
    }

    private void salvaArquivo(String caminhoArquivo, byte[] file) throws Exception {
        FileOutputStream out = new FileOutputStream(caminhoArquivo);
        out.write(file);
        out.close();
    }
}
