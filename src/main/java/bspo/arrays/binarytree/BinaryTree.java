package bspo.arrays.binarytree;

import bspo.Tile;
import bspo.arrays.Interfaces.IBinaryTree;
import bspo.arrays.Interfaces.ISnakeMap;

public class BinaryTree implements IBinaryTree {
    BTNode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int data) {
        root = new BTNode(data);
    }

    public BinaryTree(int data, ISnakeMap map) {
        root = new BTNode(data, map);
    }

    @Override
    public void insertMap(int data, ISnakeMap map) {
        root = insertMap(root, data, map);
    }

    @Override
    public void insert(int data) {
        root = insert(root, data);
    }


    @Override
    public boolean search(int data) {
        return search(root, data);
    }

    @Override
    public BTNode getRoot() {
        return root;
    }

    @Override
    public BTNode getNode(int data) {
        return getNode(root, data);
    }

    @Override
    public void delete(int data) {
        removeHelper(data, root);
    }

    @Override
    public int[] inOrder() {
        int [] arr = new int[size()];
        inOrder(root, arr, 0);
        return arr;
    }

    @Override
    public int[] preOrder() {
        int[] arr = new int[size()];
        preOrder(root, arr, 0);
        return arr;
    }

    @Override
    public int[] postOrder() {
        int[] arr = new int[size()];
        postOrder(root, arr, 0);
        return arr;
    }

    @Override
    public int height() {
        return height(root);
    }

    @Override
    public int size() {
        return size(root);
    }

    private static BTNode insertMap(BTNode root, int data, ISnakeMap map) {
        if (root == null) {
            return new BTNode(data, map);
        }

        if(data < root.data) {
            root.left = insertMap(root.left, data, map);
        } else if(data > root.data) {
            root.right = insertMap(root.right, data, map);
        }

        return root;
    }

    private static BTNode insert(BTNode root, int data) {
        if (root == null) {
            return new BTNode(data);
        }

        if(data < root.data) {
            root.left = insert(root.left, data);
        } else if(data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    private static int size(BTNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    private static int height(BTNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private static boolean search(BTNode root, int data) {

        if (root == null) {
            System.out.println("Node doesn't exist");
            return false;
        }

        if (root.data == data) {
            return true;
        }

        if(data < root.data) {
            return search(root.left, data);
        } else {
            return search(root.right, data);
        }
    }


    private static BTNode getNode(BTNode root, int data) {

        if (root == null) {
            return null;
        }

        if (root.data == data) {
            return root;
        }

        if(data < root.data) {
            return getNode(root.left, data);
        } else {
            return getNode(root.right, data);
        }
    }

    private int inOrder(BTNode root, int[] arr, int index) {

        // preorder traversal
        if(root == null){
            return index;
        }

        index = inOrder(root.left, arr, index);
        arr[index++] = root.data;

        index = inOrder(root.right, arr, index);
        return index;
    }

    private int preOrder(BTNode root, int[] arr, int index){
        if (root == null){
            return index;
        }
        arr[index++] = root.data;
        index = preOrder(root.left, arr, index);
        index = preOrder(root.right, arr, index );
        return index;
    }

    private int postOrder(BTNode root, int[] arr, int index){
        if (root == null){
            return index;
        }

        index = postOrder(root.left, arr, index);
        index = postOrder(root.right, arr, index );
        arr[index++] = root.data;

        return index;
    }

    private BTNode removeHelper(int data, BTNode current) {
        if (current == null) {
            return null;
        } else if(data < current.data) {
            current.left = removeHelper(data, current.left);
        } else if (data > current.data) {
            current.right = removeHelper(data, current.right);
        } else {

            if (current.left == null && current.right == null) {
                return null;
            } else if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            } else {
                BTNode dummy = new BTNode(0);
                current.right = removeSuccesor(current.right, dummy);
                current.data = dummy.data;
            }
        }
        return current;
    }

    private BTNode removeSuccesor(BTNode current, BTNode dummy) {
        if (current.left == null) {
            dummy.data = current.data;
            return current.right;
        } else {
            current.left = removeSuccesor(current.left, dummy);
            return current;
        }
    }
}
