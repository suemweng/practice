/**
 * Final Exam
 *
 * Q2. Distance between two given nodes in a given binary search tree.
 *
 *
 *
 *     Assuming:
 *
 * there is no parent pointer.
 *
 * both nodes belong to the tree.
 *
 *            15
 *
 *         /          \
 *
 *       5           20
 *
 *      /    \
 *
 *    3      10
 *
 *  /   \      /
 *
 * 1   4    8
 *
 *           /   \
 *
 *          7     9
 *
 *
 *
 * distance(3, 8) = 3
 *
 * distance(5, 7) = 3
 *
 * distance(1, 9) = 5
 *
 *
 *
 * class TreeNode {
 *
 * int val;
 *
 * TreeNode left;
 *
 * TreeNode right;
 *
 * }
 */

package Class2.Tree;

import Class2.Recursion.LCABST;

public class DistanceBST {

    public int distance(TreeNode root, TreeNode one, TreeNode two) {
        // corner case
        if (root == null || one == null || two == null) {
            return 0;
        }

        TreeNode LCA = findLCA(root, one, two);
        return depth(LCA, one) + depth(LCA, two);
    }

    private TreeNode findLCA(TreeNode root, TreeNode one, TreeNode two) {
        int small = Math.min(one.key, two.key);
        int large = Math.max(one.key, two.key);

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

    private int depth(TreeNode node, TreeNode target) {

        if (node == null) {
            return -1;
        }

        if (node.key == target.key) {
            return 0;
        } else if (node.key > target.key) {
            return depth(node.left, target) + 1;
        } else {
            return depth(node.right, target) + 1;
        }

    }

    public static void main(String[] args) {
        DistanceBST obj = new DistanceBST();

        Integer[] array = {5,2,12,1,3,null,14};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);

        TreeNode node5 = root;
        TreeNode node2 = node5.left;
        TreeNode node12 = node5.right;
        TreeNode node1 = node2.left;
        TreeNode node3 = node2.right;
        TreeNode node14 = node12.right;
        int distance = obj.distance(node5, node1, node12);
        System.out.println(distance);
    }
}
