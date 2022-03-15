/**
 * Laicode 523
 */

package Class2.Recursion;

import Class2.Tree.Tree;
import Class2.Tree.TreeNode;

public class FlattenTree {

    // Method 1 - 存档

    public TreeNode flattenI(TreeNode root) {
        // use prev[] to store the current prev pointer, prev is the connector
        // each level: connect prev and root, move prev to root, disconnect root's subtree
        TreeNode[] prev = new TreeNode[1];
        helperI(root, prev);
        return root;
    }

    private void helperI(TreeNode root, TreeNode[] prev) {
        if (root == null) {
            return;
        }

        TreeNode leftTree = root.left;
        TreeNode rightTree = root.right;

        if (prev[0] != null) {
            prev[0].right = root;
        }
        prev[0] = root;
        root.left = null;

        helperI(leftTree, prev);
        helperI(rightTree, prev);
    }

    // Method 2 - suggested answer

    public TreeNode flattenII(TreeNode root) {
        // Write your solution here
        // use prev[] to store the current prev pointer, prev is the top node to be connected
        // each level: connect root and prev, disconnect left tree, move prev to root
        TreeNode[] prev = new TreeNode[1];
        helperII(root, prev);
        return root;
    }

    private void helperII(TreeNode root, TreeNode[] prev) {
        if (root == null) {
            return;
        }

        helperII(root.right, prev);
        helperII(root.left, prev);

        root.right = prev[0];
        root.left = null;
        prev[0] = root;
    }

    public static void main(String[] args) {
        FlattenTree obj = new FlattenTree();

        Integer[] array = {1,2,5,3,4,null,6};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        TreeNode result = obj.flattenI(root);
        Tree.print(result);
    }
}
