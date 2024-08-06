package DataStructure.TreeAndGraphs.FindCommonParent;

public class Test {
    public static void main(String[] args) {
        Tree t = new Tree(10);
        /*
                4
               / \
             1     7
            / \    / \
           0   2  5   8
                \  \   \
                 3  6   9
         */
        Node fa1 = t.commonAncestor1(3, 5); // = 4
        System.out.println("The first common ancestor is " + fa1.data);

        Node fa2 = t.commonAncestor2(6, 9); // = 7
        System.out.println("The first common ancestor is " + fa2.data);
    }
}
