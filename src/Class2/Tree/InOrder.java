package Class2.Tree;
import java.util.*;
public class InOrder {

    public List<Integer> inOrderIterate(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;

        // corner case
        if (root == null) {
            return list;
        }

        // keep going to far left, if null, go right one step
        while (cur != null || !stack.isEmpty()) {
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

    public static void main(String[] args) {
        InOrder solution = new InOrder();
        Integer[] array = {10,5,15,2,7,12,20};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        List<Integer> list = solution.inOrderIterate(root);
        System.out.println(list);

    }
}
