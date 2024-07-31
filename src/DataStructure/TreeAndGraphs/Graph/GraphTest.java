package DataStructure.TreeAndGraphs.Graph;

public class GraphTest {
    public static void main(String[] args) {
        Graph g = new Graph(9);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);

        /*
            0
           /
          1 -- 3    7
          |  / | \ /
          | /  |  5
          2 -- 4   \
                    6 -- 8
         */

//        g.dfs(); // 0 1 3 5 7 6 8 4 2
//        g.bfs(); // 0 1 2 3 4 5 6 7 8
//        g.dfsR(); // 0 1 2 4 3 5 6 8 7
        g.dfs(3); // 3 5 7 6 8 4 2 1 0
//        g.bfs(3); // 3 1 2 4 5 0 6 7 8
//        g.dfsR(3); // 3 1 0 2 4 5 6 8 7

        // 주의!
        // 메소드 여러개를 한번에 실행하면 노드들의 marked가 true로 변하기 때문에
        // 메소드 한개씩 실행할 것!
    }
}
