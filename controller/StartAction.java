/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author lolapriego
 */
import java.awt.event.*;

  public class StartAction implements ActionListener {
      private int estado = 0;
        public void actionPerformed(ActionEvent e) {
            this.estado = 2;
        }
        public int getEstado(){
            return this.estado;
        }
        public void setEstado(int estado){
            this.estado = estado;
        }
        }
