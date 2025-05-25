package assets.utils;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 * Utility class for resizing {@link BufferedImage} instances.
 * <p>
 * Provides methods for scaling images by a uniform or non-uniform factor.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 *     BufferedImage scaled = new ResizeUtil().simpleResizer(image, 0.5);
 *     BufferedImage advancedScaled = new ResizeUtil().advancedResizer(image, 0.5, 0.75);
 * </pre>
 * </p>
 *
 * <ul>
 * <li>{@link #simpleResizer(BufferedImage, double)}: Scales an image by a
 * single scale factor for both width and height.</li>
 * <li>{@link #advancedResizer(BufferedImage, double, double)}: Scales an image
 * by separate scale factors for width and height.</li>
 * </ul>
 *
 * <p>
 * Both methods return a new {@link BufferedImage} instance with the specified
 * dimensions.
 * </p>
 *
 * @author Ayden Snedigar
 */
public class ResizeUtil {

    /**
     * Scales the given image by the specified scale factor.
     *
     * @param src The source image to be scaled
     * @param scaleFactor The scale factor to apply
     * @return A new BufferedImage that is scaled by the given factor
     */
    public static BufferedImage simpleResizer(BufferedImage image, double scaleFactor) {
        int newWidth = (int) (image.getWidth() * scaleFactor);
        int newHeight = (int) (image.getHeight() * scaleFactor);

        BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaledImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(image, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        return scaledImage;
    }

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
    public static BufferedImage advancedResizer(BufferedImage image, double xScaleFactor, double yScaleFactor) {
        if (image == null || yScaleFactor <= 0 || xScaleFactor <= 0) {
            throw new IllegalArgumentException("Image cannot be null and scale factors must be positive.");
        }

        int newWidth = (int) (image.getWidth() * xScaleFactor);
        int newHeight = (int) (image.getHeight() * yScaleFactor);
        BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        scaledImage.getGraphics().drawImage(image, 0, 0, newWidth, newHeight, null);

        return scaledImage;
    }

}
