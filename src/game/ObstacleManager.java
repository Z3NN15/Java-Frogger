package game;

import java.awt.Graphics;
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
	}
	
	public static void updateAll() {
		tick++;
		
		// Advance obstacles
		for (AbstractObstacle o: obstacles) {
			o.update();
		}
		
		if (tick >= nextLogTick) {
			spawnLog();
			scheduleNextLog();
		}
		
		if (tick >= nextCarTick) {
			spawnCar();
			scheduleNextCar();
		}
	}
	
	public static void drawAll(Graphics2D g) {
		for (AbstractObstacle o: obstacles) {
			o.drawOn(g);
		}
	}
	
	public void handleCollision(Frog frog) {
		frog = gc.getFrog();
		for (AbstractObstacle o: obstacles) {
			if (o.collideWithPlayer(frog)) {
				frog.handleCollision(o);
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
		double speed = 0;
		
		switch (gc.getLevel()) {
			case 1:
				speed = LOG_SPEED;
				break;
			case 2:
				speed = rnd.nextBoolean() ? LOG_SPEED : -LOG_SPEED;
				break;
			case 3:
				speed = rnd.nextBoolean() ? LOG_SPEED * 1.5 : -LOG_SPEED * 1.5;
				break;
		}
		
		double x = (speed > 0) ? -Log.getWidth() : gc.getWidth();
		obstacles.add(new Log(gc, LOG_SCALE_FACTOR, x, y, speed));
	}
	
	private static void spawnCar() {
		double y = CAR_LANES[rnd.nextInt(CAR_LANES.length)]; // Randomly select a lane
		double speed = 0;
		
		switch (gc.getLevel()) {
			case 1:
				speed = CAR_SPEED;
				break;
			case 2:
				speed = rnd.nextBoolean() ? CAR_SPEED : -CAR_SPEED;
				break;
			case 3:
				speed = rnd.nextBoolean() ? CAR_SPEED * 1.5 : -CAR_SPEED * 1.5;
				break;
		}
		
		double x = (speed > 0) ? -Car.getWidth() : gc.getWidth();
		obstacles.add(new Car(gc, CAR_SCALE_FACTOR, x, y, speed));
	}

}
