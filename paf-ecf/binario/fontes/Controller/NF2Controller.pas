{*******************************************************************************
Title: T2Ti ERP
Description: Classe de controle da NF2.

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
unit NF2Controller;

interface

uses
  Classes, SQLExpr, SysUtils, NF2CabecalhoVO, NF2DetalheVO, Generics.Collections,
  DB;

type
  TNF2Controller = class
  protected
  public
    function TabelaNF2Cabecalho: TObjectList<TNF2CabecalhoVO>;
    function TabelaNF2Detalhe(Id: Integer): TObjectList<TNF2DetalheVO>;
  end;

implementation

uses UDataModule;

var
  ConsultaSQL: String;
  Query: TSQLQuery;

function TNF2Controller.TabelaNF2Cabecalho: TObjectList<TNF2CabecalhoVO>;
var
  ListaNF2Cabecalho: TObjectList<TNF2CabecalhoVO>;
  NF2Cabecalho: TNF2CabecalhoVO;
begin
  try
    try
      ConsultaSQL := 'select * from NF2_CABECALHO';

      Query := TSQLQuery.Create(nil);
      Query.SQLConnection := FDataModule.Conexao;
      Query.sql.Text := ConsultaSQL;
      Query.Open;

      ListaNF2Cabecalho := TObjectList<TNF2CabecalhoVO>.Create;

      Query.First;
      while not Query.Eof do
      begin
        NF2Cabecalho := TNF2CabecalhoVO.Create;
        NF2Cabecalho.Id := Query.FieldByName('ID').AsInteger;
        NF2Cabecalho.IdCFOP := Query.FieldByName('ID_CFOP').AsInteger;
        NF2Cabecalho.IdVendedor := Query.FieldByName('ID_ECF_FUNCIONARIO').AsInteger;
        NF2Cabecalho.IdCliente := Query.FieldByName('ID_CLIENTE').AsInteger;
        NF2Cabecalho.Numero := Query.FieldByName('NUMERO').AsString;
        NF2Cabecalho.DataHoraEmissao := Query.FieldByName('DATA_HORA_EMISSAO').AsString;
        NF2Cabecalho.Serie := Query.FieldByName('SERIE').AsString;
        NF2Cabecalho.SubSerie := Query.FieldByName('SUBSERIE').AsString;
        NF2Cabecalho.TotalProdutos := Query.FieldByName('TOTAL_PRODUTOS').AsFloat;
        NF2Cabecalho.TotalNF := Query.FieldByName('TOTAL_NF').AsFloat;
        NF2Cabecalho.BaseICMS := Query.FieldByName('BASE_ICMS').AsFloat;
        NF2Cabecalho.ICMS := Query.FieldByName('ICMS').AsFloat;
        NF2Cabecalho.ICMSOutras := Query.FieldByName('ICMS_OUTRAS').AsFloat;
        NF2Cabecalho.ISSQN := Query.FieldByName('ISSQN').AsFloat;
        NF2Cabecalho.PIS := Query.FieldByName('PIS').AsFloat;
        NF2Cabecalho.COFINS := Query.FieldByName('COFINS').AsFloat;
        NF2Cabecalho.IPI := Query.FieldByName('IPI').AsFloat;
        NF2Cabecalho.TaxaAcrescimo := Query.FieldByName('TAXA_ACRESCIMO').AsFloat;
        NF2Cabecalho.Acrescimo := Query.FieldByName('ACRESCIMO').AsFloat;
        NF2Cabecalho.AcrescimoItens := Query.FieldByName('ACRESCIMO_ITENS').AsFloat;
        NF2Cabecalho.TaxaDesconto := Query.FieldByName('TAXA_DESCONTO').AsFloat;
        NF2Cabecalho.Desconto := Query.FieldByName('DESCONTO').AsFloat;
        NF2Cabecalho.DescontoItens := Query.FieldByName('DESCONTO_ITENS').AsFloat;
        NF2Cabecalho.Cancelada := Query.FieldByName('CANCELADA').AsString;
        ListaNF2Cabecalho.Add(NF2Cabecalho);
        Query.next;
      end;
      result := ListaNF2Cabecalho;
    except
      result := nil;
    end;
  finally
    Query.Free;
  end;
end;

function TNF2Controller.TabelaNF2Detalhe(Id: Integer): TObjectList<TNF2DetalheVO>;
var
  ListaNF2Detalhe: TObjectList<TNF2DetalheVO>;
  NF2Detalhe: TNF2DetalheVO;
  TotalRegistros: Integer;
begin
  ConsultaSQL := 'select count(*) AS TOTAL from NF2_DETALHE where ID_NF2_CABECALHO='+IntToStr(Id);
  try
    try
      Query := TSQLQuery.Create(nil);
      Query.SQLConnection := FDataModule.Conexao;
      Query.sql.Text := ConsultaSQL;
      Query.Open;
      TotalRegistros := Query.FieldByName('TOTAL').AsInteger;

      if TotalRegistros > 0 then
      begin
        ListaNF2Detalhe := TObjectList<TNF2DetalheVO>.Create;

        ConsultaSQL := 'select * from NF2_DETALHE where ID_NF2_CABECALHO='+IntToStr(Id);
        Query.sql.Text := ConsultaSQL;
        Query.Open;
        Query.First;
        while not Query.Eof do
        begin
          NF2Detalhe := TNF2DetalheVO.Create;
          NF2Detalhe.Id := Query.FieldByName('ID').AsInteger;
          NF2Detalhe.IdCFOP := Query.FieldByName('ID_CFOP').AsInteger;
          NF2Detalhe.IdTributo := Query.FieldByName('ID_ECF_TRIBUTO_PRODUTO').AsInteger;
          NF2Detalhe.IdProduto := Query.FieldByName('ID_PRODUTO').AsInteger;
          NF2Detalhe.IdNF2Cabecalho := Query.FieldByName('ID_NF2_CABECALHO').AsInteger;
          NF2Detalhe.Item := Query.FieldByName('ITEM').AsInteger;
          NF2Detalhe.Quantidade := Query.FieldByName('QUANTIDADE').AsFloat;
          NF2Detalhe.ValorUnitario := Query.FieldByName('VALOR_UNITARIO').AsFloat;
          NF2Detalhe.ValorTotal := Query.FieldByName('VALOR_TOTAL').AsFloat;
          NF2Detalhe.BaseICMS := Query.FieldByName('BASE_ICMS').AsFloat;
          NF2Detalhe.TaxaICMS := Query.FieldByName('TAXA_ICMS').AsFloat;
          NF2Detalhe.ICMS := Query.FieldByName('ICMS').AsFloat;
          NF2Detalhe.ICMSOutras := Query.FieldByName('ICMS_OUTRAS').AsFloat;
          NF2Detalhe.ICMSIsento := Query.FieldByName('ICMS_ISENTO').AsFloat;
          NF2Detalhe.TaxaDesconto := Query.FieldByName('TAXA_DESCONTO').AsFloat;
          NF2Detalhe.Desconto := Query.FieldByName('DESCONTO').AsFloat;
          NF2Detalhe.TaxaISSQN := Query.FieldByName('TAXA_ISSQN').AsFloat;
          NF2Detalhe.ISSQN := Query.FieldByName('ISSQN').AsFloat;
          NF2Detalhe.TaxaPIS := Query.FieldByName('TAXA_PIS').AsFloat;
          NF2Detalhe.PIS := Query.FieldByName('PIS').AsFloat;
          NF2Detalhe.TaxaCOFINS := Query.FieldByName('TAXA_COFINS').AsFloat;
          NF2Detalhe.COFINS := Query.FieldByName('COFINS').AsFloat;
          NF2Detalhe.TaxaAcrescimo := Query.FieldByName('TAXA_ACRESCIMO').AsFloat;
          NF2Detalhe.Acrescimo := Query.FieldByName('ACRESCIMO').AsFloat;
          NF2Detalhe.TaxaIPI := Query.FieldByName('TAXA_IPI').AsFloat;
          NF2Detalhe.IPI := Query.FieldByName('IPI').AsFloat;
          NF2Detalhe.Cancelado := Query.FieldByName('CANCELADO').AsString;
          NF2Detalhe.MovimentaEstoque := Query.FieldByName('MOVIMENTA_ESTOQUE').AsString;
          ListaNF2Detalhe.Add(NF2Detalhe);
          Query.next;
        end;
        result := ListaNF2Detalhe;
      end
      // caso não exista a relacao, retorna um ponteiro nulo
      else
        result := nil;
    except
      result := nil;
    end;
  finally
    Query.Free;
  end;
end;

end.
