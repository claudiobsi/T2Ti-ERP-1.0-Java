package com.t2tierp.edi.cnab240.bb;

import org.jrimum.texgit.Record;

public class TrailerLote {
private Record record;
public TrailerLote(){}
public TrailerLote(Record record){this.record = record;}
public Integer getCodigoBanco() { return record.getValue("CodigoBanco");}
public void  setCodigoBanco(Integer codigoBanco){ record.setValue("CodigoBanco", codigoBanco);}
public Integer getLoteServico() { return record.getValue("LoteServico");}
public void  setLoteServico(Integer loteServico){ record.setValue("LoteServico", loteServico);}
public String getCNAB1() { return record.getValue("CNAB1");}
public void  setCNAB1(String cNAB1){ record.setValue("CNAB1", cNAB1);}
public Integer getQuantidadeRegistros() { return record.getValue("QuantidadeRegistros");}
public void  setQuantidadeRegistros(Integer quantidadeRegistros){ record.setValue("QuantidadeRegistros", quantidadeRegistros);}
public String getCNAB2() { return record.getValue("CNAB2");}
public void  setCNAB2(String cNAB2){ record.setValue("CNAB2", cNAB2);}
public Record getRecord(){ return record; }
public void setRecord(Record record){ this.record = record; }
}
