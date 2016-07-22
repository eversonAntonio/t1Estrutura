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

    public static void ordenarVetor(int[] vetor) {
        int[] arvore = new int[vetor.length];
        arvore[1] = vetor[0];
        int count = 0;
        int pai = 1;
        int paiAtual = 1;
        Inserir onde = Inserir.FILHO_ESQUERDA;
        while (count < vetor.length) {
            count++;
            if (pai == paiAtual) {
                arvore[obter(pai, onde)] = vetor[count];
            } else {
                arvore[obter(paiAtual, onde)] = vetor[count];
            }
            if (onde == Inserir.FILHO_DIREITA) {
                onde = Inserir.FILHO_ESQUERDA;
            } else {
                onde = Inserir.FILHO_DIREITA;
            }
        }
    }

    private static int obter(int index, Inserir onde) {
        switch (onde) {
            case FILHO_DIREITA:
                return obterFilhoDireita(index);
            case FILHO_ESQUERDA:
                return obterFilhoEsquerda(index);
            case PAI:
                return obterPai(index);
            default:
                return 0;
        }
    }

    private static int obterPai(int index) {
        return index / 2;
    }

    private static int obterFilhoEsquerda(int index) {
        return 2 * index;
    }

    private static int obterFilhoDireita(int index) {
        return 2 * index + 1;
    }

}
