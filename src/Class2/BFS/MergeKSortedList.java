/**
 * Laicode 134. Merge K Sorted Lists
 *
 * Merge K sorted lists into one big sorted list in ascending order.
 *
 * Assumptions
 *
 * ListOfLists is not null, and none of the lists is null.
 *
 */

package Class2.BFS;


import Class2.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {

    public ListNode merge(List<ListNode> listOfLists) {

        // Key insight:
        // push node reference in PQ, disconnect when polling

        // TC: O(n * logk)
        // SC: O(logk)

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return Integer.compare(n1.value, n2.value);
            }
        });

        for (ListNode node : listOfLists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode cur = minHeap.poll();
            if (cur.next != null) {
                minHeap.offer(cur.next);
            }
            tail.next = cur;
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedList obj = new MergeKSortedList();

        int[] array1 = new int[]{1,3,7};
        int[] array2 = new int[]{2,4,8};
        int[] array3 = new int[]{5,6,9};

        ListNode list1 = ListNode.createList(array1);
        ListNode list2 = ListNode.createList(array2);
        ListNode list3 = ListNode.createList(array3);
        List<ListNode> listOfLists = new ArrayList<>();
        listOfLists.add(list1);
        listOfLists.add(list2);
        listOfLists.add(list3);

        ListNode newList = obj.merge(listOfLists);
        newList.printList();
    }
}
