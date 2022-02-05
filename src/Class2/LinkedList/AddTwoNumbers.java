/**
 * Laicode 223. Add Two Numbers
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * Example
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *
 * Output: 7 -> 0 -> 8
 */

package Class2.LinkedList;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode one, ListNode two) {
        // corner case
        if (one == null) {
            return two;
        }

        if (two == null) {
            return one;
        }

        // reverse two linked lists
        one = reverse(one);
        two = reverse(two);

        // add two lists
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        int val = 0;

        while (one != null || two != null || val != 0) {

            if (one != null) {
                val += one.value;
                one = one.next;
            }

            if (two != null) {
                val += two.value;
                two = two.next;
            }

            cur.next = new ListNode(val % 10);
            val = val / 10;
            cur = cur.next;
        }

        // reverse the final list
        return reverse(dummyHead.next);
    }

    private ListNode reverse(ListNode head) {
        // corner case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();
        int[] array1 = {1,3,4,2};
        ListNode one = ListNode.createList(array1);
        int[] array2 = {4,6,5};
        ListNode two = ListNode.createList(array2);
        one.printList();
        two.printList();
        ListNode result = solution.addTwoNumbers(one, two);
        result.printList();
    }
}

// TC: O(max(m, n))
// SC: O(1)