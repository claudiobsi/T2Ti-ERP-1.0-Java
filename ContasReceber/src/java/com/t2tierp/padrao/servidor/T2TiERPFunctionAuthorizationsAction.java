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

        ApplicationFunction n1 = new ApplicationFunction(factory.getResources(langId).getResource("Contabilidade"), null);
        ApplicationFunction n11 = new ApplicationFunction(factory.getResources(langId).getResource("Plano Natureza Financeira"), "planoNaturezaFinanceira", null, "getPlanoNaturezaFinanceira");
        ApplicationFunction n12 = new ApplicationFunction(factory.getResources(langId).getResource("Plano Centro Resultado"), "planoCentroResultado", null, "getPlanoCentroResultado");
        ApplicationFunction n13 = new ApplicationFunction(factory.getResources(langId).getResource("Natureza Financeira"), "naturezaFinanceira", null, "getNaturezaFinanceira");
        ApplicationFunction n14 = new ApplicationFunction(factory.getResources(langId).getResource("Centro Resultado"), "centroResultado", null, "getCentroResultado");

        ApplicationFunction n2 = new ApplicationFunction(factory.getResources(langId).getResource("Financeiro"), null);
        ApplicationFunction n21 = new ApplicationFunction(factory.getResources(langId).getResource("Documento Origem"), "finDocumentoOrigem", null, "getFinDocumentoOrigem");

        ApplicationFunction n3 = new ApplicationFunction(factory.getResources(langId).getResource("Contas a Receber"), null);
        ApplicationFunction n31 = new ApplicationFunction(factory.getResources(langId).getResource("Status Parcela"), "finStatusParcela", null, "getFinStatusParcela");
        ApplicationFunction n32 = new ApplicationFunction(factory.getResources(langId).getResource("Tipo Recebimento"), "finTipoRecebimento", null, "getFinTipoRecebimento");
        ApplicationFunction n33 = new ApplicationFunction(factory.getResources(langId).getResource("Configuração Boleto"), "finConfiguracaoBoleto", null, "getFinConfiguracaoBoleto");
        ApplicationFunction n34 = new ApplicationFunction(factory.getResources(langId).getResource("Lançamento Receber"), "finLancamentoReceber", null, "getFinLancamentoReceber");
        ApplicationFunction n35 = new ApplicationFunction(factory.getResources(langId).getResource("Recebimento"), "finParcelaRecebimento", null, "getFinParcelaRecebimento");

        ApplicationFunction n4 = new ApplicationFunction(factory.getResources(langId).getResource("EDI Bancário"), null);
        ApplicationFunction n41 = new ApplicationFunction(factory.getResources(langId).getResource("Processa Retorno"), "finProcessaArquivoRetorno", null, "getFinProcessaArquivoRetorno");

        n1.add(n11);
        n1.add(n12);
        n1.add(n13);
        n1.add(n14);

        n2.add(n21);

        n3.add(n31);
        n3.add(n32);
        n3.add(n33);
        n3.add(n34);
        n3.add(n35);

        n4.add(n41);

        root.add(n1);
        root.add(n2);
        root.add(n3);
        root.add(n4);

        return new VOResponse(model);
    }
}
