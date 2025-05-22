package obstacles;


import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import game.GameComponent;
import java.awt.image.BufferedImage;
import java.io.File;
import player.AbstractPlayer;



public class Car extends AbstractObstacle {
	private static final BufferedImage CAR_IMAGE;
	
	static {
		try {
			CAR_IMAGE = ImageIO.read(new File("src/Images/car.png"));
		} catch (Exception e) {
			throw new RuntimeException("Failed to load car image", e);
		}
	}
	
	public Car(GameComponent gc, double scaleFactor, double x, double y, double speed) {
		super(gc, scaleFactor, x, y, CAR_IMAGE.getWidth(), CAR_IMAGE.getHeight(), speed);
		
	}

	@Override
	public void drawOn(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(CAR_IMAGE, (int) x, (int) y, null);
	}

	@Override
	public void collideWithPlayer(AbstractPlayer frog) {
		// Check if the frog is on the car
		if (frog.getX() < x + WIDTH && frog.getX() + frog.getWidth() > x && 
			frog.getY() < y + HEIGHT && frog.getY() + frog.getHeight() > y) {
			// Frog is hit by the car
			frog.isHit = true;
		}
	}
	
}
