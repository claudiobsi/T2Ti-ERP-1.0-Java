package com.t2tierp.cadastros.cliente;

import com.t2tierp.cadastros.java.SocioDependenteVO;
import com.t2tierp.cadastros.java.SocioParticipacaoSocietariaVO;
import com.t2tierp.padrao.java.Constantes;
import java.util.List;
import javax.swing.JOptionPane;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.client.ClientUtils;
import org.openswing.swing.util.java.Consts;

/**
* <p>Title: T2Ti ERP</p>
* <p>Description: Classe de controle da tela SocioDetalhe.</p>
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
public class SocioDetalheController extends FormController {

    private SocioDetalhe socioDetalhe = null;
    private String pk = null;
    private SocioGrid socioGrid = null;
    private String acaoServidor;

    public SocioDetalheController(SocioGrid socioGrid, String pk) {
        this.socioGrid = socioGrid;
        this.pk = pk;
        this.acaoServidor = "socioDetalheAction";
        socioDetalhe = new SocioDetalhe(this);
        socioDetalhe.setParentFrame(this.socioGrid);
        this.socioGrid.pushFrame(socioDetalhe);
        MDIFrame.add(socioDetalhe);

        if (pk != null) {
            socioDetalhe.getForm1().setMode(Consts.READONLY);
            socioDetalhe.getForm1().reload();
        } else {
            socioDetalhe.getForm1().setMode(Consts.INSERT);
            socioDetalhe.getGridControlDependentes().reloadData();
            socioDetalhe.getGridControlParticipacaoSocietaria().reloadData();
        }
    }

    @Override
    public Response loadData(Class valueObjectClass) {
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.LOAD, pk});
    }

    @Override
    public void loadDataCompleted(boolean error) {
        socioDetalhe.getDependenteController().setPk(pk);
        socioDetalhe.getGridControlDependentes().reloadData();

        socioDetalhe.getParticipacaoSocietariaController().setPk(pk);
        socioDetalhe.getGridControlParticipacaoSocietaria().reloadData();
    }

    @Override
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        List<SocioDependenteVO> dependentes = socioDetalhe.getGridControlDependentes().getVOListTableModel().getDataVector();
        List<SocioParticipacaoSocietariaVO> participacaoSocietaria = socioDetalhe.getGridControlParticipacaoSocietaria().getVOListTableModel().getDataVector();

        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.INSERT, newPersistentObject, dependentes, participacaoSocietaria});
    }

    @Override
    public void afterInsertData() {
        socioGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(socioDetalhe, "Dados salvos com sucesso!", "Informacao do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        List<SocioDependenteVO> dependentes = socioDetalhe.getGridControlDependentes().getVOListTableModel().getDataVector();
        List<SocioParticipacaoSocietariaVO> participacaoSocietaria = socioDetalhe.getGridControlParticipacaoSocietaria().getVOListTableModel().getDataVector();
        
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.UPDATE, oldPersistentObject, persistentObject, dependentes, participacaoSocietaria});
    }

    @Override
    public void afterEditData() {
        socioGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(socioDetalhe, "Dados alterados com sucesso!", "Informacao do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }
}
