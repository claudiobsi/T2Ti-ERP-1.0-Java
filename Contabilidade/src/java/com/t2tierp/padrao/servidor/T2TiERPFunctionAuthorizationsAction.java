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

        ApplicationFunction n11 = new ApplicationFunction(factory.getResources(langId).getResource("Cadastros"), null);
        ApplicationFunction n111 = new ApplicationFunction(factory.getResources(langId).getResource("Registro Cartório"), "registroCartorio", null, "getRegistroCartorio");
        ApplicationFunction n112 = new ApplicationFunction(factory.getResources(langId).getResource("Parâmetros"), "parametros", null, "getParametros");
        ApplicationFunction n113 = new ApplicationFunction(factory.getResources(langId).getResource("Índices"), "indices", null, "getIndices");
        ApplicationFunction n114 = new ApplicationFunction(factory.getResources(langId).getResource("Históricos"), "historico", null, "getHistorico");
        ApplicationFunction n115 = new ApplicationFunction(factory.getResources(langId).getResource("AIDF/AIMDF"), "aidfAimdf", null, "getAidfAimdf");
        ApplicationFunction n116 = new ApplicationFunction(factory.getResources(langId).getResource("FAP"), "fap", null, "getFap");

        ApplicationFunction n12 = new ApplicationFunction(factory.getResources(langId).getResource("Plano de Contas"), null);
        ApplicationFunction n121 = new ApplicationFunction(factory.getResources(langId).getResource("Plano Contas"), "planoContas", null, "getPlanoContas");
        ApplicationFunction n122 = new ApplicationFunction(factory.getResources(langId).getResource("Plano Contas SPED"), "planoContasRefSped", null, "getPlanoContasRefSped");
        ApplicationFunction n123 = new ApplicationFunction(factory.getResources(langId).getResource("Conta Contábil"), "contaContabil", null, "getContaContabil");

        ApplicationFunction n13 = new ApplicationFunction(factory.getResources(langId).getResource("Lançamentos"), null);
        ApplicationFunction n131 = new ApplicationFunction(factory.getResources(langId).getResource("Fechamento"), "fechamento", null, "getFechamento");
        ApplicationFunction n132 = new ApplicationFunction(factory.getResources(langId).getResource("Lançamento Padrão"), "lancamentoPadrao", null, "getLancamentoPadrao");
        ApplicationFunction n133 = new ApplicationFunction(factory.getResources(langId).getResource("Lançamento em Lote"), "lancamentoLote", null, "getLancamentoLote");
        ApplicationFunction n134 = new ApplicationFunction(factory.getResources(langId).getResource("Lançamento Programado"), "lancamentoProgramado", null, "getLancamentoProgramado");
        ApplicationFunction n135 = new ApplicationFunction(factory.getResources(langId).getResource("Lançamento Orçado"), "lancamentoOrcado", null, "getLancamentoOrcado");
        ApplicationFunction n136 = new ApplicationFunction(factory.getResources(langId).getResource("Lançamento Contabil"), "lancamentoContabil", null, "getLancamentoContabil");

        ApplicationFunction n14 = new ApplicationFunction(factory.getResources(langId).getResource("Demonstrativos"), null);
        ApplicationFunction n141 = new ApplicationFunction(factory.getResources(langId).getResource("DRE"), "dre", null, "getDre");
        ApplicationFunction n142 = new ApplicationFunction(factory.getResources(langId).getResource("DFC"), "dfc", null, "getDfc");
        ApplicationFunction n143 = new ApplicationFunction(factory.getResources(langId).getResource("Balanço Patrimonial"), "balancoPatrimonial", null, "getBalancoPatrimonial");
        ApplicationFunction n144 = new ApplicationFunction(factory.getResources(langId).getResource("Encerramento Exercício"), "encerramentoExercicio", null, "getEncerramentoExercicio");

        ApplicationFunction n15 = new ApplicationFunction(factory.getResources(langId).getResource("Livros Contábeis"), null);
        ApplicationFunction n151 = new ApplicationFunction(factory.getResources(langId).getResource("Livros e Termos"), "livrosTermos", null, "getLivrosTermos");
        ApplicationFunction n152 = new ApplicationFunction(factory.getResources(langId).getResource("Emissão de Livros"), "livroContabil", null, "getLivroContabil");

        n1.add(n11);
        n1.add(n12);
        n1.add(n13);
        n1.add(n14);
        n1.add(n15);

        n11.add(n111);
        n11.add(n112);
        n11.add(n113);
        n11.add(n114);
        n11.add(n115);
        n11.add(n116);

        n12.add(n121);
        n12.add(n122);
        n12.add(n123);

        n13.add(n131);
        n13.add(n132);
        n13.add(n133);
        n13.add(n134);
        n13.add(n135);
        n13.add(n136);

        n14.add(n141);
        n14.add(n142);
        n14.add(n143);
        n14.add(n144);

        n15.add(n151);
        n15.add(n152);

        root.add(n1);

        return new VOResponse(model);
    }
}
