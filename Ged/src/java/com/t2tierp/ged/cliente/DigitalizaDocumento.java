/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t2tierp.ged.cliente;

import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import uk.co.mmscomputing.device.scanner.Scanner;
import uk.co.mmscomputing.device.scanner.ScannerIOException;
import uk.co.mmscomputing.device.scanner.ScannerIOMetadata;
import uk.co.mmscomputing.device.scanner.ScannerIOMetadata.Type;
import uk.co.mmscomputing.device.scanner.ScannerListener;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Classe responsavel por realizar a digitalizacao do documento.</p>
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
public class DigitalizaDocumento implements ScannerListener {

    BufferedImage image;

    public BufferedImage getDocumento() {

        Scanner scanner = Scanner.getDevice();
        if (scanner != null) {
            try {
                scanner.addListener(DigitalizaDocumento.this);
                scanner.acquire();
                while (image == null) {
                    Thread.sleep(100);
                }
            } catch (ScannerIOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao conectar ao dispositivo");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Acesso ao dispositivo interrompido");
            }
        }
        return image;
    }

    public void update(Type type, ScannerIOMetadata metadata) {
        if (type.equals(ScannerIOMetadata.ACQUIRED)) {
            image = metadata.getImage();
        }
    }
}

