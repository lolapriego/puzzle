package jigsaw;


/**
 * Class Puzzle, esta clase permite crear, instanciar puzzles del tama�o a
 * elegir formado por letras y n�meros.
 * TRPG ETSIT-UPM
 * 
 * @author M� Dolores Priego Porcuna y Daniel Cabellero Bellot
 * @version 9/03/2012
 */
public class Puzzle
{
    private String secuencia;
    /**
     * Define la constante espacio en blanco del puzzle
     */
    public  static final char BLANCO = ' ';
    private int col;
    private int row;
    
    /**Constructor por defecto
     * 
     */
    
    public Puzzle(){
    }

    
     /**Construye un puzzle.
      * Constructor que nos permite dise�ar un puzzle seg�n sus dimensiones y letras o n�meros
      *
      * 
      * @param secuencia recibe las letras o n�meros de los que se compondr� el puzzle
      * @param row recibe las filas del puzzle
      * @param col recibe el n�mero de columnas de las que se compondr� el puzzle
      * 
      * @throws Excepcion si no corresponde la secuencia para la dimensi�n escogida
      * @throws Exception si el puzzle no contiene el espacio en blanco
      */
     
   
    
    public Puzzle(String secuencia, int row, int col) throws Exception{
    if(secuencia.length()!=col*row) throw new Exception("Error al elegir las dimensiones del puzzle");
    if(secuencia.indexOf(BLANCO)==-1) throw new Exception("Error el puzzle no contiene espacio en blanco");
    this.secuencia=secuencia;
    this.row=row;
    this.col= col;
    }
    
    /**
     * Getter. Nos permite ver el valor de la secuencia de caracteres
     * 
     * @return cadena de caracteres que forma el puzzle
     */
    public String getPuzzle(){
    return this.secuencia;
    }
    
   /* public void setSecuencia(String secuencia) throws Exception{
        if(secuencia.length()< this.row*this.col) throw new Exception("Error secuencia incompatible con tama�o de puzzle");
        this.secuencia=secuencia;
    }
    */
   
   /**
    * MoverArriba, para mover pieza en blanco
    * 
    * @return Puzzle con el espacio en BLANCO desplazado hacia arriba.
    * Nota: no es un setter
    * 
    * @throws MoveException si intenta desplazar el espacio en BLANCO y estaba en la fila de arriba
    * @throws Exception si hay incongruencia al devolver el puzzle
    */
    public Puzzle  moverArriba() throws Exception{
        int posBlanc =this.secuencia.indexOf(BLANCO);
        if(posBlanc<this.col) throw new MoveException("No se puede realizar ese movimiento, int�nte otro movimiento diferente");
        char [] aux=this.secuencia.toCharArray();
        char almacen;
        aux[posBlanc]=aux[posBlanc-col];
        aux[posBlanc-col]=BLANCO;
        return new Puzzle(String.copyValueOf(aux),this.row,this.col);
    }
    
    /**
    * MoverAbajo
    * para mover pieza en blanco
    * 
    * @return Puzzle con el espacio en BLANCO desplazado hacia abajo.
    * Nota: no es un setter
    * 
    * @throws MoveException si intenta desplazar el espacio en BLANCO y estaba en la fila de abajo
    * @throws Exception si hay incongruencia al devolver el puzzle
    */
    public Puzzle moverAbajo ()throws Exception{
        int posBlanc =this.secuencia.indexOf(BLANCO);
        if(posBlanc>=this.col*(this.row-1)) throw new MoveException("No se puede realizar ese movimiento, int�nte otro movimiento diferente");
        char [] aux=this.secuencia.toCharArray();
        char almacen;
        aux[posBlanc]=aux[posBlanc+col];
        aux[posBlanc+col]=BLANCO;
        return new Puzzle(String.copyValueOf(aux),this.row,this.col);
    }
    
    
    /**
    * MoverDerecha
    * para mover pieza en blanco
    * Nota: no es un setter
    * 
    * @return Puzzle con el espacio en BLANCO desplazado hacia la derecha.
    * 
    * @throws MoveException si intenta desplazar el espacio en BLANCO y estaba en la fila de la derecha
    * @throws Exception si hay incongruencia al devolver el puzzle
    */
    public Puzzle moverDerecha() throws Exception{
        int posBlanc =this.secuencia.indexOf(BLANCO);
        if((posBlanc+1)%this.col==0) 
        throw new MoveException("No se puede realizar ese movimiento, int�nte otro movimiento diferente");
        char [] aux=this.secuencia.toCharArray();
        char almacen;
        aux[posBlanc]=aux[posBlanc+1];
        aux[posBlanc+1]=BLANCO;
        return new Puzzle(String.copyValueOf(aux),this.row,this.col);
    }
    
    /**
    * MoverIz
    * para mover pieza en blanco
    * Nota: no es un setter 
    *
    *@return Puzzle con el espacio en BLANCO desplazado hacia la izda.
    * 
    * @throws MoveException si intenta desplazar el espacio en BLANCO y estaba en la fila de la izda
    * @throws Exception si hay incongruencia al devolver el puzzle
    */
    public Puzzle moverIz() throws Exception{
        int posBlanc =this.secuencia.indexOf(BLANCO);
        if(posBlanc%this.col==0) throw new MoveException("No se puede realizar ese movimiento, intente otro movimiento diferente");
        char [] aux=this.secuencia.toCharArray();
        char almacen;
        aux[posBlanc]=aux[posBlanc-1];
        aux[posBlanc-1]=BLANCO;
        return new Puzzle(String.copyValueOf(aux),this.row,this.col);
    }

     /**
     * toString nos permite ver el puzzle
     * 
     * @return String Imprime por terminal el puzzle de forma visual de manera que se aprecie
     * claramente las columnas y las filas, as� como el espacio en BLANCO
     */
    @Override
    public String toString(){
            String devuelto='\n' + "" ;
     for(int i=0; i<row; i++){
      devuelto += '\n' + "----------------" +'\n';
         for(int j=0;j<col; j++)
         devuelto += " " + this.secuencia.charAt(i*col+j) + "|";
     }
     return devuelto;
    }
     
    
    /**
     * equals
     * Redefine cuando dos puzzles son iguales
     * 
     * @param Object o
     * @return boolean nos dice si un puzzle es igual a otro bas�ndose en su secuencia
     * de caracteres
     */
     @Override
        public boolean equals(Object o){
        if((o==null) || !(o instanceof Puzzle)) return false;
        Puzzle aux = (Puzzle) o;
        return aux.getPuzzle().equals(this.secuencia);
    }
    
    /**
     * hashCode
     * Redefine cuando dos puzzles tienen el mismo hashCode
     * 
     * @return int hereda hashCode de la secuencia de caracteres (String)
     */
    @Override
    public int hashCode(){
        return this.secuencia.hashCode();
    }
    
    
    /**
     * Resuelto
     * Funci�n �til para tener como referencia el puzzle resuelto seg�n su secuencia de caracteres.
     * Nota: no es un setter
     * 
     * @return Puzzle con sus piezas ordenadas seg�n el orden de la tabla ASCII
     * @throws Exception si hubo un error al crear el puzzle resuelto
     * 
     */
    public Puzzle resuelto() throws Exception{//algoritmo de la burbuja, ordenar un array
        char almacen;
        boolean flag= false;
        char aux []= this.secuencia.toCharArray();
        int contador=aux.length;
        do{
            for(int i=0; i<contador-1; i++){
                if(aux[i]>aux[i+1]){
                    almacen=aux[i+1];
                    aux[i+1]= aux[i];
                    aux[i]=almacen;
                    flag=true;
                }
            }
            contador--;
        }while(flag&&contador!=0);

        for (int i=0; i<aux.length-1 ; i++)
        aux[i]=aux[i+1];
        aux[aux.length-1]=BLANCO;
        
                
        return new Puzzle(String.copyValueOf(aux), this.row, this.col);
       
        
    }
}