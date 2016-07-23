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
public class QuickSort {

    public static int comparacoes, trocas;

    public static void ordenaVetor(int[] v, int esq, int dir) {
        if (dir > esq) {
            int q = dividir(v, esq, dir);
            ordenaVetor(v, esq, q - 1);
            ordenaVetor(v, q + 1, dir);
        }
        comparacoes++;
    }

    private static int dividir(int[] v, int esq, int dir) {
        int pivo = v[esq];
        int j = dir;
        int i = esq;
        while (i < j) {
            while (v[i] <= pivo && i < dir) {
                i++;
            }
            while (v[j] > pivo) {
                j--;
            }
            if (i < j) {
                int aux = v[i];
                v[i] = v[j];
                v[j] = aux;
                trocas++;
            }
            comparacoes++;
        }
        v[esq] = v[j];
        v[j] = pivo;
        trocas++;
        return j;
    }
}
