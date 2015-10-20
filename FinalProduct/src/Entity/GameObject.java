package Entity;



import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import World.Game;

public class GameObject {
	private Image image; //Image representing the Object
	private static Game world; //Reference to the "Game" class
	private Vector2f position; //Coordinates of the center of the Object image relative to screen.
	private float rotation = 0; //Rotation of image (degrees)
	private Vector2f velocity; //Direction vector of this object
	
	public GameObject() throws SlickException {
		image = new Image("res/images/blank.png"); //filler image
		position = new Vector2f(0, 0);
		velocity = new Vector2f(0, 0);
	}
	
	public void update(GameContainer gc, int delta) throws SlickException {
		
	}
	
	public void render(GameContainer gc, Graphics g) {
		image.setRotation(rotation);
		image.draw(position.x-(getWidth()/2), position.y-(getHeight()/2)); //draws Object image around the center of it's position coordinates
	}
	
	public static void setWorld(Game world) {
		GameObject.world = world;
	}
	
	public static Game getWorld() {
		return world;
	}
	
	public Image getImage() {
		return image;
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

	
	public void setRot(float rot) {
		rotation = rot;
	}
	
	public float getRot() {
		return rotation;
	}
	
	public void setV(float x, float y) {
		velocity.x = x;
		velocity.y = y;
	}
	
	public Vector2f getV() {
		return velocity;
	}
	
	
	public Vector2f getCollide(GameObject object) {
		if (object.getPos().y - object.getHeight()/2 <= position.y + (getHeight()/2) && 
				object.getPos().x + object.getWidth()/2 >= position.x - (getWidth()/2) &&
				object.getPos().x - object.getWidth()/2 <= position.x + (getWidth()/2) &&
				object.getPos().y + object.getHeight()/2 >= position.y - (getHeight()/2)) {
			return object.getV();
		} 
		return null;
	}
}
