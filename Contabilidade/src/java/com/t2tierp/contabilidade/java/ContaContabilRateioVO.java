package com.t2tierp.contabilidade.java;

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
* <p>Description:  VO relacionado a tabela [CONTA_CONTABIL_RATEIO]</p>
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
@Table(name = "CONTA_CONTABIL_RATEIO")
public class ContaContabilRateioVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "PORCENTO_RATEIRO")
    private BigDecimal porcentoRateiro;
    @JoinColumn(name = "ID_CONTABIL_CONTA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ContabilContaVO contabilConta;
    @JoinColumn(name = "ID_CENTRO_RESULTADO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CentroResultadoVO centroResultado;

    public ContaContabilRateioVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPorcentoRateiro() {
        return porcentoRateiro;
    }

    public void setPorcentoRateiro(BigDecimal porcentoRateiro) {
        this.porcentoRateiro = porcentoRateiro;
    }

    public ContabilContaVO getContabilConta() {
        return contabilConta;
    }

    public void setContabilConta(ContabilContaVO contabilConta) {
        this.contabilConta = contabilConta;
    }

    public CentroResultadoVO getCentroResultado() {
        return centroResultado;
    }

    public void setCentroResultado(CentroResultadoVO centroResultado) {
        this.centroResultado = centroResultado;
    }


    @Override
    public String toString() {
        return "com.t2tierp.contabilidade.java.ContaContabilRateioVO[id=" + id + "]";
    }

}
