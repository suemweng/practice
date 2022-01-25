package Class2.Tree;

import java.util.*;
public class BSTHelper {

    public boolean isBSTHelper(TreeNode root) {
        // corner case
        if (root == null) {
            return true;
        }

        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTHelper(TreeNode root, int min, int max) {
        // base case
        if (root == null) {
            return true;
        }

        if (min >= root.key || root.key >= max) {
            return false;
        }

        return isBSTHelper(root.left, min, root.key) && isBSTHelper(root.right, root.key, max);

    }

    // TC O(n)
    // SC O(height) -- call stack

    // inOrder Iteration algorithm, instead of printing, compare current value with the last value if it's ascending

    public boolean isBSTIterate(TreeNode root) {

        if(root == null) {
            return true;
        }
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        int min = Integer.MIN_VALUE;

        while(cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = stack.pollFirst();
                if (cur.key <= min) {
                    return false;
                } else {
                    min = cur.key;
                }
                cur = cur.right;
            }
        }
        return true;
    }

    // TC O(n)
    // SC O(height) -- our stack on heap

    public static void main(String[] args) {
        BSTHelper solution = new BSTHelper();
        Integer[] array = {10,5,15,2,7,12,20};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        boolean result = solution.isBSTIterate(root);
        System.out.println(result);

    }
}
