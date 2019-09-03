package com.t2tierp.pafecf.vo;

import java.util.Date;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Objeto de valor referente a tabela Produto em Promoção.</p>
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
public class ProdutoPromocaoVO {

    private Integer id;
    private Integer idProduto;
    private Date dataInicio;
    private Date eataFim;
    private Double quantidadeEmPromocao;
    private Double quantidadeMaximaPorCliente;
    private Double valor;

    public ProdutoPromocaoVO() {
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
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the eataFim
     */
    public Date getEataFim() {
        return eataFim;
    }

    /**
     * @param eataFim the eataFim to set
     */
    public void setEataFim(Date eataFim) {
        this.eataFim = eataFim;
    }

    /**
     * @return the quantidadeEmPromocao
     */
    public Double getQuantidadeEmPromocao() {
        return quantidadeEmPromocao;
    }

    /**
     * @param quantidadeEmPromocao the quantidadeEmPromocao to set
     */
    public void setQuantidadeEmPromocao(Double quantidadeEmPromocao) {
        this.quantidadeEmPromocao = quantidadeEmPromocao;
    }

    /**
     * @return the quantidadeMaximaPorCliente
     */
    public Double getQuantidadeMaximaPorCliente() {
        return quantidadeMaximaPorCliente;
    }

    /**
     * @param quantidadeMaximaPorCliente the quantidadeMaximaPorCliente to set
     */
    public void setQuantidadeMaximaPorCliente(Double quantidadeMaximaPorCliente) {
        this.quantidadeMaximaPorCliente = quantidadeMaximaPorCliente;
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

}