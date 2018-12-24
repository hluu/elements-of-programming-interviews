import java.util.List;

/**
 * A binary tree is said to be height-balanced if the difference in the height
 * of its left and right subtrees is at most one.
 *
 */
public class IsHeightBalanced {

    /**
     * 9.1
    */

    public static void main(String[] args) {
        BinaryTree<Integer> root = BinaryTreeUtil.getFigureTenDotOne();

        List<String> result = InorderIterative.inOrderRecursion(root);

        System.out.println(result);

    }

    private static class NodeStatusWithHeight {
        public boolean isBalanced;
        public int height;

        public NodeStatusWithHeight(boolean balanced, int height) {
            this.isBalanced = balanced;
            this.height = height;
        }
    }

    /**
     * Text book solution: using a class to maintain a flag and
     * height.
     *
     * @param tree
     * @return
     */
    public static boolean isBalanced(BinaryTree<Integer> tree) {

        NodeStatusWithHeight result = checkBalanced(tree);
        return result.isBalanced;
    }


    private static NodeStatusWithHeight checkBalanced(BinaryTree<Integer> tree) {
        // base case,
        if (tree == null) {
            return new NodeStatusWithHeight(true, -1);
        }

        NodeStatusWithHeight leftStatus = checkBalanced(tree.left);
        // if left subtree is not balanced, no need to check the right subtree
        if (!leftStatus.isBalanced) {
            return leftStatus;
        }


        NodeStatusWithHeight rightStatus = checkBalanced(tree.right);
        // if right substree is not balanced, short circuit it
        if (!rightStatus.isBalanced) {
            return rightStatus;
        }


        boolean isBalanced = Math.abs(leftStatus.height - rightStatus.height) <= 1;
        int height = Math.max(leftStatus.height, rightStatus.height) + 1;

        return new NodeStatusWithHeight(isBalanced, height);

    }


    /**
     * General approach - compute the height of left and right subtree
     * and compare the difference.
     *
     * This is similar to the post-order traversal
     *
     * @param tree
     * @return
     */
    public static boolean isBalancedUsingHeight(BinaryTree<Integer> tree) {

        int leftHeight = getHeight(tree.left);
        if (leftHeight == -1) {
            return false;
        }
        int rightHeight = getHeight(tree.right);

        if (rightHeight == -1) {
            return false;
        }

        return Math.abs(leftHeight - rightHeight) <= 1;
    }

    private static int getHeight(BinaryTree<Integer> tree) {

        // base case
        if (tree == null) {
            return 0;
        }

        int left = getHeight(tree.left) + 1;

        int right = getHeight(tree.right) + 1;

        if (Math.abs(left-right) > 1) {
            System.out.println("***** return -1, left: "
                    + left + " right: " + right + " at: " + tree.data);
            return -1;
        }

        return Math.max(left, right);

    }
}