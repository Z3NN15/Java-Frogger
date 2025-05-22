package game;


import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import obstacles.AbstractObstacle;
import obstacles.Car;
import obstacles.Log;
import player.Frog;

public class ObstacleManager {
	private static GameComponent gc;
	private static List<AbstractObstacle> obstacles = new ArrayList<>();
	private final static Random rnd = new Random();
	private static long tick = 0;
	
	// Scale factors for the obstacles
	private static final double LOG_SCALE_FACTOR = 0.25;
	private static final double CAR_SCALE_FACTOR = 0.25;
	
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
	
	public ObstacleManager(GameComponent gc) {
		ObstacleManager.gc = gc;
		
		scheduleNextLog();
		scheduleNextCar();
		checkCollision();
	}
	
	public static void updateAll() {
		tick++;
		
		// Advance obstacles
		
		obstacles.removeIf(o -> {
			o.update();
			
			// For debugging purposes
			if (o.isOffScreen()) {
				System.out.println("Obstacle is off screen");
			}
			return o.isRemoved();
		});
		
		if (tick >= nextLogTick) {
			spawnLog();
			scheduleNextLog();
		}
		
		if (tick >= nextCarTick) {
			spawnCar();
			scheduleNextCar();
		}
	}
	
	/**
	 * Draws all obstacles
	 */
	public static void drawAll(Graphics2D g) {
		for (AbstractObstacle o: obstacles) {
			o.drawOn(g);
		}
	}
	
	/**
	 * Get the obstacle speed based on the level.
	 */
	private static double getSpeed(double baseSpeed) {
		
		//TODO: Change the switch once levels are implemented
		return switch (gc.getLevel()) {
			case 1 -> baseSpeed;
			case 2 -> rnd.nextBoolean() ? baseSpeed : -baseSpeed;
			case 3 -> rnd.nextBoolean() ? baseSpeed * 1.5 : -baseSpeed * 1.5;
			default -> throw new IllegalArgumentException("Unexpected value: " + gc.getLevel());
		};
	}
	
	private void checkCollision() {
		Frog frog = gc.getFrog();
		
		for (AbstractObstacle o: obstacles) {
			if (frog.isHit) {
				o.collideWithPlayer(frog);
			}
		}
	}
	
	
	private static void scheduleNextLog() {
		nextLogTick = tick + rnd.nextInt(MIN_LOG_DELAY, MAX_LOG_DELAY);
	}
	
	private static void scheduleNextCar() {
		nextCarTick = tick + rnd.nextInt(MIN_CAR_DELAY, MAX_CAR_DELAY);
	}
	
	private static void spawnLog() {
		double y = LOG_LANES[rnd.nextInt(LOG_LANES.length)]; // Randomly select a lane
		double speed = getSpeed(LOG_SPEED);
		
		// Create a temp log to get its width
		Log tempLog = new Log(gc, LOG_SCALE_FACTOR, 0, y, speed);
		double x = (speed > 0) ? -tempLog.getWidth() : gc.getWidth();
		
		//Add the log to the list of obstacles
		obstacles.add(new Log(gc, LOG_SCALE_FACTOR, x, y, speed));
	}
	
	private static void spawnCar() {
		double y = CAR_LANES[rnd.nextInt(CAR_LANES.length)]; // Randomly select a lane
		double speed = getSpeed(CAR_SPEED);
		
		// Create a temp car to get its width
		Car tempCar = new Car(gc, CAR_SCALE_FACTOR, 0, y, speed);
		double x = (speed > 0) ? -tempCar.getWidth() : gc.getWidth();
		
		//Add the car to the list of obstacles
		obstacles.add(new Car(gc, CAR_SCALE_FACTOR, x, y, speed));
	}
}
