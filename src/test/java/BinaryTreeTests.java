import bspo.arrays.Interfaces.IBinaryTree;
import bspo.arrays.binarytree.BinaryTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryTreeTests {



    @Test
    public void testInsertOnMultipleElements(){
        IBinaryTree tree = new BinaryTree();

        tree.insert(8);
        tree.insert(4);
        tree.insert(12);
        tree.insert(2);
        tree.insert(6);
        tree.insert(10);
        tree.insert(14);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);
        tree.insert(9);
        tree.insert(11);
        tree.insert(13);
        tree.insert(15);

        Assertions.assertEquals(15, tree.size());

        Assertions.assertTrue(tree.search(8));
        Assertions.assertTrue(tree.search(4));
        Assertions.assertTrue(tree.search(12));
        Assertions.assertTrue(tree.search(2));
        Assertions.assertTrue(tree.search(6));
        Assertions.assertTrue(tree.search(10));
        Assertions.assertTrue(tree.search(14));
        Assertions.assertTrue(tree.search(1));
        Assertions.assertTrue(tree.search(3));
        Assertions.assertTrue(tree.search(5));
        Assertions.assertTrue(tree.search(7));
        Assertions.assertTrue(tree.search(9));
        Assertions.assertTrue(tree.search(11));
        Assertions.assertTrue(tree.search(13));
        Assertions.assertTrue(tree.search(15));
    }


    @Test
    public void testSizeOnTenElements() {
        IBinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        tree.insert(1);
        tree.insert(9);
        tree.insert(0);

        Assertions.assertEquals(10, tree.size());
    }

    // Test case insertion of three same elements, must be one
    @Test
    public void testSizeOnThreeSameElements(){
        IBinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(5);
        tree.insert(5);
        Assertions.assertEquals(1, tree.size());
    }

    @Test
    public void testSizeOnEmptyTree() {
        IBinaryTree tree = new BinaryTree();
        Assertions.assertEquals(0, tree.size());
    }

    @Test
    public void testGetRoot(){
        IBinaryTree tree = new BinaryTree();
        tree.insert(8);
        tree.insert(4);
        tree.insert(12);
        tree.insert(2);
        tree.insert(6);
        tree.insert(10);


        Assertions.assertEquals(8, tree.getRoot().data);
    }



    @Test
    public void testSearchOnNonexistentElement(){
        IBinaryTree tree = new BinaryTree(5);
        tree.insert(3);
        tree.insert(1);
        tree.insert(9);
        tree.insert(6);

        Assertions.assertFalse(tree.search(2));
    }

    @Test
    public void testGetNode(){
        IBinaryTree tree = new BinaryTree(5);
        tree.insert(8);
        tree.insert(4);
        tree.insert(12);
        tree.insert(2);
        tree.insert(6);
        tree.insert(10);
        tree.insert(14);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);
        tree.insert(9);
        tree.insert(11);
        tree.insert(13);
        tree.insert(15);

        Assertions.assertEquals(10, tree.getNode(10).data);
    }

    @Test
    public void testOnGetLeftNode(){
        BinaryTree tree = new BinaryTree(5);
        tree.insert(3);
        tree.insert(1);
        tree.insert(9);
        tree.insert(6);

        Assertions.assertEquals(3, tree.getLeftNode(tree.getRoot()).data);
    }

    @Test
    public void testOnGetRightNode(){
        BinaryTree tree = new BinaryTree(5);
        tree.insert(3);
        tree.insert(1);
        tree.insert(9);
        tree.insert(6);

        Assertions.assertEquals(9, tree.getRightNode(tree.getRoot()).data);
    }

    @Test
    public void testHeight(){
        IBinaryTree tree = new BinaryTree();
        tree.insert(8);
        tree.insert(4);
        tree.insert(12);
        tree.insert(2);
        tree.insert(6);
        tree.insert(10);
        tree.insert(14);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);
        tree.insert(9);
        tree.insert(11);
        tree.insert(13);
        tree.insert(15);

        Assertions.assertEquals(4, tree.height());
    }


    @Test
    public void testDeleteOnEmptyTree(){
        IBinaryTree tree = new BinaryTree();
        Assertions.assertEquals(0, tree.size());
        tree.delete(5);
        Assertions.assertEquals(0, tree.size());
    }

    @Test
    public void testInOrder(){
        IBinaryTree tree = new BinaryTree();
        tree.insert(8);
        tree.insert(4);
        tree.insert(12);
        tree.insert(2);
        tree.insert(6);
        tree.insert(10);
        tree.insert(14);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);
        tree.insert(9);
        tree.insert(11);
        tree.insert(13);
        tree.insert(15);


        Assertions.assertEquals(15, tree.size());

        int[] valueExpected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        int[] value = tree.inOrder();

        Assertions.assertArrayEquals(valueExpected, value);

        for (int i = 0; i<tree.size(); i++){
            System.out.print(value[i] + " ");

        }
    }

    @Test
    public void testPostOrder(){
        IBinaryTree tree = new BinaryTree();
        tree.insert(8);
        tree.insert(4);
        tree.insert(12);
        tree.insert(2);
        tree.insert(6);
        tree.insert(10);
        tree.insert(14);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);
        tree.insert(9);
        tree.insert(11);
        tree.insert(13);
        tree.insert(15);


        Assertions.assertEquals(15, tree.size());

        int[] valueExpected = {1, 3, 2, 5, 7, 6, 4, 9, 11, 10, 13, 15, 14, 12, 8};

        int[] value = tree.postOrder();

        Assertions.assertArrayEquals(valueExpected, value);

        for (int i = 0; i<tree.size(); i++){
            System.out.print(value[i] + " ");
        }
    }

    @Test
    public void testPreOrder(){
        IBinaryTree tree = new BinaryTree();
        tree.insert(8);
        tree.insert(4);
        tree.insert(12);
        tree.insert(2);
        tree.insert(6);
        tree.insert(10);
        tree.insert(14);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);
        tree.insert(9);
        tree.insert(11);
        tree.insert(13);
        tree.insert(15);



        Assertions.assertEquals(15, tree.size());

        int[] valueExpectged = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};

        int[] value = tree.preOrder();

        Assertions.assertArrayEquals(valueExpectged, value);

        for (int i = 0; i<tree.size(); i++){
            System.out.print(value[i] + " ");
        }
    }


}
