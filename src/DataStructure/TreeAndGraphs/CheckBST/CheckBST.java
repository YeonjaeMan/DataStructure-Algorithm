package DataStructure.TreeAndGraphs.CheckBST;

// 주어진 트리가 이진검색트리인지를 확인하는 함수를 구현하시오.
public class CheckBST {
    public Node root;
    public int size;
    public int index;

    public CheckBST(int size) {
        this.size = size;
        root = makeBST(0, size - 1);
    }

    public Node makeBST(int start, int end) {
        if(start > end)
            return null;
        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeBST(start, mid - 1);
        node.right = makeBST(mid + 1, end);
        return node;
    }

    public boolean isValidateBST1() {
        int[] array = new int[size];
        inorder(root, array);
        for(int i = 1; i < array.length; i++) {
            if(array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public void inorder(Node root, int[] array) {
        if(root != null) {
            inorder(root.left, array);
            array[index] = root.data;
            index++;
            inorder(root.right, array);
        }
    }
}
