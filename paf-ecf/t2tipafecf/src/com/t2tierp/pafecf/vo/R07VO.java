package com.t2tierp.pafecf.vo;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Objeto de valor referente a tabela R07.</p>
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
public class R07VO {
    private Integer id;
    private Integer idR06;
    private Integer CCF;
    private String meioPagamento;
    private Double valorPagamento;
    private String indicadorEstorno;
    private Double valorEstorno;

    public R07VO() {
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the idR06
     */
    public Integer getIdR06() {
        return idR06;
    }

    /**
     * @param idR06 the idR06 to set
     */
    public void setIdR06(Integer idR06) {
        this.idR06 = idR06;
    }

    /**
     * @return the CCF
     */
    public Integer getCCF() {
        return CCF;
    }

    /**
     * @param CCF the CCF to set
     */
    public void setCCF(Integer CCF) {
        this.CCF = CCF;
    }

    /**
     * @return the meioPagamento
     */
    public String getMeioPagamento() {
        return meioPagamento;
    }

    /**
     * @param meioPagamento the meioPagamento to set
     */
    public void setMeioPagamento(String meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    /**
     * @return the valorPagamento
     */
    public Double getValorPagamento() {
        return valorPagamento;
    }

    /**
     * @param valorPagamento the valorPagamento to set
     */
    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    /**
     * @return the indicadorEstorno
     */
    public String getIndicadorEstorno() {
        return indicadorEstorno;
    }

    /**
     * @param indicadorEstorno the indicadorEstorno to set
     */
    public void setIndicadorEstorno(String indicadorEstorno) {
        this.indicadorEstorno = indicadorEstorno;
    }

    /**
     * @return the valorEstorno
     */
    public Double getValorEstorno() {
        return valorEstorno;
    }

    /**
     * @param valorEstorno the valorEstorno to set
     */
    public void setValorEstorno(Double valorEstorno) {
        this.valorEstorno = valorEstorno;
    }

}