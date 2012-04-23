package jigsaw;


/**
 * Clase que define la excepci�n de intentar realizar un movimiento incorrecto en un puzzle
 * 
 * @author Daniel Caballero Bellot y M� Dolores Priego Porcuna
 * @version 11/03/2012
 */
public class MoveException extends Exception
{

/**Constructor que llama al constructor padre
 * 
 * @param String mensaje de notificaci�n de error
 */
  public MoveException(String m){
      super(m);
    }
}