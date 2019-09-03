/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.t2tierp.padrao.cliente;

import com.t2tierp.cadastros.java.EmpresaVO;
import com.t2tierp.cadastros.java.UsuarioVO;
import java.util.Hashtable;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Classe com dados estáticos do usuário.</p>
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
 * @author Claudio de Barros (T2Ti.COM)
 * @version 1.0
 */
public class Container {

    //objeto utilizado para armazenar dados da aplicação do lado cliente
    private static Hashtable container = new Hashtable();

    public static Hashtable getContainer(){
        return container;
    }

    public static void setContainer(UsuarioVO usuarioVO){
        container.put("usuario", usuarioVO);
        container.put("empresa", usuarioVO.getColaborador().getPessoa().getListaEmpresa().get(0));
    }
}