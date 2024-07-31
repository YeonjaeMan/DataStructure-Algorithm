package DataStructure.TreeAndGraphs.Tree;

public class TreeTest {
    public static void main(String[] args) {
        /* Tree
                (1)
            (2)     (3)
         (4)   (5)
        */
        Tree t = new Tree();

        Node n5 = t.makeNode(null, 5, null);
        Node n4 = t.makeNode(null, 4, null);
        Node n2 = t.makeNode(n4, 2, n5);
        Node n3 = t.makeNode(null, 3, null);
        Node n1 = t.makeNode(n2, 1, n3);

        t.setRoot(n1);

        // Inorder (Left, Root, Right)
        t.inorder(t.getRoot()); // 4 2 5 1 3
        // Preorder (Root, Left, Right)
        t.preorder(t.getRoot()); // 1 2 4 5 3
        // Postorder (Left, Right, Root)
        t.postorder(t.getRoot()); // 4 5 2 3 1
    }
}
