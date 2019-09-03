package com.t2tierp.padrao.cliente;

import com.t2tierp.contratos.cliente.ContratoGridController;
import com.t2tierp.contratos.cliente.ContratoSolicitacaoServicoGridController;
import com.t2tierp.contratos.cliente.ContratoTemplateGridController;
import com.t2tierp.contratos.cliente.ContratoTipoServicoGridController;
import com.t2tierp.contratos.cliente.TipoContratoGridController;
import org.openswing.swing.mdi.client.*;

public class Fachada implements ClientFacade {

    public Fachada() {
    }

    public void getContratoTipoServico() {
        new ContratoTipoServicoGridController();
    }

    public void getTipoContrato() {
        new TipoContratoGridController();
    }

    public void getContratoTemplate() {
        new ContratoTemplateGridController();
    }

    public void getContratoSolicitacaoServico(){
        new ContratoSolicitacaoServicoGridController();
    }

    public void getContrato(){
        new ContratoGridController();
    }
}
