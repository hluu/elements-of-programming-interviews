import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FindRootToLeafSumTest {

    private boolean expected;
    private BinaryTree<Integer> tree;
    private int targetSum;

    @Test
    public void hasPathSum1() throws Exception {
        expected = true;
        tree = BinaryTreeUtil.getFullTree();
        targetSum = 7;

        test(expected, tree, targetSum);
    }

    @Test
    public void hasPathSum2() throws Exception {
        expected = false;
        tree = BinaryTreeUtil.getFullTree();
        targetSum = 5;

        test(expected, tree, targetSum);
    }

    @Test
    public void hasPathSum3() throws Exception {
        expected = true;
        tree = BinaryTreeUtil.getFigureTenDotOne();
        targetSum = 1365;

        test(expected, tree, targetSum);
    }

    @Test
    public void hasPathSum4() throws Exception {
        expected = false;
        tree = BinaryTreeUtil.getFigureTenDotOne();
        targetSum = 724;

        test(expected, tree, targetSum);
    }

    @Test
    public void hasPathSum5() throws Exception {
        expected = true;
        tree = BinaryTreeUtil.getFigureTenDotOne();
        targetSum = 591;

        test(expected, tree, targetSum);
    }


    private void test(boolean expected, BinaryTree<Integer> tree, int targetSum) {
        assertEquals(expected, FindRootToLeafSum.hasPathSum1(tree, targetSum));
        assertEquals(expected, FindRootToLeafSum.hasPathSum2(tree, targetSum));
    }

    @Test
    public void hasPathSum6() throws Exception {
        List<String> expected1 = Arrays.asList("A", "B","C","D");
        List<String> expected2 = Arrays.asList("A", "I","O","P");
        tree = BinaryTreeUtil.getFigureTenDotOne();
        targetSum = 619;

        List<List<String>> result = FindRootToLeafSum.collectPaths(tree, targetSum);

        for (List<String> path : result) {
            System.out.println(path);
        }

        assertEquals(2, result.size());
        assertEquals(expected1, result.get(0));
        assertEquals(expected2, result.get(1));
        //System.out.println("actual codes: " + codes);
        //Assert.assertEquals(expected, codes);
    }

}