package com.t2tierp.ponto.afd;

import java.util.Date;
import org.jrimum.texgit.Record;

public class Tipo1 {

    private Record record;

    public Tipo1() {
    }

    public Tipo1(Record record) {
        this.record = record;
    }

    public Long getNumeroSequencialRegistro() {
        return record.getValue("NumeroSequencialRegistro");
    }

    public void setNumeroSequencialRegistro(Long numeroSequencialRegistro) {
        record.setValue("NumeroSequencialRegistro", numeroSequencialRegistro);
    }

    public Integer getTipoIdentificadorEmpregador() {
        return record.getValue("TipoIdentificadorEmpregador");
    }

    public void setTipoIdentificadorEmpregador(Integer tipoIdentificadorEmpregador) {
        record.setValue("TipoIdentificadorEmpregador", tipoIdentificadorEmpregador);
    }

    public Long getCnpjCpfEmpreador() {
        return record.getValue("CnpjCpfEmpreador");
    }

    public void setCnpjCpfEmpreador(Long cnpjCpfEmpreador) {
        record.setValue("CnpjCpfEmpreador", cnpjCpfEmpreador);
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

    public Long getNumeroFabricacaoRep() {
        return record.getValue("NumeroFabricacaoRep");
    }

    public void setNumeroFabricacaoRep(Long numeroFabricacaoRep) {
        record.setValue("NumeroFabricacaoRep", numeroFabricacaoRep);
    }

    public Date getDataInicial() {
        return record.getValue("DataInicial");
    }

    public void setDataInicial(Date dataInicial) {
        record.setValue("DataInicial", dataInicial);
    }

    public Date getDataFinal() {
        return record.getValue("DataFinal");
    }

    public void setDataFinal(Date dataFinal) {
        record.setValue("DataFinal", dataFinal);
    }

    public Date getDataGeracaoArquivo() {
        return record.getValue("DataGeracaoArquivo");
    }

    public void setDataGeracaoArquivo(Date dataGeracaoArquivo) {
        record.setValue("DataGeracaoArquivo", dataGeracaoArquivo);
    }

    public String getHoraGeracaoArquivo() {
        return record.getValue("HoraGeracaoArquivo");
    }

    public void setHoraGeracaoArquivo(String horaGeracaoArquivo) {
        record.setValue("HoraGeracaoArquivo", horaGeracaoArquivo);
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
