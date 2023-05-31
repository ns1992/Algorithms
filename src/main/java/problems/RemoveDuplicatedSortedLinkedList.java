package problems;

import java.util.Objects;

public class RemoveDuplicatedSortedLinkedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode currentNode = head;

        // Get current node's value
        // if same as next, then skip node
        // Otherwise proceed to the next node
        while (currentNode != null && currentNode.next != null) {
            if (currentNode.val == currentNode.next.val) {
                // Skip ahead a node
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }


    protected static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }
}
