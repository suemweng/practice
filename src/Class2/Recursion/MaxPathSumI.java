/**
 * Laicode 138. Maximum Path Sum Binary Tree I
 *
 * Given a binary tree in which each node contains an integer number. Find the maximum possible sum "from one leaf node to another leaf node". If there is no such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).
 *
 * Examples
 *
 *   -15
 *
 *   /    \
 *
 * 2      11
 *
 *      /    \
 *
 *     6     14
 *
 * The maximum path sum is 6 + 11 + 14 = 31.
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

public class MaxPathSumI {

    public int maxPathSum(TreeNode root) {

        int[] max = {Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }

    private int helper(TreeNode root, int[] max) {
        // base case
        if (root == null) {
            return 0;
        }

        int leftNum = helper(root.left, max);
        int rightNum = helper(root.right, max);

        if (root.left != null && root.right != null) {
            max[0] = Math.max(max[0], leftNum + rightNum + root.key);
            return Math.max(leftNum, rightNum) + root.key;
        }

        if (root.left == null) {
            return rightNum + root.key;
        } else {
            return leftNum + root.key;
        }
    }

    public static void main(String[] args) {
        MaxPathSumI obj = new MaxPathSumI();

        Integer[] array = {18,3,-77,null,16,62,79,-76,75,39,-88,38,-83,36,-68,-30,46,28,-19,46,1,null,44,-98,
                -37,90,53,-97,-38,-69,-71,null,-78};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        int max = obj.maxPathSum(root);
        System.out.println(max);

    }
}

// TC: O(n)
// SC: O(height)