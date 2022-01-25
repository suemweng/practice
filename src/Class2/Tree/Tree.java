package Class2.Tree;


import java.util.*;

public class Tree {
    // read left / right value by pairs
    // queue top points to the parent node of current pair of child nodes in array

    public static TreeNode constructTree(Integer[] array) {

        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        for (int i = 1; i < array.length; i++) {
            TreeNode cur = queue.poll();
            if (array[i] != null) {
                TreeNode left = new TreeNode(array[i]);
                cur.left = left;
                queue.add(left);
            }

            if (array[++i] != null) {
                TreeNode right = new TreeNode(array[i]);
                cur.right = right;
                queue.add(right);
            }
        }
        return root;
    }

    // queue to store valid output node
    // there will be null node, so queue cannot use ArrayDeque
    // reverse order: tree --> queue --> list
    // 只要parent node valid，both child nodes need to be printed
    public static List<Integer> destructTree(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int nullNum = 0;

        while (!queue.isEmpty() && queue.size() != nullNum) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                list.add(cur.key);
                queue.offer(cur.left);
                queue.offer(cur.right);
                if (cur.left == null) {
                    nullNum++;
                }
                if (cur.right == null) {
                    nullNum++;
                }
            } else {
                list.add(null);
                nullNum--;
            }
        }
        return list;
    }


    public static void print(TreeNode root) {
        if (root == null) {
            System.out.println("The root is null. No tree printed");
        }
        print("", root, false);

    }

    public static void print(String prefix, TreeNode n, boolean isLeft) {
        if (n != null) {
            print(prefix + "     ", n.right, false);
            System.out.println(prefix + ("|-- ") + n.key);
            print(prefix + "     ", n.left, true);
        }
    }
}


