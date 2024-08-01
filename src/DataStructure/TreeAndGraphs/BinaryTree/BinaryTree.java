package DataStructure.TreeAndGraphs.BinaryTree;

// 정렬이 되어있고, 고유한 정수로만 이루어진 배열이 있다.
// 이 배열로 이진검색트리를 구현하시오.
public class BinaryTree {
    public Node root;

    public void makeTree(int[] a) {
        this.root = makeTreeR(a, 0, a.length - 1);
    }

    public Node makeTreeR(int[] a, int start, int end) {
        if(start > end)
            return null;
        int mid = (start + end) / 2;
        Node node = new Node(a[mid]);
        node.left = makeTreeR(a, start, mid - 1);
        node.right = makeTreeR(a, mid + 1, end);
        return node;
    }

    public void searchBTree(Node node, int find) {
        if(find < node.data) {
            System.out.println("Data is smaller than " + node.data);
            searchBTree(node.left, find);
        } else if(find > node.data) {
            System.out.println("Data is bigger than " + node.data);
            searchBTree(node.right, find);
        } else {
            System.out.println("Data found!");
        }
    }
}
