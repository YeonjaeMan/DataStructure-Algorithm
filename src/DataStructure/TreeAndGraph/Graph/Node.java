package DataStructure.TreeAndGraph.Graph;

import java.util.LinkedList;

public class Node {
    public int data;
    public boolean marked;
    public LinkedList<Node> adjacent;

    public Node(int data) {
        this.data = data;
        this.marked = false;
        this.adjacent = new LinkedList<Node>();
    }
}
