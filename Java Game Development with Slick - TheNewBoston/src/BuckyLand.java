import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class BuckyLand extends StateBasedGame {
	public static final int menu = 0;
	public static final int play = 1;
	public BuckyLand() {
		super("Bucky Land");
		this.addState(new BuckyMenu(menu));
		this.addState(new BuckyPlay(play));
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.getState(menu).init(container, this);
		this.getState(play).init(container, this);
		
		this.enterState(menu);
		
		
	}
	public static void main(String[] args) {
		AppGameContainer container;
		try {
			container = new AppGameContainer(new BuckyLand());
			container.setDisplayMode(800, 600, false);
			container.setTargetFrameRate(60);
			container.setShowFPS(false);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
