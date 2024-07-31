package DataStructure.TreeAndGraphs.Graph;

import DataStructure.StackAndQueue.Queue.Queue;

import java.util.Stack;

// DFS, BFS를 구현하시오.
public class Graph {
    public Node[] nodes;

    public Graph(int size) {
        this.nodes = new Node[size];
        for(int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    // 두 정점의 간선을 연결해주는 메소드
    public void addEdge(int i1, int i2) {
        if(!nodes[i1].adjacent.contains(nodes[i2])) {
            nodes[i1].adjacent.add(nodes[i2]);
        }
        if(!nodes[i2].adjacent.contains(nodes[i1])) {
            nodes[i2].adjacent.add(nodes[i1]);
        }
    }

    public void dfs() {
        dfs(0);
    }

    // Stack을 이용한 DFS 구현
    public void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;
        while(!stack.isEmpty()) {
            Node r = stack.pop();
            for(Node n : r.adjacent) {
                if(!n.marked) {
                    stack.push(n);
                    n.marked = true;
                }
            }
            visit(r);
        }
    }

    public void bfs() {
        bfs(0);
    }

    // Queue를 이용한 BFS 구현
    public void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new Queue<>();
        queue.add(root);
        root.marked = true;
        while(!queue.isEmpty()) {
            Node r = queue.remove();
            for(Node n : r.adjacent) {
                if(!n.marked) {
                    queue.add(n);
                    n.marked = true;
                }
            }
            visit(r);
        }
    }

    // 재귀 호출을 이용한 DFS 구현
    public void dfsR(Node r) {
        if(r == null) return;
        r.marked = true;
        visit(r);
        for(Node n : r.adjacent) {
            if(!n.marked) {
                dfsR(n);
            }
        }
    }

    public void dfsR(int index) {
        Node r = nodes[index];
        dfsR(r);
    }

    public void dfsR() {
        dfsR(0);
    }

    // 방문했을 때 출력해주는 메소드
    public void visit(Node node) {
        System.out.print(node.data + " ");
    }
}
