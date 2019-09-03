/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.t2ti.vo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ecf_pre_venda_cabecalho")
@NamedQueries({
    @NamedQuery(name = "EcfPreVendaCabecalhoVO.findAll", query = "SELECT e FROM EcfPreVendaCabecalhoVO e")})
public class EcfPreVendaCabecalhoVO extends ValueObjectImpl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATA_PV")
    @Temporal(TemporalType.DATE)
    private Date dataPv;
    @Column(name = "HORA_PV")
    private String horaPv;
    @Column(name = "SITUACAO")
    private String situacao;
    @Column(name = "CCF")
    private Integer ccf;
    @Column(name = "VALOR")
    private Double valor;

    public EcfPreVendaCabecalhoVO() {
    }

    public EcfPreVendaCabecalhoVO(Integer id) {
        this.id = id;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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
        if (!(object instanceof EcfPreVendaCabecalhoVO)) {
            return false;
        }
        EcfPreVendaCabecalhoVO other = (EcfPreVendaCabecalhoVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.t2ti.vo.EcfPreVendaCabecalhoVO[id=" + id + "]";
    }

}
