/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.t1Estruturas.model;

import java.io.Serializable;
import java.util.Random;
import javafx.scene.control.TextArea;

/**
 *
 * @author PC
 */
public class Vetor implements Serializable {
    
    private int tamanho;
    private int[] v;
    
    public Vetor(int n){
        int[] ve = new int[n];
        this.tamanho = n;
        preencheVetor(ve);
        this.v = ve;
    }
    
    private void preencheVetor(int[] vet){
        Random gerador = new Random();
        for (int i=0;i<vet.length;i++){
            vet[i] = gerador.nextInt(1001);
        }
    }
    
    public static void imprimeVetor(TextArea t, int[] vetor){
        t.setText("");
        for (int i=0;i<vetor.length;i++){
            t.setText(t.getText()+(i+1)+"|"+vetor[i]+"\n");
        }
    }

    /**
     * @return the tamanho
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * @return the v
     */
    public int[] getV() {
        return v;
    }

    /**
     * @param v the v to set
     */
    public void setV(int[] v) {
        this.v = v;
    }
    
}
