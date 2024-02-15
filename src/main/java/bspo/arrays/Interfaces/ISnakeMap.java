package bspo.arrays.Interfaces;

import bspo.SnakeGame;
import bspo.Tile;

public interface ISnakeMap {
    String[][] getMap();
    Tile[][] getTileMap();

    Tile getFood1();
    Tile getFood2();

    void speedBoost();

}
