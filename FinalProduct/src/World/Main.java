package World;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {
	public static final int START = 0;
	public static final int GAME = 1;
	public static final int END = 2;
	
	private static int screenY = 700;
	private static int screenX = 592;
	
	public Main() {
		super("Gun-Smoke");
		End end = new End(screenX, screenY);
		
		this.addState(new Start(screenX, screenY));
		this.addState(new Game(screenX, screenY, end));
		this.addState(end);
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(END).init(gc, this);
		this.enterState(END);
		
	}
	
	public static void main(String[] args) {
		AppGameContainer container;
		try {
			container = new AppGameContainer(new Main());
			container.setShowFPS(false);
			container.setTargetFrameRate(60);
			container.setDisplayMode(screenX, screenY, false);
			container.start();
			
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
