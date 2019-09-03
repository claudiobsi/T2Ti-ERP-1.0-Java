package com.t2tierp.padrao.cliente;

import com.t2tierp.compras.cliente.CompraConfirmaCotacaoGridController;
import com.t2tierp.compras.cliente.CompraCotacaoGridController;
import com.t2tierp.compras.cliente.CompraMapaComparativoGridController;
import com.t2tierp.compras.cliente.CompraPedidoGridController;
import com.t2tierp.compras.cliente.CompraRequisicaoGridController;
import com.t2tierp.compras.cliente.CompraSugeridaGridController;
import com.t2tierp.compras.cliente.CompraTipoPedidoGridController;
import com.t2tierp.compras.cliente.CompraTipoRequisicaoGridController;
import org.openswing.swing.mdi.client.*;

public class Fachada implements ClientFacade {

    public Fachada() {
    }

    public void getCompraTipoRequisicao() {
        new CompraTipoRequisicaoGridController();
    }

    public void getCompraTipoPedido() {
        new CompraTipoPedidoGridController();
    }

    public void getCompraRequisicao() {
        new CompraRequisicaoGridController();
    }

    public void getCompraCotacao() {
        new CompraCotacaoGridController();
    }

    public void getCompraConfirmaCotacao() {
        new CompraConfirmaCotacaoGridController();
    }

    public void getCompraMapaComparativo() {
        new CompraMapaComparativoGridController();
    }

    public void getCompraPedido() {
        new CompraPedidoGridController();
    }

    public void getCompraSugerida() {
        new CompraSugeridaGridController();
    }
}
