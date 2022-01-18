package Class2.LinkedList;

public class Cycle {

    public boolean hasCycle(ListNode head) {
        // write your solution here
        // corner cases
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        // stop: fast == null || slow == fast
        while (fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
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
        //two.next = one;
        //System.out.println(two.next.value);
        Cycle solution = new Cycle();
        Boolean found = solution.hasCycle(list);
        System.out.println(found);
    }
}
