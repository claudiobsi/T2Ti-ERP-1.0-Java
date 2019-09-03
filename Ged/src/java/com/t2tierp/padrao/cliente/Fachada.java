package com.t2tierp.padrao.cliente;

import com.t2tierp.ged.cliente.GedDocumentoGridController;
import com.t2tierp.ged.cliente.GedTipoDocumentoGridController;
import org.openswing.swing.mdi.client.*;

public class Fachada implements ClientFacade {

    public Fachada() {
    }

    public void getTipoDocumento(){
        new GedTipoDocumentoGridController();
    }

    public void getDocumento(){
        new GedDocumentoGridController();
    }

}
