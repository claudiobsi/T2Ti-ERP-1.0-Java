/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.t2ti.vo;

import java.io.Serializable;
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
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author T2Ti
 */
@Entity
@Table(name = "ecf_pre_venda_detalhe")
@NamedQueries({
    @NamedQuery(name = "EcfPreVendaDetalheVO.findAll", query = "SELECT e FROM EcfPreVendaDetalheVO e")})
public class EcfPreVendaDetalheVO extends ValueObjectImpl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "QUANTIDADE")
    private Double quantidade;
    @Column(name = "VALOR_UNITARIO")
    private Double valorUnitario;
    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ProdutoVO produto;
    @JoinColumn(name = "ID_ECF_PRE_VENDA_CABECALHO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EcfPreVendaCabecalhoVO ecfPreVendaCabecalho;

    public EcfPreVendaDetalheVO() {
    }

    public EcfPreVendaDetalheVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
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
        if (!(object instanceof EcfPreVendaDetalheVO)) {
            return false;
        }
        EcfPreVendaDetalheVO other = (EcfPreVendaDetalheVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.t2ti.vo.EcfPreVendaDetalheVO[id=" + id + "]";
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
     * @return the ecfPreVendaCabecalho
     */
    public EcfPreVendaCabecalhoVO getEcfPreVendaCabecalho() {
        return ecfPreVendaCabecalho;
    }

    /**
     * @param ecfPreVendaCabecalho the ecfPreVendaCabecalho to set
     */
    public void setEcfPreVendaCabecalho(EcfPreVendaCabecalhoVO ecfPreVendaCabecalho) {
        this.ecfPreVendaCabecalho = ecfPreVendaCabecalho;
    }

}
