package player;

import assets.Sprites;

//TODO: Implement this if, and only if, the rest of the game works. Fly will serve as an extra score increase jawn.
public class Fly extends AbstractPlayer {

    private double x, y;

    public Fly(double startX, double startY) {
        super(
                Sprites.FLY,
                startX,
                startY
        );

    }

    @Override
    public void handleDeath() {
        //TODO: Implement this jawn as well
    }
}
