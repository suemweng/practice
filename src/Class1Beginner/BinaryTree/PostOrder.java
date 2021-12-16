package Class1Beginner.BinaryTree;

public class PostOrder {

    public static void postOrder(TreeNode root) {
        // base case
        if (root == null) return;

        // recursion rule
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(20);
        node1.left = node2;
        node1.right = node3;
        node3.right = node4;

        postOrder(node1);
    }
}


// TC: O(n)
// SC: wc O(n) avg O(logn)