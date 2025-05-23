package main;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Assets {
	private static BufferedImage SRC_FROG, SRC_LOG, SRC_CAR;
	public static BufferedImage FROG, LOG, CAR;
	protected static double frogScaleFactor, logScaleFactor, carScaleFactor;
	public static Clip frogDeathSound, moveSound, gameOverSound;

	public static void init() {
		loadSounds();
		loadImages();

		FROG = getScaledImage(SRC_FROG, frogScaleFactor);
		LOG = getScaledImage(SRC_LOG, logScaleFactor);
		CAR = rotateImage(getScaledImage(SRC_CAR, carScaleFactor), 90);

	}

	private static void loadImages() {
		try {
			SRC_FROG = ImageIO.read(Assets.class.getResourceAsStream("/resources/frog-2.png"));
			SRC_LOG = ImageIO.read(Assets.class.getResourceAsStream("/resources/8-bit log.png"));
			SRC_CAR = ImageIO.read(Assets.class.getResourceAsStream("/resources/8-bit car.png"));

			if (SRC_FROG == null || SRC_LOG == null || SRC_CAR == null) {
				throw new IOException("One or more image assets could not be loaded. Check file paths.");
			}

		} catch (IOException | NullPointerException e) {
			throw new RuntimeException("Error loading images in Assets: ", e);
		}
	}

	private static void loadSounds() {
		frogDeathSound = loadClip("/resources/womp-womp.mp3");
		moveSound = loadClip("/resources/frog-croak.mp3");
		gameOverSound = loadClip("/resources/kermit-is-never-gonna-give-you-up.mp3");
	}

	private static BufferedImage getScaledImage(BufferedImage src, double scaleFactor) {
		int w = (int) (src.getWidth() * scaleFactor);
		int h = (int) (src.getHeight() * scaleFactor);

		// Create a new image with the new dimensions
		BufferedImage resized = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = resized.createGraphics();
		g2d.drawImage(src, 0, 0, w, h, null);
		g2d.dispose();
		return resized;
	}

	/**
	 * 
	 * @param src   Image to be rotated
	 * @param angle Angle in degrees
	 * @return Returns the image rotated by the given angle
	 */
	public static BufferedImage rotateImage(BufferedImage src, double angle) {
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

	}

	/**
	 * Set the scale factor for the frog image.
	 * 
	 * @param scaleFactor The scale factor to set
	 */
	public static void setFrogScaleFactor(double scaleFactor) {
		frogScaleFactor = scaleFactor;
	}

	/**
	 * Set the scale factor for the log image.
	 * 
	 * @param scaleFactor The scale factor to set
	 */
	public static void setLogScaleFactor(double scaleFactor) {
		logScaleFactor = scaleFactor;
	}

	/**
	 * Set the scale factor for the car image.
	 * 
	 * @param scaleFactor The scale factor to set
	 */
	public static void setCarScaleFactor(double scaleFactor) {
		carScaleFactor = scaleFactor;
	}

	/**
	 * Loads a sound clip from the given path.
	 * 
	 * @param path The path to the sound file
	 * @return The loaded Clip object
	 */
	private static Clip loadClip(String path) {
		try (InputStream audioSrc = Assets.class.getResourceAsStream(path);
				InputStream bufferedIn = new java.io.BufferedInputStream(audioSrc);
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn)) {

			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			return clip;

		} catch (Exception e) {
			System.err.println("Error loading audio: " + path);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Plays the given sound clip. If the clip is already playing, it stops and
	 * restarts it.
	 * 
	 * @param clip The sound clip to play
	 */
	public static void playSound(Clip clip) {
		if (clip != null) {
			clip.stop(); // Stop if it's already playing
			clip.setFramePosition(0); // Rewind to beginning
			clip.start();
		}

	}
}
