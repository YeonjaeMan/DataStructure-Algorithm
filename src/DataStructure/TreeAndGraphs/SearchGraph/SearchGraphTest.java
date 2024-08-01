package DataStructure.TreeAndGraphs.SearchGraph;

public class SearchGraphTest {
    public static void main(String[] args) {
        SearchGraph g = new SearchGraph(9);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
//        g.addEdge(1, 3);
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
          1    3    7
          |  / | \ /
          | /  |  5
          2 -- 4   \
                    6 -- 8
        */

        System.out.println(g.search(1, 8));
    }
}
