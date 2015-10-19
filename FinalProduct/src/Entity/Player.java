package Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Vector2f;

public class Player extends Sprite {
	
	private final float MOVESPEED = 0.2f;   //Movement velocity of Player
	private final float FIRESPEED = 0.4f;   //Velocity of Bullets fired by Player
	
	private Input input; 
	private int shootDelay = 0;   //shootDelay between Shooting/Animation-change
	private Sound bulletSound; //Sound of Bullet fire
	private Image left, right, defaultPos, shootForward;
	private int delta;
	private int immune = 0;
	
	public Player() throws SlickException {
		delta = 0;
		bulletSound = new Sound("res/sound/shooting1.wav");
		// Main Player Images
		defaultPos = new Image("res/images/player/player.png");
		shootForward = new Image("res/images/player/playerShoot.png");
		left = new Image("res/images/player/shootLeft.png");
		right = new Image("res/images/player/shootRight.png");
		
		setImage(defaultPos);
		setPos(300, 600);
		
		//Sequences of Player Images to make different Animations
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
		if (immune > 0) {
			immune -= delta;
		}
		this.delta = delta;
		input = gc.getInput(); //Gets input from my Game Container
		playerMove();
		bulletFire();
	}
	
	public void playerMove() {
		setV(0, 0);
		if (input.isKeyDown(Input.KEY_UP)) {
			setV(getV().x, -MOVESPEED * delta);
		}
		if (input.isKeyDown(Input.KEY_DOWN)) {
			setV(getV().x, MOVESPEED * delta);
		}
		if (input.isKeyDown(Input.KEY_LEFT)) {
			setV(-MOVESPEED * delta, getV().y);
		}
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			setV(MOVESPEED * delta, getV().y);
		}
		
		changeX(getV().x);
		changeY(getV().y);
		
		if (getPos().y > 700 - getHeight() / 2) {
			changeY(-MOVESPEED * delta);
		}
		if (getPos().y < getHeight() / 2) {
			changeY(MOVESPEED * delta);
		}
		if (getPos().x > 592 - getWidth() / 2) {
			changeX(-MOVESPEED * delta);
		}
		if (getPos().x < getWidth() / 2) {
			changeX(MOVESPEED * delta);
		}
	}
	
	public void bulletFire() throws SlickException {
		
		if (shootDelay > 0) {
			shootDelay -= delta;
		} else if (input.isKeyPressed(Input.KEY_Q)) {
			getWorld().addObject(new Bullet(getPos().x - getWidth()/2, getPos().y, -45, FIRESPEED, 1300));
			getWorld().addObject(new Bullet(getPos().x + getWidth()/2, getPos().y, -45, FIRESPEED, 1300));
			
			setAnimation("shootLeft");
			bulletSound.play();
			shootDelay = 200;
		} else if (input.isKeyPressed(Input.KEY_W)) {
			getWorld().addObject(new Bullet(getPos().x - getWidth()/2, getPos().y, 0, FIRESPEED, 1300));
			getWorld().addObject(new Bullet(getPos().x + getWidth()/2, getPos().y, 0, FIRESPEED, 1300));
			
			setAnimation("shoot");
			bulletSound.play();
			shootDelay = 200;
		} else if (input.isKeyPressed(Input.KEY_E)) {
			getWorld().addObject(new Bullet(getPos().x - getWidth()/2, getPos().y, 45, FIRESPEED, 1300));
			getWorld().addObject(new Bullet(getPos().x + getWidth()/2, getPos().y, 45, FIRESPEED, 1300));
			
			setAnimation("shootRight");
			bulletSound.play();
			shootDelay = 200;
		} else {
			setAnimation("walk");
		}
	}
	
	@Override
	public void collideMove(Vector2f collideV, boolean alive) {
		if (alive && immune <= 0) {
			death();
		}
		getV().sub(collideV);
		getV().set(getV().x*-1, getV().y*-1);
		
		changeX(getV().x);
		changeY(getV().y);
	}
	
	
	@Override
	public void death() {
//		getWorld().getHealthBar().changeHealth(-1);
		immune = 1000;
		
		if (getWorld().getHealthBar().getHealth() == 0) {
			setAlive(false);
			getWorld().endGame();
		} 
	}
}
