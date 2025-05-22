package obstacles;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import game.GameComponent;
import game.GameObject;
import player.AbstractPlayer;

/**
 * 
 */
public abstract class AbstractObstacle extends GameObject {

	protected double x, y, WIDTH, HEIGHT, speed;
	protected boolean offScreen;
	
	/**
	 * 
	 * @param image
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param speed
	 */
	public AbstractObstacle(GameComponent gc, double x, double y, double width, double height, double speed) {
		super(gc, x, y, width, height, speed, speed);
		this.x = x;
		this.y = y;
		this.WIDTH = width;
		this.HEIGHT = height;
		this.speed = speed;
		
	}//constructor
	
	
	public double getSpeed() {
		// Return the speed of the obstacle
		return speed;
	}//getSpeed
	
	@Override
	public void update() {
		super.update();
		x += speed;
		if (isOffScreen()) {
			markRemoved();
		}
	}//update
	
	@Override
	public void onRemove() {
		//Do nothing
	}
	
	// handle the collision with the player
	public abstract void collideWithPlayer(AbstractPlayer frog);
	
	
}
