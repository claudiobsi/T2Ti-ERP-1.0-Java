package com.t2tierp.padrao.cliente;

import com.t2tierp.ponto.cliente.PontoAbonoGridController;
import com.t2tierp.ponto.cliente.PontoBancoHorasGridController;
import com.t2tierp.ponto.cliente.PontoClassificacaoJornadaGridController;
import com.t2tierp.ponto.cliente.PontoEscalaGridController;
import com.t2tierp.ponto.cliente.PontoEspelhoGridController;
import com.t2tierp.ponto.cliente.PontoGeracaoArquivoGridController;
import com.t2tierp.ponto.cliente.PontoHorarioGridController;
import com.t2tierp.ponto.cliente.PontoImportaMarcacaoController;
import com.t2tierp.ponto.cliente.PontoParametroGridController;
import com.t2tierp.ponto.cliente.PontoRegistraMarcacaoController;
import com.t2tierp.ponto.cliente.PontoRelogioGridController;
import org.openswing.swing.mdi.client.*;

public class Fachada implements ClientFacade {

    public Fachada() {
    }

    public void getPontoParametro() {
        new PontoParametroGridController();
    }

    public void getPontoHorario() {
        new PontoHorarioGridController();
    }

    public void getPontoEscala() {
        new PontoEscalaGridController();
    }

    public void getPontoClassificacaoJornada() {
        new PontoClassificacaoJornadaGridController();
    }

    public void getPontoAbono() {
        new PontoAbonoGridController();
    }

    public void getPontoRelogio() {
        new PontoRelogioGridController();
    }

    public void getPontoBancoHoras() {
        new PontoBancoHorasGridController();
    }

    public void getPontoImportaMarcacao() {
        new PontoImportaMarcacaoController();
    }

    public void getPontoGeracaoArquivo() {
        new PontoGeracaoArquivoGridController();
    }

    public void getPontoEspelho() {
        new PontoEspelhoGridController();
    }

    public void getPontoRegistraMarcacao() {
        new PontoRegistraMarcacaoController();
    }
}
