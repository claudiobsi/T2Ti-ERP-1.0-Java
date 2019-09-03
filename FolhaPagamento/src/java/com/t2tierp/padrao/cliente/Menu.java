package com.t2tierp.padrao.cliente;

import com.t2tierp.cadastros.java.UsuarioVO;
import java.util.*;
import org.openswing.swing.mdi.client.*;
import org.openswing.swing.util.client.*;
import org.openswing.swing.permissions.client.*;
import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import org.openswing.swing.domains.java.Domain;
import org.openswing.swing.internationalization.java.*;
import org.openswing.swing.message.receive.java.*;
import org.openswing.swing.permissions.java.ButtonsAuthorizations;

public class Menu implements MDIController, LoginController {

    private Fachada fachadaCliente = null;
    private Hashtable domains = new Hashtable();
    private String nomeUsuario = null;

    public Menu() {
        ClientUtils.setObjectSender(new HessianObjectSender());
        fachadaCliente = new Fachada();
        LoginDialog d = new LoginDialog(null, false, this);
    }

    /**
     * @return client facade, invoked by the MDI Frame tree/menu
     */
    public ClientFacade getClientFacade() {
        return fachadaCliente;
    }

    /**
     * Method used to destroy application.
     */
    public void stopApplication() {
        ClientUtils.getData("closeApplication", Boolean.TRUE);
        System.exit(0);
    }

    /**
     * Defines if application functions must be viewed inside a tree panel of MDI Frame.
     * @return <code>true</code> if application functions must be viewed inside a tree panel of MDI Frame, <code>false</code> no tree is viewed
     */
    public boolean viewFunctionsInTreePanel() {
        return true;
    }

    /**
     * Defines if application functions must be viewed in the menubar of MDI Frame.
     * @return <code>true</code> if application functions must be viewed in the menubar of MDI Frame, <code>false</code> otherwise
     */
    public boolean viewFunctionsInMenuBar() {
        return true;
    }

    /**
     * @return <code>true</code> if the MDI frame must show a login menu in the menubar, <code>false</code> no login menu item will be added
     */
    public boolean viewLoginInMenuBar() {
        return true;
    }

    /**
     * @return application title
     */
    public String getMDIFrameTitle() {
        return "T2Ti ERP";
    }

    /**
     * @return text to view in the about dialog window
     */
    public String getAboutText() {
        return "Aplicação: T2Ti ERP\n"
                + "\n"
                + "The MIT License\n"
                + "Copyright: Copyright (C) 2011 T2Ti.COM\n"
                + "\n"
                + "Permission is hereby granted, free of charge, to any person\n"
                + "obtaining a copy of this software and associated documentation\n"
                + "files (the 'Software'), to deal in the Software without\n"
                + "restriction, including without limitation the rights to use,\n"
                + "copy, modify, merge, publish, distribute, sublicense, and/or sell\n"
                + "copies of the Software, and to permit persons to whom the\n"
                + "Software is furnished to do so, subject to the following\n"
                + "conditions:\n"
                + "\n"
                + "The above copyright notice and this permission notice shall be\n"
                + "included in all copies or substantial portions of the Software.\n"
                + "\n"
                + "THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND,\n"
                + "EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES\n"
                + "OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND\n"
                + "NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT\n"
                + "HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,\n"
                + "WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING\n"
                + "FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR\n"
                + "OTHER DEALINGS IN THE SOFTWARE.\n";
    }

    /**
     * @return image name to view in the about dialog window
     */
    public String getAboutImage() {
        return "about.jpg";
    }

    /**
     * @param parentFrame parent frame
     * @return a dialog window to logon the application; the method can return null if viewLoginInMenuBar returns false
     */
    public JDialog viewLoginDialog(JFrame parentFrame) {
        JDialog d = new LoginDialog(parentFrame, true, this);
        return d;
    }

    /**
     * @return maximum number of failed login
     */
    public int getMaxAttempts() {
        return 3;
    }

    /**
     * Method called by MDI Frame to authenticate the user.
     * @param loginInfo login information, like nomeUsuario, password, ...
     * @return <code>true</code> if user is correcly authenticated, <code>false</code> otherwise
     */
    public boolean authenticateUser(Map loginInfo) throws Exception {
        nomeUsuario = (String) loginInfo.get("username");
        String password = (String) loginInfo.get("password");

        if (nomeUsuario == null || password == null) {
            return false;
        }

        nomeUsuario = nomeUsuario.toUpperCase();
        password = password.toUpperCase();
        loginInfo.put("username", nomeUsuario);
        loginInfo.put("password", password);

        Response response = ClientUtils.getData("login", new String[]{nomeUsuario, password});

        if (response.isError()) {
            throw new Exception(response.getErrorMessage());
        }

        String languageId = ((TextResponse) response).getMessage();

        response = ClientUtils.getData("containerAction", new String[]{nomeUsuario, password});
        if (response.isError()) {
            throw new Exception(response.getErrorMessage());
        }

        UsuarioVO usuarioVO = (UsuarioVO) ((VOResponse) response).getVo();
        Container.setContainer(usuarioVO);

        response = ClientUtils.getData("getButtonAuthorizations", new Object[0]);
        if (response.isError()) {
            throw new Exception(response.getErrorMessage());
        }

        ButtonsAuthorizations buttonsAuthorizations = (ButtonsAuthorizations) ((VOResponse) response).getVo();

        Hashtable xmlFiles = new Hashtable();
        xmlFiles.put("EN", "Resources_en.xml");
        xmlFiles.put("IT", "Resources_it.xml");
        xmlFiles.put("ES", "Resources_es.xml");
        xmlFiles.put("PT_BR", "Resources_ptBR.xml");

        ClientSettings clientSettings = new ClientSettings(
                new XMLResourcesFactory(xmlFiles, true),
                domains,
                buttonsAuthorizations,
                false);

        ClientSettings.PERC_TREE_FOLDER = "folder3.gif";
        ClientSettings.BACKGROUND = "background4.jpg";
        ClientSettings.TREE_BACK = "treeback2.jpg";
        ClientSettings.FILTER_PANEL_ON_GRID = true;
        ClientSettings.LOOK_AND_FEEL_CLASS_NAME = "com.birosoft.liquid.LiquidLookAndFeel";
        com.birosoft.liquid.LiquidLookAndFeel.setLiquidDecorations(true);

        ClientSettings.getInstance().setLanguage(languageId);

        return true;
    }

    public static void main(String[] argv) {
        new Menu();
    }

    /**
     * Method called after MDI creation.
     */
    public void afterMDIcreation(MDIFrame frame) {
        GenericStatusPanel userPanel = new GenericStatusPanel();
        userPanel.setColumns(12);
        MDIFrame.addStatusComponent(userPanel);
        userPanel.setText(nomeUsuario);
        MDIFrame.addStatusComponent(new Clock());
    }

    /**
     * @see JFrame getExtendedState method
     */
    public int getExtendedState() {
        return JFrame.MAXIMIZED_BOTH;
    }

    /**
     * Method called by LoginDialog to notify the sucessful login.
     * @param loginInfo login information, like nomeUsuario, password, ...
     */
    public void loginSuccessful(Map loginInfo) {

        Domain tipoPessoa = new Domain("tipoPessoa");
        tipoPessoa.addDomainPair("F", "Física");
        tipoPessoa.addDomainPair("J", "Jurídica");

        Domain tipoSangue = new Domain("tipoSangue");
        tipoSangue.addDomainPair("A+", "A+");
        tipoSangue.addDomainPair("B+", "B+");
        tipoSangue.addDomainPair("O+", "O+");
        tipoSangue.addDomainPair("AB+", "AB+");
        tipoSangue.addDomainPair("A-", "A-");
        tipoSangue.addDomainPair("B-", "B-");
        tipoSangue.addDomainPair("AB-", "AB-");
        tipoSangue.addDomainPair("O-", "O-");

        Domain dominioSexo = new Domain("sexo");
        dominioSexo.addDomainPair("M", "Masculino");
        dominioSexo.addDomainPair("F", "Feminino");

        Domain dominioSimNao = new Domain("simnao");
        dominioSimNao.addDomainPair("S", "Sim");
        dominioSimNao.addDomainPair("N", "Não");

        Domain dominioMes = new Domain("mes");
        dominioMes.addDomainPair("01", "Janeiro");
        dominioMes.addDomainPair("02", "Fevereiro");
        dominioMes.addDomainPair("03", "Março");
        dominioMes.addDomainPair("04", "Abril");
        dominioMes.addDomainPair("05", "Maio");
        dominioMes.addDomainPair("06", "Junho");
        dominioMes.addDomainPair("07", "Julho");
        dominioMes.addDomainPair("08", "Agosto");
        dominioMes.addDomainPair("09", "Setembro");
        dominioMes.addDomainPair("10", "Outubro");
        dominioMes.addDomainPair("11", "Novembro");
        dominioMes.addDomainPair("12", "Dezembro");

        Domain dominioTipoCentroResultado = new Domain("tipoCentroResultado");
        dominioTipoCentroResultado.addDomainPair("A", "Analítico");
        dominioTipoCentroResultado.addDomainPair("S", "Sintético");

        //dominios NF-e
        Domain dominioStatusNota = new Domain("statusNotaFiscalEletronica");
        dominioStatusNota.addDomainPair("0", "0 - Em Edição");
        dominioStatusNota.addDomainPair("1", "1 - Salva");
        dominioStatusNota.addDomainPair("2", "2 - Validada");
        dominioStatusNota.addDomainPair("3", "3 - Assinada");
        dominioStatusNota.addDomainPair("4", "4 - Enviada");
        dominioStatusNota.addDomainPair("5", "5 - Autorizada");
        dominioStatusNota.addDomainPair("6", "6 - Cancelada");

        Domain dominioTipoOperacao = new Domain("tipoOperacao");
        dominioTipoOperacao.addDomainPair("0", "0 - Entrada");
        dominioTipoOperacao.addDomainPair("1", "1 - Saída");

        Domain dominioFormaPagamento = new Domain("formaPagamento");
        dominioFormaPagamento.addDomainPair("0", "0 - A Vista");
        dominioFormaPagamento.addDomainPair("1", "1 - A Prazo");
        dominioFormaPagamento.addDomainPair("2", "2 - Outros");

        Domain dominioFormaEmissao = new Domain("formaEmissao");
        dominioFormaEmissao.addDomainPair("1", "1 - Normal");
        dominioFormaEmissao.addDomainPair("2", "2 - Contigência");
        dominioFormaEmissao.addDomainPair("3", "3 - Contingência SCAN");
        dominioFormaEmissao.addDomainPair("4", "4 - Contingência DPEC");
        dominioFormaEmissao.addDomainPair("5", "5 - Contingência FS-DA");

        Domain dominioFinalidadeEmissao = new Domain("finalidadeEmissao");
        dominioFinalidadeEmissao.addDomainPair("1", "1 - Normal");
        dominioFinalidadeEmissao.addDomainPair("2", "2 - Complementar");
        dominioFinalidadeEmissao.addDomainPair("3", "3 - Ajuste");

        Domain dominioTipoImpressaoDanfe = new Domain("tipoImpressaoDanfe");
        dominioTipoImpressaoDanfe.addDomainPair("1", "1 - Retrato");
        dominioTipoImpressaoDanfe.addDomainPair("2", "2 - Paisagem");

        Domain dominioCRT = new Domain("crt");
        dominioCRT.addDomainPair(1, "1 - Simples Nacional");
        dominioCRT.addDomainPair(2, "2 - Simples Nac - Excesso");
        dominioCRT.addDomainPair(3, "3 - Regime Normal");

        Domain dominioModeloCupomFiscal = new Domain("modeloCupomFiscal");
        dominioModeloCupomFiscal.addDomainPair("2B", "2B - Emitido em Máquina Registradora (Não ECF)");
        dominioModeloCupomFiscal.addDomainPair("2C", "2C - Cupom Fiscal PDV");
        dominioModeloCupomFiscal.addDomainPair("2D", "2D - Cupom Fiscal Emitido por ECF");

        Domain dominioTipoReajuste = new Domain("tipoReajuste");
        dominioTipoReajuste.addDomainPair("A", "Aumentar");
        dominioTipoReajuste.addDomainPair("D", "Diminuir");

        Domain dominioMetodoDepreciacao = new Domain("metodoDepreciacao");
        dominioMetodoDepreciacao.addDomainPair("1", "Linear");
        dominioMetodoDepreciacao.addDomainPair("2", "Soma dos Algarismos dos Anos");
        dominioMetodoDepreciacao.addDomainPair("3", "Horas de Trabalho");
        dominioMetodoDepreciacao.addDomainPair("4", "Unidades Produzidas");

        Domain dominioTipoDepreciacao = new Domain("tipoDepreciacao");
        dominioTipoDepreciacao.addDomainPair("N", "Normal");
        dominioTipoDepreciacao.addDomainPair("A", "Acelerada");
        dominioTipoDepreciacao.addDomainPair("I", "Incentivada");

        Domain dominioTipoHorarioPonto = new Domain("tipoHorarioPonto");
        dominioTipoHorarioPonto.addDomainPair("F", "Fixo");
        dominioTipoHorarioPonto.addDomainPair("D", "Diário");
        dominioTipoHorarioPonto.addDomainPair("S", "Semanal");
        dominioTipoHorarioPonto.addDomainPair("M", "Mensal");

        Domain dominioTipoTrabalho = new Domain("tipoTrabalho");
        dominioTipoTrabalho.addDomainPair("N", "Normal");
        dominioTipoTrabalho.addDomainPair("C", "Compensação");
        dominioTipoTrabalho.addDomainPair("F", "Folga");

        Domain dominioNaoRegistroPonto = new Domain("tipoNaoRegistroPonto");
        dominioNaoRegistroPonto.addDomainPair("F", "Falta");
        dominioNaoRegistroPonto.addDomainPair("I", "Ignora");
        dominioNaoRegistroPonto.addDomainPair("A", "Aviso de Ocorrência");

        Domain dominioUtilizacaoRelogioPonto = new Domain("utilizacaoRelogioPonto");
        dominioUtilizacaoRelogioPonto.addDomainPair("P", "Ponto");
        dominioUtilizacaoRelogioPonto.addDomainPair("R", "Refeitório");
        dominioUtilizacaoRelogioPonto.addDomainPair("C", "Circulação");

        Domain dominioSituacaoBancoHoras = new Domain("situacaoBancoHoras");
        dominioSituacaoBancoHoras.addDomainPair("N", "Não Utilizado");
        dominioSituacaoBancoHoras.addDomainPair("U", "Utilizado");
        dominioSituacaoBancoHoras.addDomainPair("P", "Utilizado Parcialmente");

        Domain dominioTipoMarcacaoPonto = new Domain("tipoMarcacaoPonto");
        dominioTipoMarcacaoPonto.addDomainPair("E", "Entrada");
        dominioTipoMarcacaoPonto.addDomainPair("S", "Saída");
        dominioTipoMarcacaoPonto.addDomainPair("D", "Desconsiderar");

        Domain dominioTipoRegistroPonto = new Domain("tipoRegistroPonto");
        dominioTipoRegistroPonto.addDomainPair("O", "Original");
        dominioTipoRegistroPonto.addDomainPair("I", "Incluído por Digitação");
        dominioTipoRegistroPonto.addDomainPair("P", "Intervalo Pré-assinalado");

        Domain dominioProporcionalidadeFolha = new Domain("proporcionalidadeFolha");
        dominioProporcionalidadeFolha.addDomainPair("0", "30 dias");
        dominioProporcionalidadeFolha.addDomainPair("I", "Conforme dias do mês");

        Domain dominioTipoGps = new Domain("tipoGps");
        dominioTipoGps.addDomainPair("1", "Emite GPS de apenas uma filial (serviços que representam a própria empresa, um tomador de serviço ou obra por empreitada parcial)");
        dominioTipoGps.addDomainPair("2", "Emite GPS somente de um serviço (obra própria/empreitada total)");
        dominioTipoGps.addDomainPair("3", "Emite GPS apenas de uma filial referente aos cooperados (tomadores de serviço de cooperativa de trabalho)");

        Domain dominioBeneficiarioPlanoSaude = new Domain("beneficiarioPlanoSaude");
        dominioBeneficiarioPlanoSaude.addDomainPair("1", "Somente Colaborador");
        dominioBeneficiarioPlanoSaude.addDomainPair("2", "Colaborador e Dependentes");
        dominioBeneficiarioPlanoSaude.addDomainPair("3", "Somente Dependentes");

        Domain dominioBaseCalculoEventoFolha = new Domain("baseCalculoEventoFolha");
        dominioBaseCalculoEventoFolha.addDomainPair("01", "Salário contratual: define que a base de cálculo deve ser calculada sobre o valor do salário contratual");
        dominioBaseCalculoEventoFolha.addDomainPair("02", "Salário mínimo: define que a base de cálculo deve ser calculada sobre o valor do salário mínimo");
        dominioBaseCalculoEventoFolha.addDomainPair("03", "Salário mínimo: define que a base de cálculo deve ser calculada sobre o valor do salário mínimo");
        dominioBaseCalculoEventoFolha.addDomainPair("04", "Líquido: define que a base de cálculo deve ser calculada sobre o líquido da folha");

        Domain dominioTipoEventoFolha = new Domain("tipoEventoFolha");
        dominioTipoEventoFolha.addDomainPair("P", "Provento");
        dominioTipoEventoFolha.addDomainPair("D", "Desconto");

        Domain dominioUnidadeEventoFolha = new Domain("unidadeEventoFolha");
        dominioUnidadeEventoFolha.addDomainPair("V", "Valor");
        dominioUnidadeEventoFolha.addDomainPair("P", "Percentual");

        Domain dominioSituacaoFerias = new Domain("situacaoFerias");
        dominioSituacaoFerias.addDomainPair("0", "Em Aberto");
        dominioSituacaoFerias.addDomainPair("1", "Gozado");
        dominioSituacaoFerias.addDomainPair("2", "Parcialmente gozado");
        dominioSituacaoFerias.addDomainPair("3", "Perda por Afastamento");
        dominioSituacaoFerias.addDomainPair("4", "Perda por Falta");
        dominioSituacaoFerias.addDomainPair("5", "Cancelado");

        Domain dominioTipoLancamentoFolha = new Domain("tipoLancamentoFolha");
        dominioTipoLancamentoFolha.addDomainPair("1", "Folha Mensal");
        dominioTipoLancamentoFolha.addDomainPair("2", "Rescisão");

        Domain dominioTipoFatorRiscoPpp = new Domain("tipoFatorRiscoPpp");
        dominioTipoFatorRiscoPpp.addDomainPair("F", "Físico");
        dominioTipoFatorRiscoPpp.addDomainPair("Q", "Químico");
        dominioTipoFatorRiscoPpp.addDomainPair("E", "Ergonômico/Psicossocial");
        dominioTipoFatorRiscoPpp.addDomainPair("M", "Mecânico/de Acidente");

        Domain dominioTipoExameMedicoPpp = new Domain("tipoExameMedicoPpp");
        dominioTipoExameMedicoPpp.addDomainPair("A", "Admissional");
        dominioTipoExameMedicoPpp.addDomainPair("P", "Periódico");
        dominioTipoExameMedicoPpp.addDomainPair("R", "Retorno ao Trabalho");
        dominioTipoExameMedicoPpp.addDomainPair("D", "Demissional");

        Domain dominioExameMedicoPpp = new Domain("exameMedicoPpp");
        dominioExameMedicoPpp.addDomainPair("R", "Referencial");
        dominioExameMedicoPpp.addDomainPair("S", "Sequencial");

        domains.clear();
        domains.put(tipoPessoa.getDomainId(), tipoPessoa);
        domains.put(tipoSangue.getDomainId(), tipoSangue);
        domains.put(dominioSexo.getDomainId(), dominioSexo);
        domains.put(dominioSimNao.getDomainId(), dominioSimNao);
        domains.put(dominioMes.getDomainId(), dominioMes);
        domains.put(dominioTipoCentroResultado.getDomainId(), dominioTipoCentroResultado);
        domains.put(dominioStatusNota.getDomainId(), dominioStatusNota);
        domains.put(dominioTipoOperacao.getDomainId(), dominioTipoOperacao);
        domains.put(dominioFormaPagamento.getDomainId(), dominioFormaPagamento);
        domains.put(dominioFormaEmissao.getDomainId(), dominioFormaEmissao);
        domains.put(dominioFinalidadeEmissao.getDomainId(), dominioFinalidadeEmissao);
        domains.put(dominioTipoImpressaoDanfe.getDomainId(), dominioTipoImpressaoDanfe);
        domains.put(dominioCRT.getDomainId(), dominioCRT);
        domains.put(dominioModeloCupomFiscal.getDomainId(), dominioModeloCupomFiscal);
        domains.put(dominioTipoReajuste.getDomainId(), dominioTipoReajuste);
        domains.put(dominioMetodoDepreciacao.getDomainId(), dominioMetodoDepreciacao);
        domains.put(dominioTipoDepreciacao.getDomainId(), dominioTipoDepreciacao);
        domains.put(dominioTipoHorarioPonto.getDomainId(), dominioTipoHorarioPonto);
        domains.put(dominioTipoTrabalho.getDomainId(), dominioTipoTrabalho);
        domains.put(dominioNaoRegistroPonto.getDomainId(), dominioNaoRegistroPonto);
        domains.put(dominioUtilizacaoRelogioPonto.getDomainId(), dominioUtilizacaoRelogioPonto);
        domains.put(dominioSituacaoBancoHoras.getDomainId(), dominioSituacaoBancoHoras);
        domains.put(dominioTipoMarcacaoPonto.getDomainId(), dominioTipoMarcacaoPonto);
        domains.put(dominioTipoRegistroPonto.getDomainId(), dominioTipoRegistroPonto);
        domains.put(dominioProporcionalidadeFolha.getDomainId(), dominioProporcionalidadeFolha);
        domains.put(dominioTipoGps.getDomainId(), dominioTipoGps);
        domains.put(dominioBeneficiarioPlanoSaude.getDomainId(), dominioBeneficiarioPlanoSaude);
        domains.put(dominioBaseCalculoEventoFolha.getDomainId(), dominioBaseCalculoEventoFolha);
        domains.put(dominioTipoEventoFolha.getDomainId(), dominioTipoEventoFolha);
        domains.put(dominioUnidadeEventoFolha.getDomainId(), dominioUnidadeEventoFolha);
        domains.put(dominioSituacaoFerias.getDomainId(), dominioSituacaoFerias);
        domains.put(dominioTipoLancamentoFolha.getDomainId(), dominioTipoLancamentoFolha);
        domains.put(dominioTipoFatorRiscoPpp.getDomainId(), dominioTipoFatorRiscoPpp);
        domains.put(dominioTipoExameMedicoPpp.getDomainId(), dominioTipoExameMedicoPpp);
        domains.put(dominioExameMedicoPpp.getDomainId(), dominioExameMedicoPpp);

        MDIFrame mdi = new MDIFrame(this);

    }

    /**
     * @return <code>true</code> if the MDI frame must show a change language menu in the menubar, <code>false</code> no change language menu item will be added
     */
    public boolean viewChangeLanguageInMenuBar() {
        return true;
    }

    /**
     * @return list of languages supported by the application
     */
    public ArrayList getLanguages() {
        ArrayList list = new ArrayList();
        list.add(new Language("EN", "English"));
        list.add(new Language("IT", "Italiano"));
        list.add(new Language("ES", "Espanhol"));
        list.add(new Language("PT_BR", "Português do Brasil"));
        return list;
    }

    /**
     * @return application functions (ApplicationFunction objects), organized as a tree
     */
    public DefaultTreeModel getApplicationFunctions() {
        return (DefaultTreeModel) ((VOResponse) ClientUtils.getData("getFunctionAuthorizations", new Object[0])).getVo();
    }

    /**
     * @return <code>true</code> if the MDI frame must show a panel in the bottom, containing last opened window icons, <code>false</code> no panel is showed
     */
    public boolean viewOpenedWindowIcons() {
        return true;
    }

    public boolean viewFileMenu() {
        return true;
    }
}
