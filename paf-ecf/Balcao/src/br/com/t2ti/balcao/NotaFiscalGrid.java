/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.t2ti.balcao;

import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.form.client.Form;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.lookup.client.LookupServerDataLocator;
import org.openswing.swing.mdi.client.InternalFrame;

/**
 * <p>Title: T2Ti Balcao</p>
 * <p>Description: Janela de cadastro da Nota Fiscal NF2.</p>
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
 * @author Claudio de Barros (T2Ti.COM)
 * @version 1.0
 */
public class NotaFiscalGrid extends InternalFrame {

    private LookupController produtoController = new LookupController();
    private LookupServerDataLocator produtoDataLocator = new ProdutoLookupDataLocator();
    private LookupController clienteController = new LookupController();
    private LookupServerDataLocator clienteDataLocator = new ClienteLookupDataLocator();
    private LookupController funcionarioController = new LookupController();
    private LookupServerDataLocator funcionarioDataLocator = new FuncionarioLookupDataLocator();

    /** Creates new form NewJInternalFrame */
    public NotaFiscalGrid(NotaFiscalController controller) {
        initComponents();

        form1.setFormController(controller);

        NotaFiscalGridController notaFiscalGridController = new NotaFiscalGridController(this);
        gridControl1.setController(notaFiscalGridController);
        gridControl1.setGridDataLocator(notaFiscalGridController);

        /*
         * Configurações do lookup do produto
         */
        produtoController.setLookupValueObjectClassName("br.com.t2ti.vo.ProdutoVO");
        produtoController.addLookup2ParentLink("id", "produto.id");
        produtoController.addLookup2ParentLink("nome", "produto.nome");
        produtoController.addLookup2ParentLink("valorVenda", "produto.valorVenda");
        produtoController.addLookup2ParentLink("gtin", "produto.gtin");
        produtoController.addLookup2ParentLink("unidadeProduto.nome", "produto.unidadeProduto.nome");
        produtoController.addLookup2ParentLink("cst", "produto.cst");
        produtoController.addLookup2ParentLink("taxaIcms", "produto.taxaIcms");
        produtoController.addLookup2ParentLink("taxaIssqn", "produto.taxaIssqn");
        produtoController.addLookup2ParentLink("taxaPis", "produto.taxaPis");
        produtoController.addLookup2ParentLink("taxaCofins", "produto.taxaCofins");
        produtoController.addLookup2ParentLink("taxaIpi", "produto.taxaIpi");
        produtoController.addLookup2ParentLink("totalizadorParcial", "produto.totalizadorParcial");
        produtoController.setHeaderColumnName("nome", "Nome");
        produtoController.setHeaderColumnName("valorVenda", "Valor Unitário");
        produtoController.setFrameTitle("Importa Produto");

        produtoController.setVisibleStatusPanel(true);
        produtoController.setVisibleColumn("nome", true);
        produtoController.setPreferredWidthColumn("nome", 200);
        produtoController.setVisibleColumn("valorVenda", true);
        produtoController.setFramePreferedSize(new Dimension(500, 400));

        produtoController.setLookupDataLocator(produtoDataLocator);
        codLookupColumn1.setLookupController(produtoController);
        produtoDataLocator.setLookupFrameParams(null);

        produtoController.setFilterableColumn("nome", true);
        produtoController.setSortableColumn("nome", true);

        /*
         * Configurações do lookup do cliente
         */
        clienteController.setLookupValueObjectClassName("br.com.t2ti.vo.ClienteVO");
        clienteController.addLookup2ParentLink("id", "cliente.id");
        clienteController.addLookup2ParentLink("nome", "cliente.nome");
        clienteController.addLookup2ParentLink("uf", "cliente.uf");
        clienteController.addLookup2ParentLink("cpfCnpj", "cliente.cpfCnpj");
        clienteController.setHeaderColumnName("id", "ID");
        clienteController.setHeaderColumnName("nome", "Nome");
        clienteController.setHeaderColumnName("cpfCnpj", "CPF/CNPJ");
        clienteController.setFrameTitle("Importa Cliente");

        clienteController.setVisibleStatusPanel(true);
        clienteController.setVisibleColumn("id", true);
        clienteController.setVisibleColumn("nome", true);
        clienteController.setVisibleColumn("cpfCnpj", true);
        clienteController.setPreferredWidthColumn("nome", 200);
        clienteController.setFramePreferedSize(new Dimension(500, 400));

        clienteController.setLookupDataLocator(clienteDataLocator);
        codLookupControl2.setLookupController(clienteController);
        clienteDataLocator.setLookupFrameParams(null);

        clienteController.setFilterableColumn("nome", true);
        clienteController.setSortableColumn("nome", true);

        /*
         * Configurações do lookup do vendedor/funcionario
         */
        funcionarioController.setLookupValueObjectClassName("br.com.t2ti.vo.EcfFuncionarioVO");
        funcionarioController.addLookup2ParentLink("id", "funcionario.id");
        funcionarioController.addLookup2ParentLink("nome", "funcionario.nome");
        funcionarioController.setHeaderColumnName("id", "ID");
        funcionarioController.setHeaderColumnName("nome", "Nome");
        funcionarioController.setFrameTitle("Importa Funcionário");

        funcionarioController.setVisibleStatusPanel(true);
        funcionarioController.setVisibleColumn("id", true);
        funcionarioController.setVisibleColumn("nome", true);
        funcionarioController.setPreferredWidthColumn("nome", 200);
        funcionarioController.setFramePreferedSize(new Dimension(500, 400));

        funcionarioController.setLookupDataLocator(funcionarioDataLocator);
        codLookupControl1.setLookupController(funcionarioController);
        funcionarioDataLocator.setLookupFrameParams(null);

        funcionarioController.setFilterableColumn("nome", true);
        funcionarioController.setSortableColumn("nome", true);

    }

    public GridControl getGrid1() {
        return gridControl1;
    }

    public Form getForm1() {
        return form1;
    }

    public void setValorTotal(String valorTotal) {
        jLabel2.setText(valorTotal);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        form1 = new org.openswing.swing.form.client.Form();
        labelControl1 = new org.openswing.swing.client.LabelControl();
        textControl1 = new org.openswing.swing.client.TextControl();
        labelControl2 = new org.openswing.swing.client.LabelControl();
        jLabel2 = new javax.swing.JLabel();
        textControl2 = new org.openswing.swing.client.TextControl();
        jLabel3 = new javax.swing.JLabel();
        labelControl3 = new org.openswing.swing.client.LabelControl();
        textControl3 = new org.openswing.swing.client.TextControl();
        labelControl4 = new org.openswing.swing.client.LabelControl();
        codLookupControl1 = new org.openswing.swing.client.CodLookupControl();
        textControl4 = new org.openswing.swing.client.TextControl();
        labelControl5 = new org.openswing.swing.client.LabelControl();
        labelControl6 = new org.openswing.swing.client.LabelControl();
        dateControl1 = new org.openswing.swing.client.DateControl();
        codLookupControl2 = new org.openswing.swing.client.CodLookupControl();
        textControl5 = new org.openswing.swing.client.TextControl();
        gridControl1 = new org.openswing.swing.client.GridControl();
        codLookupColumn1 = new org.openswing.swing.table.columns.client.CodLookupColumn();
        integerColumn1 = new org.openswing.swing.table.columns.client.IntegerColumn();
        decimalColumn1 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn2 = new org.openswing.swing.table.columns.client.DecimalColumn();
        jPanel3 = new javax.swing.JPanel();
        insertButton1 = new org.openswing.swing.client.InsertButton();
        editButton1 = new org.openswing.swing.client.EditButton();
        deleteButton1 = new org.openswing.swing.client.DeleteButton();
        reloadButton1 = new org.openswing.swing.client.ReloadButton();
        saveButton1 = new org.openswing.swing.client.SaveButton();
        jPanel4 = new javax.swing.JPanel();
        saveButton2 = new org.openswing.swing.client.SaveButton();

        setTitle("T2Ti PAF-ECF+TEF - Balcão");
        setPreferredSize(new java.awt.Dimension(650, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(java.awt.SystemColor.inactiveCaption);
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nota Fiscal");
        jPanel1.add(jLabel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        form1.setVOClassName("br.com.t2ti.vo.NotaFiscalCabecalhoVO");
        form1.setSaveButton(saveButton2);
        form1.setLayout(new java.awt.GridBagLayout());

        labelControl1.setText("Nome Destinatário");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        form1.add(labelControl1, gridBagConstraints);

        textControl1.setAttributeName("cliente.nome");
        textControl1.setMaxCharacters(150);
        textControl1.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        form1.add(textControl1, gridBagConstraints);

        labelControl2.setText("CPF / CNPJ Destinatário");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        form1.add(labelControl2, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("0,00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        form1.add(jLabel2, gridBagConstraints);

        textControl2.setAttributeName("cliente.cpfCnpj");
        textControl2.setMaxCharacters(14);
        textControl2.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        form1.add(textControl2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Total Nota:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        form1.add(jLabel3, gridBagConstraints);

        labelControl3.setText("Número:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        form1.add(labelControl3, gridBagConstraints);

        textControl3.setAttributeName("numero");
        textControl3.setMaxCharacters(6);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        form1.add(textControl3, gridBagConstraints);

        labelControl4.setText("Vendedor / Funcionário");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        form1.add(labelControl4, gridBagConstraints);

        codLookupControl1.setAllowOnlyNumbers(true);
        codLookupControl1.setAttributeName("funcionario.id");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = -50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        form1.add(codLookupControl1, gridBagConstraints);

        textControl4.setAttributeName("funcionario.nome");
        textControl4.setEnabled(false);
        textControl4.setEnabledOnEdit(false);
        textControl4.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        form1.add(textControl4, gridBagConstraints);

        labelControl5.setText("Data Emissão:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        form1.add(labelControl5, gridBagConstraints);

        labelControl6.setText("Hora Emissão:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        form1.add(labelControl6, gridBagConstraints);

        dateControl1.setAttributeName("dataEmissao");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        form1.add(dateControl1, gridBagConstraints);

        codLookupControl2.setAllowOnlyNumbers(true);
        codLookupControl2.setAttributeName("cliente.id");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = -50;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        form1.add(codLookupControl2, gridBagConstraints);

        textControl5.setAttributeName("horaEmissao");
        textControl5.setMaxCharacters(8);
        textControl5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textControl5FocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        form1.add(textControl5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(form1, gridBagConstraints);

        gridControl1.setDeleteButton(deleteButton1);
        gridControl1.setEditButton(editButton1);
        gridControl1.setInsertButton(insertButton1);
        gridControl1.setPreferredSize(new java.awt.Dimension(627, 400));
        gridControl1.setReloadButton(reloadButton1);
        gridControl1.setSaveButton(saveButton1);
        gridControl1.setValueObjectClassName("br.com.t2ti.vo.NotaFiscalDetalheVO");
        gridControl1.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        codLookupColumn1.setColumnName("produto.nome");
        codLookupColumn1.setEditableOnEdit(true);
        codLookupColumn1.setEditableOnInsert(true);
        codLookupColumn1.setHeaderColumnName("Descrição");
        codLookupColumn1.setPreferredWidth(300);
        gridControl1.getColumnContainer().add(codLookupColumn1);

        integerColumn1.setColumnName("quantidade");
        integerColumn1.setEditableOnEdit(true);
        integerColumn1.setEditableOnInsert(true);
        integerColumn1.setHeaderColumnName("Quantidade");
        gridControl1.getColumnContainer().add(integerColumn1);

        decimalColumn1.setColumnName("produto.valorVenda");
        decimalColumn1.setDecimals(2);
        decimalColumn1.setHeaderColumnName("Unitário");
        gridControl1.getColumnContainer().add(decimalColumn1);

        decimalColumn2.setColumnName("valorTotal");
        decimalColumn2.setColumnRequired(false);
        decimalColumn2.setDecimals(2);
        decimalColumn2.setHeaderColumnName("Total");
        gridControl1.getColumnContainer().add(decimalColumn2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(gridControl1, gridBagConstraints);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel3.add(insertButton1);
        jPanel3.add(editButton1);
        jPanel3.add(deleteButton1);
        jPanel3.add(reloadButton1);
        jPanel3.add(saveButton1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(jPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel4.add(saveButton2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel4, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textControl5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textControl5FocusGained
        if (textControl5.getText().trim().equals("")) {
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
            textControl5.setValue(formatoHora.format(new Date()));
        }
    }//GEN-LAST:event_textControl5FocusGained
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupColumn1;
    private org.openswing.swing.client.CodLookupControl codLookupControl1;
    private org.openswing.swing.client.CodLookupControl codLookupControl2;
    private org.openswing.swing.client.DateControl dateControl1;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn1;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn2;
    private org.openswing.swing.client.DeleteButton deleteButton1;
    private org.openswing.swing.client.EditButton editButton1;
    private org.openswing.swing.form.client.Form form1;
    private org.openswing.swing.client.GridControl gridControl1;
    private org.openswing.swing.client.InsertButton insertButton1;
    private org.openswing.swing.table.columns.client.IntegerColumn integerColumn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private org.openswing.swing.client.LabelControl labelControl1;
    private org.openswing.swing.client.LabelControl labelControl2;
    private org.openswing.swing.client.LabelControl labelControl3;
    private org.openswing.swing.client.LabelControl labelControl4;
    private org.openswing.swing.client.LabelControl labelControl5;
    private org.openswing.swing.client.LabelControl labelControl6;
    private org.openswing.swing.client.ReloadButton reloadButton1;
    private org.openswing.swing.client.SaveButton saveButton1;
    private org.openswing.swing.client.SaveButton saveButton2;
    private org.openswing.swing.client.TextControl textControl1;
    private org.openswing.swing.client.TextControl textControl2;
    private org.openswing.swing.client.TextControl textControl3;
    private org.openswing.swing.client.TextControl textControl4;
    private org.openswing.swing.client.TextControl textControl5;
    // End of variables declaration//GEN-END:variables
}
