package assets;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sprites extends Utils {

    // Sprite Assets
    private static BufferedImage SRC_FROG, SRC_LOG, SRC_CAR;
    public static BufferedImage FROG, LOG, CAR;

    // Scale Factors
    private static double frogScaleFactor = 0.25;
    private static double logScaleFactor = 0.15;
    private static double carScaleFactor = 0.15;

    /**
     * Initializes the sprite assets by loading them a single time. It scales
     * the frog, log, and car images to the specified scale factors. It also
     * rotates the car image by 90 degrees.
     *
     * @throws IOException If there is an error loading the images or sounds
     * @throws NullPointerException If any of the image assets are not found
     */
    public static void init() {
        try {
            SRC_FROG = ImageIO.read(Sprites.class.getResourceAsStream("/images/frog-2.png"));
            SRC_LOG = ImageIO.read(Sprites.class.getResourceAsStream("/images/8-bit log.png"));
            SRC_CAR = ImageIO.read(Sprites.class.getResourceAsStream("/images/8-bit car.png"));

            if (SRC_FROG == null || SRC_LOG == null || SRC_CAR == null) {
                throw new IOException("One or more image assets could not be loaded. Check file paths.");
            }

        } catch (IOException | NullPointerException e) {
            throw new RuntimeException("Error loading images in Assets: ", e);
        }

        FROG = getScaledImage(SRC_FROG, frogScaleFactor);
        LOG = getScaledImage(SRC_LOG, logScaleFactor);
        CAR = rotateImage(getScaledImage(SRC_CAR, carScaleFactor), 90);

    }// init()

    /**
     * Set the scale factor for the frog image.
     *
     * @param scaleFactor The scale factor to set
     */
    public static void setFrogScaleFactor(double scaleFactor) {
        frogScaleFactor = scaleFactor;
    }// setFrogScaleFactor()

    /**
     * Set the scale factor for the log image.
     *
     * @param scaleFactor The scale factor to set
     */
    public static void setLogScaleFactor(double scaleFactor) {
        logScaleFactor = scaleFactor;
    }// setLogScaleFactor()

    /**
     * Set the scale factor for the car image.
     *
     * @param scaleFactor The scale factor to set
     */
    public static void setCarScaleFactor(double scaleFactor) {
        carScaleFactor = scaleFactor;
    }
}
