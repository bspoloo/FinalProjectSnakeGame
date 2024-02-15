import bspo.arrays.Interfaces.IBinaryTree;
import bspo.arrays.binarytree.BinaryTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryTreeTests {


    @Test
    public void testInsertOnOneElement() {
        IBinaryTree tree = new BinaryTree();
        tree.insert(5);
        Assertions.assertEquals(1, tree.size());
        Assertions.assertTrue(tree.search(5));
    }


    @Test
    public void testInsertOnMultipleElements(){
        IBinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(2);
        tree.insert(9);
        tree.insert(6);

        Assertions.assertEquals(4, tree.size());
        Assertions.assertTrue(tree.search(5));
        Assertions.assertTrue(tree.search(2));
        Assertions.assertTrue(tree.search(9));
        Assertions.assertTrue(tree.search(6));
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
        IBinaryTree tree = new BinaryTree(5);
        tree.insert(3);
        tree.insert(1);
        tree.insert(9);
        tree.insert(6);

        Assertions.assertEquals(5, tree.getRoot().data);
    }


    @Test
    public void testDelete() {
        IBinaryTree tree = new BinaryTree();
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(5);
        tree.insert(4);

        tree.delete(5);

        Assertions.assertEquals(4, tree.size());
        Assertions.assertFalse(tree.search(5));
    }

    @Test
    public void testSearch(){
        IBinaryTree tree = new BinaryTree(5);
        tree.insert(3);
        tree.insert(1);
        tree.insert(9);
        tree.insert(6);

        Assertions.assertTrue(tree.search(9));
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
        tree.insert(3);
        tree.insert(1);
        tree.insert(9);
        tree.insert(6);

        Assertions.assertEquals(9, tree.getNode(9).data);
    }

    @Test
    public void testHeight(){
        IBinaryTree tree = new BinaryTree(5);
        tree.insert(3);
        tree.insert(1);
        tree.insert(9);
        tree.insert(10);
        tree.insert(6);

        Assertions.assertEquals(3, tree.height());
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
        tree.insert(5);
        tree.insert(6);
        tree.insert(9);
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        tree.insert(10);

        Assertions.assertEquals(9, tree.size());

        int[] value = tree.inOrder();

        for (int i = 0; i<tree.size(); i++){
            System.out.print(value[i] + " ");

        }
    }

    @Test
    public void testPreOrder(){
        IBinaryTree tree = new BinaryTree();
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);


        int[] value = tree.preOrder();

        for (int i = 0; i<tree.size(); i++){
            System.out.print(value[i] + " ");
        }
    }

    @Test
    public void testPostOrder(){
        IBinaryTree tree = new BinaryTree();
        tree.insert(8);
        tree.insert(5);
        tree.insert(6);
        tree.insert(9);
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        tree.insert(10);


        Assertions.assertEquals(9, tree.size());

        int[] value = tree.postOrder();

        for (int i = 0; i<tree.size(); i++){
            System.out.print(value[i] + " ");
        }
    }


}
