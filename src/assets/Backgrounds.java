package assets;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Backgrounds extends Utils {

    // Terrain Assets
    private static BufferedImage SRC_WATER, SRC_GRASS, SRC_ROAD;
    public static BufferedImage WATER, GRASS, ROAD;

    private static double waterWidthScale = 0.15;
    private static double waterHeightScale = 0.15;
    private static double grassWidthScale = 0.15;
    private static double grassHeightScale = 0.15;
    private static double roadWidthScale = 0.15;
    private static double roadHeightScale = 0.15;

    public static void init() {
        try {
            SRC_WATER = ImageIO.read(Backgrounds.class.getResourceAsStream("/images/water.png"));
            SRC_GRASS = ImageIO.read(Backgrounds.class.getResourceAsStream("/images/grass.png"));
            SRC_ROAD = ImageIO.read(Backgrounds.class.getResourceAsStream("/images/road.png"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load terrain assets", e);
        }

        WATER = getScaledImage(SRC_WATER, waterHeightScale, waterWidthScale);
        GRASS = getScaledImage(SRC_GRASS, grassHeightScale, grassWidthScale);
        ROAD = getScaledImage(SRC_ROAD, roadHeightScale, roadWidthScale);
    }// init()

    /**
     * Scales the given image to the specified scale factor.
     *
     * @param image The image to scale
     * @param lenScaleFactor The scale factor that specifies the length of the
     * image
     * @param widthScaleFactor The scale factor that specifies the width of the
     * image
     * @return The scaled image
     */
    private static BufferedImage getScaledImage(BufferedImage image, double heightScaleFactor, double widthScaleFactor) {
        if (image == null || heightScaleFactor <= 0 || widthScaleFactor <= 0) {
            throw new IllegalArgumentException("Image cannot be null and scale factors must be positive.");
        }

        int newWidth = (int) (image.getWidth() * widthScaleFactor);
        int newHeight = (int) (image.getHeight() * heightScaleFactor);
        BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        scaledImage.getGraphics().drawImage(image, 0, 0, newWidth, newHeight, null);
        return scaledImage;
    }

    public static void setWaterScale(double waterWidthScale, double waterHeightScale) {
        Backgrounds.waterWidthScale = waterWidthScale;
        Backgrounds.waterHeightScale = waterHeightScale;
    }

    public static void setGrassScale(double grassWidthScale, double grassHeightScale) {
        Backgrounds.grassWidthScale = grassWidthScale;
        Backgrounds.grassHeightScale = grassHeightScale;
    }

    public static void setRoadScale(double roadWidthScale, double roadHeightScale) {
        Backgrounds.roadWidthScale = roadWidthScale;
        Backgrounds.roadHeightScale = roadHeightScale;
    }

}
