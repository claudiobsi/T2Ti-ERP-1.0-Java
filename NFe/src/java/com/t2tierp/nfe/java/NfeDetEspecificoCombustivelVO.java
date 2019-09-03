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
* <p>Description:  VO relacionado a tabela [NFE_DET_ESPECIFICO_COMBUSTIVEL]</p>
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
@Table(name = "NFE_DET_ESPECIFICO_COMBUSTIVEL")
public class NfeDetEspecificoCombustivelVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CODIGO_ANP")
    private Integer codigoAnp;
    @Column(name = "CODIF")
    private String codif;
    @Column(name = "QUANTIDADE_TEMP_AMBIENTE")
    private BigDecimal quantidadeTempAmbiente;
    @Column(name = "UF_CONSUMO")
    private String ufConsumo;
    @Column(name = "BASE_CALCULO_CIDE")
    private BigDecimal baseCalculoCide;
    @Column(name = "ALIQUOTA_CIDE")
    private BigDecimal aliquotaCide;
    @Column(name = "VALOR_CIDE")
    private BigDecimal valorCide;
    @JoinColumn(name = "ID_NFE_DETALHE", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private NfeDetalheVO nfeDetalhe;

    public NfeDetEspecificoCombustivelVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigoAnp() {
        return codigoAnp;
    }

    public void setCodigoAnp(Integer codigoAnp) {
        this.codigoAnp = codigoAnp;
    }

    public String getCodif() {
        return codif;
    }

    public void setCodif(String codif) {
        this.codif = codif;
    }

    public BigDecimal getQuantidadeTempAmbiente() {
        return quantidadeTempAmbiente;
    }

    public void setQuantidadeTempAmbiente(BigDecimal quantidadeTempAmbiente) {
        this.quantidadeTempAmbiente = quantidadeTempAmbiente;
    }

    public String getUfConsumo() {
        return ufConsumo;
    }

    public void setUfConsumo(String ufConsumo) {
        this.ufConsumo = ufConsumo;
    }

    public BigDecimal getBaseCalculoCide() {
        return baseCalculoCide;
    }

    public void setBaseCalculoCide(BigDecimal baseCalculoCide) {
        this.baseCalculoCide = baseCalculoCide;
    }

    public BigDecimal getAliquotaCide() {
        return aliquotaCide;
    }

    public void setAliquotaCide(BigDecimal aliquotaCide) {
        this.aliquotaCide = aliquotaCide;
    }

    public BigDecimal getValorCide() {
        return valorCide;
    }

    public void setValorCide(BigDecimal valorCide) {
        this.valorCide = valorCide;
    }

    public NfeDetalheVO getNfeDetalhe() {
        return nfeDetalhe;
    }

    public void setNfeDetalhe(NfeDetalheVO nfeDetalhe) {
        this.nfeDetalhe = nfeDetalhe;
    }


    @Override
    public String toString() {
        return "com.t2tierp.nfe.java.NfeDetEspecificoCombustivelVO[id=" + id + "]";
    }

}
