package com.t2tierp.controleestoque.java;

import com.t2tierp.cadastros.java.ProdutoVO;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.openswing.swing.message.receive.java.ValueObjectImpl;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [ESTOQUE_CONTAGEM_DETALHE]</p>
*
* <p>The MIT License</p>
*
* <p>Copyright: Copyright (C) 2010 T2Ti.COM
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
*        The author may be contacted at:
*            t2ti.com@gmail.com</p>
*
* @author Claudio de Barros (t2ti.com@gmail.com)
* @version 1.0
*/
@Entity
@Table(name = "ESTOQUE_CONTAGEM_DETALHE")
public class EstoqueContagemDetalheVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "QUANTIDADE_CONTADA")
    private BigDecimal quantidadeContada;
    @Column(name = "QUANTIDADE_SISTEMA")
    private BigDecimal quantidadeSistema;
    @Column(name = "ACURACIDADE")
    private BigDecimal acuracidade;
    @Column(name = "DIVERGENCIA")
    private BigDecimal divergencia;
    @JoinColumn(name = "ID_ESTOQUE_CONTAGEM_CABECALHO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EstoqueContagemCabecalhoVO estoqueContagemCabecalho;
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ProdutoVO produto;

    public EstoqueContagemDetalheVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getQuantidadeContada() {
        return quantidadeContada;
    }

    public void setQuantidadeContada(BigDecimal quantidadeContada) {
        this.quantidadeContada = quantidadeContada;
    }

    public BigDecimal getQuantidadeSistema() {
        return quantidadeSistema;
    }

    public void setQuantidadeSistema(BigDecimal quantidadeSistema) {
        this.quantidadeSistema = quantidadeSistema;
    }

    public BigDecimal getAcuracidade() {
        return acuracidade;
    }

    public void setAcuracidade(BigDecimal acuracidade) {
        this.acuracidade = acuracidade;
    }

    public BigDecimal getDivergencia() {
        return divergencia;
    }

    public void setDivergencia(BigDecimal divergencia) {
        this.divergencia = divergencia;
    }

    public EstoqueContagemCabecalhoVO getEstoqueContagemCabecalho() {
        return estoqueContagemCabecalho;
    }

    public void setEstoqueContagemCabecalho(EstoqueContagemCabecalhoVO estoqueContagemCabecalho) {
        this.estoqueContagemCabecalho = estoqueContagemCabecalho;
    }

    public ProdutoVO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoVO produto) {
        this.produto = produto;
    }


    @Override
    public String toString() {
        return "com.t2tierp.controleestoque.java.EstoqueContagemDetalheVO[id=" + id + "]";
    }

}
