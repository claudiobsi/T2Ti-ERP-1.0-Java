package com.t2tierp.ponto.afdt;

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

    public Long getNumFabricacaoREP() {
        return record.getValue("NumFabricacaoREP");
    }

    public void setNumFabricacaoREP(Long numFabricacaoREP) {
        record.setValue("NumFabricacaoREP", numFabricacaoREP);
    }

    public String getTipoMarcacao() {
        return record.getValue("TipoMarcacao");
    }

    public void setTipoMarcacao(String tipoMarcacao) {
        record.setValue("TipoMarcacao", tipoMarcacao);
    }

    public Integer getNumeroSequencialEmpregado() {
        return record.getValue("NumeroSequencialEmpregado");
    }

    public void setNumeroSequencialEmpregado(Integer numeroSequencialEmpregado) {
        record.setValue("NumeroSequencialEmpregado", numeroSequencialEmpregado);
    }

    public String getTipoRegistroMarcado() {
        return record.getValue("TipoRegistroMarcado");
    }

    public void setTipoRegistroMarcado(String tipoRegistro) {
        record.setValue("TipoRegistroMarcado", tipoRegistro);
    }

    public String getMotivo() {
        return record.getValue("Motivo");
    }

    public void setMotivo(String motivo) {
        record.setValue("Motivo", motivo);
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
