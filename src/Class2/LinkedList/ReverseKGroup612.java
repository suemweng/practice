/*
Q 241. Reverse Nodes in k-Group 25

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is. You may not alter the values in the nodes, only nodes itself may be changed.

Example

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

 */

package Class2.LinkedList;

public class ReverseKGroup612 {

    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your solution here
        // base case
        if (head == null) return head;
        ListNode cur = head;
        for(int i = 0; i < k - 1; i++) {
            cur = cur.next;
            if (cur == null) return head;
        }

        ListNode subHead = reverseKGroup(cur.next, k);
        ListNode newHead = reverse(head, k);
        head.next = subHead;
        return newHead;
    }

    private ListNode reverse(ListNode head, int k) {

        ListNode pre = null;

        for (int i = 1; i <= k; i++) {
            ListNode nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        int k = 5;
        ListNode head = ListNode.createList(array);
        // testing ListNode methods
        System.out.println("length = " + head.length());
        System.out.println("Get node: " + head.get(6).value);

        head = head.appendHead(0);
        System.out.println("length = " + head.length());
        System.out.println("Get node: " + head.get(0).value);

        head.appendTail(9);
        System.out.println("length = " + head.length());
        System.out.println("Get node: " + head.get(9).value);


        // continue with question 241
        ReverseKGroup612 solution = new ReverseKGroup612();
        ListNode newHead = solution.reverseKGroup(head,k);
        newHead.printList();
    }
}
