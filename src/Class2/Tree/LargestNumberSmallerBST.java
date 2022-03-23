/**
 * Laicode 136. Largest Number Smaller In Binary Search Tree
 *
 * In a binary search tree, find the node containing the largest number smaller than the given target number.
 *
 * If there is no such number, return -2^31.
 *
 * Assumptions:
 *
 * The given root is not null.
 * There are no duplicate keys in the binary search tree.
 * Examples
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
 * largest number smaller than 1 is Integer.MIN_VALUE(Java) or INT_MIN(c++)
 *
 * largest number smaller than 10 is 6
 *
 * largest number smaller than 6 is 5
 */

package Class2.Tree;

public class LargestNumberSmallerBST {

    public int largestSmaller(TreeNode root, int target) {

        // Key insight:
        // keep updating the result when going right

        int result = Integer.MIN_VALUE;
        while (root != null) {
            if (root.key >= target) {
                root = root.left;
            } else {
                result = root.key;
                root = root.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LargestNumberSmallerBST obj = new LargestNumberSmallerBST();

        Integer[] array = {5,2,11,null,null,6,14};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);

        int target = 7;
        int result = obj.largestSmaller(root, target);
        System.out.println(result);
    }
}
