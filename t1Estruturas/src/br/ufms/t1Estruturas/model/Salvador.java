/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.t1Estruturas.model;

import br.ufms.t1Estruturas.model.contracts.SalvarArquivo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author PC
 */
public class Salvador implements SalvarArquivo {

    @Override
    public void salvar(String caminho, String nomeArquivo, String texto) throws IOException{
        File f = new File(caminho);
        f.mkdir();
        String salvar = f.toString() + "\\" + nomeArquivo;
        FileWriter arq = new FileWriter(salvar);
        PrintWriter gravararq = new PrintWriter(arq);
        gravararq.write(texto);
        gravararq.close();
    }

}
