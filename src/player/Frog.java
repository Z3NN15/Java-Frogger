package player;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import assets.Sprites;
import assets.Sounds;

imports

assets.

/**
 *
 * @author Ayden Snedigar and Chris Renda
 */
public class Frog extends AbstractPlayer {

    // Save spawn point for respawn on death
    private final double startX, startY;

    /**
     *
     * @param gc The game component you want the frog to be drawn on
     * @param scaleFactor modifier for the size of the image
     * @param x The starting x position of the frog
     * @param y The starting y position of the frog
     */
    public Frog(double x, double y) {
        super(Sprites.FROG, x, y);
        this.startX = x;
        this.startY = y;

    }

    @Override
    public void drawOn(Graphics2D g2d) {
        g2d.drawImage(Sprites.FROG, (int) this.getX(), (int) this.getY(), null);
        this.drawHitBox(g2d);
    }

    public boolean handleEat(Fly fly) {
        // Changed to inherited x instead of local x
        return fly.getX() == x;
    }// handleEat

    public void handleDeath() {

        this.x = startX;
        this.y = startY;
    }// handleDeath

    @Override
    public Rectangle2D.Double getHitBox() {
        double paddingX = 0.15 * AbstractAssets.FROG.getWidth();
        double paddingY = 0.1 * AbstractAssets.FROG.getHeight();

        return new Rectangle2D.Double(
                x + paddingX,
                y + paddingY,
                AbstractAssets.FROG.getWidth() - 2 * paddingX,
                AbstractAssets.FROG.getHeight() - 2 * paddingY
        );
    }// getHitBox

}
