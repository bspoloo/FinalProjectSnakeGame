package bspo.arrays.binarytree;

import bspo.Tile;
import bspo.arrays.Interfaces.ISnakeMap;

public class BTNode {

    public  int data;
    public ISnakeMap map;
    BTNode left;
    BTNode right;

    public BTNode(int data, ISnakeMap map) {
        this.data = data;
        left = null;
        right = null;
        this.map = map;
    }

    public BTNode(int data) {
        this.data = data;
        left = null;
        right = null;
        this.map = null;
    }

    public boolean isLeaf(){
        return left == null && right == null;
    }

}
