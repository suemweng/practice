/**
 * Laicode 133. Merge K Sorted Array
 *
 * Merge K sorted array into one big sorted array in ascending order.
 *
 * Assumptions
 *
 * The input arrayOfArrays is not null, none of the arrays is null either.
 */

package Class2.BFS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArray {

    public int[] merge(int[][] arrayOfArrays) {
        // Key insight
        // heap with element(value, x, y)

        class Entry{
            int x;
            int y;
            int value;

            public Entry(int x, int y, int value) {
                this.x = x;
                this.y = y;
                this.value = value;
            }
        }

        PriorityQueue<Entry> minHeap = new PriorityQueue<>(new Comparator<Entry>(){
            @Override
            public int compare(Entry e1, Entry e2) {
                return Integer.compare(e1.value, e2.value);
            }
        });

        int arrLen = 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            arrLen += arrayOfArrays[i].length;
            if (arrayOfArrays[i].length > 0) {
                minHeap.offer(new Entry(i, 0, arrayOfArrays[i][0]));
            }
        }

        int[] result = new int[arrLen];
        int i = 0;
        while (!minHeap.isEmpty()) {
            Entry cur = minHeap.poll();
            result[i++] = cur.value;
            if (cur.y + 1 < arrayOfArrays[cur.x].length) {
                cur.y++;
                cur.value = arrayOfArrays[cur.x][cur.y];
                minHeap.offer(cur);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MergeKSortedArray obj = new MergeKSortedArray();

        int[][] array = {{3}, {1,2,3,4,5}};
        int[] result = obj.merge(array);
        System.out.println(Arrays.toString(result));
    }
}
