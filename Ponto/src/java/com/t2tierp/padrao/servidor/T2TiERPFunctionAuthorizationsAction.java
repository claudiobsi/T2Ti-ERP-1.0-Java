package com.t2tierp.padrao.servidor;

import org.openswing.swing.server.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.openswing.swing.message.receive.java.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.openswing.swing.mdi.java.ApplicationFunction;
import org.openswing.swing.internationalization.java.ResourcesFactory;
import org.openswing.swing.tree.java.OpenSwingTreeNode;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Devolve para a aplicação do lado cliente as autorizações
 * das funções (menus) da aplicação.</p>
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
public class T2TiERPFunctionAuthorizationsAction implements Action {

    public T2TiERPFunctionAuthorizationsAction() {
    }

    /**
     * @return request name
     */
    public final String getRequestName() {
        return "getFunctionAuthorizations";
    }

    /**
     * Business logic to execute.
     */
    public final Response executeCommand(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        //recupera as definições de internacionalização (objeto Resources)...
        ResourcesFactory factory = (ResourcesFactory) context.getAttribute(Controller.RESOURCES_FACTORY);
        String langId = userSessionPars.getLanguageId();

        /**
         * deve ser gerado de forma automática de acordo com as
         * definições do banco de dados.
         */
        DefaultMutableTreeNode root = new OpenSwingTreeNode();
        root.setUserObject("T2Ti ERP");
        DefaultTreeModel model = new DefaultTreeModel(root);

        ApplicationFunction n1 = new ApplicationFunction(factory.getResources(langId).getResource("Ponto Eletrônico"), null);
        ApplicationFunction n11 = new ApplicationFunction(factory.getResources(langId).getResource("Parâmetros"), "pontoParametro", null, "getPontoParametro");
        ApplicationFunction n12 = new ApplicationFunction(factory.getResources(langId).getResource("Horários"), "pontoHorario", null, "getPontoHorario");
        ApplicationFunction n13 = new ApplicationFunction(factory.getResources(langId).getResource("Escala e Turma"), "pontoEscala", null, "getPontoEscala");
        ApplicationFunction n14 = new ApplicationFunction(factory.getResources(langId).getResource("Classificação Jornada"), "pontoClassificacaoJornada", null, "getPontoClassificacaoJornada");
        ApplicationFunction n15 = new ApplicationFunction(factory.getResources(langId).getResource("Abono"), "pontoAbono", null, "getPontoAbono");
        ApplicationFunction n16 = new ApplicationFunction(factory.getResources(langId).getResource("Relógio"), "pontoRelogio", null, "getPontoRelogio");
        ApplicationFunction n17 = new ApplicationFunction(factory.getResources(langId).getResource("Banco de Horas"), "pontoBancoHoras", null, "getPontoBancoHoras");
        ApplicationFunction n18 = new ApplicationFunction(factory.getResources(langId).getResource("Importa Arquivo AFD"), "pontoImportaMarcacao", null, "getPontoImportaMarcacao");
        ApplicationFunction n19 = new ApplicationFunction(factory.getResources(langId).getResource("Geração de Arquivos"), "pontoGeracaoArquivo", null, "getPontoGeracaoArquivo");
        ApplicationFunction n110 = new ApplicationFunction(factory.getResources(langId).getResource("Espelho Ponto Eletrônico"), "pontoEspelho", null, "getPontoEspelho");
        ApplicationFunction n111 = new ApplicationFunction(factory.getResources(langId).getResource("Registrar Marcação"), "pontoRegistraMarcacao", null, "getPontoRegistraMarcacao");

        n1.add(n11);
        n1.add(n12);
        n1.add(n13);
        n1.add(n14);
        n1.add(n15);
        n1.add(n16);
        n1.add(n17);
        n1.add(n18);
        n1.add(n19);
        n1.add(n110);
        n1.add(n111);

        root.add(n1);

        return new VOResponse(model);
    }
}
