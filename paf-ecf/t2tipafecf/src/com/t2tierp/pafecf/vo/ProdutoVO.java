package com.t2tierp.pafecf.vo;

import java.util.Date;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Objeto de valor referente a tabela Produto.</p>
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
public class ProdutoVO {
    private Integer id;
    private Integer idUnidade;
    private String GTIN;
    private String codigoInterno;
    private String nome;
    private String descricao;
    private String descricaoPDV;
    private Double valorVenda;
    private Date dataEstoque;
    private String horaEstoque;
    private Double quantidadeEstoque;
    private Double quantidadeEstoqueAnterior;
    private Double estoqueMinimo;
    private Double estoqueMaximo;
    private String IAT;
    private String IPPT;
    private String NCM;
    private String unidadeProduto;
    private String situacaoTributaria;
    private String totalizadorParcial;
    private String ECFICMS;
    private Double aliquotaICMS;
    private String podeFracionar;

    private Double taxaIPI;
    private Double taxaISSQN;
    private Double taxaPIS;
    private Double taxaCOFINS;
    private Double taxaICMS;
    private String CST;
    private String hashTripa;
    private Integer hashIncremento;

    public ProdutoVO() {
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
     * @return the idUnidade
     */
    public Integer getIdUnidade() {
        return idUnidade;
    }

    /**
     * @param idUnidade the idUnidade to set
     */
    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
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
     * @return the codigoInterno
     */
    public String getCodigoInterno() {
        return codigoInterno;
    }

    /**
     * @param codigoInterno the codigoInterno to set
     */
    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
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
     * @return the quantidadeEstoque
     */
    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /**
     * @param quantidadeEstoque the quantidadeEstoque to set
     */
    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    /**
     * @return the estoqueMinimo
     */
    public Double getEstoqueMinimo() {
        return estoqueMinimo;
    }

    /**
     * @param estoqueMinimo the estoqueMinimo to set
     */
    public void setEstoqueMinimo(Double estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    /**
     * @return the estoqueMaximo
     */
    public Double getEstoqueMaximo() {
        return estoqueMaximo;
    }

    /**
     * @param estoqueMaximo the estoqueMaximo to set
     */
    public void setEstoqueMaximo(Double estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
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
     * @return the NCM
     */
    public String getNCM() {
        return NCM;
    }

    /**
     * @param NCM the NCM to set
     */
    public void setNCM(String NCM) {
        this.NCM = NCM;
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

    /**
     * @return the podeFracionar
     */
    public String getPodeFracionar() {
        return podeFracionar;
    }

    /**
     * @param podeFracionar the podeFracionar to set
     */
    public void setPodeFracionar(String podeFracionar) {
        this.podeFracionar = podeFracionar;
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
     * @return the quantidadeEstoqueAnterior
     */
    public Double getQuantidadeEstoqueAnterior() {
        return quantidadeEstoqueAnterior;
    }

    /**
     * @param quantidadeEstoqueAnterior the quantidadeEstoqueAnterior to set
     */
    public void setQuantidadeEstoqueAnterior(Double quantidadeEstoqueAnterior) {
        this.quantidadeEstoqueAnterior = quantidadeEstoqueAnterior;
    }

    /**
     * @return the dataEstoque
     */
    public Date getDataEstoque() {
        return dataEstoque;
    }

    /**
     * @param dataEstoque the dataEstoque to set
     */
    public void setDataEstoque(Date dataEstoque) {
        this.dataEstoque = dataEstoque;
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

    /**
     * @return the horaEstoque
     */
    public String getHoraEstoque() {
        return horaEstoque;
    }

    /**
     * @param horaEstoque the horaEstoque to set
     */
    public void setHoraEstoque(String horaEstoque) {
        this.horaEstoque = horaEstoque;
    }

}