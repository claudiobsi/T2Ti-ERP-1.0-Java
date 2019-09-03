package com.t2tierp.sped.contabil.blocoi;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Classe que representa o registro I550 do sped contabil.</p>
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
public class RegistroI550 implements Serializable {

    private static final long serialVersionUID = 1L;
    private String rzCont; // Conteúdo dos campos mencionados no Registro I510.
    private List<RegistroI555> registroi555List; /// BLOCO I - Lista de RegistroI555 (FILHO)

    /**
     * @return the rzCont
     */
    public String getRzCont() {
        return rzCont;
    }

    /**
     * @param rzCont the rzCont to set
     */
    public void setRzCont(String rzCont) {
        this.rzCont = rzCont;
    }

    /**
     * @return the registroi555List
     */
    public List<RegistroI555> getRegistroi555List() {
        return registroi555List;
    }

    /**
     * @param registroi555List the registroi555List to set
     */
    public void setRegistroi555List(List<RegistroI555> registroi555List) {
        this.registroi555List = registroi555List;
    }
}
