package Class2.Tree;

public class SearchBST {
    public TreeNode searchRecursive(TreeNode root, int target) {
        // base case
        if (root == null || root.key == target) {
            return root;
        }

        if (root.key < target) {
            return searchRecursive(root.right, target);
        } else { // target < root.key
            return searchRecursive(root.left, target);
        }

    }

    public TreeNode searchIterative(TreeNode root, int target) {
        // corner case
        if (root == null) {
            return null;
        }

        while (root != null) {
            if (root.key == target) {
                return root;
            } else if (root.key < target) {
                root = root.right;
            } else {  // target < cur.key
                root = root.left;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SearchBST solution = new SearchBST();
        Integer[] array = {10,5,15,null,8,14,16,null,null,6,9};
        TreeNode root = Tree.constructTree(array);
        int target = 7;
        TreeNode result = solution.searchRecursive(root, target);
        if (result == null) {
            System.out.println("Not Found");
        } else {
            System.out.println(result.key);
        }

    }
}
