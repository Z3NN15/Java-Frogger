package player;


import game.GameComponent;
import game.GameObject;
import obstacles.AbstractObstacle;
import obstacles.Log;

public abstract class AbstractPlayer extends GameObject {
	
	protected int x, y, speed, WIDTH, HEIGHT;
	protected boolean deathFlag;
	
	
	public AbstractPlayer(GameComponent gc, int x, int y, int width, int height, int speed) {
		super(gc, x, y, width, height, speed, speed);
		this.x = x;
		this.y = y;
		this.WIDTH = width;
		this.HEIGHT = height;
		this.speed = speed;
	}
	
	// Abstract methods for eating and removing flies	
	public abstract void removeFly();
	public abstract void addFly();

	// Abstract method for collision with obstacles
	public abstract void handleCollision(AbstractObstacle obstacle);
	
	
	
}
