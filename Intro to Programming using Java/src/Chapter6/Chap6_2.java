package Chapter6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chap6_2 extends JPanel implements MouseListener, MouseMotionListener {
	int rX, rY, bX, bY, br;
	boolean dragged;
	public static void main(String[] args) {
		JFrame window = new JFrame("Chapter 6 Problem 2");
		Chap6_2 content = new Chap6_2();
		window.setContentPane(content);
		window.setSize(800, 800);
		window.setLocation(300, 100);
		window.setVisible(true);
	}
	public void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      g.setColor(Color.RED);
	      g.fillRect(rX, rY, 50, 50);
	      g.setColor(Color.BLUE);
	      g.fillRect(bX, bY, 50, 50);
    }
	
	public Chap6_2() {
		bX = 10;
		bY = 10;
		rX = 500;
		rY = 500;
		dragged = false;
		setBackground(Color.BLACK);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent evt) {

	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent evt) {
		dragged = true;
		int x = evt.getX();
		int y = evt.getY();
		if ((bX <= x && x <= bX + 50) && (bY <= y && y <= bY + 50)) br = 0;
		else if ((rX <= x && x <= rX + 50) && (rY <= y && y <= rY + 50)) br = 1;
		else br = 2;
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent evt) {
		if (!dragged || br == 2) return;
		int x = evt.getX();
		int y = evt.getY();
		if (br == 0) {
			bX = x;
			bY = y;
			repaint();
		} else if (br == 1) {
			rX = x;
			rY = y;
			repaint();
		}
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
