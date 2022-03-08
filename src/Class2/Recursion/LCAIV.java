package Class2.Recursion;

import Class2.Tree.Tree;
import Class2.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LCAIV {

    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        // Write your solution here.

        // base case
        if (root == null) {
            return root;
        }

        for (TreeNode node : nodes) {
            if (root == node) {
                return root;
            }
        }

        TreeNode left = lowestCommonAncestor(root.left, nodes);
        TreeNode right = lowestCommonAncestor(root.right, nodes);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

    public static void main(String[] args) {
        LCAIV obj = new LCAIV();

        Integer[] array = {5,9,12,2,3,null,14};
        TreeNode root = Tree.constructTree(array);
        TreeNode node2 = root.left.left;
        TreeNode node3 = root.left.right;
        TreeNode node9 = root.left;
        TreeNode node14 = root.right.right;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node9);
        TreeNode lca = obj.lowestCommonAncestor(root, nodes);
        System.out.println(lca.key);

    }
}
