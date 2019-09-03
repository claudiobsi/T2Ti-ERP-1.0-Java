package com.t2tierp.cadastros.cliente;

import com.t2tierp.padrao.cliente.LookupDataLocatorGenerico;
import java.awt.Dimension;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.mdi.client.InternalFrame;

/**
* <p>Title: T2Ti ERP</p>
* <p>Description: Tela SocioDetalhe.</p>
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
public class SocioDetalhe extends InternalFrame {

    private LookupController pessoaController = new LookupController();
    private LookupController quadroSocietarioController = new LookupController();
    private LookupController tipoRelacionamentoController = new LookupController();
    private SocioDependenteGridController dependenteController;
    private SocioParticipacaoSocietariaGridController participacaoSocietariaController;

    public SocioDetalhe(SocioDetalheController controller) {
        initComponents();

        form1.setFormController(controller);

        dependenteController = new SocioDependenteGridController(this);
        gridControl1.setController(dependenteController);
        gridControl1.setGridDataLocator(dependenteController);

        participacaoSocietariaController = new SocioParticipacaoSocietariaGridController(this);
        gridControl2.setController(participacaoSocietariaController);
        gridControl2.setGridDataLocator(participacaoSocietariaController);

        /*
         * Configurações do lookup da pessoa
         */
        pessoaController.setLookupValueObjectClassName("com.t2tierp.cadastros.java.PessoaVO");
        pessoaController.addLookup2ParentLink("id", "pessoa.id");
        pessoaController.addLookup2ParentLink("nome", "pessoa.nome");
        pessoaController.setHeaderColumnName("id", "ID");
        pessoaController.setHeaderColumnName("nome", "Nome");
        pessoaController.setFrameTitle("Importa Pessoa");

        pessoaController.setVisibleStatusPanel(true);
        pessoaController.setVisibleColumn("id", true);
        pessoaController.setVisibleColumn("nome", true);
        pessoaController.setFramePreferedSize(new Dimension(600, 500));

        pessoaController.setLookupDataLocator(new LookupDataLocatorGenerico(pessoaController.getLookupValueObjectClassName()));
        codLookupControl2.setLookupController(pessoaController);

        /*
         * Configurações do lookup do quadro societario
         */
        quadroSocietarioController.setLookupValueObjectClassName("com.t2tierp.cadastros.java.QuadroSocietarioVO");
        quadroSocietarioController.addLookup2ParentLink("id", "quadroSocietario.id");
        quadroSocietarioController.addLookup2ParentLink("empresa.razaoSocial", "quadroSocietario.empresa.razaoSocial");
        quadroSocietarioController.setHeaderColumnName("id", "ID");
        quadroSocietarioController.setHeaderColumnName("empresa.razaoSocial", "Empresa");
        quadroSocietarioController.setFrameTitle("Importa Quadro Societário");

        quadroSocietarioController.setVisibleStatusPanel(true);
        quadroSocietarioController.setVisibleColumn("id", true);
        quadroSocietarioController.setVisibleColumn("empresa.razaoSocial", true);
        quadroSocietarioController.setFramePreferedSize(new Dimension(600, 500));

        quadroSocietarioController.setLookupDataLocator(new LookupDataLocatorGenerico(quadroSocietarioController.getLookupValueObjectClassName()));
        codLookupControl3.setLookupController(quadroSocietarioController);

        /*
         * Configurações do lookup do tipo relacionamento
         */
        tipoRelacionamentoController.setLookupValueObjectClassName("com.t2tierp.cadastros.java.TipoRelacionamentoVO");
        tipoRelacionamentoController.addLookup2ParentLink("id", "tipoRelacionamento.id");
        tipoRelacionamentoController.addLookup2ParentLink("nome", "tipoRelacionamento.nome");
        tipoRelacionamentoController.setHeaderColumnName("id", "ID");
        tipoRelacionamentoController.setHeaderColumnName("nome", "Nome");
        tipoRelacionamentoController.setFrameTitle("Importa Tipo Relacionamento");

        tipoRelacionamentoController.setVisibleStatusPanel(true);
        tipoRelacionamentoController.setVisibleColumn("id", true);
        tipoRelacionamentoController.setVisibleColumn("nome", true);
        tipoRelacionamentoController.setFramePreferedSize(new Dimension(600, 500));

        tipoRelacionamentoController.setLookupDataLocator(new LookupDataLocatorGenerico(tipoRelacionamentoController.getLookupValueObjectClassName()));
        codLookupColumn1.setLookupController(tipoRelacionamentoController);

    }

    public org.openswing.swing.form.client.Form getForm1() {
        return form1;
    }

    public SocioDependenteGridController getDependenteController() {
        return dependenteController;
    }

    public org.openswing.swing.client.GridControl getGridControlDependentes() {
        return gridControl1;
    }

    public SocioParticipacaoSocietariaGridController getParticipacaoSocietariaController() {
        return participacaoSocietariaController;
    }

    public org.openswing.swing.client.GridControl getGridControlParticipacaoSocietaria() {
        return gridControl2;
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
        form1 = new org.openswing.swing.form.client.Form();
        labelControl1 = new org.openswing.swing.client.LabelControl();
        codLookupControl2 = new org.openswing.swing.client.CodLookupControl();
        textControl2 = new org.openswing.swing.client.TextControl();
        labelControl3 = new org.openswing.swing.client.LabelControl();
        codLookupControl3 = new org.openswing.swing.client.CodLookupControl();
        textControl3 = new org.openswing.swing.client.TextControl();
        labelControl5 = new org.openswing.swing.client.LabelControl();
        textControl4 = new org.openswing.swing.client.TextControl();
        labelControl6 = new org.openswing.swing.client.LabelControl();
        numericControl5 = new org.openswing.swing.client.NumericControl();
        labelControl7 = new org.openswing.swing.client.LabelControl();
        textControl6 = new org.openswing.swing.client.TextControl();
        labelControl8 = new org.openswing.swing.client.LabelControl();
        textControl7 = new org.openswing.swing.client.TextControl();
        labelControl9 = new org.openswing.swing.client.LabelControl();
        textControl8 = new org.openswing.swing.client.TextControl();
        labelControl10 = new org.openswing.swing.client.LabelControl();
        textControl9 = new org.openswing.swing.client.TextControl();
        labelControl11 = new org.openswing.swing.client.LabelControl();
        textControl10 = new org.openswing.swing.client.TextControl();
        labelControl12 = new org.openswing.swing.client.LabelControl();
        textControl11 = new org.openswing.swing.client.TextControl();
        labelControl13 = new org.openswing.swing.client.LabelControl();
        textControl12 = new org.openswing.swing.client.TextControl();
        labelControl14 = new org.openswing.swing.client.LabelControl();
        textControl13 = new org.openswing.swing.client.TextControl();
        labelControl15 = new org.openswing.swing.client.LabelControl();
        numericControl14 = new org.openswing.swing.client.NumericControl();
        labelControl16 = new org.openswing.swing.client.LabelControl();
        numericControl15 = new org.openswing.swing.client.NumericControl();
        labelControl17 = new org.openswing.swing.client.LabelControl();
        numericControl16 = new org.openswing.swing.client.NumericControl();
        labelControl18 = new org.openswing.swing.client.LabelControl();
        dateControl17 = new org.openswing.swing.client.DateControl();
        labelControl19 = new org.openswing.swing.client.LabelControl();
        dateControl18 = new org.openswing.swing.client.DateControl();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        insertButton1 = new org.openswing.swing.client.InsertButton();
        editButton2 = new org.openswing.swing.client.EditButton();
        deleteButton1 = new org.openswing.swing.client.DeleteButton();
        saveButton2 = new org.openswing.swing.client.SaveButton();
        reloadButton2 = new org.openswing.swing.client.ReloadButton();
        gridControl1 = new org.openswing.swing.client.GridControl();
        codLookupColumn1 = new org.openswing.swing.table.columns.client.CodLookupColumn();
        textColumn4 = new org.openswing.swing.table.columns.client.TextColumn();
        dateColumn5 = new org.openswing.swing.table.columns.client.DateColumn();
        dateColumn6 = new org.openswing.swing.table.columns.client.DateColumn();
        dateColumn7 = new org.openswing.swing.table.columns.client.DateColumn();
        textColumn8 = new org.openswing.swing.table.columns.client.TextColumn();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        insertButton2 = new org.openswing.swing.client.InsertButton();
        editButton3 = new org.openswing.swing.client.EditButton();
        deleteButton2 = new org.openswing.swing.client.DeleteButton();
        saveButton3 = new org.openswing.swing.client.SaveButton();
        reloadButton3 = new org.openswing.swing.client.ReloadButton();
        gridControl2 = new org.openswing.swing.client.GridControl();
        textColumn3 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn5 = new org.openswing.swing.table.columns.client.TextColumn();
        dateColumn8 = new org.openswing.swing.table.columns.client.DateColumn();
        dateColumn9 = new org.openswing.swing.table.columns.client.DateColumn();
        decimalColumn7 = new org.openswing.swing.table.columns.client.DecimalColumn();
        comboColumn8 = new org.openswing.swing.table.columns.client.ComboColumn();

        setTitle("T2Ti ERP - Cadastros");
        setPreferredSize(new java.awt.Dimension(700, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Socio"));
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

        form1.setVOClassName("com.t2tierp.cadastros.java.SocioVO");
        form1.setEditButton(editButton1);
        form1.setFunctionId("socio");
        form1.setReloadButton(reloadButton1);
        form1.setSaveButton(saveButton1);
        form1.setLayout(new java.awt.GridBagLayout());

        labelControl1.setLabel("Socio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl1, gridBagConstraints);

        codLookupControl2.setAllowOnlyNumbers(true);
        codLookupControl2.setAttributeName("pessoa.id");
        codLookupControl2.setEnabled(false);
        codLookupControl2.setLinkLabel(labelControl1);
        codLookupControl2.setMaxCharacters(10);
        codLookupControl2.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -100;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(codLookupControl2, gridBagConstraints);

        textControl2.setAttributeName("pessoa.nome");
        textControl2.setEnabled(false);
        textControl2.setEnabledOnEdit(false);
        textControl2.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl2, gridBagConstraints);

        labelControl3.setLabel("Quadro Societario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl3, gridBagConstraints);

        codLookupControl3.setAllowOnlyNumbers(true);
        codLookupControl3.setAttributeName("quadroSocietario.id");
        codLookupControl3.setEnabled(false);
        codLookupControl3.setMaxCharacters(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -100;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(codLookupControl3, gridBagConstraints);

        textControl3.setAttributeName("quadroSocietario.empresa.razaoSocial");
        textControl3.setEnabled(false);
        textControl3.setEnabledOnEdit(false);
        textControl3.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl3, gridBagConstraints);

        labelControl5.setLabel("Logradouro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl5, gridBagConstraints);

        textControl4.setAttributeName("logradouro");
        textControl4.setEnabled(false);
        textControl4.setMaxCharacters(100);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl4, gridBagConstraints);

        labelControl6.setLabel("Numero:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl6, gridBagConstraints);

        numericControl5.setAttributeName("numero");
        numericControl5.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl5, gridBagConstraints);

        labelControl7.setLabel("Complemento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl7, gridBagConstraints);

        textControl6.setAttributeName("complemento");
        textControl6.setEnabled(false);
        textControl6.setMaxCharacters(100);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl6, gridBagConstraints);

        labelControl8.setLabel("Bairro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl8, gridBagConstraints);

        textControl7.setAttributeName("bairro");
        textControl7.setEnabled(false);
        textControl7.setMaxCharacters(100);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl7, gridBagConstraints);

        labelControl9.setLabel("Municipio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl9, gridBagConstraints);

        textControl8.setAttributeName("municipio");
        textControl8.setEnabled(false);
        textControl8.setMaxCharacters(100);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl8, gridBagConstraints);

        labelControl10.setLabel("Uf:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl10, gridBagConstraints);

        textControl9.setAttributeName("uf");
        textControl9.setEnabled(false);
        textControl9.setMaxCharacters(2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl9, gridBagConstraints);

        labelControl11.setLabel("Cep:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl11, gridBagConstraints);

        textControl10.setAttributeName("cep");
        textControl10.setEnabled(false);
        textControl10.setMaxCharacters(8);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl10, gridBagConstraints);

        labelControl12.setLabel("Fone:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl12, gridBagConstraints);

        textControl11.setAttributeName("fone");
        textControl11.setEnabled(false);
        textControl11.setMaxCharacters(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl11, gridBagConstraints);

        labelControl13.setLabel("Celular:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl13, gridBagConstraints);

        textControl12.setAttributeName("celular");
        textControl12.setEnabled(false);
        textControl12.setMaxCharacters(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl12, gridBagConstraints);

        labelControl14.setLabel("Email:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl14, gridBagConstraints);

        textControl13.setAttributeName("email");
        textControl13.setEnabled(false);
        textControl13.setMaxCharacters(250);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl13, gridBagConstraints);

        labelControl15.setLabel("Participacao(%):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl15, gridBagConstraints);

        numericControl14.setAttributeName("participacao");
        numericControl14.setDecimals(2);
        numericControl14.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl14, gridBagConstraints);

        labelControl16.setLabel("Quotas:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl16, gridBagConstraints);

        numericControl15.setAttributeName("quotas");
        numericControl15.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl15, gridBagConstraints);

        labelControl17.setLabel("Integralizar:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl17, gridBagConstraints);

        numericControl16.setAttributeName("integralizar");
        numericControl16.setDecimals(2);
        numericControl16.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(numericControl16, gridBagConstraints);

        labelControl18.setLabel("Data Ingresso:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl18, gridBagConstraints);

        dateControl17.setAttributeName("dataIngresso");
        dateControl17.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(dateControl17, gridBagConstraints);

        labelControl19.setLabel("Data Saida:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl19, gridBagConstraints);

        dateControl18.setAttributeName("dataSaida");
        dateControl18.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(dateControl18, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(form1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Socio Dependente"));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel3.add(insertButton1);
        jPanel3.add(editButton2);
        jPanel3.add(deleteButton1);
        jPanel3.add(saveButton2);
        jPanel3.add(reloadButton2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(jPanel3, gridBagConstraints);

        gridControl1.setAutoLoadData(false);
        gridControl1.setDeleteButton(deleteButton1);
        gridControl1.setEditButton(editButton2);
        gridControl1.setFunctionId("socioDependente");
        gridControl1.setInsertButton(insertButton1);
        gridControl1.setReloadButton(reloadButton2);
        gridControl1.setSaveButton(saveButton2);
        gridControl1.setValueObjectClassName("com.t2tierp.cadastros.java.SocioDependenteVO");
        gridControl1.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        codLookupColumn1.setColumnName("tipoRelacionamento.nome");
        codLookupColumn1.setEditableOnEdit(true);
        codLookupColumn1.setEditableOnInsert(true);
        codLookupColumn1.setHeaderColumnName("Tipo Relacionamento");
        codLookupColumn1.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        codLookupColumn1.setPreferredWidth(200);
        gridControl1.getColumnContainer().add(codLookupColumn1);

        textColumn4.setColumnName("nome");
        textColumn4.setEditableOnEdit(true);
        textColumn4.setEditableOnInsert(true);
        textColumn4.setHeaderColumnName("Nome");
        textColumn4.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        textColumn4.setMaxCharacters(100);
        textColumn4.setPreferredWidth(200);
        gridControl1.getColumnContainer().add(textColumn4);

        dateColumn5.setColumnName("dataNascimento");
        dateColumn5.setEditableOnEdit(true);
        dateColumn5.setEditableOnInsert(true);
        dateColumn5.setHeaderColumnName("Data Nascimento");
        dateColumn5.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        gridControl1.getColumnContainer().add(dateColumn5);

        dateColumn6.setColumnName("dataInicioDepedencia");
        dateColumn6.setEditableOnEdit(true);
        dateColumn6.setEditableOnInsert(true);
        dateColumn6.setHeaderColumnName("Data Inicio Depedencia");
        dateColumn6.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        dateColumn6.setPreferredWidth(130);
        gridControl1.getColumnContainer().add(dateColumn6);

        dateColumn7.setColumnName("dataFimDependencia");
        dateColumn7.setColumnRequired(false);
        dateColumn7.setEditableOnEdit(true);
        dateColumn7.setEditableOnInsert(true);
        dateColumn7.setHeaderColumnName("Data Fim Dependencia");
        dateColumn7.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        dateColumn7.setPreferredWidth(130);
        gridControl1.getColumnContainer().add(dateColumn7);

        textColumn8.setColumnName("cpf");
        textColumn8.setColumnRequired(false);
        textColumn8.setEditableOnEdit(true);
        textColumn8.setEditableOnInsert(true);
        textColumn8.setHeaderColumnName("Cpf");
        textColumn8.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn8.setMaxCharacters(11);
        gridControl1.getColumnContainer().add(textColumn8);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(gridControl1, gridBagConstraints);

        jTabbedPane1.addTab("Dependentes", jPanel2);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Socio Participacao Societaria"));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel5.add(insertButton2);
        jPanel5.add(editButton3);
        jPanel5.add(deleteButton2);
        jPanel5.add(saveButton3);
        jPanel5.add(reloadButton3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(jPanel5, gridBagConstraints);

        gridControl2.setAutoLoadData(false);
        gridControl2.setDeleteButton(deleteButton2);
        gridControl2.setEditButton(editButton3);
        gridControl2.setFunctionId("socioParticipacaoSocietaria");
        gridControl2.setInsertButton(insertButton2);
        gridControl2.setReloadButton(reloadButton3);
        gridControl2.setSaveButton(saveButton3);
        gridControl2.setValueObjectClassName("com.t2tierp.cadastros.java.SocioParticipacaoSocietariaVO");
        gridControl2.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        textColumn3.setColumnName("cnpj");
        textColumn3.setEditableOnEdit(true);
        textColumn3.setEditableOnInsert(true);
        textColumn3.setHeaderColumnName("Cnpj");
        textColumn3.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn3.setMaxCharacters(14);
        textColumn3.setPreferredWidth(150);
        gridControl2.getColumnContainer().add(textColumn3);

        textColumn5.setColumnName("razaoSocial");
        textColumn5.setColumnRequired(false);
        textColumn5.setEditableOnEdit(true);
        textColumn5.setEditableOnInsert(true);
        textColumn5.setHeaderColumnName("Razao Social");
        textColumn5.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        textColumn5.setMaxCharacters(100);
        textColumn5.setPreferredWidth(200);
        gridControl2.getColumnContainer().add(textColumn5);

        dateColumn8.setColumnName("dataEntrada");
        dateColumn8.setEditableOnEdit(true);
        dateColumn8.setEditableOnInsert(true);
        dateColumn8.setHeaderColumnName("Data Entrada");
        dateColumn8.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        gridControl2.getColumnContainer().add(dateColumn8);

        dateColumn9.setColumnName("dataSaida");
        dateColumn9.setColumnRequired(false);
        dateColumn9.setEditableOnEdit(true);
        dateColumn9.setEditableOnInsert(true);
        dateColumn9.setHeaderColumnName("Data Saida");
        dateColumn9.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        gridControl2.getColumnContainer().add(dateColumn9);

        decimalColumn7.setColumnName("participacao");
        decimalColumn7.setColumnRequired(false);
        decimalColumn7.setDecimals(2);
        decimalColumn7.setEditableOnEdit(true);
        decimalColumn7.setEditableOnInsert(true);
        decimalColumn7.setHeaderColumnName("Participacao");
        decimalColumn7.setHeaderFont(new java.awt.Font("Arial", 1, 11));
        gridControl2.getColumnContainer().add(decimalColumn7);

        comboColumn8.setColumnName("dirigente");
        comboColumn8.setDomainId("simnao");
        comboColumn8.setEditableOnEdit(true);
        comboColumn8.setEditableOnInsert(true);
        comboColumn8.setHeaderColumnName("Dirigente");
        comboColumn8.setHeaderFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gridControl2.getColumnContainer().add(comboColumn8);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(gridControl2, gridBagConstraints);

        jTabbedPane1.addTab("Participação Societária", jPanel4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jTabbedPane1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupColumn1;
    private org.openswing.swing.client.CodLookupControl codLookupControl2;
    private org.openswing.swing.client.CodLookupControl codLookupControl3;
    private org.openswing.swing.table.columns.client.ComboColumn comboColumn8;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn5;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn6;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn7;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn8;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn9;
    private org.openswing.swing.client.DateControl dateControl17;
    private org.openswing.swing.client.DateControl dateControl18;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn7;
    private org.openswing.swing.client.DeleteButton deleteButton1;
    private org.openswing.swing.client.DeleteButton deleteButton2;
    private org.openswing.swing.client.EditButton editButton1;
    private org.openswing.swing.client.EditButton editButton2;
    private org.openswing.swing.client.EditButton editButton3;
    private org.openswing.swing.form.client.Form form1;
    private org.openswing.swing.client.GridControl gridControl1;
    private org.openswing.swing.client.GridControl gridControl2;
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
    private org.openswing.swing.client.LabelControl labelControl16;
    private org.openswing.swing.client.LabelControl labelControl17;
    private org.openswing.swing.client.LabelControl labelControl18;
    private org.openswing.swing.client.LabelControl labelControl19;
    private org.openswing.swing.client.LabelControl labelControl3;
    private org.openswing.swing.client.LabelControl labelControl5;
    private org.openswing.swing.client.LabelControl labelControl6;
    private org.openswing.swing.client.LabelControl labelControl7;
    private org.openswing.swing.client.LabelControl labelControl8;
    private org.openswing.swing.client.LabelControl labelControl9;
    private org.openswing.swing.client.NumericControl numericControl14;
    private org.openswing.swing.client.NumericControl numericControl15;
    private org.openswing.swing.client.NumericControl numericControl16;
    private org.openswing.swing.client.NumericControl numericControl5;
    private org.openswing.swing.client.ReloadButton reloadButton1;
    private org.openswing.swing.client.ReloadButton reloadButton2;
    private org.openswing.swing.client.ReloadButton reloadButton3;
    private org.openswing.swing.client.SaveButton saveButton1;
    private org.openswing.swing.client.SaveButton saveButton2;
    private org.openswing.swing.client.SaveButton saveButton3;
    private org.openswing.swing.table.columns.client.TextColumn textColumn3;
    private org.openswing.swing.table.columns.client.TextColumn textColumn4;
    private org.openswing.swing.table.columns.client.TextColumn textColumn5;
    private org.openswing.swing.table.columns.client.TextColumn textColumn8;
    private org.openswing.swing.client.TextControl textControl10;
    private org.openswing.swing.client.TextControl textControl11;
    private org.openswing.swing.client.TextControl textControl12;
    private org.openswing.swing.client.TextControl textControl13;
    private org.openswing.swing.client.TextControl textControl2;
    private org.openswing.swing.client.TextControl textControl3;
    private org.openswing.swing.client.TextControl textControl4;
    private org.openswing.swing.client.TextControl textControl6;
    private org.openswing.swing.client.TextControl textControl7;
    private org.openswing.swing.client.TextControl textControl8;
    private org.openswing.swing.client.TextControl textControl9;
    // End of variables declaration//GEN-END:variables

}
