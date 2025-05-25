package obstacles;

import java.awt.image.BufferedImage;
import main.GameObject;
import player.AbstractPlayer;

/**
 * AbstractObstacle is an abstract class that represents an obstacle in the
 * game. It extends the GameObject class and provides a constructor to
 * initialize the image, position, and speed of the obstacle.
 *
 * @author Ayden Snedigar and Chris Renda
 */
public abstract class AbstractObstacle extends GameObject {

    protected double speed;

    /**
     * Constructor for the AbstractObstacle class
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param speed
     */
    public AbstractObstacle(BufferedImage image, double x, double y, double speed) {
        super(
                image,
                x,
                y
        );

        this.speed = speed;

    }//constructor

    public double getSpeed() {
        // Return the speed of the obstacle
        return speed;
    }//getSpeed

    public void update() {
        x += speed;
    }//update

    // handle the collision with the player
    public abstract void handleCollision(AbstractPlayer frog);

}
