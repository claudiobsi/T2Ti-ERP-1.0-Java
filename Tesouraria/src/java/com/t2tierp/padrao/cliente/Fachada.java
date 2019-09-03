package com.t2tierp.padrao.cliente;

import com.t2tierp.contabilidade.cliente.CentroResultadoGridController;
import com.t2tierp.contabilidade.cliente.NaturezaFinanceiraGridController;
import com.t2tierp.contabilidade.cliente.PlanoCentroResultadoGridController;
import com.t2tierp.contabilidade.cliente.PlanoNaturezaFinanceiraGridController;
import com.t2tierp.financeiro.cliente.FinDocumentoOrigemGridController;
import com.t2tierp.financeiro.cliente.FinParcelaPagamentoGridController;
import com.t2tierp.financeiro.cliente.FinResumoTesourariaGridController;
import org.openswing.swing.mdi.client.*;

public class Fachada implements ClientFacade {

    public Fachada() {
    }

    public void getPlanoNaturezaFinanceira() {
        new PlanoNaturezaFinanceiraGridController();
    }

    public void getPlanoCentroResultado() {
        new PlanoCentroResultadoGridController();
    }

    public void getNaturezaFinanceira() {
        new NaturezaFinanceiraGridController();
    }

    public void getCentroResultado() {
        new CentroResultadoGridController();
    }

    public void getFinDocumentoOrigem() {
        new FinDocumentoOrigemGridController();
    }

    public void getFinParcelaPagamento() {
        new FinParcelaPagamentoGridController();
    }

    public void getFinResumoTesouraria() {
        new FinResumoTesourariaGridController();
    }
}
