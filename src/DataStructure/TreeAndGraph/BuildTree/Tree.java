package DataStructure.TreeAndGraph.BuildTree;

// 트리의 순회 결과 배열로 원본의 트리를 구현하시오.
public class Tree {
    public Node root;
    public static int pIndex = 0; // 순회결과의 몇번방까지 읽었는지 저장하는 변수

    // inorder과 preorder 결과 배열을 가지고 트리를 재현하는 방법
    public void buildTreeByInPre(int[] in, int[] pre) {
        pIndex = 0;
        root = buildTreeByInPre(in, pre, 0, in.length - 1);
    }

    private Node buildTreeByInPre(int[] in, int[] pre, int start, int end) {
        if(start > end) {
            return null;
        }
        Node node = new Node(pre[pIndex++]);
        if(start == end) {
            return node;
        }
        int mid = search(in, start, end, node.data);
        node.left = buildTreeByInPre(in, pre, start, mid - 1);
        node.right = buildTreeByInPre(in, pre, mid + 1, end);
        return node;
    }

    // inorder과 postorder 결과 배열을 가지고 트리를 재현하는 방법
    public void buildTreeByInPost(int[] in, int[] post) {
        pIndex = post.length - 1;
        root = buildTreeByInPost(in, post, 0, in.length - 1);
    }

    private Node buildTreeByInPost(int[] in, int[] post, int start, int end) {
        if(start > end) {
            return null;
        }
        Node node = new Node(post[pIndex--]);
        if(start == end) {
            return node;
        }
        int mid = search(in, start, end, node.data);
        node.right = buildTreeByInPost(in, post, mid + 1, end);
        node.left = buildTreeByInPost(in, post, start, mid - 1);
        return node;
    }

    private int search(int[] arr, int start, int end, int value) {
        int i;
        for(i = start; i <= end; i++) {
            if(arr[i] == value)
                return i;
        }
        return i;
    }

    public void printInorder(Node node) {
        if(node == null) return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
}
