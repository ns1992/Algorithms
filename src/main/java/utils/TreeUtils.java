package utils;


import searching.tree.Node;
import searching.tree.NodeSequence;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class TreeUtils {

    private static NodeSequence inorderRecursive(final Node currentNode,
                                                 final Predicate<Node> traversalPredicate,
                                                 final NodeSequence nodeSequence) {
        if (currentNode != null) {
            // Search left
            if (inorderRecursive(currentNode.left, traversalPredicate, nodeSequence).getTargetNode().isPresent())
                return nodeSequence;

            // Search current node
            nodeSequence.addTraversedNode(currentNode);
            if (traversalPredicate.test(currentNode)) {
                nodeSequence.setTargetNode(currentNode);
                return nodeSequence;
            }

            // Search right
            if (inorderRecursive(currentNode.right, traversalPredicate, nodeSequence).getTargetNode().isPresent())
                return nodeSequence;
        }

        return nodeSequence; // Predicate not satiated
    }


    private static NodeSequence preorderRecursive(final Node currentNode,
                                                  final Predicate<Node> traversalPredicate,
                                                  final NodeSequence nodeSequence) {
        if (null != currentNode) {
            // Search current node
            nodeSequence.addTraversedNode(currentNode);
            if (traversalPredicate.test(currentNode)) {
                nodeSequence.setTargetNode(currentNode);
                return nodeSequence;
            }

            // Search left
            if (preorderRecursive(currentNode.left, traversalPredicate, nodeSequence).getTargetNode().isPresent())
                return nodeSequence;

            // Search right
            if (preorderRecursive(currentNode.right, traversalPredicate, nodeSequence).getTargetNode().isPresent())
                return nodeSequence;
        }

        return nodeSequence; // Predicate not satiated
    }


    private static NodeSequence postorderRecursive(final Node currentNode,
                                                   final Predicate<Node> traversalPredicate,
                                                   final NodeSequence nodeSequence) {
        if (null != currentNode) {
            // Search Left
            if (postorderRecursive(currentNode.left, traversalPredicate, nodeSequence).getTargetNode().isPresent())
                return nodeSequence;

            // Search Right
            if (postorderRecursive(currentNode.right, traversalPredicate, nodeSequence).getTargetNode().isPresent())
                return nodeSequence;

            //Search current node
            nodeSequence.addTraversedNode(currentNode);
            if (traversalPredicate.test(currentNode)) {
                nodeSequence.setTargetNode(currentNode);
                return nodeSequence;
            }
        }

        return nodeSequence; // Predicate not satiated
    }


    public static NodeSequence dfs(final Node currentNode,
                                   final int toFind,
                                   final TraversalType traversalType) {
        final NodeSequence nodeSequence = new NodeSequence();
        switch (traversalType) {
            case PREORDER -> {
                return preorderRecursive(currentNode, node -> TreeUtils.isSoughtNode(node, toFind), nodeSequence);
            }
            case INORDER -> {
                return inorderRecursive(currentNode, node -> TreeUtils.isSoughtNode(node, toFind), nodeSequence);
            }
            case POSTORDER -> {
                return postorderRecursive(currentNode, node -> TreeUtils.isSoughtNode(node, toFind), nodeSequence);
            }
            default -> throw new IllegalArgumentException("Hit default with " + traversalType.name());
        }
    }

    private static boolean isSoughtNode(final Node node, final int value) {
        return node.value == value;
    }


    /**
     * In preorder traversal, we traverse the root first, then the left and finally the right subtrees.
     * <p>
     * Method:-
     * Push root in our stack
     * While stack is not empty
     * Pop current node
     * Visit current node
     * Push right child, then left child to stack
     *
     * @param root          node to start searching
     * @param toFind        value to search for
     * @param traverseOrder Consumer on traversal
     * @return First Node containing the value if found, else null
     */
    public static Node preOrderDepthFirstSearch(final Node root, final int toFind, final Consumer<Node> traverseOrder) {
        Node currentNode;
        final ArrayDeque<Node> stack = new ArrayDeque<>();

        stack.addFirst(root);
        while (!stack.isEmpty()) {
            // Visit
            currentNode = stack.pop();
            traverseOrder.accept(currentNode);
            if (currentNode.value == toFind) {

                return currentNode;
            }

            if (currentNode.right != null) stack.push(currentNode.right);
            if (currentNode.left != null) stack.push(currentNode.left);
        }

        return null; //Not found
    }

    /**
     * For inorder traversal, we traverse the left subtree first, then the root, then finally the right subtree.
     * <p>
     * Method:-
     * Push root node to stack
     * While stack is not empty
     * Keep pushing left child onto stack, till we reach current node's left-most child
     * Visit current node
     * Push right child onto stack
     *
     * @param root          node to start searching
     * @param toFind        value to search for
     * @param traverseOrder Consumer on traversal
     * @return First Node containing the value if found, else null
     */
    public static Node inorderDepthFirstSearch(final Node root, final int toFind, final Consumer<Node> traverseOrder) {
        Node currentNode = root;
        final ArrayDeque<Node> stack = new ArrayDeque<>();

        stack.addFirst(currentNode);
        while (!stack.isEmpty()) {
            // Keep pushing until leftmost child reached
            while (currentNode.left != null) {
                currentNode = currentNode.left;
                stack.push(currentNode);
            }

            // Visit
            currentNode = stack.pop();
            traverseOrder.accept(currentNode);
            if (currentNode.value == toFind) {
                return currentNode;
            }

            // Explore right subtree
            if (currentNode.right != null) {
                currentNode = currentNode.right;
                stack.push(currentNode);
            }
        }

        return null; //Not found
    }


    /**
     * For postorder traversal, we traverse the left subtree first, then the right, then finally the root.
     * <p>
     * Method:-
     * Push root node in stack
     * While stack is not empty
     * Check if we already traversed left and right subtree
     * If not then push right child and left child onto stack
     *
     * @param root          node to start searching
     * @param toFind        value to search for
     * @param traverseOrder Consumer on traversal
     * @return First Node containing the value if found, else null
     */
    public static Node postOrderDepthFirstSearch(final Node root, final int toFind, final Consumer<Node> traverseOrder) {
        final ArrayDeque<Node> stack = new ArrayDeque<>();
        Node previouslyVisited = root;
        Node current = root;
        stack.push(root);

        while (!stack.isEmpty()) {
            //Check if we already traversed left and right subtree
            current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPrevLastChild = (previouslyVisited == current.right ||
                    (previouslyVisited == current.left && current.right == null));

            // If we have, visit this node
            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
                traverseOrder.accept(current);
                if (current.value == toFind) {
                    return current;
                }
                previouslyVisited = current;
            } else {
                //If not then push right child and left child onto stack
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }

        return null; // Not found
    }
}
