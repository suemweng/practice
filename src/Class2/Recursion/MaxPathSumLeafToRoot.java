/**
 * Laicode 639. Max Path Sum From Leaf To Root
 *
 * Given a binary tree in which each node contains an integer number. Find the maximum possible path sum from a leaf to root.
 *
 *
 * Assumptions
 * The root of given binary tree is not null.
 *
 *
 * Examples
 *
 *
 *          10
 *        /      \
 *     -2        7
 *   /     \
 * 8      -4
 * The maximum path sum is 10 + 7 = 17.
 */

package Class2.Recursion;

import Class2.Tree.Tree;
import Class2.Tree.TreeNode;

public class MaxPathSumLeafToRoot {

    // Method 1: Bottom up return max suffix sum
    public int maxPathSumLeafToRoot(TreeNode root) {

        // base case
        if (root == null) {
            return 0;
        }

        int left = maxPathSumLeafToRoot(root.left);
        int right = maxPathSumLeafToRoot(root.right);

        if (root.left != null && root.right != null) {
            return Math.max(left, right) + root.key;
        }

        if (root.left == null) {
            return right + root.key;
        } else {
            return left + root.key;
        }

    }

    public static void main(String[] args) {
        MaxPathSumLeafToRoot obj = new MaxPathSumLeafToRoot();

        Integer[] array = {4,-9,-15,-3};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        int max = obj.maxPathSumLeafToRoot(root);
        System.out.println(max);

    }
}

// TC: O(n)
// SC: O(height)