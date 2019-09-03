package com.t2tierp.sped.contabil.blocoj;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Classe que representa o registro J900 do sped contabil.</p>
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
public class RegistroJ900 implements Serializable {

    private static final long serialVersionUID = 1L;
    private String numOrd; /// Número de ordem do instrumento de escrituração.
    private String natLivro; /// Natureza do livro
    private String nome; /// Nome empresarial.
    private Integer qtdLin; /// Quantidade total de linhas do arquivo digital.
    private Date dtIniEscr; /// Data de inicio da escrituração.
    private Date dtFinEscr; /// Data de término da escrituração.

    /**
     * @return the numOrd
     */
    public String getNumOrd() {
        return numOrd;
    }

    /**
     * @param numOrd the numOrd to set
     */
    public void setNumOrd(String numOrd) {
        this.numOrd = numOrd;
    }

    /**
     * @return the natLivro
     */
    public String getNatLivro() {
        return natLivro;
    }

    /**
     * @param natLivro the natLivro to set
     */
    public void setNatLivro(String natLivro) {
        this.natLivro = natLivro;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the qtdLin
     */
    public Integer getQtdLin() {
        return qtdLin;
    }

    /**
     * @param qtdLin the qtdLin to set
     */
    public void setQtdLin(Integer qtdLin) {
        this.qtdLin = qtdLin;
    }

    /**
     * @return the dtIniEscr
     */
    public Date getDtIniEscr() {
        return dtIniEscr;
    }

    /**
     * @param dtIniEscr the dtIniEscr to set
     */
    public void setDtIniEscr(Date dtIniEscr) {
        this.dtIniEscr = dtIniEscr;
    }

    /**
     * @return the dtFinEscr
     */
    public Date getDtFinEscr() {
        return dtFinEscr;
    }

    /**
     * @param dtFinEscr the dtFinEscr to set
     */
    public void setDtFinEscr(Date dtFinEscr) {
        this.dtFinEscr = dtFinEscr;
    }
}
