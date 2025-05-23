
package obstacles;


import player.AbstractPlayer;

import java.awt.geom.Rectangle2D;

import main.Assets;



public class Log extends AbstractObstacle{

	public Log(double x, double y, double speed) {
		super(Assets.LOG, x, y, speed);
	}
	
	@Override
	public void handleCollision(AbstractPlayer frog) {
		// Check if the frog is on the log
		if (this.overlaps(frog)) {
			// Move the frog with the log
			frog.setMoveDelta(this.getSpeed(), 0);
			frog.update();
			
		}
	}
	
	@Override
	public Rectangle2D.Double getHitBox() {
		double paddingX = 0.1 * Assets.LOG.getWidth();
		double paddingY = 0.1 * Assets.LOG.getHeight();
		
		return new Rectangle2D.Double(
				x + paddingX,
				y + paddingY,
				Assets.LOG.getWidth() - 2 * paddingX,
				Assets.LOG.getHeight() - 2 * paddingY
				);
	}

}

