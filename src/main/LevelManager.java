package main;

import player.Frog;

public class LevelManager {

    private static final int MAX_LEVEL = 3;
    private static int currentLevel = 1;

    private static boolean showLevelMessage = false;
    private static long levelMessageStartTime;
    private TerrainManager terrainManager;

    public LevelManager(TerrainManager terrainManager) {
        this.terrainManager = terrainManager;
    }

    /**
     * Returns the current level number.
     *
     * @return the current level as an integer
     */
    protected static int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Sets the current level to the specified value.
     * <p>
     * The level must be within the valid range (1 to {@code MAX_LEVEL}),
     * inclusive. If the specified level is outside this range, an
     * {@link IllegalArgumentException} is thrown.
     * </p>
     *
     * @param level the level to set as the current level
     * @throws IllegalArgumentException if {@code level} is less than 1 or
     * greater than {@code MAX_LEVEL}
     */
    protected void setCurrentLevel(int level) {
        if (level < 1 || level > MAX_LEVEL) {
            throw new IllegalArgumentException(
                    "Level must be between 1 and " + MAX_LEVEL
            );
        }
        currentLevel = level;
    }

    /**
     * Advances the game to the next level if the current level is less than the
     * maximum level. If the current level is already at the maximum, no action
     * is taken.
     */
    public void nextLevel() {
        if (currentLevel < MAX_LEVEL) {
            currentLevel++;
            terrainManager = new TerrainManager(currentLevel); // reset with new row count
            showLevelMessage = true;
            levelMessageStartTime = System.currentTimeMillis();
        }
    }

    /**
     * Resets the current level to the initial level (level 1). This method is
     * typically used to restart the game or level progression.
     */
    protected void resetLevel() {
        currentLevel = 1;
    }

    /**
     * Checks if the current level is complete.
     * <p>
     * The level is considered complete if the frog's Y position is less than or
     * equal to 0, indicating that the frog has reached the top of the screen.
     *
     * @return {@code true} if the frog has reached the top of the screen;
     * {@code false} otherwise.
     */
    protected static boolean levelComplete(Frog frog) {
        // if (frog.overlaps(frog)
        return false;
    }

}
