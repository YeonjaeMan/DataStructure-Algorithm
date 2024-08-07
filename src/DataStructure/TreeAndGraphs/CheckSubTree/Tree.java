package DataStructure.TreeAndGraphs.CheckSubTree;

// 크기가 매우 큰 두개의 이진트리 T1과 T2가 있다.
// T1은 T2보다 큰데 T2가 T1의 서브트리인지를 확인하는 알고리즘을 구현하시오.
// T2의 루트노드의 값이 T1에 존재하고, 그 노드를 기준으로 줄기를 잘라냈을 때,
// T2의 값과 구조가 같으면 서브트리로 인정함.
public class Tree {
    public Node root;

    public Tree() {}

    public Tree(int size) {
        this.root = makeBST(0, size - 1);
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

    public boolean containsTree(Node t1, Node t2) {
        if(t2 == null)
            return true;
        return subTree(t1, t2);
    }

    public boolean subTree(Node t1, Node t2) {
        if(t1 == null)
            return false;
        else if(t1.data == t2.data && matchTree(t1, t2))
            return true;
        return subTree(t1.left, t2) || subTree(t1.right, t2);
    }

    public boolean matchTree(Node t1, Node t2) {
        if(t1 == null && t2 == null) {
            return true;
        } else if(t1 == null || t2 == null) {
            return false;
        } else if(t1.data != t2.data) {
            return false;
        } else {
            return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
        }
    }
}
