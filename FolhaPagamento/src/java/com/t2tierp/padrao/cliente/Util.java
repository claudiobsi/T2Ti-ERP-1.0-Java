/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t2tierp.padrao.cliente;

import java.text.ParseException;
import javax.swing.JFormattedTextField;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Classe que contém funções adicionais para o sistema.</p>
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
public class Util {

    public JFormattedTextField.AbstractFormatter formatoCpf() {
        return new JFormattedTextField.AbstractFormatter() {

            @Override
            public Object stringToValue(String text) throws ParseException {
                String str = text.replace(".", "");
                str = str.replace("-", "");
                return str;
            }

            @Override
            public String valueToString(Object value) throws ParseException {
                String str = (String) value;
                //TODO: implementar código para validação do CPF
                if (str.length() < 11) {
                    return null;
                }
                str = str.replace(".", "");
                str = str.replace("-", "");
                String strFormatado = str.substring(0, 3) + "."
                        + str.substring(3, 6) + "."
                        + str.substring(6, 9) + "-"
                        + str.substring(9, 11);

                return strFormatado;
            }
        };
    }

    public JFormattedTextField.AbstractFormatter formatoCnpj() {
        return new JFormattedTextField.AbstractFormatter() {

            @Override
            public Object stringToValue(String text) throws ParseException {
                String str = text.replace(".", "");
                str = str.replace("-", "");
                str = str.replace("/", "");
                return str;
            }

            @Override
            public String valueToString(Object value) throws ParseException {
                String str = (String) value;
                //TODO: implementar código para validação do CNPJ
                if (str.length() < 14) {
                    return null;
                }
                str = str.replace(".", "");
                str = str.replace("-", "");
                str = str.replace("/", "");
                String strFormatado = str.substring(0, 2) + "."
                        + str.substring(2, 5) + "."
                        + str.substring(5, 8) + "/"
                        + str.substring(8, 12) + "-"
                        + str.substring(12, 14);//10.793.118/0001-78

                return strFormatado;
            }
        };
    }
}