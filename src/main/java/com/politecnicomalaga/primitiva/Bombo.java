/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politecnicomalaga.primitiva;

import java.util.Random;

/**
 *
 * @author mint
 */
public class Bombo {
    private int min, max;
    private boolean[] booleanNumeros;
    
    //constructor
    //sacarNum que devuelve un número que no pueda estar repetido y debe estar entre min y max
    
    public Bombo(int min, int max){
        this.min = min;
        this.max = max;
        booleanNumeros = new boolean[max-min+1];
    }

    public int sacarNum(){
        int numero, i = 0;
        Random r = new Random();
        
        numero = r.nextInt(max-min+1)+min; //Número random desde min a max.
        
        while(booleanNumeros[numero - min] == true){
            numero = r.nextInt(max-min+1)+min;
            if(i > (max-min+1)){
                return min-1;
            }
            i++;
        }
        if(booleanNumeros[numero - min] == false){
            i= 0;
            booleanNumeros[numero - min] = true;
            return numero;
        }
        return min-1;
    }
}
