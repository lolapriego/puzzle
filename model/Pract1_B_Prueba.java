package model;


/**
 * Prueba las clases Puzzle Partida y resuelvePartidas
 * Leer� de fichero los puzzles y para cada uno de ellos desarrollar� una partida
 * dando a opci�n al usuario de escoger sus movimientos o rendirse y ver el desarrollo
 * de la jugada ganadora (backtracking)
 * Habr� que ejecutar el programa con toda la memoria RAM que se pueda para evitar problemas con grandes dimensiones de puzzle
 * 
 * @author Daniel Caballero Bellot y M� Dolores Priego Porcuna 
 * @version 11/03/2012
 */

import java.io.*;
import java.util.Scanner;

public class Pract1_B_Prueba
{
    public static void main(String [] args){
       Scanner lector= new Scanner(System.in);
       int contador=0;
       Puzzle puzzle = leerPuzzle(contador);
       contador++;
       char opcion;
       Partida partida= new Partida(puzzle);
       System.out.println("Empieza la partida");
           do{
            System.out.println("Decida que funciones desea probar sobre este puzzle");
            System.out.println("1) Mover pieza en blanco hacia arriba");
            System.out.println("2) Mover pieza en blanco hacia abajo");
            System.out.println("3) Mover pieza en blanco hacia derecha");
            System.out.println("4) Mover pieza en blanco hacia izquierda"); 
            System.out.println("5) Ver puzzle resuelto");
            System.out.println("6) Deshacer jugada");
            System.out.println("7) Rendirse ver jugada ganadora");
            System.out.println("8) Leer otro puzzle");
            System.out.println("9) Salir del programa");
            opcion = lector.next().charAt(0);
            System.out.println("ok");
            switch (opcion){
                case '1':  
                    partida.mete(partida.getUltimaJugada().moverArriba());
                     System.out.println(partida);

                break;
                case '2':  
                    partida.mete(partida.getUltimaJugada().moverAbajo());
                    System.out.println(partida);

                break;
                case '3':
                    partida.mete(partida.getUltimaJugada().moverDerecha());
                     System.out.println(partida);
                    break;
                case '4':
                    partida.mete(partida.getUltimaJugada().moverIz());
                    System.out.println(partida);
                    break;
                case '5':
                    System.out.println(partida.getUltimaJugada().resuelto());
                    break;
                case '6': partida.deshacerMov();
                System.out.println(partida);
                break;
                case '7':
                 if(partida.partidaResuelta())
                  System.out.println(partida);
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