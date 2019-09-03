package com.t2tierp.padrao.cliente;

import com.t2tierp.nfe.cliente.NfeGridController;
import com.t2tierp.nfe.cliente.StatusServico;
import java.security.KeyStore;
import java.util.Map;
import javax.swing.JOptionPane;
import org.openswing.swing.mdi.client.*;

public class Fachada implements ClientFacade {

    public Fachada() {
    }

    public void getNfe() {
        new NfeGridController();
    }

    public void getStatusServico() {
        SelecionaCertificado selecionaCertificado = new SelecionaCertificado(null, true);
        selecionaCertificado.setVisible(true);
        if (!selecionaCertificado.isCancelado()) {
            Map map = selecionaCertificado.getDadosCertificado();
            KeyStore ks = (KeyStore) map.get("keyStore");
            String alias = (String) map.get("alias");
            char[] senha = (char[]) map.get("senha");

            StatusServico statusNfe = new StatusServico();
            JOptionPane.showMessageDialog(null, statusNfe.verificaStatusServico(ks, alias, senha), "Status do serviço NF-e", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
