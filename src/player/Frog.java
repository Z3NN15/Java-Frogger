package player;

import assets.Sprites;
import assets.utils.SoundUtil;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

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
        super(
                Sprites.FROG,
                x,
                y
        );

        this.startX = x;
        this.startY = y;

    }

    @Override
    public void drawOn(Graphics2D g2d) {
        g2d.drawImage(
                Sprites.FROG,
                (int) this.getX(),
                (int) this.getY(),
                null
        );

        this.drawHitBox(g2d);
    }

    public boolean handleEat(Fly fly) {
        // Changed to inherited x instead of local x
        return fly.getX() == x;
    }// handleEat

    @Override
    public void handleDeath() {
        SoundUtil.playSound(assets.Sounds.frogDeathSound);
        this.x = startX;
        this.y = startY;
    }// handleDeath

    @Override
    public Rectangle2D.Double getHitBox() {
        double paddingX = 0.15 * Sprites.FROG.getWidth();
        double paddingY = 0.1 * Sprites.FROG.getHeight();

        return new Rectangle2D.Double(
                x + paddingX,
                y + paddingY,
                Sprites.FROG.getWidth() - 2 * paddingX,
                Sprites.FROG.getHeight() - 2 * paddingY
        );
    }// getHitBox

}
