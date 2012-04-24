package model;


/**
 * Recibe una partida y la resuelve paso a paso mediante la t�cnica de Backtracking
 * Problemas de stack para puzzles grandes. Habr� puzzles de fichero que no pueda resolver
 * 
 * @author Daniel Caballero Bellot y M� Dolores Priego Porcuna
 * @version 10/03/2012
 */


import java.util.*;

public class PartidaResuelta
{

   public static Partida partida= new Partida();//estar� bien aqui?
   public static Set<Puzzle> visitados= new HashSet <Puzzle>();
   public static Partida llegada ;//se deber�a mejorar

/**Resuelve partidas de puzzles, calcula la primera jugada ganadora
 * Calcula los movimientos para llegar al puzzle resuelto
 * Algoritmo de Backtracking explora todas las posibilidades hasta llegar a la soluci�n deseada
 * 
 * @param Puzzle puzzle del que construye una partida ganadora
 * 
 * @return Partida ganadora
 */
    
    public static Partida partidaResuelta(Puzzle p){//�����por ahora devuelve una partida resuelta pero no la �ptima, darle una vuelta, est� feo private y static
        //si ya hay stack overflow sin contar la �ptima petar�a la pila si buscas la �ptima
        partida.mete(p);

        try{
                   
        if(partida.getPuzzle().hashCode()==p.resuelto().hashCode()) {

            llegada= new Partida(partida.getPuzzle(),partida.getPadre());
            return llegada;
        }
    }
    catch(Exception e){
        System.out.println(e);
    }
        System.out.println("traza " + partida.getPuzzle());
        visitados.add(partida.getPuzzle());
        Set <Puzzle> movimientos= new HashSet<Puzzle>();
        try{
        movimientos.add(partida.getPuzzle().moverArriba());
    }
    catch(Exception e){
    }
    try{
        movimientos.add(partida.getPuzzle().moverAbajo());
    }
    catch(Exception e){
    }
        try{
            movimientos.add(partida.getPuzzle().moverDerecha());
        }
        catch(Exception e){
    }
        try {
            movimientos.add(partida.getPuzzle().moverIz());
        }
        catch(Exception e){
    }
        boolean flag= false;
        for(Puzzle pz: movimientos){
            if(!visitados.contains(pz)){
            flag=true;
            partidaResuelta(pz);

            }
         }
         if(!flag)
             partida.saca();
         if (llegada == null)return null;
         else return llegada;

         
        }//function
                     
    }//class
            
            
        