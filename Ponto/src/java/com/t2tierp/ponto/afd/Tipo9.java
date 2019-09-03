package com.t2tierp.ponto.afd;

import org.jrimum.texgit.Record;

public class Tipo9 {

    private Record record;

    public Tipo9() {
    }

    public Tipo9(Record record) {
        this.record = record;
    }

    public Long getNumeroSequencialRegistro() {
        return record.getValue("NumeroSequencialRegistro");
    }

    public void setNumeroSequencialRegistro(Long numeroSequencialRegistro) {
        record.setValue("NumeroSequencialRegistro", numeroSequencialRegistro);
    }

    public Long getQuantidadeTipo2() {
        return record.getValue("QuantidadeTipo2");
    }

    public void setQuantidadeTipo2(Long quantidadeTipo2) {
        record.setValue("QuantidadeTipo2", quantidadeTipo2);
    }

    public Long getQuantidadeTipo3() {
        return record.getValue("QuantidadeTipo3");
    }

    public void setQuantidadeTipo3(Long quantidadeTipo3) {
        record.setValue("QuantidadeTipo3", quantidadeTipo3);
    }

    public Long getQuantidadeTipo4() {
        return record.getValue("QuantidadeTipo4");
    }

    public void setQuantidadeTipo4(Long quantidadeTipo4) {
        record.setValue("QuantidadeTipo4", quantidadeTipo4);
    }

    public Long getQuantidadeTipo5() {
        return record.getValue("QuantidadeTipo5");
    }

    public void setQuantidadeTipo5(Long quantidadeTipo5) {
        record.setValue("QuantidadeTipo5", quantidadeTipo5);
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
