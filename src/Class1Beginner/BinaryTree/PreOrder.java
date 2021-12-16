package Class1Beginner.BinaryTree;

public class PreOrder {

    public static void preOrder(TreeNode root) {
        // base case
        if (root == null) return;

        // recursion rule
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(20);
        node1.left = node2;
        node1.right = node3;
        node3.right = node4;

        preOrder(node1);
    }
}


// TC: O(n)
// SC: wc O(n) avg O(logn)