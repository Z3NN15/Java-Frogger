package assets;

import assets.utils.SoundUtil;
import java.io.IOException;
import javax.sound.sampled.Clip;

public class Sounds {

    // Sound Assets
    public static Clip frogDeathSound;
    public static Clip moveSound;
    public static Clip gameOverSound;

    /**
     * Initializes the sound assets by loading loading them a single time. Can
     * be used to call and play a specific sound file.
     *
     * @throws IOException Thrown if there is an error loading the sounds
     * @throws NullPointerException If any of the image assets are not found
     */
    public static void init() {
        // Load sound assets here if needed
        frogDeathSound = SoundUtil.loadClip(
                "/audio/womp-womp.wav"
        );
        moveSound = SoundUtil.loadClip(
                "/audio/frog-croak.wav"
        );
        gameOverSound = SoundUtil.loadClip(
                "/audio/kermit-is-never-gonna-give-you-up.wav"
        );
    }
}
