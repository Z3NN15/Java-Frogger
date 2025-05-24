package assets.utils;

public class AudioUtils {

    /**
     * Loads a sound clip from the given path.
     *
     * @param path The path to the sound file
     * @return The loaded Clip object
     */
    @SuppressWarnings("unused")
    static Clip loadClip(String path) {
        try (InputStream audioSrc = Utils.class.getResourceAsStream(path); InputStream bufferedIn = new java.io.BufferedInputStream(audioSrc); AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn)) {

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            return clip;

        } catch (Exception e) {
            System.err.println("Error loading audio: " + path);
            return null;
        }
    }// loadClip()

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

    }// playSound() 
}
