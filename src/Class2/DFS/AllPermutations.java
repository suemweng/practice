package Class2.DFS;

import java.util.*;

public class AllPermutations {
    // swap - swap
    public List<String> permutations(String input) {
        List<String> list = new ArrayList<>();

        if (input == null) {
            return list;
        }

        if (input == "") {
            list.add("");
            return list;
        }

        char[] ch = input.toCharArray();
        System.out.println(Arrays.toString(ch));
        permutations(ch, list, 0);
        return list;
    }

    private void permutations(char[] ch, List<String> list, int index) {
        if (index == ch.length - 1) {
            list.add(new String(ch));
            return;
        }

        for (int i = index; i < ch.length; i++) {
            swap(ch, index, i);
            permutations(ch, list, index + 1);
            swap(ch, index, i);   // remember to swap back when back track to previous level
        }
    }

    private void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public static void main(String[] args){
        AllPermutations solution = new AllPermutations();
        String input = "";
        List<String> result = solution.permutations(input);
        System.out.println(result);
    }
}

// TC O(n!)
// SC O(n)