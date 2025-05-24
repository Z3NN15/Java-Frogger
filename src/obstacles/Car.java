package obstacles;

import assets.Sprites;
import java.awt.geom.Rectangle2D;
import player.AbstractPlayer;

public class Car extends AbstractObstacle {

    public Car(double x, double y, double speed) {
        super(Sprites.CAR, x, y, speed);
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
        double paddingX = 0.10 * Sprites.CAR.getWidth();
        double paddingY = 0.25 * Sprites.CAR.getHeight();

        return new Rectangle2D.Double(
                x + paddingX,
                y + paddingY,
                Sprites.CAR.getWidth() - 2 * paddingX,
                Sprites.CAR.getHeight() - 2 * paddingY
        );
    }

}
