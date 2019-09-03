/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.t2tierp.pafecf.vo;

import java.math.BigDecimal;


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
 * @author Claudio de Barros (T2Ti.COM)
 * @version 1.0
 */

public class NotaFiscalDetalheVO {

    private Integer id;
    private Integer idNotaCabecalho;
    private Integer idProduto;
    private Integer cfop;
    private Integer item;
    private BigDecimal quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
    private BigDecimal baseIcms;
    private BigDecimal taxaIcms;
    private BigDecimal icms;
    private BigDecimal icmsOutras;
    private BigDecimal icmsIsento;
    private BigDecimal taxaDesconto;
    private BigDecimal desconto;
    private BigDecimal taxaIssqn;
    private BigDecimal issqn;
    private BigDecimal taxaPis;
    private BigDecimal pis;
    private BigDecimal taxaCofins;
    private BigDecimal cofins;
    private BigDecimal taxaAcrescimo;
    private BigDecimal acrescimo;
    private BigDecimal taxaIpi;
    private BigDecimal ipi;
    private String cancelado;
    private String movimentaEstoque;
    private String sincronizado;
    private String cst;
    private String ecfIcmsSt;
    private String gtinProduto;
    private String descricaoProduto;

    public NotaFiscalDetalheVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCfop() {
        return cfop;
    }

    public void setCfop(Integer cfop) {
        this.cfop = cfop;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getBaseIcms() {
        return baseIcms;
    }

    public void setBaseIcms(BigDecimal baseIcms) {
        this.baseIcms = baseIcms;
    }

    public BigDecimal getTaxaIcms() {
        return taxaIcms;
    }

    public void setTaxaIcms(BigDecimal taxaIcms) {
        this.taxaIcms = taxaIcms;
    }

    public BigDecimal getIcms() {
        return icms;
    }

    public void setIcms(BigDecimal icms) {
        this.icms = icms;
    }

    public BigDecimal getIcmsOutras() {
        return icmsOutras;
    }

    public void setIcmsOutras(BigDecimal icmsOutras) {
        this.icmsOutras = icmsOutras;
    }

    public BigDecimal getIcmsIsento() {
        return icmsIsento;
    }

    public void setIcmsIsento(BigDecimal icmsIsento) {
        this.icmsIsento = icmsIsento;
    }

    public BigDecimal getTaxaDesconto() {
        return taxaDesconto;
    }

    public void setTaxaDesconto(BigDecimal taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getTaxaIssqn() {
        return taxaIssqn;
    }

    public void setTaxaIssqn(BigDecimal taxaIssqn) {
        this.taxaIssqn = taxaIssqn;
    }

    public BigDecimal getIssqn() {
        return issqn;
    }

    public void setIssqn(BigDecimal issqn) {
        this.issqn = issqn;
    }

    public BigDecimal getTaxaPis() {
        return taxaPis;
    }

    public void setTaxaPis(BigDecimal taxaPis) {
        this.taxaPis = taxaPis;
    }

    public BigDecimal getPis() {
        return pis;
    }

    public void setPis(BigDecimal pis) {
        this.pis = pis;
    }

    public BigDecimal getTaxaCofins() {
        return taxaCofins;
    }

    public void setTaxaCofins(BigDecimal taxaCofins) {
        this.taxaCofins = taxaCofins;
    }

    public BigDecimal getCofins() {
        return cofins;
    }

    public void setCofins(BigDecimal cofins) {
        this.cofins = cofins;
    }

    public BigDecimal getTaxaAcrescimo() {
        return taxaAcrescimo;
    }

    public void setTaxaAcrescimo(BigDecimal taxaAcrescimo) {
        this.taxaAcrescimo = taxaAcrescimo;
    }

    public BigDecimal getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(BigDecimal acrescimo) {
        this.acrescimo = acrescimo;
    }

    public BigDecimal getTaxaIpi() {
        return taxaIpi;
    }

    public void setTaxaIpi(BigDecimal taxaIpi) {
        this.taxaIpi = taxaIpi;
    }

    public BigDecimal getIpi() {
        return ipi;
    }

    public void setIpi(BigDecimal ipi) {
        this.ipi = ipi;
    }

    public String getCancelado() {
        return cancelado;
    }

    public void setCancelado(String cancelado) {
        this.cancelado = cancelado;
    }

    public String getMovimentaEstoque() {
        return movimentaEstoque;
    }

    public void setMovimentaEstoque(String movimentaEstoque) {
        this.movimentaEstoque = movimentaEstoque;
    }

    public String getSincronizado() {
        return sincronizado;
    }

    public void setSincronizado(String sincronizado) {
        this.sincronizado = sincronizado;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public String getEcfIcmsSt() {
        return ecfIcmsSt;
    }

    public void setEcfIcmsSt(String ecfIcmsSt) {
        this.ecfIcmsSt = ecfIcmsSt;
    }

    /**
     * @return the idNotaCabecalho
     */
    public Integer getIdNotaCabecalho() {
        return idNotaCabecalho;
    }

    /**
     * @param idNotaCabecalho the idNotaCabecalho to set
     */
    public void setIdNotaCabecalho(Integer idNotaCabecalho) {
        this.idNotaCabecalho = idNotaCabecalho;
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
     * @return the gtinProduto
     */
    public String getGtinProduto() {
        return gtinProduto;
    }

    /**
     * @param gtinProduto the gtinProduto to set
     */
    public void setGtinProduto(String gtinProduto) {
        this.gtinProduto = gtinProduto;
    }

    /**
     * @return the descricaoProduto
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     * @param descricaoProduto the descricaoProduto to set
     */
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

}
