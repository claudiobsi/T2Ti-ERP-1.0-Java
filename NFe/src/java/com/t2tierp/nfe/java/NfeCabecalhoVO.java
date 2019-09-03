package com.t2tierp.nfe.java;

import com.t2tierp.cadastros.java.ClienteVO;
import com.t2tierp.cadastros.java.EmpresaVO;
import com.t2tierp.cadastros.java.FornecedorVO;
import com.t2tierp.tributacao.java.TributOperacaoFiscalVO;
import com.t2tierp.vendas.java.VendaCabecalhoVO;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.openswing.swing.message.receive.java.ValueObjectImpl;


/**
* <p>Title: T2Ti ERP</p>
* <p>Description:  VO relacionado a tabela [NFE_CABECALHO]</p>
*
* <p>The MIT License</p>
*
* <p>Copyright: Copyright (C) 2010 T2Ti.COM
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
*        The author may be contacted at:
*            t2ti.com@gmail.com</p>
*
* @author Claudio de Barros (t2ti.com@gmail.com)
* @version 1.0
*/
@Entity
@Table(name = "NFE_CABECALHO")
public class NfeCabecalhoVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "UF_EMITENTE")
    private Integer ufEmitente;
    @Column(name = "CODIGO_NUMERICO")
    private String codigoNumerico;
    @Column(name = "NATUREZA_OPERACAO")
    private String naturezaOperacao;
    @Column(name = "INDICADOR_FORMA_PAGAMENTO")
    private String indicadorFormaPagamento;
    @Column(name = "CODIGO_MODELO")
    private String codigoModelo;
    @Column(name = "SERIE")
    private String serie;
    @Column(name = "NUMERO")
    private String numero;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_EMISSAO")
    private Date dataEmissao;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_ENTRADA_SAIDA")
    private Date dataEntradaSaida;
    @Column(name = "HORA_ENTRADA_SAIDA")
    private String horaEntradaSaida;
    @Column(name = "TIPO_OPERACAO")
    private String tipoOperacao;
    @Column(name = "CODIGO_MUNICIPIO")
    private Integer codigoMunicipio;
    @Column(name = "FORMATO_IMPRESSAO_DANFE")
    private String formatoImpressaoDanfe;
    @Column(name = "TIPO_EMISSAO")
    private String tipoEmissao;
    @Column(name = "CHAVE_ACESSO")
    private String chaveAcesso;
    @Column(name = "DIGITO_CHAVE_ACESSO")
    private String digitoChaveAcesso;
    @Column(name = "AMBIENTE")
    private String ambiente;
    @Column(name = "FINALIDADE_EMISSAO")
    private String finalidadeEmissao;
    @Column(name = "PROCESSO_EMISSAO")
    private String processoEmissao;
    @Column(name = "VERSAO_PROCESSO_EMISSAO")
    private String versaoProcessoEmissao;
    @Column(name = "DATA_ENTRADA_CONTINGENCIA")
    private Timestamp dataEntradaContingencia;
    @Column(name = "JUSTIFICATIVA_CONTINGENCIA")
    private String justificativaContingencia;
    @Column(name = "BASE_CALCULO_ICMS")
    private BigDecimal baseCalculoIcms;
    @Column(name = "VALOR_ICMS")
    private BigDecimal valorIcms;
    @Column(name = "BASE_CALCULO_ICMS_ST")
    private BigDecimal baseCalculoIcmsSt;
    @Column(name = "VALOR_ICMS_ST")
    private BigDecimal valorIcmsSt;
    @Column(name = "VALOR_TOTAL_PRODUTOS")
    private BigDecimal valorTotalProdutos;
    @Column(name = "VALOR_FRETE")
    private BigDecimal valorFrete;
    @Column(name = "VALOR_SEGURO")
    private BigDecimal valorSeguro;
    @Column(name = "VALOR_DESCONTO")
    private BigDecimal valorDesconto;
    @Column(name = "VALOR_IMPOSTO_IMPORTACAO")
    private BigDecimal valorImpostoImportacao;
    @Column(name = "VALOR_IPI")
    private BigDecimal valorIpi;
    @Column(name = "VALOR_PIS")
    private BigDecimal valorPis;
    @Column(name = "VALOR_COFINS")
    private BigDecimal valorCofins;
    @Column(name = "VALOR_DESPESAS_ACESSORIAS")
    private BigDecimal valorDespesasAcessorias;
    @Column(name = "VALOR_TOTAL")
    private BigDecimal valorTotal;
    @Column(name = "VALOR_SERVICOS")
    private BigDecimal valorServicos;
    @Column(name = "BASE_CALCULO_ISSQN")
    private BigDecimal baseCalculoIssqn;
    @Column(name = "VALOR_ISSQN")
    private BigDecimal valorIssqn;
    @Column(name = "VALOR_PIS_ISSQN")
    private BigDecimal valorPisIssqn;
    @Column(name = "VALOR_COFINS_ISSQN")
    private BigDecimal valorCofinsIssqn;
    @Column(name = "VALOR_RETIDO_PIS")
    private BigDecimal valorRetidoPis;
    @Column(name = "VALOR_RETIDO_COFINS")
    private BigDecimal valorRetidoCofins;
    @Column(name = "VALOR_RETIDO_CSLL")
    private BigDecimal valorRetidoCsll;
    @Column(name = "BASE_CALCULO_IRRF")
    private BigDecimal baseCalculoIrrf;
    @Column(name = "VALOR_RETIDO_IRRF")
    private BigDecimal valorRetidoIrrf;
    @Column(name = "BASE_CALCULO_PREVIDENCIA")
    private BigDecimal baseCalculoPrevidencia;
    @Column(name = "VALOR_RETIDO_PREVIDENCIA")
    private BigDecimal valorRetidoPrevidencia;
    @Column(name = "COMEX_UF_EMBARQUE")
    private String comexUfEmbarque;
    @Column(name = "COMEX_LOCAL_EMBARQUE")
    private String comexLocalEmbarque;
    @Column(name = "COMPRA_NOTA_EMPENHO")
    private String compraNotaEmpenho;
    @Column(name = "COMPRA_PEDIDO")
    private String compraPedido;
    @Column(name = "COMPRA_CONTRATO")
    private String compraContrato;
    @Column(name = "INFORMACOES_ADD_FISCO")
    private String informacoesAddFisco;
    @Column(name = "INFORMACOES_ADD_CONTRIBUINTE")
    private String informacoesAddContribuinte;
    @Column(name = "STATUS_NOTA")
    private String statusNota;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID")
    @ManyToOne
    private ClienteVO cliente;
    @JoinColumn(name = "ID_FORNECEDOR", referencedColumnName = "ID")
    @ManyToOne
    private FornecedorVO fornecedor;
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID")
    @ManyToOne
    private EmpresaVO empresa;
    @JoinColumn(name = "ID_VENDA_CABECALHO", referencedColumnName = "ID")
    @ManyToOne
    private VendaCabecalhoVO vendaCabecalho;
    @JoinColumn(name = "ID_TRIBUT_OPERACAO_FISCAL", referencedColumnName = "ID")
    @ManyToOne
    private TributOperacaoFiscalVO tributOperacaoFiscal;
    
    public NfeCabecalhoVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUfEmitente() {
        return ufEmitente;
    }

    public void setUfEmitente(Integer ufEmitente) {
        this.ufEmitente = ufEmitente;
    }

    public String getCodigoNumerico() {
        return codigoNumerico;
    }

    public void setCodigoNumerico(String codigoNumerico) {
        this.codigoNumerico = codigoNumerico;
    }

    public String getNaturezaOperacao() {
        return naturezaOperacao;
    }

    public void setNaturezaOperacao(String naturezaOperacao) {
        this.naturezaOperacao = naturezaOperacao;
    }

    public String getIndicadorFormaPagamento() {
        return indicadorFormaPagamento;
    }

    public void setIndicadorFormaPagamento(String indicadorFormaPagamento) {
        this.indicadorFormaPagamento = indicadorFormaPagamento;
    }

    public String getCodigoModelo() {
        return codigoModelo;
    }

    public void setCodigoModelo(String codigoModelo) {
        this.codigoModelo = codigoModelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataEntradaSaida() {
        return dataEntradaSaida;
    }

    public void setDataEntradaSaida(Date dataEntradaSaida) {
        this.dataEntradaSaida = dataEntradaSaida;
    }

    public String getHoraEntradaSaida() {
        return horaEntradaSaida;
    }

    public void setHoraEntradaSaida(String horaEntradaSaida) {
        this.horaEntradaSaida = horaEntradaSaida;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public Integer getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(Integer codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getFormatoImpressaoDanfe() {
        return formatoImpressaoDanfe;
    }

    public void setFormatoImpressaoDanfe(String formatoImpressaoDanfe) {
        this.formatoImpressaoDanfe = formatoImpressaoDanfe;
    }

    public String getTipoEmissao() {
        return tipoEmissao;
    }

    public void setTipoEmissao(String tipoEmissao) {
        this.tipoEmissao = tipoEmissao;
    }

    public String getChaveAcesso() {
        return chaveAcesso;
    }

    public void setChaveAcesso(String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }

    public String getDigitoChaveAcesso() {
        return digitoChaveAcesso;
    }

    public void setDigitoChaveAcesso(String digitoChaveAcesso) {
        this.digitoChaveAcesso = digitoChaveAcesso;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getFinalidadeEmissao() {
        return finalidadeEmissao;
    }

    public void setFinalidadeEmissao(String finalidadeEmissao) {
        this.finalidadeEmissao = finalidadeEmissao;
    }

    public String getProcessoEmissao() {
        return processoEmissao;
    }

    public void setProcessoEmissao(String processoEmissao) {
        this.processoEmissao = processoEmissao;
    }

    public String getVersaoProcessoEmissao() {
        return versaoProcessoEmissao;
    }

    public void setVersaoProcessoEmissao(String versaoProcessoEmissao) {
        this.versaoProcessoEmissao = versaoProcessoEmissao;
    }

    public Timestamp getDataEntradaContingencia() {
        return dataEntradaContingencia;
    }

    public void setDataEntradaContingencia(Timestamp dataEntradaContingencia) {
        this.dataEntradaContingencia = dataEntradaContingencia;
    }

    public String getJustificativaContingencia() {
        return justificativaContingencia;
    }

    public void setJustificativaContingencia(String justificativaContingencia) {
        this.justificativaContingencia = justificativaContingencia;
    }

    public BigDecimal getBaseCalculoIcms() {
        return baseCalculoIcms;
    }

    public void setBaseCalculoIcms(BigDecimal baseCalculoIcms) {
        this.baseCalculoIcms = baseCalculoIcms;
    }

    public BigDecimal getValorIcms() {
        return valorIcms;
    }

    public void setValorIcms(BigDecimal valorIcms) {
        this.valorIcms = valorIcms;
    }

    public BigDecimal getBaseCalculoIcmsSt() {
        return baseCalculoIcmsSt;
    }

    public void setBaseCalculoIcmsSt(BigDecimal baseCalculoIcmsSt) {
        this.baseCalculoIcmsSt = baseCalculoIcmsSt;
    }

    public BigDecimal getValorIcmsSt() {
        return valorIcmsSt;
    }

    public void setValorIcmsSt(BigDecimal valorIcmsSt) {
        this.valorIcmsSt = valorIcmsSt;
    }

    public BigDecimal getValorTotalProdutos() {
        return valorTotalProdutos;
    }

    public void setValorTotalProdutos(BigDecimal valorTotalProdutos) {
        this.valorTotalProdutos = valorTotalProdutos;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public BigDecimal getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(BigDecimal valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public BigDecimal getValorImpostoImportacao() {
        return valorImpostoImportacao;
    }

    public void setValorImpostoImportacao(BigDecimal valorImpostoImportacao) {
        this.valorImpostoImportacao = valorImpostoImportacao;
    }

    public BigDecimal getValorIpi() {
        return valorIpi;
    }

    public void setValorIpi(BigDecimal valorIpi) {
        this.valorIpi = valorIpi;
    }

    public BigDecimal getValorPis() {
        return valorPis;
    }

    public void setValorPis(BigDecimal valorPis) {
        this.valorPis = valorPis;
    }

    public BigDecimal getValorCofins() {
        return valorCofins;
    }

    public void setValorCofins(BigDecimal valorCofins) {
        this.valorCofins = valorCofins;
    }

    public BigDecimal getValorDespesasAcessorias() {
        return valorDespesasAcessorias;
    }

    public void setValorDespesasAcessorias(BigDecimal valorDespesasAcessorias) {
        this.valorDespesasAcessorias = valorDespesasAcessorias;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorServicos() {
        return valorServicos;
    }

    public void setValorServicos(BigDecimal valorServicos) {
        this.valorServicos = valorServicos;
    }

    public BigDecimal getBaseCalculoIssqn() {
        return baseCalculoIssqn;
    }

    public void setBaseCalculoIssqn(BigDecimal baseCalculoIssqn) {
        this.baseCalculoIssqn = baseCalculoIssqn;
    }

    public BigDecimal getValorIssqn() {
        return valorIssqn;
    }

    public void setValorIssqn(BigDecimal valorIssqn) {
        this.valorIssqn = valorIssqn;
    }

    public BigDecimal getValorPisIssqn() {
        return valorPisIssqn;
    }

    public void setValorPisIssqn(BigDecimal valorPisIssqn) {
        this.valorPisIssqn = valorPisIssqn;
    }

    public BigDecimal getValorCofinsIssqn() {
        return valorCofinsIssqn;
    }

    public void setValorCofinsIssqn(BigDecimal valorCofinsIssqn) {
        this.valorCofinsIssqn = valorCofinsIssqn;
    }

    public BigDecimal getValorRetidoPis() {
        return valorRetidoPis;
    }

    public void setValorRetidoPis(BigDecimal valorRetidoPis) {
        this.valorRetidoPis = valorRetidoPis;
    }

    public BigDecimal getValorRetidoCofins() {
        return valorRetidoCofins;
    }

    public void setValorRetidoCofins(BigDecimal valorRetidoCofins) {
        this.valorRetidoCofins = valorRetidoCofins;
    }

    public BigDecimal getValorRetidoCsll() {
        return valorRetidoCsll;
    }

    public void setValorRetidoCsll(BigDecimal valorRetidoCsll) {
        this.valorRetidoCsll = valorRetidoCsll;
    }

    public BigDecimal getBaseCalculoIrrf() {
        return baseCalculoIrrf;
    }

    public void setBaseCalculoIrrf(BigDecimal baseCalculoIrrf) {
        this.baseCalculoIrrf = baseCalculoIrrf;
    }

    public BigDecimal getValorRetidoIrrf() {
        return valorRetidoIrrf;
    }

    public void setValorRetidoIrrf(BigDecimal valorRetidoIrrf) {
        this.valorRetidoIrrf = valorRetidoIrrf;
    }

    public BigDecimal getBaseCalculoPrevidencia() {
        return baseCalculoPrevidencia;
    }

    public void setBaseCalculoPrevidencia(BigDecimal baseCalculoPrevidencia) {
        this.baseCalculoPrevidencia = baseCalculoPrevidencia;
    }

    public BigDecimal getValorRetidoPrevidencia() {
        return valorRetidoPrevidencia;
    }

    public void setValorRetidoPrevidencia(BigDecimal valorRetidoPrevidencia) {
        this.valorRetidoPrevidencia = valorRetidoPrevidencia;
    }

    public String getComexUfEmbarque() {
        return comexUfEmbarque;
    }

    public void setComexUfEmbarque(String comexUfEmbarque) {
        this.comexUfEmbarque = comexUfEmbarque;
    }

    public String getComexLocalEmbarque() {
        return comexLocalEmbarque;
    }

    public void setComexLocalEmbarque(String comexLocalEmbarque) {
        this.comexLocalEmbarque = comexLocalEmbarque;
    }

    public String getCompraNotaEmpenho() {
        return compraNotaEmpenho;
    }

    public void setCompraNotaEmpenho(String compraNotaEmpenho) {
        this.compraNotaEmpenho = compraNotaEmpenho;
    }

    public String getCompraPedido() {
        return compraPedido;
    }

    public void setCompraPedido(String compraPedido) {
        this.compraPedido = compraPedido;
    }

    public String getCompraContrato() {
        return compraContrato;
    }

    public void setCompraContrato(String compraContrato) {
        this.compraContrato = compraContrato;
    }

    public String getInformacoesAddFisco() {
        return informacoesAddFisco;
    }

    public void setInformacoesAddFisco(String informacoesAddFisco) {
        this.informacoesAddFisco = informacoesAddFisco;
    }

    public String getInformacoesAddContribuinte() {
        return informacoesAddContribuinte;
    }

    public void setInformacoesAddContribuinte(String informacoesAddContribuinte) {
        this.informacoesAddContribuinte = informacoesAddContribuinte;
    }

    public String getStatusNota() {
        return statusNota;
    }

    public void setStatusNota(String statusNota) {
        this.statusNota = statusNota;
    }

    public ClienteVO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteVO cliente) {
        this.cliente = cliente;
    }

    public FornecedorVO getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorVO fornecedor) {
        this.fornecedor = fornecedor;
    }

    public EmpresaVO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaVO empresa) {
        this.empresa = empresa;
    }

    public VendaCabecalhoVO getVendaCabecalho() {
        return vendaCabecalho;
    }

    public void setVendaCabecalho(VendaCabecalhoVO vendaCabecalho) {
        this.vendaCabecalho = vendaCabecalho;
    }

    public TributOperacaoFiscalVO getTributOperacaoFiscal() {
        return tributOperacaoFiscal;
    }

    public void setTributOperacaoFiscal(TributOperacaoFiscalVO tributOperacaoFiscal) {
        this.tributOperacaoFiscal = tributOperacaoFiscal;
    }


    @Override
    public String toString() {
        return "com.t2tierp.nfe.java.NfeCabecalhoVO[id=" + id + "]";
    }

}
