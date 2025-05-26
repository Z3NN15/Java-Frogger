package assets;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Backgrounds {

    // Terrain Assets
    public static BufferedImage WATER, GRASS, ROAD;

    public static void init() {
        try {
            WATER = ImageIO.read(
                    Backgrounds.class.getResourceAsStream(
                            "/images/water.jpg"
                    )
            );
            GRASS = ImageIO.read(
                    Backgrounds.class.getResourceAsStream(
                            "/images/grass.png"
                    )
            );
            ROAD = ImageIO.read(
                    Backgrounds.class.getResourceAsStream(
                            "/images/Road-1.png"
                    )
            );
        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to load 1 or more terrain assets",
                    e
            );
        }
    }// init()

}
