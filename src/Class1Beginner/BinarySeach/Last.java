package Class1Beginner.BinarySeach;

public class Last {
    public static int findLast(int[] arr, int target) {
    if (arr == null || arr.length == 0) {
        return -1;
    }

    int left = 0;
    int right = arr.length - 1;
    while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                left = mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
    }
    if (arr[right] == target ) {
        return right;
    } else if (arr[left] == target){
        return left;
    } else {
        return -1;
    }

}

    public static void main(String[] args){
        int[] array = {1,2,2,3};
        int target = 2;
        int index = findLast(array,target);
        System.out.println(index);
    }
}
