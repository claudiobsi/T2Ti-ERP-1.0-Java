package com.t2tierp.ponto.afd;

import java.util.Date;
import org.jrimum.texgit.Record;

public class Tipo4 {

    private Record record;

    public Tipo4() {
    }

    public Tipo4(Record record) {
        this.record = record;
    }

    public Long getNumeroSequencialRegistro() {
        return record.getValue("NumeroSequencialRegistro");
    }

    public void setNumeroSequencialRegistro(Long numeroSequencialRegistro) {
        record.setValue("NumeroSequencialRegistro", numeroSequencialRegistro);
    }

    public Date getDataAntesAjuste() {
        return record.getValue("DataAntesAjuste");
    }

    public void setDataAntesAjuste(Date dataAntesAjuste) {
        record.setValue("DataAntesAjuste", dataAntesAjuste);
    }

    public String getHoraAntesAjuste() {
        return record.getValue("HoraAntesAjuste");
    }

    public void setHoraAntesAjuste(String horaAntesAjuste) {
        record.setValue("HoraAntesAjuste", horaAntesAjuste);
    }

    public Date getDataAjustada() {
        return record.getValue("DataAjustada");
    }

    public void setDataAjustada(Date dataAjustada) {
        record.setValue("DataAjustada", dataAjustada);
    }

    public String getHoraAjustada() {
        return record.getValue("HoraAjustada");
    }

    public void setHoraAjustada(String horaAjustada) {
        record.setValue("HoraAjustada", horaAjustada);
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
