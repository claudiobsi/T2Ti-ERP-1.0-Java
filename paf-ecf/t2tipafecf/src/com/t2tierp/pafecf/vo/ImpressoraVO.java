package com.t2tierp.pafecf.vo;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Objeto de valor referente a tabela Impressora.</p>
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
public class ImpressoraVO {
    private Integer id;
    private String codigo;
    private String serie;
    private String identificacao;
    private String MC;
    private String MD;
    private String VR;
    private String tipo;
    private String marca;
    private String modelo;
    private String modeloACBr;
    private String versao;
    private String LE;
    private String LEF;
    private String MFD;
    private String lacreNaMfd;
    private String DOCTO;
    private String numeroEcf;

    public ImpressoraVO() {
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
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * @return the identificacao
     */
    public String getIdentificacao() {
        return identificacao;
    }

    /**
     * @param identificacao the identificacao to set
     */
    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    /**
     * @return the MC
     */
    public String getMC() {
        return MC;
    }

    /**
     * @param MC the MC to set
     */
    public void setMC(String MC) {
        this.MC = MC;
    }

    /**
     * @return the MD
     */
    public String getMD() {
        return MD;
    }

    /**
     * @param MD the MD to set
     */
    public void setMD(String MD) {
        this.MD = MD;
    }

    /**
     * @return the VR
     */
    public String getVR() {
        return VR;
    }

    /**
     * @param VR the VR to set
     */
    public void setVR(String VR) {
        this.VR = VR;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the versao
     */
    public String getVersao() {
        return versao;
    }

    /**
     * @param versao the versao to set
     */
    public void setVersao(String versao) {
        this.versao = versao;
    }

    /**
     * @return the LE
     */
    public String getLE() {
        return LE;
    }

    /**
     * @param LE the LE to set
     */
    public void setLE(String LE) {
        this.LE = LE;
    }

    /**
     * @return the LEF
     */
    public String getLEF() {
        return LEF;
    }

    /**
     * @param LEF the LEF to set
     */
    public void setLEF(String LEF) {
        this.LEF = LEF;
    }

    /**
     * @return the MFD
     */
    public String getMFD() {
        return MFD;
    }

    /**
     * @param MFD the MFD to set
     */
    public void setMFD(String MFD) {
        this.MFD = MFD;
    }

    /**
     * @return the DOCTO
     */
    public String getDOCTO() {
        return DOCTO;
    }

    /**
     * @param DOCTO the DOCTO to set
     */
    public void setDOCTO(String DOCTO) {
        this.DOCTO = DOCTO;
    }

    /**
     * @return the modeloACBr
     */
    public String getModeloACBr() {
        return modeloACBr;
    }

    /**
     * @param modeloACBr the modeloACBr to set
     */
    public void setModeloACBr(String modeloACBr) {
        this.modeloACBr = modeloACBr;
    }

    /**
     * @return the lacreNaMfd
     */
    public String getLacreNaMfd() {
        return lacreNaMfd;
    }

    /**
     * @param lacreNaMfd the lacreNaMfd to set
     */
    public void setLacreNaMfd(String lacreNaMfd) {
        this.lacreNaMfd = lacreNaMfd;
    }

    /**
     * @return the numeroEcf
     */
    public String getNumeroEcf() {
        return numeroEcf;
    }

    /**
     * @param numeroEcf the numeroEcf to set
     */
    public void setNumeroEcf(String numeroEcf) {
        this.numeroEcf = numeroEcf;
    }

}
