package DataStructure.TreeAndGraph.FindCommonParent;

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

        Node fa3 = t.commonAncestor3(5, 8); // = 7
        System.out.println("The first common ancestor is " + fa3.data);

        Node fa4 = t.commonAncestor4(2, 8); // = 4
        System.out.println("The first common ancestor is " + fa4.data);

        Node fa5 = t.commonAncestor5(0, 3); // = 1
        System.out.println("The first common ancestor is " + fa5.data);
    }
}
