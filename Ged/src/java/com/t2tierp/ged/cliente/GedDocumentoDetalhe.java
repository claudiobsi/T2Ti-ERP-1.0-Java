package com.t2tierp.ged.cliente;

import com.t2tierp.ged.java.ArquivoVO;
import com.t2tierp.padrao.cliente.LookupDataLocatorGenerico;
import com.t2tierp.padrao.cliente.Util;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.openswing.swing.client.GenericButton;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.mdi.client.InternalFrame;
import org.openswing.swing.util.client.ClientUtils;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Tela GedDocumentoDetalhe.</p>
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
public class GedDocumentoDetalhe extends InternalFrame {

    private GedDocumentoDetalheController controller;
    private LookupController tipoDocumentoController = new LookupController();

    public GedDocumentoDetalhe(GedDocumentoDetalheController controller) {
        initComponents();

        btDigitalizar.setToolTipText("Digitalizar Documento");
        btDownloadDocumento.setToolTipText("Download do Documento");
        btSelecionaArquivo.setToolTipText("Selecionar Arquivo para Armazenamento");
        btVisualizaDocumento.setToolTipText("Visualizar Documento");

        this.controller = controller;
        form1.setFormController(this.controller);

        /*
         * Configurações do lookup do tipo de documento
         */
        tipoDocumentoController.setLookupValueObjectClassName("com.t2tierp.ged.java.GedTipoDocumentoVO");
        tipoDocumentoController.addLookup2ParentLink("id", "gedTipoDocumento.id");
        tipoDocumentoController.addLookup2ParentLink("nome", "gedTipoDocumento.nome");
        tipoDocumentoController.addLookup2ParentLink("tamanhoMaximo", "gedTipoDocumento.tamanhoMaximo");
        tipoDocumentoController.setPreferredWidthColumn("nome", 200);
        tipoDocumentoController.setPreferredWidthColumn("tamanhoMaximo", 200);
        tipoDocumentoController.setHeaderColumnName("nome", "Tipo Documento");
        tipoDocumentoController.setHeaderColumnName("tamanhoMaximo", "Tamanho Máximo(MB)");
        tipoDocumentoController.setFrameTitle("Tipo de Documento");

        tipoDocumentoController.setVisibleStatusPanel(true);
        tipoDocumentoController.setVisibleColumn("nome", true);
        tipoDocumentoController.setVisibleColumn("tamanhoMaximo", true);
        tipoDocumentoController.setFramePreferedSize(new Dimension(600, 500));

        tipoDocumentoController.setLookupDataLocator(new LookupDataLocatorGenerico(tipoDocumentoController.getLookupValueObjectClassName()));
        codLookupControl3.setLookupController(tipoDocumentoController);
    }

    /**
     * @return the form1
     */
    public org.openswing.swing.form.client.Form getForm1() {
        return form1;
    }

    private void visualizaDocumento() {
        if (!txtArquivoSelecionado.getText().equals("")) {
            try {
                ClientUtils.displayURL(txtArquivoSelecionado.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao abrir o arquivo!\n" + e.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void downloadDocumento() {
        if (!txtArquivoSelecionado.getText().equals("")) {
            try {
                JFileChooser file = new JFileChooser();
                file.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int resposta = file.showSaveDialog(this);
                if (resposta == JFileChooser.APPROVE_OPTION) {
                    String copia = file.getSelectedFile().getAbsolutePath();
                    String original = txtArquivoSelecionado.getText();
                    if (!copia.endsWith(getExtensaoArquivo())) {
                        copia += getExtensaoArquivo();
                    }
                    Util.copiaArquivo(original, copia);
                    JOptionPane.showMessageDialog(this, "Arquivo salvo com sucesso!", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao salvar o arquivo!\n" + e.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void selecionaDocumento() {
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int resposta = file.showOpenDialog(this);

        if (resposta == JFileChooser.APPROVE_OPTION) {
            txtArquivoSelecionado.setText(file.getSelectedFile().getAbsolutePath());

            //tenta carregar a imagem no imagePanel
            try {
                imgDigitalizada.setImage(ImageIO.read(file.getSelectedFile()));
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
    }

    private void digitalizaDocumento() {
        try {
            btDigitalizar.setEnabled(false);
            DigitalizaDocumento dd;
            dd = new DigitalizaDocumento();
            BufferedImage documento = dd.getDocumento();
            //converte a imagem digitalizada em bytes
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(documento, "jpg", baos);
            byte[] bytesOut = baos.toByteArray();
            //seta a imagem no imagePanel
            imgDigitalizada.setImage(bytesOut);
            btDigitalizar.setEnabled(true);
            txtArquivoSelecionado.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizaDocumento(ArquivoVO arquivoVO) {
        if (arquivoVO != null) {
            if (arquivoVO.getFile() != null) {
                try {
                    File file = File.createTempFile(arquivoVO.getHash(), arquivoVO.getExtensao());
                    file.deleteOnExit();
                    String nomeArquivo = file.getAbsolutePath();
                    FileOutputStream out = new FileOutputStream(nomeArquivo);
                    byte[] bb = arquivoVO.getFile();
                    out.write(bb);
                    out.close();
                    txtArquivoSelecionado.setText(nomeArquivo);
                    //se for uma imagem será carregada no imagePanel
                    imgDigitalizada.setImage(ImageIO.read(file));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public byte[] getDocumentoSelecionado() {
        byte[] documento = null;
        try {
            if (!txtArquivoSelecionado.getText().equals("")) {
                File arquivo = new File(txtArquivoSelecionado.getText());
                //converte o arquio em array de bytes
                InputStream is = new FileInputStream(arquivo);
                // Get the size of the file
                long length = arquivo.length();
                // Create the byte array to hold the data
                documento = new byte[(int) length];
                // Read in the bytes
                int offset = 0;
                int numRead = 0;
                while (offset < documento.length
                        && (numRead = is.read(documento, offset, documento.length - offset)) >= 0) {
                    offset += numRead;
                }
                // Ensure all the bytes have been read in
                if (offset < documento.length) {
                    throw new IOException("Could not completely read file " + arquivo.getName());
                }
                // Close the input stream and return bytes
                is.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return documento;
    }

    public String getExtensaoArquivo() {
        if (!txtArquivoSelecionado.getText().equals("")) {
            String nomeArquivo = txtArquivoSelecionado.getText();
            int indiceExtensao = nomeArquivo.lastIndexOf(".");
            if (indiceExtensao > -1) {
                return nomeArquivo.substring(indiceExtensao, nomeArquivo.length());
            }
        }
        return "";
    }

    public byte[] getImagem() {
        byte[] imagem = null;
        try {
            if (imgDigitalizada.getImage() != null) {
                imagem = imgDigitalizada.getImage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imagem;
    }

    public String getHashDocumento() {
        if (!txtArquivoSelecionado.getText().equals("")) {
            //retorna o hash do arquivo selecionado
            return Util.md5Arquivo(txtArquivoSelecionado.getText());
        } else {
            try {
                //retorna o hash da imagem digitalizada
                String nomeArquivo = System.getProperty("user.home") + System.getProperty("file.separator") + "imagemDigitalizada.jpg";
                File file = new File(nomeArquivo);
                file.createNewFile();
                FileOutputStream out = new FileOutputStream(nomeArquivo);
                byte[] bb = imgDigitalizada.getImage();
                out.write(bb);
                out.close();
                return Util.md5Arquivo(nomeArquivo);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
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
        deleteButton1 = new org.openswing.swing.client.DeleteButton();
        saveButton1 = new org.openswing.swing.client.SaveButton();
        btVisualizaDocumento = new GenericButton(new ImageIcon(ClientUtils.getImage("visualizar.png")));
        btDownloadDocumento = new GenericButton(new ImageIcon(ClientUtils.getImage("download.png")));
        btSelecionaArquivo = new GenericButton(new ImageIcon(ClientUtils.getImage("open.png")));
        btDigitalizar = new GenericButton(new ImageIcon(ClientUtils.getImage("scanner.png")));
        form1 = new org.openswing.swing.form.client.Form();
        labelControl1 = new org.openswing.swing.client.LabelControl();
        codLookupControl3 = new org.openswing.swing.client.CodLookupControl();
        textControl3 = new org.openswing.swing.client.TextControl();
        labelControl3 = new org.openswing.swing.client.LabelControl();
        textControl4 = new org.openswing.swing.client.TextControl();
        labelControl4 = new org.openswing.swing.client.LabelControl();
        textControl5 = new org.openswing.swing.client.TextControl();
        labelControl5 = new org.openswing.swing.client.LabelControl();
        textControl6 = new org.openswing.swing.client.TextControl();
        labelControl6 = new org.openswing.swing.client.LabelControl();
        comboBoxControl7 = new org.openswing.swing.client.ComboBoxControl();
        labelControl7 = new org.openswing.swing.client.LabelControl();
        comboBoxControl8 = new org.openswing.swing.client.ComboBoxControl();
        labelControl8 = new org.openswing.swing.client.LabelControl();
        comboBoxControl9 = new org.openswing.swing.client.ComboBoxControl();
        labelControl9 = new org.openswing.swing.client.LabelControl();
        dateControl10 = new org.openswing.swing.client.DateControl();
        jPanel2 = new javax.swing.JPanel();
        txtArquivoSelecionado = new javax.swing.JTextField();
        labelControl11 = new org.openswing.swing.client.LabelControl();
        imgDigitalizada = new org.openswing.swing.client.ImagePanel();

        setTitle("T2Ti ERP - GED - Gestão Eletrônica de Documentos");
        setPreferredSize(new java.awt.Dimension(700, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ged Documento"));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel1.add(editButton1);
        jPanel1.add(reloadButton1);
        jPanel1.add(deleteButton1);
        jPanel1.add(saveButton1);

        btVisualizaDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVisualizaDocumentoActionPerformed(evt);
            }
        });
        jPanel1.add(btVisualizaDocumento);

        btDownloadDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDownloadDocumentoActionPerformed(evt);
            }
        });
        jPanel1.add(btDownloadDocumento);

        btSelecionaArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionaArquivoActionPerformed(evt);
            }
        });
        jPanel1.add(btSelecionaArquivo);

        btDigitalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDigitalizarActionPerformed(evt);
            }
        });
        jPanel1.add(btDigitalizar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        form1.setVOClassName("com.t2tierp.ged.java.GedDocumentoVO");
        form1.setDeleteButton(deleteButton1);
        form1.setEditButton(editButton1);
        form1.setFunctionId("gedDocumento");
        form1.setReloadButton(reloadButton1);
        form1.setSaveButton(saveButton1);
        form1.setLayout(new java.awt.GridBagLayout());

        labelControl1.setText("Tipo Documento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl1, gridBagConstraints);

        codLookupControl3.setAllowOnlyNumbers(true);
        codLookupControl3.setAttributeName("gedTipoDocumento.id");
        codLookupControl3.setEnabled(false);
        codLookupControl3.setLinkLabel(labelControl1);
        codLookupControl3.setMaxCharacters(10);
        codLookupControl3.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -50;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(codLookupControl3, gridBagConstraints);

        textControl3.setAttributeName("gedTipoDocumento.nome");
        textControl3.setEnabled(false);
        textControl3.setEnabledOnEdit(false);
        textControl3.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl3, gridBagConstraints);

        labelControl3.setLabel("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl3, gridBagConstraints);

        textControl4.setAttributeName("nome");
        textControl4.setEnabled(false);
        textControl4.setLinkLabel(labelControl3);
        textControl4.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl4, gridBagConstraints);

        labelControl4.setLabel("Descricao:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl4, gridBagConstraints);

        textControl5.setAttributeName("descricao");
        textControl5.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl5, gridBagConstraints);

        labelControl5.setText("Palavra Chave:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl5, gridBagConstraints);

        textControl6.setAttributeName("palavraChave");
        textControl6.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(textControl6, gridBagConstraints);

        labelControl6.setLabel("Pode Excluir:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl6, gridBagConstraints);

        comboBoxControl7.setAttributeName("podeExcluir");
        comboBoxControl7.setDomainId("simnao");
        comboBoxControl7.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(comboBoxControl7, gridBagConstraints);

        labelControl7.setLabel("Pode Alterar:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl7, gridBagConstraints);

        comboBoxControl8.setAttributeName("podeAlterar");
        comboBoxControl8.setDomainId("simnao");
        comboBoxControl8.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(comboBoxControl8, gridBagConstraints);

        labelControl8.setLabel("Assinado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl8, gridBagConstraints);

        comboBoxControl9.setAttributeName("assinado");
        comboBoxControl9.setDomainId("simnao");
        comboBoxControl9.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(comboBoxControl9, gridBagConstraints);

        labelControl9.setLabel("Data Fim Vigencia:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        form1.add(labelControl9, gridBagConstraints);

        dateControl10.setAttributeName("dataFimVigencia");
        dateControl10.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        form1.add(dateControl10, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(form1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        txtArquivoSelecionado.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel2.add(txtArquivoSelecionado, gridBagConstraints);

        labelControl11.setText("Arquivo Selecionado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel2.add(labelControl11, gridBagConstraints);

        imgDigitalizada.setAutoscrolls(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(imgDigitalizada, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVisualizaDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVisualizaDocumentoActionPerformed
        visualizaDocumento();
    }//GEN-LAST:event_btVisualizaDocumentoActionPerformed

    private void btDownloadDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDownloadDocumentoActionPerformed
        downloadDocumento();
    }//GEN-LAST:event_btDownloadDocumentoActionPerformed

    private void btSelecionaArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionaArquivoActionPerformed
        selecionaDocumento();
    }//GEN-LAST:event_btSelecionaArquivoActionPerformed

    private void btDigitalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDigitalizarActionPerformed
        digitalizaDocumento();
    }//GEN-LAST:event_btDigitalizarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.client.GenericButton btDigitalizar;
    private org.openswing.swing.client.GenericButton btDownloadDocumento;
    private org.openswing.swing.client.GenericButton btSelecionaArquivo;
    private org.openswing.swing.client.GenericButton btVisualizaDocumento;
    private org.openswing.swing.client.CodLookupControl codLookupControl3;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl7;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl8;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl9;
    private org.openswing.swing.client.DateControl dateControl10;
    private org.openswing.swing.client.DeleteButton deleteButton1;
    private org.openswing.swing.client.EditButton editButton1;
    private org.openswing.swing.form.client.Form form1;
    private org.openswing.swing.client.ImagePanel imgDigitalizada;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private org.openswing.swing.client.LabelControl labelControl1;
    private org.openswing.swing.client.LabelControl labelControl11;
    private org.openswing.swing.client.LabelControl labelControl3;
    private org.openswing.swing.client.LabelControl labelControl4;
    private org.openswing.swing.client.LabelControl labelControl5;
    private org.openswing.swing.client.LabelControl labelControl6;
    private org.openswing.swing.client.LabelControl labelControl7;
    private org.openswing.swing.client.LabelControl labelControl8;
    private org.openswing.swing.client.LabelControl labelControl9;
    private org.openswing.swing.client.ReloadButton reloadButton1;
    private org.openswing.swing.client.SaveButton saveButton1;
    private org.openswing.swing.client.TextControl textControl3;
    private org.openswing.swing.client.TextControl textControl4;
    private org.openswing.swing.client.TextControl textControl5;
    private org.openswing.swing.client.TextControl textControl6;
    private javax.swing.JTextField txtArquivoSelecionado;
    // End of variables declaration//GEN-END:variables
}
