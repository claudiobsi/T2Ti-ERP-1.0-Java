package com.t2tierp.pafecf.vo;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Objeto de valor referente a tabela Configuração.</p>
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
public class ConfiguracaoVO {
    private Integer id;
    private Integer idCaixa;
    private Integer idEmpresa;
    private String mensagemCupom;
    private String portaECF;
    private String portaPinPad;
    private String portaBalanca;
    private String ipServidor;
    private String ipSitef;
    private String tipoTEF;
    private String tituloTelaCaixa;
    private String caminhoImagensProdutos;
    private String caminhoImagensMarketing;
    private String caminhoImagensLayout;
    private String corJanelasInternas;
    private String marketingAtivo;
    private Integer CFOPECF;
    private Integer CFOPNF2;
    private Integer timeOutECF;
    private Integer intervaloECF;
    private String descricaoSuprimento;
    private String descricaoSangria;
    private Integer indiceGerencialDAV;
    private String sincronizado;
    private ResolucaoVO resolucaoVO;
    private ImpressoraVO impressoraVO;
    private Integer decimaisValor;
    private Integer decimaisQuantidade;
    private Integer gerencialMeiosPagamento;
    private Integer gerencialIdentificacaoPaf;
    private Integer gerencialParametrosConfiguracao;

    public ConfiguracaoVO() {
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the idCaixa
     */
    public Integer getIdCaixa() {
        return idCaixa;
    }

    /**
     * @param idCaixa the idCaixa to set
     */
    public void setIdCaixa(Integer idCaixa) {
        this.idCaixa = idCaixa;
    }

    /**
     * @return the idEmpresa
     */
    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * @param idEmpresa the idEmpresa to set
     */
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    /**
     * @return the mensagemCupom
     */
    public String getMensagemCupom() {
        return mensagemCupom;
    }

    /**
     * @param mensagemCupom the mensagemCupom to set
     */
    public void setMensagemCupom(String mensagemCupom) {
        this.mensagemCupom = mensagemCupom;
    }

    /**
     * @return the portaECF
     */
    public String getPortaECF() {
        return portaECF;
    }

    /**
     * @param portaECF the portaECF to set
     */
    public void setPortaECF(String portaECF) {
        this.portaECF = portaECF;
    }

    /**
     * @return the portaPinPad
     */
    public String getPortaPinPad() {
        return portaPinPad;
    }

    /**
     * @param portaPinPad the portaPinPad to set
     */
    public void setPortaPinPad(String portaPinPad) {
        this.portaPinPad = portaPinPad;
    }

    /**
     * @return the portaBalanca
     */
    public String getPortaBalanca() {
        return portaBalanca;
    }

    /**
     * @param portaBalanca the portaBalanca to set
     */
    public void setPortaBalanca(String portaBalanca) {
        this.portaBalanca = portaBalanca;
    }

    /**
     * @return the ipServidor
     */
    public String getIpServidor() {
        return ipServidor;
    }

    /**
     * @param ipServidor the ipServidor to set
     */
    public void setIpServidor(String ipServidor) {
        this.ipServidor = ipServidor;
    }

    /**
     * @return the ipSitef
     */
    public String getIpSitef() {
        return ipSitef;
    }

    /**
     * @param ipSitef the ipSitef to set
     */
    public void setIpSitef(String ipSitef) {
        this.ipSitef = ipSitef;
    }

    /**
     * @return the tipoTEF
     */
    public String getTipoTEF() {
        return tipoTEF;
    }

    /**
     * @param tipoTEF the tipoTEF to set
     */
    public void setTipoTEF(String tipoTEF) {
        this.tipoTEF = tipoTEF;
    }

    /**
     * @return the tituloTelaCaixa
     */
    public String getTituloTelaCaixa() {
        return tituloTelaCaixa;
    }

    /**
     * @param tituloTelaCaixa the tituloTelaCaixa to set
     */
    public void setTituloTelaCaixa(String tituloTelaCaixa) {
        this.tituloTelaCaixa = tituloTelaCaixa;
    }

    /**
     * @return the caminhoImagensProdutos
     */
    public String getCaminhoImagensProdutos() {
        return caminhoImagensProdutos;
    }

    /**
     * @param caminhoImagensProdutos the caminhoImagensProdutos to set
     */
    public void setCaminhoImagensProdutos(String caminhoImagensProdutos) {
        this.caminhoImagensProdutos = caminhoImagensProdutos;
    }

    /**
     * @return the caminhoImagensMarketing
     */
    public String getCaminhoImagensMarketing() {
        return caminhoImagensMarketing;
    }

    /**
     * @param caminhoImagensMarketing the caminhoImagensMarketing to set
     */
    public void setCaminhoImagensMarketing(String caminhoImagensMarketing) {
        this.caminhoImagensMarketing = caminhoImagensMarketing;
    }

    /**
     * @return the caminhoImagensLayout
     */
    public String getCaminhoImagensLayout() {
        return caminhoImagensLayout;
    }

    /**
     * @param caminhoImagensLayout the caminhoImagensLayout to set
     */
    public void setCaminhoImagensLayout(String caminhoImagensLayout) {
        this.caminhoImagensLayout = caminhoImagensLayout;
    }

    /**
     * @return the corJanelasInternas
     */
    public String getCorJanelasInternas() {
        return corJanelasInternas;
    }

    /**
     * @param corJanelasInternas the corJanelasInternas to set
     */
    public void setCorJanelasInternas(String corJanelasInternas) {
        this.corJanelasInternas = corJanelasInternas;
    }

    /**
     * @return the marketingAtivo
     */
    public String getMarketingAtivo() {
        return marketingAtivo;
    }

    /**
     * @param marketingAtivo the marketingAtivo to set
     */
    public void setMarketingAtivo(String marketingAtivo) {
        this.marketingAtivo = marketingAtivo;
    }

    /**
     * @return the CFOPECF
     */
    public Integer getCFOPECF() {
        return CFOPECF;
    }

    /**
     * @param CFOPECF the CFOPECF to set
     */
    public void setCFOPECF(Integer CFOPECF) {
        this.CFOPECF = CFOPECF;
    }

    /**
     * @return the CFOPNF2
     */
    public Integer getCFOPNF2() {
        return CFOPNF2;
    }

    /**
     * @param CFOPNF2 the CFOPNF2 to set
     */
    public void setCFOPNF2(Integer CFOPNF2) {
        this.CFOPNF2 = CFOPNF2;
    }

    /**
     * @return the timeOutECF
     */
    public Integer getTimeOutECF() {
        return timeOutECF;
    }

    /**
     * @param timeOutECF the timeOutECF to set
     */
    public void setTimeOutECF(Integer timeOutECF) {
        this.timeOutECF = timeOutECF;
    }

    /**
     * @return the intervaloECF
     */
    public Integer getIntervaloECF() {
        return intervaloECF;
    }

    /**
     * @param intervaloECF the intervaloECF to set
     */
    public void setIntervaloECF(Integer intervaloECF) {
        this.intervaloECF = intervaloECF;
    }

    /**
     * @return the descricaoSuprimento
     */
    public String getDescricaoSuprimento() {
        return descricaoSuprimento;
    }

    /**
     * @param descricaoSuprimento the descricaoSuprimento to set
     */
    public void setDescricaoSuprimento(String descricaoSuprimento) {
        this.descricaoSuprimento = descricaoSuprimento;
    }

    /**
     * @return the descricaoSangria
     */
    public String getDescricaoSangria() {
        return descricaoSangria;
    }

    /**
     * @param descricaoSangria the descricaoSangria to set
     */
    public void setDescricaoSangria(String descricaoSangria) {
        this.descricaoSangria = descricaoSangria;
    }

    /**
     * @return the indiceGerencialDAV
     */
    public Integer getIndiceGerencialDAV() {
        return indiceGerencialDAV;
    }

    /**
     * @param indiceGerencialDAV the indiceGerencialDAV to set
     */
    public void setIndiceGerencialDAV(Integer indiceGerencialDAV) {
        this.indiceGerencialDAV = indiceGerencialDAV;
    }

    /**
     * @return the sincronizado
     */
    public String getSincronizado() {
        return sincronizado;
    }

    /**
     * @param sincronizado the sincronizado to set
     */
    public void setSincronizado(String sincronizado) {
        this.sincronizado = sincronizado;
    }

    /**
     * @return the resolucaoVO
     */
    public ResolucaoVO getResolucaoVO() {
        return resolucaoVO;
    }

    /**
     * @param resolucaoVO the resolucaoVO to set
     */
    public void setResolucaoVO(ResolucaoVO resolucaoVO) {
        this.resolucaoVO = resolucaoVO;
    }

    /**
     * @return the impressoraVO
     */
    public ImpressoraVO getImpressoraVO() {
        return impressoraVO;
    }

    /**
     * @param impressoraVO the impressoraVO to set
     */
    public void setImpressoraVO(ImpressoraVO impressoraVO) {
        this.impressoraVO = impressoraVO;
    }

    /**
     * @return the decimaisValor
     */
    public Integer getDecimaisValor() {
        return decimaisValor;
    }

    /**
     * @param decimaisValor the decimaisValor to set
     */
    public void setDecimaisValor(Integer decimaisValor) {
        this.decimaisValor = decimaisValor;
    }

    /**
     * @return the decimaisQuantidade
     */
    public Integer getDecimaisQuantidade() {
        return decimaisQuantidade;
    }

    /**
     * @param decimaisQuantidade the decimaisQuantidade to set
     */
    public void setDecimaisQuantidade(Integer decimaisQuantidade) {
        this.decimaisQuantidade = decimaisQuantidade;
    }

    /**
     * @return the gerencialMeiosPagamento
     */
    public Integer getGerencialMeiosPagamento() {
        return gerencialMeiosPagamento;
    }

    /**
     * @param gerencialMeiosPagamento the gerencialMeiosPagamento to set
     */
    public void setGerencialMeiosPagamento(Integer gerencialMeiosPagamento) {
        this.gerencialMeiosPagamento = gerencialMeiosPagamento;
    }

    /**
     * @return the gerencialIdentificacaoPaf
     */
    public Integer getGerencialIdentificacaoPaf() {
        return gerencialIdentificacaoPaf;
    }

    /**
     * @param gerencialIdentificacaoPaf the gerencialIdentificacaoPaf to set
     */
    public void setGerencialIdentificacaoPaf(Integer gerencialIdentificacaoPaf) {
        this.gerencialIdentificacaoPaf = gerencialIdentificacaoPaf;
    }

    /**
     * @return the gerencialParametrosConfiguracao
     */
    public Integer getGerencialParametrosConfiguracao() {
        return gerencialParametrosConfiguracao;
    }

    /**
     * @param gerencialParametrosConfiguracao the gerencialParametrosConfiguracao to set
     */
    public void setGerencialParametrosConfiguracao(Integer gerencialParametrosConfiguracao) {
        this.gerencialParametrosConfiguracao = gerencialParametrosConfiguracao;
    }

}