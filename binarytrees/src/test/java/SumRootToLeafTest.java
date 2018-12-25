import org.junit.Test;

import static org.junit.Assert.*;

public class SumRootToLeafTest {

    private int expected;
    private BinaryTree<Integer> tree;

    @Test
    public void sumRootToLeaf1() throws Exception {
        expected = 3;
        tree = new BinaryTree<>(0);
        tree.right = new BinaryTree<>(1);
        tree.right.right = new BinaryTree<>(0);
        tree.left = new BinaryTree<>(0);
        tree.left.left = new BinaryTree<>(1);

        test(expected, tree);
    }

    @Test
    public void sumRootToLeaf2() throws Exception {
        expected = 11;
        tree = new BinaryTree<>(1);
        tree.right = new BinaryTree<>(1);
        tree.right.right = new BinaryTree<>(0);
        tree.left = new BinaryTree<>(0);
        tree.left.left = new BinaryTree<>(1);

        test(expected, tree);
    }

    @Test
    public void sumRootToLeaf3() throws Exception {
        //expected = 16;
        expected = 22;
        tree = new BinaryTree<>(1);
        tree.right = new BinaryTree<>(1);
        tree.right.right = new BinaryTree<>(0);
        tree.right.left = new BinaryTree<>(1);
        tree.left = new BinaryTree<>(0);
        tree.left.left = new BinaryTree<>(1);
        tree.left.right = new BinaryTree<>(0);

        test(expected, tree);
    }

    @Test
    public void testNineFour1() throws Exception {
        expected = 8;
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        tree.left = new BinaryTree<>(0);
        tree.left.left = new BinaryTree<>(0);
        tree.left.left.left = new BinaryTree<>(0);
        test(expected, tree);

    }

    @Test
    public void testNineFour2() throws Exception {
        expected = 9;
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        tree.left = new BinaryTree<>(0);
        tree.left.left = new BinaryTree<>(0);
        tree.left.left.right = new BinaryTree<>(1);
        test(expected, tree);

    }

    @Test
    public void testNineFour3() throws Exception {
        expected = 17;
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        tree.left = new BinaryTree<>(0);
        tree.left.left = new BinaryTree<>(0);
        tree.left.left.left = new BinaryTree<>(0);
        tree.left.left.right = new BinaryTree<>(1);
        test(expected, tree);

    }

    @Test
    public void testNineFour4() throws Exception {
        expected = 22;
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        tree.left = new BinaryTree<>(0);
        tree.left.right = new BinaryTree<>(1);
        tree.left.right.right = new BinaryTree<>(1);
        tree.left.right.right.left = new BinaryTree<>(0);

        test(expected, tree);

    }

    private void test(int expected, BinaryTree<Integer> tree) {
        assertEquals(expected, SumRootToLeaf.sumRootToLeaf(tree));
    }

}