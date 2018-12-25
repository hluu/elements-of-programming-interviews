import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * The path weight of a node is the sum of the integers on the unique path
 * from root to that node.
 *
 * Determine if there exists a leaf whose path weight equals the given targetSum
 *
 * Approach:
 *
 * 1) Similar to 10.5, traverse from root to leaf
 * 2) Maintain either running sum or remaining
 * 3) This will be pre-order traversal
 *
 *
 */
public class FindRootToLeafSum {

    /*
    10.6
    */

    public static boolean hasPathSum1(BinaryTree<Integer> tree, int targetSum) {
        if (tree == null) {
            return false;
        }
        System.out.println("*** hasPathSum1 ***");
        return hasPathSumWithRunningSum(tree, targetSum, 0);
    }

    public static boolean hasPathSum2(BinaryTree<Integer> tree, int targetSum) {
        if (tree == null) {
            return false;
        }

        System.out.println("*** hasPathSum2 ***");
        return hasPathSumWithRunningDiff(tree, targetSum);
    }

    /**
     * This is the running sum approach.  The running sum is maintained by
     * the stack
     *
     * @param tree
     * @param targetSum
     * @param runningSum
     * @return
     */
    private static boolean hasPathSumWithRunningSum(BinaryTree<Integer> tree,
                                                    int targetSum,
                                                    int runningSum) {

        if (tree == null) {
            return false;
        }

        runningSum += tree.data;

        // if leaf node then check
        if (tree.left == null && tree.right == null) {
            // found target sum and leaf node
            return runningSum == targetSum;
        }

        return hasPathSumWithRunningSum(tree.left, targetSum, runningSum) ||
                hasPathSumWithRunningSum(tree.right, targetSum, runningSum);
    }

    /**
     * This is the running difference approach.  The remain sum is maintained by
     * the stack
     *
     * @param tree
     * @param remaining - getting smaller as traversing down the tree
     * @return
     */
    private static boolean hasPathSumWithRunningDiff(BinaryTree<Integer> tree,
                                                    int remaining) {

        if (tree == null) {
            return false;
        }

        remaining -= tree.data;

        // if leaf node then check
        if (tree.left == null && tree.right == null) {
            // found target sum and leaf node
            return remaining == 0;
        }

        return hasPathSumWithRunningDiff(tree.left,  remaining) ||
                hasPathSumWithRunningDiff(tree.right, remaining);
    }

    /**
     * Return a list of node codes if there is a path with sum euqals to
     * target sum
     *
     * @param tree
     * @param targetSum
     * @return List<String>
     */
    public static List<List<String>> collectPaths(BinaryTree<Integer> tree,
                                                  int targetSum) {
        if (tree == null) {
            return Collections.emptyList();
        }
        System.out.println("*** collectPaths ***");
        List<List<String>> result = new ArrayList<>();
        List<String> collector = new ArrayList<>();

        hasPathSumWithCodesHelper(tree, targetSum, collector, result);
        return result;
    }

    private static void hasPathSumWithCodesHelper(BinaryTree<Integer> tree,
                                                     int remaining,
                                                     List<String> codes,
                                                     List<List<String>> result) {

        if (tree == null) {
            return ;
        }

        remaining -= tree.data;
        codes.add(tree.code);

        if (tree.left == null && tree.right == null){
            if (remaining == 0) {
                // leaf node
                result.add(new LinkedList<>(codes));
            }
            codes.remove(codes.size()-1);
            return;
        }


        hasPathSumWithCodesHelper(tree.left, remaining, codes, result);

        hasPathSumWithCodesHelper(tree.right, remaining, codes, result);

        codes.remove(codes.size()-1);

    }
}
