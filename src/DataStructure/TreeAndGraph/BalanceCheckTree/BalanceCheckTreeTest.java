package DataStructure.TreeAndGraph.BalanceCheckTree;

public class BalanceCheckTreeTest {
    public static void main(String[] args) {
        BalanceCheckTree t = new BalanceCheckTree(10);
        System.out.println(t.isBalanced(t.root));
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
