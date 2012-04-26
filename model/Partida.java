package model;

import java.util.*;

/**
 * Construye una jugada de puzzle
 * 
 * @author M� Dolores Priego Porcuna y Daniel Caballero Bellot
 * @version 10/03/2012
 */
public class Partida
{
    private List<Puzzle> jugadas = new ArrayList<Puzzle>();
    private Set<Puzzle> historial = new HashSet <Puzzle>();
    private Puzzle jugadaInicial;
    private ArrayList<Puzzle> traza = new ArrayList<Puzzle>();

    /**
     * Constructor for objects of class Partida
     * 
     * @param Puzzle recibe la �ltima jugada de la partida
     * @param Partida recibe las jugadas anteriores
     */
    public Partida(Puzzle puzzle)
    {
        jugadas.add(puzzle);
        this.jugadaInicial = puzzle;
    }
    
    /**
     * Constructor por defecto
     */
    public Partida(){
    }
    
        
    /**
     * Getter del atributo puzzle (jugada actual)
     * 
     * @return Puzzle 
     */
    public Puzzle getUltimaJugada()
    {
       return this.jugadas.get(this.jugadas.size() -1);
    }
    

    
    public int getNumPartidas(){
        return this.jugadas.size();
    }
    
     /**
     * toString nos permite una secuencia de las jugadas de la partida 
     * 
     * @return String Imprime por terminal los puzzles  de forma visual de manera que se aprecie
     * claramente las columnas y las filas, as� como los espacios en BLANCO
     */
    @Override
    public String toString(){
        String aux= "";
        if(this.jugadas.size() == 0)
            aux += "No se ha inicializado ninguna partida";
        for (int i=0; i< this.jugadas.size(); i ++){
            aux += this.jugadas.get(i).toString();
        }
        return aux;

    }
    
    /**
     * equals
     * Redefine cuando dos partidas son iguales
     * 
     * @param Object o
     * @return boolean nos dice si una partida es igual a otro bas�ndose en la definici�n
     * cuando dos puzzles son iguales
     */
    @Override
    public boolean equals(Object o){
        if((o==null) || !(o instanceof Partida)) return false;
        Partida aux = (Partida) o;
        boolean flag = true;
        for (int i=0; i< this.jugadas.size(); i ++){
        }
        return flag;
    }
    
    /**
     * hashCode
     * Redefine cuando dos partidas tienen el mismo hashCode
     * 
     * @return int hashCode calculado a partir del hashCode de cada puzzle sum�ndolos multiplicados por 3
     */
    @Override
    public int hashCode(){
      //  int hc=0;
     //   if(padre!=null)
      //  hc=3*hc +padre.hashCode();
      //  if(puzzle!=null)
      //  hc= 3*hc + puzzle.hashCode();
      //  return hc;
        return 1;
    }
    
    
    /**Borra la �ltima jugada de la partida
     * 
     */
    public Puzzle deshacerMov(){
        return this.jugadas.remove(this.jugadas.size() -1);
    }
    
     /**A�ade una jugada a la partida
     * 
     * @param Puzzle jugada actual a a�adir a la partida
     */
    public void mete(Puzzle p){
       if(this.jugadas.size() == 0)
           this.jugadaInicial = p;
       this.jugadas.add(p);
    }

    public ArrayList<Puzzle> getTraza(){
        return this.traza;
    }

    public boolean partidaResuelta(){
        Puzzle aux = getUltimaJugada();
        traza.add(aux);
        if(aux.hashCode() == this.jugadaInicial.resuelto().hashCode()) {
        return true;
        }

        historial.add(aux);
        Set <Puzzle> movimientos= new HashSet<Puzzle>();

        movimientos.add(aux.moverAbajo());
        movimientos.add(aux.moverDerecha());
        movimientos.add(aux.moverArriba());
        movimientos.add(aux.moverIz());

        boolean flag = false;
        for(Puzzle pz: movimientos){
            if(!historial.contains(pz)){
            mete(pz);
            flag = partidaResuelta();
            }
         }
         if(!flag){
             deshacerMov();
             return false;
         }
         else return true;
    }//function
 
   
}
