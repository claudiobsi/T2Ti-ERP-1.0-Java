package com.t2tierp.padrao.cliente;

import com.t2tierp.sintegra.cliente.SintegraController;
import org.openswing.swing.mdi.client.*;

public class Fachada implements ClientFacade {

    public Fachada() {
    }

    public void getSintegra() {
        new SintegraController();
    }

}
