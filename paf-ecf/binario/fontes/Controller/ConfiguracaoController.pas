{*******************************************************************************
Title: T2Ti ERP
Description: Classe de controle das configurações.

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
unit ConfiguracaoController;

interface

uses
  Classes, Forms, SQLExpr, SysUtils, Generics.Collections, PosicaoComponentesVO, ConfiguracaoVO, ResolucaoVO;

type
  TConfiguracaoController = class
  protected
  public
    class function VerificaPosicaoTamanho: TObjectList<TPosicaoComponentesVO>;
    class function PegaConfiguracao: TConfiguracaoVO;
    class procedure GravaUltimaExclusao(UltimaExclusao: Integer);
    class procedure GravaDataAtulaizacaoEstoque(DataAtualizacao: String);
    class function ConsultaDataAtualizacaoEstoque: String;
    class function ConsultaIdConfiguracao(Id:Integer):boolean;
  end;

implementation

uses UDataModule, Biblioteca;

var
  ConsultaSQL: String;
  Query: TSQLQuery;

class function TConfiguracaoController.VerificaPosicaoTamanho: TObjectList<TPosicaoComponentesVO>;
var
  PosicaoComponentes: TPosicaoComponentesVO;
  ListaPosicoes : TObjectList<TPosicaoComponentesVO>;
begin
  ConsultaSQL := 'select '+
                 ' P.ID, '+
                 ' P.NOME, '+
                 ' P.ALTURA, '+
                 ' P.LARGURA, '+
                 ' P.TOPO, '+
                 ' P.ESQUERDA, '+
                 ' P.TAMANHO_FONTE, '+
                 ' P.TEXTO, '+
                 ' C.ID_ECF_RESOLUCAO '+
                 ' from '+
                 ' ECF_POSICAO_COMPONENTES P, ECF_CONFIGURACAO C ' +
                 ' where '+
                 ' P.ID_ECF_RESOLUCAO=C.ID_ECF_RESOLUCAO';

  ListaPosicoes := TObjectList<TPosicaoComponentesVO>.Create(True);

  try
    try
      Query := TSQLQuery.Create(nil);
      Query.SQLConnection := FDataModule.Conexao;
      Query.sql.Text := ConsultaSQL;
      Query.Open;
      Query.First;

      while not Query.Eof  do
      begin
        PosicaoComponentes := TPosicaoComponentesVO.Create;
        PosicaoComponentes.Id := Query.FieldByName('ID').AsInteger;
        PosicaoComponentes.NomeComponente := Query.FieldByName('NOME').AsString;
        PosicaoComponentes.Altura := Query.FieldByName('ALTURA').AsInteger;
        PosicaoComponentes.Largura := Query.FieldByName('LARGURA').AsInteger;
        PosicaoComponentes.Topo := Query.FieldByName('TOPO').AsInteger;
        PosicaoComponentes.Esquerda := Query.FieldByName('ESQUERDA').AsInteger;
        PosicaoComponentes.TamanhoFonte := Query.FieldByName('TAMANHO_FONTE').AsInteger;
        PosicaoComponentes.TextoComponente := Query.FieldByName('TEXTO').AsString;
        listaPosicoes.Add(PosicaoComponentes);
        Query.next;
      end;
      result := ListaPosicoes;
    except
      result := nil;
    end;
  finally
    Query.Free;
  end;
end;


class procedure TConfiguracaoController.GravaDataAtulaizacaoEstoque(DataAtualizacao: String);
begin
  ConsultaSQL :=  'update ECF_CONFIGURACAO set DATA_ATUALIZACAO_ESTOQUE = :pData';
  try
    try
      Query := TSQLQuery.Create(nil);
      Query.SQLConnection := FDataModule.Conexao;
      Query.sql.Text := ConsultaSQL;
      Query.ParamByName('pData').AsDate := TextoParaData(DataAtualizacao);
      Query.ExecSQL();
    except
    end;
  finally
    Query.Free;
  end;
end;

class procedure TConfiguracaoController.GravaUltimaExclusao(UltimaExclusao: Integer);
begin
  ConsultaSQL :=  'update ECF_CONFIGURACAO set ULTIMA_EXCLUSAO = :pULTIMA_EXCLUSAO';
  try
    try
      Query := TSQLQuery.Create(nil);
      Query.SQLConnection := FDataModule.Conexao;
      Query.sql.Text := ConsultaSQL;

      Query.ParamByName('pULTIMA_EXCLUSAO').AsInteger := ultimaexclusao;
      Query.ExecSQL();
    except
    end;
  finally
    Query.Free;
  end;
end;

class function TConfiguracaoController.PegaConfiguracao: TConfiguracaoVO;
var
  Configuracao: TConfiguracaoVO;
  Linha: String;
begin

  ConsultaSQL :='select ' +
                ' C.ID_ECF_IMPRESSORA, '+
                ' C.ID_ECF_RESOLUCAO, '+
                ' C.ID_ECF_CAIXA, ' +
                ' C.ID_ECF_EMPRESA, '+
                ' C.MENSAGEM_CUPOM, '+
                ' C.PORTA_ECF, '+
                ' C.IP_SERVIDOR, '+
                ' C.IP_SITEF, '+
                ' C.TIPO_TEF, '+
                ' C.TITULO_TELA_CAIXA, '+
                ' C.CAMINHO_IMAGENS_PRODUTOS, '+
                ' C.CAMINHO_IMAGENS_MARKETING, '+
                ' C.CAMINHO_IMAGENS_LAYOUT, '+
                ' C.COR_JANELAS_INTERNAS, '+
                ' C.MARKETING_ATIVO, '+
                ' C.CFOP_ECF, '+
                ' C.CFOP_NF2, '+
                ' C.TIMEOUT_ECF, '+
                ' C.INTERVALO_ECF, '+
                ' C.DESCRICAO_SUPRIMENTO, '+
                ' C.DESCRICAO_SANGRIA, '+
                ' C.TEF_TIPO_GP, '+
                ' C.TEF_TEMPO_ESPERA, '+
                ' C.TEF_ESPERA_STS, '+
                ' C.TEF_NUMERO_VIAS, '+
                ' C.DECIMAIS_QUANTIDADE, '+
                ' C.DECIMAIS_VALOR, '+
                ' I.MODELO_ACBR, '+
                ' I.SERIE '+
                'from '+
                ' ECF_CONFIGURACAO C, ECF_IMPRESSORA I ' +
                'where '+
                ' C.ID_ECF_IMPRESSORA=I.ID';

  Configuracao := TConfiguracaoVO.Create;
  Configuracao.ResolucaoVO := TResolucaoVO.Create;

  try
    try
      Query := TSQLQuery.Create(nil);
      Query.SQLConnection := FDataModule.Conexao;
      Query.sql.Text := ConsultaSQL;
      Query.Open;

      Configuracao.IdImpressora := Query.FieldByName('ID_ECF_IMPRESSORA').AsInteger;
      Configuracao.IdCaixa := Query.FieldByName('ID_ECF_CAIXA').AsInteger;
      Configuracao.IdEmpresa := FDataModule.EmpresaID; //Query.FieldByName('ID_ECF_EMPRESA').AsInteger;
      Configuracao.MensagemCupom := Query.FieldByName('MENSAGEM_CUPOM').AsString;
      Configuracao.PortaECF := Query.FieldByName('PORTA_ECF').AsString;
      Configuracao.IpServidor := Query.FieldByName('IP_SERVIDOR').AsString;
      Configuracao.IpSitef := Query.FieldByName('IP_SITEF').AsString;
      Configuracao.TipoTEF := Query.FieldByName('TIPO_TEF').AsString;
      Configuracao.TituloTelaCaixa := Query.FieldByName('TITULO_TELA_CAIXA').AsString;
      Configuracao.CaminhoImagensProdutos := Query.FieldByName('CAMINHO_IMAGENS_PRODUTOS').AsString;
      Configuracao.CaminhoImagensMarketing := Query.FieldByName('CAMINHO_IMAGENS_MARKETING').AsString;
      Configuracao.CaminhoImagensLayout := Query.FieldByName('CAMINHO_IMAGENS_LAYOUT').AsString;
      Configuracao.CorJanelasInternas := Query.FieldByName('COR_JANELAS_INTERNAS').AsString;
      Configuracao.MarketingAtivo := Query.FieldByName('MARKETING_ATIVO').AsString;
      Configuracao.CFOPECF := Query.FieldByName('CFOP_ECF').AsInteger;
      Configuracao.CFOPNF2 := Query.FieldByName('CFOP_NF2').AsInteger;
      Configuracao.TimeOutECF := Query.FieldByName('TIMEOUT_ECF').AsInteger;
      Configuracao.IntervaloECF := Query.FieldByName('INTERVALO_ECF').AsInteger;
      Configuracao.DescricaoSuprimento := Query.FieldByName('DESCRICAO_SUPRIMENTO').AsString;
      Configuracao.DescricaoSangria := Query.FieldByName('DESCRICAO_SANGRIA').AsString;
      Configuracao.TEFTipoGP := Query.FieldByName('TEF_TIPO_GP').AsInteger;
      Configuracao.TEFTempoEspera := Query.FieldByName('TEF_TEMPO_ESPERA').AsInteger;
      Configuracao.TEFEsperaSTS := Query.FieldByName('TEF_ESPERA_STS').AsInteger;
      Configuracao.TEFNumeroVias := Query.FieldByName('TEF_NUMERO_VIAS').AsInteger;
      Configuracao.DecimaisQuantidade := Query.FieldByName('DECIMAIS_QUANTIDADE').AsInteger;
      Configuracao.DecimaisValor := Query.FieldByName('DECIMAIS_VALOR').AsInteger;
      //Configuracao.BitsPorSegundo := Query.FieldByName('BITS_POR_SEGUNDO').AsInteger;
      //Configuracao.QuantidadeMaximaCartoes := Query.FieldByName('QTDE_MAXIMA_CARTOES').AsInteger;
      //Configuracao.PesquisaParte := Query.FieldByName('PESQUISA_PARTE').AsString;
      //Configuracao.ConfiguracaoBalanca := trim(Query.FieldByName('CONFIGURACAO_BALANCA').AsString);
      //Configuracao.ParametrosDiversos := trim(Query.FieldByName('PARAMETROS_DIVERSOS').AsString);
      //Configuracao.UltimaExclusao := Query.FieldByName('ULTIMA_EXCLUSAO').AsInteger;
      //Configuracao.Laudo  := Query.FieldByName('LAUDO').AsString;
      //Configuracao.IndiceGerencial := trim(Query.FieldByName('INDICE_GERENCIAL').AsString);
      //Configuracao.DataAtualizacaoEstoque := trim(Query.FieldByName('DATA_ATUALIZACAO_ESTOQUE').AsString);

      //Configuracao.ResolucaoVO.ResolucaoTela := Query.FieldByName('RESOLUCAO_TELA').AsString;
      //Configuracao.ResolucaoVO.Largura := Query.FieldByName('LARGURA').AsInteger;
      //Configuracao.ResolucaoVO.Altura := Query.FieldByName('ALTURA').AsInteger;
      //Configuracao.ResolucaoVO.ImagemTela := Query.FieldByName('IMAGEM_TELA').AsString;
      //Configuracao.ResolucaoVO.ImagemMenu := Query.FieldByName('IMAGEM_MENU').AsString;
      //Configuracao.ResolucaoVO.ImagemSubMenu := Query.FieldByName('IMAGEM_SUBMENU').AsString;
      //Configuracao.ResolucaoVO.HotTrackColor := Query.FieldByName('HOTTRACK_COLOR').AsString;
      //Configuracao.ResolucaoVO.ItemStyleFontName := Query.FieldByName('ITEM_STYLE_FONT_NAME').AsString;
      //Configuracao.ResolucaoVO.ItemStyleFontColor := Query.FieldByName('ITEM_STYLE_FONT_COLOR').AsString;
      //Configuracao.ResolucaoVO.ItemSelStyleColor := Query.FieldByName('ITEM_SEL_STYLE_COLOR').AsString;
      //Configuracao.ResolucaoVO.LabelTotalGeralFontColor := Query.FieldByName('LABEL_TOTAL_GERAL_FONT_COLOR').AsString;
      //Configuracao.ResolucaoVO.ItemStyleFontStyle := Query.FieldByName('ITEM_STYLE_FONT_STYLE').AsString;
      //Configuracao.ResolucaoVO.EditColor := Query.FieldByName('EDITS_COLOR').AsString;
      //Configuracao.ResolucaoVO.EditFontColor := Query.FieldByName('EDITS_FONT_COLOR').AsString;
      //Configuracao.ResolucaoVO.EditDisabledColor := Query.FieldByName('EDITS_DISABLED_COLOR').AsString;
      //Configuracao.ResolucaoVO.EditFontName := Query.FieldByName('EDITS_FONT_NAME').AsString;
      //Configuracao.ResolucaoVO.EditFontStyle := Query.FieldByName('EDITS_FONT_STYLE').AsString;

      //Configuracao.NomeCaixa := Query.FieldByName('NOME_CAIXA').Asstring;
      Configuracao.ModeloImpressora := Query.FieldByName('MODELO_ACBR').AsString;
      Configuracao.NumSerieECF := Query.FieldByName('SERIE').AsString;

      //******* ConfiguracaoBalanca ********************************************
      {Linha := Configuracao.ConfiguracaoBalanca;

      Configuracao.BalancaModelo := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.BalancaIdentificadorBalanca := DevolveConteudoDelimitado('|',Linha);
      Configuracao.BalancaHandShaking := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.BalancaParity := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.BalancaStopBits := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.BalancaDataBits := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.BalancaBaudRate := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.BalancaPortaSerial := DevolveConteudoDelimitado('|',Linha);
      Configuracao.BalancaTimeOut := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.BalancaTipoConfiguracaoBalanca := DevolveConteudoDelimitado('|',Linha);
      //*******  Fim ConfiguracaoBalanca ***************************************

       //******* IndiceGerencial ***********************************************
      Linha := Configuracao.IndiceGerencial;

      Configuracao.GerencialX := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.MeiosDePagamento := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.DavEmitidos := StrToIntDef(DevolveConteudoDelimitado('|',Linha),8);
      Configuracao.IdentificacaoPaf := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.ParametrosDeConfiguracao := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.Relatorio := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      //******* Fim IndiceGerencial ********************************************

      //******* ParametrosDiversos *********************************************
      Linha := Configuracao.ParametrosDiversos;

      Configuracao.PedeCPFCupom := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.UsaIntegracao := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.TimerIntegracao := StrToIntDef(DevolveConteudoDelimitado('|',Linha),8);
      Configuracao.GavetaDinheiro := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.SinalInvertido := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.QtdeMaximaParcelas := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.ImprimeParcelas := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.TecladoReduzido := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      //Parametros do Leitor Serial
      Configuracao.UsaLeitorSerial := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.PortaLeitorSerial := DevolveConteudoDelimitado('|',Linha);
      Configuracao.BaudLeitorSerial := DevolveConteudoDelimitado('|',Linha);
      Configuracao.SufixoLeitorSerial := DevolveConteudoDelimitado('|',Linha);
      Configuracao.IntervaloLeitorSerial := DevolveConteudoDelimitado('|',Linha);
      Configuracao.DataLeitorSerial := DevolveConteudoDelimitado('|',Linha);
      Configuracao.ParidadeLeitorSerial := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.HardFlowLeitorSerial := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.SoftFlowLeitorSerial := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.HandShakeLeitorSerial := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.StopLeitorSerial := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.FilaLeitorSerial := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      Configuracao.ExcluiSufixoLeitorSerial := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);
      //LancamentoNotasManuais
      Configuracao.LancamentoNotasManuais := StrToIntDef(DevolveConteudoDelimitado('|',Linha),0);  }
      //******* Fim ParametrosDiversos *****************************************

      result := Configuracao;
    except
      raise Exception.Create('Ocorreu um erro ao tentar ler as configurações');
    end;
  finally
    Query.Free;
  end;
end;

class function TConfiguracaoController.ConsultaDataAtualizacaoEstoque: String;
begin
  ConsultaSQL :=  'select DATA_ATUALIZACAO_ESTOQUE from ECF_CONFIGURACAO';
  try
    try
      Query := TSQLQuery.Create(nil);
      Query.SQLConnection := FDataModule.Conexao;
      Query.sql.Text := ConsultaSQL;
      Query.Open();
      if not Query.IsEmpty then
        Result := DataParaTexto(Query.FieldByName('DATA_ATUALIZACAO_ESTOQUE').AsDateTime)
      else
        Result := '2000-01-01'
    except
      Result := '2000-01-01'
    end;
  finally
    Query.Free;
  end;

end;

class function TConfiguracaoController.ConsultaIdConfiguracao(Id: Integer): boolean;
begin
  ConsultaSQL := 'select ID from ECF_CONFIGURACAO where (ID = :pID) ';
  try
    try
      Query := TSQLQuery.Create(nil);
      Query.SQLConnection := FDataModule.Conexao;
      Query.sql.Text := ConsultaSQL;
      Query.ParamByName('pID').AsInteger:=Id;
      Query.Open;
      if not Query.IsEmpty then
        result := true
      else
        result := false;
    except
    end;
  finally
    Query.Free;
  end;
end;

end.
