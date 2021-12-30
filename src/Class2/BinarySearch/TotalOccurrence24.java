package Class2.BinarySearch;

public class TotalOccurrence24 {
    public int totalOccurrence(int[] array, int target) {
        if (array == null || array.length == 0) return 0;

        int left = firstOccurrence(array, target);
        if (left == -1) return 0;
        int right = lastOccurrence(array,target);

        return right - left + 1;
}

    private int firstOccurrence(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) right = mid;
            else if (array[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        if (array[left] == target) return left;
        if (array[right] == target) return right;
        return -1;
    }

    private int lastOccurrence(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) left = mid;
            else if (array[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        if (array[right] == target) return right;
        else return left;                               // because we know the firstOccurrence != -1;

    }

    public static void main(String[] args) {
        int[] array = {1,2,2,2,3};
        int target = 2;
        TotalOccurrence24 solution = new TotalOccurrence24();
        int total = solution.totalOccurrence(array, target);
        System.out.println(total);
    }
}
