package Class2.Tree;

import java.util.*;

public class PostOrder {
    // 第三次visit时pop； top element --> 根据之前的走向（pre和cur的关系），判断是第几次visit，从而决定走向，进行压栈
    // check the relation between the current node and previous node
    // to determin which direction should go next
    public void postOrder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        // corner case
        if (root == null) {
            return;
        }

        stack.offerFirst(root);
        TreeNode pre = root;
        TreeNode cur = root.left; // top element of stack
        while (!stack.isEmpty() || cur != null) {
            if (cur == null) {
                pre = cur;
                cur = stack.peek();
            } else {
                if (pre != null && (pre.left == cur || pre.right == cur)) {
                    stack.offerFirst(cur);
                    pre = cur;
                    cur = cur.left;
                } else if (cur.left == pre) {
                    pre = cur;
                    cur = cur.right;
                } else { // cur.right == pre
                    stack.pollFirst();
                    System.out.println(cur.key);
                    pre = cur;
                    cur = stack.peek();
                }
            }
        }

    }

    public static void main(String[] args) {
        PostOrder solution = new PostOrder();
        Integer[] array = {5,2,8,1,2};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        solution.postOrder(root);
        //List<Integer> list = solution.postOrder(root);
        //System.out.println(list);

    }
}
