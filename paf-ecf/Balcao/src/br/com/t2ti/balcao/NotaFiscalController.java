/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.t2ti.balcao;

import br.com.t2ti.principal.HibernateUtil;
import br.com.t2ti.vo.EcfConfiguracaoVO;
import br.com.t2ti.vo.EcfEmpresaVO;
import br.com.t2ti.vo.NotaFiscalCabecalhoVO;
import br.com.t2ti.vo.NotaFiscalDetalheVO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.java.Consts;

/**
 * <p>Title: T2Ti Balcao</p>
 * <p>Description: Classe controller da NF2.</p>
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
public class NotaFiscalController extends FormController {

    private NotaFiscalGrid grid;

    public NotaFiscalController() {
        grid = new NotaFiscalGrid(this);
        MDIFrame.add(grid);
        grid.getForm1().setMode(Consts.INSERT);
    }

    @Override
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        NotaFiscalCabecalhoVO notaFiscalCabecalho = (NotaFiscalCabecalhoVO) newPersistentObject;

        Calendar dataAtual = Calendar.getInstance();
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

        String horaAtual = formatoHora.format(dataAtual.getTime());

        BigDecimal valorTotal = BigDecimal.ZERO;
        List<NotaFiscalDetalheVO> listaNotaFiscalDetalhe = grid.getGrid1().getVOListTableModel().getDataVector();
        if (listaNotaFiscalDetalhe.isEmpty()) {
            return new ErrorResponse("Nenhum item na lista!");
        }
        for (int i = 0; i < listaNotaFiscalDetalhe.size(); i++) {
            if (listaNotaFiscalDetalhe.get(i).getCancelado() == null) {
                listaNotaFiscalDetalhe.get(i).setCancelado("N");
                valorTotal = valorTotal.add(listaNotaFiscalDetalhe.get(i).getValorTotal());
                valorTotal.setScale(2, RoundingMode.DOWN);
            }
        }
        notaFiscalCabecalho.setTotalNf(valorTotal);
        notaFiscalCabecalho.setDataEmissao(dataAtual.getTime());
        notaFiscalCabecalho.setHoraEmissao(horaAtual);
        notaFiscalCabecalho.setCancelada("N");
        notaFiscalCabecalho.setSincronizado("N");
        notaFiscalCabecalho.setTipoNota("2");
        notaFiscalCabecalho.setSerie("D");
        notaFiscalCabecalho.setSubserie("");
        notaFiscalCabecalho.setTaxaAcrescimo(BigDecimal.ZERO);
        notaFiscalCabecalho.setAcrescimo(BigDecimal.ZERO);
        notaFiscalCabecalho.setAcrescimoItens(BigDecimal.ZERO);
        notaFiscalCabecalho.setTaxaDesconto(BigDecimal.ZERO);
        notaFiscalCabecalho.setDesconto(BigDecimal.ZERO);
        notaFiscalCabecalho.setDescontoItens(BigDecimal.ZERO);


        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            String sql = "from br.com.t2ti.vo.EcfConfiguracaoVO";
            EcfConfiguracaoVO configuracao = (EcfConfiguracaoVO) session.createQuery(sql).uniqueResult();
            sql = "from br.com.t2ti.vo.EcfEmpresaVO";
            EcfEmpresaVO empresa = (EcfEmpresaVO) session.createQuery(sql).uniqueResult();

            if (notaFiscalCabecalho.getCliente().getUf().equals(empresa.getUf())) {
                notaFiscalCabecalho.setCfop(5102);
            } else {
                notaFiscalCabecalho.setCfop(configuracao.getCfopNf2());
            }

            session.save(notaFiscalCabecalho);

            NotaFiscalDetalheVO notaDetalhe;
            for (int i = 0; i < listaNotaFiscalDetalhe.size(); i++) {
                notaDetalhe = listaNotaFiscalDetalhe.get(i);

                notaDetalhe.setNotaFiscalCabecalho(notaFiscalCabecalho);
                notaDetalhe.setValorUnitario(notaDetalhe.getProduto().getValorVenda());
                notaDetalhe.setSincronizado("N");
                notaDetalhe.setTaxaIcms(notaDetalhe.getProduto().getTaxaIcms());
                notaDetalhe.setTaxaIssqn(notaDetalhe.getProduto().getTaxaIssqn());
                notaDetalhe.setTaxaPis(notaDetalhe.getProduto().getTaxaPis());
                notaDetalhe.setTaxaCofins(notaDetalhe.getProduto().getTaxaCofins());
                notaDetalhe.setTaxaIpi(notaDetalhe.getProduto().getTaxaIpi());
                notaDetalhe.setTaxaAcrescimo(BigDecimal.ZERO);
                notaDetalhe.setAcrescimo(BigDecimal.ZERO);
                notaDetalhe.setTaxaDesconto(BigDecimal.ZERO);
                notaDetalhe.setDesconto(BigDecimal.ZERO);
                notaDetalhe.setCfop(configuracao.getCfopNf2());
                notaDetalhe.setCst(notaDetalhe.getProduto().getCst());
                
                session.save(notaDetalhe);
            }

            session.getTransaction().commit();

            return new VOResponse(newPersistentObject);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return new ErrorResponse("Erro ao gravar a Nota Fiscal!");
        } finally {
            session.close();
        }
    }

    @Override
    public void afterInsertData() {
        JOptionPane.showMessageDialog(grid, "Nota Fiscal gravada com sucesso!");
        grid.dispose();
    }
}
