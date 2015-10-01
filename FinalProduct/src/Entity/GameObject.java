package Entity;



import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import World.Game;

public class GameObject {
	private Image image;
	private Game world;
	private Vector2f position;
	public int dir;
	private float rotation;
	
	public GameObject() throws SlickException {
		image = new Image("res/images/blank.png");
		dir = 0;
		position = new Vector2f(0, 0);
		rotation = 0;
	}
	
	public void update(GameContainer gc, int delta) throws SlickException {
		
	}
	
	public void render(GameContainer gc, Graphics g) {
		image.setRotation(rotation);
		image.draw(position.x-(getWidth()/2), position.y-(getHeight()/2));
	}
	
	public int getWidth() {
		return image.getWidth();
	}
	
	public int getHeight() {
		return image.getHeight();
	}
	
	public void setImage(Image img) {
		image = img;
	}
	
	public Vector2f getPos() {
		return position;
	}
	
	public void setPos(float x, float y) {
		position.x = x;
		position.y = y;
	}
	
	public void setX(float x) {
		position.x = x;
	}
	
	public void setY(float y) {
		position.y = y;
	}
	
	
	public void changeX(float x) {
		position.x += x;
	}
	
	public void changeY(float y) {
		position.y += y;
	}
	
	public void setDir(int dir) {
		this.dir = dir;
	}
	
	public void setRot(float rot) {
		rotation = rot;
	}
	
	public float getRot() {
		return rotation;
	}
	
//	public void setBuffer(int buffer) {
//		this.buffer = buffer;
//	}
	
	public void setWorld(Game world) {
		this.world = world;
	}
	
	public Game getWorld() {
		return world;
	}
	
	public int getCollide(GameObject object) {
		if (object.getPos().y - object.getHeight()/2 <= position.y + (getHeight()/2) && 
				object.getPos().x + object.getWidth()/2 >= position.x - (getWidth()/2) &&
				object.getPos().x - object.getWidth()/2 <= position.x + (getWidth()/2) &&
				object.getPos().y + object.getHeight()/2 >= position.y - (getHeight()/2)) {
			return dir;
		} 
		return 0;
	}
}
