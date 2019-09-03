package com.t2tierp.pafecf.vo;

import java.util.Date;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Objeto de valor referente a tabela de Venda - Cabeçalho.</p>
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
public class VendaCabecalhoVO {

    private Integer id;
    private Integer idDAV;
    private Integer idPreVenda;
    private Integer idCliente;
    private Integer cfop;
    private Integer idVendedor;
    private Integer idMovimento;
    private Integer COO;
    private Integer CCF;
    private Date dataVenda;
    private String horaVenda;
    private Double valorVenda;
    private Double taxaDesconto;
    private Double desconto;
    private Double taxaAcrescimo;
    private Double acrescimo;
    private Double valorFinal;
    private Double valorRecebido;
    private Double troco;
    private Double valorCancelado;
    private String sincronizado;
    private Double totalProdutos;
    private Double totalDocumento;
    private Double baseICMS;
    private Double ICMS;
    private Double ICMSOutras;
    private Double ISSQN;
    private Double PIS;
    private Double COFINS;
    private Double acrescimoItens;
    private Double descontoItens;
    private String cancelada;
    private String statusVenda;
    private String nomeCliente;
    private String CPFouCNPJCliente;
    private String cupomCancelado;
    private String hashTripa;
    private String serieEcf;
    private Integer hashIncremento;

    public VendaCabecalhoVO() {
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
     * @return the idDAV
     */
    public Integer getIdDAV() {
        return idDAV;
    }

    /**
     * @param idDAV the idDAV to set
     */
    public void setIdDAV(Integer idDAV) {
        this.idDAV = idDAV;
    }

    /**
     * @return the idPreVenda
     */
    public Integer getIdPreVenda() {
        return idPreVenda;
    }

    /**
     * @param idPreVenda the idPreVenda to set
     */
    public void setIdPreVenda(Integer idPreVenda) {
        this.idPreVenda = idPreVenda;
    }

    /**
     * @return the idCliente
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the idVendedor
     */
    public Integer getIdVendedor() {
        return idVendedor;
    }

    /**
     * @param idVendedor the idVendedor to set
     */
    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    /**
     * @return the idMovimento
     */
    public Integer getIdMovimento() {
        return idMovimento;
    }

    /**
     * @param idMovimento the idMovimento to set
     */
    public void setIdMovimento(Integer idMovimento) {
        this.idMovimento = idMovimento;
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
     * @return the valorVenda
     */
    public Double getValorVenda() {
        return valorVenda;
    }

    /**
     * @param valorVenda the valorVenda to set
     */
    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
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
     * @return the valorFinal
     */
    public Double getValorFinal() {
        return valorFinal;
    }

    /**
     * @param valorFinal the valorFinal to set
     */
    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    /**
     * @return the valorRecebido
     */
    public Double getValorRecebido() {
        return valorRecebido;
    }

    /**
     * @param valorRecebido the valorRecebido to set
     */
    public void setValorRecebido(Double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    /**
     * @return the troco
     */
    public Double getTroco() {
        return troco;
    }

    /**
     * @param troco the troco to set
     */
    public void setTroco(Double troco) {
        this.troco = troco;
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
     * @return the sincronizado
     */
    public String getSincronizado() {
        return sincronizado;
    }

    /**
     * @param sincronizado the sincronizado to set
     */
    public void setSincronizado(String sincronizado) {
        this.sincronizado = sincronizado;
    }

    /**
     * @return the totalProdutos
     */
    public Double getTotalProdutos() {
        return totalProdutos;
    }

    /**
     * @param totalProdutos the totalProdutos to set
     */
    public void setTotalProdutos(Double totalProdutos) {
        this.totalProdutos = totalProdutos;
    }

    /**
     * @return the totalDocumento
     */
    public Double getTotalDocumento() {
        return totalDocumento;
    }

    /**
     * @param totalDocumento the totalDocumento to set
     */
    public void setTotalDocumento(Double totalDocumento) {
        this.totalDocumento = totalDocumento;
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
     * @return the acrescimoItens
     */
    public Double getAcrescimoItens() {
        return acrescimoItens;
    }

    /**
     * @param acrescimoItens the acrescimoItens to set
     */
    public void setAcrescimoItens(Double acrescimoItens) {
        this.acrescimoItens = acrescimoItens;
    }

    /**
     * @return the descontoItens
     */
    public Double getDescontoItens() {
        return descontoItens;
    }

    /**
     * @param descontoItens the descontoItens to set
     */
    public void setDescontoItens(Double descontoItens) {
        this.descontoItens = descontoItens;
    }

    /**
     * @return the cancelada
     */
    public String getCancelada() {
        return cancelada;
    }

    /**
     * @param cancelada the cancelada to set
     */
    public void setCancelada(String cancelada) {
        this.cancelada = cancelada;
    }

    /**
     * @return the statusVenda
     */
    public String getStatusVenda() {
        return statusVenda;
    }

    /**
     * @param statusVenda the statusVenda to set
     */
    public void setStatusVenda(String statusVenda) {
        this.statusVenda = statusVenda;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the CPFouCNPJCliente
     */
    public String getCPFouCNPJCliente() {
        return CPFouCNPJCliente;
    }

    /**
     * @param CPFouCNPJCliente the CPFouCNPJCliente to set
     */
    public void setCPFouCNPJCliente(String CPFouCNPJCliente) {
        this.CPFouCNPJCliente = CPFouCNPJCliente;
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
     * @return the dataVenda
     */
    public Date getDataVenda() {
        return dataVenda;
    }

    /**
     * @param dataVenda the dataVenda to set
     */
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    /**
     * @return the horaVenda
     */
    public String getHoraVenda() {
        return horaVenda;
    }

    /**
     * @param horaVenda the horaVenda to set
     */
    public void setHoraVenda(String horaVenda) {
        this.horaVenda = horaVenda;
    }

    /**
     * @return the cupomCancelado
     */
    public String getCupomCancelado() {
        return cupomCancelado;
    }

    /**
     * @param cupomCancelado the cupomCancelado to set
     */
    public void setCupomCancelado(String cupomCancelado) {
        this.cupomCancelado = cupomCancelado;
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
