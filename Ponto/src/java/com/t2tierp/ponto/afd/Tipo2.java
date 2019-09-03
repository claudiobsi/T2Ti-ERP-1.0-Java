package com.t2tierp.ponto.afd;

import java.util.Date;
import org.jrimum.texgit.Record;

public class Tipo2 {

    private Record record;

    public Tipo2() {
    }

    public Tipo2(Record record) {
        this.record = record;
    }

    public Long getNumeroSequencialRegistro() {
        return record.getValue("NumeroSequencialRegistro");
    }

    public void setNumeroSequencialRegistro(Long numeroSequencialRegistro) {
        record.setValue("NumeroSequencialRegistro", numeroSequencialRegistro);
    }

    public Date getDataGravacao() {
        return record.getValue("DataGravacao");
    }

    public void setDataGravacao(Date dataGravacao) {
        record.setValue("DataGravacao", dataGravacao);
    }

    public String getHoraGravacao() {
        return record.getValue("HoraGravacao");
    }

    public void setHoraGravacao(String horaGravacao) {
        record.setValue("HoraGravacao", horaGravacao);
    }

    public Integer getTipoIdentificadorEmpregador() {
        return record.getValue("TipoIdentificadorEmpregador");
    }

    public void setTipoIdentificadorEmpregador(Integer tipoIdentificadorEmpregador) {
        record.setValue("TipoIdentificadorEmpregador", tipoIdentificadorEmpregador);
    }

    public Long getCnpjCpfEmpregador() {
        return record.getValue("CnpjCpfEmpregador");
    }

    public void setCnpjCpfEmpregador(Long cnpjCpfEmpregador) {
        record.setValue("CnpjCpfEmpregador", cnpjCpfEmpregador);
    }

    public Long getCeiEmpregador() {
        return record.getValue("CeiEmpregador");
    }

    public void setCeiEmpregador(Long ceiEmpregador) {
        record.setValue("CeiEmpregador", ceiEmpregador);
    }

    public String getRazaoSocialEmpregador() {
        return record.getValue("RazaoSocialEmpregador");
    }

    public void setRazaoSocialEmpregador(String razaoSocialEmpregador) {
        record.setValue("RazaoSocialEmpregador", razaoSocialEmpregador);
    }

    public String getLocalPrestacaoServico() {
        return record.getValue("LocalPrestacaoServico");
    }

    public void setLocalPrestacaoServico(String localPrestacaoServico) {
        record.setValue("LocalPrestacaoServico", localPrestacaoServico);
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
