package com.t2tierp.pafecf.vo;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Objeto de valor referente a tabela NF2 - Detalhe.</p>
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
public class NF2DetalheVO {
    private Integer id;
    private Integer cfop;
    private Integer idProduto;
    private Integer idNF2Cabecalho;
    private Integer item;
    private Double quantidade;
    private Double valorUnitario;
    private Double valorTotal;
    private Double baseICMS;
    private Double taxaICMS;
    private Double ICMS;
    private Double ICMSOutras;
    private Double ICMSIsento;
    private Double taxaDesconto;
    private Double desconto;
    private Double taxaISSQN;
    private Double ISSQN;
    private Double taxaPIS;
    private Double PIS;
    private Double taxaCOFINS;
    private Double COFINS;
    private Double taxaAcrescimo;
    private Double acrescimo;
    private Double taxaIPI;
    private Double IPI;
    private String cancelado;
    private String movimentaEstoque;

    public NF2DetalheVO() {
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
     * @return the idCFOP
     */
    public Integer getCfop() {
        return cfop;
    }

    /**
     * @param idCFOP the idCFOP to set
     */
    public void setCfop(Integer cfop) {
        this.cfop = cfop;
    }

    /**
     * @return the idProduto
     */
    public Integer getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the idNF2Cabecalho
     */
    public Integer getIdNF2Cabecalho() {
        return idNF2Cabecalho;
    }

    /**
     * @param idNF2Cabecalho the idNF2Cabecalho to set
     */
    public void setIdNF2Cabecalho(Integer idNF2Cabecalho) {
        this.idNF2Cabecalho = idNF2Cabecalho;
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
     * @return the valorTotal
     */
    public Double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
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
     * @return the taxaICMS
     */
    public Double getTaxaICMS() {
        return taxaICMS;
    }

    /**
     * @param taxaICMS the taxaICMS to set
     */
    public void setTaxaICMS(Double taxaICMS) {
        this.taxaICMS = taxaICMS;
    }

    /**
     * @return the ICMS
     */
    public Double getICMS() {
        return ICMS;
    }

    /**
     * @param ICMS the ICMS to set
     */
    public void setICMS(Double ICMS) {
        this.ICMS = ICMS;
    }

    /**
     * @return the ICMSOutras
     */
    public Double getICMSOutras() {
        return ICMSOutras;
    }

    /**
     * @param ICMSOutras the ICMSOutras to set
     */
    public void setICMSOutras(Double ICMSOutras) {
        this.ICMSOutras = ICMSOutras;
    }

    /**
     * @return the ICMSIsento
     */
    public Double getICMSIsento() {
        return ICMSIsento;
    }

    /**
     * @param ICMSIsento the ICMSIsento to set
     */
    public void setICMSIsento(Double ICMSIsento) {
        this.ICMSIsento = ICMSIsento;
    }

    /**
     * @return the taxaDesconto
     */
    public Double getTaxaDesconto() {
        return taxaDesconto;
    }

    /**
     * @param taxaDesconto the taxaDesconto to set
     */
    public void setTaxaDesconto(Double taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
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
     * @return the taxaISSQN
     */
    public Double getTaxaISSQN() {
        return taxaISSQN;
    }

    /**
     * @param taxaISSQN the taxaISSQN to set
     */
    public void setTaxaISSQN(Double taxaISSQN) {
        this.taxaISSQN = taxaISSQN;
    }

    /**
     * @return the ISSQN
     */
    public Double getISSQN() {
        return ISSQN;
    }

    /**
     * @param ISSQN the ISSQN to set
     */
    public void setISSQN(Double ISSQN) {
        this.ISSQN = ISSQN;
    }

    /**
     * @return the taxaPIS
     */
    public Double getTaxaPIS() {
        return taxaPIS;
    }

    /**
     * @param taxaPIS the taxaPIS to set
     */
    public void setTaxaPIS(Double taxaPIS) {
        this.taxaPIS = taxaPIS;
    }

    /**
     * @return the PIS
     */
    public Double getPIS() {
        return PIS;
    }

    /**
     * @param PIS the PIS to set
     */
    public void setPIS(Double PIS) {
        this.PIS = PIS;
    }

    /**
     * @return the taxaCOFINS
     */
    public Double getTaxaCOFINS() {
        return taxaCOFINS;
    }

    /**
     * @param taxaCOFINS the taxaCOFINS to set
     */
    public void setTaxaCOFINS(Double taxaCOFINS) {
        this.taxaCOFINS = taxaCOFINS;
    }

    /**
     * @return the COFINS
     */
    public Double getCOFINS() {
        return COFINS;
    }

    /**
     * @param COFINS the COFINS to set
     */
    public void setCOFINS(Double COFINS) {
        this.COFINS = COFINS;
    }

    /**
     * @return the taxaAcrescimo
     */
    public Double getTaxaAcrescimo() {
        return taxaAcrescimo;
    }

    /**
     * @param taxaAcrescimo the taxaAcrescimo to set
     */
    public void setTaxaAcrescimo(Double taxaAcrescimo) {
        this.taxaAcrescimo = taxaAcrescimo;
    }

    /**
     * @return the acrescimo
     */
    public Double getAcrescimo() {
        return acrescimo;
    }

    /**
     * @param acrescimo the acrescimo to set
     */
    public void setAcrescimo(Double acrescimo) {
        this.acrescimo = acrescimo;
    }

    /**
     * @return the taxaIPI
     */
    public Double getTaxaIPI() {
        return taxaIPI;
    }

    /**
     * @param taxaIPI the taxaIPI to set
     */
    public void setTaxaIPI(Double taxaIPI) {
        this.taxaIPI = taxaIPI;
    }

    /**
     * @return the IPI
     */
    public Double getIPI() {
        return IPI;
    }

    /**
     * @param IPI the IPI to set
     */
    public void setIPI(Double IPI) {
        this.IPI = IPI;
    }

    /**
     * @return the cancelado
     */
    public String getCancelado() {
        return cancelado;
    }

    /**
     * @param cancelado the cancelado to set
     */
    public void setCancelado(String cancelado) {
        this.cancelado = cancelado;
    }

    /**
     * @return the movimentaEstoque
     */
    public String getMovimentaEstoque() {
        return movimentaEstoque;
    }

    /**
     * @param movimentaEstoque the movimentaEstoque to set
     */
    public void setMovimentaEstoque(String movimentaEstoque) {
        this.movimentaEstoque = movimentaEstoque;
    }

}
