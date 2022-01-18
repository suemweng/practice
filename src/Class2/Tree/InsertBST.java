package Class2.Tree;

import java.util.*;
public class InsertBST {
    // Recursion
    // 重点： 下到坑里new node, 回头才往树上挂，每层返回当前根，一路返回一路挂
    public TreeNode insertRecursion(TreeNode root, int target) {
        TreeNode newNode = new TreeNode(target);
        // base case
        if (root == null) {
            return newNode;
        }

        if (root.key < target) {
            root.right = insertRecursion(root.right, target);
        } else if (target < root.key) {
            root.left = insertRecursion(root.left, target);
        }

        return root;
    }


    public TreeNode insertCur(TreeNode root, int target) {
        TreeNode newNode = new TreeNode(target);

        // corner case
        if (root == null) {
            return newNode;
        }
        TreeNode cur = root;
        while(cur.key != target) {
            if (cur.key < target) {
                if (cur.right == null) {
                    cur.right = newNode;
                    break;
                } else {
                    cur = cur.right;
                }
            } else {
                if (cur.left == null) {
                    cur.left = newNode;
                    break;
                } else {
                    cur = cur.left;
                }
            }
        }

        return root;
    }

   public TreeNode insertPre(TreeNode root, int target) {
       TreeNode newNode = new TreeNode(target);

       // corner case
       if (root == null) {
           return newNode;
       }

       TreeNode pre = null;
       TreeNode cur = root;

       while (cur != null) {
           pre = cur;
           if (cur.key == target) {
               return root;
           } else if (cur.key < target) {
               cur = cur.right;
           } else {
               cur = cur.left;
           }
       }

       if (pre.key < target) {
           pre.right = newNode;
       } else if (target < pre.key) {
           pre.left = newNode;
       }

       return root;
    }

    public static void main(String[] args) {
        InsertBST solution = new InsertBST();
        Integer[] array = {10,5,15,null,8,14,16,null,null,6,9};
        TreeNode root = Tree.constructTree(array);
        int target = 17;
        TreeNode result = solution.insertRecursion(root, target);
        List<Integer> list = Tree.destructTree(result);
        System.out.println(list);
    }
}
