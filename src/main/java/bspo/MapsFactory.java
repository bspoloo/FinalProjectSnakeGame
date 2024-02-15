package bspo;

import bspo.arrays.Interfaces.ISnakeMap;
import bspo.maps.*;


public class MapsFactory {
    public static ISnakeMap getManager(int runnerID){
        switch (runnerID) {
            case 1:
                return new SnakeMap1();
            case 2:
                return new SnakeMap2();
            case 3:
                return new SnakeMap3();
            case 4:
                return new SnakeMap4();
            case 5:
                return new SnakeMap5();
            case 6:
                return new SnakeMap6();
            case 7:
                return new SnakeMap7();
            case 8:

        }
        return null;

    }
}
