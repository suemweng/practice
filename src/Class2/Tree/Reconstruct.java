/**
 * Laicode 213. Reconstruct Binary Tree With Preorder And Inorder
 *
 * Given the preorder and inorder traversal sequence of a binary tree, reconstruct the original tree.
 *
 * Assumptions
 *
 * The given sequences are not null and they have the same length
 * There are no duplicate keys in the binary tree
 * Examples
 *
 * preorder traversal = {5, 3, 1, 4, 8, 11}
 *
 * inorder traversal = {1, 3, 4, 5, 8, 11}
 *
 * the corresponding binary tree is
 *
 *         5
 *
 *       /    \
 *
 *     3        8
 *
 *   /   \        \
 *
 * 1      4        11
 *
 * How is the binary tree represented?
 *
 * We use the pre order traversal sequence with a special symbol "#" denoting the null node.
 *
 * For Example:
 *
 * The sequence [1, 2, #, 3, 4, #, #, #] represents the following binary tree:
 *
 *     1
 *
 *   /   \
 *
 *  2     3
 *
 *       /
 *
 *     4
 */

package Class2.Tree;

import java.util.HashMap;
import java.util.Map;

public class Reconstruct {

    // highlight: use map to locate root in inOrder

    public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
        // Write your solution here

        Map<Integer, Integer> idxMap = new HashMap<>();
        for(int i = 0; i < inOrder.length; i++) {
            idxMap.put(inOrder[i], i);
        }

        return helper(idxMap, 0, inOrder.length - 1, preOrder, 0 , preOrder.length - 1);

    }

    private TreeNode helper(Map<Integer, Integer> idxMap, int iL, int iR, int[] preOrder, int pL, int pR) {
        // base case
        if (iL > iR || pL > pR) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[pL]);
        int leftSize = idxMap.get(preOrder[pL]) - iL;

        root.left = helper(idxMap, iL, iL + leftSize - 1, preOrder, pL + 1, pL + leftSize);
        root.right = helper(idxMap, iL + leftSize + 1, iR, preOrder, pL + leftSize + 1, pR);

        return root;
    }

    public static void main(String[] args) {
        Reconstruct obj = new Reconstruct();

        int[] preOrder = {5,3,1,4,8,11};
        int[] inOrder = {1,3,4,5,8,11};

        TreeNode root = obj.reconstruct(inOrder, preOrder);
        Tree.print(root);
    }
}
