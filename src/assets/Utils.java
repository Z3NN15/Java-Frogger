package assets;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 * The Assets class is responsible for loading and managing game assets such as
 * images and sounds. It provides methods to initialize, scale, rotate, and play
 * sound clips.
 *
 * @author Ayden Snedigar and Chris Renda
 */
abstract class Utils {

    /**
     * Scales the given image by the specified scale factor.
     *
     * @param src The source image to be scaled
     * @param scaleFactor The scale factor to apply
     * @return A new BufferedImage that is scaled by the given factor
     */
    @SuppressWarnings("unused")
    static BufferedImage getScaledImage(BufferedImage src, double scaleFactor) {
        int newWidth = (int) (src.getWidth() * scaleFactor);
        int newHeight = (int) (src.getHeight() * scaleFactor);

        BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaledImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(src, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        return scaledImage;
    }// getScaledImage()

    /**
     *
     * @param src Image to be rotated
     * @param angle Angle in degrees
     * @return Returns the image rotated by the given angle
     */
    @SuppressWarnings("unused")
    static BufferedImage rotateImage(BufferedImage src, double angle) {
        double radians = Math.toRadians(angle);

        int w = src.getWidth();
        int h = src.getHeight();

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

        g2d.drawRenderedImage(src, null);
        g2d.dispose();

        return rotatedImage;
    }// rotateImage()

}
