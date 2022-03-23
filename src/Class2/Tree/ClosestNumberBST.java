/**
 * Laicode 135. Closest Number In Binary Search Tree
 *
 * In a binary search tree, find the node containing the closest number to the given target number.
 *
 * Assumptions:
 *
 * The given root is not null.
 * There are no duplicate keys in the binary search tree.
 * Examples:
 *
 *     5
 *
 *   /    \
 *
 * 2      11
 *
 *      /    \
 *
 *     6     14
 *
 * closest number to 4 is 5
 *
 * closest number to 10 is 11
 *
 * closest number to 6 is 6
 */

package Class2.Tree;

public class ClosestNumberBST {

    public int closest(TreeNode root, int target) {

        // Key insight:
        // compare with abs of difference, keep updating the closest key on the path

        int result = root.key;
        while (root != null) {
            if (root.key == target) {
                return root.key;
            }

            if (Math.abs(root.key - target) < Math.abs(result - target)) {
                result = root.key;
            }

            if (root.key < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ClosestNumberBST obj = new ClosestNumberBST();

        Integer[] array = {5,2,11,null,null,6,14};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);

        int target = 4;
        int result = obj.closest(root, target);
        System.out.println(result);
    }
}
