package DataStructure.TreeAndGraph.FindCommonParent;

public class Result {
    public Node node;
    public boolean isAncestor;

    public Result(Node n, boolean isAnc) {
        this.node = n;
        this.isAncestor = isAnc;
    }
}
