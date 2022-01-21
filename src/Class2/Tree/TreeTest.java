package Class2.Tree;

import java.util.*;

public class TreeTest {


    public static void main(String[] args) {

        Integer[] array = {7,3,16,2,5,11,18,1,null,4,6,null,12,null,20,null,null,null,null,null,5};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        List<Integer> list = Tree.destructTree(root);
        System.out.println(list);
    }
}
