package com.t2tierp.padrao.cliente;

import com.t2tierp.sped.cliente.SpedContabilGridController;
import com.t2tierp.sped.cliente.SpedFiscalGridController;
import org.openswing.swing.mdi.client.*;

public class Fachada implements ClientFacade {

    public Fachada() {
    }

    public void getSpedContabil(){
        new SpedContabilGridController();
    }

    public void getSpedFiscal(){
        new SpedFiscalGridController();
    }
}
