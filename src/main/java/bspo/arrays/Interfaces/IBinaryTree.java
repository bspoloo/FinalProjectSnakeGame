package bspo.arrays.Interfaces;

import bspo.Tile;
import bspo.arrays.binarytree.BTNode;

public interface IBinaryTree {
    /**
     * Insert a new node with the given data into the tree
     *
     * @param data the data to be inserted
     */
    void insert(int data);

    void insertMap(int data, ISnakeMap map);
    /**
     * Search for a node with the given data in the tree
     *
     * @param data the data to be searched
     * @return true if the data is found, false otherwise
     */
    boolean search(int data);

    /**
     * Get the root node of the tree
     *
     * @return the root node
     */
    BTNode getRoot();

    /**
     * Get the node with the given data
     *
     * @param data the data to be searched
     * @return the node with the given data
     */
    BTNode getNode(int data);

    /**
     * Delete the node with the given data
     *
     * @param data the data to be deleted
     */
    void delete(int data);

    /**
     * Get the in-order traversal of the tree
     *
     * @return the in-order traversal
     */
    int[] inOrder();

    /**
     * Get the pre-order traversal of the tree
     *
     * @return the pre-order traversal
     */
    int[] preOrder();

    /**
     * Get the post-order traversal of the tree
     *
     * @return the post-order traversal
     */
    int[] postOrder();

    /**
     * Get the level-order traversal of the tree
     *
     * @return the level-order traversal
     */
    int height();

    /**
     * Get the size of the tree
     *
     * @return the size of the tree
     */
    int size();


}
