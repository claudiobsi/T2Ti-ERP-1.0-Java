/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Regras de negócio/persistência das Configurações.</p>
 *
 * <p>The MIT License</p>
 *
 * <p>Copyright: Copyright (C) 2010 T2Ti.COM</p>
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 *       The author may be contacted at:
 *           t2ti.com@gmail.com</p>
 *
 * @author Albert Eije (T2Ti.COM)
 * @version 1.0
 */
package com.t2tierp.pafecf.controller;

import com.t2tierp.pafecf.bd.AcessoBanco;
import com.t2tierp.pafecf.vo.ConfiguracaoVO;
import com.t2tierp.pafecf.vo.ImpressoraVO;
import com.t2tierp.pafecf.vo.PosicaoComponentesVO;
import com.t2tierp.pafecf.vo.ResolucaoVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConfiguracaoController {

    String consultaSQL;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    AcessoBanco bd = new AcessoBanco();

    public List<PosicaoComponentesVO> verificaPosicaoTamanho() {
        List<PosicaoComponentesVO> listaPosicoes = new ArrayList<PosicaoComponentesVO>();
        consultaSQL =
                "select P.ID, P.NOME, P.ALTURA, P.LARGURA, P.TOPO, P.ESQUERDA, "
                + "P.TAMANHO_FONTE, P.TEXTO, C.ID_ECF_RESOLUCAO "
                + "from ECF_POSICAO_COMPONENTES P, ECF_CONFIGURACAO C "
                + "where P.ID_ECF_RESOLUCAO=C.ID_ECF_RESOLUCAO";
        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(consultaSQL);
            rs.beforeFirst();
            rs.beforeFirst();
            while (rs.next()) {
                PosicaoComponentesVO posicao = new PosicaoComponentesVO();
                posicao.setId(rs.getInt("ID"));
                posicao.setNomeComponente(rs.getString("NOME"));
                posicao.setAltura(rs.getInt("ALTURA"));
                posicao.setLargura(rs.getInt("LARGURA"));
                posicao.setTopo(rs.getInt("TOPO"));
                posicao.setEsquerda(rs.getInt("ESQUERDA"));
                posicao.setTamanhoFonte(rs.getInt("TAMANHO_FONTE"));
                posicao.setTextoComponente(rs.getString("TEXTO"));
                listaPosicoes.add(posicao);
            }
            return listaPosicoes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            bd.desconectar();
        }
    }

    public ConfiguracaoVO pegaConfiguracao() {
        ConfiguracaoVO configuracao = new ConfiguracaoVO();
        ImpressoraVO impressora = new ImpressoraVO();
        configuracao.setImpressoraVO(impressora);
        ResolucaoVO resolucao = new ResolucaoVO();
        configuracao.setResolucaoVO(resolucao);

        consultaSQL =
                "select C.ID_ECF_RESOLUCAO, R.RESOLUCAO_TELA, R.LARGURA, R.ALTURA, R.IMAGEM_TELA,"
                + "C.ID_ECF_IMPRESSORA, C.ID_ECF_CAIXA, C.ID_ECF_EMPRESA, C.MENSAGEM_CUPOM, C.PORTA_ECF, "
                + "C.PORTA_PINPAD, C.PORTA_BALANCA, C.IP_SERVIDOR, C.IP_SITEF, C.MARKETING_ATIVO, "
                + "C.TIPO_TEF, C.TITULO_TELA_CAIXA, C.SINCRONIZADO, C.COR_JANELAS_INTERNAS, "
                + "C.DESCRICAO_SUPRIMENTO, C.DESCRICAO_SANGRIA, C.INDICE_GERENCIAL_DAV, "
                + "C.CFOP_ECF, C.CFOP_NF2, C.TIMEOUT_ECF, C.INTERVALO_ECF, I.MODELO_ACBR, I.NUMERO_ECF, I.SERIE, "
                + "C.CAMINHO_IMAGENS_PRODUTOS, C.CAMINHO_IMAGENS_MARKETING, C.CAMINHO_IMAGENS_LAYOUT, "
                + "C.DECIMAIS_QUANTIDADE, C.DECIMAIS_VALOR, "
                + "C.GERENCIAL_MEIOS_PAGAMENTO, C.GERENCIAL_IDENTIFICACAO_PAF, C.GERENCIAL_PARAMETROS_CONFIGURACAO "
                + "from ECF_RESOLUCAO R, ECF_CONFIGURACAO C, ECF_IMPRESSORA I "
                + "where C.ID_ECF_RESOLUCAO=R.ID and C.ID_ECF_IMPRESSORA=I.ID";
        try {
            stm = bd.conectar().createStatement();
            rs = stm.executeQuery(consultaSQL);
            rs.beforeFirst();
            if (rs.next()) {
                configuracao.setMensagemCupom(rs.getString("MENSAGEM_CUPOM"));
                configuracao.setIdEmpresa(rs.getInt("ID_ECF_EMPRESA"));
                configuracao.setIdCaixa(rs.getInt("ID_ECF_CAIXA"));
                configuracao.setPortaECF(rs.getString("PORTA_ECF"));
                configuracao.setPortaBalanca(rs.getString("PORTA_BALANCA"));
                configuracao.setPortaPinPad(rs.getString("PORTA_PINPAD"));
                configuracao.setIpServidor(rs.getString("IP_SERVIDOR"));
                configuracao.setIpSitef(rs.getString("IP_SITEF"));
                configuracao.setTipoTEF(rs.getString("TIPO_TEF"));
                configuracao.setTituloTelaCaixa(rs.getString("TITULO_TELA_CAIXA"));
                configuracao.setCaminhoImagensProdutos(rs.getString("CAMINHO_IMAGENS_PRODUTOS"));
                configuracao.setCaminhoImagensMarketing(rs.getString("CAMINHO_IMAGENS_MARKETING"));
                configuracao.setCaminhoImagensLayout(rs.getString("CAMINHO_IMAGENS_LAYOUT"));
                configuracao.setMarketingAtivo(rs.getString("MARKETING_ATIVO"));
                configuracao.setCorJanelasInternas(rs.getString("COR_JANELAS_INTERNAS"));
                configuracao.setCFOPECF(rs.getInt("CFOP_ECF"));
                configuracao.setCFOPNF2(rs.getInt("CFOP_NF2"));
                configuracao.setTimeOutECF(rs.getInt("TIMEOUT_ECF"));
                configuracao.setIntervaloECF(rs.getInt("INTERVALO_ECF"));
                configuracao.setDescricaoSuprimento(rs.getString("DESCRICAO_SUPRIMENTO"));
                configuracao.setDescricaoSangria(rs.getString("DESCRICAO_SANGRIA"));
                configuracao.setIndiceGerencialDAV(rs.getInt("INDICE_GERENCIAL_DAV"));
                configuracao.setDecimaisQuantidade(rs.getInt("DECIMAIS_QUANTIDADE"));
                configuracao.setDecimaisValor(rs.getInt("DECIMAIS_VALOR"));
                configuracao.setGerencialIdentificacaoPaf(rs.getInt("GERENCIAL_IDENTIFICACAO_PAF"));
                configuracao.setGerencialMeiosPagamento(rs.getInt("GERENCIAL_IDENTIFICACAO_PAF"));
                configuracao.setGerencialParametrosConfiguracao(rs.getInt("GERENCIAL_PARAMETROS_CONFIGURACAO"));

                configuracao.getImpressoraVO().setId(rs.getInt("ID_ECF_IMPRESSORA"));
                configuracao.getImpressoraVO().setModeloACBr(rs.getString("MODELO_ACBR"));
                configuracao.getImpressoraVO().setNumeroEcf(rs.getString("NUMERO_ECF"));
                configuracao.getImpressoraVO().setSerie(rs.getString("SERIE"));

                configuracao.getResolucaoVO().setImagemTela(rs.getString("IMAGEM_TELA"));
                configuracao.getResolucaoVO().setResolucaoTela(rs.getString("RESOLUCAO_TELA"));
                configuracao.getResolucaoVO().setLargura(rs.getInt("LARGURA"));
                configuracao.getResolucaoVO().setAltura(rs.getInt("ALTURA"));

                return configuracao;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            bd.desconectar();
        }
    }
}