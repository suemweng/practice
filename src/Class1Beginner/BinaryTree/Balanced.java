package Class1Beginner.BinaryTree;

import com.sun.source.tree.Tree;

public class Balanced {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return height(root) != -1;
    }

    private static int height(TreeNode root) {
        // base case
        if (root == null) return 0;

        // recursion rule
        // check if left subtree is balanced
        int leftHeight = height(root.left);
        if (leftHeight == -1) return -1;
        // check if right subtree is balanced
        int rightHeight = height(root.right);
        if (rightHeight == -1) return -1;

        // check the whole tree is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight,rightHeight) + 1;

    }

    public static void main(String[] args) {

        //           10 (root)
        //          /  \
        //         5    15
        //                \
        //                20
        //               /
        //              30

        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(20);
        TreeNode node5 = new TreeNode(30);
        node1.left = node2;
        node1.right = node3;
        node3.right = node4;
        node4.left=node5;

        System.out.println(isBalanced(node1));
    }
}

// TC: O(n)
// SC: worse O(n) average O(logn)