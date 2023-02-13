/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politecnicomalaga.primitiva;

/**
 *
 * @author mint
 */
public class Boleto {
    
    private byte[] boletoGanador;
    
    public Boleto(){
        boletoGanador = new byte[7];
        this.ganadora();
    }
    
    public void ganadora(){
        for(byte i = 0; i < boletoGanador.length; i++){
            boletoGanador[i] = (byte) (Math.random()*49+1); //Número random desde 1 a 49
            for(byte j=0; j < i; j++){
                if(boletoGanador[i] == boletoGanador[j]){
                    i--; //Compara el número random actual con el anterior, si son iguales vuelve a randomizar el número actual
                }
            }
        }
    }

    public byte comprobar(byte[] boletoIn){
        byte aciertos = 0;

        for(byte i=0; i < boletoIn.length; i++){
            for(byte j=0; j < boletoGanador.length - 1; j++){
                if(boletoIn[i] == boletoGanador[j]){
                    aciertos++; 
                }
            }
        }
        return aciertos;
    }

    public boolean comprobarComplementario(byte[] boletoIn){
        boolean complementario = false;

        for(byte i=0; i < boletoIn.length; i++){
            if(boletoIn[i] == boletoGanador[6]){
                complementario = true; 
            }
        }
        return complementario;
    }

    /*public byte[] getBoletoGanador(){
        return boletoGanador;
    }*/

    public String toString(){
        String cadena = "";
        
        for(byte i = 0; i<boletoGanador.length;i++){
            cadena += boletoGanador[i] + " ";
        }
        return cadena;
    }
}
