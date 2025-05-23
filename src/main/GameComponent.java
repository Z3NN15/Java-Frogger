package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.Timer;
import player.Frog;

public class GameComponent extends JComponent {
    private static final long serialVersionUID = 1L;
    private static final int FPS = 60;
    private final Timer timer;
    private final int level = 1;
    private final Frog frog;
    @SuppressWarnings("unused")
	private final ObstacleManager obstacleManager;


    public GameComponent() {
        frog = new Frog(400, 400);
        obstacleManager = new ObstacleManager();

        InputHandler inputHandler = new InputHandler(frog, 50, 50);
        this.addKeyListener(inputHandler);
        this.setFocusable(true);
        this.requestFocusInWindow();

        timer = new Timer(1000 / FPS, this::actionPerformed);
        timer.start();
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        this.updateState();
        this.repaint();
    }

    public int getLevel() {
        return level;
    }

    @Override
    public void addNotify() {
        super.addNotify();
        this.requestFocusInWindow();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        ObstacleManager.drawAll(g2d);
        frog.drawOn(g2d);
    }

    public void updateState() {
        ObstacleManager.updateAll(this.frog);
        frog.update();
    }
}

