/* Q 38. Cycle Node In Linked List  -- Leetcode 142

    Check if a given linked list has a cycle. Return the node where the cycle starts. Return null if there is no cycle.

 */
package Class1Beginner.LinkedList;

public class Cycle38 {
    public ListNode cycleNode(ListNode head) {
        // write your solution here
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;


        while (true) {
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }


        //System.out.println("Slow:" + slow.value);

        // f = 2s && f = s + nb ( b - Cycle length) ==> s = nb && f = 2nb
        // steps to cycle starting points k = a + nb (a - head to cycle starting point), so k  = a + s; s will reach cycle starting point after a steps

        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] array = {12,2,6,9,3,1,22,5,222,-1,33,66};
        ListNode list = ListNode.createList(array);
        ListNode one = list;
        for(int i = 0; i < 5; i++) {
            one = one.next;
        }
        System.out.println(one.value);
        ListNode two = one;
        while (two.next != null) {
            two = two.next;
        }
        System.out.println(two.value);
        two.next = one;
        System.out.println(two.next.value);
        Cycle38 solution = new Cycle38();
        ListNode found = solution.cycleNode(list);
        System.out.println(found.value);
    }
}
