package bspo.maps;

import bspo.Tile;
import bspo.arrays.Interfaces.ISnakeMap;

public class LeafMap implements ISnakeMap {
    @Override
    public String[][] getMap() {
        return new String[0][];
    }

    @Override
    public Tile[][] getTileMap() {
        return new Tile[0][];
    }

    @Override
    public Tile getFood1() {
        return null;
    }

    @Override
    public Tile getFood2() {
        return null;
    }

    @Override
    public void speedBoost() {

    }
}
