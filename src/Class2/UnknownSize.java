/*
Q10 Search In Unknown Sized Sorted Array

Given a integer dictionary A of unknown size, where the numbers in the dictionary are sorted in ascending order, determine if a given target integer T is in the dictionary. Return the index of T in A, return -1 if T is not in A.

Assumptions

dictionary A is not null
dictionary.get(i) will return null(Java)/INT_MIN(C++)/None(Python) if index i is out of bounds

Examples

A = {1, 2, 5, 9, ......}, T = 5, return 2
A = {1, 2, 5, 9, 12, ......}, T = 7, return -1

 */


import java.util.*;

public class UnknownSize {

    public static int binarySearch(Dictionary dict, int target) {
        if (dict == null) {
            return -1;
        }

        int i = 0;
        int p = 0;

        while (dict.get(p) != null && target > (int) dict.get(p)  ) {
                i++;
                p = (int) Math.pow(2, i);

            }


        int left = (int) Math.pow(2, i - 1);
        int right = (int) Math.pow(2, i);

        while (left <= right) {
            int mid = (left + right) / 2;
            if (dict.get(mid)==null || (int)dict.get(mid)>target) {
                right = mid -1;
            }
             else if ((int)dict.get(mid) == target) {
                return mid;
            } else {
                left = mid+1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        //int[] array = {1,2,5,9,12,15};
        //MyDict dict = new MyDict(array);
        Dictionary<Integer,Integer> dict = new Hashtable<Integer,Integer>();
        dict.put(0,1);
        dict.put(1,2);
        dict.put(2,5);
        dict.put(3,9);
        dict.put(4,12);
        dict.put(5,15);




        int T = 17;
        int i = binarySearch(dict, T);
        System.out.println(i);
    }
}

/*
    class MyDict {
        private int[] original;

        public MyDict(int[] original) {
            this.original = original;
        }

        public Integer get(int index) {
            if(index <= this.original.length-1){
                return this.original[index];
            }else { // out of bound
                return null;
            }
        }
    }

*/



