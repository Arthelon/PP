package Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends Sprite {
	private final float MOVESPEED = 0.3f;
	private Input input;
	private final float FIRESPEED = 0.3f;
	private int delay = 0;
	private Sound bulletSound;
	private Image left, right, defaultPos, shootForward;
	
	public Player() throws SlickException {
		bulletSound = new Sound("res/sound/shooting1.wav");
		defaultPos = new Image("res/images/player/player.png");
		shootForward = new Image("res/images/player/playerShoot.png");
		left = new Image("res/images/player/shootLeft.png");
		right = new Image("res/images/player/shootRight.png");
		
		setImage(defaultPos);
		setPos(300, 600);
		
		Image[] shoot = {shootForward, new Image("res/images/player/playerShoot1.png"), shootForward, new Image("res/images/player/playerShoot2.png"), shootForward};
		Image[] walk = {defaultPos, new Image("res/images/player/player1.png"), defaultPos, new Image("res/images/player/player2.png")};
		Image[] death = {new Image("res/images/player/death1.png"), new Image("res/images/player/death2.png")};
		Image[] shootLeft = {left, new Image("res/images/player/shootLeft1.png"), left, new Image("res/images/player/shootLeft2.png")};
		Image[] shootRight = {right, new Image("res/images/player/shootRight1.png"), right, new Image("res/images/player/shootRight2.png")};
		
		addAnimation(shoot, 200, "shoot");
		addAnimation(shootRight, 200, "shootRight");
		addAnimation(shootLeft, 200, "shootLeft");
		addAnimation(walk, 200, "walk");
		addAnimation(death, 200, "death");
		
		setAnimation("walk");
	}
	
	public void update(GameContainer gc, int delta) throws SlickException {
		input = gc.getInput();
		playerMove(delta);
		bulletFire(delta);
	}
	
	public void playerMove(int delta) {
		if (input.isKeyDown(Input.KEY_UP) || getPos().y > 700 - getHeight() / 2) {
			changeY(-MOVESPEED * delta);
		}
		if (input.isKeyDown(Input.KEY_DOWN) || getPos().y < getHeight() / 2) {
			changeY(MOVESPEED * delta);
		}
		if (input.isKeyDown(Input.KEY_LEFT) || getPos().x > 592 - getWidth() / 2) {
			changeX(-MOVESPEED * delta);
		}
		if (input.isKeyDown(Input.KEY_RIGHT) || getPos().x < getWidth() / 2) {
			changeX(MOVESPEED * delta);
		}
	}
	
	public void bulletFire(int delta) throws SlickException {
		
		if (delay <= 0) {
			if (input.isKeyPressed(Input.KEY_Q)) {
				getWorld().addObject(new Bullet(getPos().x - getWidth()/2, getPos().y, -45, FIRESPEED, 1300));
				getWorld().addObject(new Bullet(getPos().x + getWidth()/2, getPos().y, -45, FIRESPEED, 1300));
				
				setAnimation("shootLeft");
				bulletSound.play();
				delay = 200;
			} else if (input.isKeyPressed(Input.KEY_W)) {
				getWorld().addObject(new Bullet(getPos().x - getWidth()/2, getPos().y, 0, FIRESPEED, 1300));
				getWorld().addObject(new Bullet(getPos().x + getWidth()/2, getPos().y, 0, FIRESPEED, 1300));
				bulletSound.play();
				delay = 200;
			} else if (input.isKeyPressed(Input.KEY_E)) {
				getWorld().addObject(new Bullet(getPos().x - getWidth()/2, getPos().y, 45, FIRESPEED, 1300));
				getWorld().addObject(new Bullet(getPos().x + getWidth()/2, getPos().y, 45, FIRESPEED, 1300));
				
				setAnimation("shootRight");
				bulletSound.play();
				delay = 200;
			} else {
				setAnimation("walk");
			}
		} else {
			delay -= delta;
		}
	}
	
	@Override
	public void death() {
		
	}
	
	

}
