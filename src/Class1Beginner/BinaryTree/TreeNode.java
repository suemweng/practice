package Class1Beginner.BinaryTree;

public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public static TreeNode createTree(int[] array) {
        TreeNode head = new TreeNode(-1);
        return createTree(array, head,0);
    }

    private static TreeNode createTree(int[] array, TreeNode root, int i) {
        // base case
        if (i < array.length) {
            TreeNode newNode = new TreeNode(array[i]);
            root = newNode;


            root.left = createTree(array, root.left, 2 * i + 1);
            root.right = createTree(array, root.right, 2 * i + 2);
        }
        return root;
    }
}
