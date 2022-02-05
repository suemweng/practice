package Class2.Tree;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

public class LayerByLayer {

    public List<List<Integer>> layerByLayer(TreeNode root) {

        List<List<Integer>> treeList = new ArrayList<>();

        // corner case
        if (root == null) {     // mistake: missed corner case check
            return treeList;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {                                      // using two loops to realize 2D traverse
            // the list storing all the nodes on the current level
            List<Integer> curLayer = new ArrayList<>();
            // the size of current level
            int size = queue.size();

            // traverse all the nodes on the current level
            // and prepare for the next level
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                curLayer.add(cur.key);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            treeList.add(curLayer);
        }

        return treeList;
    }

    public static void main(String[] args) {
        LayerByLayer obj = new LayerByLayer();

        Integer[] array = {5,3,8,1,4,null, 11};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        List<List<Integer>> treeList = obj.layerByLayer(root);
        System.out.println(treeList);
    }
}

// TC: O(n)
// SC: O(n)
