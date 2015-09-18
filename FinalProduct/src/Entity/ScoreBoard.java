package Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ScoreBoard extends GameObject {
	private int score = 0;
	public ScoreBoard() throws SlickException {
		super();
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		g.drawString("Score : " + score, 10, 10);
	}
	
	public int getScore() {
		return score;
	}
	
	public void addScore(int score) {
		this.score += score;
	}

}
