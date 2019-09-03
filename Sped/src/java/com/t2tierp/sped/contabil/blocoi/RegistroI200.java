package com.t2tierp.sped.contabil.blocoi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Classe que representa o registro I200 do sped contabil.</p>
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
public class RegistroI200 implements Serializable {

    private static final long serialVersionUID = 1L;
    private String numLcto; // Número de identificação do lançamento
    private Date dtLcto; // Data do lançamento
    private BigDecimal vlLcto; // Valor do Lançamento
    private String indLcto; // Indicador do tipo do lançamento
    private List<RegistroI250> registroi250List; /// BLOCO I - Lista de RegistroI250 (FILHO)

    public RegistroI200() {
        registroi250List = new ArrayList<RegistroI250>();
    }

    /**
     * @return the numLcto
     */
    public String getNumLcto() {
        return numLcto;
    }

    /**
     * @param numLcto the numLcto to set
     */
    public void setNumLcto(String numLcto) {
        this.numLcto = numLcto;
    }

    /**
     * @return the dtLcto
     */
    public Date getDtLcto() {
        return dtLcto;
    }

    /**
     * @param dtLcto the dtLcto to set
     */
    public void setDtLcto(Date dtLcto) {
        this.dtLcto = dtLcto;
    }

    /**
     * @return the vlLcto
     */
    public BigDecimal getVlLcto() {
        return vlLcto;
    }

    /**
     * @param vlLcto the vlLcto to set
     */
    public void setVlLcto(BigDecimal vlLcto) {
        this.vlLcto = vlLcto;
    }

    /**
     * @return the indLcto
     */
    public String getIndLcto() {
        return indLcto;
    }

    /**
     * @param indLcto the indLcto to set
     */
    public void setIndLcto(String indLcto) {
        this.indLcto = indLcto;
    }

    /**
     * @return the registroi250List
     */
    public List<RegistroI250> getRegistroi250List() {
        return registroi250List;
    }

    /**
     * @param registroi250List the registroi250List to set
     */
    public void setRegistroi250List(List<RegistroI250> registroi250List) {
        this.registroi250List = registroi250List;
    }
}
