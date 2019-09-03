package com.t2tierp.sped.java;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <p>Title: T2Ti ERP
 * <p>Description:  VO relacionado a tabela [view_sped_i155]
 *
 * <p>The MIT License
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
//@Entity
//@Table(name = "view_sped_i155")
@Embeddable
public class ViewSpedI155VO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "MES_ANO")
    private String mesAno;
    @Basic(optional = false)
    @Column(name = "ID_CONTABIL_CONTA")
    private int idContabilConta;
    @Column(name = "CLASSIFICACAO")
    private String classificacao;
    @Column(name = "TIPO")
    private Character tipo;
    @Column(name = "SOMA_VALOR")
    private BigDecimal somaValor;

    public ViewSpedI155VO() {
    }

    public String getMesAno() {
        return mesAno;
    }

    public void setMesAno(String mesAno) {
        this.mesAno = mesAno;
    }

    public int getIdContabilConta() {
        return idContabilConta;
    }

    public void setIdContabilConta(int idContabilConta) {
        this.idContabilConta = idContabilConta;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getSomaValor() {
        return somaValor;
    }

    public void setSomaValor(BigDecimal somaValor) {
        this.somaValor = somaValor;
    }

}
