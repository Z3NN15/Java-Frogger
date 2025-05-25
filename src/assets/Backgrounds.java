package assets;

import assets.utils.ResizeUtil;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Backgrounds {

    // Terrain Assets
    private static BufferedImage SRC_WATER, SRC_GRASS, SRC_ROAD;
    public static BufferedImage WATER, GRASS, ROAD;

    private static double waterXScale = 0.15;
    private static double waterYScale = 0.15;
    private static double grassXScale = 0.15;
    private static double grassYScale = 0.15;
    private static double roadXScale = 0.15;
    private static double roadYScale = 0.15;

    public static void init() {
        try {
            SRC_WATER = ImageIO.read(
                    Backgrounds.class.getResourceAsStream(
                            "/images/water.jpg"
                    )
            );
            SRC_GRASS = ImageIO.read(
                    Backgrounds.class.getResourceAsStream(
                            "/images/grass.png"
                    )
            );
            SRC_ROAD = ImageIO.read(
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

        WATER = ResizeUtil.advancedResizer(
                SRC_WATER,
                waterXScale,
                waterYScale
        );
        GRASS = ResizeUtil.advancedResizer(
                SRC_GRASS,
                grassXScale,
                grassYScale
        );
        ROAD = ResizeUtil.advancedResizer(
                SRC_ROAD,
                roadXScale,
                roadYScale
        );
    }// init()

    public static void setWaterScale(double xScaleFactor, double yScaleFactor) {
        Backgrounds.waterXScale = xScaleFactor;
        Backgrounds.waterYScale = yScaleFactor;
    }

    public static void setGrassScale(double xScaleFactor, double yScaleFactor) {
        Backgrounds.grassXScale = xScaleFactor;
        Backgrounds.grassYScale = yScaleFactor;
    }

    public static void setRoadScale(double xScaleFactor, double yScaleFactor) {
        Backgrounds.roadXScale = xScaleFactor;
        Backgrounds.roadYScale = yScaleFactor;
    }

}
