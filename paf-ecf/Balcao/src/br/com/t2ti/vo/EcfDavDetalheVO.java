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
@Table(name = "dav_detalhe")
@NamedQueries({
    @NamedQuery(name = "EcfDavDetalheVO.findAll", query = "SELECT e FROM EcfDavDetalheVO e")})
public class EcfDavDetalheVO extends ValueObjectImpl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ITEM")
    private Integer item;
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "VALOR_UNITARIO")
    private BigDecimal valorUnitario;
    @Column(name = "VALOR_TOTAL")
    private BigDecimal valorTotal;
    @Column(name = "CANCELADO")
    private String cancelado;
    @Column(name = "MESCLA_PRODUTO")
    private String mesclaProduto;
    @Column(name = "GTIN_PRODUTO")
    private String gtinProduto;
    @Column(name = "NOME_PRODUTO")
    private String nomeProduto;
    @Column(name = "UNIDADE_PRODUTO")
    private String unidadeProduto;
    @Column(name = "HASH_TRIPA")
    private String hashTripa;
    @Column(name = "HASH_INCREMENTO")
    private Integer hashIncremento;
    @Column(name = "DATA_EMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    @Column(name = "NUMERO_DAV")
    private String numeroDav;
    @Column(name = "TOTALIZADOR_PARCIAL")
    private String totalizadorParcial;
    @JoinColumn(name = "ID_DAV_CABECALHO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EcfDavCabecalhoVO ecfDavCabecalhoVO;
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ProdutoVO produto;



    public EcfDavDetalheVO() {
    }

    public EcfDavDetalheVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCancelado() {
        return cancelado;
    }

    public void setCancelado(String cancelado) {
        this.cancelado = cancelado;
    }

    public String getMesclaProduto() {
        return mesclaProduto;
    }

    public void setMesclaProduto(String mesclaProduto) {
        this.mesclaProduto = mesclaProduto;
    }

    public String getGtinProduto() {
        return gtinProduto;
    }

    public void setGtinProduto(String gtinProduto) {
        this.gtinProduto = gtinProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getUnidadeProduto() {
        return unidadeProduto;
    }

    public void setUnidadeProduto(String unidadeProduto) {
        this.unidadeProduto = unidadeProduto;
    }

    public String getHashTripa() {
        return hashTripa;
    }

    public void setHashTripa(String hashTripa) {
        this.hashTripa = hashTripa;
    }

    public Integer getHashIncremento() {
        return hashIncremento;
    }

    public void setHashIncremento(Integer hashIncremento) {
        this.hashIncremento = hashIncremento;
    }

    public EcfDavCabecalhoVO getEcfDavCabecalhoVO() {
        return ecfDavCabecalhoVO;
    }

    public void setEcfDavCabecalhoVO(EcfDavCabecalhoVO ecfDavCabecalhoVO) {
        this.ecfDavCabecalhoVO = ecfDavCabecalhoVO;
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
        if (!(object instanceof EcfDavDetalheVO)) {
            return false;
        }
        EcfDavDetalheVO other = (EcfDavDetalheVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.t2ti.vo.EcfDavDetalheVO[id=" + id + "]";
    }

    /**
     * @return the produto
     */
    public ProdutoVO getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(ProdutoVO produto) {
        this.produto = produto;
    }

    /**
     * @return the dataEmissao
     */
    public Date getDataEmissao() {
        return dataEmissao;
    }

    /**
     * @param dataEmissao the dataEmissao to set
     */
    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    /**
     * @return the numeroDav
     */
    public String getNumeroDav() {
        return numeroDav;
    }

    /**
     * @param numeroDav the numeroDav to set
     */
    public void setNumeroDav(String numeroDav) {
        this.numeroDav = numeroDav;
    }

    /**
     * @return the totalizadorParcial
     */
    public String getTotalizadorParcial() {
        return totalizadorParcial;
    }

    /**
     * @param totalizadorParcial the totalizadorParcial to set
     */
    public void setTotalizadorParcial(String totalizadorParcial) {
        this.totalizadorParcial = totalizadorParcial;
    }

}
