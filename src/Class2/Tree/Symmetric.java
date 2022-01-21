package Class2.Tree;

public class Symmetric {

    public boolean isSymmetric(TreeNode root) {
        // base case
        if (root == null){
            return true;
        }

        return isSymmetric(root.left, root.right);

    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        // base case
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.key != right.key) {
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static void main(String[] args) {
        Symmetric solution = new Symmetric();
        Integer[] array = {10,5,5,1,3,3,1,2,4,6,8,8,6,4,2};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        boolean result = solution.isSymmetric(root);
        System.out.println(result);

    }
}
