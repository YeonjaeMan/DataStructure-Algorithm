package DataStructure.TreeAndGraphs.CheckBST;

public class CheckBSTTest {
    public static void main(String[] args) {
        CheckBST t = new CheckBST(10);
        System.out.println("Solution 1 - using inorder : " + t.isValidateBST1());
    }
}
