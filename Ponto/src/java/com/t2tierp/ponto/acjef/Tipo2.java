package com.t2tierp.ponto.acjef;

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

    public Integer getCodigoHorario() {
        return record.getValue("CodigoHorario");
    }

    public void setCodigoHorario(Integer codigoHorario) {
        record.setValue("CodigoHorario", codigoHorario);
    }

    public String getHoraEntrada() {
        return record.getValue("HoraEntrada");
    }

    public void setHoraEntrada(String horaEntrada) {
        record.setValue("HoraEntrada", horaEntrada);
    }

    public String getHoraSaida() {
        return record.getValue("HoraSaida");
    }

    public void setHoraSaida(String horaSaida) {
        record.setValue("HoraSaida", horaSaida);
    }

    public String getInicioIntervalo() {
        return record.getValue("InicioIntervalo");
    }

    public void setInicioIntervalo(String inicioIntervalo) {
        record.setValue("InicioIntervalo", inicioIntervalo);
    }

    public String getFimIntervalo() {
        return record.getValue("FimIntervalo");
    }

    public void setFimIntervalo(String fimIntervalo) {
        record.setValue("FimIntervalo", fimIntervalo);
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
