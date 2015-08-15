package Chapter6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A simple demonstration of MouseEvents.  Shapes are drawn
 * on a black background when the user clicks the panel.  If
 * the user Shift-clicks, the panel is cleared.  If the user
 * right-clicks the panel, a blue oval is drawn.  Otherwise,
 * when the user clicks, a red rectangle is drawn.  The contents of
 * the panel are not persistent.  For example, they might disappear 
 * if the panel is resized.
 * This class has a main() routine to allow it to be run as an application.
 */
public class Chap6_1 extends JPanel implements MouseListener, MouseMotionListener {
	private int startX, startY; 
    private int prevX, prevY;  
    private boolean dragging; 
	   
    public static void main(String[] args) {
        JFrame window = new JFrame("Simple Stamper");
        Chap6_1 content = new Chap6_1();
        window.setContentPane(content);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(120,70);
        window.setSize(800,800);
        window.setVisible(true);
    }

    // ----------------------------------------------------------------------

    /**
     * This constructor simply sets the background color of the panel to be black
     * and sets the panel to listen for mouse events on itself.
     */
    public Chap6_1() {
        setBackground(Color.BLACK);
        addMouseListener(this);
        addMouseMotionListener(this);
    }


    /**
     *  Since this panel has been set to listen for mouse events on itself, 
     *  this method will be called when the user clicks the mouse on the panel.
     *  This method is part of the MouseListener interface.
     */
    public void mousePressed(MouseEvent evt) {
    	startX = evt.getX();
    	startY = evt.getY();
    	prevX = startX;
    	prevY = startY;
    	int x = evt.getX();
    	int y = evt.getY();
    	
    	if ( evt.isShiftDown() ) {
    		repaint();
    		dragging = false;
        	return;
    	}
    	Graphics g = getGraphics();
    	dragging = true;
    	
    	 if ( evt.isMetaDown() ) {

         g.setColor(Color.BLUE);  // Blue interior.
         g.fillOval( x - 30, y - 15, 60, 30 );
         g.setColor(Color.BLACK); // Black outline.
         g.drawOval( x - 30, y - 15, 60, 30 );
	     }
	     else {
	         g.setColor(Color.RED);   // Red interior.
	         g.fillRect( x - 30, y - 15, 60, 30 );
	         g.setColor(Color.BLACK); // Black outline.
	         g.drawRect( x - 30, y - 15, 60, 30 );
	     }
    	 g.dispose();
    } 
    public void mouseEntered(MouseEvent evt) { }
    public void mouseExited(MouseEvent evt) { }
    public void mouseClicked(MouseEvent evt) { }
    public void mouseReleased(MouseEvent evt) {
    	if (!dragging) return;
    	dragging = false;
    }
    
    public void mouseDragged(MouseEvent evt) {
    	if (!dragging) { 
            return;
        }
        int x = evt.getX(); 
        int y = evt.getY(); 
        Graphics g = getGraphics();  

        if ( evt.isMetaDown() ) {
              
            g.setColor(Color.BLUE); 
            g.fillOval( x - 30, y - 15, 60, 30 );
            g.setColor(Color.BLACK); 
            g.drawOval( x - 30, y - 15, 60, 30 );
        }
        else {
            g.setColor(Color.RED);   
            g.fillRect( x - 30, y - 15, 60, 30 );
            g.setColor(Color.BLACK); 
            g.drawRect( x - 30, y - 15, 60, 30 );
        }
        g.dispose();
    }

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

} // end class SimpleStamper