package com.t2tierp.edi.cnab240.bb;

import java.util.Date;
import org.jrimum.texgit.Record;

public class HeaderArquivo {

    private Record record;

    public HeaderArquivo() {
    }

    public HeaderArquivo(Record record) {
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

    public String getCNAB1() {
        return record.getValue("CNAB1");
    }

    public void setCNAB1(String cNAB1) {
        record.setValue("CNAB1", cNAB1);
    }

    public Integer getTipoInscricao() {
        return record.getValue("TipoInscricao");
    }

    public void setTipoInscricao(Integer tipoInscricao) {
        record.setValue("TipoInscricao", tipoInscricao);
    }

    public Long getNumeroInscricao() {
        return record.getValue("NumeroInscricao");
    }

    public void setNumeroInscricao(Long numeroInscricao) {
        record.setValue("NumeroInscricao", numeroInscricao);
    }

    public String getCodigoConvenio() {
        return record.getValue("CodigoConvenio");
    }

    public void setCodigoConvenio(String codigoConvenio) {
        record.setValue("CodigoConvenio", codigoConvenio);
    }

    public Integer getAgenciaMantenedora() {
        return record.getValue("AgenciaMantenedora");
    }

    public void setAgenciaMantenedora(Integer agenciaMantenedora) {
        record.setValue("AgenciaMantenedora", agenciaMantenedora);
    }

    public String getDigitoVerificadorAgencia() {
        return record.getValue("DigitoVerificadorAgencia");
    }

    public void setDigitoVerificadorAgencia(String digitoVerificadorAgencia) {
        record.setValue("DigitoVerificadorAgencia", digitoVerificadorAgencia);
    }

    public Integer getNumeroContaCorrente() {
        return record.getValue("NumeroContaCorrente");
    }

    public void setNumeroContaCorrente(Integer numeroContaCorrente) {
        record.setValue("NumeroContaCorrente", numeroContaCorrente);
    }

    public String getDigitoVerificadorContaCorrente() {
        return record.getValue("DigitoVerificadorContaCorrente");
    }

    public void setDigitoVerificadorContaCorrente(String digitoVerificadorContaCorrente) {
        record.setValue("DigitoVerificadorContaCorrente", digitoVerificadorContaCorrente);
    }

    public String getDigitoVerificadorAgenciaConta() {
        return record.getValue("DigitoVerificadorAgenciaConta");
    }

    public void setDigitoVerificadorAgenciaConta(String digitoVerificadorAgenciaConta) {
        record.setValue("DigitoVerificadorAgenciaConta", digitoVerificadorAgenciaConta);
    }

    public String getNomeEmpresa() {
        return record.getValue("NomeEmpresa");
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        record.setValue("NomeEmpresa", nomeEmpresa);
    }

    public String getNomeBanco() {
        return record.getValue("NomeBanco");
    }

    public void setNomeBanco(String nomeBanco) {
        record.setValue("NomeBanco", nomeBanco);
    }

    public String getCNAB2() {
        return record.getValue("CNAB2");
    }

    public void setCNAB2(String cNAB2) {
        record.setValue("CNAB2", cNAB2);
    }

    public Integer getCodigoRemessaRetorno() {
        return record.getValue("CodigoRemessaRetorno");
    }

    public void setCodigoRemessaRetorno(Integer codigoRemessaRetorno) {
        record.setValue("CodigoRemessaRetorno", codigoRemessaRetorno);
    }

    public Date getDataGeracaoArquivo() {
        return record.getValue("DataGeracaoArquivo");
    }

    public void setDataGeracaoArquivo(Date dataGeracaoArquivo) {
        record.setValue("DataGeracaoArquivo", dataGeracaoArquivo);
    }

    public Integer getHoraGeracaoArquivo() {
        return record.getValue("HoraGeracaoArquivo");
    }

    public void setHoraGeracaoArquivo(Integer horaGeracaoArquivo) {
        record.setValue("HoraGeracaoArquivo", horaGeracaoArquivo);
    }

    public Integer getNumeroSequencialArquivo() {
        return record.getValue("NumeroSequencialArquivo");
    }

    public void setNumeroSequencialArquivo(Integer numeroSequencialArquivo) {
        record.setValue("NumeroSequencialArquivo", numeroSequencialArquivo);
    }

    public Integer getNumeroVersaoArquivo() {
        return record.getValue("NumeroVersaoArquivo");
    }

    public void setNumeroVersaoArquivo(Integer numeroVersaoArquivo) {
        record.setValue("NumeroVersaoArquivo", numeroVersaoArquivo);
    }

    public Integer getDensidadeGravacaoArquivo() {
        return record.getValue("DensidadeGravacaoArquivo");
    }

    public void setDensidadeGravacaoArquivo(Integer densidadeGravacaoArquivo) {
        record.setValue("DensidadeGravacaoArquivo", densidadeGravacaoArquivo);
    }

    public String getUsoReservadoBanco() {
        return record.getValue("UsoReservadoBanco");
    }

    public void setUsoReservadoBanco(String usoReservadoBanco) {
        record.setValue("UsoReservadoBanco", usoReservadoBanco);
    }

    public String getUsoReservadoEmpresa() {
        return record.getValue("UsoReservadoEmpresa");
    }

    public void setUsoReservadoEmpresa(String usoReservadoEmpresa) {
        record.setValue("UsoReservadoEmpresa", usoReservadoEmpresa);
    }

    public String getCNAB3() {
        return record.getValue("CNAB3");
    }

    public void setCNAB3(String cNAB3) {
        record.setValue("CNAB3", cNAB3);
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
