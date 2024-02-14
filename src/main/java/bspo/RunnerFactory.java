package bspo;

import bspo.arrays.Interfaces.ISnakeMap;

public class RunnerFactory {
    public static ISnakeMap getManager(int runnerID){
        switch (runnerID) {
            case 1:
                return new SnakeMap1();
            case 2:
                return new SnakeMap2();
            case 3:
                return new NullMap();
            case 4:
                return new NullMap();
            case 5:
                return new NullMap();
            case 6:
                return new NullMap();
            case 7:
                return new NullMap();
            case 8:

        }
        return null;

    }
}
