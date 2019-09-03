package com.t2tierp.pafecf.vo;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: VO transiente que representa o registro 60D do Sintegra.</p>
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
public class Sintegra60DVO {

    private String GTIN;
    private String descricao;
    private String siglaUnidade;
    private Double quantidade;
    private Double valorLiquido;
    private Double baseICMS;
    private String situacaoTributaria;
    private Double valorICMS;
    private Double aliquotaICMS;

    public Sintegra60DVO() {
    }

    /**
     * @return the GTIN
     */
    public String getGTIN() {
        return GTIN;
    }

    /**
     * @param GTIN the GTIN to set
     */
    public void setGTIN(String GTIN) {
        this.GTIN = GTIN;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the siglaUnidade
     */
    public String getSiglaUnidade() {
        return siglaUnidade;
    }

    /**
     * @param siglaUnidade the siglaUnidade to set
     */
    public void setSiglaUnidade(String siglaUnidade) {
        this.siglaUnidade = siglaUnidade;
    }

    /**
     * @return the quantidade
     */
    public Double getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the valorLiquido
     */
    public Double getValorLiquido() {
        return valorLiquido;
    }

    /**
     * @param valorLiquido the valorLiquido to set
     */
    public void setValorLiquido(Double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    /**
     * @return the baseICMS
     */
    public Double getBaseICMS() {
        return baseICMS;
    }

    /**
     * @param baseICMS the baseICMS to set
     */
    public void setBaseICMS(Double baseICMS) {
        this.baseICMS = baseICMS;
    }

    /**
     * @return the situacaoTributaria
     */
    public String getSituacaoTributaria() {
        return situacaoTributaria;
    }

    /**
     * @param situacaoTributaria the situacaoTributaria to set
     */
    public void setSituacaoTributaria(String situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    /**
     * @return the valorICMS
     */
    public Double getValorICMS() {
        return valorICMS;
    }

    /**
     * @param valorICMS the valorICMS to set
     */
    public void setValorICMS(Double valorICMS) {
        this.valorICMS = valorICMS;
    }

    /**
     * @return the aliquotaICMS
     */
    public Double getAliquotaICMS() {
        return aliquotaICMS;
    }

    /**
     * @param aliquotaICMS the aliquotaICMS to set
     */
    public void setAliquotaICMS(Double aliquotaICMS) {
        this.aliquotaICMS = aliquotaICMS;
    }


}