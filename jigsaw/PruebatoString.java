/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jigsaw;

/**
 *
 * @author lolapriego
 */
public class PruebatoString {
    public static void main (String args []){
        try{
        Puzzle p = new Puzzle ("QWERT ", 2, 3);
        Partida partida = new Partida (p,null);
        System.out.println(partida.getPadre()==null);
        Puzzle p2 = new Puzzle ("QWER T", 2, 3);
        partida.mete(p2);
    System.out.println(partida.getPadre().getPadre()==null);
        System.out.println(partida.toString());
        Puzzle p3 = new Puzzle ("QWE RT", 2, 3);
        System.out.println("hola");
        partida.mete(p3);
        System.out.println(partida.getPadre().getPadre().getPadre()==null);


                //System.out.println(partida.toString());


        }
        catch( Exception e){
            System.out.println(e);
        }
    }
}
