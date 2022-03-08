/**
 * Laicode 128
 */

package Class2.Recursion;

import Class2.Tree.Tree;
import Class2.Tree.TreeNode;

public class LCAIII {

    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode one, TreeNode two) {
        // write your solution here
        if (root == null || one == null || two == null) {
            return null;
        }

        int[] found = {0};
        TreeNode result = helper(root, one, two, found);
        return found[0] == 2 ? result : null;
    }

    private TreeNode helper(TreeNode root, TreeNode one, TreeNode two, int[] found) {
        // base case
        if (root == null) {
            return null;
        }

        if (root == one || root == two) {
            found[0]++;
            if (found[0] == 2) {
                return root;
            }
        }

        TreeNode left = helper(root.left, one, two, found);
        TreeNode right = helper(root.right, one, two, found);


        if (root == one || root == two || left != null && right != null) {
            return root;
        }

        return left == null ? right : left;

    }

    public static void main(String[] args) {
        LCAIII obj = new LCAIII();

        Integer[] array = {5,9,12,2,3,null,14};
        TreeNode root = Tree.constructTree(array);
        TreeNode node9 = root.left;
        TreeNode node12 = root.right;
        TreeNode node2 = root.left.left;
        TreeNode node14 = root.right.right;
        TreeNode node8 = new TreeNode(8);
        TreeNode lca = obj.lowestCommonAncestor(root, node2, node12);
        System.out.println(lca.key);

    }
}
