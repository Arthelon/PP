package Chapter3;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  This file can be used to create very simple animations.  Just fill in
 *  the definition of drawFrame with the code to draw one frame of the 
 *  animation, and possibly change a few of the values in the rest of
 *  the program as noted below. Note that if you change the name of the
 *  class, you must also change the name in the main() routine!
 */
public class Chap3_9 extends JPanel implements ActionListener {

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
    	int frameNumber1 = frameNumber % 400;
    	g.setColor(Color.RED);
    	if (frameNumber1 > 200) frameNumber1 = 400 - frameNumber1;
    	g.fillRect(3*frameNumber1, 0, 50, 50); 
       
        
       int frameNumber2 = frameNumber % 50;
       g.setColor(Color.BLUE);
       if (frameNumber2 > 25) frameNumber2 = 50 - frameNumber2;
       g.fillRect(5*frameNumber2, 50, 50, 50);
       
       g.drawString("Frame Number : " + frameNumber, 0, 100);
    }
    
    //------ Implementation details: DO NOT EXPECT TO UNDERSTAND THIS ------
    
    
    public static void main(String[] args) {
        
        /* NOTE:  The string in the following statement goes in the title bar
         * of the window.
         */
        JFrame window = new JFrame("Simple Animation");
        
        /*
         * NOTE: If you change the name of this class, you must change
         * the name of the class in the next line to match!
         */
        Chap3_9 drawingArea = new Chap3_9();
        
        drawingArea.setBackground(Color.WHITE);
        window.setContentPane(drawingArea);

        /* NOTE:  In the next line, the numbers 600 and 450 give the
         * initial width and height of the drawing array.  You can change
         * these numbers to get a different size.
         */
        drawingArea.setPreferredSize(new Dimension(600,450));

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