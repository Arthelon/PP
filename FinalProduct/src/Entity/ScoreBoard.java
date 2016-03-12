package Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
/*
 * This class displays the Player's score onto the Game Screen. A ScoreBoard Object is declared and initialized
 * in the Game class, it is passed as a reference to any classes that need to access it's methods.
 */

public class ScoreBoard extends GameObject {
	
	private int score = 0; //score starts from 0
	
	public ScoreBoard() throws SlickException {
		super(); //GameObject default constructor
	}
	
	/*
	 * Responsible for rendering the user's score onto the top-left corner
	 * of the screen.
	 */
	public void render(GameContainer gc, Graphics g) {
		g.drawString("Score : " + score, 100, 10); 
	}
	
	/*
	 * Returns the user's score
	 */
	public int getScore() {
		
		return score;
	}
	/*
	 * Increments the user's score by the method's argument
	 * (Decrements if the argument is negative)
	 */
	public void addScore(int score) {
		this.score += score;
	}

}
