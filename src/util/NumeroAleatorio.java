/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Random;

/**
 *
 * @author vicente-jpro
 */
public class NumeroAleatorio {

    private int minimo;
    private int maximo;

    /**
     *
     * @param minimo > 0 
     * @param maximo < = 1 000 000 000
     */
    public NumeroAleatorio(int minimo, int maximo) {

        this.minimo = minimo;
        this.maximo = maximo;
    }

    public int getNumber() {

        int numero = 0;
        Random random = new Random();
        
        while (numero < minimo) {

            numero = random.nextInt(maximo);

        }

        return numero;
    }

}
