{*******************************************************************************
Title: T2Ti ERP
Description: VO dos detalhes da NF2.

The MIT License

Copyright: Copyright (C) 2010 T2Ti.COM

Permission is hereby granted, free of charge, to any person
obtaining a copy of this software and associated documentation
files (the "Software"), to deal in the Software without
restriction, including without limitation the rights to use,
copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the
Software is furnished to do so, subject to the following
conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.

       The author may be contacted at:
           t2ti.com@gmail.com</p>

@author Albert Eije (T2Ti.COM)
@version 1.0
*******************************************************************************}
unit NF2DetalheVO;

interface

type
  TNF2DetalheVO = class
  private
    FID: Integer;
    FID_CFOP: Integer;
    FID_ECF_TRIBUTO_PRODUTO: Integer;
    FID_PRODUTO: Integer;
    FID_NF2_CABECALHO: Integer;
    FITEM: Integer;
    FQUANTIDADE: Double;
    FVALOR_UNITARIO: Double;
    FVALOR_TOTAL: Double;
    FBASE_ICMS: Double;
    FTAXA_ICMS: Double;
    FICMS: Double;
    FICMS_OUTRAS: Double;
    FICMS_ISENTO: Double;
    FTAXA_DESCONTO: Double;
    FDESCONTO: Double;
    FTAXA_ISSQN: Double;
    FISSQN: Double;
    FTAXA_PIS: Double;
    FPIS: Double;
    FTAXA_COFINS: Double;
    FCOFINS: Double;
    FTAXA_ACRESCIMO: Double;
    FACRESCIMO: Double;
    FTAXA_IPI: Double;
    FIPI: Double;
    FCANCELADO: String;
	  FMOVIMENTA_ESTOQUE: String;

  published

    property Id: Integer read FID write FID;
    property IdCFOP: Integer read FID_CFOP write FID_CFOP;
    property IdTributo: Integer read FID_ECF_TRIBUTO_PRODUTO write FID_ECF_TRIBUTO_PRODUTO;
    property IdProduto: Integer read FID_PRODUTO write FID_PRODUTO;
    property IdNF2Cabecalho: Integer read FID_NF2_CABECALHO write FID_NF2_CABECALHO;
    property Item: Integer read FITEM write FITEM;
    property Quantidade: Double read FQUANTIDADE write FQUANTIDADE;
    property ValorUnitario: Double read FVALOR_UNITARIO write FVALOR_UNITARIO;
    property ValorTotal: Double read FVALOR_TOTAL write FVALOR_TOTAL;
    property BaseICMS: Double read FBASE_ICMS write FBASE_ICMS;
    property TaxaICMS: Double read FTAXA_ICMS write FTAXA_ICMS;
    property ICMS: Double read FICMS write FICMS;
    property ICMSOutras: Double read FICMS_OUTRAS write FICMS_OUTRAS;
    property ICMSIsento: Double read FICMS_ISENTO write FICMS_ISENTO;
    property TaxaDesconto: Double read FTAXA_DESCONTO write FTAXA_DESCONTO;
    property Desconto: Double read FDESCONTO write FDESCONTO;
    property TaxaISSQN: Double read FTAXA_ISSQN write FTAXA_ISSQN;
    property ISSQN: Double read FISSQN write FISSQN;
    property TaxaPIS: Double read FTAXA_PIS write FTAXA_PIS;
    property PIS: Double read FPIS write FPIS;
    property TaxaCOFINS: Double read FTAXA_COFINS write FTAXA_COFINS;
    property COFINS: Double read FCOFINS write FCOFINS;
    property TaxaAcrescimo: Double read FTAXA_ACRESCIMO write FTAXA_ACRESCIMO;
    property Acrescimo: Double read FACRESCIMO write FACRESCIMO;
    property TaxaIPI: Double read FTAXA_IPI write FTAXA_IPI;
    property IPI: Double read FIPI write FIPI;
    property Cancelado: String read FCANCELADO write FCANCELADO;
    property MovimentaEstoque: String read FMOVIMENTA_ESTOQUE write FMOVIMENTA_ESTOQUE;	

end;

implementation

end.