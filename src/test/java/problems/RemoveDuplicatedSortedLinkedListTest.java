package problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RemoveDuplicatedSortedLinkedListTest {

    RemoveDuplicatedSortedLinkedList underTest = new RemoveDuplicatedSortedLinkedList();

    @Test
    void deleteDuplicatesTestSingleDuplicate() {
        RemoveDuplicatedSortedLinkedList.ListNode nodeThree = new RemoveDuplicatedSortedLinkedList.ListNode(2);
        RemoveDuplicatedSortedLinkedList.ListNode nodeTwo = new RemoveDuplicatedSortedLinkedList.ListNode(1, nodeThree);
        RemoveDuplicatedSortedLinkedList.ListNode headNode = new RemoveDuplicatedSortedLinkedList.ListNode(1, nodeTwo);

        RemoveDuplicatedSortedLinkedList.ListNode result = underTest.deleteDuplicates(headNode);

        assertEquals(result, headNode);
        assertEquals(result.next, nodeThree);
    }

    @Test
    void deleteDuplicatesTestMultipleDuplicates() {
        RemoveDuplicatedSortedLinkedList.ListNode nodeFive = new RemoveDuplicatedSortedLinkedList.ListNode(3);
        RemoveDuplicatedSortedLinkedList.ListNode nodeFour = new RemoveDuplicatedSortedLinkedList.ListNode(3, nodeFive);
        RemoveDuplicatedSortedLinkedList.ListNode nodeThree = new RemoveDuplicatedSortedLinkedList.ListNode(2, nodeFour);
        RemoveDuplicatedSortedLinkedList.ListNode nodeTwo = new RemoveDuplicatedSortedLinkedList.ListNode(1, nodeThree);
        RemoveDuplicatedSortedLinkedList.ListNode headNode = new RemoveDuplicatedSortedLinkedList.ListNode(1, nodeTwo);

        RemoveDuplicatedSortedLinkedList.ListNode result = underTest.deleteDuplicates(headNode);

        assertEquals(result, headNode);
        assertEquals(result.next, nodeThree);
        assertEquals(nodeThree.next, nodeFour);
        assertNull(nodeFour.next);
    }

    @Test
    void deleteDuplicatesTestThreeDuplicates() {
        RemoveDuplicatedSortedLinkedList.ListNode nodeThree = new RemoveDuplicatedSortedLinkedList.ListNode(1);
        RemoveDuplicatedSortedLinkedList.ListNode nodeTwo = new RemoveDuplicatedSortedLinkedList.ListNode(1, nodeThree);
        RemoveDuplicatedSortedLinkedList.ListNode headNode = new RemoveDuplicatedSortedLinkedList.ListNode(1, nodeTwo);

        RemoveDuplicatedSortedLinkedList.ListNode result = underTest.deleteDuplicates(headNode);

        assertEquals(result, headNode);
        assertNull(result.next);
    }
}