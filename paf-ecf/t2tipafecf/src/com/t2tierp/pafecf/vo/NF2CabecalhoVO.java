package com.t2tierp.pafecf.vo;

import java.util.Date;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Objeto de valor referente a tabela NF2 - Cabeçalho.</p>
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
public class NF2CabecalhoVO  {
    private Integer id;
    private Integer idVendedor;
    private Integer idCliente;
    private Integer cfop;
    private String numero;
    private Date dataEmissao;
    private String horaEmissao;
    private String serie;
    private String subserie;
    private Double totalProdutos;
    private Double totalNF;
    private Double baseICMS;
    private Double ICMS;
    private Double ICMSOutras;
    private Double ISSQN;
    private Double PIS;
    private Double COFINS;
    private Double IPI;
    private Double taxaAcrescimo;
    private Double acrescimo;
    private Double acrescimoItens;
    private Double taxaDesconto;
    private Double desconto;
    private Double descontoItens;
    private String cancelada;
    private String sincronizado;

    public NF2CabecalhoVO() {
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
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * @return the subserie
     */
    public String getSubserie() {
        return subserie;
    }

    /**
     * @param subserie the subserie to set
     */
    public void setSubserie(String subserie) {
        this.subserie = subserie;
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
     * @return the totalNF
     */
    public Double getTotalNF() {
        return totalNF;
    }

    /**
     * @param totalNF the totalNF to set
     */
    public void setTotalNF(Double totalNF) {
        this.totalNF = totalNF;
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
     * @return the dataEmissao
     */
    public Date getDataEmissao() {
        return dataEmissao;
    }

    /**
     * @param dataEmissao the dataEmissao to set
     */
    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    /**
     * @return the horaEmissao
     */
    public String getHoraEmissao() {
        return horaEmissao;
    }

    /**
     * @param horaEmissao the horaEmissao to set
     */
    public void setHoraEmissao(String horaEmissao) {
        this.horaEmissao = horaEmissao;
    }
}
