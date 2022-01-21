/*
Let's assume if we tweak the left child with right child of an arbitrary node in a binary tree, then
the "structure" of the tree are not changed.  Then how can we determine whether two binary trees'
structures are identical.
 */

package Class2.Tree;

public class Identical {

    public boolean isIdentical(TreeNode root1, TreeNode root2) {
        // base case
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        } else if (root1.key != root2.key) {
            return false;
        }

        return isIdentical(root1.left, root2.left) && isIdentical(root1.right,root2.right) ||
                isIdentical(root1.left, root2.right) && isIdentical(root1.right,root2.left);


    }

    public static void main(String[] args) {
        Identical solution = new Identical();
        Integer[] array1 = {8,4,5,7};
        TreeNode root1 = Tree.constructTree(array1);
        Tree.print(root1);
        Integer[] array2 = {8,5,4,null,null,null,7};
        TreeNode root2 = Tree.constructTree(array2);
        Tree.print(root2);
        boolean result = solution.isIdentical(root1, root2);
        System.out.println(result);

    }


}
