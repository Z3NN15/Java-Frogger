package main;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public abstract class GameObject {

    protected double x, y;
    protected BufferedImage src;

    /**
     * Constructor for the GameObject class
     *
     * @param image Image used for the object (Frog, Car, Log, etc.)
     * @param x initial horizontal position of the image
     * @param y initial vertical position of the image
     */
    public GameObject(BufferedImage image, double x, double y) {
        src = image;
        this.x = x;
        this.y = y;
    }

    // Image jawn methods to draw them jawns on screen
    public void drawOn(Graphics2D g2d) {
        g2d.drawImage(
                src,
                (int) x,
                (int) y,
                null
        );

        drawHitBox(g2d);
    }

		/**
		 * Returns the hitbox of this game object as a {@link Rectangle2D.Double}.
		 * The hitbox is typically used for collision detection.
		 *
		 * @return the {@code Rectangle2D.Double} representing the hitbox of this object
		 */
    public abstract Rectangle2D.Double getHitBox();

    public boolean overlaps(GameObject other) {
        return this.getHitBox().intersects(other.getHitBox());
    }

		/**
		 * Draws the hit box of this game object using the specified {@link Graphics2D} context.
		 * The hit box is rendered as a red rectangle, which can be useful for debugging
		 * collision detection and object boundaries.
		 *
		 * @param g2d the {@code Graphics2D} context used for drawing the hit box
		 */
    public void drawHitBox(Graphics2D g2d) {
        Rectangle2D.Double hitBox = this.getHitBox();
        g2d.setColor(java.awt.Color.RED);
        g2d.draw(hitBox);
    }

		/**
		 * Determines whether the game object is outside the visible game window.
		 *
		 * @return true if the object is completely off the screen either horizontally or vertically; false otherwise.
		 */
    public boolean isOffScreen() {
        boolean x1 = x + src.getWidth() < 0;
        boolean x2 = x > GameMain.WINDOW_WIDTH;
        boolean y1 = y < 0;
        boolean y2 = y > GameMain.WINDOW_HEIGHT;

        return x1 || x2 || y1 || y2;
    }

}
