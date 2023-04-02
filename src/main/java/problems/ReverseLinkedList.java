package problems;

import javaApi.ListNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {

    public LinkedList<Integer> reverse(LinkedList<Integer> input) {

        int size = input.size();
        Integer last;
        for (int i = 0; i < size; i++) {
            last = input.removeLast();
            input.add(i, last);
        }

        return input;
    }

    public ListNode reverseFromHead(ListNode input) {
        ListNode previousVisited = null;
        ListNode current = input;
        ListNode nextToVisit;

        while (current != null) {
            nextToVisit = current.next;
            current.next = previousVisited;
            previousVisited = current;
            current = nextToVisit;
        }

        return previousVisited;
    }


    public ListNode reverseFromHeadViaStack(ListNode input) {
        Stack<ListNode> stack = new Stack<>();

        ListNode temp = input;
        while (temp.next != null) {
            //Push all to stack
            stack.add(temp);
            temp = temp.next;
        }
        stack.add(temp);

        ListNode next;
        ListNode head = stack.pop();
        ListNode current = head;
        while (!stack.isEmpty()) {
            // Pop stack, setting each node to the next in the stack
            next = stack.peek();
            current.next = next;
            current = stack.pop();
        }

        //Set new tail's next value as null
        current.next = null;

        return head;
    }
}
