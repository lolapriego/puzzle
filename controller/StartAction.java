package controller;

/**
 * StartAction.java
 * Implementa el listener que reinicirá la partida en caso de accionarlo
 *
 * @author Mª Dolores priego Porcuna y Daniel Caballero Bellot
 * https://github.com/lolapriego/puzzle
 * @version 27/04/2012
 */
import java.awt.event.*;

  public class StartAction implements ActionListener {
      private int estado = 0;

      /*
       * actionPerformed acción que realiza al escuchar
       *
       * @params ActionEvent recibe el evento
       */
        public void actionPerformed(ActionEvent e) {
            this.estado = 2;
        }

       /*
        * getEstado getter del estado
        *
        * @return int estado que marca el reinicio de la partida
        */
        public int getEstado(){
            return this.estado;
        }

        /*
         * setEstado setter del estado de reinicio.
         *
         * @params int estado que tras iniciarse debería ser otro
         */
        public void setEstado(int estado){
            this.estado = estado;
        }
    }
