package player;

import game.GameComponent;
import game.GameObject;
import obstacles.AbstractObstacle;

public abstract class AbstractPlayer extends GameObject {

	protected double x, y, dx, dy, WIDTH, HEIGHT;
	protected boolean deathFlag;

	public AbstractPlayer(GameComponent gc, double x, double y, double width, double height) {
		super(gc, x, y, width, height);
		this.x = x;
		this.y = y;
		this.WIDTH = width;
		this.HEIGHT = height;
	}

	public void update(double dx, double dy) {
		// Update the player's position based on dx and dy
		this.x += dx;
		this.y += dy;

	}
	
	// Abstract methods for eating and removing flies
	public abstract void removeFly();

	public abstract void addFly();

	// Abstract method for collision with obstacles
	public abstract void handleCollision(AbstractObstacle obstacle);

}
