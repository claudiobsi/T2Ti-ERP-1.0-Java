package com.t2tierp.cadastros.java;

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
* <p>Description:  VO relacionado a tabela [IRRF_DETALHE]</p>
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
@Table(name = "IRRF_DETALHE")
public class IrrfDetalheVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FAIXA")
    private Integer faixa;
    @Column(name = "DE")
    private BigDecimal de;
    @Column(name = "ATE")
    private BigDecimal ate;
    @Column(name = "TAXA")
    private BigDecimal taxa;
    @Column(name = "DESCONTO")
    private BigDecimal desconto;
    @JoinColumn(name = "ID_IRRF", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private IrrfVO irrf;

    public IrrfDetalheVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFaixa() {
        return faixa;
    }

    public void setFaixa(Integer faixa) {
        this.faixa = faixa;
    }

    public BigDecimal getDe() {
        return de;
    }

    public void setDe(BigDecimal de) {
        this.de = de;
    }

    public BigDecimal getAte() {
        return ate;
    }

    public void setAte(BigDecimal ate) {
        this.ate = ate;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public IrrfVO getIrrf() {
        return irrf;
    }

    public void setIrrf(IrrfVO irrf) {
        this.irrf = irrf;
    }


    @Override
    public String toString() {
        return "com.t2tierp.cadastros.java.IrrfDetalheVO[id=" + id + "]";
    }

}
