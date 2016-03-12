package World;

import java.awt.Font;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeOutTransition;



public class Start extends BasicGameState {
	
	private int screenX; //specifies screen width
	private int screenY; //screen height
	
	//Title image declaration, with height and width specified
	private Image title;
	private int titleWidth = 500; 
	private int titleHeight = 150; 
	
	private TrueTypeFont instructionF;
	private Image button;
	
	//Mouse Coordinates
	private int x;
	private int y;
	private boolean start = false;
	private int time;
	private int timeLimit = 700;
	private FadeOutTransition fadeToBlack;
	
	private Sound startSound;
	private Input input;
	private boolean clicked = false;
	
	
	public Start(int screenX, int screenY) {
		this.screenX = screenX;
		this.screenY = screenY;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		startSound = new Sound("res/sound/start.wav");
		title = new Image("res/images/gunSmokeTitle.png");
		button = new Image("res/images/startButton.png");
		Font instructionFont = new Font("PF Ronda Seven", Font.PLAIN, 14);
		instructionF = new TrueTypeFont(instructionFont, false);
		fadeToBlack = new FadeOutTransition(new Color(Color.black), 2000);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
			title.draw((screenX/2)-(titleWidth/2), 0); //Places title horizontally at the middle
			instructionF.drawString((screenX/2) - 75, titleHeight+30,"QWE keys to shoot");
			instructionF.drawString((screenX/2) - 75, titleHeight+60,"Arrow keys to move");
			instructionF.drawString(10, screenY-30,"Emulation of \"Gun Smoke\", all rights are upheld by respective game owners");
			if (time >= 0 && time <= timeLimit) {
				button.draw((screenX/2) - 270, 400);
			} 
			if (start) {
				fadeToBlack.postRender(sbg, gc, g);
			}
	}
	public void mouseClicked(int button, int x, int y, int clickCount) {
		if (button == 0 && (y >= 400 && y <= 430)) {
			clicked = true;
		}
	}
	

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		input = gc.getInput();
		x = Mouse.getX();
		y = Mouse.getY();
		if (!start && clicked) {
			clicked = false;
			start = true;
			timeLimit = 100;
			time = 0;
			button.draw((screenX/2) - 270, 400);
			startSound.play();
			fadeToBlack.init(sbg.getState(0), sbg.getState(1));
		}
		if (!start || startSound.playing()) {
			time += delta;
		} else {
			time = 0;
		}
		
		if (time >= timeLimit*2) {
			time = 0;
		}
		if (start) {
			fadeToBlack.update(sbg, gc, delta);
		}
		if (fadeToBlack.isComplete()) {
			start = false;
			timeLimit = 700;
			sbg.getState(1).init(gc, sbg);
			sbg.enterState(1);
		}
	}
	
	@Override
	public int getID() {
		//Returns screen ID
		return 0;
	}

}
