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
	
	public Car(GameComponent gc, double x, double y, double width, double height, double speed) {
		super(gc, x, y, width, height, speed);
	}

	@Override
	public void drawOn(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(CAR_IMAGE, (int) x, (int) y, null);
	}

	@Override
	public void collideWithPlayer(AbstractPlayer frog) {
		// TODO Auto-generated method stub
		frog.handleCollision(this);
	}
	
}
