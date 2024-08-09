package DataStructure.TreeAndGraph.CheckBST;

// 주어진 트리가 이진검색트리인지를 확인하는 함수를 구현하시오.
public class CheckBST {
    public Node root;
    public int size;
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

    // 방법 1. inorder를 변형하여 확인
    public int index = 0;

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

    // 방법 2. 방법 1의 배열 공간 없이 확인
    public Integer last_printed = null;

    public boolean isValidateBST2() {
        return isValidateBST2(root);
    }

    public boolean isValidateBST2(Node n) {
        if(n == null)
            return true;
        if(!isValidateBST2(n.left))
            return false;
        if(last_printed != null && n.data < last_printed) {
            return false;
        }
        last_printed = n.data;
        if(!isValidateBST2(n.right))
            return false;
        return true;
    }

    // 방법 3. 노드의 범위를 변경해서 확인
    public boolean isValidateBST3() {
        return isValidateBST3(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidateBST3(Node n, int min, int max) {
        if(n == null) {
            return true;
        }
        if(n.data < min || n.data > max) {
            return false;
        }
        if(!isValidateBST3(n.left, min, n.data) || !isValidateBST3(n.right, n.data, max)) {
            return false;
        }
        return true;
    }
}
