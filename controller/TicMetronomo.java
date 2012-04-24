/*
 * prueba para metronomo listener
 * imprimirá cada 60 ms una letra de una cadena
 */

package controller;


/**
 *   Clase que escucha los eventos generados por los metronomos y
 *   los pinta en pantalla.
 *   Esta clase define un atributo "nombre" que se usa para identificar
 *   a los diferentes objetos Echo que se creen.
 *   @author TPRG
 */
    public class TicMetronomo implements MetronomoListener {

    /**
     * Identificador del objeto.
     */

    /**
     *  Construye un objeto, el cual se identificara con un nombre dado.
     *  @param nombre String que identificara al objeto.
     */
       public TicMetronomo() {

      }

    /**
     *  Metodo invocado por el Metronomo para pasar el evento a este objeto.
     *  Pinta en pantalla el nombre del objeto y el valor del evento.
     *  @param El evento generado por el metronomo.
     */
       public void tic(MetronomoEvent me) {
       //pendiente de llamada a una función que ejecute la siguiente jugada
      }
   }