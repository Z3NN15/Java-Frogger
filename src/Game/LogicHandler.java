package Game;



public abstract class LogicHandler {
	private double x, y;
	private double dy;
	private double dx; 
	private boolean removeObject;
	protected GameComponent gc;
	
	public LogicHandler(GameComponent gameComponent, double x, double y, double dx, double dy) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.gc = gameComponent;
	}
	
	public boolean isOffScreen() {
		boolean x1 = x < 0;
		boolean x2 = x + GameMain.WINDOW_WIDTH > gc.getWidth();
		boolean y1 = y < 0;
		boolean y2 = y + GameMain.WINDOW_HEIGHT > gc.getHeight();
		
		return x1 || x2 || y1 || y2;
	}

}
