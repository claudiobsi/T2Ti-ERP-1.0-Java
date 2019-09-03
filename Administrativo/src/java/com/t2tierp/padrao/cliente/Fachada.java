package com.t2tierp.padrao.cliente;

import com.t2tierp.cadastros.cliente.PapelGridController;
import com.t2tierp.cadastros.cliente.UsuarioGridController;
import javax.swing.JOptionPane;
import org.openswing.swing.mdi.client.*;

public class Fachada implements ClientFacade {

    public Fachada() {
    }

    public void getUsuario() {
        new UsuarioGridController();
    }

    public void getPapel() {
        new PapelGridController();
    }

    public void getFuncaoPadrao() {
        JOptionPane.showMessageDialog(null, "Acesso não autorizado!", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }
}
