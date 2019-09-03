package com.t2tierp.pafecf.vo;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Objeto de valor referente a tabela de Venda - Detalhe.</p>
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
public class VendaDetalheVO {
    private Integer id;
    private Integer cfop;
    private Integer idProduto;
    private Integer idVendaCabecalho;
    private Integer item;
    private Double quantidade;
    private Double valorUnitario;
    private Double valorTotal;
    private Double totalItem;
    private Double baseICMS;
    private Double taxaICMS;
    private Double ICMS;
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
    private String totalizadorParcial;
    private String CST;
    private String cancelado;
    private String movimentaEstoque;
    private String GTIN;
    private String unidadeProduto;
    private String descricaoPDV;
    private String ECFICMS;
    //apenas para quando for recuperar uma venda perdida
    private String identificacaoCliente;
    private double acrescimoRateio;
    private double descontoRateio;
    private String hashTripa;
    private Integer ccf;
    private Integer coo;
    private String serieEcf;
    private String ecfIcmsSt;
    private Integer hashIncremento;

    public VendaDetalheVO() {
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
     * @return the idVendaCabecalho
     */
    public Integer getIdVendaCabecalho() {
        return idVendaCabecalho;
    }

    /**
     * @param idVendaCabecalho the idVendaCabecalho to set
     */
    public void setIdVendaCabecalho(Integer idVendaCabecalho) {
        this.idVendaCabecalho = idVendaCabecalho;
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
     * @return the CST
     */
    public String getCST() {
        return CST;
    }

    /**
     * @param CST the CST to set
     */
    public void setCST(String CST) {
        this.CST = CST;
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
     * @return the unidadeProduto
     */
    public String getUnidadeProduto() {
        return unidadeProduto;
    }

    /**
     * @param unidadeProduto the unidadeProduto to set
     */
    public void setUnidadeProduto(String unidadeProduto) {
        this.unidadeProduto = unidadeProduto;
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
     * @return the ECFICMS
     */
    public String getECFICMS() {
        return ECFICMS;
    }

    /**
     * @param ECFICMS the ECFICMS to set
     */
    public void setECFICMS(String ECFICMS) {
        this.ECFICMS = ECFICMS;
    }

    /**
     * @return the identificacaoCliente
     */
    public String getIdentificacaoCliente() {
        return identificacaoCliente;
    }

    /**
     * @param identificacaoCliente the identificacaoCliente to set
     */
    public void setIdentificacaoCliente(String identificacaoCliente) {
        this.identificacaoCliente = identificacaoCliente;
    }

    /**
     * @return the acrescimoRateio
     */
    public double getAcrescimoRateio() {
        return acrescimoRateio;
    }

    /**
     * @param acrescimoRateio the acrescimoRateio to set
     */
    public void setAcrescimoRateio(double acrescimoRateio) {
        this.acrescimoRateio = acrescimoRateio;
    }

    /**
     * @return the descontoRateio
     */
    public double getDescontoRateio() {
        return descontoRateio;
    }

    /**
     * @param descontoRateio the descontoRateio to set
     */
    public void setDescontoRateio(double descontoRateio) {
        this.descontoRateio = descontoRateio;
    }

    /**
     * @return the hashTripa
     */
    public String getHashTripa() {
        return hashTripa;
    }

    /**
     * @param hashTripa the hashTripa to set
     */
    public void setHashTripa(String hashTripa) {
        this.hashTripa = hashTripa;
    }

    /**
     * @return the ccf
     */
    public Integer getCcf() {
        return ccf;
    }

    /**
     * @param ccf the ccf to set
     */
    public void setCcf(Integer ccf) {
        this.ccf = ccf;
    }

    /**
     * @return the coo
     */
    public Integer getCoo() {
        return coo;
    }

    /**
     * @param coo the coo to set
     */
    public void setCoo(Integer coo) {
        this.coo = coo;
    }

    /**
     * @return the serieEcf
     */
    public String getSerieEcf() {
        return serieEcf;
    }

    /**
     * @param serieEcf the serieEcf to set
     */
    public void setSerieEcf(String serieEcf) {
        this.serieEcf = serieEcf;
    }

    /**
     * @return the ecfIcmsSt
     */
    public String getEcfIcmsSt() {
        return ecfIcmsSt;
    }

    /**
     * @param ecfIcmsSt the ecfIcmsSt to set
     */
    public void setEcfIcmsSt(String ecfIcmsSt) {
        this.ecfIcmsSt = ecfIcmsSt;
    }

    /**
     * @return the hashIncremento
     */
    public Integer getHashIncremento() {
        return hashIncremento;
    }

    /**
     * @param hashIncremento the hashIncremento to set
     */
    public void setHashIncremento(Integer hashIncremento) {
        this.hashIncremento = hashIncremento;
    }

}