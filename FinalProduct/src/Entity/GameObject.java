package Entity;



import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import World.Game;

public class GameObject {
	protected static final float MAPSPEED = 0.05f;
	
	private Image image; //Image representing the Object
	private static Game world; //Stores reference to the "Game" state/class
	private Vector2f position; //Coordinates representing the rendered center of the GameObject relative to screen.
	private float rotation = 0; //Rotation of image (degrees)
	private Vector2f velocity; //Movement vector of this object
	private static boolean mapStopped = false;
	
	public GameObject() throws SlickException {
		image = new Image("res/images/blank.png"); //filler image
		position = new Vector2f(0, 0); //Is rendered at the top-left corner of the screen by default
		velocity = new Vector2f(0, 0); 
	}
	
	public void update(GameContainer gc, int delta) throws SlickException {
		//No game logic
	}
	
	public void render(GameContainer gc, Graphics g) {
		image.setRotation(rotation);
		image.draw(position.x-(getWidth()/2), position.y-(getHeight()/2)); //draws Object image around the center of it's position coordinates
	}
	/*
	 * Sets reference to the "Game" state
	 */
	public static void setWorld(Game world) { 
		GameObject.world = world;
	}
	/*
	 * Accessor method to the "Game" state where this GameObject is in
	 */
	public static Game getWorld() { 
		return world;
	}
	/*
	 * Accessor method to the GameObject's Image (which is an instance of the Slick2D Image class)
	 */
	public Image getImage() { //
		return image;
	}
	/*
	 * Returns the width of the GameObject's image (int)
	 */
	public int getWidth() {
		return image.getWidth();
	}
	/*
	 * Returns the height of the GameObject's image (int)
	 */
	public int getHeight() {
		return image.getHeight();
	}
	/*
	 * Modifier method for the GameObject's image 
	 */
	public void setImage(Image img) {
		image = img;
	}
	/*
	 * Accessor method to the GameObject's coordinates on the screen.
	 * Returns an instance of Vector2f (Slick2D class)
	 */
	public Vector2f getPos() {
		return position;
	}
	/*
	 * Modifier method for the GameObject's x and y coordinates
	 */
	public void setPos(float x, float y) {
		position.x = x;
		position.y = y;
	}
	/*
	 * Modifier method for the GameObject's x coordinates
	 * Increases it's current x coordinate by the passed argument (Decreases if negative)
	 */
	public void changeX(float x) {
		position.x += x;
	}
	
	/*
	 * Modifier method for the GameObject's y coordinates
	 * Increases it's current y coordinate by the passed argument (Decreases if negative)
	 */
	public void changeY(float y) {
		position.y += y;
	}

	/*
	 * Modifier method for the GameObject's image rotation. 
	 * Rotates image by the specified argument (in angles)
	 */
	public void setRot(float rot) {
		rotation = rot;
	}
	/*
	 * Accessor method for the GameObject's image rotation
	 */
	public float getRot() {
		return rotation;
	}
	/*
	 * Modifier method for the GameObject's movement vector
	 * Sets the x and y values of the instance's movement vector to the passed arguments
	 */
	public void setV(float x, float y) {
		velocity.x = x;
		velocity.y = y;
	}
	/*
	 * Accessor method for the GameObject's movement vector
	 * Returns a Vector2f (Slick2D class) object 
	 */
	public Vector2f getV() {
		return velocity;
	}
	/*
	 * Modifier method for the mapStopped static boolean
	 * Invoked by the "Game" state when the map is stopped so that the behaviour of the GameObjects can react accordingly.
	 */
	public static void stopMap() {
		mapStopped = true;
	}
	/*
	 * Accessor method for the mapStopped static boolean
	 */
	public static boolean isMapStopped() {
		return mapStopped;
	}
	/*
	 * Checks if this GameObject's collision box (image boundaries) intersects with the argument's collision box
	 * Returns the argument's movement vector if intersecting, otherwise it returns null.
	 */
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
