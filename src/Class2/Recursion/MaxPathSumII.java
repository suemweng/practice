/**
 *  Laicode 139. Maximum Path Sum Binary Tree II
 *
 *  Given a binary tree in which each node contains an integer number. Find the maximum possible sum from any node to any node (the start node and the end node can be the same).
 *
 * Assumptions
 *
 * The root of the given binary tree is not null
 * Examples
 *
 *    -1
 *
 *   /    \
 *
 * 2      11
 *
 *      /    \
 *
 *     6    -14
 *
 * one example of paths could be -14 -> 11 -> -1 -> 2
 *
 * another example could be the node 11 itself
 *
 * The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18
 *
 *
 */

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */

package Class2.Recursion;

import Class2.Tree.Tree;
import Class2.Tree.TreeNode;

public class MaxPathSumII {
    // Assumptions: root is not null
    // max stores the global maximum path sum and
    // will be updated during the recursion
    public int maxPathSum(TreeNode root) {

        int[] max = {Integer.MIN_VALUE};
        maxPathSumHelper(root, max);
        return max[0];
    }

    // return the maximum path sum of the "single" path
    private int maxPathSumHelper(TreeNode root, int[] max) {
        // base case
        if (root == null) {
            return 0;
        }

        int leftSum = maxPathSumHelper(root.left, max);
        int rightSum = maxPathSumHelper(root.right, max);

        leftSum = leftSum < 0 ? 0 : leftSum;
        rightSum = rightSum < 0 ? 0 : rightSum;

        // max of current root vs max[0]
        max[0] = Math.max(max[0], leftSum + rightSum + root.key);

        return Math.max(leftSum, rightSum) + root.key;
    }

    public static void main(String[] args) {
        MaxPathSumII obj = new MaxPathSumII();

        Integer[] array = {-1,2,11,null,null,6,-14};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        int max = obj.maxPathSum(root);
        System.out.println(max);

    }
}
// TC: O(n)
// SC: O(height)