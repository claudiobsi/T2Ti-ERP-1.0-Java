package com.t2tierp.cadastros.cliente;

import com.t2tierp.padrao.cliente.LookupDataLocatorGenerico;
import java.awt.Dimension;
import javax.swing.text.MaskFormatter;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.mdi.client.InternalFrame;

/**
* <p>Title: T2Ti ERP</p>
* <p>Description: Tela EmpresaDetalhe.</p>
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
public class EmpresaDetalhe extends InternalFrame {

    private LookupController matrizController = new LookupController();
    private LookupController contadorController = new LookupController();
    private LookupController sindicatoController = new LookupController();
    private LookupController fpasController = new LookupController();
    private LookupController municipioEnderecoController = new LookupController();
    private EmpresaContatoGridController contatoController;
    private EmpresaEnderecoGridController enderecoController;

    public EmpresaDetalhe(EmpresaDetalheController controller) {
        initComponents();

        form1.setFormController(controller);

        contatoController = new EmpresaContatoGridController(this);
        gridControlContato.setController(contatoController);
        gridControlContato.setGridDataLocator(contatoController);

        enderecoController = new EmpresaEnderecoGridController(this);
        gridControlEndereco.setController(enderecoController);
        gridControlEndereco.setGridDataLocator(enderecoController);

        formattedTextControl1.setEnabled(false);
        try {
            MaskFormatter mask = new MaskFormatter("##.###.###/####-##");
            mask.setValidCharacters("0123456789");
            mask.setValueContainsLiteralCharacters(false);
            formattedTextControl1.setFormatter(mask);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        /*
         * Configurações do lookup da matriz
         */
        matrizController.setLookupValueObjectClassName("com.t2tierp.cadastros.java.EmpresaVO");
        matrizController.addLookup2ParentLink("id", "empresa.id");
        matrizController.addLookup2ParentLink("razaoSocial", "empresa.razaoSocial");
        matrizController.addLookup2ParentLink("cnpj", "empresa.cnpj");
        matrizController.setHeaderColumnName("id", "ID");
        matrizController.setHeaderColumnName("razaoSocial", "Razão Social");
        matrizController.setHeaderColumnName("cnpj", "CNPJ");
        matrizController.setFrameTitle("Importa Empresa");

        matrizController.setVisibleStatusPanel(true);
        matrizController.setVisibleColumn("id", true);
        matrizController.setVisibleColumn("razaoSocial", true);
        matrizController.setVisibleColumn("cnpj", true);
        matrizController.setFramePreferedSize(new Dimension(600, 500));

        matrizController.setLookupDataLocator(new LookupDataLocatorGenerico(matrizController.getLookupValueObjectClassName()));
        codLookupControl3.setLookupController(matrizController);

        /*
         * Configurações do lookup do contador
         */
        contadorController.setLookupValueObjectClassName("com.t2tierp.cadastros.java.ContadorVO");
        contadorController.addLookup2ParentLink("id", "contador.id");
        contadorController.addLookup2ParentLink("pessoa.nome", "contador.pessoa.nome");
        contadorController.setHeaderColumnName("id", "ID");
        contadorController.setHeaderColumnName("pessoa.nome", "Nome");
        contadorController.setFrameTitle("Importa Contador");

        contadorController.setVisibleStatusPanel(true);
        contadorController.setVisibleColumn("id", true);
        contadorController.setVisibleColumn("pessoa.nome", true);
        contadorController.setFramePreferedSize(new Dimension(600, 500));

        contadorController.setLookupDataLocator(new LookupDataLocatorGenerico(contadorController.getLookupValueObjectClassName()));
        codLookupControl5.setLookupController(contadorController);

        /*
         * Configurações do lookup do sindicato
         */
        sindicatoController.setLookupValueObjectClassName("com.t2tierp.cadastros.java.SindicatoVO");
        sindicatoController.addLookup2ParentLink("id", "sindicato.id");
        sindicatoController.addLookup2ParentLink("nome", "sindicato.nome");
        sindicatoController.setHeaderColumnName("id", "ID");
        sindicatoController.setHeaderColumnName("nome", "Nome");
        sindicatoController.setFrameTitle("Importa Sindicato");

        sindicatoController.setVisibleStatusPanel(true);
        sindicatoController.setVisibleColumn("id", true);
        sindicatoController.setVisibleColumn("nome", true);
        sindicatoController.setFramePreferedSize(new Dimension(600, 500));

        sindicatoController.setLookupDataLocator(new LookupDataLocatorGenerico(sindicatoController.getLookupValueObjectClassName()));
        codLookupControl6.setLookupController(sindicatoController);

        /*
         * Configurações do lookup do fpas
         */
        fpasController.setLookupValueObjectClassName("com.t2tierp.cadastros.java.FpasVO");
        fpasController.addLookup2ParentLink("id", "fpas.id");
        fpasController.addLookup2ParentLink("descricao", "fpas.descricao");
        fpasController.setHeaderColumnName("id", "ID");
        fpasController.setHeaderColumnName("descricao", "Descrição");
        fpasController.setFrameTitle("Importa FPAS");

        fpasController.setVisibleStatusPanel(true);
        fpasController.setVisibleColumn("id", true);
        fpasController.setVisibleColumn("descricao", true);
        fpasController.setFramePreferedSize(new Dimension(600, 500));

        fpasController.setLookupDataLocator(new LookupDataLocatorGenerico(fpasController.getLookupValueObjectClassName()));
        codLookupControl4.setLookupController(fpasController);

        /*
         * Configurações do lookup do municipio
         */
        municipioEnderecoController.setLookupValueObjectClassName("com.t2tierp.cadastros.java.MunicipioVO");
        municipioEnderecoController.addLookup2ParentLink("id", "municipio.id");
        municipioEnderecoController.addLookup2ParentLink("codigoIbge", "municipioIbge");
        municipioEnderecoController.addLookup2ParentLink("uf.sigla", "uf");
        municipioEnderecoController.setHeaderColumnName("id", "ID");
        municipioEnderecoController.setHeaderColumnName("codigoIbge", "Código Ibge");
        municipioEnderecoController.setHeaderColumnName("uf.sigla", "Sigla");
        municipioEnderecoController.setFrameTitle("Importa Municipio IBGE");

        municipioEnderecoController.setVisibleStatusPanel(true);
        municipioEnderecoController.setVisibleColumn("id", true);
        municipioEnderecoController.setVisibleColumn("codigoIbge", true);
        municipioEnderecoController.setVisibleColumn("uf.sigla", true);
        municipioEnderecoController.setFramePreferedSize(new Dimension(600, 500));

        municipioEnderecoController.setLookupDataLocator(new LookupDataLocatorGenerico(municipioEnderecoController.getLookupValueObjectClassName()));
        codLookupColumn1.setLookupController(municipioEnderecoController);


    }

    /**
     * @return the form1
     */
    public org.openswing.swing.form.client.Form getForm1() {
        return form1;
    }

    public EmpresaContatoGridController getContatoController() {
        return contatoController;
    }

    public EmpresaEnderecoGridController getEnderecoController() {
        return enderecoController;
    }

    public org.openswing.swing.client.GridControl getGridControlContato() {
        return gridControlContato;
    }

    public org.openswing.swing.client.GridControl getGridControlEndereco() {
        return gridControlEndereco;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        editButton1 = new org.openswing.swing.client.EditButton();
        reloadButton1 = new org.openswing.swing.client.ReloadButton();
        saveButton1 = new org.openswing.swing.client.SaveButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        form1 = new org.openswing.swing.form.client.Form();
        labelControl1 = new org.openswing.swing.client.LabelControl();
        codLookupControl3 = new org.openswing.swing.client.CodLookupControl();
        textControl3 = new org.openswing.swing.client.TextControl();
        labelControl3 = new org.openswing.swing.client.LabelControl();
        codLookupControl4 = new org.openswing.swing.client.CodLookupControl();
        textControl4 = new org.openswing.swing.client.TextControl();
        labelControl5 = new org.openswing.swing.client.LabelControl();
        codLookupControl5 = new org.openswing.swing.client.CodLookupControl();
        textControl5 = new org.openswing.swing.client.TextControl();
        labelControl7 = new org.openswing.swing.client.LabelControl();
        textControl6 = new org.openswing.swing.client.TextControl();
        labelControl8 = new org.openswing.swing.client.LabelControl();
        textControl7 = new org.openswing.swing.client.TextControl();
        labelControl9 = new org.openswing.swing.client.LabelControl();
        labelControl10 = new org.openswing.swing.client.LabelControl();
        textControl9 = new org.openswing.swing.client.TextControl();
        labelControl11 = new org.openswing.swing.client.LabelControl();
        textControl10 = new org.openswing.swing.client.TextControl();
        labelControl12 = new org.openswing.swing.client.LabelControl();
        textControl11 = new org.openswing.swing.client.TextControl();
        labelControl13 = new org.openswing.swing.client.LabelControl();
        textControl12 = new org.openswing.swing.client.TextControl();
        labelControl14 = new org.openswing.swing.client.LabelControl();
        dateControl13 = new org.openswing.swing.client.DateControl();
        labelControl15 = new org.openswing.swing.client.LabelControl();
        comboBoxControl14 = new org.openswing.swing.client.ComboBoxControl();
        labelControl17 = new org.openswing.swing.client.LabelControl();
        dateControl16 = new org.openswing.swing.client.DateControl();
        labelControl18 = new org.openswing.swing.client.LabelControl();
        textControl17 = new org.openswing.swing.client.TextControl();
        labelControl19 = new org.openswing.swing.client.LabelControl();
        textControl18 = new org.openswing.swing.client.TextControl();
        labelControl20 = new org.openswing.swing.client.LabelControl();
        labelControl21 = new org.openswing.swing.client.LabelControl();
        comboBoxControl20 = new org.openswing.swing.client.ComboBoxControl();
        labelControl22 = new org.openswing.swing.client.LabelControl();
        comboBoxControl21 = new org.openswing.swing.client.ComboBoxControl();
        labelControl23 = new org.openswing.swing.client.LabelControl();
        numericControl22 = new org.openswing.swing.client.NumericControl();
        labelControl24 = new org.openswing.swing.client.LabelControl();
        textControl23 = new org.openswing.swing.client.TextControl();
        labelControl25 = new org.openswing.swing.client.LabelControl();
        numericControl24 = new org.openswing.swing.client.NumericControl();
        labelControl26 = new org.openswing.swing.client.LabelControl();
        numericControl25 = new org.openswing.swing.client.NumericControl();
        labelControl27 = new org.openswing.swing.client.LabelControl();
        numericControl26 = new org.openswing.swing.client.NumericControl();
        labelControl28 = new org.openswing.swing.client.LabelControl();
        numericControl27 = new org.openswing.swing.client.NumericControl();
        labelControl29 = new org.openswing.swing.client.LabelControl();
        numericControl28 = new org.openswing.swing.client.NumericControl();
        labelControl30 = new org.openswing.swing.client.LabelControl();
        numericControl29 = new org.openswing.swing.client.NumericControl();
        labelControl31 = new org.openswing.swing.client.LabelControl();
        textControl30 = new org.openswing.swing.client.TextControl();
        labelControl32 = new org.openswing.swing.client.LabelControl();
        textControl31 = new org.openswing.swing.client.TextControl();
        labelControl33 = new org.openswing.swing.client.LabelControl();
        codLookupControl6 = new org.openswing.swing.client.CodLookupControl();
        textControl13 = new org.openswing.swing.client.TextControl();
        imageControl1 = new org.openswing.swing.client.ImageControl();
        formattedTextControl1 = new org.openswing.swing.client.FormattedTextControl();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        insertButton1 = new org.openswing.swing.client.InsertButton();
        editButton2 = new org.openswing.swing.client.EditButton();
        deleteButton1 = new org.openswing.swing.client.DeleteButton();
        saveButton2 = new org.openswing.swing.client.SaveButton();
        reloadButton2 = new org.openswing.swing.client.ReloadButton();
        navigatorBar1 = new org.openswing.swing.client.NavigatorBar();
        gridControlContato = new org.openswing.swing.client.GridControl();
        textColumn4 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn5 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn6 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn7 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn8 = new org.openswing.swing.table.columns.client.TextColumn();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        insertButton2 = new org.openswing.swing.client.InsertButton();
        editButton3 = new org.openswing.swing.client.EditButton();
        deleteButton2 = new org.openswing.swing.client.DeleteButton();
        saveButton3 = new org.openswing.swing.client.SaveButton();
        reloadButton3 = new org.openswing.swing.client.ReloadButton();
        navigatorBar2 = new org.openswing.swing.client.NavigatorBar();
        gridControlEndereco = new org.openswing.swing.client.GridControl();
        textColumn9 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn10 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn11 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn12 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn13 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn14 = new org.openswing.swing.table.columns.client.TextColumn();
        codLookupColumn1 = new org.openswing.swing.table.columns.client.CodLookupColumn();
        textColumn15 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn16 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn17 = new org.openswing.swing.table.columns.client.TextColumn();
        comboColumn14 = new org.openswing.swing.table.columns.client.ComboColumn();
        comboColumn15 = new org.openswing.swing.table.columns.client.ComboColumn();
        comboColumn16 = new org.openswing.swing.table.columns.client.ComboColumn();
        comboColumn17 = new org.openswing.swing.table.columns.client.ComboColumn();

        setTitle("T2Ti ERP - Cadastros");
        setPreferredSize(new java.awt.Dimension(700, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Empresa"));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel1.add(editButton1);
        jPanel1.add(reloadButton1);
        jPanel1.add(saveButton1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        form1.setVOClassName("com.t2tierp.cadastros.java.EmpresaVO");
        form1.setEditButton(editButton1);
        form1.setFunctionId("empresa");
        form1.setReloadButton(reloadButton1);
        form1.setSaveButton(saveButton1);
        form1.setLayout(new java.awt.GridBagLayout());

        labelControl1.setLabel("Matriz:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl1, gridBagConstraints);

        codLookupControl3.setAllowOnlyNumbers(true);
        codLookupControl3.setAttributeName("empresa.id");
        codLookupControl3.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -100;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(codLookupControl3, gridBagConstraints);

        textControl3.setAttributeName("empresa.razaoSocial");
        textControl3.setEnabled(false);
        textControl3.setEnabledOnEdit(false);
        textControl3.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl3, gridBagConstraints);

        labelControl3.setLabel("FPas:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl3, gridBagConstraints);

        codLookupControl4.setAllowOnlyNumbers(true);
        codLookupControl4.setAttributeName("fpas.id");
        codLookupControl4.setEnabled(false);
        codLookupControl4.setMaxCharacters(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -100;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(codLookupControl4, gridBagConstraints);

        textControl4.setAttributeName("fpas.descricao");
        textControl4.setEnabled(false);
        textControl4.setEnabledOnEdit(false);
        textControl4.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl4, gridBagConstraints);

        labelControl5.setLabel("Contador:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl5, gridBagConstraints);

        codLookupControl5.setAllowOnlyNumbers(true);
        codLookupControl5.setAttributeName("contador.id");
        codLookupControl5.setEnabled(false);
        codLookupControl5.setMaxCharacters(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -100;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(codLookupControl5, gridBagConstraints);

        textControl5.setAttributeName("contador.pessoa.nome");
        textControl5.setEnabled(false);
        textControl5.setEnabledOnEdit(false);
        textControl5.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl5, gridBagConstraints);

        labelControl7.setLabel("Razao Social:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl7, gridBagConstraints);

        textControl6.setAttributeName("razaoSocial");
        textControl6.setEnabled(false);
        textControl6.setLinkLabel(labelControl7);
        textControl6.setMaxCharacters(150);
        textControl6.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl6, gridBagConstraints);

        labelControl8.setLabel("Nome Fantasia:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl8, gridBagConstraints);

        textControl7.setAttributeName("nomeFantasia");
        textControl7.setEnabled(false);
        textControl7.setLinkLabel(labelControl8);
        textControl7.setMaxCharacters(150);
        textControl7.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl7, gridBagConstraints);

        labelControl9.setLabel("Cnpj:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl9, gridBagConstraints);

        labelControl10.setLabel("Inscricao Estadual:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl10, gridBagConstraints);

        textControl9.setAttributeName("inscricaoEstadual");
        textControl9.setEnabled(false);
        textControl9.setMaxCharacters(30);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl9, gridBagConstraints);

        labelControl11.setLabel("Inscricao Estadual St:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl11, gridBagConstraints);

        textControl10.setAttributeName("inscricaoEstadualSt");
        textControl10.setEnabled(false);
        textControl10.setMaxCharacters(30);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl10, gridBagConstraints);

        labelControl12.setLabel("Inscricao Municipal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl12, gridBagConstraints);

        textControl11.setAttributeName("inscricaoMunicipal");
        textControl11.setEnabled(false);
        textControl11.setMaxCharacters(30);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl11, gridBagConstraints);

        labelControl13.setLabel("Inscricao Junta Comercial:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl13, gridBagConstraints);

        textControl12.setAttributeName("inscricaoJuntaComercial");
        textControl12.setEnabled(false);
        textControl12.setMaxCharacters(30);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl12, gridBagConstraints);

        labelControl14.setLabel("Data Insc Junta Comercial:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl14, gridBagConstraints);

        dateControl13.setAttributeName("dataInscJuntaComercial");
        dateControl13.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(dateControl13, gridBagConstraints);

        labelControl15.setLabel("Tipo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl15, gridBagConstraints);

        comboBoxControl14.setAttributeName("tipo");
        comboBoxControl14.setDomainId("empresaTipo");
        comboBoxControl14.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(comboBoxControl14, gridBagConstraints);

        labelControl17.setLabel("Inicio Atividades:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl17, gridBagConstraints);

        dateControl16.setAttributeName("dataInicioAtividades");
        dateControl16.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(dateControl16, gridBagConstraints);

        labelControl18.setLabel("Suframa:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl18, gridBagConstraints);

        textControl17.setAttributeName("suframa");
        textControl17.setEnabled(false);
        textControl17.setMaxCharacters(9);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl17, gridBagConstraints);

        labelControl19.setLabel("Email:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl19, gridBagConstraints);

        textControl18.setAttributeName("email");
        textControl18.setEnabled(false);
        textControl18.setMaxCharacters(250);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl18, gridBagConstraints);

        labelControl20.setLabel("Imagem Logotipo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl20, gridBagConstraints);

        labelControl21.setLabel("Crt:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl21, gridBagConstraints);

        comboBoxControl20.setAttributeName("crt");
        comboBoxControl20.setDomainId("crt");
        comboBoxControl20.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(comboBoxControl20, gridBagConstraints);

        labelControl22.setLabel("Tipo Regime:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl22, gridBagConstraints);

        comboBoxControl21.setAttributeName("tipoRegime");
        comboBoxControl21.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(comboBoxControl21, gridBagConstraints);

        labelControl23.setLabel("Aliquota Pis:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl23, gridBagConstraints);

        numericControl22.setAttributeName("aliquotaPis");
        numericControl22.setDecimals(2);
        numericControl22.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl22, gridBagConstraints);

        labelControl24.setLabel("Contato:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl24, gridBagConstraints);

        textControl23.setAttributeName("contato");
        textControl23.setEnabled(false);
        textControl23.setMaxCharacters(50);
        textControl23.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl23, gridBagConstraints);

        labelControl25.setLabel("Aliquota Cofins:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl25, gridBagConstraints);

        numericControl24.setAttributeName("aliquotaCofins");
        numericControl24.setDecimals(2);
        numericControl24.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl24, gridBagConstraints);

        labelControl26.setLabel("Codigo Ibge Cidade:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl26, gridBagConstraints);

        numericControl25.setAttributeName("codigoIbgeCidade");
        numericControl25.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl25, gridBagConstraints);

        labelControl27.setLabel("Codigo Ibge Uf:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl27, gridBagConstraints);

        numericControl26.setAttributeName("codigoIbgeUf");
        numericControl26.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl26, gridBagConstraints);

        labelControl28.setLabel("Codigo Terceiros:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl28, gridBagConstraints);

        numericControl27.setAttributeName("codigoTerceiros");
        numericControl27.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl27, gridBagConstraints);

        labelControl29.setLabel("Codigo Gps:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl29, gridBagConstraints);

        numericControl28.setAttributeName("codigoGps");
        numericControl28.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl28, gridBagConstraints);

        labelControl30.setLabel("Aliquota Sat:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl30, gridBagConstraints);

        numericControl29.setAttributeName("aliquotaSat");
        numericControl29.setDecimals(2);
        numericControl29.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl29, gridBagConstraints);

        labelControl31.setLabel("Cei:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl31, gridBagConstraints);

        textControl30.setAttributeName("cei");
        textControl30.setEnabled(false);
        textControl30.setMaxCharacters(12);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl30, gridBagConstraints);

        labelControl32.setLabel("Codigo Cnae Principal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl32, gridBagConstraints);

        textControl31.setAttributeName("codigoCnaePrincipal");
        textControl31.setEnabled(false);
        textControl31.setMaxCharacters(7);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl31, gridBagConstraints);

        labelControl33.setLabel("Sindicato:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl33, gridBagConstraints);

        codLookupControl6.setAllowOnlyNumbers(true);
        codLookupControl6.setAttributeName("sindicato.id");
        codLookupControl6.setEnabled(false);
        codLookupControl6.setMaxCharacters(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -100;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(codLookupControl6, gridBagConstraints);

        textControl13.setAttributeName("sindicato.nome");
        textControl13.setEnabled(false);
        textControl13.setEnabledOnEdit(false);
        textControl13.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl13, gridBagConstraints);

        imageControl1.setAttributeName("imagem");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(imageControl1, gridBagConstraints);

        formattedTextControl1.setAttributeName("cnpj");
        formattedTextControl1.setLinkLabel(labelControl9);
        formattedTextControl1.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(formattedTextControl1, gridBagConstraints);

        jTabbedPane1.addTab("Dados Gerais", form1);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Contato"));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel4.add(insertButton1);
        jPanel4.add(editButton2);
        jPanel4.add(deleteButton1);
        jPanel4.add(saveButton2);
        jPanel4.add(reloadButton2);
        jPanel4.add(navigatorBar1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(jPanel4, gridBagConstraints);

        gridControlContato.setAutoLoadData(false);
        gridControlContato.setDeleteButton(deleteButton1);
        gridControlContato.setEditButton(editButton2);
        gridControlContato.setFunctionId("contato");
        gridControlContato.setInsertButton(insertButton1);
        gridControlContato.setNavBar(navigatorBar1);
        gridControlContato.setReloadButton(reloadButton2);
        gridControlContato.setSaveButton(saveButton2);
        gridControlContato.setValueObjectClassName("com.t2tierp.cadastros.java.ContatoVO");
        gridControlContato.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        textColumn4.setColumnName("nome");
        textColumn4.setEditableOnEdit(true);
        textColumn4.setEditableOnInsert(true);
        textColumn4.setHeaderColumnName("Nome");
        textColumn4.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        textColumn4.setMaxCharacters(100);
        textColumn4.setPreferredWidth(200);
        gridControlContato.getColumnContainer().add(textColumn4);

        textColumn5.setColumnName("email");
        textColumn5.setColumnRequired(false);
        textColumn5.setEditableOnEdit(true);
        textColumn5.setEditableOnInsert(true);
        textColumn5.setHeaderColumnName("Email");
        textColumn5.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        textColumn5.setMaxCharacters(250);
        textColumn5.setPreferredWidth(300);
        gridControlContato.getColumnContainer().add(textColumn5);

        textColumn6.setColumnName("foneComercial");
        textColumn6.setColumnRequired(false);
        textColumn6.setEditableOnEdit(true);
        textColumn6.setEditableOnInsert(true);
        textColumn6.setHeaderColumnName("Fone Comercial");
        textColumn6.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        textColumn6.setMaxCharacters(14);
        textColumn6.setPreferredWidth(120);
        gridControlContato.getColumnContainer().add(textColumn6);

        textColumn7.setColumnName("foneResidencial");
        textColumn7.setColumnRequired(false);
        textColumn7.setEditableOnEdit(true);
        textColumn7.setEditableOnInsert(true);
        textColumn7.setHeaderColumnName("Fone Residencial");
        textColumn7.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        textColumn7.setMaxCharacters(14);
        textColumn7.setPreferredWidth(120);
        gridControlContato.getColumnContainer().add(textColumn7);

        textColumn8.setColumnName("foneCelular");
        textColumn8.setColumnRequired(false);
        textColumn8.setEditableOnEdit(true);
        textColumn8.setEditableOnInsert(true);
        textColumn8.setHeaderColumnName("Fone Celular");
        textColumn8.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        textColumn8.setMaxCharacters(14);
        textColumn8.setPreferredWidth(120);
        gridControlContato.getColumnContainer().add(textColumn8);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(gridControlContato, gridBagConstraints);

        jTabbedPane1.addTab("Contatos", jPanel2);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereco"));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel5.add(insertButton2);
        jPanel5.add(editButton3);
        jPanel5.add(deleteButton2);
        jPanel5.add(saveButton3);
        jPanel5.add(reloadButton3);
        jPanel5.add(navigatorBar2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(jPanel5, gridBagConstraints);

        gridControlEndereco.setAutoLoadData(false);
        gridControlEndereco.setDeleteButton(deleteButton2);
        gridControlEndereco.setEditButton(editButton3);
        gridControlEndereco.setFunctionId("endereco");
        gridControlEndereco.setInsertButton(insertButton2);
        gridControlEndereco.setNavBar(navigatorBar2);
        gridControlEndereco.setReloadButton(reloadButton3);
        gridControlEndereco.setSaveButton(saveButton3);
        gridControlEndereco.setValueObjectClassName("com.t2tierp.cadastros.java.EnderecoVO");
        gridControlEndereco.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        textColumn9.setColumnName("logradouro");
        textColumn9.setEditableOnEdit(true);
        textColumn9.setEditableOnInsert(true);
        textColumn9.setHeaderColumnName("Logradouro");
        textColumn9.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        textColumn9.setMaxCharacters(60);
        gridControlEndereco.getColumnContainer().add(textColumn9);

        textColumn10.setColumnName("numero");
        textColumn10.setEditableOnEdit(true);
        textColumn10.setEditableOnInsert(true);
        textColumn10.setHeaderColumnName("Numero");
        textColumn10.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        textColumn10.setMaxCharacters(10);
        gridControlEndereco.getColumnContainer().add(textColumn10);

        textColumn11.setColumnName("complemento");
        textColumn11.setColumnRequired(false);
        textColumn11.setEditableOnEdit(true);
        textColumn11.setEditableOnInsert(true);
        textColumn11.setHeaderColumnName("Complemento");
        textColumn11.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        textColumn11.setMaxCharacters(60);
        gridControlEndereco.getColumnContainer().add(textColumn11);

        textColumn12.setColumnName("bairro");
        textColumn12.setEditableOnEdit(true);
        textColumn12.setEditableOnInsert(true);
        textColumn12.setHeaderColumnName("Bairro");
        textColumn12.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        textColumn12.setMaxCharacters(60);
        gridControlEndereco.getColumnContainer().add(textColumn12);

        textColumn13.setColumnName("cidade");
        textColumn13.setEditableOnEdit(true);
        textColumn13.setEditableOnInsert(true);
        textColumn13.setHeaderColumnName("Cidade");
        textColumn13.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        textColumn13.setMaxCharacters(60);
        gridControlEndereco.getColumnContainer().add(textColumn13);

        textColumn14.setColumnName("cep");
        textColumn14.setEditableOnEdit(true);
        textColumn14.setEditableOnInsert(true);
        textColumn14.setHeaderColumnName("Cep");
        textColumn14.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        textColumn14.setMaxCharacters(8);
        gridControlEndereco.getColumnContainer().add(textColumn14);

        codLookupColumn1.setAllowOnlyNumbers(true);
        codLookupColumn1.setColumnName("municipioIbge");
        codLookupColumn1.setEditableOnEdit(true);
        codLookupColumn1.setEditableOnInsert(true);
        codLookupColumn1.setHeaderColumnName("Municipio Ibge");
        codLookupColumn1.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControlEndereco.getColumnContainer().add(codLookupColumn1);

        textColumn15.setColumnName("uf");
        textColumn15.setHeaderColumnName("Uf");
        textColumn15.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn15.setMaxCharacters(2);
        gridControlEndereco.getColumnContainer().add(textColumn15);

        textColumn16.setColumnName("fone");
        textColumn16.setColumnRequired(false);
        textColumn16.setEditableOnEdit(true);
        textColumn16.setEditableOnInsert(true);
        textColumn16.setHeaderColumnName("Fone");
        textColumn16.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        textColumn16.setMaxCharacters(14);
        gridControlEndereco.getColumnContainer().add(textColumn16);

        textColumn17.setColumnName("fax");
        textColumn17.setColumnRequired(false);
        textColumn17.setEditableOnEdit(true);
        textColumn17.setEditableOnInsert(true);
        textColumn17.setHeaderColumnName("Fax");
        textColumn17.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        textColumn17.setMaxCharacters(14);
        gridControlEndereco.getColumnContainer().add(textColumn17);

        comboColumn14.setColumnName("principal");
        comboColumn14.setDomainId("naosim");
        comboColumn14.setEditableOnEdit(true);
        comboColumn14.setEditableOnInsert(true);
        comboColumn14.setHeaderColumnName("Principal");
        comboColumn14.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        gridControlEndereco.getColumnContainer().add(comboColumn14);

        comboColumn15.setColumnName("entrega");
        comboColumn15.setDomainId("naosim");
        comboColumn15.setEditableOnEdit(true);
        comboColumn15.setEditableOnInsert(true);
        comboColumn15.setHeaderColumnName("Entrega");
        comboColumn15.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        gridControlEndereco.getColumnContainer().add(comboColumn15);

        comboColumn16.setColumnName("cobranca");
        comboColumn16.setDomainId("naosim");
        comboColumn16.setEditableOnEdit(true);
        comboColumn16.setEditableOnInsert(true);
        comboColumn16.setHeaderColumnName("Cobranca");
        comboColumn16.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        gridControlEndereco.getColumnContainer().add(comboColumn16);

        comboColumn17.setColumnName("correspondencia");
        comboColumn17.setDomainId("naosim");
        comboColumn17.setEditableOnEdit(true);
        comboColumn17.setEditableOnInsert(true);
        comboColumn17.setHeaderColumnName("Correspondencia");
        comboColumn17.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        gridControlEndereco.getColumnContainer().add(comboColumn17);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel3.add(gridControlEndereco, gridBagConstraints);

        jTabbedPane1.addTab("Endereços", jPanel3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jTabbedPane1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupColumn1;
    private org.openswing.swing.client.CodLookupControl codLookupControl3;
    private org.openswing.swing.client.CodLookupControl codLookupControl4;
    private org.openswing.swing.client.CodLookupControl codLookupControl5;
    private org.openswing.swing.client.CodLookupControl codLookupControl6;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl14;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl20;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl21;
    private org.openswing.swing.table.columns.client.ComboColumn comboColumn14;
    private org.openswing.swing.table.columns.client.ComboColumn comboColumn15;
    private org.openswing.swing.table.columns.client.ComboColumn comboColumn16;
    private org.openswing.swing.table.columns.client.ComboColumn comboColumn17;
    private org.openswing.swing.client.DateControl dateControl13;
    private org.openswing.swing.client.DateControl dateControl16;
    private org.openswing.swing.client.DeleteButton deleteButton1;
    private org.openswing.swing.client.DeleteButton deleteButton2;
    private org.openswing.swing.client.EditButton editButton1;
    private org.openswing.swing.client.EditButton editButton2;
    private org.openswing.swing.client.EditButton editButton3;
    private org.openswing.swing.form.client.Form form1;
    private org.openswing.swing.client.FormattedTextControl formattedTextControl1;
    private org.openswing.swing.client.GridControl gridControlContato;
    private org.openswing.swing.client.GridControl gridControlEndereco;
    private org.openswing.swing.client.ImageControl imageControl1;
    private org.openswing.swing.client.InsertButton insertButton1;
    private org.openswing.swing.client.InsertButton insertButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.openswing.swing.client.LabelControl labelControl1;
    private org.openswing.swing.client.LabelControl labelControl10;
    private org.openswing.swing.client.LabelControl labelControl11;
    private org.openswing.swing.client.LabelControl labelControl12;
    private org.openswing.swing.client.LabelControl labelControl13;
    private org.openswing.swing.client.LabelControl labelControl14;
    private org.openswing.swing.client.LabelControl labelControl15;
    private org.openswing.swing.client.LabelControl labelControl17;
    private org.openswing.swing.client.LabelControl labelControl18;
    private org.openswing.swing.client.LabelControl labelControl19;
    private org.openswing.swing.client.LabelControl labelControl20;
    private org.openswing.swing.client.LabelControl labelControl21;
    private org.openswing.swing.client.LabelControl labelControl22;
    private org.openswing.swing.client.LabelControl labelControl23;
    private org.openswing.swing.client.LabelControl labelControl24;
    private org.openswing.swing.client.LabelControl labelControl25;
    private org.openswing.swing.client.LabelControl labelControl26;
    private org.openswing.swing.client.LabelControl labelControl27;
    private org.openswing.swing.client.LabelControl labelControl28;
    private org.openswing.swing.client.LabelControl labelControl29;
    private org.openswing.swing.client.LabelControl labelControl3;
    private org.openswing.swing.client.LabelControl labelControl30;
    private org.openswing.swing.client.LabelControl labelControl31;
    private org.openswing.swing.client.LabelControl labelControl32;
    private org.openswing.swing.client.LabelControl labelControl33;
    private org.openswing.swing.client.LabelControl labelControl5;
    private org.openswing.swing.client.LabelControl labelControl7;
    private org.openswing.swing.client.LabelControl labelControl8;
    private org.openswing.swing.client.LabelControl labelControl9;
    private org.openswing.swing.client.NavigatorBar navigatorBar1;
    private org.openswing.swing.client.NavigatorBar navigatorBar2;
    private org.openswing.swing.client.NumericControl numericControl22;
    private org.openswing.swing.client.NumericControl numericControl24;
    private org.openswing.swing.client.NumericControl numericControl25;
    private org.openswing.swing.client.NumericControl numericControl26;
    private org.openswing.swing.client.NumericControl numericControl27;
    private org.openswing.swing.client.NumericControl numericControl28;
    private org.openswing.swing.client.NumericControl numericControl29;
    private org.openswing.swing.client.ReloadButton reloadButton1;
    private org.openswing.swing.client.ReloadButton reloadButton2;
    private org.openswing.swing.client.ReloadButton reloadButton3;
    private org.openswing.swing.client.SaveButton saveButton1;
    private org.openswing.swing.client.SaveButton saveButton2;
    private org.openswing.swing.client.SaveButton saveButton3;
    private org.openswing.swing.table.columns.client.TextColumn textColumn10;
    private org.openswing.swing.table.columns.client.TextColumn textColumn11;
    private org.openswing.swing.table.columns.client.TextColumn textColumn12;
    private org.openswing.swing.table.columns.client.TextColumn textColumn13;
    private org.openswing.swing.table.columns.client.TextColumn textColumn14;
    private org.openswing.swing.table.columns.client.TextColumn textColumn15;
    private org.openswing.swing.table.columns.client.TextColumn textColumn16;
    private org.openswing.swing.table.columns.client.TextColumn textColumn17;
    private org.openswing.swing.table.columns.client.TextColumn textColumn4;
    private org.openswing.swing.table.columns.client.TextColumn textColumn5;
    private org.openswing.swing.table.columns.client.TextColumn textColumn6;
    private org.openswing.swing.table.columns.client.TextColumn textColumn7;
    private org.openswing.swing.table.columns.client.TextColumn textColumn8;
    private org.openswing.swing.table.columns.client.TextColumn textColumn9;
    private org.openswing.swing.client.TextControl textControl10;
    private org.openswing.swing.client.TextControl textControl11;
    private org.openswing.swing.client.TextControl textControl12;
    private org.openswing.swing.client.TextControl textControl13;
    private org.openswing.swing.client.TextControl textControl17;
    private org.openswing.swing.client.TextControl textControl18;
    private org.openswing.swing.client.TextControl textControl23;
    private org.openswing.swing.client.TextControl textControl3;
    private org.openswing.swing.client.TextControl textControl30;
    private org.openswing.swing.client.TextControl textControl31;
    private org.openswing.swing.client.TextControl textControl4;
    private org.openswing.swing.client.TextControl textControl5;
    private org.openswing.swing.client.TextControl textControl6;
    private org.openswing.swing.client.TextControl textControl7;
    private org.openswing.swing.client.TextControl textControl9;
    // End of variables declaration//GEN-END:variables

}
