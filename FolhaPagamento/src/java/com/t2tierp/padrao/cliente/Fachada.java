package com.t2tierp.padrao.cliente;

import com.t2tierp.folhapagamento.cliente.FeriasPeriodoAquisitivoGridController;
import com.t2tierp.folhapagamento.cliente.FolhaAfastamentoGridController;
import com.t2tierp.folhapagamento.cliente.FolhaEventoGridController;
import com.t2tierp.folhapagamento.cliente.FolhaFechamentoGridController;
import com.t2tierp.folhapagamento.cliente.FolhaFeriasColetivasGridController;
import com.t2tierp.folhapagamento.cliente.FolhaHistoricoSalarialGridController;
import com.t2tierp.folhapagamento.cliente.FolhaInssGridController;
import com.t2tierp.folhapagamento.cliente.FolhaInssServicoGridController;
import com.t2tierp.folhapagamento.cliente.FolhaLancamentoGridController;
import com.t2tierp.folhapagamento.cliente.FolhaParametrosGridController;
import com.t2tierp.folhapagamento.cliente.FolhaPlanoSaudeGridController;
import com.t2tierp.folhapagamento.cliente.FolhaPppGridController;
import com.t2tierp.folhapagamento.cliente.FolhaRescisaoGridController;
import com.t2tierp.folhapagamento.cliente.FolhaTipoAfastamentoGridController;
import com.t2tierp.folhapagamento.cliente.FolhaValeTransporteGridController;
import com.t2tierp.folhapagamento.cliente.GuiasAcumuladasGridController;
import com.t2tierp.folhapagamento.cliente.InformativosGuiasController;
import org.openswing.swing.mdi.client.*;

public class Fachada implements ClientFacade {

    public Fachada() {
    }

    public void getFolhaParametro(){
        new FolhaParametrosGridController();
    }

    public void getGuiasAcumuladas(){
        new GuiasAcumuladasGridController();
    }

    public void getPlanoSaude(){
        new FolhaPlanoSaudeGridController();
    }

    public void getEvento(){
        new FolhaEventoGridController();
    }

    public void getTipoAfastamento(){
        new FolhaTipoAfastamentoGridController();
    }

    public void getAfastamento(){
        new FolhaAfastamentoGridController();
    }

    public void getFeriasColetivas(){
        new FolhaFeriasColetivasGridController();
    }

    public void getFeriasPeriodoAquisitivo(){
        new FeriasPeriodoAquisitivoGridController();
    }

    public void getFechamento(){
        new FolhaFechamentoGridController();
    }

    public void getLancamento(){
        new FolhaLancamentoGridController();
    }

    public void getAlteracaoSalarial(){
        new FolhaHistoricoSalarialGridController();
    }

    public void getValeTransporte(){
        new FolhaValeTransporteGridController();
    }

    public void getPpp(){
        new FolhaPppGridController();
    }

    public void getRescisao(){
        new FolhaRescisaoGridController();
    }

    public void getInssServico(){
        new FolhaInssServicoGridController();
    }

    public void getInssRetencao(){
        new FolhaInssGridController();
    }

    public void getInformativosGuias(){
        new InformativosGuiasController();
    }

}
