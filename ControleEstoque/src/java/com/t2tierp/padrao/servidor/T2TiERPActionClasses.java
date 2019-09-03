package com.t2tierp.padrao.servidor;

import com.t2tierp.cadastros.servidor.EstoqueFormacaoPrecoGridAction;
import com.t2tierp.cadastros.servidor.NcmGridAction;
import com.t2tierp.cadastros.servidor.ProdutoDetalheAction;
import com.t2tierp.cadastros.servidor.ProdutoGridAction;
import com.t2tierp.cadastros.servidor.ProdutoGrupoDetalheAction;
import com.t2tierp.cadastros.servidor.ProdutoGrupoGridAction;
import com.t2tierp.cadastros.servidor.ProdutoMarcaDetalheAction;
import com.t2tierp.cadastros.servidor.ProdutoMarcaGridAction;
import com.t2tierp.cadastros.servidor.ProdutoSubGrupoDetalheAction;
import com.t2tierp.cadastros.servidor.ProdutoSubGrupoGridAction;
import com.t2tierp.cadastros.servidor.UnidadeProdutoDetalheAction;
import com.t2tierp.cadastros.servidor.UnidadeProdutoGridAction;
import com.t2tierp.controleestoque.servidor.EntradaNotaDetalheAction;
import com.t2tierp.controleestoque.servidor.EntradaNotaGridAction;
import com.t2tierp.controleestoque.servidor.EstoqueContagemCabecalhoDetalheAction;
import com.t2tierp.controleestoque.servidor.EstoqueContagemCabecalhoGridAction;
import com.t2tierp.controleestoque.servidor.EstoqueContagemDetalheGridAction;
import com.t2tierp.controleestoque.servidor.EstoqueFormacaoPrecoDetalheGridAction;
import com.t2tierp.controleestoque.servidor.EstoqueReajusteCabecalhoDetalheAction;
import com.t2tierp.controleestoque.servidor.EstoqueReajusteCabecalhoGridAction;
import com.t2tierp.controleestoque.servidor.EstoqueReajusteDetalheGridAction;
import com.t2tierp.controleestoque.servidor.FiscalNotaFiscalEntradaDetalheAction;
import com.t2tierp.controleestoque.servidor.NfeCteReferenciadoGridAction;
import com.t2tierp.controleestoque.servidor.NfeCupomFiscalReferenciadoGridAction;
import com.t2tierp.controleestoque.servidor.NfeDetalheGridAction;
import com.t2tierp.controleestoque.servidor.NfeDuplicataGridAction;
import com.t2tierp.controleestoque.servidor.NfeEmitenteDetalheAction;
import com.t2tierp.controleestoque.servidor.NfeFaturaDetalheAction;
import com.t2tierp.controleestoque.servidor.NfeLocalEntregaDetalheAction;
import com.t2tierp.controleestoque.servidor.NfeLocalRetiradaDetalheAction;
import com.t2tierp.controleestoque.servidor.NfeNfReferenciadaGridAction;
import com.t2tierp.controleestoque.servidor.NfeProdRuralReferenciadaGridAction;
import com.t2tierp.controleestoque.servidor.NfeReferenciadaGridAction;
import com.t2tierp.controleestoque.servidor.NfeTransporteDetalheAction;
import com.t2tierp.controleestoque.servidor.NfeTransporteReboqueGridAction;
import com.t2tierp.controleestoque.servidor.NfeTransporteVolumeGridAction;
import com.t2tierp.controleestoque.servidor.NfeTransporteVolumeLacreGridAction;
import com.t2tierp.controleestoque.servidor.RequisicaoInternaCabecalhoDetalheAction;
import com.t2tierp.controleestoque.servidor.RequisicaoInternaCabecalhoGridAction;
import com.t2tierp.controleestoque.servidor.RequisicaoInternaDetalheGridAction;
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
        a = new EntradaNotaGridAction(); put(a.getRequestName(), a);
        a = new EntradaNotaDetalheAction(); put(a.getRequestName(), a);
        a = new NfeEmitenteDetalheAction(); put(a.getRequestName(), a);
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
        a = new FiscalNotaFiscalEntradaDetalheAction(); put(a.getRequestName(), a);
        a = new RequisicaoInternaCabecalhoGridAction(); put(a.getRequestName(), a);
        a = new RequisicaoInternaCabecalhoDetalheAction(); put(a.getRequestName(), a);
        a = new RequisicaoInternaDetalheGridAction(); put(a.getRequestName(), a);
        a = new EstoqueContagemCabecalhoGridAction(); put(a.getRequestName(), a);
        a = new EstoqueContagemCabecalhoDetalheAction(); put(a.getRequestName(), a);
        a = new EstoqueContagemDetalheGridAction(); put(a.getRequestName(), a);
        a = new EstoqueReajusteCabecalhoGridAction(); put(a.getRequestName(), a);
        a = new EstoqueReajusteCabecalhoDetalheAction(); put(a.getRequestName(), a);
        a = new EstoqueReajusteDetalheGridAction(); put(a.getRequestName(), a);
        a = new EstoqueFormacaoPrecoGridAction(); put(a.getRequestName(), a);
        a = new EstoqueFormacaoPrecoDetalheGridAction(); put(a.getRequestName(), a);

        /*actions do módulo Cadastros Base*/
        a = new ProdutoMarcaGridAction(); put(a.getRequestName(), a);
        a = new ProdutoMarcaDetalheAction(); put(a.getRequestName(), a);
        a = new NcmGridAction(); put(a.getRequestName(), a);
        a = new UnidadeProdutoGridAction(); put(a.getRequestName(), a);
        a = new UnidadeProdutoDetalheAction(); put(a.getRequestName(), a);
        a = new ProdutoGrupoGridAction(); put(a.getRequestName(), a);
        a = new ProdutoGrupoDetalheAction(); put(a.getRequestName(), a);
        a = new ProdutoSubGrupoGridAction(); put(a.getRequestName(), a);
        a = new ProdutoSubGrupoDetalheAction(); put(a.getRequestName(), a);
        a = new ProdutoGridAction(); put(a.getRequestName(), a);
        a = new ProdutoDetalheAction(); put(a.getRequestName(), a);

        /*validacoes e importacoes*/
        a = new ImportaDadosAction(); put(a.getRequestName(), a);
        a = new ValidaDadosAction(); put(a.getRequestName(), a);
    }
}
