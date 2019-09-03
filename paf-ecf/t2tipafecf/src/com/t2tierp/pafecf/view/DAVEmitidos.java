/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: PAF-ECF + TEF - Janela dos DAV emitidos.</p>
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
package com.t2tierp.pafecf.view;

import com.t2tierp.pafecf.controller.DAVController;
import com.t2tierp.pafecf.infra.Biblioteca;
import com.t2tierp.pafecf.infra.MenuFiscalAction;
import com.t2tierp.pafecf.infra.Paf;
import com.t2tierp.pafecf.vo.DAVCabecalhoVO;
import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class DAVEmitidos extends javax.swing.JDialog {

    public DAVEmitidos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        defineFormatoData();

        int r = Integer.valueOf(Caixa.configuracao.getCorJanelasInternas().substring(0, 3));
        int g = Integer.valueOf(Caixa.configuracao.getCorJanelasInternas().substring(4, 7));
        int b = Integer.valueOf(Caixa.configuracao.getCorJanelasInternas().substring(8, 11));

        //TODO : É necessário configurar a cor de cada Panel?
        panelPrincipal.setBackground(new Color(r, g, b));
        panelComponentes.setBackground(new Color(r, g, b));
        panelFiltro.setBackground(new Color(r, g, b));
        panelPeriodo.setBackground(new Color(r, g, b));
        panelBotoes.setBackground(new Color(r, g, b));

        CancelaAction cancelaAction = new CancelaAction();
        botaoCancela.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancelaAction");
        botaoCancela.getActionMap().put("cancelaAction", cancelaAction);

        ConfirmaAction confirmaAction = new ConfirmaAction();
        botaoConfirma.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0), "confirmaAction");
        botaoConfirma.getActionMap().put("confirmaAction", confirmaAction);

        //troca TAB por ENTER
        HashSet conj = new HashSet(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);

        MenuFiscalAction menuFiscalAction = new MenuFiscalAction(this);
        panelPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), "menuFiscal");
        panelPrincipal.getActionMap().put("menuFiscal", menuFiscalAction);

        this.setPreferredSize(new Dimension(500, 170));
        this.pack();
    }

    private void defineFormatoData() {
        try {
            MaskFormatter mascara = new MaskFormatter("##/##/####");
            DefaultFormatterFactory formatter = new DefaultFormatterFactory(mascara);
            dataFinal.setFormatterFactory(formatter);
            dataInicial.setFormatterFactory(formatter);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelComponentes = new javax.swing.JPanel();
        panelFiltro = new javax.swing.JPanel();
        radioGerencial = new javax.swing.JRadioButton();
        radioArquivo = new javax.swing.JRadioButton();
        panelPeriodo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dataInicial = new javax.swing.JFormattedTextField();
        dataFinal = new javax.swing.JFormattedTextField();
        panelBotoes = new javax.swing.JPanel();
        botaoConfirma = new javax.swing.JButton();
        botaoCancela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DAV Emitidos");
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/telas/telaRegistradora01.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        panelPrincipal.add(jLabel1, gridBagConstraints);

        panelComponentes.setLayout(new java.awt.GridBagLayout());

        panelFiltro.setBackground(new Color(255,255,255,0));
        panelFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Filtro:"));
        panelFiltro.setLayout(new java.awt.GridBagLayout());

        buttonGroup1.add(radioGerencial);
        radioGerencial.setSelected(true);
        radioGerencial.setText("Relatório Gerencial");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelFiltro.add(radioGerencial, gridBagConstraints);

        buttonGroup1.add(radioArquivo);
        radioArquivo.setText("Geração de Arquivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelFiltro.add(radioArquivo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        panelComponentes.add(panelFiltro, gridBagConstraints);

        panelPeriodo.setBackground(new Color(255,255,255,0));
        panelPeriodo.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Data inicial:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelPeriodo.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Data final:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelPeriodo.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        panelPeriodo.add(dataInicial, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        panelPeriodo.add(dataFinal, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelComponentes.add(panelPeriodo, gridBagConstraints);

        panelBotoes.setBackground(new Color(255,255,255,0));
        panelBotoes.setLayout(new java.awt.GridBagLayout());

        botaoConfirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/botaoConfirmar.png"))); // NOI18N
        botaoConfirma.setText("Confirma (F12)");
        botaoConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        panelBotoes.add(botaoConfirma, gridBagConstraints);

        botaoCancela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgBotoes/botaoCancelar.png"))); // NOI18N
        botaoCancela.setText("Cancela (ESC)");
        botaoCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 5);
        panelBotoes.add(botaoCancela, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        panelComponentes.add(panelBotoes, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panelPrincipal.add(panelComponentes, gridBagConstraints);

        getContentPane().add(panelPrincipal, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmaActionPerformed
        validaPeriodo();
}//GEN-LAST:event_botaoConfirmaActionPerformed

    private void botaoCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelaActionPerformed
        dispose();
}//GEN-LAST:event_botaoCancelaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                DAVEmitidos dialog = new DAVEmitidos(new javax.swing.JFrame(), true);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancela;
    private javax.swing.JButton botaoConfirma;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelComponentes;
    private javax.swing.JPanel panelFiltro;
    private javax.swing.JPanel panelPeriodo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JRadioButton radioArquivo;
    private javax.swing.JRadioButton radioGerencial;
    // End of variables declaration//GEN-END:variables

    private class ConfirmaAction extends AbstractAction {

        public ConfirmaAction() {
        }

        public void actionPerformed(ActionEvent e) {
            validaPeriodo();
        }
    }

    private class CancelaAction extends AbstractAction {

        public CancelaAction() {
        }

        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    public void validaPeriodo() {
        try {
            dataInicial.commitEdit();
            dataFinal.commitEdit();
            if (!Biblioteca.isDataValida(dataInicial.getText())) {
                JOptionPane.showMessageDialog(this, "Data inicial inválida!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                dataInicial.requestFocus();
            } else if (!Biblioteca.isDataValida(dataFinal.getText())) {
                JOptionPane.showMessageDialog(this, "Data final inválida!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
                dataFinal.requestFocus();
            } else {
                confirma();
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Problemas com os valores informados!", "Aviso do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void confirma() {
        DAVController davControl = new DAVController();
        String numero, dataEmissao, titulo, valor = "";

        SimpleDateFormat formataData;
        Date dataIni = null;
        Date dataFim = null;
        try {
            formataData = new SimpleDateFormat("dd/MM/yyyy");
            dataIni = formataData.parse((String) dataInicial.getValue());
            dataFim = formataData.parse((String) dataFinal.getValue());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        //relatorio gerencial
        if (radioGerencial.isSelected()) {
            String[] opcoes = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(null, "Deseja imprimir o relatório DAV EMITIDOS?", "Pergunta do Sistema",
                    JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, opcoes, null);
            if (escolha == JOptionPane.YES_OPTION) {
                //formata a data para realizar o filtro
                formataData = new SimpleDateFormat("yyyy-MM-dd");
                String strDataIni = formataData.format(dataIni);
                String strDataFim = formataData.format(dataFim);

                List<DAVCabecalhoVO> listaDAV = davControl.listaDAVPeriodo(strDataIni, strDataFim);
                if (listaDAV != null) {
                    try {
                        Caixa.aCBrECF.abreRelatorioGerencial(Caixa.configuracao.getIndiceGerencialDAV());
                        Caixa.aCBrECF.linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);
                        Caixa.aCBrECF.linhaRelatorioGerencial("DAV EMITIDOS", 0);
                        Caixa.aCBrECF.linhaRelatorioGerencial("PERIODO: " + strDataIni + " A " + strDataFim, 0);
                        //TODO : Devemos configurar o numero de colunas do ECF?
                        Caixa.aCBrECF.linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);
                        Caixa.aCBrECF.linhaRelatorioGerencial("NUMERO      DATA EMISSAO TITULO       VALOR    ", 0);
                        Caixa.aCBrECF.linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);
                        for (int i = 0; i < listaDAV.size(); i++) {
                            numero = listaDAV.get(i).getNumeroDav() + "  ";
                            dataEmissao = listaDAV.get(i).getDataEmissao().toString() + "   ";
                            //TODO : Devemos configurar o titulo de cada DAV? Ou pelo menos deixar em aberto a configuração do titulo dos DAV (orçamento/pedido/etc)?
                            titulo = "ORCAMENTO ";
                            NumberFormat formatter = new DecimalFormat("0.00");
                            valor = formatter.format(listaDAV.get(i).getValor());
                            valor = Biblioteca.repete(" ", 13 - valor.length()) + valor;
                            Caixa.aCBrECF.linhaRelatorioGerencial(numero + dataEmissao + titulo + valor, 0);
                        }
                        Caixa.aCBrECF.linhaRelatorioGerencial(Biblioteca.repete("=", 48), 0);
                        Caixa.aCBrECF.fechaRelatorio();

                        //TODO : Está correta essa implementação para gravação do registro R06?
                        Paf.gravaR06("RG");
                        //TODO : Precisamos fazer alguma coisa em relacao ao registro R07?
                    } catch (Throwable t) {
                        t.printStackTrace();
                        JOptionPane.showMessageDialog(rootPane, t.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Não existe DAV para o período informado.", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

        //geração de arquivo
        if (radioArquivo.isSelected()) {
            String[] opcoes = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(null, "Deseja gerar o arquivo de DAV EMITIDOS?", "Pergunta do Sistema",
                    JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, opcoes, null);
            if (escolha == 0) {

                formataData = new SimpleDateFormat("yyyy-MM-dd");
                String strDataIni = formataData.format(dataIni);
                String strDataFim = formataData.format(dataFim);

                List<DAVCabecalhoVO> listaDAV = davControl.listaDAVPeriodo(strDataIni, strDataFim);
                if (listaDAV != null) {
                    formataData = new SimpleDateFormat("dd/MM/yyyy");
                    strDataIni = formataData.format(dataIni);
                    strDataFim = formataData.format(dataFim);
                    String comando =
                            System.getProperty("user.dir") + "\\binario\\binario.exe "
                            + "DAVEmitidos "
                            + Caixa.configuracao.getIdEmpresa() + " "
                            + "0 "
                            + "0 "
                            + Caixa.configuracao.getImpressoraVO().getId() + " "
                            + Caixa.configuracao.getPortaECF() + " "
                            + Caixa.configuracao.getTimeOutECF() + " "
                            + Caixa.configuracao.getIntervaloECF() + " "
                            + Caixa.configuracao.getImpressoraVO().getModeloACBr() + " "
                            + strDataIni + " "
                            + strDataFim;
                    try {
                        Process p = Runtime.getRuntime().exec(comando);
                        p.waitFor();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Não existe DAV para o período informado.", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
}
