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
public class MergeSort {

    int[] vetor = {3, 2, 1, 6, 5, 4};
    int tamanho = vetor.length, divisao = tamanho / 2, aux = 0;

    static void ordenaVetor(int[] vetor) {
        int tamanho = vetor.length, divisao1 = tamanho / 2, aux = 0, divisao2 = tamanho - divisao1;
        for (int i = 0; i < divisao1; i++) {
            if (divisao1 > 1) {
                divisao1 = divisao1 / 2;
            }
        }

    }

//    void MergeSort(int[] vetor, int p, int r) {
//
//        if (p < r) {
//            int q = (int) (p + r) / 2;
//            MergeSort(vetor, p, q);
//
//            MergeSort(vetor, q + 1, r);
//            Merge(vetor, p, q, r);
//
//        }
//        void Merge
//        (int[] vetor, int p, int q, int r
//        
//            ){
//
//int[] vetor1 = q - p + 1;
//            int[] vetor2 = r - q;
//            for (int i = 1; i < vetor1.length; i++) {
//            L[i] = vetor[p + i - 1];
//        }
//            para i de 1 até n1 faça 
//            para j de 1 até n2 faça R[j] ← A[q + j];i ← j ← 1; L[n1 + 1] ← ∞;
//
//R[n2 + 1] 
//    
//
//        
//    
//
//← ∞;
}

//      for (int i = 0; i < divisao ;i++) {
//            if (vetor[i + 1] == null) {
//
//        }
//        if (i + 1 != divisao && vetor[i + 1] < vetor[i]) {
//            aux = vetor[i];
//            vetor[i] = vetor[i + 1];
//            vetor[i + 1] = aux;
//        }
//        System.out.println(vetor[i]);
