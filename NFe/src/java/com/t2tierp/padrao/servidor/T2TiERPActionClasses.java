package com.t2tierp.padrao.servidor;

import com.t2tierp.nfe.servidor.NfeCteReferenciadoGridAction;
import com.t2tierp.nfe.servidor.NfeCupomFiscalReferenciadoGridAction;
import com.t2tierp.nfe.servidor.NfeDetalheAction;
import com.t2tierp.nfe.servidor.NfeDetalheGridAction;
import com.t2tierp.nfe.servidor.NfeDuplicataGridAction;
import com.t2tierp.nfe.servidor.NfeDestinatarioDetalheAction;
import com.t2tierp.nfe.servidor.NfeFaturaDetalheAction;
import com.t2tierp.nfe.servidor.NfeGridAction;
import com.t2tierp.nfe.servidor.NfeLocalEntregaDetalheAction;
import com.t2tierp.nfe.servidor.NfeLocalRetiradaDetalheAction;
import com.t2tierp.nfe.servidor.NfeNfReferenciadaGridAction;
import com.t2tierp.nfe.servidor.NfeProdRuralReferenciadaGridAction;
import com.t2tierp.nfe.servidor.NfeReferenciadaGridAction;
import com.t2tierp.nfe.servidor.NfeTransporteDetalheAction;
import com.t2tierp.nfe.servidor.NfeTransporteReboqueGridAction;
import com.t2tierp.nfe.servidor.NfeTransporteVolumeGridAction;
import com.t2tierp.nfe.servidor.NfeTransporteVolumeLacreGridAction;
import com.t2tierp.nfe.servidor.nfeTributAction;
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
        a = new NfeGridAction(); put(a.getRequestName(), a);
        a = new NfeDetalheAction(); put(a.getRequestName(), a);
        a = new NfeDestinatarioDetalheAction(); put(a.getRequestName(), a);
        a = new NfeDetalheGridAction(); put(a.getRequestName(), a);
        a = new NfeReferenciadaGridAction(); put(a.getRequestName(), a);
        a = new NfeNfReferenciadaGridAction(); put(a.getRequestName(), a);
        a = new NfeCteReferenciadoGridAction(); put(a.getRequestName(), a);
        a = new NfeProdRuralReferenciadaGridAction(); put(a.getRequestName(), a);
        a = new NfeCupomFiscalReferenciadoGridAction(); put(a.getRequestName(), a);
        a = new NfeLocalEntregaDetalheAction(); put(a.getRequestName(), a);
        a = new NfeLocalRetiradaDetalheAction(); put(a.getRequestName(), a);
        a = new NfeTransporteDetalheAction(); put(a.getRequestName(), a);
        a = new NfeTransporteReboqueGridAction(); put(a.getRequestName(), a);
        a = new NfeTransporteVolumeGridAction(); put(a.getRequestName(), a);
        a = new NfeTransporteVolumeLacreGridAction(); put(a.getRequestName(), a);
        a = new NfeFaturaDetalheAction(); put(a.getRequestName(), a);
        a = new NfeDuplicataGridAction(); put(a.getRequestName(), a);
        a = new nfeTributAction(); put(a.getRequestName(), a);

        /*validacoes e importacoes*/
        a = new ImportaDadosAction(); put(a.getRequestName(), a);
        a = new ValidaDadosAction(); put(a.getRequestName(), a);
    }
}
