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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author T2Ti
 */
@Entity
@Table(name = "situacao_cliente")
@NamedQueries({
    @NamedQuery(name = "SituacaoClienteVO.findAll", query = "SELECT s FROM SituacaoClienteVO s")})
public class SituacaoClienteVO extends ValueObjectImpl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME")
    private String nome;
    @Lob
    @Column(name = "DESCRICAO")
    private String descricao;

    public SituacaoClienteVO() {
    }

    public SituacaoClienteVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        if (!(object instanceof SituacaoClienteVO)) {
            return false;
        }
        SituacaoClienteVO other = (SituacaoClienteVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.t2ti.vo.SituacaoClienteVO[id=" + id + "]";
    }

}
