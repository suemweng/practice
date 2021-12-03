package Class1Beginner.BinarySeach;

public class Closest {
    public static int findClosest(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }


        int left = 0;
        int right = arr.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
         }

        if (Math.abs(arr[left] - target) <= Math.abs(arr[right] - target)) {
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,3,3,4};
        int target = 2;
        int index = findClosest(array, target);
        System.out.println(index);
    }
}
