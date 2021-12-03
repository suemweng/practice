import java.util.Arrays;

public class SmallestKth {

    public static int[] binarySearch(int[] a, int[] b, int k) {
        int i = 0;
        int j = 0;
        int left = k;


        while (left > 1) {
            int imid = i+left / 2-1;
            int jmid = j+left/ 2-1;
            if (a[imid] <= b[jmid]) {
                i = imid + 1;
            } else {
                j = jmid + 1;
            }
            left = k - i - j;
        }

        if(a[i]<=b[j]){
            i=i+1;
        } else {
            j=j+1;
        }

        return new int[] {i,j};
    }

    public static void main (String[] args){
        int[] a = {2,2,3,10,13};
        int[] b = {1,3,4,13,20,29};
        int k = 6;
        int[] list = binarySearch(a,b,k);
        System.out.println(Arrays.toString(list));

    }
}
