package com.t2tierp.pafecf.vo;

import java.util.Date;
import java.util.List;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Objeto de valor referente a tabela DAV cabeçalho.</p>
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
public class DAVCabecalhoVO  {
    private Integer id;
    private Integer CCF;
    private Integer COO;
    private String nomeDestinatario;
    private String CpfCnpjDestinatario;
    private Date dataEmissao;
    private String horaEmissao;
    private String situacao;
    private Double valor;
    private String selecao;
    private String hashTripa;
    private Integer hashIncremento;
    private List<DAVDetalheVO> listaDavDetalhe;
    private String numeroDav;
    private String numeroEcf;
    private Integer idPessoa;
    private Double taxaAcrescimo;
    private Double acrescimo;
    private Double taxaDesconto;
    private Double desconto;
    private Double subTotal;
    

    public DAVCabecalhoVO() {
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
     * @return the nomeDestinatario
     */
    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    /**
     * @param nomeDestinatario the nomeDestinatario to set
     */
    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    /**
     * @return the CpfCnpjDestinatario
     */
    public String getCpfCnpjDestinatario() {
        return CpfCnpjDestinatario;
    }

    /**
     * @param CpfCnpjDestinatario the CpfCnpjDestinatario to set
     */
    public void setCpfCnpjDestinatario(String CpfCnpjDestinatario) {
        this.CpfCnpjDestinatario = CpfCnpjDestinatario;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the selecao
     */
    public String getSelecao() {
        return selecao;
    }

    /**
     * @param selecao the selecao to set
     */
    public void setSelecao(String selecao) {
        this.selecao = selecao;
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
     * @return the listaDavDetalhe
     */
    public List<DAVDetalheVO> getListaDavDetalhe() {
        return listaDavDetalhe;
    }

    /**
     * @param listaDavDetalhe the listaDavDetalhe to set
     */
    public void setListaDavDetalhe(List<DAVDetalheVO> listaDavDetalhe) {
        this.listaDavDetalhe = listaDavDetalhe;
    }

    /**
     * @return the numeroDav
     */
    public String getNumeroDav() {
        return numeroDav;
    }

    /**
     * @param numeroDav the numeroDav to set
     */
    public void setNumeroDav(String numeroDav) {
        this.numeroDav = numeroDav;
    }

    /**
     * @return the numeroEcf
     */
    public String getNumeroEcf() {
        return numeroEcf;
    }

    /**
     * @param numeroEcf the numeroEcf to set
     */
    public void setNumeroEcf(String numeroEcf) {
        this.numeroEcf = numeroEcf;
    }

    /**
     * @return the idPessoa
     */
    public Integer getIdPessoa() {
        return idPessoa;
    }

    /**
     * @param idPessoa the idPessoa to set
     */
    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
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
     * @return the subTotal
     */
    public Double getSubTotal() {
        return subTotal;
    }

    /**
     * @param subTotal the subTotal to set
     */
    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

}
