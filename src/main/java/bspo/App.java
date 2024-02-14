package bspo;
import bspo.arrays.Interfaces.IRunner;
import bspo.arrays.Interfaces.ISnakeMap;

import javax.swing.*;

public class App {

    public static void main(String[] args) {

        ISnakeMap snakeMap = RunnerFactory.getManager(1);


        int boardWidth = snakeMap.getMap().length;
        int boardHeight = snakeMap.getMap()[0].length;

        JFrame frame = new JFrame("Snake");
        frame.setVisible(true);
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakeGame snakeGame = new SnakeGame(snakeMap);
        frame.add(snakeGame);
        frame.pack();

        snakeGame.requestFocus();
    }

}