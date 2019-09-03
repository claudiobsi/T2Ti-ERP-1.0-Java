package com.t2tierp.nfe.java;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.openswing.swing.message.receive.java.ValueObjectImpl;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [NFE_DETALHE_IMPOSTO_ISSQN]</p>
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
@Table(name = "NFE_DETALHE_IMPOSTO_ISSQN")
public class NfeDetalheImpostoIssqnVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "BASE_CALCULO_ISSQN")
    private BigDecimal baseCalculoIssqn;
    @Column(name = "ALIQUOTA_ISSQN")
    private BigDecimal aliquotaIssqn;
    @Column(name = "VALOR_ISSQN")
    private BigDecimal valorIssqn;
    @Column(name = "MUNICIPIO_ISSQN")
    private Integer municipioIssqn;
    @Column(name = "ITEM_LISTA_SERVICOS")
    private Integer itemListaServicos;
    @Column(name = "TRIBUTACAO_ISSQN")
    private String tributacaoIssqn;
    @JoinColumn(name = "ID_NFE_DETALHE", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private NfeDetalheVO nfeDetalhe;

    public NfeDetalheImpostoIssqnVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getBaseCalculoIssqn() {
        return baseCalculoIssqn;
    }

    public void setBaseCalculoIssqn(BigDecimal baseCalculoIssqn) {
        this.baseCalculoIssqn = baseCalculoIssqn;
    }

    public BigDecimal getAliquotaIssqn() {
        return aliquotaIssqn;
    }

    public void setAliquotaIssqn(BigDecimal aliquotaIssqn) {
        this.aliquotaIssqn = aliquotaIssqn;
    }

    public BigDecimal getValorIssqn() {
        return valorIssqn;
    }

    public void setValorIssqn(BigDecimal valorIssqn) {
        this.valorIssqn = valorIssqn;
    }

    public Integer getMunicipioIssqn() {
        return municipioIssqn;
    }

    public void setMunicipioIssqn(Integer municipioIssqn) {
        this.municipioIssqn = municipioIssqn;
    }

    public Integer getItemListaServicos() {
        return itemListaServicos;
    }

    public void setItemListaServicos(Integer itemListaServicos) {
        this.itemListaServicos = itemListaServicos;
    }

    public String getTributacaoIssqn() {
        return tributacaoIssqn;
    }

    public void setTributacaoIssqn(String tributacaoIssqn) {
        this.tributacaoIssqn = tributacaoIssqn;
    }

    public NfeDetalheVO getNfeDetalhe() {
        return nfeDetalhe;
    }

    public void setNfeDetalhe(NfeDetalheVO nfeDetalhe) {
        this.nfeDetalhe = nfeDetalhe;
    }


    @Override
    public String toString() {
        return "com.t2tierp.nfe.java.NfeDetalheImpostoIssqnVO[id=" + id + "]";
    }

}
