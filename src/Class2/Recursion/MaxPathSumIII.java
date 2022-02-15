/**
 * Laicode 140. Maximum Path Sum Binary Tree III
 *
 * Given a binary tree in which each node contains an integer number. Find the maximum possible subpath sum(both the starting and ending node of the subpath should be on the same path from root to one of the leaf nodes, and the subpath is allowed to contain only one node).
 *
 * Assumptions
 *
 * The root of given binary tree is not null
 * Examples
 *
 *    -5
 *
 *   /    \
 *
 * 2      11
 *
 *      /    \
 *
 *     6     14
 *
 *            /
 *
 *         -3
 *
 * The maximum path sum is 11 + 14 = 25
 *
 * How is the binary tree represented?
 *
 * We use the level order traversal sequence with a special symbol "#" denoting the null node.
 *
 * For Example:
 *
 * The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
 *
 *     1
 *
 *   /   \
 *
 *  2     3
 *
 *       /
 *
 *     4
 */
package Class2.Recursion;

import Class2.Tree.Tree;
import Class2.Tree.TreeNode;

public class MaxPathSumIII {

    public int maxPathSum(TreeNode root) {

        // corner case
        if (root == null) {
            return 0;
        }

        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSumHelper(root, max);
        return max[0];
    }

    private int maxPathSumHelper(TreeNode root, int[] max) {
        // base case
        if (root == null) {
            return 0;
        }

        int leftPath = Math.max(maxPathSumHelper(root.left, max), 0);
        int rightPath = Math.max(maxPathSumHelper(root.right, max), 0);
        int sum = Math.max(leftPath, rightPath) + root.key;
        max[0] = Math.max(sum, max[0]);
        return sum;

    }

    public static void main(String[] args) {
        MaxPathSumIII obj = new MaxPathSumIII();

        Integer[] array = {-1,2,11,null,null,6,-14};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        int max = obj.maxPathSum(root);
        System.out.println(max);

    }
}

// TC: O(n)
// SC: O(height)