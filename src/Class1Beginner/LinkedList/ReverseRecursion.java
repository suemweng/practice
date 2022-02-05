/**
 * Reverse a singly linked list recursively
 */

package Class1Beginner.LinkedList;

public class ReverseRecursion {
    // Recursion
    public static ListNode reverseRecursion(ListNode head) {
        // be careful about the base case
        // need to make sure the later head.next != null

        // base case
        if (head == null || head.next == null) return head;

        // sub-problem
        ListNode subHead = reverseRecursion(head.next);

        // recursive rule
        head.next.next = head;
        head.next = null;
        return subHead;
    }


    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4};
        ListNode list = ListNode.createList(array);
        ListNode newList = reverseRecursion(list);
        newList.printList();
    }
}

// TC: O(n)
// SC: O(n)