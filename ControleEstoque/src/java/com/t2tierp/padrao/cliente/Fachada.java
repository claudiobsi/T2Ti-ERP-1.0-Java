package com.t2tierp.padrao.cliente;

import com.t2tierp.controleestoque.cliente.EntradaNotaGridController;
import com.t2tierp.controleestoque.cliente.EstoqueContagemCabecalhoGridController;
import com.t2tierp.controleestoque.cliente.EstoqueFormacaoPrecoGridController;
import com.t2tierp.controleestoque.cliente.EstoqueReajusteCabecalhoGridController;
import com.t2tierp.controleestoque.cliente.RequisicaoInternaCabecalhoGridController;
import org.openswing.swing.mdi.client.*;

public class Fachada implements ClientFacade {

    public Fachada() {
    }

    public void getRequisicaoInterna() {
        new RequisicaoInternaCabecalhoGridController();
    }

    public void getEstoqueContagem() {
        new EstoqueContagemCabecalhoGridController();
    }

    public void getEstoqueReajuste() {
        new EstoqueReajusteCabecalhoGridController();
    }

    public void getEstoqueFormacaoPreco() {
        new EstoqueFormacaoPrecoGridController();
    }

    public void getEntradaNotaFiscal() {
        new EntradaNotaGridController();
    }
}
