package com.t2tierp.padrao.cliente;

import com.t2tierp.contabilidade.cliente.AidfAimdfGridController;
import com.t2tierp.contabilidade.cliente.BalancoPatrimonialGridController;
import com.t2tierp.contabilidade.cliente.ContabilContaGridController;
import com.t2tierp.contabilidade.cliente.ContabilDreCabecalhoGridController;
import com.t2tierp.contabilidade.cliente.ContabilEncerramentoExeCabGridController;
import com.t2tierp.contabilidade.cliente.ContabilFechamentoGridController;
import com.t2tierp.contabilidade.cliente.ContabilHistoricoGridController;
import com.t2tierp.contabilidade.cliente.ContabilIndiceGridController;
import com.t2tierp.contabilidade.cliente.ContabilLancamentoCabecalhoGridController;
import com.t2tierp.contabilidade.cliente.ContabilLancamentoOrcadoGridController;
import com.t2tierp.contabilidade.cliente.ContabilLancamentoPadraoGridController;
import com.t2tierp.contabilidade.cliente.ContabilLivroGridController;
import com.t2tierp.contabilidade.cliente.ContabilLoteGridController;
import com.t2tierp.contabilidade.cliente.ContabilParametrosGridController;
import com.t2tierp.contabilidade.cliente.DfcGridController;
import com.t2tierp.contabilidade.cliente.FapGridController;
import com.t2tierp.contabilidade.cliente.LivroContabilGridController;
import com.t2tierp.contabilidade.cliente.PlanoContaGridController;
import com.t2tierp.contabilidade.cliente.PlanoContaRefSpedGridController;
import com.t2tierp.contabilidade.cliente.RegistroCartorioGridController;
import org.openswing.swing.mdi.client.*;

public class Fachada implements ClientFacade {

    public Fachada() {
    }

    public void getRegistroCartorio() {
        new RegistroCartorioGridController();
    }

    public void getParametros(){
        new ContabilParametrosGridController();
    }

    public void getIndices(){
        new ContabilIndiceGridController();
    }

    public void getHistorico(){
        new ContabilHistoricoGridController();
    }

    public void getAidfAimdf(){
        new AidfAimdfGridController();
    }

    public void getFap(){
        new FapGridController();
    }

    public void getPlanoContas(){
        new PlanoContaGridController();
    }

    public void getPlanoContasRefSped(){
        new PlanoContaRefSpedGridController();
    }

    public void getContaContabil(){
        new ContabilContaGridController();
    }

    public void getFechamento(){
        new ContabilFechamentoGridController();
    }

    public void getLancamentoPadrao(){
        new ContabilLancamentoPadraoGridController();
    }

    public void getLancamentoLote(){
        new ContabilLoteGridController();
    }

    public void getLancamentoOrcado(){
        new ContabilLancamentoOrcadoGridController();
    }

    public void getLancamentoContabil(){
        new ContabilLancamentoCabecalhoGridController();
    }

    public void getDre(){
        new ContabilDreCabecalhoGridController();
    }

    public void getEncerramentoExercicio(){
        new ContabilEncerramentoExeCabGridController();
    }

    public void getLivrosTermos(){
        new ContabilLivroGridController();
    }

    public void getDfc(){
        new DfcGridController();
    }

    public void getBalancoPatrimonial(){
        new BalancoPatrimonialGridController();
    }

    public void getLivroContabil(){
        new LivroContabilGridController();
    }

}
