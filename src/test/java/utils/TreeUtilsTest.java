package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import searching.tree.Node;
import searching.tree.NodeSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<Node> expectedTraversalOrder;
        final ArrayList<Node> actualTraverseOrder = new ArrayList<>();

        // Root
        actualTraverseOrder.clear();
        expectedTraversalOrder = Arrays.asList(root);
        assertEquals(root, TreeUtils.preOrderDepthFirstSearch(root, 0, actualTraverseOrder::add));
        assertEquals(expectedTraversalOrder, actualTraverseOrder);

        // Left Tree - Left most node
        actualTraverseOrder.clear();
        expectedTraversalOrder = Arrays.asList(root, node1, node1a);
        assertEquals(node1a, TreeUtils.preOrderDepthFirstSearch(root, 5, actualTraverseOrder::add));
        assertEquals(expectedTraversalOrder, actualTraverseOrder);

        // Left Tree a right child
        actualTraverseOrder.clear();
        expectedTraversalOrder = Arrays.asList(root, node1, node1a, node1b);
        assertEquals(node1b, TreeUtils.preOrderDepthFirstSearch(root, 6, actualTraverseOrder::add));
        assertEquals(expectedTraversalOrder, actualTraverseOrder);

        // Right Tree - Right most node
        actualTraverseOrder.clear();
        expectedTraversalOrder = Arrays.asList(root, node1, node1a, node1b, node2, node2a, node2b);
        assertEquals(node2b, TreeUtils.preOrderDepthFirstSearch(root, 19, actualTraverseOrder::add));
        assertEquals(expectedTraversalOrder, actualTraverseOrder);

        // Right Tree - a left child
        actualTraverseOrder.clear();
        expectedTraversalOrder = Arrays.asList(root, node1, node1a, node1b, node2, node2a);
        assertEquals(node2a, TreeUtils.preOrderDepthFirstSearch(root, 8, actualTraverseOrder::add));
        assertEquals(expectedTraversalOrder, actualTraverseOrder);
    }

    @Test
    public void testInOrderDepthFirstSearch() {
        List<Node> expectedTraversalOrder;
        final ArrayList<Node> actualTraverseOrder = new ArrayList<>();

        // Root
        actualTraverseOrder.clear();
        expectedTraversalOrder = Arrays.asList(node1a, node1, node1b, root);
        assertEquals(root, TreeUtils.inorderDepthFirstSearch(root, 0, actualTraverseOrder::add));
        assertEquals(expectedTraversalOrder, actualTraverseOrder);

        // Left Tree - Left most node
        actualTraverseOrder.clear();
        expectedTraversalOrder = Arrays.asList(node1a);
        assertEquals(node1a, TreeUtils.inorderDepthFirstSearch(root, 5, actualTraverseOrder::add));
        assertEquals(expectedTraversalOrder, actualTraverseOrder);

        // Left Tree a right child
        actualTraverseOrder.clear();
        expectedTraversalOrder = Arrays.asList(node1a, node1, node1b);
        assertEquals(node1b, TreeUtils.inorderDepthFirstSearch(root, 6, actualTraverseOrder::add));
        assertEquals(expectedTraversalOrder, actualTraverseOrder);

        // Right Tree - Right most node
        actualTraverseOrder.clear();
        expectedTraversalOrder = Arrays.asList(node1a, node1, node1b, root, node2a, node2, node2b);
        assertEquals(node2b, TreeUtils.inorderDepthFirstSearch(root, 19, actualTraverseOrder::add));
        assertEquals(expectedTraversalOrder, actualTraverseOrder);

        // Right Tree - a left child
        actualTraverseOrder.clear();
        expectedTraversalOrder = Arrays.asList(node1a, node1, node1b, root, node2a);
        assertEquals(node2a, TreeUtils.inorderDepthFirstSearch(root, 8, actualTraverseOrder::add));
        assertEquals(expectedTraversalOrder, actualTraverseOrder);
    }


    @Test
    public void testPostOrderDepthFirstSearch() {
        List<Node> expectedTraversalOrder;
        final ArrayList<Node> actualTraverseOrder = new ArrayList<>();

        // Root
        actualTraverseOrder.clear();
        expectedTraversalOrder = Arrays.asList(node1a, node1b, node1, node2a, node2b, node2, root);
        assertEquals(root, TreeUtils.postOrderDepthFirstSearch(root, 0, actualTraverseOrder::add));
        assertEquals(expectedTraversalOrder, actualTraverseOrder);

        // Left Tree - Left most node
        actualTraverseOrder.clear();
        expectedTraversalOrder = Arrays.asList(node1a);
        assertEquals(node1a, TreeUtils.postOrderDepthFirstSearch(root, 5, actualTraverseOrder::add));
        assertEquals(expectedTraversalOrder, actualTraverseOrder);

        // Left Tree a right child
        actualTraverseOrder.clear();
        expectedTraversalOrder = Arrays.asList(node1a, node1b);
        assertEquals(node1b, TreeUtils.postOrderDepthFirstSearch(root, 6, actualTraverseOrder::add));
        assertEquals(expectedTraversalOrder, actualTraverseOrder);

        // Right Tree - Right most node
        actualTraverseOrder.clear();
        expectedTraversalOrder = Arrays.asList(node1a, node1b, node1, node2a, node2b);
        assertEquals(node2b, TreeUtils.postOrderDepthFirstSearch(root, 19, actualTraverseOrder::add));
        assertEquals(expectedTraversalOrder, actualTraverseOrder);

        // Right Tree - a left child
        actualTraverseOrder.clear();
        expectedTraversalOrder = Arrays.asList(node1a, node1b, node1, node2a);
        assertEquals(node2a, TreeUtils.postOrderDepthFirstSearch(root, 8, actualTraverseOrder::add));
        assertEquals(expectedTraversalOrder, actualTraverseOrder);
    }


    @Test
    public void testRecursiveInOrderDepthFirstSearch()  {
        List<Node> expectedTraversalOrder;
        NodeSequence actualTraverseOrder;

        // Root
        expectedTraversalOrder = Arrays.asList(node1a, node1, node1b, root);
        actualTraverseOrder = TreeUtils.dfs(root, 0, TraversalType.INORDER);
        assertEquals(expectedTraversalOrder, actualTraverseOrder.getTraverseSequence());
        assertEquals(root, actualTraverseOrder.getTargetNode().get());

        // Left Tree - Left most node
        expectedTraversalOrder = Arrays.asList(node1a);
        actualTraverseOrder = TreeUtils.dfs(root, 5, TraversalType.INORDER);
        assertEquals(expectedTraversalOrder, actualTraverseOrder.getTraverseSequence());
        assertEquals(node1a, actualTraverseOrder.getTargetNode().get());

        // Left Tree a right child
        expectedTraversalOrder = Arrays.asList(node1a, node1, node1b);
        actualTraverseOrder = TreeUtils.dfs(root, 6, TraversalType.INORDER);
        assertEquals(expectedTraversalOrder, actualTraverseOrder.getTraverseSequence());
        assertEquals(node1b, actualTraverseOrder.getTargetNode().get());

        // Right Tree - Right most node
        expectedTraversalOrder = Arrays.asList(node1a, node1, node1b, root, node2a, node2, node2b);
        actualTraverseOrder = TreeUtils.dfs(root, 19, TraversalType.INORDER);
        assertEquals(expectedTraversalOrder, actualTraverseOrder.getTraverseSequence());
        assertEquals(node2b, actualTraverseOrder.getTargetNode().get());

        // Right Tree - a left child
        expectedTraversalOrder = Arrays.asList(node1a, node1, node1b, root, node2a);
        actualTraverseOrder = TreeUtils.dfs(root, 8, TraversalType.INORDER);
        assertEquals(expectedTraversalOrder, actualTraverseOrder.getTraverseSequence());
        assertEquals(node2a, actualTraverseOrder.getTargetNode().get());
    }

    @Test
    public void testRecursivePreOrderDepthFirstSearch() {
        List<Node> expectedTraversalOrder;
        NodeSequence actualTraverseOrder;

        // Root
        expectedTraversalOrder = Arrays.asList(root);
        actualTraverseOrder = TreeUtils.dfs(root, 0, TraversalType.PREORDER);
        assertEquals(expectedTraversalOrder, actualTraverseOrder.getTraverseSequence());
        assertEquals(root, actualTraverseOrder.getTargetNode().get());

        // Left Tree - Left most node
        expectedTraversalOrder = Arrays.asList(root, node1, node1a);
        actualTraverseOrder = TreeUtils.dfs(root, 5, TraversalType.PREORDER);
        assertEquals(expectedTraversalOrder, actualTraverseOrder.getTraverseSequence());
        assertEquals(node1a, actualTraverseOrder.getTargetNode().get());

        // Left Tree a right child
        expectedTraversalOrder = Arrays.asList(root, node1, node1a, node1b);
        actualTraverseOrder = TreeUtils.dfs(root, 6, TraversalType.PREORDER);
        assertEquals(expectedTraversalOrder, actualTraverseOrder.getTraverseSequence());
        assertEquals(node1b, actualTraverseOrder.getTargetNode().get());

        // Right Tree - Right most node
        expectedTraversalOrder = Arrays.asList(root, node1, node1a, node1b, node2, node2a, node2b);
        actualTraverseOrder = TreeUtils.dfs(root, 19, TraversalType.PREORDER);
        assertEquals(expectedTraversalOrder, actualTraverseOrder.getTraverseSequence());
        assertEquals(node2b, actualTraverseOrder.getTargetNode().get());

        // Right Tree - a left child
        expectedTraversalOrder = Arrays.asList(root, node1, node1a, node1b, node2, node2a);
        actualTraverseOrder = TreeUtils.dfs(root, 8, TraversalType. PREORDER);
        assertEquals(expectedTraversalOrder, actualTraverseOrder.getTraverseSequence());
        assertEquals(node2a, actualTraverseOrder.getTargetNode().get());
    }

    @Test
    public void testRecursivePostOrderDepthFirstSearch() {
        List<Node> expectedTraversalOrder;
        NodeSequence actualTraverseOrder;

        // Root
        expectedTraversalOrder = Arrays.asList(node1a, node1b, node1, node2a, node2b, node2, root);
        actualTraverseOrder = TreeUtils.dfs(root, 0, TraversalType.POSTORDER);
        assertEquals(expectedTraversalOrder, actualTraverseOrder.getTraverseSequence());
        assertEquals(root, actualTraverseOrder.getTargetNode().get());

        // Left Tree - Left most node
        expectedTraversalOrder = Arrays.asList(node1a);
        actualTraverseOrder = TreeUtils.dfs(root, 5, TraversalType.POSTORDER);
        assertEquals(expectedTraversalOrder, actualTraverseOrder.getTraverseSequence());
        assertEquals(node1a, actualTraverseOrder.getTargetNode().get());

        // Left Tree a right child
        expectedTraversalOrder = Arrays.asList(node1a, node1b);
        actualTraverseOrder = TreeUtils.dfs(root, 6, TraversalType.POSTORDER);
        assertEquals(expectedTraversalOrder, actualTraverseOrder.getTraverseSequence());
        assertEquals(node1b, actualTraverseOrder.getTargetNode().get());

        // Right Tree - Right most node
        expectedTraversalOrder = Arrays.asList(node1a, node1b, node1, node2a, node2b);
        actualTraverseOrder = TreeUtils.dfs(root, 19, TraversalType.POSTORDER);
        assertEquals(expectedTraversalOrder, actualTraverseOrder.getTraverseSequence());
        assertEquals(node2b, actualTraverseOrder.getTargetNode().get());

        // Right Tree - a left child
        expectedTraversalOrder = Arrays.asList(node1a, node1b, node1, node2a);
        actualTraverseOrder = TreeUtils.dfs(root, 8, TraversalType. POSTORDER);
        assertEquals(expectedTraversalOrder, actualTraverseOrder.getTraverseSequence());
        assertEquals(node2a, actualTraverseOrder.getTargetNode().get());
    }
}