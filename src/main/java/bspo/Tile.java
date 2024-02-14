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
        if (name.equals("0")) {
            return;
        } else if (name.equals("X")) {
            g.setColor(Color.cyan);
        } else if (name.equals("head")) {
            g.setColor(Color.green);
        } else if (name.equals("red")) {
            g.setColor(Color.red);
        }else if (name.equals("blue")) {
            g.setColor(Color.blue);
        }
        g.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
    }
}
