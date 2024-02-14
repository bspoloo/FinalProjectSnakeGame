package bspo;

import bspo.arrays.Interfaces.ISnakeMap;

public class NullMap implements ISnakeMap {
    @Override
    public String[][] getMap() {
        return new String[0][];
    }
}
