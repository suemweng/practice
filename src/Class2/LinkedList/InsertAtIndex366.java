/*
Q 366. Linked List Insert At Index

Insert a new element at a specific index in the given linked list. The index is 0 based, and if the index is out of the list's scope, you do not need to do anything.

Examples:

1 -> 2 -> 3 -> null, insert 4 at index 3, --> 1 -> 2 -> 3 -> 4 -> null

1 -> 2 -> null, insert 4 at index 0, --> 4 -> 1 -> 2 -> null

test case:
[[339,120,11,35,85,314,150,204,114,17,177,440,176,198,43,266,247,1,429,28,279,180,2,427,100,199,401,287,136,464,336,277,171,360,425,73,151,72,255,189,497,293,148,40,57,149,174,24,246,428,199,46,277,277,139,491,192,177,218,397,495,452,368,276,24,218,425,112,261,43,374,87,173,144,406,383,213,45,18,449,197,371,408,346],83,485]
 */

package Class2.LinkedList;

public class InsertAtIndex366 {

    public ListNode insert(ListNode head, int index, int value) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;

        // stop: index == 0 || head == null
        while (index > 0 && head != null) {
            pre = head;
            head = head.next;
            index--;
        }

        if (index == 0) {
            ListNode newNode = new ListNode(value);
            newNode.next = head;
            pre.next = newNode;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        InsertAtIndex366 solution = new InsertAtIndex366();
        int[] array = {1,2};
        int index = 3;
        int value = 4;
        ListNode list = ListNode.createList(array);
        list = solution.insert(list, index, value);
        list.printList();

    }
}
