package searching.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NodeSequence {
    private Node targetNode;
    private List<Node> traverseSequence = new ArrayList<>();

    public Optional<Node> getTargetNode() {
        return Optional.ofNullable(targetNode);
    }

    public void setTargetNode(final Node targetNode) {
        this.targetNode = targetNode;
    }

    public List<Node> getTraverseSequence() {
        return traverseSequence;
    }

    public void addTraversedNode(final Node traversed) {
        traverseSequence.add(traversed);
    }
}
