/**
 * Laicode 131. Deep Copy Linked List With Random Pointer
 *
 * Each of the nodes in the linked list has another pointer pointing to a random node in the list or null. Make a deep copy of the original list.
 */

package Class2.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyLinkedListRandom {

    // Key insight:
    // Map<original node, copied node>

    public RandomListNode copy(RandomListNode head) {
        // Write your solution here.
        if (head == null) {
            return null;
        }
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode pre = dummy;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (head != null) {
            if (!map.containsKey(head)) {
                map.put(head, new RandomListNode(head.value));
            }
            pre.next = map.get(head);

            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.value));
                }
                pre.next.random = map.get(head.random);
            }
            pre = pre.next;
            head = head.next;
        }
        return dummy.next;
    }

    class RandomListNode {
        public int value;
        public RandomListNode next;
        public RandomListNode random;
        public RandomListNode(int value) {
          this.value = value;
        }
   }

}
