package World;

import java.awt.Font;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
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
	private int delta;
	private FadeOutTransition fadeToBlack;
	
	
	public Start(int screenX, int screenY) {
		this.screenX = screenX;
		this.screenY = screenY;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
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
			g.drawString(x + ", " + y, 0, 0);
			if (time >= 0 && time <= 700) {
				button.draw((screenX/2) - 270, 400);
			} 
			if (start) {
				fadeToBlack.postRender(sbg, gc, g);
			}
	}
	

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		this.delta = delta;
		x = Mouse.getX();
		y = Mouse.getY();
		if (!start && (y >= 240 && y <= 285) && Mouse.isButtonDown(0)) {
			gc.sleep(1000);
			fadeToBlack.init(sbg.getState(0), sbg.getState(1));
			start = true;
		}
		
		time += delta;
		if (time >= 1400) {
			time = 0;
		}
		if (start) {
			fadeToBlack.update(sbg, gc, delta);
		}
		if (fadeToBlack.isComplete()) {
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
