package Class2.Tree;

import java.util.*;

public class TreeTest {


    public static void main(String[] args) {

        Integer[] array = {11,1,null,null,-1,null,null,null,null,-9,10};
        TreeNode root = Tree.constructTree(array);
        Tree.print(root);
        List<Integer> list = Tree.destructTree(root);
        System.out.println(list);
    }
}
