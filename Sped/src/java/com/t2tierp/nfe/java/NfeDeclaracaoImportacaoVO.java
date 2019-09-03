package com.t2tierp.nfe.java;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.openswing.swing.message.receive.java.ValueObjectImpl;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [NFE_DECLARACAO_IMPORTACAO]</p>
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
@Table(name = "NFE_DECLARACAO_IMPORTACAO")
public class NfeDeclaracaoImportacaoVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_REGISTRO")
    private Date dataRegistro;
    @Column(name = "LOCAL_DESEMBARACO")
    private String localDesembaraco;
    @Column(name = "UF_DESEMBARACO")
    private String ufDesembaraco;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_DESEMBARACO")
    private Date dataDesembaraco;
    @Column(name = "CODIGO_EXPORTADOR")
    private String codigoExportador;
    @JoinColumn(name = "ID_NFE_DETALHE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private NfeDetalheVO nfeDetalhe;
    @OneToMany(mappedBy = "nfeDeclaracaoImportacao")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<NfeImportacaoDetalheVO> listaImportacaoDetalhe;

    public NfeDeclaracaoImportacaoVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getLocalDesembaraco() {
        return localDesembaraco;
    }

    public void setLocalDesembaraco(String localDesembaraco) {
        this.localDesembaraco = localDesembaraco;
    }

    public String getUfDesembaraco() {
        return ufDesembaraco;
    }

    public void setUfDesembaraco(String ufDesembaraco) {
        this.ufDesembaraco = ufDesembaraco;
    }

    public Date getDataDesembaraco() {
        return dataDesembaraco;
    }

    public void setDataDesembaraco(Date dataDesembaraco) {
        this.dataDesembaraco = dataDesembaraco;
    }

    public String getCodigoExportador() {
        return codigoExportador;
    }

    public void setCodigoExportador(String codigoExportador) {
        this.codigoExportador = codigoExportador;
    }

    public NfeDetalheVO getNfeDetalhe() {
        return nfeDetalhe;
    }

    public void setNfeDetalhe(NfeDetalheVO nfeDetalhe) {
        this.nfeDetalhe = nfeDetalhe;
    }


    @Override
    public String toString() {
        return "com.t2tierp.nfe.java.NfeDeclaracaoImportacaoVO[id=" + id + "]";
    }

    public List<NfeImportacaoDetalheVO> getListaImportacaoDetalhe() {
        return listaImportacaoDetalhe;
    }

    public void setListaImportacaoDetalhe(List<NfeImportacaoDetalheVO> listaImportacaoDetalhe) {
        this.listaImportacaoDetalhe = listaImportacaoDetalhe;
    }

}
