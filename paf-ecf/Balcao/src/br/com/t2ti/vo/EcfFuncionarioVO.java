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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author T2Ti
 */
@Entity
@Table(name = "ecf_funcionario")
@NamedQueries({
    @NamedQuery(name = "EcfFuncionarioVO.findAll", query = "SELECT e FROM EcfFuncionarioVO e")})
public class EcfFuncionarioVO extends ValueObjectImpl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "CELULAR")
    private String celular;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "COMISSAO_VISTA")
    private Double comissaoVista;
    @Column(name = "COMISSAO_PRAZO")
    private Double comissaoPrazo;
    @Column(name = "NIVEL_AUTORIZACAO")
    private Character nivelAutorizacao;

    public EcfFuncionarioVO() {
    }

    public EcfFuncionarioVO(Integer id) {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getComissaoVista() {
        return comissaoVista;
    }

    public void setComissaoVista(Double comissaoVista) {
        this.comissaoVista = comissaoVista;
    }

    public Double getComissaoPrazo() {
        return comissaoPrazo;
    }

    public void setComissaoPrazo(Double comissaoPrazo) {
        this.comissaoPrazo = comissaoPrazo;
    }

    public Character getNivelAutorizacao() {
        return nivelAutorizacao;
    }

    public void setNivelAutorizacao(Character nivelAutorizacao) {
        this.nivelAutorizacao = nivelAutorizacao;
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
        if (!(object instanceof EcfFuncionarioVO)) {
            return false;
        }
        EcfFuncionarioVO other = (EcfFuncionarioVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.t2ti.vo.EcfFuncionarioVO[id=" + id + "]";
    }

}
