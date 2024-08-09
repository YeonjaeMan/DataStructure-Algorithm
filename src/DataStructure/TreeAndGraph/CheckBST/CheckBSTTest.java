package DataStructure.TreeAndGraph.CheckBST;

public class CheckBSTTest {
    public static void main(String[] args) {
        CheckBST t = new CheckBST(10);
        /*
                4
               / \
             1     7
            / \    / \
           0   2  5   8
                \  \   \
                 3  6   9
         */
        System.out.println("Solution 1 - using inorder : " + t.isValidateBST1());
        System.out.println("Solution 2 - without array : " + t.isValidateBST2());
        System.out.println("Solution 3 - min/max : " + t.isValidateBST3());
    }
}
