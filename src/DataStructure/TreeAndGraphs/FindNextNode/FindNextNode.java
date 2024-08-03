package DataStructure.TreeAndGraphs.FindNextNode;

// 이진검색트리에서 주어진 노드의 다음 노드를 찾는 함수를 구현하시오.
// (단, 다음노드의 순서는 inorder traverse에 입각함)
public class FindNextNode {
    public Node root;

    public FindNextNode(int size) {
        root = makeBST(0, size - 1, null);
    }

    public Node makeBST(int start, int end, Node parent) {
        if(start > end)
            return null;
        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeBST(start, mid - 1, node);
        node.right = makeBST(mid + 1, end, node);
        node.parent = parent;
        return node;
    }

    public void findNext(Node node) {
        if(node.right == null) {
            System.out.println(findAbove(node.parent, node).data + " is " + node.data + "'s next");
        } else {
            System.out.println(findBelow(node.right).data + " is " + node.data + "'s next");
        }
    }

    public Node findAbove(Node root, Node child) {
        if(root == null)
            return null;
        if(root.left == child)
            return root;
        return findAbove(root.parent, root);
    }

    public Node findBelow(Node root) {
        if(root.left == null)
            return root;
        return findBelow(root.left);
    }
}
