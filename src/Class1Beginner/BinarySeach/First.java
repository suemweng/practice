package Class1Beginner.BinarySeach;

public class First {
    public static int findFirst(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                right = mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (arr[left] == target ) {
            return left;
        } else {
            return -1;
        }
    }

    public static void main(String[] args){
        int[] array = {1,2};
        int target = 0;
        int index = findFirst(array,target);
        System.out.println(index);
    }
}
