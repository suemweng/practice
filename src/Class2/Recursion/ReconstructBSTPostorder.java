package Class2.Recursion;

import Class2.Tree.Tree;
import Class2.Tree.TreeNode;

public class ReconstructBSTPostorder {

    // use min to set the left boundary of subtrees (from right to left)
    // use index[] to store the global current pointer

    public TreeNode reconstruct(int[] post) {

        int[] index = {post.length - 1};
        return helper(post, index, Integer.MIN_VALUE);
    }

    private TreeNode helper(int[] post, int[] index, int min) {
        if (index[0] < 0 || post[index[0]] < min) {
            return null;
        }

        TreeNode root = new TreeNode(post[index[0]--]);
        root.right = helper(post, index, root.key);
        root.left = helper(post, index, min);
        return root;
    }

    public static void main(String[] args) {
        ReconstructBSTPostorder obj = new ReconstructBSTPostorder();

        int[] array = {1,4,3,1,1,8,5};
        TreeNode root = obj.reconstruct(array);
        Tree.print(root);
    }
}
