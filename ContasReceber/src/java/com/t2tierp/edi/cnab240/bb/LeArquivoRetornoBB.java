/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t2tierp.edi.cnab240.bb;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.jrimum.texgit.Record;

/**
 * <p>Title: T2Ti ERP</p>
 * <p>Description: Classe que le o arquivo de retorno CNAB240 do banco do brasil.</p>
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
public class LeArquivoRetornoBB extends AbstractFlatFile {

    public LeArquivoRetornoBB() {
        super("/com/t2tierp/edi/cnab240/bb/layout_cnab240_bb_retorno.xml");
    }

    public Collection<DetalheLoteSegmentoT> leArquivoRetorno(File arquivoRetorno) throws Exception {
        //busca as linhas do arquivo
        List<String> lines = FileUtils.readLines(arquivoRetorno, "UTF8");
        read(lines);
        //instancia os objetos
        Collection<Record> recordsT = getFlatFile().getRecords("DetalheLoteSegmentoT");

        Collection<DetalheLoteSegmentoT> listaSegmentoT = new ArrayList<DetalheLoteSegmentoT>();

        DetalheLoteSegmentoT segmentoT;
        DetalheLoteSegmentoU segmentoU;
        for (Iterator<Record> i = recordsT.iterator(); i.hasNext();) {
            segmentoT = new DetalheLoteSegmentoT(i.next());

            List<Record> listaSegmentoU = segmentoT.getRecord().getInnerRecords();
            segmentoU = new DetalheLoteSegmentoU(listaSegmentoU.get(0));

            segmentoT.setSegmentoU(segmentoU);

            listaSegmentoT.add(segmentoT);
        }

        return listaSegmentoT;
    }
}
