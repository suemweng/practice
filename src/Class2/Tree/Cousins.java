package Class2.Tree;

public class Cousins {

    // Key insight
    // found, return depth; not found, return -1;
    // update global boolean result at LCA

    // TC: O(n)
    // SC: O(height)

    public boolean isCousins(TreeNode root, TreeNode one, TreeNode two) {
        // corner case
        if (root == null || one == null || two == null) {
            return false;
        }
        boolean[] result = new boolean[1];
        dfs(0, root, one, two, result);
        return result[0];
    }

    private int dfs(int depth, TreeNode node, TreeNode one, TreeNode two, boolean[] result) {

        if (node == null) {
            return -1;
        }

        if (node == one || node == two) {
            return depth;
        }

        int left = dfs(depth + 1, node.left, one, two, result);
        int right = dfs(depth + 1, node.right, one, two, result);

        if (left == right && left - depth > 1) {
            result[0] = true;
        }

        return left == -1 ? right : left;
    }

    public static void main(String[] args) {
        Cousins obj = new Cousins();

        Integer[] array = {6,3,5,7,8,1,2};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);

        TreeNode node7 = root.left.left;
        TreeNode node1 = root.right.left;
        TreeNode node8 = root.left.right;
        System.out.println(obj.isCousins(root,node7,node8));
    }
}
