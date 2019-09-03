package com.t2tierp.padrao.cliente;

import com.t2tierp.contabilidade.cliente.RegistroCartorioGridController;
import com.t2tierp.escritafiscal.cliente.FiscalApuracaoIcmsController;
import com.t2tierp.escritafiscal.cliente.FiscalParametrosGridController;
import com.t2tierp.escritafiscal.cliente.FiscalTermoGridController;
import com.t2tierp.escritafiscal.cliente.InformativosGuiasGrid;
import com.t2tierp.escritafiscal.cliente.SimplesNacionalCabecalhoGridController;
import com.t2tierp.vendas.cliente.TipoNotaFiscalGridController;
import org.openswing.swing.mdi.client.*;

public class Fachada implements ClientFacade {

    public Fachada() {
    }

    public void getRegistroCartorio() {
        new RegistroCartorioGridController();
    }

    public void getFiscalParametros() {
        new FiscalParametrosGridController();
    }

    public void getTipoNotaFiscal() {
        new TipoNotaFiscalGridController();
    }

    public void getSimplesNacional() {
        new SimplesNacionalCabecalhoGridController();
    }

    public void getFiscalTermo() {
        new FiscalTermoGridController();
    }

    public void getRegistroEntradaSaida() {

    }

    public void getApuracaoIcms() {
        new FiscalApuracaoIcmsController();
    }

    public void getInformativosGuias(){
        MDIFrame.add(new InformativosGuiasGrid());
    }

}
