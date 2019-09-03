package com.t2tierp.sped.contabil.bloco0;

import java.io.Serializable;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Classe que representa o registro 0020 do sped contabil.</p>
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
public class Registro0020 implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer indDec; /// Indicador de descentralização - 0 - escrituração da matriz; 1 - escrituração da filial.
    private String cnpj; /// Número de inscrição do empresário ou sociedade empresária no CNPJ da matriz ou da filial.
    private String uf; /// Sigla da unidade da federação da matriz ou da filial.
    private String ie; /// Inscrição estadual da matriz ou da filial.
    private Integer codMun; /// Código do município do domicílio da matriz ou da filial.
    private String im; /// Número de Inscrição Municipal da matriz ou da filial.
    private String nire; /// Número de Identificação do Registro de Empresas da matriz ou da filial na Junta Comercial.

    /**
     * @return the indDec
     */
    public Integer getIndDec() {
        return indDec;
    }

    /**
     * @param indDec the indDec to set
     */
    public void setIndDec(Integer indDec) {
        this.indDec = indDec;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the ie
     */
    public String getIe() {
        return ie;
    }

    /**
     * @param ie the ie to set
     */
    public void setIe(String ie) {
        this.ie = ie;
    }

    /**
     * @return the codMun
     */
    public Integer getCodMun() {
        return codMun;
    }

    /**
     * @param codMun the codMun to set
     */
    public void setCodMun(Integer codMun) {
        this.codMun = codMun;
    }

    /**
     * @return the im
     */
    public String getIm() {
        return im;
    }

    /**
     * @param im the im to set
     */
    public void setIm(String im) {
        this.im = im;
    }

    /**
     * @return the nire
     */
    public String getNire() {
        return nire;
    }

    /**
     * @param nire the nire to set
     */
    public void setNire(String nire) {
        this.nire = nire;
    }
}
