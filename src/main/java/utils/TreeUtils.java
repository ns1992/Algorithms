package utils;


import searching.tree.Node;
import searching.tree.NodeSequence;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.function.Consumer;
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
            // Search left
            if (postorderRecursive(currentNode.left, traversalPredicate, nodeSequence).getTargetNode().isPresent())
                return nodeSequence;

            // Search right
            if (postorderRecursive(currentNode.right, traversalPredicate, nodeSequence).getTargetNode().isPresent())
                return nodeSequence;

            // Search current
            nodeSequence.addTraversedNode(currentNode);
            if (traversalPredicate.test(currentNode)) {
                nodeSequence.setTargetNode(currentNode);
                return nodeSequence;
            }
        }

        return nodeSequence;
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
        Node current;
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


    public static Node findTree(final Node root, final int toFind) {
        if(root != null) {
            if(root.value == toFind) {
                return root;
            }

            // Search left side
            if(root.left != null) {
                final Node tree = findTree(root.left, toFind);
                if(null != tree) {
                    return tree;
                }
            }

            // Search right side
            if(root.right != null) {
                final Node tree = findTree(root.right, toFind);
                if(null != tree) {
                    return tree;
                }
            }
        }

        // not found
        return null;
    }


    /**
     * Checks if two Binary Trees are equal
     * Note: Takes into consideration the node positions in the tree, not just the values
     * E.g. 1, null, 3  !=  1, 3
     *
     * @param rootOne First tree
     * @param rootTwo Tree to compare against
     * @return true if equal
     */
    public static boolean sameTree(final Node rootOne, final Node rootTwo) {
        final ArrayDeque<Optional<Node>> firstNodes = new ArrayDeque<>();
        final ArrayDeque<Optional<Node>> secondNodes = new ArrayDeque<>();


        firstNodes.add(Optional.ofNullable(rootOne));
        secondNodes.add(Optional.ofNullable(rootTwo));
        while (!firstNodes.isEmpty() && !secondNodes.isEmpty()) {
            final Optional<Node> optionalFirst = firstNodes.removeFirst();
            final Optional<Node> optionalSecond = secondNodes.removeFirst();


            // If both are null, check the next set of nodes
            if(optionalFirst.isEmpty() && optionalSecond.isEmpty()) continue;

            // If one is null, it's a mismatch
            if(optionalFirst.isEmpty() || optionalSecond.isEmpty()) {
                return false;
            }

            // Else check the values
            final Node currentFirst = optionalFirst.get();
            final Node currentSecond = optionalSecond.get();

            if (currentFirst.value != currentSecond.value) {
                return false;
            }

            firstNodes.add(Optional.ofNullable(currentFirst.left));
            firstNodes.add(Optional.ofNullable(currentFirst.right));

            secondNodes.add(Optional.ofNullable(currentSecond.left));
            secondNodes.add(Optional.ofNullable(currentSecond.right));
        }

        return firstNodes.isEmpty() && secondNodes.isEmpty();
    }

    public static long sum(final Node root) {
        if(root != null) {
            return root.value + sum(root.right) + sum(root.left);
        }

        return 0;
    }


    public static long average(final Node root) {
        final ArrayDeque<Node> arrayDeque = new ArrayDeque<>();

        int count = 0;
        double sum = 0;
        arrayDeque.addFirst(root);
        while (!arrayDeque.isEmpty()) {
            final Node current = arrayDeque.removeFirst();
            sum += current.value;
            count++;

            if(null != current.left) arrayDeque.add(current.left);
            if(null != current.right) arrayDeque.add(current.right);
        }

        return count > 0 ? Math.round(sum/count) : count;
    }
}
