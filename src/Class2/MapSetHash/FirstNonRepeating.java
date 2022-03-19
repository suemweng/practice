/**
 * Laicode 288. First Non-Repeating Character In Stream
 *
 * Given a stream of characters, find the first non-repeating character from stream. You need to tell the first non-repeating character in O(1) time at any moment.
 *
 * Implement two methods of the class:
 *
 * read() - read one character from the stream
 * firstNonRepeating() - return the first non-repoeating character from the stream at any time when calling the method, return null if there does not exist such characters
 * Examples:
 *
 * read:
 *
 * a   b   c   a   c   c    b
 *
 * firstNonRepeating:
 *
 * a   a   a   b   b   b   null
 */

package Class2.MapSetHash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeating {

    // Key insight:
    // use double linked list in map to determine whose is the first
    // use set to save the chars appeared more than twice

    Map<Character, Node> singled;
    Set<Character> repeated;
    Node head;
    Node tail;

    class Node{
        Node prev;
        Node next;
        char ch;

        Node(char ch) {
            this.ch = ch;
        }
    }
    public FirstNonRepeating() {
        // Initialize the class.
        singled = new HashMap<Character, Node>();
        repeated = new HashSet<Character>();
    }

    public void read(char ch) {
        // Implement this method here.
        if (repeated.contains(ch)) {
            return;
        }

        Node node = singled.get(ch);
        if(node == null) {
            node = new Node(ch);
            append(node);
        } else {
            remove(node);
        }

    }

    public Character firstNonRepeating() {
        // Implement this method here.
        if (head == null) {
            return null;
        }
        return head.ch;
    }

    private void remove(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (head == node) {
            head = node.next;
        }

        if (tail == node) {
            tail = node.prev;
        }
        node.prev = null;
        node.next = null;
        singled.remove(node.ch);
        repeated.add(node.ch);
    }

    private void append(Node node) {
        singled.put(node.ch, node);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
    }

    public static void main(String[] args) {
        FirstNonRepeating obj = new FirstNonRepeating();

        char[] array = {'a','b','c','b','a','d','c','d','a','e'};
        char[] array2 = {'a','b','c','a','c','c','b'};
        for (char item : array2) {
            obj.read(item);
            System.out.print(obj.firstNonRepeating());
        }
    }
}
