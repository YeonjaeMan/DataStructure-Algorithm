package DataStructure.TreeAndGraphs.CountPath;

public class Test {
    public static void main(String[] args) {
        Tree t = new Tree(10);
        System.out.println(t.countPathsWithSum1(5)); // 4
        System.out.println(t.countPathsWithSum2(3)); // 2
        System.out.println(t.countPathsWithSum3(5)); // 4
    }
}
