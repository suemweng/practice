/**
 * Laicode 215. Reconstruct Binary Tree With Levelorder And Inorder
 *
 * Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree.
 *
 * Assumptions
 *
 * The given sequences are not null and they have the same length
 * There are no duplicate keys in the binary tree
 * Examples
 *
 * levelorder traversal = {5, 3, 8, 1, 4, 11}
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
 */

package Class2.Recursion;

import Class2.Tree.Tree;
import Class2.Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructBTInLevel {

    // Key insight:
    // store inOrder in a map
    // compare index with root index to determine left or right

    public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {

        Map<Integer, Integer> inMap = new HashMap<>();
        List<Integer> levelList = new ArrayList<>();

        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i], i);
        }

        for (int num : levelOrder) {
            levelList.add(num);
        }
        return helper(inMap, levelList);
    }

    private TreeNode helper(Map<Integer, Integer> inMap, List<Integer> levelList) {
        if (levelList.isEmpty()) {
            return null;
        }

        // important: to remove root from levelList
        TreeNode root = new TreeNode(levelList.remove(0));
        int rootIndex = inMap.get(root.key);

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        for (Integer num : levelList) {
            if (inMap.get(num) < rootIndex) {
                leftList.add(num);
            } else {
                rightList.add(num);
            }
        }
        root.left = helper(inMap, leftList);
        root.right = helper(inMap, rightList);

        return root;

    }

    public static void main(String[] args) {
        ReconstructBTInLevel obj = new ReconstructBTInLevel();

        int[] inOrder = {1, 3, 4, 5, 8, 11};
        int[] levelOrder = {5, 3, 8, 1, 4, 11};

        TreeNode root = obj.reconstruct(inOrder, levelOrder);
        Tree.print(root);
    }
}
