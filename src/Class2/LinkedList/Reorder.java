/*
N1 --> N2 --> N3 --> N4 --> N5 --> N6 --> ... --> Nn --> null
convert to
(N1 --> Nn) --> (N2 --> Nn-1) --> N3 --> Nn-2
 */

package Class2.LinkedList;

public class Reorder {

    public ListNode reorder(ListNode head) {
        // corner case
        if (head == null || head.next == null) {
            return head;
        }

        // find Middle
        ListNode mid = findMiddle(head);
        ListNode one = head;
        ListNode two = mid.next;

        // reverse second half
        mid.next = null;
        two = reverse(two);


        // merge
        return merge(one, two);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        // base case
        if (head.next == null) {
            return head;
        }
        ListNode subHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return subHead;
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;

        while(one != null && two != null) {
            cur.next = one;
            one = one.next;
            cur.next.next = two;
            two = two.next;
            cur = cur.next.next;
        }

        if (one != null) {
            cur.next = one;
        } else {
            cur.next = two;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Reorder solution = new Reorder();
        int[] array = {1,2,3,4,5,6,7};
        ListNode head = ListNode.createList(array);
        head.printList();
        head = solution.reorder(head);
        head.printList();
    }
}
