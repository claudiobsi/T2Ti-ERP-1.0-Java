package com.t2tierp.padrao.cliente;

import com.t2tierp.orcamento.cliente.OrcamentoEmpresarialGridController;
import com.t2tierp.orcamento.cliente.OrcamentoFluxoCaixaGridController;
import com.t2tierp.orcamento.cliente.OrcamentoFluxoCaixaPeriodoGridController;
import com.t2tierp.orcamento.cliente.OrcamentoPeriodoGridController;
import org.openswing.swing.mdi.client.*;

public class Fachada implements ClientFacade {

    public Fachada() {
    }

    public void getOrcamentoPeriodo() {
        new OrcamentoPeriodoGridController();
    }

    public void getOrcamentoFluxoCaixaPeriodo() {
        new OrcamentoFluxoCaixaPeriodoGridController();
    }

    public void getOrcamentoFluxoCaixa() {
        new OrcamentoFluxoCaixaGridController();
    }

    public void getOrcamentoEmpresarial() {
        new OrcamentoEmpresarialGridController();
    }

}
