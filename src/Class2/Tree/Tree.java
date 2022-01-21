package Class2.Tree;


import java.util.*;

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

        treeList.add(root);
        int i = 0;
        int max = 0;  // max is the index of last node that is not null
        TreeNode curNode = null;

        while(i <= max) {
            curNode = treeList.get(i);
            if (curNode == null) {
                treeList.add(null);  // add left child
                treeList.add(null);  // add right child
            } else {
                treeList.add(curNode.left);
                if (curNode.left != null) {
                    max = treeList.size() - 1;
                }
                treeList.add(curNode.right);
                if (curNode.right != null) {
                    max = treeList.size() - 1;
                }
            }
            i++;
        }

        // traverse treeList and copy key to keyList
        for (i = 0; i <= max; i++) {
            curNode = treeList.get(i);
            if (curNode == null) {
                keyList.add(null);
            } else {
                keyList.add(curNode.key);
            }
        }

        return keyList;
    }

    public static void print(TreeNode root) {
        if (root ==  null) {
            System.out.println("The root is null. No tree printed");
        }
        print("", root, false);

    }

    public static void print(String prefix, TreeNode n, boolean isLeft) {
        if (n != null) {
            print(prefix + "     ", n.right, false);
            System.out.println (prefix + ("|-- ") + n.key);
            print(prefix + "     ", n.left, true);
        }
    }
}
