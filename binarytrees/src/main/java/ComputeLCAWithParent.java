
import java.util.HashSet;
import java.util.Set;

/**
 * Assuming each node in the tree has parent field so that it can travel
 * upward.
 *
 * Given two nodes in the tree, find the LCA (lowest common ancestor) between
 * them.
 *
 * One of the two nodes can be the root node.
 *
 * An LCA of two nodes is the common node in both the paths from root to each
 * of the nodes.  How to find that common node?
 *
 * Approaches:
 * 1) Build a path of one of the nodes from itself to the root.  For the other node,
 *    as it walks up the parent path, check the if parent is in the path of the other node.
 *
 * 2) Two nodes can be at a different height in the tree.  Find the height of each node.
 *    Figure out which on is at the deeper end and walk it up to the same level as
 *    the other one.  Then walk them up in tandem until reach tha common code.
 *
 */
public class ComputeLCAWithParent {

    /*
    10.4
    */

    public static BinaryTreeParent<Integer> LCA(BinaryTreeParent<Integer> node0,
                                                BinaryTreeParent<Integer> node1) {
        return lcaUsingPath(node0, node1);
    }

    private static BinaryTreeParent<Integer> lcaUsingPath(BinaryTreeParent<Integer> node0,
                                                          BinaryTreeParent<Integer> node1) {

        BinaryTreeParent<Integer> notRootNode = null;

        Set<BinaryTreeParent<Integer>> pathToRoot = new HashSet<>();

        // find the node that is not root by looking at parent
        notRootNode = (node0.parent != null) ? node0 : node1;

        // use tmpNode to walk up the parent path
        BinaryTreeParent<Integer> tmpNode = notRootNode;

        while (tmpNode != null) {
            pathToRoot.add(tmpNode);
            tmpNode = tmpNode.parent;
        }

        // the other node
        tmpNode = (notRootNode == node0) ? node1 : node0;

        while (tmpNode != null) {
            if (pathToRoot.contains(tmpNode)) {
                return tmpNode;
            }

            tmpNode = tmpNode.parent;
        }

        // if can't find the LCA, then return null;
        return null;

    }

    public static BinaryTreeParent<Integer> lcaUsingDepth(BinaryTreeParent<Integer> node0,
                                                          BinaryTreeParent<Integer> node1) {

        int node0Depth = getDepth(node0);
        int node1Depth = getDepth(node1);

        int diff = Math.abs(node0Depth - node1Depth);

        BinaryTreeParent<Integer> tmpNodeToMoveUp = (node0Depth > node1Depth) ? node0 : node1;

        for (int i = 0; i < diff; i++) {
            tmpNodeToMoveUp = tmpNodeToMoveUp.parent;
        }

        // now both tmpNodeToMoveUp and other node should be at the same level
        BinaryTreeParent<Integer> tmpOtherNode = (node0Depth > node1Depth) ? node1 : node0;

        while (tmpNodeToMoveUp != null) {
            if (tmpNodeToMoveUp == tmpOtherNode) {
                return tmpOtherNode;
            }

            tmpOtherNode = tmpOtherNode.parent;
            tmpNodeToMoveUp = tmpNodeToMoveUp.parent;
        }

        return null;

    }

    private static int getDepth(BinaryTreeParent<Integer> node) {
        int result = 0;

        while (node != null) {
            node = node.parent;
            result++;
        }

        return result;
    }

}
