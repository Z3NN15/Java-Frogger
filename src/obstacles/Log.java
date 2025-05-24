
package obstacles;


import player.AbstractPlayer;

import java.awt.geom.Rectangle2D;

import Assets.;



public class Log extends AbstractObstacle{

	public Log(double x, double y, double speed) {
		super(MainAssets.LOG, x, y, speed);
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
		double paddingX = 0.1 * MainAssets.LOG.getWidth();
		double paddingY = 0.1 * MainAssets.LOG.getHeight();
		
		return new Rectangle2D.Double(
				x + paddingX,
				y + paddingY,
				MainAssets.LOG.getWidth() - 2 * paddingX,
				MainAssets.LOG.getHeight() - 2 * paddingY
				);
	}

}

