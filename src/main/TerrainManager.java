package main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import terrains.*;

public class TerrainManager {

    private static final List<AbstractTerrain> terrainList = new ArrayList<>();

    private static final int NUM_ROWS = 10;
    private static final int ROW_HEIGHT = GameMain.WINDOW_HEIGHT / NUM_ROWS;

    public void render(Graphics g, int level) {

        for (int i = 0; i < NUM_ROWS; i++) {
            int y = i * ROW_HEIGHT;

            switch (level) {

            }
        }
    }

    private void levelTerrain() {

    }

}
