package assets.utils;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 * Utility class for rotating images.
 * <p>
 * Provides a method to rotate a {@link BufferedImage} by a specified angle,
 * returning a new image with the rotated content and adjusted dimensions.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * BufferedImage rotated = new RotateUtil().rotateImage(originalImage, 45);
 * </pre>
 * </p>
 *
 * @author Ayden Snedigar
 */
public class RotateUtil {

    /**
     *
     * @param image Image to be rotated
     * @param angle Desired angle in degrees
     * @return Returns the image rotated by the given angle
     */
    public static BufferedImage rotateImage(BufferedImage image, double angle) {
        double radians = Math.toRadians(angle);

        int w = image.getWidth();
        int h = image.getHeight();

        // Calculate the new dimensions of the image after rotation
        double sin = Math.abs(Math.sin(radians));
        double cos = Math.abs(Math.cos(radians));
        int newWidth = (int) Math.round(w * cos + h * sin);
        int newHeight = (int) Math.round(h * cos + w * sin);

        // Create a new image with the new dimensions
        BufferedImage rotatedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotatedImage.createGraphics();

        // Anti-aliasing for better quality
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Translate to the center of the new image
        g2d.translate((newWidth - w) / 2.0, (newHeight - h) / 2.0);

        // Rotate the image about the center
        g2d.rotate(radians, w / 2.0, h / 2.0);

        g2d.drawRenderedImage(image, null);
        g2d.dispose();

        return rotatedImage;
    }
}
