package terrains;

import assets.Backgrounds;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import player.Frog;

/**
 * Represents a water terrain tile in the game. When a {@link Frog} collides
 * with this terrain, the game should end unless the frog is on a floating
 * object. This class extends {@link AbstractTerrain} and provides specific
 * collision logic and hitbox calculation for water tiles.
 *
 * <p>
 * The hitbox for the water terrain is slightly padded to provide more accurate
 * collision detection.
 * </p>
 *
 * @author Ayden Snedigar
 */
public class Water extends AbstractTerrain {

    private final BufferedImage image;

    /**
     * Constructs a new Water terrain object at the specified coordinates.
     *
     * @param y the y-coordinate of the water terrain's position
     * @param height the row height of the terrain
     */
    public Water(
            BufferedImage image,
            double y
    ) {

        super(
                image,
                0,
                y
        );

        this.image = image;
    }//constructor

    public double getWidth() {
        return image.getWidth();
    }

    public double getHeight() {
        return image.getHeight();
    }

    @Override
    public void checkTerrainCollision(Frog frog) {
        if (frog.overlaps(this)) {
            //TODO: If the frog is "in the water" the game should end
        }

    }//checkTerrainCollision

    @Override
    public Rectangle2D.Double getHitBox() {
        int w = Backgrounds.WATER.getWidth();
        int h = Backgrounds.WATER.getHeight();
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
