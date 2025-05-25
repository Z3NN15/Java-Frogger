package main;

import obstacles.Car;
import obstacles.Log;
import player.Fly;
import player.Frog;

public class ScoreManager {
	private int score;
	
	public ScoreManager() {
		this.score=0;
	}
	
	
	
	public void score(Frog frog,GameObject ob) {
		if(!frog.overlaps(ob)) {
			score+=1;
		}
	}
	public int getScore() {
		return score;
	}
}
