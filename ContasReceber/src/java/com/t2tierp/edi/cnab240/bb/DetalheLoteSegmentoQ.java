package com.t2tierp.edi.cnab240.bb;

import org.jrimum.texgit.Record;

public class DetalheLoteSegmentoQ {

    private Record record;

    public DetalheLoteSegmentoQ() {
    }

    public DetalheLoteSegmentoQ(Record record) {
        this.record = record;
    }

    public Integer getCodigoBanco() {
        return record.getValue("CodigoBanco");
    }

    public void setCodigoBanco(Integer codigoBanco) {
        record.setValue("CodigoBanco", codigoBanco);
    }

    public Integer getLoteServico() {
        return record.getValue("LoteServico");
    }

    public void setLoteServico(Integer loteServico) {
        record.setValue("LoteServico", loteServico);
    }

    public Integer getTipoRegistro() {
        return record.getValue("TipoRegistro");
    }

    public void setTipoRegistro(Integer tipoRegistro) {
        record.setValue("TipoRegistro", tipoRegistro);
    }

    public Integer getNumeroSequencialRegistro() {
        return record.getValue("NumeroSequencialRegistro");
    }

    public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
        record.setValue("NumeroSequencialRegistro", numeroSequencialRegistro);
    }

    public String getCNAB1() {
        return record.getValue("CNAB1");
    }

    public void setCNAB1(String cNAB1) {
        record.setValue("CNAB1", cNAB1);
    }

    public Integer getCodigoMovimentoRemessa() {
        return record.getValue("CodigoMovimentoRemessa");
    }

    public void setCodigoMovimentoRemessa(Integer codigoMovimentoRemessa) {
        record.setValue("CodigoMovimentoRemessa", codigoMovimentoRemessa);
    }

    public Integer getTipoInscricaoSacado() {
        return record.getValue("TipoInscricaoSacado");
    }

    public void setTipoInscricaoSacado(Integer tipoInscricaoSacado) {
        record.setValue("TipoInscricaoSacado", tipoInscricaoSacado);
    }

    public Long getNumeroInscricaoSacado() {
        return record.getValue("NumeroInscricaoSacado");
    }

    public void setNumeroInscricaoSacado(Long numeroInscricaoSacado) {
        record.setValue("NumeroInscricaoSacado", numeroInscricaoSacado);
    }

    public String getNome() {
        return record.getValue("Nome");
    }

    public void setNome(String nome) {
        record.setValue("Nome", nome);
    }

    public String getEndereco() {
        return record.getValue("Endereco");
    }

    public void setEndereco(String endereco) {
        record.setValue("Endereco", endereco);
    }

    public String getBairro() {
        return record.getValue("Bairro");
    }

    public void setBairro(String bairro) {
        record.setValue("Bairro", bairro);
    }

    public Integer getCEP() {
        return record.getValue("CEP");
    }

    public void setCEP(Integer cEP) {
        record.setValue("CEP", cEP);
    }

    public Integer getSufixoCEP() {
        return record.getValue("SufixoCEP");
    }

    public void setSufixoCEP(Integer sufixoCEP) {
        record.setValue("SufixoCEP", sufixoCEP);
    }

    public String getCidade() {
        return record.getValue("Cidade");
    }

    public void setCidade(String cidade) {
        record.setValue("Cidade", cidade);
    }

    public String getUF() {
        return record.getValue("UF");
    }

    public void setUF(String uF) {
        record.setValue("UF", uF);
    }

    public Integer getTipoInscricaoSacadoAvalista() {
        return record.getValue("TipoInscricaoSacadoAvalista");
    }

    public void setTipoInscricaoSacadoAvalista(Integer tipoInscricaoSacadoAvalista) {
        record.setValue("TipoInscricaoSacadoAvalista", tipoInscricaoSacadoAvalista);
    }

    public Long getNumeroInscricaoSacadoAvalista() {
        return record.getValue("NumeroInscricaoSacadoAvalista");
    }

    public void setNumeroInscricaoSacadoAvalista(Long numeroInscricaoSacadoAvalista) {
        record.setValue("NumeroInscricaoSacadoAvalista", numeroInscricaoSacadoAvalista);
    }

    public String getNomeSacadorAvalista() {
        return record.getValue("NomeSacadorAvalista");
    }

    public void setNomeSacadorAvalista(String nomeSacadorAvalista) {
        record.setValue("NomeSacadorAvalista", nomeSacadorAvalista);
    }

    public Integer getCodigoBancoCorrespondenteCompe() {
        return record.getValue("CodigoBancoCorrespondenteCompe");
    }

    public void setCodigoBancoCorrespondenteCompe(Integer codigoBancoCorrespondenteCompe) {
        record.setValue("CodigoBancoCorrespondenteCompe", codigoBancoCorrespondenteCompe);
    }

    public String getNossoNumeroBancoCorrespondente() {
        return record.getValue("NossoNumeroBancoCorrespondente");
    }

    public void setNossoNumeroBancoCorrespondente(String nossoNumeroBancoCorrespondente) {
        record.setValue("NossoNumeroBancoCorrespondente", nossoNumeroBancoCorrespondente);
    }

    public String getCNAB2() {
        return record.getValue("CNAB2");
    }

    public void setCNAB2(String cNAB2) {
        record.setValue("CNAB2", cNAB2);
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
