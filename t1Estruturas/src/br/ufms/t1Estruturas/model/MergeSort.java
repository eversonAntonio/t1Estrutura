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

    public static void mergeSort(int vetor[], int inicio, int fim) {
        
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            merge(vetor, inicio, meio, fim);
        }
    }

    private static void merge(int vetor[], int inicio, int meio, int fim) {
        int[] vet = new int[fim - inicio + 1];
        int i = inicio, j = meio + 1, k = 0;

        while (i <= meio && j <= fim) {
            if (vetor[i] <= vetor[j]) {
                vet[k] = vetor[i];
                k++;
                i++;
            } else {
                vet[k] = vetor[j];
                k++;
                j++;
            }
        }

        while (i <= meio) {
            vet[k] = vetor[i];
            k++;
            i++;
        }

        while (j <= fim) {
            vet[k] = vetor[j];
            k++;
            j++;
        }

        for (i = 0; i <= fim - inicio; i++) {
            vetor[inicio + i] = vet[i];
        }
    }
}
