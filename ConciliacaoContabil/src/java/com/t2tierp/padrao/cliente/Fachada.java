package com.t2tierp.padrao.cliente;

import com.t2tierp.conciliacaocontabil.cliente.ComposicaoSaldoGridController;
import com.t2tierp.conciliacaocontabil.cliente.ConciliacaoBancariaGridController;
import com.t2tierp.conciliacaocontabil.cliente.ConciliacaoClienteGridController;
import com.t2tierp.conciliacaocontabil.cliente.ConciliacaoFornecedorGridController;
import com.t2tierp.conciliacaocontabil.cliente.ContabilLancamentoCabecalhoGridController;
import org.openswing.swing.mdi.client.*;

public class Fachada implements ClientFacade {

    public Fachada() {
    }

    public void getConciliacaoBancaria(){
        new ConciliacaoBancariaGridController();
    }

    public void getConciliacaoCliente(){
        new ConciliacaoClienteGridController();
    }

    public void getConciliacaoFornecedor(){
        new ConciliacaoFornecedorGridController();
    }

    public void getConciliacaoContabil(){
        new ContabilLancamentoCabecalhoGridController();
    }

    public void getComposicaoSaldo(){
        new ComposicaoSaldoGridController();
    }

}
