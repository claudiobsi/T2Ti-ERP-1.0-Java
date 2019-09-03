package com.t2tierp.padrao.servidor;

import org.openswing.swing.server.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.openswing.swing.message.receive.java.*;
import org.openswing.swing.permissions.java.ButtonsAuthorizations;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Mapeia e devolve as autorizações dos botões para o usuário logado.</p>
 *
 * <p>The MIT License</p>
 *
 * <p>Copyright: Copyright (C) 2010 T2Ti.COM</p>
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 *       The author may be contacted at:
 *           t2ti.com@gmail.com</p>
 *
 * @author Albert Eije (T2Ti.COM)
 * @version 1.0
 */
public class T2TiERPButtonAuthorizationsAction implements Action {

    public T2TiERPButtonAuthorizationsAction() {
    }

    /**
     * @return request name
     */
    public final String getRequestName() {
        return "getButtonAuthorizations";
    }

    /**
     * Business logic to execute.
     */
    public final Response executeCommand(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        /**
         * deve ser gerado de forma automática de acordo com as
         * definições do banco de dados.
         */
        if (userSessionPars.getUsername().equals("CLAUDIO")) {
            //todas as permissões
            ButtonsAuthorizations ba = new ButtonsAuthorizations();
            return new VOResponse(ba);
        } else {
            //permissões limitadas
            ButtonsAuthorizations ba = new ButtonsAuthorizations();
            //ba.addButtonAuthorization("pais", false, true, false);
            //ba.addButtonAuthorization("estado", false, true, false);
            //ba.addButtonAuthorization("cidade", false, true, false);
            return new VOResponse(ba);
        }
    }
}
