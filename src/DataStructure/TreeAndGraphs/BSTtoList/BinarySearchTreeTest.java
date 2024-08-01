package DataStructure.TreeAndGraphs.BSTtoList;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree(10);
        t.printList(t.BSTtoList2());
        /*
                4
               / \
             1     7
            / \    / \
           0   2  5   8
                \  \   \
                 3  6   9
         */
    }
}
