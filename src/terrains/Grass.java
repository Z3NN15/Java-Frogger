package terrains;

import assets.Backgrounds;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import player.Frog;

/**
 * Represents a grass terrain tile in the game.
 * <p>
 * The {@code Grass} class extends {@link AbstractTerrain} and provides a
 * terrain type that does not interact with the {@link Frog} upon collision. It
 * defines a custom hitbox with padding for collision detection.
 * </p>
 *
 * @author Ayden Snedigar
 */
public class Grass extends AbstractTerrain {

    private final BufferedImage image;

    public Grass(
            BufferedImage image,
            double y
    ) {
        super(
                image,
                0,
                y
        );

        this.image = image;
    }

    public double getWidth() {
        return image.getWidth();
    }

    public double getHeight() {
        return image.getHeight();
    }

    @Override
    public void checkTerrainCollision(Frog frog) {
        /**
         * Do nothing
         */
    } //checkTerrainCollision

    @Override
    public Rectangle2D.Double getHitBox() {
        int w = Backgrounds.GRASS.getWidth();
        int h = Backgrounds.GRASS.getHeight();
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
