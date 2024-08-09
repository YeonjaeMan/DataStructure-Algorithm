package DataStructure.TreeAndGraph.BinarySearchTree;

public class Test {
    public static void main(String[] args) {
        Tree t = new Tree();

        t.insert(4);
        t.insert(2);
        t.insert(1);
        t.insert(3);
        t.insert(6);
        t.insert(5);
        t.insert(7);
        t.inorder();

        t.delete(5);
        t.delete(6);
        t.delete(2);
        t.inorder();
    }
}
