/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.t1Estruturas.model;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author PC
 */
public class Vetor implements Serializable {

    private int tamanho;
    private int[] v;
    private boolean ordenado;

    public Vetor(int n) {
        int[] ve = new int[n];
        this.tamanho = n;
        preencheVetor(ve);
        this.v = ve;
    }

    private void preencheVetor(int[] vet) {
        Random gerador = new Random();
        for (int i = 0; i < vet.length; i++) {
            vet[i] = gerador.nextInt(1001);
        }
        this.setOrdenado(false);
    }

    public static String imprimeVetor(int[] vetor) {
        String t;
        t = "| ";
        int count = 1;
        int limite = 5;
        for (int i = 0; i < vetor.length - 1; i++) {
            t = t + vetor[i] + " | ";
            count++;
            if (count == limite) {
                count = 0;
                t = t + "\n|";
            }
        }
        t = t + vetor[vetor.length - 1] + " |";
        return t;
    }

    public static String buscaSequencial(int[] v, int valor) {
        String s = "BUSCA SEQUENCIAL";
        int ir = -1, x = 0;
        boolean continuar = true;
        while (x < v.length && continuar) {
            if (v[x] == valor) {
                ir = x + 1;
                continuar = false;
            } else {
                x++;
            }
        }
        if (ir != -1) {
            s += "\nIndice: " + ir + "\nValor: " + v[ir - 1] + "";
        } else {
            s += "\nValor não encontrado";
        }
        return s + "\n----------------------------------------\n";
    }

    public static String buscaBinaria(int[] v, int valor) {
        String s = "BUSCA BINÁRIA\n";
        s += "Em desenvolvimento...";
        return s + "\n----------------------------------------\n";
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

    /**
     * @return the ordenado
     */
    public boolean isOrdenado() {
        return ordenado;
    }

    /**
     * @param ordenado the ordenado to set
     */
    public void setOrdenado(boolean ordenado) {
        this.ordenado = ordenado;
    }

}
