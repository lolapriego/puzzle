/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


/**
 *
 * @author lolapriego
 */
public class NewClass {
    public static void main (String [] args) throws Exception{
        Puzzle p1 = new Puzzle("AQWE R",2,3);
        Puzzle p2 = new Puzzle("WE R",2,2);
        Puzzle p3 = new Puzzle("1 2345",2,3);
        Puzzle p4 = new Puzzle(" 2DE",2,2);
        Puzzle p5 = new Puzzle("AQ 33R",2,3);
        Partida partida = new Partida ();
        partida.mete(p1);
        System.out.println(partida.getPadre()== null);
                System.out.println(partida.getPuzzle()== p1);
        System.out.println(partida.getPadre().getPuzzle() == null);


    }

}
