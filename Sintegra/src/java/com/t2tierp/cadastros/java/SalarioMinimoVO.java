package com.t2tierp.cadastros.java;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.openswing.swing.message.receive.java.ValueObjectImpl;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [SALARIO_MINIMO]</p>
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
@Table(name = "SALARIO_MINIMO")
public class SalarioMinimoVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "VIGENCIA")
    private Date vigencia;
    @Column(name = "VALOR_MENSAL")
    private BigDecimal valorMensal;
    @Column(name = "VALOR_DIARIO")
    private BigDecimal valorDiario;
    @Column(name = "VALOR_HORA")
    private BigDecimal valorHora;
    @Column(name = "NORMA_LEGAL")
    private String normaLegal;
    @Temporal(TemporalType.DATE)
    @Column(name = "DOU")
    private Date dou;

    public SalarioMinimoVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public BigDecimal getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(BigDecimal valorMensal) {
        this.valorMensal = valorMensal;
    }

    public BigDecimal getValorDiario() {
        return valorDiario;
    }

    public void setValorDiario(BigDecimal valorDiario) {
        this.valorDiario = valorDiario;
    }

    public BigDecimal getValorHora() {
        return valorHora;
    }

    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    public String getNormaLegal() {
        return normaLegal;
    }

    public void setNormaLegal(String normaLegal) {
        this.normaLegal = normaLegal;
    }

    public Date getDou() {
        return dou;
    }

    public void setDou(Date dou) {
        this.dou = dou;
    }


    @Override
    public String toString() {
        return "com.t2tierp.cadastros.java.SalarioMinimoVO[id=" + id + "]";
    }

}
