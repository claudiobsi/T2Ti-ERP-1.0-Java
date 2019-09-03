package com.t2tierp.padrao.cliente;

import com.t2tierp.vendas.cliente.TipoNotaFiscalGridController;
import com.t2tierp.vendas.cliente.VendaCondicoesPagamentoGridController;
import com.t2tierp.vendas.cliente.VendaFreteGridController;
import com.t2tierp.vendas.cliente.VendaGridController;
import com.t2tierp.vendas.cliente.VendaOrcamentoGridController;
import com.t2tierp.vendas.cliente.VendaRomaneioEntregaGridController;
import org.openswing.swing.mdi.client.*;

public class Fachada implements ClientFacade {

    public Fachada() {
    }

    public void getTipoNotaFiscal() {
        new TipoNotaFiscalGridController();
    }

    public void getVendaCondicoesPagamento() {
        new VendaCondicoesPagamentoGridController();
    }

    public void getVendaOrcamento() {
        new VendaOrcamentoGridController();
    }

    public void getVenda() {
        new VendaGridController();
    }

    public void getVendaFrete() {
        new VendaFreteGridController();
    }

    public void getVendaRomaneioEntrega() {
        new VendaRomaneioEntregaGridController();
    }
}
