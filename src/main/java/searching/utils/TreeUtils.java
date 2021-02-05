package searching.utils;


import searching.tree.Node;

import java.util.ArrayDeque;
import java.util.function.Consumer;

public class TreeUtils {

    /**
     * This uses recursion to traverse the tree but will not easily work for halting on a specific element
     * (for example for a Find operation)
     * @param currentNode the Node to search from
     * @param toFind the value to search for
     * @return the first Node containing the specified value or else null
     */
    public static Node dfs(final Node currentNode, final int toFind) {
        if(currentNode != null) {
            dfs(currentNode.left, toFind);
            if(currentNode.value == toFind) return currentNode;
            dfs(currentNode.right, toFind);
        }

        return null; //Not found
    }


    /**
     * In preorder traversal, we traverse the root first, then the left and right subtrees.
     *
     * Method:-
     * Push root in our stack
     * While stack is not empty
     * Pop current node
     * Visit current node
     * Push right child, then left child to stack
     *
     * @param startNode node to start searching
     * @param toFind value to search for
     * @param logOutput Output for logging
     * @return First Node containing the value if found, else null
     */
    public static Node preOrderDepthFirstSearch(final Node startNode, final int toFind, final Consumer<String> logOutput) {
        Node currentNode;
        final ArrayDeque<Node> stack = new ArrayDeque<>();

        stack.addFirst(startNode);
        while (!stack.isEmpty()) {
            currentNode = stack.pop();
            logOutput.accept("Searching " + currentNode.name);

            if (currentNode.value == toFind) {
                logOutput.accept("Found value and returning");
                return currentNode;
            }

            if (currentNode.right != null) stack.addFirst(currentNode.right);
            if (currentNode.left != null) stack.addFirst(currentNode.left);
        }

        return null; //Not found
    }

    /**
     * For inorder traversal, we traverse the left subtree first, then the root, then finally the right subtree.
     *
     * Method:-
     * Push root node to stack
     * While stack is not empty
     * Keep pushing left child onto stack, till we reach current node's left-most child
     * Visit current node
     * Push right child onto stack
     *
     * @param startNode node to start searching
     * @param toFind value to search for
     * @param logOutput Output for logging
     * @return First Node containing the value if found, else null
     */
    public static Node inorderDepthFirstSearch(final Node startNode, final int toFind, final Consumer<String> logOutput) {
        Node currentNode = startNode;
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
            logOutput.accept("Searching " + currentNode.name);
            if (currentNode.value == toFind) {
                logOutput.accept("Found value and returning");
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
}
