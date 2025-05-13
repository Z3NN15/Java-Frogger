package player;

public abstract class AbstractPlayer extends GameObject {

	public AbstractPlayer(GameComponent component, double x, double y, double dx, double dy, double width, double height) {
		super(component, x, y, dx, dy, width, height);
	}
	
	public abstract void removeFly();
	public abstract void addFly();
	
	public void isEaten() {
		
	}
	
	
}
