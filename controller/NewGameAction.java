/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;


import java.awt.event.*;

  public class NewGameAction implements ActionListener {
      private int estado = 0;
        public void actionPerformed(ActionEvent e) {
            this.estado = 1;
        }
        public int getEstado(){
            return this.estado;
        }
        }
