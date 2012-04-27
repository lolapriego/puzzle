

package model;

import controller.MetronomoEvent;
import controller.MetronomoListener;
 import java.util.*;

/**
 *   Esta clase sirve para crear metronomos, que son objetos que generan
 *   eventos de tipo MetronomoEvent periodicamente.
 *   Cuando se crea esta clase puede indicarse en que instantes de tiempo
 *   se generaran los eventos.
 *   @author TPRG
 */
    public class Metronomo extends Thread {

    /**
     * Indica cada cuanto tiempo se generan los eventos.
     * Su valor esta expresado en segundos.
     */
      private long periodo;

    /**
     *  Objetos interesados en escuchar los eventos generados por este objeto.
     */
      private Vector escuchadores;

    /**
     *  Crea un objeto Metronomo que generara eventos con el periodo indicado.
     *  Ademas, los eventos se generaran en instantes de tiempo que son multiplos
     *  del periodo dado, es decir, si el periodo es de 60 segundos, los
     *  eventos se generaran cuando el reloj del sistema cumpla los minutos exactos.
     *  @param periodo Valor que indica cada cuantos segundos se generaran los eventos,
     *                y en que instantes de tiempo.
     */
       public Metronomo(long periodo) {
         escuchadores = new Vector();
         this.periodo = periodo;
         start();
      }

    /**
     * Genera un metronomo con un periodo de 60 segundos, y que ademas generara los
     * eventos cuando el reloj del sistema cumpla los minutos exactos..
     */
       public Metronomo() {
         this(60);
      }

       public void setPeriodo(int periodo){
           this.periodo = periodo;
           }
       


    /**
     *   Cuerpo de ejecucion del thread.
     *   Espera hasta el instante de tiempo adecuado, avisa a los escuchadores,
     *   se duerme rato, y vuelve a empezar.
     */
       public void run() {

         long hora = (new Date()).getTime()/periodo/1000;

         try {
            while (true) {
               hora ++;
               long dormir = hora*periodo*1000 - (new Date()).getTime();
               dormir = dormir /20;
               if (dormir > 0) Thread.sleep(dormir+50);
               avisar();

            }
         }
             catch (Exception exc) {
               System.err.println("Error en Metronomo: "+exc.getMessage());
            }
      }

    /**
     * Avisa a los escuchadores.
     */
       public void avisar() {

         Date d = new Date();

         MetronomoEvent mevent = new MetronomoEvent(periodo);

         Enumeration enume = ((Vector)escuchadores.clone()).elements();
         while (enume.hasMoreElements()) {
            MetronomoListener ml = (MetronomoListener) enume.nextElement();
            ml.tic(mevent);
         }
      }

    /**
     *  Añade un nuevo escuchador de eventos.
     *  @param ml Escuchador interesado en recibir los eventos generados por
     *            este objeto
     */
       public void addMetronomoListener(MetronomoListener ml) {
         escuchadores.add(ml);
      }

    /**
     *  Elimina a un escuchador de la lista de escuchadores.
     *  @param ml Escuchador a eliminar de la lista de escuchadores.
     */
       public void removeMetronomoListener(MetronomoListener ml) {
         escuchadores.remove(ml);
      }


   }
