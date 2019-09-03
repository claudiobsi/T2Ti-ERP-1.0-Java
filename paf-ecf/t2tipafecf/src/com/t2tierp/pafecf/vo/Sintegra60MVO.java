package com.t2tierp.pafecf.vo;

import java.sql.Date;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Objeto de valor referente a tabela Sintegra60M.</p>
 *
 * <p>The MIT License</p>
 *
 * <p>Copyright: Copyright (C) 2010 T2Ti.COM</p>
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
 *       The author may be contacted at:
 *           t2ti.com@gmail.com</p>
 *
 * @author Albert Eije (T2Ti.COM)
 * @version 1.0
 */
public class Sintegra60MVO {
    private Integer id;
    private Date dataEmissao;
    private String numeroSerieECF;
    private Integer numeroEquipamento;
    private String modeloDocumentoFiscal;
    private Integer COOInicial;
    private Integer COOFinal;
    private Integer CRZ;
    private Integer CRO;
    private Double valorVendaBruta;
    private Double valorGrandeTotal;

    public Sintegra60MVO() {
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return the numeroSerieECF
     */
    public String getNumeroSerieECF() {
        return numeroSerieECF;
    }

    /**
     * @param numeroSerieECF the numeroSerieECF to set
     */
    public void setNumeroSerieECF(String numeroSerieECF) {
        this.numeroSerieECF = numeroSerieECF;
    }

    /**
     * @return the numeroEquipamento
     */
    public Integer getNumeroEquipamento() {
        return numeroEquipamento;
    }

    /**
     * @param numeroEquipamento the numeroEquipamento to set
     */
    public void setNumeroEquipamento(Integer numeroEquipamento) {
        this.numeroEquipamento = numeroEquipamento;
    }

    /**
     * @return the modeloDocumentoFiscal
     */
    public String getModeloDocumentoFiscal() {
        return modeloDocumentoFiscal;
    }

    /**
     * @param modeloDocumentoFiscal the modeloDocumentoFiscal to set
     */
    public void setModeloDocumentoFiscal(String modeloDocumentoFiscal) {
        this.modeloDocumentoFiscal = modeloDocumentoFiscal;
    }

    /**
     * @return the COOInicial
     */
    public Integer getCOOInicial() {
        return COOInicial;
    }

    /**
     * @param COOInicial the COOInicial to set
     */
    public void setCOOInicial(Integer COOInicial) {
        this.COOInicial = COOInicial;
    }

    /**
     * @return the COOFinal
     */
    public Integer getCOOFinal() {
        return COOFinal;
    }

    /**
     * @param COOFinal the COOFinal to set
     */
    public void setCOOFinal(Integer COOFinal) {
        this.COOFinal = COOFinal;
    }

    /**
     * @return the CRZ
     */
    public Integer getCRZ() {
        return CRZ;
    }

    /**
     * @param CRZ the CRZ to set
     */
    public void setCRZ(Integer CRZ) {
        this.CRZ = CRZ;
    }

    /**
     * @return the CRO
     */
    public Integer getCRO() {
        return CRO;
    }

    /**
     * @param CRO the CRO to set
     */
    public void setCRO(Integer CRO) {
        this.CRO = CRO;
    }

    /**
     * @return the valorVendaBruta
     */
    public Double getValorVendaBruta() {
        return valorVendaBruta;
    }

    /**
     * @param valorVendaBruta the valorVendaBruta to set
     */
    public void setValorVendaBruta(Double valorVendaBruta) {
        this.valorVendaBruta = valorVendaBruta;
    }

    /**
     * @return the valorGrandeTotal
     */
    public Double getValorGrandeTotal() {
        return valorGrandeTotal;
    }

    /**
     * @param valorGrandeTotal the valorGrandeTotal to set
     */
    public void setValorGrandeTotal(Double valorGrandeTotal) {
        this.valorGrandeTotal = valorGrandeTotal;
    }


}