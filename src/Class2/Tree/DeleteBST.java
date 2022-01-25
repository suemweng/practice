package Class2.Tree;

public class DeleteBST {

    public TreeNode deleteBST(TreeNode root, int target) {
        // corner case
        if (root == null) {
            return null;
        }

        // search target node
        if (root.key < target) {
            root.right = deleteBST(root.right, target);
            return root;                                // easy to forget
        } else if (root.key > target) {
            root.left = deleteBST(root.left, target);
            return root;                                // easy to forget
        }

        // root != null && root.value == target

        // case 1 & 2: no child
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        // cae 3: cur.right has no left child
        if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        }

        // cae 4: cur.right has left child
        // find the far left node
        TreeNode pre = root.right;
        TreeNode cur = pre.left;
        while (cur.left != null) {
            pre = cur;
            cur = cur.left;
        }

        pre.left = cur.right;
        cur.left = root.left;
        cur.right = root.right;
        return cur;
    }

    public static void main(String[] args) {
        DeleteBST solution = new DeleteBST();
        Integer[] array = {3,2,8,null,null,6,12,null,null,null,null,null,null,9};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        int target = 8;
        root = solution.deleteBST(root, target);
        Tree.print(root);

    }
}

// TC O(height) -- findTarget + findSmallest
// SC O(height) -- call stack