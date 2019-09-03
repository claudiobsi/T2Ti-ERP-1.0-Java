package com.t2tierp.sped.contabil.blocoi;

import java.io.Serializable;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Classe que representa o registro I010 do sped contabil.</p>
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
public class RegistroI010 implements Serializable {

    private static final long serialVersionUID = 1L;
    private String indEsc; /// Indicador da forma de escrituração contábil
    private String codVerLc; /// Código da Versão do Leiaute Contábil (preencher com 1.00).

    /**
     * @return the indEsc
     */
    public String getIndEsc() {
        return indEsc;
    }

    /**
     * @param indEsc the indEsc to set
     */
    public void setIndEsc(String indEsc) {
        this.indEsc = indEsc;
    }

    /**
     * @return the codVerLc
     */
    public String getCodVerLc() {
        return codVerLc;
    }

    /**
     * @param codVerLc the codVerLc to set
     */
    public void setCodVerLc(String codVerLc) {
        this.codVerLc = codVerLc;
    }
}
