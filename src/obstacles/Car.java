package obstacles;
import java.awt.geom.Rectangle2D;

import main.Assets;
import player.AbstractPlayer;

public class Car extends AbstractObstacle {
	
	public Car(double x, double y, double speed) {
		super(Assets.CAR, x, y, speed);
	}
	
	@Override
	public void handleCollision(AbstractPlayer frog) {
		// Check if the frog is on the car
		if (this.overlaps(frog)) {
			// Frog is hit by the car
			frog.isHit = true;
		}
	}
	
	@Override
	public Rectangle2D.Double getHitBox() {
		double paddingX = 0.10 * this.getWidth();
		double paddingY = 0.25 * this.getHeight();
		
		return new Rectangle2D.Double(
				x + paddingX,
				y + paddingY,
				this.getWidth() - 2 * paddingX,
				this.getHeight() - 2 * paddingY
				);
	}
	
}
