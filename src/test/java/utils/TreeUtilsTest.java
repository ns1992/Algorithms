package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import searching.tree.Node;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeUtilsTest {

    private Node root;
    private Node node1;
    private Node node2;
    private Node node1a;
    private Node node1b;
    private Node node2a;
    private Node node2b;

    @BeforeEach
    public void setup() {
        root = new Node("Root");
        root.value = 0;

        //First level
        node1 = new Node("1");
        node1.value = 1;
        node2 = new Node("2");
        node2.value = 2;

        //Second level
        node1a = new Node("1a");
        node1a.value = 5;
        node1b = new Node("1b");
        node1b.value = 6;
        node2a = new Node("2a");
        node2a.value = 8;
        node2b = new Node("2b");
        node2b.value = 19;

        // Construct
        root.left = node1;
        root.right = node2;

        node1.left = node1a;
        node1.right = node1b;

        node2.left = node2a;
        node2.right = node2b;
    }

    @Test
    public void testPreOrderDepthFirstSearch() {
        assertEquals(node1a, TreeUtils.preOrderDepthFirstSearch(root, 5, System.out::println));
    }

    @Test
    public void testInOrderDepthFirstSearch() {
        // Root
        assertEquals(root, TreeUtils.inorderDepthFirstSearch(root, 0, System.out::println));

        // Left Tree - Left most node
        assertEquals(node1a, TreeUtils.inorderDepthFirstSearch(root, 5, System.out::println));

        // Left Tree a right child
        assertEquals(node1b, TreeUtils.inorderDepthFirstSearch(root, 6, System.out::println));

        // Right Tree - Right most node
        assertEquals(node2b, TreeUtils.inorderDepthFirstSearch(root, 19, System.out::println));

        // Right Tree - a left child
        assertEquals(node2a, TreeUtils.inorderDepthFirstSearch(root, 8, System.out::println));
    }

}