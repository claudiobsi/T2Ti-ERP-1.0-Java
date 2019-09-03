package com.t2tierp.sped.contabil.blocoi;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Classe que representa o registro I155 do sped contabil.</p>
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
public class RegistroI155 implements Serializable {

    private static final long serialVersionUID = 1L;
    private String codCta; /// Código da conta analítica.
    private String codCcus; /// Código do centro de custos.
    private BigDecimal vlSldIni; /// Valor do saldo inicial do período.
    private String indDcIni; /// Indicador da situação do saldo inicial
    private BigDecimal vlDeb; /// Valor total dos débitos no período.
    private BigDecimal vlCred; /// Valor total dos créditos no período.
    private BigDecimal vlSldFin; /// Valor do saldo final do período.
    private String indDcFin; /// Indicador da situação do saldo final

    /**
     * @return the codCta
     */
    public String getCodCta() {
        return codCta;
    }

    /**
     * @param codCta the codCta to set
     */
    public void setCodCta(String codCta) {
        this.codCta = codCta;
    }

    /**
     * @return the codCcus
     */
    public String getCodCcus() {
        return codCcus;
    }

    /**
     * @param codCcus the codCcus to set
     */
    public void setCodCcus(String codCcus) {
        this.codCcus = codCcus;
    }

    /**
     * @return the vlSldIni
     */
    public BigDecimal getVlSldIni() {
        return vlSldIni;
    }

    /**
     * @param vlSldIni the vlSldIni to set
     */
    public void setVlSldIni(BigDecimal vlSldIni) {
        this.vlSldIni = vlSldIni;
    }

    /**
     * @return the indDcIni
     */
    public String getIndDcIni() {
        return indDcIni;
    }

    /**
     * @param indDcIni the indDcIni to set
     */
    public void setIndDcIni(String indDcIni) {
        this.indDcIni = indDcIni;
    }

    /**
     * @return the vlDeb
     */
    public BigDecimal getVlDeb() {
        return vlDeb;
    }

    /**
     * @param vlDeb the vlDeb to set
     */
    public void setVlDeb(BigDecimal vlDeb) {
        this.vlDeb = vlDeb;
    }

    /**
     * @return the vlCred
     */
    public BigDecimal getVlCred() {
        return vlCred;
    }

    /**
     * @param vlCred the vlCred to set
     */
    public void setVlCred(BigDecimal vlCred) {
        this.vlCred = vlCred;
    }

    /**
     * @return the vlSldFin
     */
    public BigDecimal getVlSldFin() {
        return vlSldFin;
    }

    /**
     * @param vlSldFin the vlSldFin to set
     */
    public void setVlSldFin(BigDecimal vlSldFin) {
        this.vlSldFin = vlSldFin;
    }

    /**
     * @return the indDcFin
     */
    public String getIndDcFin() {
        return indDcFin;
    }

    /**
     * @param indDcFin the indDcFin to set
     */
    public void setIndDcFin(String indDcFin) {
        this.indDcFin = indDcFin;
    }
}
