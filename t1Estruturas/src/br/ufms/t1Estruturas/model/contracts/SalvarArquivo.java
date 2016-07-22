/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.t1Estruturas.model.contracts;

import br.ufms.t1Estruturas.model.Vetor;
import java.io.IOException;

/**
 *
 * @author PC
 */
public interface SalvarArquivo {
    
    public void salvar(String caminho, String nomeArquivo, String texto) throws IOException;
    
}
