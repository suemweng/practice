/**
 * Laicode 58. Get Keys In Binary Tree Layer By Layer Zig-Zag Order
 *
 * Get the list of keys in a given binary tree layer by layer in zig-zag order.
 *
 * Examples
 *
 *         5
 *
 *       /    \
 *
 *     3        8
 *
 *   /   \        \
 *
 *  1     4        11
 *
 * the result is [5, 3, 8, 11, 4, 1]
 *
 * Corner Cases
 *
 * What if the binary tree is null? Return an empty list in this case.
 */

package Class2.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ZigZagLayerByLayer {

    // Key insight:
    // use deque to poll from different direction
    // when polling from the back, need to push right child first

    public List<Integer> zigZag(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        // corner case
        if (root == null) {
            return result;
        }

        Deque<TreeNode> QDeque = new ArrayDeque<>();
        QDeque.offer(root);
        int level = 0;

        while (!QDeque.isEmpty()) {

            int size = QDeque.size();

            for (int i = 0; i < size; i++) {
                if (level == 1) {
                    TreeNode cur = QDeque.pollFirst();
                    result.add(cur.key);

                    if (cur.left != null) {
                        QDeque.offerLast(cur.left);
                    }

                    if (cur.right != null) {
                        QDeque.offerLast(cur.right);
                    }
                } else {
                    TreeNode cur = QDeque.pollLast();
                    result.add(cur.key);

                    if (cur.right != null) {
                        QDeque.offerFirst(cur.right);
                    }

                    if (cur.left != null) {
                        QDeque.offerFirst(cur.left);
                    }

                }
            }
            level = 1 - level;
        }
        return result;
    }

    public static void main(String[] args) {
        ZigZagLayerByLayer obj = new ZigZagLayerByLayer();

        Integer[] array = {5,3,8,1,4,null,11};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        System.out.println(obj.zigZag(root));

    }
}
