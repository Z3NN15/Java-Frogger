package assets.utils;

import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Utility class for loading and playing sound clips in the application.
 * <p>
 * Provides static methods to load audio files as
 * {@link javax.sound.sampled.Clip} objects and to play them.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 *     Clip clip = SoundUtil.loadClip("/sounds/jump.wav");
 *     SoundUtil.playSound(clip);
 * </pre>
 * </p>
 *
 * @author Ayden Snedigar
 */
public class SoundUtil {

    /**
     * Loads a sound clip from the given path.
     *
     * @param path The path to the sound file
     * @return The loaded Clip object
     */
    public static Clip loadClip(String path) {
        try (InputStream audioSrc = SoundUtil.class.getResourceAsStream(path); InputStream bufferedIn = new java.io.BufferedInputStream(audioSrc); AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn)) {

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            return clip;

        } catch (Exception e) {
            System.err.println("Error loading audio: " + path);
            return null;
        }
    }// loadClip()

    
    /**
     * Plays the given audio clip from the beginning. If the clip is already playing,
     * it will be stopped and restarted from the start.
     *
     * @param clip the {@link Clip} object to be played; if {@code null}, no action is taken
     */
    public static void playSound(Clip clip) {
        if (clip != null) {
            clip.stop(); // Stop if it's already playing
            clip.setFramePosition(0); // Rewind to beginning
            clip.start();
        }

    }// playSound()
}
