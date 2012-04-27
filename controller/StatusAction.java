/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;


import java.awt.event.*;

  public class StatusAction implements ActionListener {
      private int estado = 0;
      private int flag = 1;
        public void actionPerformed(ActionEvent e) {
            if (flag ==1){
            this.estado = 1;
            this.flag = 0;
            }
            else{
                this.flag = 1;
                this.estado = 0;
                }
        }
        public int getEstado(){
            return this.estado;
        }
        }
