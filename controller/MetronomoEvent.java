/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;


/**
 *  Clase que define los eventos generados por los Metronomos.
 *
 * https://github.com/lolapriego/puzzle
 *  @author TPRG
 * modified for Mª Dolores Priego Porcuna y Daniel Caballero Bellot
 * @version X
 */
    public class MetronomoEvent {

    /**
     *  Entero que indica cual es el periodo del metronomo que genero el evento.
     *  Esta expresado en segundos.
     */
      private long periodo;

    /**
     *  Construye el objeto que describe el evento generado por el metronomo.
     *  @param periodo Indica cual es el periodo en segundos del metronomo generador.
     */
       public MetronomoEvent(long periodo) {
         this.periodo = periodo;
      }

    /**
     *  Devuelve el valor del atributo "periodo".
     *  @return El valor del atributo "periodo".
     */
       public long getPeriodo() {
         return periodo;
      }

   }