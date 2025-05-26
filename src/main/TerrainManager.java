package main;

import assets.Backgrounds;
import assets.utils.ResizeUtil;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import player.Frog;
import terrains.*;

public class TerrainManager {

    private final List<AbstractTerrain> terrainList = new ArrayList<>();

    private final int numRows;
    private final int rowHeight;

    private final BufferedImage scaledWater;
    private final BufferedImage scaledGrass;
    private final BufferedImage scaledRoad;

    public TerrainManager(int level) {
        this.numRows = getNumRowsForLevel(level);
        this.rowHeight = GameMain.WINDOW_HEIGHT / numRows;

        this.scaledWater = ResizeUtil.advancedResizer(
                Backgrounds.WATER,
                ResizeUtil.getScaleFactor(
                        Backgrounds.WATER.getWidth(),
                        Backgrounds.WATER.getHeight(),
                        rowHeight
                )
        );

        this.scaledGrass = ResizeUtil.advancedResizer(
                Backgrounds.GRASS,
                ResizeUtil.getScaleFactor(
                        Backgrounds.GRASS.getWidth(),
                        Backgrounds.GRASS.getHeight(),
                        rowHeight
                )
        );

        this.scaledRoad = ResizeUtil.advancedResizer(
                Backgrounds.ROAD,
                ResizeUtil.getScaleFactor(
                        Backgrounds.ROAD.getWidth(),
                        Backgrounds.ROAD.getHeight(),
                        rowHeight
                )
        );

        generateTerrains();
    }

    private int getNumRowsForLevel(int level) {
        return switch (level) {
            case 1 ->
                7;
            case 2 ->
                9;
            case 3 ->
                10;
            default ->
                Math.min(10, 5 + level); // Caps at 10
        };
    }

    public void generateTerrains() {
        terrainList.clear();

        int startRow = 0;
        int endRow = numRows - 1;

        // Start grass (bottom of screen)
        terrainList.add(new Grass(scaledGrass, rowHeight * startRow));
        startRow++;

        String lastType = "grass";

        for (int i = startRow; i < endRow; i++) {
            if ((lastType.equals("road") || lastType.equals("water")) && Math.random() < 0.5) {
                terrainList.add(new Grass(scaledGrass, rowHeight * i));
                lastType = "grass";
            } else {
                if (Math.random() < 0.5) {
                    terrainList.add(new Road(scaledRoad, rowHeight * i));
                    lastType = "road";
                } else {
                    terrainList.add(new Water(scaledWater, rowHeight * i));
                    lastType = "water";
                }
            }
        }

        // Goal grass (top of screen)
        terrainList.add(new Grass(scaledGrass, rowHeight * endRow));
    }

    public void drawAll(Graphics2D g2D) {
        for (AbstractTerrain t : terrainList) {
            t.drawOn(g2D);
        }
    }

    public void updateAll(Frog frog) {
        for (AbstractTerrain t : terrainList) {
            t.checkTerrainCollision(frog);
        }
    }

    public int getNumRows() {
        return numRows;
    }

    public int getRowHeight() {
        return rowHeight;
    }
}
