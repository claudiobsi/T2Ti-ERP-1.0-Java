{*******************************************************************************
Title: T2Ti ERP
Description: VO do cabeçalho da NF2.

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
unit NF2CabecalhoVO;

interface

type
  TNF2CabecalhoVO = class
  private
    FID: Integer;
    FID_CFOP: Integer;
    FID_ECF_FUNCIONARIO: Integer;
    FID_CLIENTE: Integer;
    FNUMERO: String;
    FDATA_HORA_EMISSAO: String;
    FSERIE: String;
    FSUBSERIE: String;
    FTOTAL_PRODUTOS: Double;
    FTOTAL_NF: Double;
    FBASE_ICMS: Double;
    FICMS: Double;
    FICMS_OUTRAS: Double;
    FISSQN: Double;
    FPIS: Double;
    FCOFINS: Double;
    FIPI: Double;
    FTAXA_ACRESCIMO: Double;
    FACRESCIMO: Double;
    FACRESCIMO_ITENS: Double;
    FTAXA_DESCONTO: Double;
    FDESCONTO: Double;
    FDESCONTO_ITENS: Double;
    FCANCELADA: String;
    FSINCRONIZADO: String;

  published

    property Id: Integer read FID write FID;
    property IdCFOP: Integer read FID_CFOP write FID_CFOP;
    property IdVendedor: Integer read FID_ECF_FUNCIONARIO write FID_ECF_FUNCIONARIO;
    property IdCliente: Integer read FID_CLIENTE write FID_CLIENTE;
    property Numero: String read FNUMERO write FNUMERO;
    property DataHoraEmissao: String read FDATA_HORA_EMISSAO write FDATA_HORA_EMISSAO;
    property Serie: String read FSERIE write FSERIE;
    property SubSerie: String read FSUBSERIE write FSUBSERIE;
    property TotalProdutos: Double read FTOTAL_PRODUTOS write FTOTAL_PRODUTOS;
    property TotalNF: Double read FTOTAL_NF write FTOTAL_NF;
    property BaseICMS: Double read FBASE_ICMS write FBASE_ICMS;
    property ICMS: Double read FICMS write FICMS;
    property ICMSOutras: Double read FICMS_OUTRAS write FICMS_OUTRAS;
    property ISSQN: Double read FISSQN write FISSQN;
    property PIS: Double read FPIS write FPIS;
    property COFINS: Double read FCOFINS write FCOFINS;
    property IPI: Double read FIPI write FIPI;
    property TaxaAcrescimo: Double read FTAXA_ACRESCIMO write FTAXA_ACRESCIMO;
    property Acrescimo: Double read FACRESCIMO write FACRESCIMO;
    property AcrescimoItens: Double read FACRESCIMO_ITENS write FACRESCIMO_ITENS;
    property TaxaDesconto: Double read FTAXA_DESCONTO write FTAXA_DESCONTO;
    property Desconto: Double read FDESCONTO write FDESCONTO;
    property DescontoItens: Double read FDESCONTO_ITENS write FDESCONTO_ITENS;
    property Cancelada: String read FCANCELADA write FCANCELADA;
    property Sincronizado: String read FSINCRONIZADO write FSINCRONIZADO;

end;

implementation

end.