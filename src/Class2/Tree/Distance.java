package Class2.Tree;

public class Distance {

    public int distance(TreeNode root, TreeNode one, TreeNode two) {
        // Write your solution here
        if (root == null || one == null || two == null) {
            return 0;
        }
        int[] result = new int[1];
        helper(root, one, two, result);
        return result[0];
    }

    private int helper(TreeNode node, TreeNode one, TreeNode two, int[] result) {

        if (node == null) {
            return 0;
        }


        int left = helper(node.left, one, two, result);
        int right = helper(node.right, one, two, result);

        if (node == one || node == two) {
            if (left == 0 && right == 0) {
                return 1;
            } else {
                result[0] = (left == 0 ? right : left);
            }
        }


        if (left > 0 && right > 0) {
            result[0] = left + right;
        }

        if (left == 0 && right == 0) {
            return 0;
        }

        return left == 0 ? right + 1 : left + 1;
    }

    public static void main(String[] args) {
        Distance obj = new Distance();

        Integer[] array = {6,3,5,7,8,1,2};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);

        TreeNode node6 = root;
        TreeNode node3 = root.left;
        TreeNode node5 = node6.right;
        TreeNode node7 = node3.left;
        TreeNode node8 = node3.right;
        TreeNode node1 = node5.left;
        TreeNode node2 = node5.right;

        System.out.println(obj.distance(root,node3,node1));
    }
}
