package searching.tree;

public class Node {
    public Node left;
    public Node right;
    public int value;
    public String name;

    public Node(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                '}';
    }
}
