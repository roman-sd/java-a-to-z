package ru.sdroman.menu;

/**
 * Class Node.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class Node implements Action, Output {

    /**
     * Default capacity.
     */
    private static final int DEFAULT_CAPACITY = 3;

    /**
     * Number of dashes.
     */
    private static int dash = 0;

    /**
     * Nodes array.
     */
    private Node[] nodes;

    /**
     * Name.
     */
    private String name;

    /**
     * Key.
     */
    private String key;

    /**
     * Position in the array.
     */
    private int position = 0;

    /**
     * Constructs the new Node object.
     *
     * @param key  String
     * @param name String
     */
    public Node(String key, String name) {
        nodes = new Node[DEFAULT_CAPACITY];
        this.name = name;
        this.key = key;
    }

    /**
     * Gets node array.
     *
     * @return Node[]
     */
    public Node[] getNodes() {
        return nodes;
    }

    /**
     * Array growth.
     */
    private void grow() {
        Node[] temp = new Node[this.position + 1];
        System.arraycopy(this.nodes, 0, temp, 0, this.position);
        this.nodes = temp;
    }

    /**
     * Adds node in the array.
     *
     * @param node Node
     */
    public void add(Node node) {
        if (this.position == this.nodes.length) {
            grow();
        }
        this.nodes[this.position++] = node;
    }

    /**
     * Execute.
     *
     * @param key String
     */
    @Override
    public void execute(String key) {
        System.out.println("execute ");
    }

    /**
     * Prints nodes.
     */
    @Override
    public void printNode() {
        dash++;
        System.out.println(dashBuilder());
        for (Node node : this.nodes) {
            if (node != null) {
                node.printNode();
            }
        }
        dash--;
    }

    /**
     * Builds nodes to print.
     *
     * @return String
     */
    private String dashBuilder() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < dash - 1; i++) {
            builder.append("--");
        }
        builder.append(this.key).append(".").append(this.name);
        return builder.toString();
    }
}
