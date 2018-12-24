import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class InorderIterative {

    /*
    10.7
    */

    public static List<Integer> BSTInOrder(BinaryTree<Integer> tree) {

        return Collections.emptyList();
    }

    public static List<String> inOrderRecursion(BinaryTree<Integer> tree) {
        List<String> output = new LinkedList<>();

        inOrderRecursionHelper(tree, output);

        return output;
    }

    private static void inOrderRecursionHelper(BinaryTree<Integer> tree,
                                               List<String> collector) {

        if (tree == null) {
            return;
        }

        inOrderRecursionHelper(tree.left, collector);

        collector.add(tree.code);

        inOrderRecursionHelper(tree.right, collector);
    }
}
