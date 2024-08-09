package DataStructure.TreeAndGraph.CheckSubTree;

public class Test {
    public static void main(String[] args) {
        Tree t1 = new Tree();
        Tree t2 = new Tree();
        boolean result;

        t1.root = t1.makeBST(0, 9);
        t2.root = t2.makeBST(5, 9);
        result = t1.containsTree(t1.root, t2.root);
        System.out.println(result);

        t2.root = t2.makeBST(7, 9);
        result = t1.containsTree(t1.root, t2.root);
        System.out.println(result);
    }
}
