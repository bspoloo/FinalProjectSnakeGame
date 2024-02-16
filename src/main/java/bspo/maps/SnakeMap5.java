package bspo.maps;

import bspo.SnakeGame;
import bspo.Tile;
import bspo.arrays.Interfaces.ISnakeMap;

import javax.swing.*;


public class SnakeMap5 extends JPanel implements ISnakeMap{

    public int boardHeight;
    public int boardWidth;
    private Tile food1;
    private Tile food2;

    public Tile[][] tailMap;

    public SnakeMap5(){
        this.boardWidth = getMap().length;
        this.boardHeight = getMap()[0].length;
        this.food1 = new Tile(10, 10, "red");
        this.food2 = new Tile(7, 8, "blue");
        this.tailMap = arrayToMap(getMap());
    }

    @Override
    public String[][] getMap() {
        return new String[][]{
                {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"},
                {"X", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "X"},
                {"X", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "X"},
                {"X", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "X"},
                {"X", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X"},
                {"X", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X"},
                {"X", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X"},
                {"X", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "X"},
                {"X", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "X"},
                {"X", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "X"},
                {"X", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X"},
                {"X", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X"},
                {"X", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X"},
                {"X", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "X"},
                {"X", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "X"},
                {"X", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "X"},
                {"X", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X"},
                {"X", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X"},
                {"X", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X", "0", "0", "0", "X", "X", "X"},
                {"X", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "X"},
                {"X", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "X"},
                {"X", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "X"},
                {"X", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "X"},
                {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}
        };
    }

    @Override
    public Tile getFood1() {
        return food1;
    }

    @Override
    public void speedBoost() {
        SnakeGame.setGameLoop(60);
    }

    @Override
    public Tile getFood2() {
        return food2;
    }

    @Override
    public Tile[][] getTileMap() {
        return tailMap;
    }

    private Tile[][] arrayToMap(String[][] map) {

        int rows = map.length;
        int columns = map[0].length;

        Tile[][] maps = new Tile[rows][columns];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                if (map[i][j].equals("X")) {
                    Tile obstacle = new Tile(j, i, "X");
                    maps[i][j] = obstacle;
                } else if (map[i][j].equals("0")) {
                    Tile spaceEmpty = new Tile(j, i, "0");
                    maps[i][j] = spaceEmpty;
                }
            }

        }
        return maps;
    }
}

