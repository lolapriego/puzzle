package view;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/**
 *
 * @author lolapriego
 */
  public class GraphicsPanel extends JPanel implements MouseListener {
        private int rows;
        private int cols;

        private static final int CELL_SIZE = 150; // Pixels
        private Font _biggerFont;


        //================================================== constructor
        public GraphicsPanel(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            _biggerFont = new Font("Helvetica", Font.BOLD, CELL_SIZE/4);
            this.setPreferredSize(
                                  new Dimension(CELL_SIZE * cols, CELL_SIZE*rows));
            this.setBackground(Color.black);
            this.addMouseListener(this);  // Listen own mouse events.
        }//end constructor


        //=======================================x method paintComponent
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int r=0; r<rows; r++) {
                for (int c=0; c<cols; c++) {
                    int x = c * CELL_SIZE;
                    int y = r * CELL_SIZE;
                    String text = "h" + c+ " " + r;
                    if (text != null) {
                        g.setColor(new Color(51, 102, 255));
                        g.fillRect(x+2, y+2, CELL_SIZE-4, CELL_SIZE-4);
                        g.setColor(new Color(244, 244, 251));
                        g.setFont(_biggerFont);
                        g.drawString(text, x+20, y+(3*CELL_SIZE)/4);
                    }
                }
            }
        }//end paintComponent


        //========================================== ignore these events
        public void mouseClicked (MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered (MouseEvent e) {}
        public void mouseExited  (MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}

}
