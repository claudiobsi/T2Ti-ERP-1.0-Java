/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.t2ti.vo;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author T2Ti
 */
@Entity
@Table(name = "nota_fiscal_cabecalho")
@NamedQueries({
    @NamedQuery(name = "NotaFiscalCabecalhoVO.findAll", query = "SELECT n FROM NotaFiscalCabecalhoVO n")})
public class NotaFiscalCabecalhoVO extends ValueObjectImpl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CFOP")
    private Integer cfop;
    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "DATA_EMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    @Column(name = "HORA_EMISSAO")
    private String horaEmissao;
    @Column(name = "SERIE")
    private String serie;
    @Column(name = "SUBSERIE")
    private String subserie;
    @Column(name = "TOTAL_PRODUTOS")
    private BigDecimal totalProdutos;
    @Column(name = "TOTAL_NF")
    private BigDecimal totalNf;
    @Column(name = "BASE_ICMS")
    private BigDecimal baseIcms;
    @Column(name = "ICMS")
    private BigDecimal icms;
    @Column(name = "ICMS_OUTRAS")
    private BigDecimal icmsOutras;
    @Column(name = "ISSQN")
    private BigDecimal issqn;
    @Column(name = "PIS")
    private BigDecimal pis;
    @Column(name = "COFINS")
    private BigDecimal cofins;
    @Column(name = "IPI")
    private BigDecimal ipi;
    @Column(name = "TAXA_ACRESCIMO")
    private BigDecimal taxaAcrescimo;
    @Column(name = "ACRESCIMO")
    private BigDecimal acrescimo;
    @Column(name = "ACRESCIMO_ITENS")
    private BigDecimal acrescimoItens;
    @Column(name = "TAXA_DESCONTO")
    private BigDecimal taxaDesconto;
    @Column(name = "DESCONTO")
    private BigDecimal desconto;
    @Column(name = "DESCONTO_ITENS")
    private BigDecimal descontoItens;
    @Column(name = "CANCELADA")
    private String cancelada;
    @Column(name = "SINCRONIZADO")
    private String sincronizado;
    @Column(name = "TIPO_NOTA")
    private String tipoNota;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ClienteVO cliente;
    @JoinColumn(name = "ID_ECF_FUNCIONARIO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EcfFuncionarioVO funcionario;

    public NotaFiscalCabecalhoVO() {
    }

    public NotaFiscalCabecalhoVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCfop() {
        return cfop;
    }

    public void setCfop(Integer cfop) {
        this.cfop = cfop;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getHoraEmissao() {
        return horaEmissao;
    }

    public void setHoraEmissao(String horaEmissao) {
        this.horaEmissao = horaEmissao;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getSubserie() {
        return subserie;
    }

    public void setSubserie(String subserie) {
        this.subserie = subserie;
    }

    public BigDecimal getTotalProdutos() {
        return totalProdutos;
    }

    public void setTotalProdutos(BigDecimal totalProdutos) {
        this.totalProdutos = totalProdutos;
    }

    public BigDecimal getTotalNf() {
        return totalNf;
    }

    public void setTotalNf(BigDecimal totalNf) {
        this.totalNf = totalNf;
    }

    public BigDecimal getBaseIcms() {
        return baseIcms;
    }

    public void setBaseIcms(BigDecimal baseIcms) {
        this.baseIcms = baseIcms;
    }

    public BigDecimal getIcms() {
        return icms;
    }

    public void setIcms(BigDecimal icms) {
        this.icms = icms;
    }

    public BigDecimal getIcmsOutras() {
        return icmsOutras;
    }

    public void setIcmsOutras(BigDecimal icmsOutras) {
        this.icmsOutras = icmsOutras;
    }

    public BigDecimal getIssqn() {
        return issqn;
    }

    public void setIssqn(BigDecimal issqn) {
        this.issqn = issqn;
    }

    public BigDecimal getPis() {
        return pis;
    }

    public void setPis(BigDecimal pis) {
        this.pis = pis;
    }

    public BigDecimal getCofins() {
        return cofins;
    }

    public void setCofins(BigDecimal cofins) {
        this.cofins = cofins;
    }

    public BigDecimal getIpi() {
        return ipi;
    }

    public void setIpi(BigDecimal ipi) {
        this.ipi = ipi;
    }

    public BigDecimal getTaxaAcrescimo() {
        return taxaAcrescimo;
    }

    public void setTaxaAcrescimo(BigDecimal taxaAcrescimo) {
        this.taxaAcrescimo = taxaAcrescimo;
    }

    public BigDecimal getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(BigDecimal acrescimo) {
        this.acrescimo = acrescimo;
    }

    public BigDecimal getAcrescimoItens() {
        return acrescimoItens;
    }

    public void setAcrescimoItens(BigDecimal acrescimoItens) {
        this.acrescimoItens = acrescimoItens;
    }

    public BigDecimal getTaxaDesconto() {
        return taxaDesconto;
    }

    public void setTaxaDesconto(BigDecimal taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getDescontoItens() {
        return descontoItens;
    }

    public void setDescontoItens(BigDecimal descontoItens) {
        this.descontoItens = descontoItens;
    }

    public String getCancelada() {
        return cancelada;
    }

    public void setCancelada(String cancelada) {
        this.cancelada = cancelada;
    }

    public String getSincronizado() {
        return sincronizado;
    }

    public void setSincronizado(String sincronizado) {
        this.sincronizado = sincronizado;
    }

    public String getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaFiscalCabecalhoVO)) {
            return false;
        }
        NotaFiscalCabecalhoVO other = (NotaFiscalCabecalhoVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.t2ti.vo.NotaFiscalCabecalhoVO[id=" + id + "]";
    }

    /**
     * @return the cliente
     */
    public ClienteVO getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteVO cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the funcionario
     */
    public EcfFuncionarioVO getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(EcfFuncionarioVO funcionario) {
        this.funcionario = funcionario;
    }

}
