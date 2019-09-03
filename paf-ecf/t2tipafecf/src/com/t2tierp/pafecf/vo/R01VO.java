/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.t2tierp.pafecf.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author T2Ti
 */
public class R01VO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String cnpjSh;
    private String inscricaoEstadualSh;
    private String inscricaoMunicipalSh;
    private String denominacaoSh;
    private String nomePafEcf;
    private String versaoPafEcf;
    private String md5PafEcf;
    private Date dataInicial;
    private Date dataFinal;
    private String versaoEr;
    private String numeroLaudoPaf;
    private String razaoSocialSh;
    private String enderecoSh;
    private String numeroSh;
    private String complementoSh;
    private String bairroSh;
    private String cidadeSh;
    private String cepSh;
    private String ufSh;
    private String telefoneSh;
    private String contatoSh;
    private String principalExecutavel;
    private String serieEcf;
    private String cnpjEmpresa;
    private String hashTripa;
    private Integer hashIncremento;

    public R01VO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpjSh() {
        return cnpjSh;
    }

    public void setCnpjSh(String cnpjSh) {
        this.cnpjSh = cnpjSh;
    }

    public String getInscricaoEstadualSh() {
        return inscricaoEstadualSh;
    }

    public void setInscricaoEstadualSh(String inscricaoEstadualSh) {
        this.inscricaoEstadualSh = inscricaoEstadualSh;
    }

    public String getInscricaoMunicipalSh() {
        return inscricaoMunicipalSh;
    }

    public void setInscricaoMunicipalSh(String inscricaoMunicipalSh) {
        this.inscricaoMunicipalSh = inscricaoMunicipalSh;
    }

    public String getDenominacaoSh() {
        return denominacaoSh;
    }

    public void setDenominacaoSh(String denominacaoSh) {
        this.denominacaoSh = denominacaoSh;
    }

    public String getNomePafEcf() {
        return nomePafEcf;
    }

    public void setNomePafEcf(String nomePafEcf) {
        this.nomePafEcf = nomePafEcf;
    }

    public String getVersaoPafEcf() {
        return versaoPafEcf;
    }

    public void setVersaoPafEcf(String versaoPafEcf) {
        this.versaoPafEcf = versaoPafEcf;
    }

    public String getMd5PafEcf() {
        return md5PafEcf;
    }

    public void setMd5PafEcf(String md5PafEcf) {
        this.md5PafEcf = md5PafEcf;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getVersaoEr() {
        return versaoEr;
    }

    public void setVersaoEr(String versaoEr) {
        this.versaoEr = versaoEr;
    }

    public String getNumeroLaudoPaf() {
        return numeroLaudoPaf;
    }

    public void setNumeroLaudoPaf(String numeroLaudoPaf) {
        this.numeroLaudoPaf = numeroLaudoPaf;
    }

    public String getRazaoSocialSh() {
        return razaoSocialSh;
    }

    public void setRazaoSocialSh(String razaoSocialSh) {
        this.razaoSocialSh = razaoSocialSh;
    }

    public String getEnderecoSh() {
        return enderecoSh;
    }

    public void setEnderecoSh(String enderecoSh) {
        this.enderecoSh = enderecoSh;
    }

    public String getNumeroSh() {
        return numeroSh;
    }

    public void setNumeroSh(String numeroSh) {
        this.numeroSh = numeroSh;
    }

    public String getComplementoSh() {
        return complementoSh;
    }

    public void setComplementoSh(String complementoSh) {
        this.complementoSh = complementoSh;
    }

    public String getBairroSh() {
        return bairroSh;
    }

    public void setBairroSh(String bairroSh) {
        this.bairroSh = bairroSh;
    }

    public String getCidadeSh() {
        return cidadeSh;
    }

    public void setCidadeSh(String cidadeSh) {
        this.cidadeSh = cidadeSh;
    }

    public String getCepSh() {
        return cepSh;
    }

    public void setCepSh(String cepSh) {
        this.cepSh = cepSh;
    }

    public String getUfSh() {
        return ufSh;
    }

    public void setUfSh(String ufSh) {
        this.ufSh = ufSh;
    }

    public String getTelefoneSh() {
        return telefoneSh;
    }

    public void setTelefoneSh(String telefoneSh) {
        this.telefoneSh = telefoneSh;
    }

    public String getContatoSh() {
        return contatoSh;
    }

    public void setContatoSh(String contatoSh) {
        this.contatoSh = contatoSh;
    }

    public String getPrincipalExecutavel() {
        return principalExecutavel;
    }

    public void setPrincipalExecutavel(String principalExecutavel) {
        this.principalExecutavel = principalExecutavel;
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
     * @return the cnpjEmpresa
     */
    public String getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    /**
     * @param cnpjEmpresa the cnpjEmpresa to set
     */
    public void setCnpjEmpresa(String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
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
