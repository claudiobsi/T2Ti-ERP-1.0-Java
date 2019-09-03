package com.t2tierp.controleestoque.servidor;

import java.math.BigDecimal;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Action ControleEstoque.</p>
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
public class ControleEstoqueAction {

    public static void atualizaEstoque(Session session, Integer idProduto, BigDecimal quantidade) throws Exception {
        //atualiza tabela PRODUTO
        String sql = "update PRODUTO set QUANTIDADE_ESTOQUE = QUANTIDADE_ESTOQUE + " + quantidade
                + " where ID = :id";
        Query query = session.createSQLQuery(sql);
        query.setInteger("id", idProduto);
        query.executeUpdate();

      //atualiza tabela PRODUTO_LOTE
      /*
        Cada participante deve avaliar como atualizar essa tabela de acordo com sua necessidade.
      */
    }
}
