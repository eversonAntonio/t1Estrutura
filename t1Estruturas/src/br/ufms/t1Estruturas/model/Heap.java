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
public class Heap {
    
    public static void ordenaVetor(int[] v, int index){
        int maior;
        int i = obterFilhoEsquerda(index);
        int r = obterFilhoDireita(index);
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
