package com.t2tierp.padrao.cliente;

import com.t2tierp.contabilidade.cliente.CentroResultadoGridController;
import com.t2tierp.contabilidade.cliente.NaturezaFinanceiraGridController;
import com.t2tierp.contabilidade.cliente.PlanoCentroResultadoGridController;
import com.t2tierp.contabilidade.cliente.PlanoNaturezaFinanceiraGridController;
import com.t2tierp.financeiro.cliente.FinDocumentoOrigemGridController;
import com.t2tierp.financeiro.cliente.FinLancamentoPagarGridController;
import com.t2tierp.financeiro.cliente.FinParcelaPagamentoGridController;
import com.t2tierp.financeiro.cliente.FinStatusParcelaGridController;
import com.t2tierp.financeiro.cliente.FinTipoPagamentoGridController;
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

    public void getFinStatusParcela() {
        new FinStatusParcelaGridController();
    }

    public void getFinTipoPagamento() {
        new FinTipoPagamentoGridController();
    }

    public void getFinLancamentoPagar() {
        new FinLancamentoPagarGridController();
    }

    public void getFinParcelaPagamento() {
        new FinParcelaPagamentoGridController();
    }

}
