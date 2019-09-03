package com.t2tierp.padrao.cliente;

import com.t2tierp.patrimonio.cliente.PatrimApoliceSeguroGridController;
import com.t2tierp.patrimonio.cliente.PatrimBemGridController;
import com.t2tierp.patrimonio.cliente.PatrimEstadoConservacaoGridController;
import com.t2tierp.patrimonio.cliente.PatrimGrupoBemGridController;
import com.t2tierp.patrimonio.cliente.PatrimIndiceAtualizacaoGridController;
import com.t2tierp.patrimonio.cliente.PatrimTaxaDepreciacaoGridController;
import com.t2tierp.patrimonio.cliente.PatrimTipoAquisicaoBemGridController;
import com.t2tierp.patrimonio.cliente.PatrimTipoMovimentacaoGridController;
import com.t2tierp.patrimonio.cliente.SeguradoraGridController;
import org.openswing.swing.mdi.client.*;

public class Fachada implements ClientFacade {

    public Fachada() {
    }

    public void getPatrimTaxaDepreciacao(){
        new PatrimTaxaDepreciacaoGridController();
    }

    public void getPatrimIndiceAtualizacao(){
        new PatrimIndiceAtualizacaoGridController();
    }

    public void getPatrimTipoAquisicaoBem(){
        new PatrimTipoAquisicaoBemGridController();
    }

    public void getPatrimTipoMovimentacao(){
        new PatrimTipoMovimentacaoGridController();
    }

    public void getPatrimEstadoConservacao(){
        new PatrimEstadoConservacaoGridController();
    }

    public void getPatrimGrupoBem(){
        new PatrimGrupoBemGridController();
    }

    public void getPatrimBem(){
        new PatrimBemGridController();
    }

    public void getSeguradora(){
        new SeguradoraGridController();
    }

    public void getPatrimApoliceSeguro(){
        new PatrimApoliceSeguroGridController();
    }

}
