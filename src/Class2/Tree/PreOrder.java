/*
5 ( 2 (1 3) 8 (9) ) ]
 */

package Class2.Tree;

import java.util.*;

public class PreOrder {
    // 第一次visit时直接pop； top element --> 直接pop，压栈左右节点
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // corner case
        if (root == null) {
            return list;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            list.add(cur.key);
            if (cur.right != null) {
                stack.offerFirst(cur.right);  // stack in right node first, so it will be pop out later
            }
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
        }
        return list;

    }

    public static void main(String[] args) {
        PreOrder solution = new PreOrder();
        Integer[] array = {10,5,15,2,7,12,20};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        List<Integer> list = solution.preOrder(root);
        System.out.println(list);

    }
}

// TC O(n)
// SP O(height) -- all the root.right in our stack