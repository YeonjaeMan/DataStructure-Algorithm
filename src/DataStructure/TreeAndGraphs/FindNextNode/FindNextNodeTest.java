package DataStructure.TreeAndGraphs.FindNextNode;

public class FindNextNodeTest {
    public static void main(String[] args) {
        FindNextNode t = new FindNextNode(10);
        /*
                4
               / \
             1     7
            / \    / \
           0   2  5   8
                \  \   \
                 3  6   9
         */
        t.findNext(t.root.left.right.right); // 3
        t.findNext(t.root.left); // 1
        t.findNext(t.root);// 4
        t.findNext(t.root.left.left); // 0
        t.findNext(t.root.right.left.right); // 6
    }
}
