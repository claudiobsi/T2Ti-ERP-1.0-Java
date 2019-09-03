package com.t2tierp.conciliacaocontabil.cliente;

import com.t2tierp.cadastros.java.ClienteVO;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.message.send.java.GridParams;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;
import org.openswing.swing.util.client.ClientUtils;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Classe de controle da tela ConciliacaoClienteGrid.</p>
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
public class ConciliacaoClienteGridController extends GridController implements GridDataLocator {

    private ConciliacaoClienteGrid grid;
    private String acaoServidor;

    public ConciliacaoClienteGridController() {
        grid = new ConciliacaoClienteGrid(this);
        acaoServidor = "conciliacaoClienteGridAction";
        MDIFrame.add(grid);
    }

    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        return ClientUtils.getData(acaoServidor, new GridParams(action, startIndex, filteredColumns, currentSortedColumns, currentSortedVersusColumns, otherGridParams));
    }

    @Override
    public void doubleClick(int rowNumber, ValueObject persistentObject) {
        ClienteVO cliente = (ClienteVO) persistentObject;
        if (cliente.getContabilConta() == null) {
            JOptionPane.showMessageDialog(grid, "Cliente sem conta contábil vinculada.", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
        } else {
            new ConciliacaoClienteDetalheController(grid, cliente);
        }
    }
}
