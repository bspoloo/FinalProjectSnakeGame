import bspo.Tile;
import bspo.arrays.Interfaces.ILinkedList;
import bspo.arrays.LinkedList.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedLisTest {
    @Test
    void onInitSizeIsZero() {

        ILinkedList<Tile> linkedList = new LinkedList<>();
        Assertions.assertEquals(0, linkedList.size());

    }

    @Test
    void onInitSizeIsOne() {
        ILinkedList<Tile> linkedList = new LinkedList<>();

        linkedList.addFirst(new Tile(0,0, "red"));
        Assertions.assertEquals(1, linkedList.size());
    }

    @Test
    void onInitSizeIsEmpty() {

        ILinkedList<Tile> linkedList = new LinkedList<>();
        Assertions.assertTrue(linkedList.isEmpty());
    }

    @Test
    void onInsertingFirst() {

        ILinkedList<Tile> linkedList = new LinkedList<>();

        Tile tile1 = new Tile(0,0, "One");
        Tile tile2 = new Tile(0,0, "Two");
        Tile tile3 = new Tile(0,0, "Three");

        linkedList.addLast(tile1);
        linkedList.addLast(tile2);

        linkedList.addFirst(tile3);

        Assertions.assertEquals(tile3, linkedList.first().data);
    }
    @Test
    void onInsertingLast() {

        ILinkedList<Tile> linkedList = new LinkedList<>();

        Tile tile1 = new Tile(0,0, "One");
        Tile tile2 = new Tile(0,0, "Two");
        Tile tile3 = new Tile(0,0, "Three");

        linkedList.addFirst(tile1);
        linkedList.addFirst(tile2);

        linkedList.addLast(tile3);

        Assertions.assertEquals(tile3, linkedList.last().data);
    }
    @Test
    void onRemovingFirst() {

        ILinkedList<Tile> linkedList = new LinkedList<>();

        Tile tile1 = new Tile(0,0, "One");
        Tile tile2 = new Tile(0,0, "Two");
        Tile tile3 = new Tile(0,0, "Three");
        Tile tile4 = new Tile(0,0, "Four");
        Tile tile5 = new Tile(0,0, "Five");
        Tile tile6 = new Tile(0,0, "Six");

        linkedList.addFirst(tile1);
        linkedList.addLast(tile2);
        linkedList.addLast(tile3);
        linkedList.addLast(tile4);
        linkedList.addLast(tile5);
        linkedList.addLast(tile6);

        linkedList.removeFirst();
        Assertions.assertSame(linkedList.first().data, tile2);
    }
    @Test
    void onRemovingLast() {

        ILinkedList<Tile> linkedList = new LinkedList<>();

        Tile tile1 = new Tile(0,0, "One");
        Tile tile2 = new Tile(0,0, "Two");
        Tile tile3 = new Tile(0,0, "Three");
        Tile tile4 = new Tile(0,0, "Four");
        Tile tile5 = new Tile(0,0, "Five");
        Tile tile6 = new Tile(0,0, "Six");

        linkedList.addFirst(tile1);
        linkedList.addLast(tile2);
        linkedList.addLast(tile3);
        linkedList.addLast(tile4);
        linkedList.addLast(tile5);
        linkedList.addLast(tile6);

        linkedList.removeLast();
        Assertions.assertSame(linkedList.last().data, tile5);
    }
    @Test
    void onSearchingData() {

        ILinkedList<Tile> linkedList = new LinkedList<>();

        Tile tile1 = new Tile(0,0, "One");
        Tile tile2 = new Tile(0,0, "Two");
        Tile tile3 = new Tile(0,0, "Three");
        Tile tile4 = new Tile(0,0, "Four");
        Tile tile5 = new Tile(0,0, "Five");
        Tile tile6 = new Tile(0,0, "Six");

        linkedList.addFirst(tile1);
        linkedList.addLast(tile2);
        linkedList.addLast(tile3);
        linkedList.addLast(tile4);
        linkedList.addLast(tile5);
        linkedList.addLast(tile6);

        Assertions.assertEquals(tile3, linkedList.search(3).data);
        Assertions.assertEquals(tile1, linkedList.search(1).data);
        Assertions.assertEquals(tile5, linkedList.search(5).data);
        Assertions.assertEquals(tile6, linkedList.search(6).data);

    }

}
