/*
 * prueba para metronomo listener
 * imprimirá cada 60 ms una letra de una cadena
 */

package controller;

import model.Partida;
import java.util.ArrayList;
import java.util.Iterator;
import model.Puzzle;


/**
 *   Clase que escucha los eventos generados por los metronomos y
 *   los pinta en pantalla.
 *   Esta clase define un atributo "nombre" que se usa para identificar
 *   a los diferentes objetos Echo que se creen.
 *   @author TPRG
 */
    public class TicMetronomo implements MetronomoListener {
        private ArrayList<Puzzle> historia = new ArrayList<Puzzle>();
        private int contador;
    /**
     * Identificador del objeto.
     */

    /**
     *  Construye un objeto, el cual se identificara con un nombre dado.
     *  @param nombre String que identificara al objeto.
     */
       public TicMetronomo(ArrayList<Puzzle> historia) {
        this.historia = historia;
        this.contador = 0;
      }

    /**
     *  Metodo invocado por el Metronomo para pasar el evento a este objeto.
     *  Pinta en pantalla el nombre del objeto y el valor del evento.
     *  @param El evento generado por el metronomo.
     */
       public void tic(MetronomoEvent me) {
        if (contador < historia.size())
            System.out.println(historia.get(contador));
        contador++;
      }
   }