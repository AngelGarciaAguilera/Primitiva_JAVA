/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.politecnicomalaga.primitiva;

//import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mint
 */
public class Primitiva {

    public static void main(String[] args) {
        
        Boleto ganador = new Boleto();
        byte[] boletoIn = new byte[6];
        Scanner sc = new Scanner(System.in);

        String opcion;
        boolean menu = true;
        byte numero;
        boolean repetido = false;
        boolean incorrecto = false;
        
        
        
        while(menu){
            System.out.println("-------------------------------------------------");
            System.out.println("");
            System.out.println("OPCIONES:");
            System.out.println("1. Sortear de nuevo.");
            System.out.println("2. Introducir boleto.");
            System.out.println("3. Comprobar boleto.");
            System.out.println("4. Comprobar complementario.");
            System.out.println("5. Obtener números aleatorios entre un intervalo.");
            System.out.println("Otra tecla: SALIR.");
            System.out.println("");
            System.out.println("-------------------------------------------------");
            System.out.println("Escoja la tarea a realizar:");
            
            opcion = sc.next();
            sc.reset();
            
            System.out.println("-------------------------------------------------");
            
            switch (opcion) {
                case "1":
                    ganador.ganadora();
                    System.out.println("El sorteo ha sido realizado con éxito.");
                    break;//LISTO
                    
                case "2":
                    System.out.println("A continuación, introduzca su boleto para, posteriormente, compararlo con el boleto ganador.");
                    System.out.println("");

                    for(byte i=0; i < boletoIn.length; i++){
                        do{
                            incorrecto = false;
                            System.out.println("Introduce el " + (i+1) + "º número de tu boleto.");
                            numero = sc.nextByte();

                            for(byte j=0; j < i; j++){
                                if(numero == boletoIn[j]){
                                    repetido = true;
                                }
                            }
                            
                            if(numero < 1 || numero > 49){
                                System.out.println("El número introducido debe estar entre 1 y 49. Vuelva a introducirlo.");
                                incorrecto = true;
                            }else if(repetido){
                                System.out.println("El número introducido está repetido. Vuelva a introducirlo.");
                                incorrecto = true;
                            }
                            else{
                                boletoIn[i] = numero;
                            }
                            repetido = false;
                        }while(incorrecto);
                    }

                break;//LISTO

                case "3":
                    System.out.println("Tu boleto es: " + boletoIn[0] + " " + boletoIn[1] + " " + boletoIn[2] + " " + boletoIn[3] + " " + boletoIn[4] + " " + boletoIn[5]);
                    //System.out.println("El boleto ganador es: " + Arrays.toString(ganador.getBoletoGanador()));
                    System.out.println("El boleto ganador es: " + ganador.toString());
                    System.out.println("");

                    if(ganador.comprobar(boletoIn) == 0){
                        System.out.println("Tu boleto no tiene ningún acierto.");
                    }else if(ganador.comprobar(boletoIn) == 0 && ganador.comprobarComplementario(boletoIn)){
                        System.out.println("Tu boleto no tiene ningún acierto más el complementario.");
                    }else if(ganador.comprobar(boletoIn) == 1){
                        System.out.println("Tu boleto tiene un acierto.");
                    }else if(ganador.comprobar(boletoIn) == 1 && ganador.comprobarComplementario(boletoIn)){
                        System.out.println("Tu boleto tiene un acierto más el complementario.");
                    }else if(ganador.comprobar(boletoIn) == 2){
                        System.out.println("Tu boleto tiene dos aciertos.");
                    }else if(ganador.comprobar(boletoIn) == 2 && ganador.comprobarComplementario(boletoIn)){
                        System.out.println("Tu boleto tiene dos aciertos más el complementario.");
                    }else if(ganador.comprobar(boletoIn) == 3){
                        System.out.println("Tu boleto tiene tres aciertos.");
                    }else if(ganador.comprobar(boletoIn) == 3 && ganador.comprobarComplementario(boletoIn)){
                        System.out.println("Tu boleto tiene tres aciertos más el complementario.");
                    }else if(ganador.comprobar(boletoIn) == 4){
                        System.out.println("Tu boleto tiene cuatro aciertos.");
                    }else if(ganador.comprobar(boletoIn) == 4 && ganador.comprobarComplementario(boletoIn)){
                        System.out.println("Tu boleto tiene cuatro aciertos más el complementario.");
                    }else if(ganador.comprobar(boletoIn) == 5){
                        System.out.println("Tu boleto tiene cinco aciertos.");
                    }else if(ganador.comprobar(boletoIn) == 5 && ganador.comprobarComplementario(boletoIn)){
                        System.out.println("Tu boleto tiene cinco aciertos más el complementario.");
                    }else if(ganador.comprobar(boletoIn) == 6){
                        System.out.println("Tu boleto tiene seis aciertos.");
                    }

                    break;//LISTO
                    
                case "4":
                    if(ganador.comprobarComplementario(boletoIn)){
                        System.out.println("El número complementario se encuentra en tu boleto.");
                    }else{
                        System.out.println("El número complementario no se encuentra en tu boleto.");
                    }
                    
                    break;//LISTO

                case "5":
                    int min, max;
                    String otra;
                    int numerobombo;
                    boolean sigo = true;
                    
                    System.out.println("Introduzca un mínimo:");
                    min = sc.nextInt();
                    sc.reset();
                    System.out.println("Introduzca un máximo:");
                    max = sc.nextInt();
                    sc.reset();
                    Bombo numAl = new Bombo(min, max);
                    
                    System.out.println("-------------------------------------------------");
                    System.out.println("Se genera un número aleatorio del intervalo introducido. Cuando el número obtenido sea menor que el número mínimo del intervalo, ya habrán aparecido todos los números pertenecientes a este.");
                    
                    do{
                        System.out.println("Introduzca S para otra bola");
                        otra = sc.next();
                        sc.reset();
                        if("S".equals(otra)){
                            numerobombo = numAl.sacarNum();
                            System.out.println(numerobombo);
                        }else{
                            System.out.println("Programa finalizado.");
                            sigo = false;
                        }
                    }while(sigo);
                    break;
                    
                default:
                    sc.close(); //Cierro la entrada de teclado.
                    menu = false;
                    break;
            }
        }
    }
}
