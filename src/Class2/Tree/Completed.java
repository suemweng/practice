/**
 * Laicode 47. Check If Binary Tree Is Completed
 *
 * Check if a given binary tree is completed. A complete binary tree is one in which every level of the binary tree is completely filled except possibly the last level. Furthermore, all nodes are as far left as possible.
 *
 * Examples
 *
 *         5
 *
 *       /    \
 *
 *     3        8
 *
 *   /   \
 *
 * 1      4
 *
 * is completed.
 *
 *         5
 *
 *       /    \
 *
 *     3        8
 *
 *   /   \        \
 *
 * 1      4        11
 *
 * is not completed.
 *
 * Corner Cases
 *
 * What if the binary tree is null? Return true in this case.
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

package Class2.Tree;

import java.util.Queue;
import java.util.ArrayDeque;

public class Completed {

    // check null, then check flag
    public boolean isCompleted(TreeNode root) {

        // corner case
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        // if the flag is set true, there should not be any child nodes afterwards
        boolean flag = false;

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            // if any of the child is not present, set the flag to true
            if (cur.left == null) {
                flag = true;
            } else if (flag) {
                // if the flag is set true, but we still see cur has a left child,
                // the binary tree is not a completed one
                return false;
            } else {
                // if the flag is not set and left child is present
                q.offer(cur.left);
            }

            // same logic applied to the right child
            if (cur.right == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                q.offer(cur.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Completed obj = new Completed();

        Integer[] array = {5,3,8,1,4};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        boolean result = obj.isCompleted(root);
        System.out.println(result);
    }
}

// TC: O(n)
// SC: O(n)
