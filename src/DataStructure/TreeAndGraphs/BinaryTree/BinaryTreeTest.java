package DataStructure.TreeAndGraphs.BinaryTree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        int[] a = new int[10];
        for(int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        BinaryTree t = new BinaryTree();
        t.makeTree(a);
        t.searchBTree(t.root, 2);
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
