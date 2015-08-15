package Chapter6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chap6_3 extends JPanel {
 
    public static void main(String[] args) {
        JFrame window = new JFrame("Dice");
        Chap6_3 content = new Chap6_3();
        window.setContentPane(content);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(120,70);
        window.pack();
        window.setVisible(true);
    }

    //---------------------------------------------------------------------

    private int die1 = 4;  // The values shown on the dice.
    private int die2 = 3;
 

    public Chap6_3() {
       setPreferredSize( new Dimension(100,100) );
       setBackground( new Color(200,200,255) );  // light blue
       addMouseListener( new MouseAdapter() {
           public void mousePressed(MouseEvent evt) {
               roll();
           }
       });
    }
    private void drawDie(Graphics g, int val, int x, int y) {
       g.setColor(Color.white);
       g.fillRect(x, y, 35, 35);
       g.setColor(Color.black);
       g.drawRect(x, y, 34, 34);
       if (val > 1)  // upper left dot
          g.fillOval(x+3, y+3, 9, 9);
       if (val > 3) 
          g.fillOval(x+23, y+3, 9, 9);
       if (val == 6)
          g.fillOval(x+3, y+13, 9, 9);
       if (val % 2 == 1) 
          g.fillOval(x+13, y+13, 9, 9);
       if (val == 6) // middle right dot
          g.fillOval(x+23, y+13, 9, 9);
       if (val > 3)  // bottom left dot
          g.fillOval(x+3, y+23, 9, 9);
       if (val > 1)  // bottom right dot
          g.fillOval(x+23, y+23, 9,9);
    }

    void roll() {
       die1 = (int)(Math.random()*6) + 1;
       die2 = (int)(Math.random()*6) + 1;
       repaint();
    }
  
    public void paintComponent(Graphics g) {
       super.paintComponent(g);  // fill with background color.
       Graphics2D g2 = (Graphics2D)g;
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                   RenderingHints.VALUE_ANTIALIAS_ON);
       g.setColor( Color.BLUE );
       g.drawRect(0,0,99,99);
       g.drawRect(1,1,97,97);
       drawDie(g, die1, 10, 10);
       drawDie(g, die2, 55, 55);
    }
 
} 
