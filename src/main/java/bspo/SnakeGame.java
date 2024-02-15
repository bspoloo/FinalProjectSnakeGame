package bspo;

import java.awt.*;
import java.awt.event.*;

import bspo.arrays.Interfaces.ILinkedList;
import bspo.arrays.Interfaces.ISnakeMap;
import bspo.arrays.Interfaces.IWindows;
import bspo.arrays.LinkedList.LinkedList;
import bspo.arrays.LinkedList.Node;
import bspo.arrays.binarytree.BTNode;
import bspo.arrays.binarytree.BinaryTree;

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
    Tile foodOne;
    Tile foodTwo;
    Tile[][] map;
    BTNode currentMap;
    //random
    Random random = new Random();
    //game logic
    static Timer gameLoop;
    // velocity
    int velocityX;
    int velocityY;
    boolean gameOver = false;
    BinaryTree tree = new BinaryTree();
    IWindows windows;

    int countOne;
    int countTwo;

    public SnakeGame(ISnakeMap snakeMap) {



        this.boardWidth = snakeMap.getMap().length * tileSize;
        this.boardHeight = snakeMap.getMap()[0].length * tileSize;


        gameLoop = new Timer(120, this);
        windows = new Windows(gameLoop);
        windows.principalMenu();

        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.black);

        addKeyListener(this);
        setFocusable(true);

        snakeHead = new Tile(5, 5, "head");
        snakeBody = new LinkedList<>();

        this.countOne = 0;
        this.countTwo = 0;

        fillTree();
        gameLoop.setDelay(120);


        this.currentMap = tree.getRoot();
        this.map = currentMap.map.getTileMap();


        foodOne = currentMap.map.getFood1();
        foodTwo = currentMap.map.getFood2();


        printMap();


        velocityX = 0;
        velocityY = 0;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public static void setGameLoop(int delay) {
        gameLoop.setDelay(delay);
    }

    public void draw(Graphics g) {

        changeState();

        //Grid
        for (int i = 0; i < boardWidth / tileSize; i++) {
            g.drawLine(i * tileSize, 0, i * tileSize, boardHeight);
            g.drawLine(0, i * tileSize, boardWidth, i * tileSize);
        }

        //obstacles
        for (int i = 0; i < boardHeight / tileSize; i++) {
            for (int j = 0; j < boardWidth / tileSize; j++) {
                map[i][j].draw(g, tileSize);
            }
        }

        //snake
        snakeHead.draw(g, tileSize);

        //food
        foodOne.draw(g, tileSize);
        foodTwo.draw(g, tileSize);

        // snake body
        for (int i = 0; i < snakeBody.size(); i++) {
            Node<Tile> snakePart = snakeBody.search(i);
            snakePart.data.draw(g, tileSize);
        }

        //score
        gameOverLoss(g);
    }

    public void placeFood(String type) {
        String name1 = foodOne.name;
        String name2 = foodTwo.name;
        do {
            if (type.equals(name1)) {
                foodOne.x = random.nextInt(boardWidth / tileSize);
                foodOne.y = random.nextInt(boardHeight / tileSize);
            } else if (type.equals(name2)) {
                foodTwo.x = random.nextInt(boardWidth / tileSize);
                foodTwo.y = random.nextInt(boardHeight / tileSize);
            }
        } while (map[foodOne.y][foodOne.x].name.equals("X") || map[foodTwo.y][foodTwo.x].name.equals("X"));
    }

    public boolean collision(Tile tile1, Tile tile2) {
        return tile1.x == tile2.x && tile1.y == tile2.y;
    }


    public void move() {

        int newHeadX = snakeHead.x + velocityX;
        int newHeadY = snakeHead.y + velocityY;

        if (collision(snakeHead, foodOne)) {
            snakeBody.addLast(new Tile(foodOne.x, foodOne.y, foodOne.name));
            countOne++;
            placeFood(foodOne.name);
        }
        if (collision(snakeHead, foodTwo)) {
            snakeBody.addLast(new Tile(foodTwo.x, foodTwo.y, foodTwo.name));
            countTwo++;
            placeFood(foodTwo.name);
        }

        if (map[newHeadY][newHeadX].name.equals("X")) {
            gameOver = true;
            return;
        }

        for (int i = snakeBody.size() - 1 ; i >= 0; i--) {
            Node<Tile> snakePart = snakeBody.search(i);
            if (i == 0) {
                snakePart.data.x = snakeHead.x;
                snakePart.data.y = snakeHead.y;
            } else {
                Node<Tile> prevSnakePart = snakeBody.search(i-1);
                snakePart.data.x = prevSnakePart.data.x;
                snakePart.data.y = prevSnakePart.data.y;
            }
        }

        snakeHead.x = newHeadX;
        snakeHead.y = newHeadY;

        for (int i = 0; i < snakeBody.size(); i++) {
            Node<Tile> snakePart = snakeBody.search(i);

            if (collision(snakeHead, snakePart.data)) {
                gameOver = true;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if (gameOver) {
            gameLoop.stop();
        }
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

    private void gameOverLoss(Graphics g) {
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        if (gameOver) {
            g.setColor(Color.red);
            g.drawString("Game Over - You loss", tileSize - 16, tileSize + 20);

            gameLoop.stop();

        } else {
            g.drawString("Score: " + snakeBody.size(), tileSize - 16, tileSize + 20);
        }
    }

    private void gameOverWin(Graphics g) {
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.setColor(Color.green);
        g.drawString("Game Over - You Win", tileSize - 30, tileSize + 20);

        gameLoop.stop();
    }


    private void changeState() {

        if (countOne == 5) {
            this.currentMap = tree.getLeftNode(currentMap);

            if(currentMap.isLeaf()){
                gameOver = true;
                gameOverWin(getGraphics());
                return;
            }

            currentMap.map.speedBoost();
            this.map = currentMap.map.getTileMap();
            foodOne = currentMap.map.getFood1();
            foodTwo = currentMap.map.getFood2();
            countOne = 0;
            countTwo = 0;
        }

        if (countTwo == 5) {
            this.currentMap = tree.getRightNode(currentMap);

            if(currentMap.isLeaf()){
                gameOver = true;
                gameOverWin(getGraphics());
//                gameOverLoss(getGraphics());
                return;
            }

            currentMap.map.speedBoost();
            this.map = currentMap.map.getTileMap();
            foodOne = currentMap.map.getFood1();
            foodTwo = currentMap.map.getFood2();
            countTwo = 0;
            countOne = 0;

        }
    }

    private void printMap() {
        for (Tile[] fila : map) {
            for (Tile tile : fila) {
                System.out.print(tile.name + " ");
            }
            System.out.println();
        }
    }

    private void setMapsToTree(int numState, ISnakeMap map){
        tree.insertMap(numState,map);
    }

    private void fillTree(){
        ISnakeMap snakeMap_4 = MapsFactory.getManager(4);
        ISnakeMap snakeMap_2 = MapsFactory.getManager(2);
        ISnakeMap snakeMap_6 = MapsFactory.getManager(6);
        ISnakeMap snakeMap_1 = MapsFactory.getManager(1);
        ISnakeMap snakeMap_3 = MapsFactory.getManager(3);
        ISnakeMap snakeMap_5 = MapsFactory.getManager(5);
        ISnakeMap snakeMap_7 = MapsFactory.getManager(7);

        setMapsToTree(4, snakeMap_4);
        setMapsToTree(2, snakeMap_2);
        setMapsToTree(6, snakeMap_6);
        setMapsToTree(1, snakeMap_1);
        setMapsToTree(3, snakeMap_3);
        setMapsToTree(5, snakeMap_5);
        setMapsToTree(7, snakeMap_7);
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


}
