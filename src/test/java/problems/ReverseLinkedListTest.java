package problems;

import javaApi.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ReverseLinkedListTest {

    public static final ReverseLinkedList UNDER_TEST = new ReverseLinkedList();


    @Test
    public void testReverses() {
        LinkedList<Integer> input = createFilledList();

        LinkedList<Integer> output = UNDER_TEST.reverse(input);


        LinkedList<Integer> expected = new LinkedList<>(input);
        expected.sort(Comparator.reverseOrder());
        assertEquals(expected, output);
    }

    @Test
    public void testReversesFromHead() {
        ListNode fifth = new ListNode(5);
        ListNode fourth = new ListNode(4, fifth);
        ListNode third = new ListNode(3, fourth);
        ListNode second = new ListNode(2, third);
        ListNode first = new ListNode(1, second);

        ListNode newHead = UNDER_TEST.reverseFromHead(first);

        assertEquals(newHead, fifth);
        assertEquals(4, fifth.next.val);
        assertEquals(3, fourth.next.val);
        assertEquals(2, third.next.val);
        assertEquals(1, second.next.val);
        assertNull(first.next);
    }

    @Test
    public void testReversesFromHeadViaStack() {
        ListNode fifth = new ListNode(5);
        ListNode fourth = new ListNode(4, fifth);
        ListNode third = new ListNode(3, fourth);
        ListNode second = new ListNode(2, third);
        ListNode first = new ListNode(1, second);

        ListNode newHead = UNDER_TEST.reverseFromHeadViaStack(first);

        assertEquals(newHead, fifth);
        assertEquals(4, fifth.next.val);
        assertEquals(3, fourth.next.val);
        assertEquals(2, third.next.val);
        assertEquals(1, second.next.val);
        assertNull(first.next);
    }

    private LinkedList<Integer> createFilledList() {
        LinkedList<Integer> output = new LinkedList<>();

        for(int i = 0; i < 10; i++) {
            output.add(i + 1);
        }

        return output;
    }

}