package com.t2tierp.ponto.afd;

import java.util.Date;
import org.jrimum.texgit.Record;

public class Tipo3 {

    private Record record;

    public Tipo3() {
    }

    public Tipo3(Record record) {
        this.record = record;
    }

    public Long getNumeroSequencialRegistro() {
        return record.getValue("NumeroSequencialRegistro");
    }

    public void setNumeroSequencialRegistro(Long numeroSequencialRegistro) {
        record.setValue("NumeroSequencialRegistro", numeroSequencialRegistro);
    }

    public Date getDataMarcacao() {
        return record.getValue("DataMarcacao");
    }

    public void setDataMarcacao(Date dataMarcacao) {
        record.setValue("DataMarcacao", dataMarcacao);
    }

    public String getHoraMarcacao() {
        return record.getValue("HoraMarcacao");
    }

    public void setHoraMarcacao(String horaMarcacao) {
        record.setValue("HoraMarcacao", horaMarcacao);
    }

    public String getPisEmpregado() {
        return record.getValue("PisEmpregado");
    }

    public void setPisEmpregado(String pisEmpregado) {
        record.setValue("PisEmpregado", pisEmpregado);
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
