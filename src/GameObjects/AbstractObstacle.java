package GameObjects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;

import Game.GameComponent;
import Game.GameObject;

public abstract class AbstractObstacle extends GameObject {

	private Color color;
	public AbstractObstacle(Rectangle2D.Double log, GameComponent component, double size) {
		super(component, log.getMinX() + Math.random() * log.getWidth(), log.getMinY() + Math.random() * log.getHeight(), 0, 1, size, size);
	}
	
	public void drawOn(Graphics2D g) {
		g.setColor(this.color);
		Rectangle2D.Double log = new Rectangle2D.Double(this.getHitBox().x, 
														this.getHitBox().y, 
														this.getHitBox().getWidth(), 
														this.getHitBox().getHeight()
														);
		g.fill(log);
		g.setColor(color.BLACK);
	}
	
	@Override
	public void update() {
		super.update();
		if (isOffScreen()) {
			markToRemove();
		}
	}
	
	@Override
	public void onRemove() {
		//Do nothing
	}
	
	public abstract void collideWithPlayer(AbstractPlayer frog);
	
	
}
