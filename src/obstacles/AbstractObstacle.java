package obstacles;

import game.GameComponent;
import game.GameObject;
import player.AbstractPlayer;

/**
 * 
 */
public abstract class AbstractObstacle extends GameObject {

	protected double speed;
	protected boolean offScreen;
	private boolean removed;
	
	/**
	 * Constructor for the AbstractObstacle class
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param speed
	 */
	public AbstractObstacle(GameComponent gc, double scaleFactor, double x, double y, double width, double height, double speed) {
		super(gc, scaleFactor, x, y, width, height);
		this.speed = speed;
		
	}//constructor
	
	public double getSpeed() {
		// Return the speed of the obstacle
		return speed;
	}//getSpeed
	
	public void update() {
		x += speed;
		if (isOffScreen()) {
			markToRemove();
		}
	}//update
	
	@Override
	public boolean isRemoved() {
		return removed;
	}//isRemoved
	
	@Override
	protected void markToRemove() {
		removed = true;
	}//markToRemove
	
	// handle the collision with the player
	public abstract void collideWithPlayer(AbstractPlayer frog);
	
	
}
