package com.t2tierp.padrao.servidor;

import com.t2tierp.contabilidade.servidor.RegistroCartorioDetalheAction;
import com.t2tierp.contabilidade.servidor.RegistroCartorioGridAction;
import com.t2tierp.escritafiscal.servidor.FiscalApuracaoIcmsAction;
import com.t2tierp.escritafiscal.servidor.FiscalLivroDetalheAction;
import com.t2tierp.escritafiscal.servidor.FiscalParametrosDetalheAction;
import com.t2tierp.escritafiscal.servidor.FiscalParametrosGridAction;
import com.t2tierp.escritafiscal.servidor.FiscalTermoGridAction;
import com.t2tierp.escritafiscal.servidor.SimplesNacionalCabecalhoDetalheAction;
import com.t2tierp.escritafiscal.servidor.SimplesNacionalCabecalhoGridAction;
import com.t2tierp.escritafiscal.servidor.SimplesNacionalDetalheGridAction;
import com.t2tierp.vendas.servidor.TipoNotaFiscalDetalheAction;
import com.t2tierp.vendas.servidor.TipoNotaFiscalGridAction;
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
        a = new FiscalParametrosGridAction(); put(a.getRequestName(), a);
        a = new FiscalParametrosDetalheAction(); put(a.getRequestName(), a);
        a = new SimplesNacionalCabecalhoGridAction(); put(a.getRequestName(), a);
        a = new SimplesNacionalCabecalhoDetalheAction(); put(a.getRequestName(), a);
        a = new SimplesNacionalDetalheGridAction(); put(a.getRequestName(), a);
        a = new FiscalLivroDetalheAction(); put(a.getRequestName(), a);
        a = new FiscalLivroDetalheAction(); put(a.getRequestName(), a);
        a = new FiscalTermoGridAction(); put(a.getRequestName(), a);
        a = new FiscalApuracaoIcmsAction(); put(a.getRequestName(), a);

        /*actions do módulo contabilidade*/
        a = new RegistroCartorioGridAction(); put(a.getRequestName(), a);
        a = new RegistroCartorioDetalheAction(); put(a.getRequestName(), a);

        /*actions do módulo vendas*/
        a = new TipoNotaFiscalGridAction(); put(a.getRequestName(), a);
        a = new TipoNotaFiscalDetalheAction(); put(a.getRequestName(), a);

        /*validacoes e importacoes*/
        a = new ImportaDadosAction(); put(a.getRequestName(), a);
        a = new ValidaDadosAction(); put(a.getRequestName(), a);
    }
}
