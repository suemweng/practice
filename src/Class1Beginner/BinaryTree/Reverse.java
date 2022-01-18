

package Class1Beginner.BinaryTree;

public class Reverse {

    public TreeNode reverse(TreeNode root) {
        // Write your solution here
        // base case
        if (root == null || root.left == null) return root;

        TreeNode head = reverse(root.left);

        root.left.left = root;
        root.left.right = root.right;
        root.left = null;
        root.right = null;
        return head;
    }

    public static void main(String[] args) {

        //           1 (root)
        //          /  \
        //         2    5
        //        / \
        //       3   4

        int[] array = {1,2,5,3,4};
        TreeNode head = TreeNode.createTree(array);

        Reverse solution = new Reverse();
        PreOrder.preOrder(solution.reverse(head));
    }
}
