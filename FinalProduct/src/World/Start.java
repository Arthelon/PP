package World;

import java.awt.Font;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Start extends BasicGameState {
	
	private int screenX; //specifies screen width
	private int screenY; //screen height
	
	//Title image declaration, with height and width specified
	private Image title;
	private int titleWidth = 500; 
	private int titleHeight = 150; 
	
	private TrueTypeFont instructionF;
	private TrueTypeFont buttonF;
	
	//Mouse Coordinates
	private int x;
	private int y;
	
	private int time;

	
	public Start(int screenX, int screenY) {
		this.screenX = screenX;
		this.screenY = screenY;
	}
	
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		title = new Image("res/images/gunSmokeTitle.png");
		Font buttonFont = new Font("PF Ronda Seven", Font.BOLD, 36);
		Font instructionFont = new Font("PF Ronda Seven", Font.PLAIN, 14);
		instructionF = new TrueTypeFont(instructionFont, false);
		buttonF = new TrueTypeFont(buttonFont, false);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		title.draw((screenX/2)-(titleWidth/2), 0); //Places title horizontally at the middle
		instructionF.drawString((screenX/2) - 75, titleHeight+30,"QWE keys to shoot");
		instructionF.drawString((screenX/2) - 75, titleHeight+60,"Arrow keys to move");
		instructionF.drawString(10, screenY-30,"Emulation of \"Gun Smoke\", all rights are upheld by respective game owners");
		g.drawString(x + ", " + y, 0, 0);
		if (time >= 0 && time <= 700) {
			buttonF.drawString((screenX/2) - 270, 400,"PRESS HERE TO BEGIN");
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		x = Mouse.getX();
		y = Mouse.getY();
		if ((y >= 240 && y <= 285) && Mouse.isButtonDown(0)) {
			//Initializes and enters the Game Screen
			sbg.getState(1).init(gc, sbg);
			sbg.enterState(1);
		}
		
		time += delta;
		if (time >= 1400) {
			time = 0;
		}
		
	}

	@Override
	public int getID() {
		//Returns screen ID
		return 0;
	}

}
