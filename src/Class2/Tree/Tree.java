package Class2.Tree;

import java.util.LinkedList;
import java.util.List;

public class Tree {

    public static TreeNode constructTree(Integer[] array) {
        // corner case
        if (array == null || array.length == 0) {
            return null;
        }

        return constructTree(array, 0);

    }

    private static TreeNode constructTree(Integer[] array, int index) {
        // base case
        if (index >= array.length || array[index] == null) {
            return null;
        }

        TreeNode newNode = new TreeNode(array[index]);
        newNode.left = constructTree(array, index * 2 + 1);
        newNode.right = constructTree(array, index * 2 + 2);

        return newNode;
    }

    public static List<Integer> destructTree(TreeNode root) {
        List<Integer> keyList = new LinkedList<>();
        List<TreeNode> treeList = new LinkedList<>();
        // corner case
        if (root == null) {
            return keyList;
        }

        keyList.add(root.key);
        treeList.add(root);
        int index = 0;

        while(index < treeList.size()) {
            TreeNode curNode = treeList.get(index);
            if (curNode.left != null) {
                keyList.add(curNode.left.key);
                treeList.add(curNode.left);
            } else {
                keyList.add(null);
            }

            if (curNode.right != null) {
                keyList.add(curNode.right.key);
                treeList.add(curNode.right);
            } else {
                keyList.add(null);
            }
            index++;
        }

        // Trim the bottom level of null, return subList
        return keyList.subList(0, keyList.lastIndexOf(treeList.get(--index).key) + 1);
    }
}
