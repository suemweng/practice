package Class2.Tree;

public class BSTHelper {

    public boolean isBSTHelper(TreeNode root) {
        // corner case
        if (root == null) {
            return true;
        }

        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTHelper(TreeNode root, int min, int max) {
        // base case
        if (root == null) {
            return true;
        }

        if (min >= root.key || root.key >= max) {
            return false;
        }

        return isBSTHelper(root.left, min, root.key) && isBSTHelper(root.right, root.key, max);

    }

    public static void main(String[] args) {
        BSTHelper solution = new BSTHelper();
        Integer[] array = {10,5,15,2,7,12,20};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        boolean result = solution.isBSTHelper(root);
        System.out.println(result);

    }
}
