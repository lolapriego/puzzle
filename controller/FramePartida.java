package controller;


import javax.swing.JFrame;
import view.SlidePuzzleGUI;
import java.util.Scanner;
import model.Puzzle;
import java.io.*;
import model.Metronomo;
import controller.TicMetronomo;
import model.Partida;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FramePartida.java
 *
 * Created on Apr 22, 2012, 4:10:01 PM
 */

/**
 *
 * @author lolapriego
 */
public class FramePartida extends javax.swing.JFrame {

    /*public FramePartida() {
        initComponents();
    }
     *
     */
public static void main(String[] args) {
       Scanner lector= new Scanner(System.in);
       int contador=0;
       Puzzle puzzle = leerPuzzle(contador);
       contador++;
       Partida partida = new Partida(puzzle);

        JFrame window = new JFrame("Slide Puzzle");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SlidePuzzleGUI gui = new SlidePuzzleGUI(puzzle);
        window.setContentPane(gui);
        window.pack();  // finalize layout
        window.show();  // make window visible
        window.setResizable(false);

        Metronomo m1 = new Metronomo (1);
        if (partida.partidaResuelta())
        m1.addMetronomoListener(new TicMetronomo(partida.getTraza(),gui));
    }//end main
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
   /* @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Me cago en la puta");
        setBackground(new java.awt.Color(0, 153, 255));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 1336, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 434, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
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
