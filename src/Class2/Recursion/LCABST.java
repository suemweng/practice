package Class2.Recursion;

import Class2.Tree.Tree;
import Class2.Tree.TreeNode;
import com.sun.jdi.PathSearchingVirtualMachine;

public class LCABST {

    public TreeNode lca(TreeNode root, int p, int q) {
        int small = Math.min(p, q);
        int large = Math.max(p, q);

        while (root != null) {
            if (root.key > large) {
                root = root.left;
            } else if (root.key < small) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LCABST obj = new LCABST();

        Integer[] array = {5,2,12,1,3,null,14};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        TreeNode lca = obj.lca(root, 1, 14);
        System.out.println(lca.key);
    }
}
// TC: O(log n)
// SC: O(1)