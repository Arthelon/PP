package World;

import java.awt.Font;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class End extends BasicGameState {
	
	private int screenX;
	private int screenY;
	private int score = 0;
	private int time = 0;
	private int titleX = 481;
	private int titleY = 57;
	private int timeInterval = 700;
	
	private TrueTypeFont textF;
	private Image title;
	private Image playAgain;
	private Sound endSound;
	
	private boolean first = false;
	
	public End(int screenX, int screenY) {
		this.screenX = screenX;
		this.screenY = screenY;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		if (first) {
			endSound = new Sound("res/sound/endSound.ogg");
			endSound.play();
			playAgain = new Image("res/images/playagain.png");
			Font textFont = new Font("PF Ronda Seven", Font.PLAIN, 40);
			textF = new TrueTypeFont(textFont, false);
			title = new Image("res/images/endTitle.png");
		}
		first = true;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		title.draw((screenX/2) - titleX/2, 100);
		textF.drawString((screenX/2) - 100, 100 + titleY*2, "Score: " + score);
		if (time > 0 && time <= timeInterval) {
			textF.drawString((screenX/2)-45, 340, "Quit");
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		time += delta;
		int y = Mouse.getY();
		if (Mouse.isButtonDown(0) && (y < 360 && y > 320)) {
			endSound.stop();
			gc.exit();
		}
		if (time >= timeInterval*2) {
			time = 0;
		}
	}
	
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}
}
