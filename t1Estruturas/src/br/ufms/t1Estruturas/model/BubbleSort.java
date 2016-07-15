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
public class BubbleSort {

    public static void ordenaVetor(int[] v) {
        int aux;
        for (int x = v.length - 1; x > 0; x--) {
            for (int y = 0; y < x; y++) {
                if (v[y] > v[y + 1]) {
                    aux = v[y];
                    v[y] = v[y + 1];
                    v[y + 1] = aux;
                }
            }
        }
    }

}
