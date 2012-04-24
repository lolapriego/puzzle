/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

/**
 *  Los escuchadores de los eventos generados por el Metronomo,
 *  deben implementar este interface, y el objeto Metronomo que
 *  se esta escuchando invocara al metodo "tic" pasando como
 *  parametro el objeto que describe el evento.
 *  @author TPRG
 */
public interface MetronomoListener {

    /**
     *  Metodo invocado en los excuchadores para pasarles el evento generado.
     */
    public void tic(MetronomoEvent me);

}