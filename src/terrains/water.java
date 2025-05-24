package terrains;

import java.awt.image.BufferedImage;
import player.AbstractPlayer;


public class water extends AbstractTerrain {
    
    /**
     * Constructor for the water class
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public water(BufferedImage image, int x, int y, int width, int height) {
        super(image, x, y, width, height);
        
    }//constructor
    
    @Override
    public void checkTerrainCollision(AbstractPlayer frog) {
        
    }//checkTerrainCollision

}
