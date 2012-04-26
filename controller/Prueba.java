/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.Partida;
import controller.TicMetronomo;
import model.Metronomo;
import java.io.*;
import java.util.Scanner;
import model.Puzzle;
/**
 *
 * @author lolapriego
 */
public class Prueba {
     public static void main(String [] args){
       Scanner lector= new Scanner(System.in);
       int contador=0;
       Puzzle puzzle = leerPuzzle(contador);
       contador++;
       char opcion;
       Partida partida= new Partida(puzzle);



       Metronomo m1 = new Metronomo (1);
       System.out.println("Empieza la partida");
           do{
            System.out.println("Decida que funciones desea probar sobre este puzzle");
            System.out.println("7) Rendirse ver jugada ganadora");
            System.out.println("8) Leer otro puzzle");
            System.out.println("9) Salir del programa");
            opcion = lector.next().charAt(0);
            switch (opcion){
                case '7':
                 if(partida.partidaResuelta()){
                  TicMetronomo tic = new TicMetronomo(partida.getTraza());
                  m1.addMetronomoListener(tic);
                 }
                 else
                 System.out.println("NO tiene solución");
                opcion = '9';
                break;
                case '8':
                partida = new Partida(leerPuzzle(contador));
                contador++;
                break;
                case '9': break;
                default: System.out.println("Opci�n incorrecta, por favor seleccione una opci�n v�lida");
            }


    }while(opcion!='9' );


        }

        /**Lee cada vez un puzzle diferente
         *
         * @param int contador que decide que puzzle leer� de fichero
         *
         * @return Puzzle le�do de fichero
         */
        public static Puzzle leerPuzzle (int contador){
         Puzzle puzzle= new Puzzle();

          try{
       BufferedReader lector= new BufferedReader(new FileReader("fichero.txt"));

       for(int i=0;i< contador;i++)
       lector.readLine();
       String linea=lector.readLine();
       System.out.println("La cadena le�da de fichero es: " + linea + "    \nlos �ltimos datos son considerados como las filas y columnas");
       System.out.println("�sta genera el siguiente puzzle: ");
       int aux=linea.length()-1;
       puzzle = new Puzzle(linea.substring(0,aux-1),linea.charAt(aux-1)-'0',linea.charAt(aux)-'0');
       System.out.println(puzzle.toString());
       lector.close();

    }
       catch (Exception e){// ver si manejarlo de otra forma
           System.out.println(e);
        }
           return puzzle;
    }

}
