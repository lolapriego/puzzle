/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JSlider;
import javax.swing.event.*;
import javax.swing.JLabel;
import model.Metronomo;

/**
 *
 * @author lolapriego
 */
public class TimerAction implements ChangeListener {
  private int timer = 1;
  private JSlider slider;
  private JLabel label;

  public void setTimerAtr (JSlider slider, JLabel label){
      this.slider = slider;
      this.label = label;
  }

  public void stateChanged(ChangeEvent ce){
  int value = slider.getValue();
  this.timer = value ;
  label.setText(Integer.toString(value));
  }

  public int getTimer(){
      return this.timer;
  }
}
