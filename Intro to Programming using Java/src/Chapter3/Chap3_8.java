package Chapter3;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *  This file can be used to create very simple animations.  Just fill in
 *  the definition of drawFrame with the code to draw one frame of the 
 *  animation, and possibly change a few of the values in the rest of
 *  the program as noted below. Note that if you change the name of the
 *  class, you must also change the name in the main() routine!
 */
public class Chap3_8 extends JPanel implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Draws one frame of an animation. This subroutine is called re
     * second and is responsible for redrawing the entire drawing area.  The
     * parameter g is used for drawing. The frameNumber starts at zero and
     * increases by 1 each time this subroutine is called.  The parameters width
     * and height give the size of the drawing area, in pixels.  
     * The sizes and positions of the rectangles that are drawn depend
     * on the frame number, giving the illusion of motion.
     */
    public void drawFrame(Graphics g, int frameNumber, int width, int height) {
        int x = 0;
        int y = 0;
        int count = 0;
        
        while (x != 400 && y != 400) {
        	if ((x % 100 == 50 && y % 100 == 50) || (x % 100 == 0 && y % 100 == 0)) {
        		g.setColor(Color.RED);
        	}
        	if ((x % 100 == 50 && y % 100 == 0) || x % 100 == 0 && y % 100 == 50) {
        		g.setColor(Color.BLACK);
        	}
        	
        	g.fillRect(x, y, 50, 50); 
        	count++;
        	if (count % 8 == 0) { //Doesn't work with (x == 400) for unknown reasons
        		y += 50;
        		x = 0;
        	} else {
        		x += 50;
        	}
        }
    }
    public static void main(String[] args) {
        
        /* NOTE:  The string in the following statement goes in the title bar
         * of the window.
         */
        JFrame window = new JFrame("Simple Animation");
        
        /*
         * NOTE: If you change the name of this class, you must change
         * the name of the class in the next line to match!
         */
        Chap3_8 drawingArea = new Chap3_8();
        
        drawingArea.setBackground(Color.WHITE);
        window.setContentPane(drawingArea);

        drawingArea.setPreferredSize(new Dimension(400,400));

        window.pack();
        window.setLocation(100,50);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        /*
         * Note:  In the following line, you can change true to
         * false.  This will prevent the user from resizing the window,
         * so you can be sure that the size of the drawing area will
         * not change.  It can be easier to draw the frames if you know
         * the size.
         */
        window.setResizable(true);
        
        /* NOTE:  In the next line, the number 20 gives the time between
         * calls to drawFrame().  The time is given in milliseconds, where
         * one second equals 1000 milliseconds.  You can increase this number
         * to get a slower animation.  You can decrease it somewhat to get a
         * faster animation, but the speed is limited by the time it takes
         * for the computer to draw each frame. 
         */
        Timer frameTimer = new Timer(20,drawingArea);

        window.setVisible(true);
        frameTimer.start();

    } // end main

    private int frameNum;
    
    public void actionPerformed(ActionEvent evt) {
        frameNum++;
        repaint();
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFrame(g, frameNum, getWidth(), getHeight());
    }

}