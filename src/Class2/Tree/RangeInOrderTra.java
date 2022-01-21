package Class2.Tree;

public class RangeInOrderTra {

    public void rangeInOrderTra(TreeNode root, int lower, int upper) {
        // base case
        if (root == null) {
            return;
        }

        if (lower < root.key){
            rangeInOrderTra(root.left, lower, upper);
        }

        if (lower <= root.key && root.key <= upper) {
            System.out.println(root.key);
        }

        if (root.key < upper) {
            rangeInOrderTra(root.right, lower, upper);
        }

    }

    public static void main(String[] args) {
        RangeInOrderTra solution = new RangeInOrderTra();
        Integer[] array = {10,5,15,2,7,12,20};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        int lower = 5;
        int upper = 12;
        solution.rangeInOrderTra(root, lower, upper);


    }
}
