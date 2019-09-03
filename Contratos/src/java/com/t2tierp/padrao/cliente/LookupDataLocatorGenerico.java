/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.t2tierp.padrao.cliente;

import org.openswing.swing.lookup.client.LookupServerDataLocator;

/**
 *
 * @author T2Ti
 */
public class LookupDataLocatorGenerico extends LookupServerDataLocator {

    public LookupDataLocatorGenerico(String nomeClasse) {
        setGridMethodName("importaDados");
        setValidationMethodName("validaDados");

        getLookupFrameParams().put("nomeClasse", nomeClasse);
        getLookupValidationParameters().put("nomeClasse", nomeClasse);
    }

}
