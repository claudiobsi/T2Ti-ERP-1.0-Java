package com.t2tierp.pafecf.java;

import com.t2tierp.cadastros.java.EmpresaVO;
import com.t2tierp.cadastros.java.PessoaVO;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.openswing.swing.message.receive.java.ValueObjectImpl;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [PRE_VENDA_CABECALHO]</p>
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
@Table(name = "PRE_VENDA_CABECALHO")
public class PreVendaCabecalhoVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_PV")
    private Date dataPv;
    @Column(name = "HORA_PV")
    private String horaPv;
    @Column(name = "SITUACAO")
    private String situacao;
    @Column(name = "CCF")
    private Integer ccf;
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "NOME_DESTINATARIO")
    private String nomeDestinatario;
    @Column(name = "CPF_CNPJ_DESTINATARIO")
    private String cpfCnpjDestinatario;
    @Column(name = "SUBTOTAL")
    private BigDecimal subtotal;
    @Column(name = "DESCONTO")
    private BigDecimal desconto;
    @Column(name = "ACRESCIMO")
    private BigDecimal acrescimo;
    @Column(name = "TAXA_ACRESCIMO")
    private BigDecimal taxaAcrescimo;
    @Column(name = "TAXA_DESCONTO")
    private BigDecimal taxaDesconto;
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID")
    @ManyToOne
    private PessoaVO pessoa;
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EmpresaVO empresa;

    public PreVendaCabecalhoVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataPv() {
        return dataPv;
    }

    public void setDataPv(Date dataPv) {
        this.dataPv = dataPv;
    }

    public String getHoraPv() {
        return horaPv;
    }

    public void setHoraPv(String horaPv) {
        this.horaPv = horaPv;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Integer getCcf() {
        return ccf;
    }

    public void setCcf(Integer ccf) {
        this.ccf = ccf;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public String getCpfCnpjDestinatario() {
        return cpfCnpjDestinatario;
    }

    public void setCpfCnpjDestinatario(String cpfCnpjDestinatario) {
        this.cpfCnpjDestinatario = cpfCnpjDestinatario;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(BigDecimal acrescimo) {
        this.acrescimo = acrescimo;
    }

    public BigDecimal getTaxaAcrescimo() {
        return taxaAcrescimo;
    }

    public void setTaxaAcrescimo(BigDecimal taxaAcrescimo) {
        this.taxaAcrescimo = taxaAcrescimo;
    }

    public BigDecimal getTaxaDesconto() {
        return taxaDesconto;
    }

    public void setTaxaDesconto(BigDecimal taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }

    public PessoaVO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaVO pessoa) {
        this.pessoa = pessoa;
    }

    public EmpresaVO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaVO empresa) {
        this.empresa = empresa;
    }


    @Override
    public String toString() {
        return "com.t2tierp.pafecf.java.PreVendaCabecalhoVO[id=" + id + "]";
    }

}
