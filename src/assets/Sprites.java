package assets;

import assets.utils.ResizeUtil;
import assets.utils.RotateUtil;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sprites {

    // Sprite Assets
    private static BufferedImage SRC_FROG;
    private static BufferedImage SRC_LOG;
    private static BufferedImage SRC_CAR;
    private static BufferedImage SRC_FLY;

    public static BufferedImage FROG;
    public static BufferedImage LOG;
    public static BufferedImage CAR;
    public static BufferedImage FLY;

    // Scale Factors
    private static double frogScaleFactor = 0.25;
    private static double logScaleFactor = 0.15;
    private static double carScaleFactor = 0.15;
    private static double flyScaleFactor = 0.15;

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
            SRC_FROG = ImageIO.read(
                    Sprites.class.getResourceAsStream(
                            "/images/frog-2.png"
                    )
            );

            SRC_LOG = ImageIO.read(
                    Sprites.class.getResourceAsStream(
                            "/images/8-bit log.png"
                    )
            );

            SRC_CAR = ImageIO.read(
                    Sprites.class.getResourceAsStream(
                            "/images/8-bit car.png"
                    )
            );

            SRC_FLY = ImageIO.read(
                    Sprites.class.getResourceAsStream(
                            "/images/HappyFly.png"
                    )
            );

            if (SRC_FROG == null || SRC_LOG == null || SRC_CAR == null || SRC_FLY == null) {
                throw new IOException(
                        "One or more sprite assets could not be loaded. Check file paths."
                );
            }

        } catch (IOException | NullPointerException e) {
            throw new RuntimeException(
                    "Error loading images in Assets: ",
                    e
            );
        }

        FROG = ResizeUtil.simpleResizer(
                SRC_FROG,
                frogScaleFactor
        );

        LOG = ResizeUtil.simpleResizer(
                SRC_LOG,
                logScaleFactor
        );

        CAR = RotateUtil.rotateImage(
                ResizeUtil.simpleResizer(
                        SRC_CAR,
                        carScaleFactor
                ),
                90
        );

        FLY = ResizeUtil.simpleResizer(
                SRC_FLY,
                flyScaleFactor
        );

    }// init()

    /**
     * Sets the scale factor for the frog sprite.
     *
     * @param scaleFactor the new scale factor to apply to the frog sprite
     */
    public static void setFrogScaleFactor(double scaleFactor) {
        Sprites.frogScaleFactor = scaleFactor;
    }// setFrogScaleFactor()

    /**
     * Sets the scale factor for the log sprite.
     *
     * @param scaleFactor the new scale factor to apply to the log sprite
     */
    public static void setLogScaleFactor(double scaleFactor) {
        Sprites.logScaleFactor = scaleFactor;
    }// setLogScaleFactor()

    /**
     * Sets the scale factor for the car sprite.
     *
     * @param scaleFactor the new scale factor to apply to the fly sprite
     */
    public static void setCarScaleFactor(double scaleFactor) {
        Sprites.carScaleFactor = scaleFactor;
    }

    /**
     * Sets the scale factor for the fly sprite.
     *
     * @param scaleFactor the new scale factor to apply to the fly sprite
     */
    public static void setFlySclaeFactor(double scaleFactor) {
        Sprites.flyScaleFactor = scaleFactor;
    }
}
