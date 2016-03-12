package World;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeOutTransition;

import Entity.Bomb;
import Entity.Bomber;
import Entity.Bullet;
import Entity.Enemy;
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
	private final float MAPSPEED = 1f; //Rate at which map moves upwards
	private FadeOutTransition fadeToBlack = new FadeOutTransition(new Color(Color.black), 2000);
	private StateBasedGame sbg; 
	private End endWorld;
	
	//ArrayLists holding Game Objects
	private ArrayList<GameObject> objectList = new ArrayList<GameObject>();
	private ArrayList<GameObject> addList = new ArrayList<GameObject>();
	private ArrayList<GameObject> removeList = new ArrayList<GameObject>();
	private ArrayList<GameObject> collideAble = new ArrayList<GameObject>();
	private ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	
	//Declaration of classes that will remain throughout the run-time of the Game
	private Player player;
	private ScoreBoard scoreboard;
	private HealthBar healthbar;
	private Image map;
	
	public Game(int screenX, int screenY, End endWorld) {
		//Size of screen in pixels
		this.screenX = screenX;
		this.screenY = screenY;
		this.endWorld = endWorld;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		backMusic = new Music("res/sound/levelTheme.ogg"); //Initialization of background Music
		if (first) {
			first = false;
			backMusic.loop(); //Plays background Music on Loop
			//Initialization of declared GameObjects, adding them to the GameObject's ArrayList
			player = new Player();
			scoreboard = new ScoreBoard();
			healthbar = new HealthBar();
			addObject(player);
			addObject(scoreboard);
			addObject(healthbar);
			
			this.sbg = sbg; //Passes a reference to the state's StateBasedGame class to a global variable
			map = new Image("res/images/startMap.png"); //Map image initialization
			mapY = -(map.getHeight() - screenY); //Map's south edge is initially positioned at the bottom of the screen.
			GameObject.setWorld(this); //Adds a reference to this Game state in all GameObjects.
		}
		first = true; //Trigger boolean variable
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		map.draw(0, mapY); //Renders map
		//Renders all GameObjects with a for-each loop
		for (GameObject object : objectList) {
			object.render(gc, g);
		}
		if (end) {
			fadeToBlack.postRender(sbg, gc, g); //Renders the FadeOutTransition object (fadeToBlack)
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if (player.getAnimation().isStopped() || (GameObject.isMapStopped() 
				&& Shooter.getCount() == 0 && Bomber.getCount() == 0)) {
			backMusic.stop();
			end = true;
		}
		if (end) {
			fadeToBlack.update(sbg, gc, delta);
			if (fadeToBlack.isComplete()) {
				fadeToBlack = new FadeOutTransition(new Color(Color.black), 2000);
				sbg.getState(2).init(gc, sbg); //Initializes End class
				endWorld.setScore(scoreboard.getScore());
				sbg.enterState(2); //Enters end class (identified using the state ID of 2)
			}
		} else {
			updateObjects(gc, delta);
		}
	}
	
	public void updateObjects(GameContainer gc, int delta) throws SlickException {
		//Spawns instances of these Sprite classes randomly at the top edge of the screen
		Shooter.spawn(delta);
		Bomber.spawn(delta);
		Fence.spawn(delta);
		
		for (GameObject object : objectList) {
			object.update(gc, delta);
			if (object instanceof Bullet || object instanceof PowerUp) {
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
		if (mapY + MAPSPEED * delta < 0) {
			mapY += delta * MAPSPEED;
		} else {
			GameObject.stopMap();
		}
		
		sprites.clear();
		collideAble.clear();
		addList.clear();
		removeList.clear();
	}
	
	public Vector2f getPlayerPos() {
		return player.getPos();
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
			if (sprite == checkObject || !sprite.getAlive() || 
					(checkObject instanceof Enemy && 
					sprite instanceof Enemy)) {
				continue;
			}
			if (checkObject instanceof Bullet) {
				if (!((Bullet)checkObject).getImmune() && sprite.getCollide(checkObject) != null) {
					if (((Bullet)checkObject).isEnemyFired() && sprite instanceof Enemy) {
					} else {
						sprite.death();
						removeObject(checkObject);
					}
				}
				continue;
			} 
			if((checkObject instanceof Sprite) && sprite.getCollide(checkObject) != null) {
				sprite.collideMove(sprite.getCollide(checkObject));
				if (sprite instanceof Player && checkObject instanceof Enemy && ((Sprite) checkObject).getAlive()) {
					sprite.death();
				}
				continue;
			} 
			if(sprite instanceof Player && checkObject instanceof PowerUp && sprite.getCollide(checkObject) != null) {
				((PowerUp)checkObject).activate();
				removeObject(checkObject);
				continue;
			}
		}
	}
	
	public void bombActive(Bomb bomb) {
		if (player.getCollide(bomb) != null) {
			player.death();
		}
	}
	
	public void endGame() {
		backMusic.stop();
		GameObject.stopMap();
		fadeToBlack.init(sbg.getCurrentState(), sbg.getState(2));
	}

	@Override
	public int getID() {
		return 1;
	}

}
