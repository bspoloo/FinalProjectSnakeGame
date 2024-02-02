package bspo.arrays.Interfaces;
import bspo.arrays.LinkedList.Node;

/**
 * Interface representing a basic linked list.
 */
public interface ILinkedList<T> {

    /**
     * Returns the number of elements in the linked list.
     *
     * @return The size of the linked list.
     */
    int size();

    /**
     * Checks if the linked list is empty.
     *
     * @return true if the linked list is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Retrieves the first node in the linked list.
     *
     * @return The first node in the linked list.
     */
    Node<T> first();

    /**
     * Retrieves the last node in the linked list.
     *
     * @return The last node in the linked list.
     */
    Node<T> last();

    /**
     * Adds a new node with the specified data to the beginning of the linked list.
     *
     * @param data The data to be added to the new node.
     */
    void addFirst(T data);

    /**
     * Adds a new node with the specified data to the end of the linked list.
     *
     * @param data The data to be added to the new node.
     */
    void addLast(T data);

    /**
     * Removes the first node from the linked list.
     */
    Node<T> removeFirst();
    /**
     * Removes the Last node from the linked list.
     */
    Node<T> removeLast();

    /**
     * Prints the elements of the linked list.
     */
    void print();

    /**
     * Checks if a given node is null.
     *
     * @param node The node to be checked for null.
     * @return true if the node is null, false otherwise.
     */
    boolean isNull(Node<T> node);
    /**
     * search node by position.
     *
     * @param number The node to be checked for null.
     * @return node if the node is found.
     */
    Node<T> search(int number);


}
