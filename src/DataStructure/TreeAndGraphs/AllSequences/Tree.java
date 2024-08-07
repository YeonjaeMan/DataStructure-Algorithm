package DataStructure.TreeAndGraphs.AllSequences;

public class Tree {
    public Node root;

    public Tree(int size) {
        this.root = makeBST(0, size - 1);
    }

    public Node makeBST(int start, int end) {
        if(start > end)
            return null;
        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeBST(start, mid - 1);
        node.right = makeBST(mid + 1, end);
        return node;
    }
}
