package Class1Beginner.BinaryTree;

public class CountNodes {

    public static int countNodes(TreeNode root) {
        // base case
        if (root == null) return 0;

        // recursion rule

        return countNodes(root.left) + countNodes(root.right) + 1;

    }

    public static void main(String[] args) {

        //           10 (root)
        //          /  \
        //         5    15
        //                \
        //                20

        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(20);
        node1.left = node2;
        node1.right = node3;
        node3.right = node4;

        System.out.println(countNodes(node1));
    }
}
