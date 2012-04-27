package controller;

import model.Partida;
import java.util.ArrayList;
import java.util.Iterator;
import model.Puzzle;
import view.SlidePuzzleGUI;
import controller.NewGameAction;


/**
 *   Clase que escucha los eventos generados por los metronomos y
 *   los pinta en pantalla.
 *   Esta clase define un atributo "nombre" que se usa para identificar
 *   a los diferentes objetos Echo que se creen.
 *   @author TPRG
 */
    public class Ticc implements MetronomoListener {
        private int estado;
        private NewGameAction gma;
    /**
     * Identificador del objeto.
     */

    /**
     *  Construye un objeto, el cual se identificara con un nombre dado.
     *  @param nombre String que identificara al objeto.
     */
       public Ticc(int estado, NewGameAction gma) {
        this.estado = estado;
        this.gma = gma;
      }

    /**
     *  Metodo invocado por el Metronomo para pasar el evento a este objeto.
     *  Pinta en pantalla el nombre del objeto y el valor del evento.
     *  @param El evento generado por el metronomo.
     */
       public void tic(MetronomoEvent me) {

        System.out.println(estado);
        estado = gma.getEstado();
      }
   }