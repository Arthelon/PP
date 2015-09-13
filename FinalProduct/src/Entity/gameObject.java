package Entity;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class gameObject {
	private Image image;
	private Vector2f position;
	
	public gameObject() throws SlickException {
		image = new Image("res/images/blank.png");
		position = new Vector2f(0, 0);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
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
	
	public void setX(int x) {
		position.x = x;
	}
	
	public void setY(int y) {
		position.y = y;
	}
	
	public void changeX(float x) {
		position.x += x;
	}
	
	public void changeY(float y) {
		position.y += y;
	}
	
	public boolean atWorldEdge() {
		return position.x < getWidth() / 2 || position.x > 592 - getWidth() / 2 || 
				position.x < getHeight() / 2 || position.y > 700 - getHeight() / 2;
	}
}
