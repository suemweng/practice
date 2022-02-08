package Class2.Tree;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }

    public TreeNode constructTree(Integer[] array) {
        // corner case
        if (array == null || array.length == 0) {
            return null;
        }

        return constructTree(array, 0);

    }

    private TreeNode constructTree(Integer[] array, int index) {
        // base case
        if (index >= array.length) {
            return null;
        }

        TreeNode newNode = new TreeNode(array[index]);
        newNode.left = constructTree(array, index * 2 + 1);
        newNode.right = constructTree(array, index * 2 + 2);
        return newNode;

    }


}
