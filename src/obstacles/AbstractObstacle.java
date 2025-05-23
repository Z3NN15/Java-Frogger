package obstacles;

import java.awt.image.BufferedImage;

import main.GameObject;
import player.AbstractPlayer;

/**
 * 
 */
public abstract class AbstractObstacle extends GameObject {
	
	
	protected double speed;
	
	/**
	 * Constructor for the AbstractObstacle class
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param speed
	 */
	public AbstractObstacle(BufferedImage image, double x, double y, double speed) {
		super(image, x, y);
		this.speed = speed;
		
	}//constructor
	
	public double getSpeed() {
		// Return the speed of the obstacle
		return speed;
	}//getSpeed
	
	public void update() {
		x += speed;
	}//update
	
	// handle the collision with the player
	public abstract void handleCollision(AbstractPlayer frog);
	
	
}
