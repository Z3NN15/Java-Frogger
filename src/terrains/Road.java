package terrains;

import assets.Backgrounds;
import java.awt.geom.Rectangle2D;
import player.Frog;

/**
 * Represents a road terrain in the game.
 * <p>
 * The {@code Road} class extends {@link AbstractTerrain} and provides the
 * specific implementation for a road area where the frog can move. It overrides
 * the collision check to do nothing, as roads do not interact with the frog in
 * terms of collision.
 * </p>
 *
 * <p>
 * The hitbox for the road is defined with some padding to better fit the visual
 * representation.
 * </p>
 *
 * @author Ayden Snedigar
 */
public class Road extends AbstractTerrain {

    public Road(double x, double y) {
        super(
                Backgrounds.ROAD,
                x,
                y
        );
    }

    @Override
    public void checkTerrainCollision(Frog frog) {
        /**
         * Do nothing
         */
    }

    @Override
    public Rectangle2D.Double getHitBox() {
        int w = Backgrounds.ROAD.getWidth();
        int h = Backgrounds.ROAD.getHeight();
        double paddingX = 0.15 * w;
        double paddingY = 0.1 * h;

        return new Rectangle2D.Double(
                x + paddingX,
                y + paddingY,
                w - 2 * paddingX,
                h - 2 * paddingY
        );
    }

}
