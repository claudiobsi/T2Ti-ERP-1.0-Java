package com.t2tierp.pafecf.vo;

import java.sql.Date;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Objeto de valor referente a tabela R06.</p>
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
public class R06VO  {
    private Integer id;
    private Integer idCaixa;
    private Integer idOperador;
    private Integer idImpressora;
    private Integer COO;
    private Integer GNF;
    private Integer GRG;
    private Integer CDC;
    private String denominacao;
    private Date dataEmissao;
    private String horaEmissao;
    private String sincronizado;
    private String hashTripa;
    private Integer hashIncremento;
    private String serieEcf;

    public R06VO() {
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
     * @return the idCaixa
     */
    public Integer getIdCaixa() {
        return idCaixa;
    }

    /**
     * @param idCaixa the idCaixa to set
     */
    public void setIdCaixa(Integer idCaixa) {
        this.idCaixa = idCaixa;
    }

    /**
     * @return the idOperador
     */
    public Integer getIdOperador() {
        return idOperador;
    }

    /**
     * @param idOperador the idOperador to set
     */
    public void setIdOperador(Integer idOperador) {
        this.idOperador = idOperador;
    }

    /**
     * @return the idImpressora
     */
    public Integer getIdImpressora() {
        return idImpressora;
    }

    /**
     * @param idImpressora the idImpressora to set
     */
    public void setIdImpressora(Integer idImpressora) {
        this.idImpressora = idImpressora;
    }

    /**
     * @return the COO
     */
    public Integer getCOO() {
        return COO;
    }

    /**
     * @param COO the COO to set
     */
    public void setCOO(Integer COO) {
        this.COO = COO;
    }

    /**
     * @return the GNF
     */
    public Integer getGNF() {
        return GNF;
    }

    /**
     * @param GNF the GNF to set
     */
    public void setGNF(Integer GNF) {
        this.GNF = GNF;
    }

    /**
     * @return the GRG
     */
    public Integer getGRG() {
        return GRG;
    }

    /**
     * @param GRG the GRG to set
     */
    public void setGRG(Integer GRG) {
        this.GRG = GRG;
    }

    /**
     * @return the CDC
     */
    public Integer getCDC() {
        return CDC;
    }

    /**
     * @param CDC the CDC to set
     */
    public void setCDC(Integer CDC) {
        this.CDC = CDC;
    }

    /**
     * @return the denominacao
     */
    public String getDenominacao() {
        return denominacao;
    }

    /**
     * @param denominacao the denominacao to set
     */
    public void setDenominacao(String denominacao) {
        this.denominacao = denominacao;
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
     * @return the horaEmissao
     */
    public String getHoraEmissao() {
        return horaEmissao;
    }

    /**
     * @param horaEmissao the horaEmissao to set
     */
    public void setHoraEmissao(String horaEmissao) {
        this.horaEmissao = horaEmissao;
    }

    /**
     * @return the sincronizado
     */
    public String getSincronizado() {
        return sincronizado;
    }

    /**
     * @param sincronizado the sincronizado to set
     */
    public void setSincronizado(String sincronizado) {
        this.sincronizado = sincronizado;
    }

    /**
     * @return the hashTripa
     */
    public String getHashTripa() {
        return hashTripa;
    }

    /**
     * @param hashTripa the hashTripa to set
     */
    public void setHashTripa(String hashTripa) {
        this.hashTripa = hashTripa;
    }

    /**
     * @return the serieEcf
     */
    public String getSerieEcf() {
        return serieEcf;
    }

    /**
     * @param serieEcf the serieEcf to set
     */
    public void setSerieEcf(String serieEcf) {
        this.serieEcf = serieEcf;
    }

    /**
     * @return the hashIncremento
     */
    public Integer getHashIncremento() {
        return hashIncremento;
    }

    /**
     * @param hashIncremento the hashIncremento to set
     */
    public void setHashIncremento(Integer hashIncremento) {
        this.hashIncremento = hashIncremento;
    }

}