package com.t2tierp.ponto.afd;

import java.util.Date;
import org.jrimum.texgit.Record;

public class Tipo5 {

    private Record record;

    public Tipo5() {
    }

    public Tipo5(Record record) {
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

    public String getTipoOperacao() {
        return record.getValue("TipoOperacao");
    }

    public void setTipoOperacao(String tipoOperacao) {
        record.setValue("TipoOperacao", tipoOperacao);
    }

    public Long getPisEmpregado() {
        return record.getValue("PisEmpregado");
    }

    public void setPisEmpregado(Long pisEmpregado) {
        record.setValue("PisEmpregado", pisEmpregado);
    }

    public String getNomeEmpregado() {
        return record.getValue("NomeEmpregado");
    }

    public void setNomeEmpregado(String nomeEmpregado) {
        record.setValue("NomeEmpregado", nomeEmpregado);
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
