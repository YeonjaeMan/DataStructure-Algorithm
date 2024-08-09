package DataStructure.TreeAndGraph.BuildTree;

public class Test {
    public static void main(String[] args) {
        Tree t = new Tree();
        int[] pre = {4,2,1,3,6,5,7};
        int[] in = {1,2,3,4,5,6,7};
        int[] post = {1,3,2,5,7,6,4};
        t.buildTreeByInPre(in, pre);
        t.printInorder(t.root);
        System.out.println(" ");
        t.buildTreeByInPost(in, post);
        t.printInorder(t.root);
    }
}
