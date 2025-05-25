package terrains;

import java.awt.image.BufferedImage;
import main.GameObject;
import player.Frog;

/**
 * Terrain is an abstract class that represents a game object that can be drawn
 * on the screen. It extends the GameObject class and provides a constructor to
 * initialize the image, position, and size of the terrain.
 *
 * @author Ayden Snedigar and Chris Renda
 */
public abstract class AbstractTerrain extends GameObject {


    public AbstractTerrain(BufferedImage image, double x, double y) {
        super(
                image,
                x,
                y
        );
    }

    public abstract void checkTerrainCollision(Frog frog);

    

}
