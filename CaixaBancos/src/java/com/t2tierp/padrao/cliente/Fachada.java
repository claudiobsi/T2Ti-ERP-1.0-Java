package com.t2tierp.padrao.cliente;

import com.t2tierp.financeiro.cliente.FinMovimentoCaixaBancoGridController;
import org.openswing.swing.mdi.client.*;

public class Fachada implements ClientFacade {

    public Fachada() {
    }

    public void getFinMovimentoCaixaBanco() {
        new FinMovimentoCaixaBancoGridController();
    }
}
