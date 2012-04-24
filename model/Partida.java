package model;


/**
 * Construye una jugada de puzzle
 * 
 * @author M� Dolores Priego Porcuna y Daniel Caballero Bellot
 * @version 10/03/2012
 */
public class Partida
{
    private Puzzle puzzle;
    private Partida padre;

    /**
     * Constructor for objects of class Partida
     * 
     * @param Puzzle recibe la �ltima jugada de la partida
     * @param Partida recibe las jugadas anteriores
     */
    public Partida(Puzzle puzzle, Partida partida)
    {
     this.puzzle= puzzle;
     this.padre= partida;
    }
    
    /**
     * Constructor por defecto
     */
    public Partida(){
        this.puzzle = null;
        this.padre = null;
    }
    
    

    /**
     * Getter del atributo padre (partidas o jugadas anteriores)
     * 
     * @return Partida las jugadas anteriores a la actual
     */
    public Partida getPadre()
    {
       return padre;
    }
    
    /**
     * Setter de partidas anteriores
     * 
     * @param recibe jugadas anteriores
     */
    
    public void setPadre(Partida padre){
    this.padre=padre;
    }
        
    /**
     * Getter del atributo puzzle (jugada actual)
     * 
     * @return Puzzle 
     */
    public Puzzle getPuzzle()
    {
       return this.puzzle;
    }
    
     /**
     *Setter del atributo puzzle (jugada actual)
     * 
     * @param Puzzle jugada actual
     */
    public void setPuzzle(Puzzle puzzle){
    this.puzzle=puzzle;
    }
    
    public int getProfundidad(){
        return getNumeroNodos() -1;
    }
    
    private int getNumeroNodos(){
        if(padre==null) return 0;
        return padre.getNumeroNodos() +1;
    }
    
    
     /**
     * toString nos permite una secuencia de las jugadas de la partida 
     * 
     * @return String Imprime por terminal los puzzles  de forma visual de manera que se aprecie
     * claramente las columnas y las filas, as� como los espacios en BLANCO
     */
    @Override
    public String toString(){
        try{
        if(this.padre.getPuzzle()==null){
            System.out.println("estoy aqui");
            return this.puzzle.toString();
            }
        return this.padre.toString() + this.puzzle.toString();
        }
        catch (NullPointerException e){
            return "";
        }

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
        if(aux.puzzle.equals(this.puzzle) && aux.padre.equals(this.padre))
        return true;
        else return false;
    }
    
    /**
     * hashCode
     * Redefine cuando dos partidas tienen el mismo hashCode
     * 
     * @return int hashCode calculado a partir del hashCode de cada puzzle sum�ndolos multiplicados por 3
     */
    @Override
    public int hashCode(){
        int hc=0;
        if(padre!=null)
        hc=3*hc +padre.hashCode();
        if(puzzle!=null)
        hc= 3*hc + puzzle.hashCode();
        return hc;
    }
    
    
    /**Borra la �ltima jugada de la partida
     * 
     */
    public void saca(){
        this.puzzle= this.padre.getPuzzle();
        this.padre = this.padre.getPadre();
    }
    
     /**A�ade una jugada a la partida
     * 
     * @param Puzzle jugada actual a a�adir a la partida
     */
    public void mete(Puzzle p){
        if(this.padre==null && this.puzzle ==null)this.puzzle=p;
         if(this.puzzle!=null&&this.padre==null) {
             this.padre= new Partida(this.puzzle, null);
             this.puzzle=p;
            }
         else{
         this.padre.setPadre(this.padre);
         System.out.println("Estoy en mete puzzle");
         System.out.println(this.padre.getPadre().getPuzzle());
         this.padre.setPuzzle(this.puzzle);
         this.puzzle=p;
    }
}
    
   
}
