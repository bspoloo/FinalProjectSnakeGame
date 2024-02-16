package bspo;

import java.awt.*;

public class Tile {
    int x;
    int y;
    String name;


    public Tile(int x, int y, String name){

        this.x = x;
        this.y = y;
        this.name = name;
    }
    public void draw(Graphics g, int tileSize) {
        switch (name) {
            case "0" -> {
                return;
            }
            case "X" -> g.setColor(Color.cyan);
            case "W" -> g.setColor(Color.green);
            case "L" -> g.setColor(Color.red);
            case "head" -> g.setColor(Color.green);
            case "red" -> g.setColor(Color.red);
            case "blue" -> g.setColor(Color.blue);
            case "yellow" -> g.setColor(Color.yellow);
            case "purple" -> g.setColor(Color.magenta);
            case "orange" -> g.setColor(Color.orange);
            case "pink" -> g.setColor(Color.pink);
            case "black" -> g.setColor(Color.black);
            case "white" -> g.setColor(Color.white);
            case "gray" -> g.setColor(Color.gray);
        }

        g.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
    }
}
