package main;

import assets.Sprites;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import obstacles.AbstractObstacle;
import obstacles.Car;
import obstacles.Log;
import player.Frog;

public class ObstacleManager {

    private static final List<AbstractObstacle> obstacles = new ArrayList<>();
    private static final Random rnd = new Random();
    private static long tick = 0;

    private static final int LOG_WIDTH = (int) (Sprites.LOG.getWidth());
    private static final int CAR_WIDTH = (int) (Sprites.CAR.getWidth());

    //Spawn ticks
    private static long nextLogTick;
    private static long nextCarTick;

    //Spawn intervals in number of frames
    private static final int MIN_LOG_DELAY = 120;
    private static final int MAX_LOG_DELAY = 240;
    private static final int MIN_CAR_DELAY = 90;
    private static final int MAX_CAR_DELAY = 180;

    //Y-position of each lane
    private static final int[] LOG_LANES = {200, 250, 300};
    private static final int[] CAR_LANES = {350, 400, 450};

    //Speeds
    private static final double LOG_SPEED = 2.0;
    private static final double CAR_SPEED = 3.0;

    public ObstacleManager() {

        scheduleNextLog();
        scheduleNextCar();
    }//ObstacleManager()

    public static void updateAll(Frog frog) {
        tick++;

        // Advance obstacles
        obstacles.removeIf(o -> {
            o.update();

            // For debugging purposes
//			if (o.isOffScreen()) {
//				System.out.println("Obstacle is off screen");
//			}
            return o.isOffScreen();
        });

        if (tick >= nextLogTick) {
            spawnLog();
            scheduleNextLog();
        }

        if (tick >= nextCarTick) {
            spawnCar();
            scheduleNextCar();
        }

        checkCollision(frog);
    }

    /**
     * Draws all obstacles
     */
    protected static void drawAll(Graphics2D g) {
        for (AbstractObstacle o : obstacles) {
            o.drawOn(g);
        }
    }//drawAll()

    protected static void clear() {
        obstacles.clear();
    }//clear()

    private static void checkCollision(Frog frog) {

        for (AbstractObstacle o : obstacles) {
            o.handleCollision(frog);
        }
    }//checkCollision()

    /**
     * Set the obstacle speed based on the level, given a desired starting speed.
     * 
     * @param baseSpeed Objects starting speed
     */
    private static double setSpeed(double baseSpeed) {
        int level = LevelManager.getCurrentLevel();

        //DONE: Change the switch once levels are implemented
        return switch (level) {
            case 1 ->
                baseSpeed;
            case 2 ->
                rnd.nextBoolean() ? baseSpeed : -baseSpeed;
            case 3 ->
                rnd.nextBoolean() ? baseSpeed * 1.5 : -baseSpeed * 1.5;
            default ->
                throw new IllegalArgumentException("Unexpected level: " + level);
        };
    }//setSpeed()

    private static void scheduleNextLog() {
        nextLogTick = tick + rnd.nextInt(MIN_LOG_DELAY, MAX_LOG_DELAY);
    }//scheduleNextLog()

    private static void scheduleNextCar() {
        nextCarTick = tick + rnd.nextInt(MIN_CAR_DELAY, MAX_CAR_DELAY);
    }//scheduleNextCar()

    private static void spawnLog() {
        double speed = setSpeed(LOG_SPEED);
        double y = LOG_LANES[rnd.nextInt(LOG_LANES.length)]; // Randomly select a lane
        double x = (speed > 0) ? -LOG_WIDTH : GameMain.WINDOW_WIDTH;

        //Add the log to the list of obstacles
        obstacles.add(new Log(x, y, speed));
    }//spawnLog()

    private static void spawnCar() {
        double y = CAR_LANES[rnd.nextInt(CAR_LANES.length)]; // Randomly select a lane
        double speed = setSpeed(CAR_SPEED);

        double x = (speed > 0) ? -CAR_WIDTH : GameMain.WINDOW_WIDTH;

        //Add the car to the list of obstacles
        obstacles.add(new Car(x, y, speed));
    }//spawnCar()
}
