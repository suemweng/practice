/**
 * Laicode 646. Store Number Of Nodes In Left Subtree
 *
 * Given a binary tree, count the number of nodes in each node’s left subtree, and store it in the numNodesLeft field.
 *
 * Examples
 *
 *                   1(6)
 *                /       \
 *            2(3)        3(0)
 *           /      \
 *       4(1)     5(0)
 *     /    \        \
 * 6(0)     7(0)   8(0)
 * The numNodesLeft is shown in parentheses.
 */

package Class2.Recursion;

public class NumNodesLeft {


    static class TreeNodeLeft {
        public int key;
        public TreeNodeLeft left;
        public TreeNodeLeft right;
        // stores the # of nodes in the left subtree
        public int numNodesLeft;

        public TreeNodeLeft(int key) {
          this.key = key;
        }
    }

    public void numNodesLeft(TreeNodeLeft root) {

        // corner case
        if (root == null) {
            return;
        }

        numNodesLeftHelper(root);
    }

    private int numNodesLeftHelper(TreeNodeLeft root) {
        // base case
        if (root == null) {
            return 0;
        }

        // left is the # of nodes in the subtree of root.left
        // right is the # of nodes in the subtree of root.right
        int leftNum = numNodesLeftHelper(root.left);
        int rightNum = numNodesLeftHelper(root.right);
        root.numNodesLeft = leftNum;

        // return the total number of nodes in the subtree of root
        return leftNum + rightNum + 1;
    }

    public static void main(String[] args) {
        NumNodesLeft obj = new NumNodesLeft();

        TreeNodeLeft node1 = new TreeNodeLeft(1);
        TreeNodeLeft node2 = new TreeNodeLeft(2);
        TreeNodeLeft node3 = new TreeNodeLeft(3);
        TreeNodeLeft node4 = new TreeNodeLeft(4);
        TreeNodeLeft node5 = new TreeNodeLeft(5);
        TreeNodeLeft node6 = new TreeNodeLeft(6);
        TreeNodeLeft node7 = new TreeNodeLeft(7);
        TreeNodeLeft node8 = new TreeNodeLeft(8);
        node1.left = node2;
        node1.right = node2;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node4.right = node7;
        node5.right = node8;

        obj.numNodesLeft(node1);
        System.out.println(node1.numNodesLeft);

    }
}

// TC: O(n)
// SC: O(height)
