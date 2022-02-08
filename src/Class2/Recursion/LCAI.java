/**
 *  Laicode 126. Lowest Common Ancestor I
 *
 *  Given two nodes in a binary tree, find their lowest common ancestor.
 *
 * Assumptions
 *
 * There is no parent pointer for the nodes in the binary tree
 * The given two nodes are guaranteed to be in the binary tree
 * Examples
 *
 *         5
 *
 *       /   \
 *
 *      9     12
 *
 *    /  \      \
 *
 *   2    3      14
 *
 * The lowest common ancestor of 2 and 14 is 5
 *
 * The lowest common ancestor of 2 and 9 is 9
 */

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */

package Class2.Recursion;

import Class2.Tree.Tree;
import Class2.Tree.TreeNode;

public class LCAI {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        // Assumptions: root is not null
        // one and two guaranteed to be in the tree and not null

        // base case
        // if root is one or two, we can ignore the later recursions
        if (root == null || root == one || root == two) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, one, two);
        TreeNode right = lowestCommonAncestor(root.right, one, two);


        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        } else {
            return right;
        }

    }

    public static void main(String[] args) {
        LCAI obj = new LCAI();

        Integer[] array = {5,9,12,2,3,null,14};
        TreeNode root = Tree.constructTree(array);
        TreeNode node2 = root.left.left;
        TreeNode node9 = root.left;
        TreeNode node14 = root.right.right;
        TreeNode lca = obj.lowestCommonAncestor(root, node2, node9);
        System.out.println(lca.key);

    }
}

// TC: O(n)
// SC: O(height)
