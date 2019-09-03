/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t2tierp.pafecf.infra;

import com.t2tierp.pafecf.view.Caixa;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JDialog;

/**
 *
 * @author T2Ti
 */
public class MenuFiscalAction extends AbstractAction {

    private JDialog dialog;

    public MenuFiscalAction() {
    }

    public MenuFiscalAction(JDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.dialog != null) {
            Caixa caixa = Caixa.getCaixa();
            caixa.fechaMenus();
            caixa.acionaMenuFiscal();
            this.dialog.dispose();
        }
    }
}
