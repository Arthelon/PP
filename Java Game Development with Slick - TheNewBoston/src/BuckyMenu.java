

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class BuckyMenu extends BasicGameState {
	Image playNow;
	Image exitGame;
	private int x;
	private int y;
	public BuckyMenu (int state) {
		 
	}
	@Override
	public void init(GameContainer arg0, StateBasedGame sbg)
			throws SlickException {
		playNow = new Image("src/playNow.png");	
		exitGame = new Image("src/exitGame.png");
		
	}
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		x = Mouse.getX();
		y = Mouse.getY();
		if(Mouse.isButtonDown(0)) {
			if ((x >= 305 && x <= 516)&&(y >= 299 && y <= 350)) {
				sbg.enterState(1);
			}
			if ((x >= 305 && x <= 516)&&(y >= 249 && y <= 300)) {
				gc.exit(); //Quits Game
			}
		}
		
		
	}
	
	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		g.drawString("Welcome to Bucky Land", 305, 200);
		playNow.draw(305, 250);
		exitGame.draw(305, 300);
		
	}
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
