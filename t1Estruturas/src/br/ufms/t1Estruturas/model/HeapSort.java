/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.t1Estruturas.model;

/**
 *
 * @author PC
 */
public class HeapSort {
    
    public static int comparacoes, trocas;

    private static void fazerHeap(int[] v, int tamanho, int index) {
        int maior, filho;
        filho = 2 * index + 1;
        maior = index;
        if (filho < tamanho) {
            if (v[filho] > v[maior]) {
                maior = filho;
            }
            comparacoes++;
        }
        comparacoes++;
        if (filho + 1 < tamanho) {
            if (v[filho + 1] > v[maior]) {
                maior = filho + 1;
            }
            comparacoes++;
        }
        comparacoes++;
        if (maior != index) {
            int aux = v[index];
            v[index] = v[maior];
            v[maior] = aux;
            fazerHeap(v, tamanho, maior);
            trocas++;
        }
        comparacoes++;
    }
    
    private static void constroiHeap(int[] v) {
        for (int i = v.length / 2 - 1; i >= 0; i--){
            fazerHeap(v, v.length, i);
        }
    }
    
    public static void ordenacaoHeap(int[] v) {
        constroiHeap(v);
        for (int i = v.length - 1; i >= 1; i--) {
            int aux = v[0];
            v[0] = v[i];
            v[i] = aux;
            fazerHeap(v, i, 0);
            trocas++;
        }
    }

}
