/**
 * Final Exam
 *
 * Q4. Infinite Loop Around the Dinner Table
 *
 *
 *
 * After the event, our company will take the students out for dinner. The restaurant has a large round table that can fit the whole party. We want to know if we can arrange the students so that the names of all students around the table form an “infinite loop.” For each pair of neighboring students s1 and s2, the last letter of s1’s name must be identical to the first letter of s2’s name.
 *
 *
 *
 * For example, “ALICE” and “ERIC” can sit together, but “ALICE” and “BOB” cannot.
 *
 * Given an array of names, determine if it is possible to arrange the students at the round table in this way.
 *
 * Input: an array of names. Each name contains capital letters only.
 *
 * Output: true or false.
 *
 *
 *
 * Example
 *
 * Input: String[] = {“ALICE”, “CHARLES”, “ERIC”, “SOPHIA”}
 *
 * Output: true
 */

package Class2.DFS;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NameChains {

    public boolean foundLoop(String[] names){

        // corner case
        if (names == null || names.length == 0){
            return false;
        }

        return dfs(1, names);

    }

    private boolean dfs(int index, String[] names) {

        // base case
        if (index == names.length) {
            return canSit(names[index - 1], names[0]);
        }


        // branches
        for (int i = index; i < names.length; i++) {
            if (canSit(names[index - 1], names[i])) {
                swap(names, index, i);
                if (dfs(index + 1, names)) {
                    return true;
                }
                swap(names, index, i);
            }
        }

        return false;
    }

    private void swap(String[] names, int i, int j) {
        String temp = names[i];
        names[i] = names[j];
        names[j] = temp;
    }

    private boolean canSit(String first, String second) {
        return first.charAt(first.length() - 1) == second.charAt(0);
    }


    public static void main(String[] args) {
        NameChains obj = new NameChains();

        String[] names = {"ALICE","CHARLES","ERIC","SOPHIA"};
        System.out.println(obj.foundLoop(names));

    }
}
