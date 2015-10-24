package Entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Bomb extends GameObject {
	private static final int BLASTAREA = 20;
	
	private Animation countDownAnimation;
	private Image bombDet;
	private Image bombDet1;
	private Image drawnImage;
	private int time = 3500;
	private int detCount = 6;
	
	public Bomb(float x, float y) throws SlickException {
		super();
		Image[] countDown = {new Image("res/images/bomb.png"), new Image("res/images/bomb1.png")};
		bombDet = new Image("res/images/bombDet.png");
		bombDet1 = new Image("res/images/bombDet1.png");
		countDownAnimation = new Animation(countDown, 500, true);
		
		
		setImage(new Image("res/images/blank50.png"));
		setPos(x, y + getHeight());
	}
	
	public void update(GameContainer gc, int delta) {
		time -= delta;
		if (time <= 1000) {
			getWorld().bombActive(this);
			if (time <= 0) {
				getWorld().removeObject(this);
			}
		}
	}
	
	public void render(GameContainer gc, Graphics g) {
		if (time > 1000) {
			countDownAnimation.draw(getPos().x, getPos().y);
		} else if (time <= detCount * 250) {
			int random = (int) (Math.random() * 4) + 1;
			if ((time/250) % 2 == 0) {
				drawnImage = bombDet1;
			} else {
				drawnImage = bombDet;
			}
			switch (random) {
				case 1:
					drawnImage.draw(getPos().x - BLASTAREA, getPos().y - BLASTAREA);
				case 2:
					drawnImage.draw(getPos().x + BLASTAREA, getPos().y - BLASTAREA);
				case 3:
					drawnImage.draw(getPos().x - BLASTAREA, getPos().y + BLASTAREA);
				case 4:
					drawnImage.draw(getPos().x + BLASTAREA, getPos().y + BLASTAREA);
			}
			detCount--;
		}
	}
}
