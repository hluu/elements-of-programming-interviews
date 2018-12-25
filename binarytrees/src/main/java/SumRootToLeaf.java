import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Each node in the tree represent a binary bit.
 *
 * Root to leaf represents a path that can be associated with a binary number
 * Note: MSB is at the root.
 *
 * Design an algorithm to compute the sum of the binary numbers represented by the
 * root-to-leaf paths.
 *
 * Brute force:
 * 1) generate the path from root to leaf,
 */
public class SumRootToLeaf {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = BinaryTreeUtil.getFigureTenDotOne();

        sumRootToLeafBF(tree);
    }
    /*
    10.5
    */

    public static int sumRootToLeaf(BinaryTree<Integer> tree) {

        //return sumRootToLeafBF(tree);
        return sumRootToLeafIncremental(tree, 0);

    }

    /**
     * Build the sum incrementally. Remember root is the MSB
     *
     *
     * @param tree
     * @return
     */
    public static int sumRootToLeafIncremental(BinaryTree<Integer> tree, int sumSoFar) {

        if (tree == null) {
            return 0;
        }

        // pre-order traversal

        sumSoFar = sumSoFar*2 + tree.data;

        if (tree.left == null && tree.right == null) {
            return sumSoFar;
        }


        return sumRootToLeafIncremental(tree.left, sumSoFar) +
                sumRootToLeafIncremental(tree.right, sumSoFar);
    }


    /**
     * Using the brute force approach, which builds the parent map
     * and a list of leaf nodes
     *
     * @param tree
     * @return
     */
    public static int sumRootToLeafBF(BinaryTree<Integer> tree) {
        List<BinaryTree<Integer>> leafList = new ArrayList<>();
        Map<BinaryTree<Integer>, BinaryTree<Integer>> pathMap =
                new HashMap<>();

        generateParentMap(tree, pathMap, leafList);

        int result = 0;
        for (BinaryTree<Integer> node : leafList) {
            System.out.println(node.data);
            result += calculatePath(node, pathMap);
        }
        return result;
    }

    private static int calculatePath(BinaryTree<Integer> leaf,
                                     Map<BinaryTree<Integer>, BinaryTree<Integer>> pathMap) {
        int result = leaf.data;

        BinaryTree<Integer> parent = pathMap.get(leaf);
        int position = 1;
        while (parent != null) {
            result += Math.pow(2, position)* parent.data;
            position++;
            parent = pathMap.get(parent);;
        }

        return result;
    }

    /**
     *
     * @param node current node
     * @param map child->parent map
     */
    private static void
        generateParentMap(BinaryTree<Integer> node,
                          Map<BinaryTree<Integer>, BinaryTree<Integer>> map,
                          List<BinaryTree<Integer>> leafList) {

        // if it is a leaf then return
        if (node.left == null && node.right == null) {
            leafList.add(node);
            return;
        }

        if (node.left != null) {
            map.put(node.left, node);
            generateParentMap(node.left, map, leafList);
        }

        if (node.right != null) {
            map.put(node.right, node);
            generateParentMap(node.right, map, leafList);
        }
    }
}
