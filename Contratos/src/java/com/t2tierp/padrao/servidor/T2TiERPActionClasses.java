package com.t2tierp.padrao.servidor;

import com.t2tierp.contratos.servidor.ContratoDetalheAction;
import com.t2tierp.contratos.servidor.ContratoGridAction;
import com.t2tierp.contratos.servidor.ContratoHistFaturamentoGridAction;
import com.t2tierp.contratos.servidor.ContratoHistoricoReajusteGridAction;
import com.t2tierp.contratos.servidor.ContratoPrevFaturamentoGridAction;
import com.t2tierp.contratos.servidor.ContratoSolicitacaoServicoDetalheAction;
import com.t2tierp.contratos.servidor.ContratoSolicitacaoServicoGridAction;
import com.t2tierp.contratos.servidor.ContratoTemplateDetalheAction;
import com.t2tierp.contratos.servidor.ContratoTemplateGridAction;
import com.t2tierp.contratos.servidor.ContratoTipoServicoDetalheAction;
import com.t2tierp.contratos.servidor.ContratoTipoServicoGridAction;
import com.t2tierp.contratos.servidor.TipoContratoDetalheAction;
import com.t2tierp.contratos.servidor.TipoContratoGridAction;
import org.openswing.swing.server.ActionsCollection;
import org.openswing.swing.server.Action;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Mapeia todas as ações tomadas no lado do servidor.</p>
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
public class T2TiERPActionClasses extends ActionsCollection {

    public T2TiERPActionClasses() {
        Action a = null;

        //infra
        a = new T2TiERPButtonAuthorizationsAction(); put(a.getRequestName(), a);
        a = new T2TiERPFunctionAuthorizationsAction(); put(a.getRequestName(), a);
        a = new UserLoginAction(); put(a.getRequestName(), a);
        a = new T2TiERPContainerAction(); put(a.getRequestName(), a);

        /*actions do módulo */
        a = new ContratoTipoServicoGridAction(); put(a.getRequestName(), a);
        a = new ContratoTipoServicoDetalheAction(); put(a.getRequestName(), a);
        a = new TipoContratoGridAction(); put(a.getRequestName(), a);
        a = new TipoContratoDetalheAction(); put(a.getRequestName(), a);
        a = new ContratoTemplateGridAction(); put(a.getRequestName(), a);
        a = new ContratoTemplateDetalheAction(); put(a.getRequestName(), a);
        a = new ContratoSolicitacaoServicoGridAction(); put(a.getRequestName(), a);
        a = new ContratoSolicitacaoServicoDetalheAction(); put(a.getRequestName(), a);
        a = new ContratoHistFaturamentoGridAction(); put(a.getRequestName(), a);
        a = new ContratoHistoricoReajusteGridAction(); put(a.getRequestName(), a);
        a = new ContratoPrevFaturamentoGridAction(); put(a.getRequestName(), a);
        a = new ContratoGridAction(); put(a.getRequestName(), a);
        a = new ContratoDetalheAction(); put(a.getRequestName(), a);

        //modulo ged
        try {
            a = (Action) Class.forName("com.t2tierp.ged.servidor.GedDocumentoGridAction").newInstance();
            put(a.getRequestName(), a);

            a = (Action) Class.forName("com.t2tierp.ged.servidor.GedDocumentoDetalheAction").newInstance();
            put(a.getRequestName(), a);
        } catch(Exception e){
            e.printStackTrace();
        }

        /*validacoes e importacoes*/
        a = new ImportaDadosAction(); put(a.getRequestName(), a);
        a = new ValidaDadosAction(); put(a.getRequestName(), a);
    }
}
