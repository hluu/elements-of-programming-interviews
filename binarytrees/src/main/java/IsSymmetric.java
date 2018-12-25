/**
 * Whether the left subtree is the mirror image of the right subtree.
 *
 * Approach:
 * - recursing down the subtrees (left, right) check if the node structure and value
 *   are the same, if yes, keep going, if no, stop
 *
 * Runtime: O(n)
 * Space: O(h) -> at any point in time, the stack stores the maximum of nodes that
 *                is equivalent to the depth of the tree
 */
public class IsSymmetric {

    /*
    10.2
    */

    public static boolean isSymmetric(BinaryTree<Integer> tree) {

        if (tree == null) {
            return true;
        }
        return isSymmetricHelper(tree.left, tree.right);
    }

    private static boolean isSymmetricHelper(BinaryTree<Integer> left,
                                             BinaryTree<Integer> right) {

        if (left == null && right == null) {
            return true;
        }

        // ==> short circuit when not satisfy symmetric constraints

        // if one is null then not symmetry
        if (left == null || right == null) {
            return false;
        }

        // check the values
        if (left.data != right.data) {
            return false;
        }

        // now keeping going down to next level (left,right) && (right, left)
        return isSymmetricHelper(left.left, right.right) &&
                isSymmetricHelper(left.right, right.left);
    }

}
