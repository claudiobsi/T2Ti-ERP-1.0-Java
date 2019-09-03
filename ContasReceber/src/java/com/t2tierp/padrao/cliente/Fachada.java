package com.t2tierp.padrao.cliente;

import com.t2tierp.contabilidade.cliente.CentroResultadoGridController;
import com.t2tierp.contabilidade.cliente.NaturezaFinanceiraGridController;
import com.t2tierp.contabilidade.cliente.PlanoCentroResultadoGridController;
import com.t2tierp.contabilidade.cliente.PlanoNaturezaFinanceiraGridController;
import com.t2tierp.financeiro.cliente.FinConfiguracaoBoletoGridController;
import com.t2tierp.financeiro.cliente.FinDocumentoOrigemGridController;
import com.t2tierp.financeiro.cliente.FinLancamentoReceberGridController;
import com.t2tierp.financeiro.cliente.FinParcelaRecebimentoGridController;
import com.t2tierp.financeiro.cliente.FinStatusParcelaGridController;
import com.t2tierp.financeiro.cliente.FinTipoRecebimentoGridController;
import com.t2tierp.financeiro.cliente.FinTrataArquivoRetornoGridController;
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

    public void getFinTipoRecebimento() {
        new FinTipoRecebimentoGridController();
    }

    public void getFinConfiguracaoBoleto() {
        new FinConfiguracaoBoletoGridController();
    }

    public void getFinLancamentoReceber() {
        new FinLancamentoReceberGridController();
    }

    public void getFinParcelaRecebimento() {
        new FinParcelaRecebimentoGridController();
    }

    public void getFinProcessaArquivoRetorno() {
        new FinTrataArquivoRetornoGridController();
    }

}
