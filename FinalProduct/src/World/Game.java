package World;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Entity.Bullet;
import Entity.Fence;
import Entity.GameObject;
import Entity.HealthBar;
import Entity.Player;
import Entity.PowerUp;
import Entity.ScoreBoard;
import Entity.Shooter;
import Entity.Sprite;

public class Game extends BasicGameState {
	
	private int screenX;
	private int screenY;
	private Music backMusic; //Background Music Object
	private boolean first = false; //Toggle for first initiation of Game class
	private boolean end = false; 
	private int mapY; //Y coordinate of background-map
	private final float MAPSPEED = 0.0005f; //Rate at which map moves upwards
	
	//ArrayLists holding Game Objects
	private ArrayList<GameObject> objectList = new ArrayList<GameObject>();
	private ArrayList<GameObject> addList = new ArrayList<GameObject>();
	private ArrayList<GameObject> removeList = new ArrayList<GameObject>();
	private ArrayList<GameObject> collideAble = new ArrayList<GameObject>();
	private ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	
	//A few Game Objects
	private Player player;
	private ScoreBoard scoreboard;
	private HealthBar healthbar;
	private Image map;
	
	public Game(int screenX, int screenY) {
		//Size of screen in pixels
		this.screenX = screenX;
		this.screenY = screenY;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
//		backMusic = new Music("res/sound/levelTheme.ogg");
		if (first) {
//			backMusic.loop();
			player = new Player();
			scoreboard = new ScoreBoard();
			healthbar = new HealthBar();
			addObject(player);
			addObject(scoreboard);
			addObject(healthbar);
			
			map = new Image("res/images/startMap.png");
			mapY = -(map.getHeight() - screenY);
			GameObject.setWorld(this); //Adds a reference to this class in all GameObjects
		}
		first = true;
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		map.draw(0, mapY); 
		for (GameObject object : objectList) {
			object.render(gc, g);
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Shooter.spawn(delta);
		updateObjects(gc, delta);
		if (end) {
			sbg.getState(2).init(gc, sbg); //Initializes End class
			sbg.enterState(2); //Enters end class (identified using the state ID of 2)
		}
	}
	
	public void updateObjects(GameContainer gc, int delta) throws SlickException {
		for (GameObject object : objectList) {
			object.update(gc, delta);
			if (object instanceof Bullet || object instanceof Fence || object instanceof PowerUp) {
				collideAble.add(object);
			}
			if (object instanceof Sprite) {
				collideAble.add(object);
				sprites.add((Sprite)object);
			}
		}
		for (Sprite sprite : sprites) {
			collideCheck(sprite);
		}
		for (GameObject object : addList) {
			objectList.add(object);
		}
		for (GameObject object : removeList) {
			objectList.remove(object);
		}
		mapY += delta * MAPSPEED;
		
		collideAble.clear();
		addList.clear();
		removeList.clear();
	}
	
	public void addObject(GameObject object) {
		addList.add(object);
	}
	
	public void removeObject(GameObject object) {
		removeList.add(object);
	}
	
	public ScoreBoard getScoreBoard() {
		return scoreboard;
	}
	
	public HealthBar getHealthBar() {
		return healthbar;
	}
	
	
	public void collideCheck(Sprite sprite) throws SlickException {
		for (GameObject checkObject : collideAble) {
			if (sprite == checkObject || !sprite.getAlive()) {
				continue;
			}
			if (checkObject instanceof Bullet) {
				if (!((Bullet)checkObject).getImmune() && sprite.collide(checkObject.getPos())) {
					sprite.death();
					removeObject(checkObject);
				}
			} 
			if(checkObject instanceof Sprite) {
				if (!((Sprite) checkObject).getAlive()) {
					sprite.collideMove(sprite.getCollide(checkObject)*10);
				} else {
					sprite.collideMove(sprite.getCollide(checkObject));
				}
			} 
			
			if(sprite instanceof Player && checkObject instanceof PowerUp && sprite.getCollide(checkObject) > 0) {
				((PowerUp)checkObject).activate();
				removeObject(checkObject);
			}
		}
	}

	
	public void endGame() {
		end = true;
	}

	@Override
	public int getID() {
		return 1;
	}

}
