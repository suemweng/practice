/**
 * Laicode 141. Binary Tree Path Sum To Target III
 *
 * Given a binary tree in which each node contains an integer number. Determine if there exists a path (the path can only be from one node to itself or to any of its descendants), the sum of the numbers on the path is the given target number.
 *
 * Examples
 *
 *     5
 *
 *   /    \
 *
 * 2      11
 *
 *      /    \
 *
 *     6     14
 *
 *   /
 *
 *  3
 *
 * If target = 17, There exists a path 11 + 6, the sum of the path is target.
 *
 * If target = 20, There exists a path 11 + 6 + 3, the sum of the path is target.
 *
 * If target = 10, There does not exist any paths sum of which is target.
 *
 * If target = 11, There exists a path only containing the node 11.
 */

package Class2.Recursion;

import Class2.Tree.Tree;
import Class2.Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryTreePathSumToTarget {

    // Method 1
    // Key insight:
    // keep nodes in a path list;
    // find the sum by looking up from current node

    public boolean exist(TreeNode root, int target) {

        if (root == null) {
            return false;
        }
        List<TreeNode> path = new ArrayList<>();
        return helper(root, target, path);
    }

    private boolean helper(TreeNode node, int target, List<TreeNode> path) {
        path.add(0, node);

        int curSum = 0;
        for (TreeNode cur : path) {
            curSum += cur.key;
            if (curSum == target) {
                return true;
            }
        }

        if (node.left != null && helper(node.left, target, path)) {
            return true;
        }
        if (node.right != null && helper(node.right, target, path)) {
            return true;
        }
        path.remove(0);
        return false;
    }

    // Method 2
    // Key insight:
    // use a set to save all prefixSum and find (current Sum - target)

    public boolean existII(TreeNode root, int target) {
        // Write your solution here
        if (root == null) {
            return false;
        }
        Set<Integer> prefixSum = new HashSet<>();
        // important to add 0 for the case of current Sum == target
        prefixSum.add(0);
        return helperII(root, target, prefixSum, 0);
    }

    private boolean helperII(TreeNode node, int target, Set<Integer> prefixSum, int prevSum) {
        prevSum += node.key;

        if (prefixSum.contains(prevSum - target)) {
            return true;
        }

        // use newSum to check if the prevSum has been added before
        // if no, do not remove in this call
        boolean newSum = prefixSum.add(prevSum);
        if (node.left != null && helperII(node.left, target, prefixSum, prevSum)) {
            return true;
        }
        if (node.right != null && helperII(node.right, target, prefixSum, prevSum)) {
            return true;
        }
        if (newSum){
            prefixSum.remove(prevSum);
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTreePathSumToTarget obj = new BinaryTreePathSumToTarget();

        Integer[] array = {-1,-2,-6,-3,-4,null,null,-7,-8,-5,null};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);

        int target = -8;
        System.out.println(obj.existII(root, target));
    }
}
