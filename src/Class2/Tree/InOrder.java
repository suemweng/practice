package Class2.Tree;
import java.util.*;
public class InOrder {

    // 第二次visit时直接pop； 为了省却判断visit次数，不在parent level压栈，manually指引往下方向
    // 第一次visit时才压栈，可以确保在栈里取点时已经是第二次visit
    // top element --> 直接pop，manually visit右节点

    public List<Integer> inOrderIterate(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        // corner case
        if (root == null) {
            return list;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;  // cur is unknown node
        // keep going to far left, if null, go right one step
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = stack.pollFirst();
                list.add(cur.key);
                cur = cur.right;
            }
        }
        return list;

    }


    public List<Integer> inOrderIterate2(TreeNode root) {
        // Write your solution here
        List<Integer> list = new ArrayList<>();
        // corner case
        if (root == null) {
            return list;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur.left != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                list.add(cur.key);
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur = stack.pollFirst();
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        InOrder solution = new InOrder();
        Integer[] array = {10,5,15,2,7,12,20};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        List<Integer> list = solution.inOrderIterate2(root);
        System.out.println(list);

    }
}

// TC O(n)
// SC O(height) -- stack size