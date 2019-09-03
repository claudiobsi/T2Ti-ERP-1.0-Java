package com.t2tierp.padrao.cliente;

import com.t2tierp.cadastros.cliente.AgenciaBancoGridController;
import com.t2tierp.cadastros.cliente.AlmoxarifadoGridController;
import com.t2tierp.cadastros.cliente.AtividadeForCliGridController;
import com.t2tierp.cadastros.cliente.BancoGridController;
import com.t2tierp.cadastros.cliente.CargoGridController;
import com.t2tierp.cadastros.cliente.CepGridController;
import com.t2tierp.cadastros.cliente.CfopGridController;
import com.t2tierp.cadastros.cliente.ChequeGridController;
import com.t2tierp.cadastros.cliente.ClienteGridController;
import com.t2tierp.cadastros.cliente.ColaboradorGridController;
import com.t2tierp.cadastros.cliente.ContaCaixaGridController;
import com.t2tierp.cadastros.cliente.ContadorGridController;
import com.t2tierp.cadastros.cliente.ConvenioGridController;
import com.t2tierp.cadastros.cliente.EmpresaCnaeGridController;
import com.t2tierp.cadastros.cliente.EmpresaGridController;
import com.t2tierp.cadastros.cliente.EstadoCivilGridController;
import com.t2tierp.cadastros.cliente.FeriadosGridController;
import com.t2tierp.cadastros.cliente.FornecedorGridController;
import com.t2tierp.cadastros.cliente.MunicipioGridController;
import com.t2tierp.cadastros.cliente.NcmGridController;
import com.t2tierp.cadastros.cliente.NivelFormacaoGridController;
import com.t2tierp.cadastros.cliente.OperadoraCartaoGridController;
import com.t2tierp.cadastros.cliente.OperadoraPlanoSaudeGridController;
import com.t2tierp.cadastros.cliente.PaisGridController;
import com.t2tierp.cadastros.cliente.PessoaGridController;
import com.t2tierp.cadastros.cliente.ProdutoGridController;
import com.t2tierp.cadastros.cliente.ProdutoGrupoGridController;
import com.t2tierp.cadastros.cliente.ProdutoMarcaGridController;
import com.t2tierp.cadastros.cliente.ProdutoSubGrupoGridController;
import com.t2tierp.cadastros.cliente.QuadroSocietarioGridController;
import com.t2tierp.cadastros.cliente.SetorGridController;
import com.t2tierp.cadastros.cliente.SindicatoGridController;
import com.t2tierp.cadastros.cliente.SituacaoColaboradorGridController;
import com.t2tierp.cadastros.cliente.SituacaoForCliGridController;
import com.t2tierp.cadastros.cliente.SocioGridController;
import com.t2tierp.cadastros.cliente.TalonarioChequeGridController;
import com.t2tierp.cadastros.cliente.TipoAdmissaoGridController;
import com.t2tierp.cadastros.cliente.TipoColaboradorGridController;
import com.t2tierp.cadastros.cliente.TipoDesligamentoGridController;
import com.t2tierp.cadastros.cliente.TipoRelacionamentoGridController;
import com.t2tierp.cadastros.cliente.TransportadoraGridController;
import com.t2tierp.cadastros.cliente.UfGridController;
import com.t2tierp.cadastros.cliente.UnidadeProdutoGridController;
import com.t2tierp.tributacao.cliente.TributConfiguraOfGtGridController;
import com.t2tierp.tributacao.cliente.TributGrupoTributarioGridController;
import com.t2tierp.tributacao.cliente.TributIcmsCustomCabGridController;
import com.t2tierp.tributacao.cliente.TributIssGridController;
import com.t2tierp.tributacao.cliente.TributOperacaoFiscalGridController;
import org.openswing.swing.mdi.client.*;

public class Fachada implements ClientFacade {

    public Fachada() {
    }

    //Produto
    public void getProdutoMarca() {
        new ProdutoMarcaGridController();
    }

    public void getNcm() {
        new NcmGridController();
    }

    public void getUnidadeProduto() {
        new UnidadeProdutoGridController();
    }

    public void getProdutoGrupo() {
        new ProdutoGrupoGridController();
    }

    public void getProdutoSubGrupo() {
        new ProdutoSubGrupoGridController();
    }

    public void getProduto() {
        new ProdutoGridController();
    }

    //Tributacao
    public void getTributOperacaoFiscal() {
        new TributOperacaoFiscalGridController();
    }

    public void getTributGrupoTributario() {
        new TributGrupoTributarioGridController();
    }

    public void getTributConfiguraOfGt() {
        new TributConfiguraOfGtGridController();
    }

    public void getTributIcmsCustomCab() {
        new TributIcmsCustomCabGridController();
    }

    public void getTributIss() {
        new TributIssGridController();
    }

    public void getQuadroSocietario() {
        new QuadroSocietarioGridController();
    }

    public void getSocio() {
        new SocioGridController();
    }

    public void getEmpresaCnae() {
        new EmpresaCnaeGridController();
    }

    public void getEmpresa() {
        new EmpresaGridController();
    }

    //PESSOA
    public void getEstadoCivil() {
        new EstadoCivilGridController();
    }

    public void getPessoa() {
        new PessoaGridController();
    }

    //CLIENTE - FORNECEDOR - TRANSPORTADORA
    public void getAtividadeForCli() {
        new AtividadeForCliGridController();
    }

    public void getSituacaoForCli() {
        new SituacaoForCliGridController();
    }

    public void getCliente() {
        new ClienteGridController();
    }

    public void getFornecedor() {
        new FornecedorGridController();
    }

    public void getTransportadora() {
        new TransportadoraGridController();
    }

    //COLABORADOR
    public void getTipoAdmissao() {
        new TipoAdmissaoGridController();
    }

    public void getTipoRelacionamento() {
        new TipoRelacionamentoGridController();
    }

    public void getSituacaoColaborador() {
        new SituacaoColaboradorGridController();
    }

    public void getTipoDesligamento() {
        new TipoDesligamentoGridController();
    }

    public void getTipoColaborador() {
        new TipoColaboradorGridController();
    }

    public void getCargo() {
        new CargoGridController();
    }

    public void getNivelFormacao() {
        new NivelFormacaoGridController();
    }

    public void getColaborador() {
        new ColaboradorGridController();
    }

    //Pessoal - Outros
    public void getContador() {
        new ContadorGridController();
    }

    public void getSindicato() {
        new SindicatoGridController();
    }

    public void getConvenio() {
        new ConvenioGridController();
    }

    //Diversos
    public void getSetor() {
        new SetorGridController();
    }

    public void getAlmoxarifado() {
        new AlmoxarifadoGridController();
    }

    public void getOperadoraPlanoSaude() {
        new OperadoraPlanoSaudeGridController();
    }

    public void getOperadoraCartao() {
        new OperadoraCartaoGridController();
    }

    //Endereco
    public void getPais() {
        new PaisGridController();
    }

    public void getUf() {
        new UfGridController();
    }

    public void getMunicipio() {
        new MunicipioGridController();
    }

    public void getCep() {
        new CepGridController();
    }

    //Financeiro
    public void getBanco() {
        new BancoGridController();
    }

    public void getAgenciaBanco() {
        new AgenciaBancoGridController();
    }

    public void getContaCaixa() {
        new ContaCaixaGridController();
    }

    public void getTalonarioCheque() {
        new TalonarioChequeGridController();
    }

    public void getCheque() {
        new ChequeGridController();
    }

    //Tabelas
    public void getCfop() {
        new CfopGridController();
    }

    public void getFeriados() {
        new FeriadosGridController();
    }

}
