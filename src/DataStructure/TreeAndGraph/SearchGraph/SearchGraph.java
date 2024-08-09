package DataStructure.TreeAndGraph.SearchGraph;

import java.util.LinkedList;

// Graph에서 두개의 노드가 서로 찾아갈 수 있는 경로가 있는지 확인하는 함수를 구현하시오.
public class SearchGraph {
    public Node[] nodes;

    public SearchGraph(int size) {
        nodes = new Node[size];
        for(int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    public void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if(!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    public void initMarks() {
        for(Node n : nodes) {
            n.marked = false;
        }
    }

    public boolean search(int i1, int i2) {
        return search(nodes[i1], nodes[i2]);
    }

    // Queue BFS 이용
    public boolean search(Node start, Node end) {
        initMarks();
        LinkedList<Node> q = new LinkedList<>();
        q.add(start);
        start.marked = true;
        while(!q.isEmpty()) {
            Node root = q.removeFirst();
            if(root == end) {
                return true;
            }
            for(Node n : root.adjacent) {
                if(!n.marked) {
                    q.add(n);
                    n.marked = true;
                }
            }
        }
        return false;
    }
}
