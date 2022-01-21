package Class2.LinkedList;

public class Palindrome {

    public boolean isPalindrome(ListNode head) {
        // corner case
        if (head == null || head.next == null) {
            return true;
        }

        // find the middle node
        ListNode mid = findMiddle(head);
        ListNode right = reverse(mid.next);

        // compare two lists
        while (right != null) {
            if (head.value != right.value) {
                return false;
            }
            head = head.next;
            right = right.next;
        }

        return true;

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

    public static void main(String[] args) {
        Palindrome solution = new Palindrome();
        int[] array = {1,2,3,4,4,3,2,1};
        ListNode head = ListNode.createList(array);
        head.printList();
        boolean result = solution.isPalindrome(head);
        System.out.println(result);
    }
}
