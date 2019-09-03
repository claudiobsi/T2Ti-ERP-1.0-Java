/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.t2ti.vo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author T2Ti
 */
@Entity
@Table(name = "ecf_configuracao")
@NamedQueries({
    @NamedQuery(name = "EcfConfiguracaoVO.findAll", query = "SELECT e FROM EcfConfiguracaoVO e")})
public class EcfConfiguracaoVO extends ValueObjectImpl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "MENSAGEM_CUPOM")
    private String mensagemCupom;
    @Column(name = "PORTA_ECF")
    private String portaEcf;
    @Column(name = "PORTA_PINPAD")
    private String portaPinpad;
    @Column(name = "PORTA_BALANCA")
    private String portaBalanca;
    @Column(name = "IP_SERVIDOR")
    private String ipServidor;
    @Column(name = "IP_SITEF")
    private String ipSitef;
    @Column(name = "TIPO_TEF")
    private String tipoTef;
    @Column(name = "TITULO_TELA_CAIXA")
    private String tituloTelaCaixa;
    @Column(name = "CAMINHO_IMAGENS_PRODUTOS")
    private String caminhoImagensProdutos;
    @Column(name = "CAMINHO_IMAGENS_MARKETING")
    private String caminhoImagensMarketing;
    @Column(name = "CAMINHO_IMAGENS_LAYOUT")
    private String caminhoImagensLayout;
    @Column(name = "COR_JANELAS_INTERNAS")
    private String corJanelasInternas;
    @Column(name = "MARKETING_ATIVO")
    private Character marketingAtivo;
    @Column(name = "CFOP_ECF")
    private Integer cfopEcf;
    @Column(name = "CFOP_NF2")
    private Integer cfopNf2;
    @Column(name = "TIMEOUT_ECF")
    private Integer timeoutEcf;
    @Column(name = "INTERVALO_ECF")
    private Integer intervaloEcf;
    @Column(name = "DESCRICAO_SUPRIMENTO")
    private String descricaoSuprimento;
    @Column(name = "DESCRICAO_SANGRIA")
    private String descricaoSangria;
    @Column(name = "TEF_TIPO_GP")
    private Integer tefTipoGp;
    @Column(name = "TEF_TEMPO_ESPERA")
    private Integer tefTempoEspera;
    @Column(name = "TEF_ESPERA_STS")
    private Integer tefEsperaSts;
    @Column(name = "TEF_NUMERO_VIAS")
    private Integer tefNumeroVias;
    @Column(name = "INDICE_GERENCIAL_DAV")
    private Integer indiceGerencialDav;
    @Column(name = "DECIMAIS_QUANTIDADE")
    private Integer decimaisQuantidade;
    @Column(name = "DECIMAIS_VALOR")
    private Integer decimaisValor;
    @Column(name = "SINCRONIZADO")
    private Character sincronizado;

    public EcfConfiguracaoVO() {
    }

    public EcfConfiguracaoVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMensagemCupom() {
        return mensagemCupom;
    }

    public void setMensagemCupom(String mensagemCupom) {
        this.mensagemCupom = mensagemCupom;
    }

    public String getPortaEcf() {
        return portaEcf;
    }

    public void setPortaEcf(String portaEcf) {
        this.portaEcf = portaEcf;
    }

    public String getPortaPinpad() {
        return portaPinpad;
    }

    public void setPortaPinpad(String portaPinpad) {
        this.portaPinpad = portaPinpad;
    }

    public String getPortaBalanca() {
        return portaBalanca;
    }

    public void setPortaBalanca(String portaBalanca) {
        this.portaBalanca = portaBalanca;
    }

    public String getIpServidor() {
        return ipServidor;
    }

    public void setIpServidor(String ipServidor) {
        this.ipServidor = ipServidor;
    }

    public String getIpSitef() {
        return ipSitef;
    }

    public void setIpSitef(String ipSitef) {
        this.ipSitef = ipSitef;
    }

    public String getTipoTef() {
        return tipoTef;
    }

    public void setTipoTef(String tipoTef) {
        this.tipoTef = tipoTef;
    }

    public String getTituloTelaCaixa() {
        return tituloTelaCaixa;
    }

    public void setTituloTelaCaixa(String tituloTelaCaixa) {
        this.tituloTelaCaixa = tituloTelaCaixa;
    }

    public String getCaminhoImagensProdutos() {
        return caminhoImagensProdutos;
    }

    public void setCaminhoImagensProdutos(String caminhoImagensProdutos) {
        this.caminhoImagensProdutos = caminhoImagensProdutos;
    }

    public String getCaminhoImagensMarketing() {
        return caminhoImagensMarketing;
    }

    public void setCaminhoImagensMarketing(String caminhoImagensMarketing) {
        this.caminhoImagensMarketing = caminhoImagensMarketing;
    }

    public String getCaminhoImagensLayout() {
        return caminhoImagensLayout;
    }

    public void setCaminhoImagensLayout(String caminhoImagensLayout) {
        this.caminhoImagensLayout = caminhoImagensLayout;
    }

    public String getCorJanelasInternas() {
        return corJanelasInternas;
    }

    public void setCorJanelasInternas(String corJanelasInternas) {
        this.corJanelasInternas = corJanelasInternas;
    }

    public Character getMarketingAtivo() {
        return marketingAtivo;
    }

    public void setMarketingAtivo(Character marketingAtivo) {
        this.marketingAtivo = marketingAtivo;
    }

    public Integer getCfopEcf() {
        return cfopEcf;
    }

    public void setCfopEcf(Integer cfopEcf) {
        this.cfopEcf = cfopEcf;
    }

    public Integer getCfopNf2() {
        return cfopNf2;
    }

    public void setCfopNf2(Integer cfopNf2) {
        this.cfopNf2 = cfopNf2;
    }

    public Integer getTimeoutEcf() {
        return timeoutEcf;
    }

    public void setTimeoutEcf(Integer timeoutEcf) {
        this.timeoutEcf = timeoutEcf;
    }

    public Integer getIntervaloEcf() {
        return intervaloEcf;
    }

    public void setIntervaloEcf(Integer intervaloEcf) {
        this.intervaloEcf = intervaloEcf;
    }

    public String getDescricaoSuprimento() {
        return descricaoSuprimento;
    }

    public void setDescricaoSuprimento(String descricaoSuprimento) {
        this.descricaoSuprimento = descricaoSuprimento;
    }

    public String getDescricaoSangria() {
        return descricaoSangria;
    }

    public void setDescricaoSangria(String descricaoSangria) {
        this.descricaoSangria = descricaoSangria;
    }

    public Integer getTefTipoGp() {
        return tefTipoGp;
    }

    public void setTefTipoGp(Integer tefTipoGp) {
        this.tefTipoGp = tefTipoGp;
    }

    public Integer getTefTempoEspera() {
        return tefTempoEspera;
    }

    public void setTefTempoEspera(Integer tefTempoEspera) {
        this.tefTempoEspera = tefTempoEspera;
    }

    public Integer getTefEsperaSts() {
        return tefEsperaSts;
    }

    public void setTefEsperaSts(Integer tefEsperaSts) {
        this.tefEsperaSts = tefEsperaSts;
    }

    public Integer getTefNumeroVias() {
        return tefNumeroVias;
    }

    public void setTefNumeroVias(Integer tefNumeroVias) {
        this.tefNumeroVias = tefNumeroVias;
    }

    public Integer getIndiceGerencialDav() {
        return indiceGerencialDav;
    }

    public void setIndiceGerencialDav(Integer indiceGerencialDav) {
        this.indiceGerencialDav = indiceGerencialDav;
    }

    public Integer getDecimaisQuantidade() {
        return decimaisQuantidade;
    }

    public void setDecimaisQuantidade(Integer decimaisQuantidade) {
        this.decimaisQuantidade = decimaisQuantidade;
    }

    public Integer getDecimaisValor() {
        return decimaisValor;
    }

    public void setDecimaisValor(Integer decimaisValor) {
        this.decimaisValor = decimaisValor;
    }

    public Character getSincronizado() {
        return sincronizado;
    }

    public void setSincronizado(Character sincronizado) {
        this.sincronizado = sincronizado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EcfConfiguracaoVO)) {
            return false;
        }
        EcfConfiguracaoVO other = (EcfConfiguracaoVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.t2ti.vo.EcfConfiguracaoVO[id=" + id + "]";
    }

}
