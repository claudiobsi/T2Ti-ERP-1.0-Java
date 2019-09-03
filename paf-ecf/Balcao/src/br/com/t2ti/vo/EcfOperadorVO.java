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
@Table(name = "ecf_operador")
@NamedQueries({
    @NamedQuery(name = "EcfOperadorVO.findAll", query = "SELECT e FROM EcfOperadorVO e")})
public class EcfOperadorVO extends ValueObjectImpl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "SENHA")
    private String senha;
    @JoinColumn(name = "ID_ECF_FUNCIONARIO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EcfFuncionarioVO ecfFuncionarioVO;

    public EcfOperadorVO() {
    }

    public EcfOperadorVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public EcfFuncionarioVO getEcfFuncionarioVO() {
        return ecfFuncionarioVO;
    }

    public void setEcfFuncionarioVO(EcfFuncionarioVO ecfFuncionarioVO) {
        this.ecfFuncionarioVO = ecfFuncionarioVO;
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
        if (!(object instanceof EcfOperadorVO)) {
            return false;
        }
        EcfOperadorVO other = (EcfOperadorVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.t2ti.vo.EcfOperadorVO[id=" + id + "]";
    }

}
