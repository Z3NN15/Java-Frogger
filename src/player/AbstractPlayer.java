package player;

import game.GameComponent;
import game.GameObject;
import obstacles.AbstractObstacle;

public abstract class AbstractPlayer extends GameObject {

	protected double dx, dy;
	protected boolean deathFlag;

	public AbstractPlayer(GameComponent gc, double scaleFactor, double x, double y, double width, double height) {
		super(gc, scaleFactor, x, y, width, height);

	}

	public void update(double dx, double dy) {
		// Update the player's position based on dx and dy
		x += dx;
		y += dy;

	}
	
	// Abstract methods for eating and removing flies
	public abstract void removeFly();

	public abstract void addFly();
	
	// Abstract method for handling player/fly death
	public abstract void handleDeath();

	// Abstract method for collision with obstacles
	public abstract void handleCollision(AbstractObstacle obstacle);

}
