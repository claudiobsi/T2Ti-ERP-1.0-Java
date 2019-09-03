package com.t2tierp.pafecf.vo;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: VO transiente. Montará os dados necessários para o registro R05.</p>
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
public class R05VO  {

    private Integer id;
    private Integer COO;
    private Integer CCF;
    private Integer item;
    private String GTIN;
    private String descricaoPDV;
    private Double quantidade;
    private String siglaUnidade;
    private Double valorUnitario;
    private Double desconto;
    private Double acrescimo;
    private Double totalItem;
    private String totalizadorParcial;
    private String indicadorCancelamento;
    private Double quantidadeCancelada;
    private Double valorCancelado;
    private Double cancelamentoAcrescimo;
    private String IAT;
    private String IPPT;
    private Integer casasDecimaisQuantidade;
    private Integer casasDecimaisValor;

    public R05VO() {
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
     * @return the COO
     */
    public Integer getCOO() {
        return COO;
    }

    /**
     * @param COO the COO to set
     */
    public void setCOO(Integer COO) {
        this.COO = COO;
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
     * @return the item
     */
    public Integer getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Integer item) {
        this.item = item;
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
     * @return the descricaoPDV
     */
    public String getDescricaoPDV() {
        return descricaoPDV;
    }

    /**
     * @param descricaoPDV the descricaoPDV to set
     */
    public void setDescricaoPDV(String descricaoPDV) {
        this.descricaoPDV = descricaoPDV;
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
     * @return the valorUnitario
     */
    public Double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * @return the desconto
     */
    public Double getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the acrescim
     */
    public Double getAcrescimo() {
        return acrescimo;
    }

    /**
     * @param acrescim the acrescim to set
     */
    public void setAcrescimo(Double acrescimo) {
        this.acrescimo = acrescimo;
    }

    /**
     * @return the totalItem
     */
    public Double getTotalItem() {
        return totalItem;
    }

    /**
     * @param totalItem the totalItem to set
     */
    public void setTotalItem(Double totalItem) {
        this.totalItem = totalItem;
    }

    /**
     * @return the totalizadorParcial
     */
    public String getTotalizadorParcial() {
        return totalizadorParcial;
    }

    /**
     * @param totalizadorParcial the totalizadorParcial to set
     */
    public void setTotalizadorParcial(String totalizadorParcial) {
        this.totalizadorParcial = totalizadorParcial;
    }

    /**
     * @return the indicadorCancelamento
     */
    public String getIndicadorCancelamento() {
        return indicadorCancelamento;
    }

    /**
     * @param indicadorCancelamento the indicadorCancelamento to set
     */
    public void setIndicadorCancelamento(String indicadorCancelamento) {
        this.indicadorCancelamento = indicadorCancelamento;
    }

    /**
     * @return the quantidadeCancelada
     */
    public Double getQuantidadeCancelada() {
        return quantidadeCancelada;
    }

    /**
     * @param quantidadeCancelada the quantidadeCancelada to set
     */
    public void setQuantidadeCancelada(Double quantidadeCancelada) {
        this.quantidadeCancelada = quantidadeCancelada;
    }

    /**
     * @return the valorCancelado
     */
    public Double getValorCancelado() {
        return valorCancelado;
    }

    /**
     * @param valorCancelado the valorCancelado to set
     */
    public void setValorCancelado(Double valorCancelado) {
        this.valorCancelado = valorCancelado;
    }

    /**
     * @return the cancelamentoAcrescimo
     */
    public Double getCancelamentoAcrescimo() {
        return cancelamentoAcrescimo;
    }

    /**
     * @param cancelamentoAcrescimo the cancelamentoAcrescimo to set
     */
    public void setCancelamentoAcrescimo(Double cancelamentoAcrescimo) {
        this.cancelamentoAcrescimo = cancelamentoAcrescimo;
    }

    /**
     * @return the IAT
     */
    public String getIAT() {
        return IAT;
    }

    /**
     * @param IAT the IAT to set
     */
    public void setIAT(String IAT) {
        this.IAT = IAT;
    }

    /**
     * @return the IPPT
     */
    public String getIPPT() {
        return IPPT;
    }

    /**
     * @param IPPT the IPPT to set
     */
    public void setIPPT(String IPPT) {
        this.IPPT = IPPT;
    }

    /**
     * @return the casasDecimaisQuantidade
     */
    public Integer getCasasDecimaisQuantidade() {
        return casasDecimaisQuantidade;
    }

    /**
     * @param casasDecimaisQuantidade the casasDecimaisQuantidade to set
     */
    public void setCasasDecimaisQuantidade(Integer casasDecimaisQuantidade) {
        this.casasDecimaisQuantidade = casasDecimaisQuantidade;
    }

    /**
     * @return the casasDecimaisValor
     */
    public Integer getCasasDecimaisValor() {
        return casasDecimaisValor;
    }

    /**
     * @param casasDecimaisValor the casasDecimaisValor to set
     */
    public void setCasasDecimaisValor(Integer casasDecimaisValor) {
        this.casasDecimaisValor = casasDecimaisValor;
    }

}