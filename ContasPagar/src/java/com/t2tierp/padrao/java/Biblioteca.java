package com.t2tierp.padrao.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.text.ParseException;
import java.util.Calendar;
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
public class Biblioteca {

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

    public static void copiaArquivo(String origem, String destino) throws Exception {
        FileInputStream in = new FileInputStream(origem);
        FileOutputStream out = new FileOutputStream(destino);
        byte[] bb = new byte[in.available()];
        in.read(bb);
        out.write(bb);
        out.close();
    }

    public static String md5Arquivo(String nomeArquivo) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        File f = new File(nomeArquivo);
        InputStream is = null;
        try {
            is = new FileInputStream(f);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        byte[] buffer = new byte[8192];
        int read = 0;
        try {
            while ((read = is.read(buffer)) > 0) {
                digest.update(buffer, 0, read);
            }
            byte[] md5sum = digest.digest();
            BigInteger bigInt = new BigInteger(1, md5sum);
            String output = bigInt.toString(16);
            return output;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] geraAssinaturaArquivo(byte[] arquivoAssinar, File arquivoCertificado, char[] senha) {
        try {
            //Carrega o KeyStore
            KeyStore ks = KeyStore.getInstance("PKCS12");
            InputStream isCertificado = new FileInputStream(arquivoCertificado);
            ks.load(isCertificado, senha);

            //pega a chave privada
            Key key = ks.getKey(ks.aliases().nextElement(), senha);
            PrivateKey privateKey = (PrivateKey) key;

            //cria o objeto Signature infomando o algoritmo de assinatura
            //http://docs.oracle.com/javase/6/docs/technotes/guides/security/StandardNames.html
            Signature sign = Signature.getInstance("SHA1withRSA");
            sign.initSign(privateKey);

            sign.update(arquivoAssinar);

            //gera a assinatura
            byte[] assinatura = sign.sign();

            return assinatura;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Verifica se a data informada e valida
     *
     * @param dia, mes e ano
     * @return  true se a data for valida, caso contrario false
     */
    public static boolean validaData(int dia, int mes, int ano) {
        try {
            Calendar dataValidar = Calendar.getInstance();
            dataValidar.setLenient(false);
            dataValidar.set(Calendar.DAY_OF_MONTH, dia);
            dataValidar.set(Calendar.MONTH, mes);
            dataValidar.set(Calendar.YEAR, ano);
            dataValidar.getTime();
            return true;
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return false;
    }

    /**
     * Verifica se a hora informada e valida
     *
     * @param hora, minuto e segundo
     * @return  true se a hora for valida, caso contrario false
     */
    public static boolean validaHora(int hora, int minuto, int segundo) {
        try {
            Calendar dataValidar = Calendar.getInstance();
            dataValidar.setLenient(false);
            dataValidar.set(Calendar.HOUR_OF_DAY, hora);
            dataValidar.set(Calendar.MINUTE, minuto);
            dataValidar.set(Calendar.SECOND, segundo);
            dataValidar.getTime();
            return true;
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return false;
    }

    /**
     * Oobtem a hora do dia em segundos
     *
     * @param dataMarcacao
     * @return  int - hora do dia em segundos
     */
    public static int getHoraSeg(Calendar dataMarcacao) {
        int segundos = dataMarcacao.get(Calendar.SECOND);
        segundos += dataMarcacao.get(Calendar.MINUTE) * 60;
        segundos += dataMarcacao.get(Calendar.HOUR_OF_DAY) * 3600;
        return segundos;
    }

    /**
     * Converte segundos para horas:minutos:segundos
     *
     * @param segundos
     * @return  String no formato HH:mm:ss
     */
    public static String getHoraMinutoSegundo(int segundos) {
        Calendar dataC = Calendar.getInstance();
        dataC.set(Calendar.HOUR_OF_DAY, 0);
        dataC.set(Calendar.MINUTE, 0);
        dataC.set(Calendar.SECOND, 0);

        dataC.add(Calendar.SECOND, segundos);

        String resultado = dataC.get(Calendar.HOUR_OF_DAY) < 10
                ? "0" + dataC.get(Calendar.HOUR_OF_DAY)
                : "" + dataC.get(Calendar.HOUR_OF_DAY);
        resultado += ":";
        resultado += dataC.get(Calendar.MINUTE) < 10
                ? "0" + dataC.get(Calendar.MINUTE)
                : "" + dataC.get(Calendar.MINUTE);
        resultado += ":";
        resultado += dataC.get(Calendar.SECOND) < 10
                ? "0" + dataC.get(Calendar.SECOND)
                : "" + dataC.get(Calendar.SECOND);

        return resultado;
    }

    /**
     * Converte a hora de String para Calendar
     *
     * @param horas no formato HH:mm:ss
     * @return  Calendar
     */
    public static Calendar horaStrToCalendar(String horas) {
        Calendar dataC = Calendar.getInstance();
        dataC.set(Calendar.HOUR_OF_DAY, Integer.valueOf(horas.substring(0, 2)));
        dataC.set(Calendar.MINUTE, Integer.valueOf(horas.substring(3, 5)));
        dataC.set(Calendar.SECOND, Integer.valueOf(horas.substring(6, 8)));

        return dataC;
    }

}
