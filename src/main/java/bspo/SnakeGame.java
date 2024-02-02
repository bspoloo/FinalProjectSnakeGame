package bspo;

import java.awt.*;
import java.awt.event.*;

import bspo.arrays.Interfaces.ILinkedList;
import bspo.arrays.LinkedList.LinkedList;
import bspo.arrays.LinkedList.Node;

import java.util.Random;
import javax.swing.*;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {
    int boardWidth;
    int boardHeight;
    int tileSize = 25;

    //snake head
    Tile snakeHead;
    //snake body
    ILinkedList<Tile> snakeBody;
    //food
    Tile food;
    //random
    Random random = new Random();
    //game logic
    Timer gameLoop;
    // velocity
    int velocityX;
    int velocityY;
    boolean gameOver = false;

    public SnakeGame(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;

        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.black);

        addKeyListener(this);
        setFocusable(true);


        snakeHead = new Tile(5, 5);
        snakeBody = new LinkedList<>();

        food = new Tile(10, 10);

        gameLoop = new Timer(100, this);
        gameLoop.start();

        velocityX = 0;
        velocityY = 0;

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        //Grid
        for (int i = 0; i < boardWidth / tileSize; i++) {
            g.drawLine(i * tileSize, 0, i * tileSize, boardHeight);
            g.drawLine(0, i * tileSize, boardWidth, i * tileSize);
        }
        //snake
        g.setColor(Color.green);
        g.fillRect(snakeHead.x * tileSize, snakeHead.y * tileSize, tileSize, tileSize);
        //food
        g.setColor(Color.red);
        g.fillRect(food.x * tileSize, food.y * tileSize, tileSize, tileSize);

        // snake body
        for (int i = 0; i < snakeBody.size(); i++) {
            Node<Tile> snakePart = snakeBody.search(i);
            g.setColor(Color.green);
            g.fillRect(snakePart.data.x * tileSize, snakePart.data.y * tileSize, tileSize, tileSize);
        }

        //score
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        if (gameOver){
            g.setColor(Color.red);
            g.drawString("Game Over"+ snakeBody.size(),tileSize-16,tileSize);
        }else {
            g.drawString("Score"+ snakeBody.size(),tileSize-16,tileSize);
        }
    }

    public void placeFood() {
        food.x = random.nextInt(boardWidth / tileSize);
        food.y = random.nextInt(boardWidth / tileSize);

    }

    public boolean collision(Tile tile1, Tile tile2) {
        return tile1.x == tile2.x && tile1.y == tile2.y;
    }

    public void move() {

        if (collision(snakeHead, food)) {
            snakeBody.addLast(new Tile(food.x, food.y));
            placeFood();
        }
        for (int i = snakeBody.size()-1; i >= 0; i--) {
            Node<Tile> snakePart = snakeBody.search(i);
            if (i == 0) {
                snakePart.data.x = snakeHead.x;
                snakePart.data.y = snakeHead.y;
            } else {
                Node<Tile> prevSnakePart = snakeBody.search(i - 1);
                snakePart.data.x = prevSnakePart.data.x;
                snakePart.data.y = prevSnakePart.data.y;
            }
        }
        snakeHead.x += velocityX;
        snakeHead.y += velocityY;
        for (int i = 0; i < snakeBody.size(); i++){
            Node<Tile> snakePart = snakeBody.search(i);

            if (collision(snakeHead,snakePart.data)){
                gameOver = true;
            }
            if (snakeHead.x*tileSize < 0 || snakeHead.x*tileSize > boardWidth || //passed left border or right border
                    snakeHead.y*tileSize < 0 || snakeHead.y*tileSize > boardHeight ) { //passed top border or bottom border
                gameOver = true;
                System.out.println("game over we xd");
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if (gameOver){
            gameLoop.stop();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_W && velocityY != 1) {
            velocityX = 0;
            velocityY = -1;
        } else if (e.getKeyCode() == KeyEvent.VK_S && velocityY != -1) {
            velocityX = 0;
            velocityY = 1;
        } else if (e.getKeyCode() == KeyEvent.VK_A && velocityX != 1) {
            velocityX = -1;
            velocityY = 0;
        } else if (e.getKeyCode() == KeyEvent.VK_D && velocityX != -1) {
            velocityX = 1;
            velocityY = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
