package bspo.arrays.LinkedList;

import bspo.arrays.Interfaces.ILinkedList;

public class LinkedList<T> implements ILinkedList<T> {

    Node<T> head;

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        int size = 0;

        Node<T> current = head;

        while (!isNull(current)) {

            size++;
            current = current.next;

        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return isNull(head);
    }

    @Override
    public Node<T> first() {
        return head;
    }

    @Override
    public Node<T> last() {
        Node<T> current = head;
        while (!isNull(current)) {

            if (isNull(current.next)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    //add node at the start
    @Override
    public void addFirst(T data) {

        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }


    //add node at the end
    @Override
    public void addLast(T data) {

        Node<T> lastNode = last();

        if (isNull(lastNode)) {
            head = new Node<>(data);
            return;
        }

        lastNode.next = new Node<T>(data);


    }

    @Override
    public Node<T> removeFirst() {
        if (!isEmpty()) {
            Node<T> firstNode = first();
            head = head.next;
            return firstNode;
        }
        return null;
    }

    @Override
    public Node<T> removeLast() {
        if (!isEmpty()) {
            Node<T> current = head;
            Node<T> prev = null;

            while (!isNull(current.next)) {
                prev = current;
                current = current.next;
            }

            if (isNull(prev)) {
                head = null;
            } else {
                prev.next = null;
            }

            return current;
        }
        return null;
    }

    //print all nodes in the list
    @Override
    public void print() {
        System.out.println("==========================================================================");
        Node<T> current = head;
        while (!isNull(current)) {
            System.out.print(current.data + "--");

            current = current.next;
        }
        System.out.println("");
        System.out.println("==========================================================================");

    }

    //check if node is null
    @Override
    public boolean isNull(Node<T> node) {
        return node == null;
    }

    @Override
    public Node<T> search(int number) {

        Node<T> current = head;
        for (int i = 1; i < number; i++) {

            if (current == null) {
                return null;
            }
            current = current.next;
        }

        return current;
    }


}
