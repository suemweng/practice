package Class2.Tree;

import java.util.*;

public class BFS1 {
    // Data structure: FIFO queue
    // Algorithm: BFS1
    // Initialization: queue = {root}

    public void printNodesByLevel(TreeNode root){
        // corner case
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int size = 1;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            size--;
            System.out.print(cur.key + ", ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }

            if (size == 0) {
                System.out.println();
                size = queue.size();  // # of nodes in the current layer before print this level

            }
        }
    }


    public static void main(String[] args) {
        BFS1 solution = new BFS1();
        Integer[] array = {1,3,2,5,4,7,null,9,11};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        solution.printNodesByLevel(root);


    }
}


