package com.t2tierp.pafecf.vo;

import java.util.Date;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: VO transiente. Montará os dados necessários para o registro R04.</p>
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
public class R04VO {

    private Integer id;
    private Integer idOperador;
    private Integer CCF;
    private Integer COO;
    private Date dataEmissao;
    private Double subTotal;
    private Double desconto;
    private String indicadorDesconto;
    private Double acrescimo;
    private String indicadorAcrescimo;
    private Double valorLiquido;
    private String cancelado;
    private Double cancelamentoAcrescimo;
    private String ordemDescontoAcrescimo;
    private String cliente;
    private String CPFCNPJ;

    public R04VO() {
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
     * @return the idOperador
     */
    public Integer getIdOperador() {
        return idOperador;
    }

    /**
     * @param idOperador the idOperador to set
     */
    public void setIdOperador(Integer idOperador) {
        this.idOperador = idOperador;
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
     * @return the indicadorDesconto
     */
    public String getIndicadorDesconto() {
        return indicadorDesconto;
    }

    /**
     * @param indicadorDesconto the indicadorDesconto to set
     */
    public void setIndicadorDesconto(String indicadorDesconto) {
        this.indicadorDesconto = indicadorDesconto;
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
     * @return the indicadorAcrescimo
     */
    public String getIndicadorAcrescimo() {
        return indicadorAcrescimo;
    }

    /**
     * @param indicadorAcrescimo the indicadorAcrescimo to set
     */
    public void setIndicadorAcrescimo(String indicadorAcrescimo) {
        this.indicadorAcrescimo = indicadorAcrescimo;
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
     * @return the ordemDescontoAcrescimo
     */
    public String getOrdemDescontoAcrescimo() {
        return ordemDescontoAcrescimo;
    }

    /**
     * @param ordemDescontoAcrescimo the ordemDescontoAcrescimo to set
     */
    public void setOrdemDescontoAcrescimo(String ordemDescontoAcrescimo) {
        this.ordemDescontoAcrescimo = ordemDescontoAcrescimo;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the CPFCNPJ
     */
    public String getCPFCNPJ() {
        return CPFCNPJ;
    }

    /**
     * @param CPFCNPJ the CPFCNPJ to set
     */
    public void setCPFCNPJ(String CPFCNPJ) {
        this.CPFCNPJ = CPFCNPJ;
    }
}
