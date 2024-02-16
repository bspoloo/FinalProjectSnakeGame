package bspo;

import bspo.arrays.Interfaces.IWindows;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Windows implements IWindows {

    Timer gameLoop;
    public Windows(Timer gameLoop){
        this.gameLoop = gameLoop;
    }
    @Override
    public void principalMenu() {
        JFrame frame = new JFrame("Menu");
        JButton button = new JButton("Start game");

        button.setPreferredSize(new Dimension(100, 50));
        button.setBackground(Color.BLUE);

        button.addActionListener(e -> {
            gameLoop.start();
            frame.dispose();
        });

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(button);

        frame.getContentPane().add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void stopGame(javax.swing.Timer gameLoop) {

    }

    @Override
    public void exitGame() {
        System.exit(0);
    }

    @Override
    public void message(String data) {
        JFrame frame = new JFrame("You "+ data);
        JButton buttonRestart = new JButton("Restart game");
        JButton buttonExit = new JButton("Exit");


        buttonRestart.setPreferredSize(new Dimension(100, 50));
        buttonRestart.setBackground(Color.PINK);

        buttonRestart.addActionListener(e -> {
            gameLoop.restart();
            frame.dispose();
        });
        buttonExit.addActionListener(e -> exitGame());

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(buttonRestart);
        panel.add(buttonExit);

        frame.getContentPane().add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
