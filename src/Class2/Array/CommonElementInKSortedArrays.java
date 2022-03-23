/**
 * Laicode 644. Common Elements In K Sorted Lists
 *
 * Find all common elements in K sorted lists.
 *
 *
 * Assumptions
 * The input and its elements are not null, and support fast random access.
 * There could be duplicate elements in each of the lists.
 *
 *
 * Examples
 * Input = {{1, 2, 2, 3}, {2, 2, 3, 5}, {2, 2, 4}}, the common elements are {2, 2}.
 */

package Class2.Array;

import Class2.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonElementInKSortedArrays {

    public List<Integer> commonElementsInKSortedArrays(List<List<Integer>> input) {

        // TC: O(n * k)
        // SC: O(n)

        List<Integer> result = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            result = helper(result, input.get(i));
        }
        return result;
    }

    private List<Integer> helper(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();

        int ai = 0;
        int bi = 0;

        while (ai < a.size() && bi < b.size()) {
            if (a.get(ai) == b.get(bi)) {
                result.add(a.get(ai));
                ai++;
                bi++;
            } else if (a.get(ai) < b.get(bi)) {
                ai++;
            } else {
                bi++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        CommonElementInKSortedArrays obj = new CommonElementInKSortedArrays();

        Integer[] array1 = new Integer[]{1,2,2,3};
        Integer[] array2 = new Integer[]{2,2,3,5};
        Integer[] array3 = new Integer[]{2,2,4};

        List<Integer> list1 = Arrays.asList(array1);
        List<Integer> list2 = Arrays.asList(array2);
        List<Integer> list3 = Arrays.asList(array3);
        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(list1);
        listOfLists.add(list2);
        listOfLists.add(list3);


        List<Integer> newList = obj.commonElementsInKSortedArrays(listOfLists);
        System.out.println(newList);
    }


}
