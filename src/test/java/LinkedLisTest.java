import bspo.arrays.Interfaces.ILinkedList;
import bspo.arrays.LinkedList.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedLisTest {
    @Test
    void onInitSizeIsZero() {

        ILinkedList<Integer> linkedList = new LinkedList<>();
        Assertions.assertEquals(0, linkedList.size());

    }

    @Test
    void onInitSizeIsOne() {
        ILinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addFirst(1);
        Assertions.assertEquals(1, linkedList.size());
    }

    @Test
    void onInitSizeIsEmpty() {

        ILinkedList<Integer> linkedList = new LinkedList<>();
        Assertions.assertTrue(linkedList.isEmpty());
    }

    @Test
    void onInsertingFirst() {

        ILinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i+1);
        }

        Assertions.assertEquals(10, linkedList.size());
    }

    @Test
    void onRemovingLast() {

        ILinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            linkedList.addLast(i+1);
        }

        linkedList.removeLast();
        Assertions.assertEquals(9, linkedList.size());
    }
    @Test
    void onSearchingData() {

        ILinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            linkedList.addLast(i+1);
        }

        Assertions.assertEquals(3, linkedList.search(3).data);
    }

}
