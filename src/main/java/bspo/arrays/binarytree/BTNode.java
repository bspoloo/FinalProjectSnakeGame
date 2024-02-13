package bspo.arrays.binarytree;

public class BTNode {

    public  int data;
    BTNode left;
    BTNode right;

    public BTNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public boolean isLeaf(){
        return left == null && right == null;
    }

}
