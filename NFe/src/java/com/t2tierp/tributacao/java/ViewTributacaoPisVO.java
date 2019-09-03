package com.t2tierp.tributacao.java;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [VIEW_TRIBUTACAO_PIS]</p>
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
@Table(name = "VIEW_TRIBUTACAO_PIS")
public class ViewTributacaoPisVO extends ValueObjectImpl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @Column(name = "ID_TRIBUT_GRUPO_TRIBUTARIO")
    private int idTributGrupoTributario;
    @Basic(optional = false)
    @Column(name = "ID_TRIBUT_OPERACAO_FISCAL")
    private int idTributOperacaoFiscal;
    @Column(name = "CST_PIS")
    private String cstPis;
    @Column(name = "CODIGO_APURACAO_EFD")
    private String codigoApuracaoEfd;
    @Column(name = "MODALIDADE_BASE_CALCULO")
    private String modalidadeBaseCalculo;
    @Column(name = "PORCENTO_BASE_CALCULO")
    private BigDecimal porcentoBaseCalculo;
    @Column(name = "ALIQUOTA_PORCENTO")
    private BigDecimal aliquotaPorcento;
    @Column(name = "ALIQUOTA_UNIDADE")
    private BigDecimal aliquotaUnidade;
    @Column(name = "VALOR_PRECO_MAXIMO")
    private BigDecimal valorPrecoMaximo;
    @Column(name = "VALOR_PAUTA_FISCAL")
    private BigDecimal valorPautaFiscal;

    public ViewTributacaoPisVO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTributGrupoTributario() {
        return idTributGrupoTributario;
    }

    public void setIdTributGrupoTributario(int idTributGrupoTributario) {
        this.idTributGrupoTributario = idTributGrupoTributario;
    }

    public int getIdTributOperacaoFiscal() {
        return idTributOperacaoFiscal;
    }

    public void setIdTributOperacaoFiscal(int idTributOperacaoFiscal) {
        this.idTributOperacaoFiscal = idTributOperacaoFiscal;
    }

    public String getCstPis() {
        return cstPis;
    }

    public void setCstPis(String cstPis) {
        this.cstPis = cstPis;
    }

    public String getCodigoApuracaoEfd() {
        return codigoApuracaoEfd;
    }

    public void setCodigoApuracaoEfd(String codigoApuracaoEfd) {
        this.codigoApuracaoEfd = codigoApuracaoEfd;
    }

    public String getModalidadeBaseCalculo() {
        return modalidadeBaseCalculo;
    }

    public void setModalidadeBaseCalculo(String modalidadeBaseCalculo) {
        this.modalidadeBaseCalculo = modalidadeBaseCalculo;
    }

    public BigDecimal getPorcentoBaseCalculo() {
        return porcentoBaseCalculo;
    }

    public void setPorcentoBaseCalculo(BigDecimal porcentoBaseCalculo) {
        this.porcentoBaseCalculo = porcentoBaseCalculo;
    }

    public BigDecimal getAliquotaPorcento() {
        return aliquotaPorcento;
    }

    public void setAliquotaPorcento(BigDecimal aliquotaPorcento) {
        this.aliquotaPorcento = aliquotaPorcento;
    }

    public BigDecimal getAliquotaUnidade() {
        return aliquotaUnidade;
    }

    public void setAliquotaUnidade(BigDecimal aliquotaUnidade) {
        this.aliquotaUnidade = aliquotaUnidade;
    }

    public BigDecimal getValorPrecoMaximo() {
        return valorPrecoMaximo;
    }

    public void setValorPrecoMaximo(BigDecimal valorPrecoMaximo) {
        this.valorPrecoMaximo = valorPrecoMaximo;
    }

    public BigDecimal getValorPautaFiscal() {
        return valorPautaFiscal;
    }

    public void setValorPautaFiscal(BigDecimal valorPautaFiscal) {
        this.valorPautaFiscal = valorPautaFiscal;
    }

}
