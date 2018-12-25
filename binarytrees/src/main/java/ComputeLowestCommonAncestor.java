/**
 * LCA is the furthest node from the root that is an ancestor of both left and right nodes.
 *
 * When is the root the LCA? when it is ancestor of both nodes. In other words, one node
 * is on the left hand side and the other is on the right hand side of the root.
 *
 * Can we test this for every single node in the tree?
 *
 */
public class ComputeLowestCommonAncestor {

    /*
    10.3
    */

    public static BinaryTree<Integer> LCA(BinaryTree<Integer> tree,
                                          BinaryTree<Integer> node0,
                                          BinaryTree<Integer> node1) {

        if (tree == null || node1 == null || node1 == null){
            return null;
        }

        LCAStatus status = lcaHelper(tree, node0, node1);

        return status.ancestor;
    }

    /**
     * Using the post-order traversal - left, right, process node
     *
     * 1) Check the result of left or right side, short circuit when found
     *    the result we want
     *
     * @param tree
     * @param node0
     * @param node1
     * @return
     */
    private static LCAStatus lcaHelper(BinaryTree<Integer> tree,
                                        BinaryTree<Integer> node0,
                                        BinaryTree<Integer> node1) {

        if (tree == null) {
            return new LCAStatus(0, null);
        }

        LCAStatus leftSideStatus = lcaHelper(tree.left, node0, node1);
        if (leftSideStatus.numNodes == 2) {
            // if found both, going to the left
            return leftSideStatus;
        }

        LCAStatus rightSideStatus = lcaHelper(tree.right, node0, node1);
        if (rightSideStatus.numNodes == 2) {
            // if found both, going to the right
            return rightSideStatus;
        }

        // processing with following checking"
        // 1) if tree is node0 or node1
        // 2) sum up the number of nodes from left or right
        // 3  return the LCA status


        int numNodes = 0;
        if (tree == node0) {
            numNodes += 1;
        }

        if (tree == node1) {
            numNodes += 1;
        }

        // we are at a node, examine num nodes of left and right children
        numNodes += leftSideStatus.numNodes;
        numNodes += rightSideStatus.numNodes;

        return new LCAStatus(numNodes, numNodes == 2 ? tree : null);
    }



    private static class LCAStatus {
        public int numNodes;
        public BinaryTree<Integer> ancestor;

        public LCAStatus(int numNodes, BinaryTree<Integer> node) {
            this.numNodes = numNodes;
            this.ancestor = node;
        }


    }

}
