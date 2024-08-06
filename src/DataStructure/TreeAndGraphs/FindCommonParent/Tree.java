package DataStructure.TreeAndGraphs.FindCommonParent;

import java.util.HashMap;

// 이진트리에서 주어진 두개의 노드의 첫번째 공통된 부모 노드를 찾으시오.
// (단, 다른 자료구조 사용금지)
public class Tree {
    public Node root;
    public HashMap<Integer, Node> rootMap;

    public Tree(int size) {
        rootMap = new HashMap<Integer, Node>();
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
        rootMap.put(mid, node); // key : mid, value : node
        return node;
    }

    // HashMap에서 해당 key : data인 value를 가져오는 메소드
    public Node getNode(int data) {
        return rootMap.get(data);
    }

    // 방법 1. 두 노드의 깊이의 차이를 이용해 두 노드의 깊이를 맞추고 하나씩 비교하는 방법
    public Node commonAncestor1(int d1, int d2) {
        Node p = getNode(d1);
        Node q = getNode(d2);
        int diff = depth(p) - depth(q);
        Node first = diff > 0 ? q : p;
        Node second = diff > 0 ? p : q;
        second = goUpBy(second, Math.abs(diff));
        while(first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }
        return first == null || second == null ? null : first;
    }

    // node를 diff만큼 올려주는 메소드
    public Node goUpBy(Node node, int diff) {
        while(diff > 0 && node != null) {
            node = node.parent;
            diff--;
        }
        return node;
    }

    // node의 깊이를 재는 메소드
    public int depth(Node node) {
        int depth = 0;
        while(node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }

    // 방법 2. 한 노드의 부모의 sub tree를 확인
    public Node commonAncestor2(int d1, int d2) {
        Node p = getNode(d1);
        Node q = getNode(d2);
        if(!covers(root, p) || !covers(root, q)) {
            return null;
        } else if(covers(p, q)) {
            return p;
        } else if(covers(q, p)) {
            return q;
        }
        Node sibling = getSibling(p); // p의 형제 노드
        Node parent = p.parent; // p의 부모 노드
        while(!covers(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }

    // node가 root의 자식인지 확인하는 메소드
    public boolean covers(Node root, Node node) {
        if(root == null)
            return false;
        if(root == node)
            return true;
        return covers(root.left, node) || covers(root.right, node);
    }

    // node의 형제 노드를 반환하는 메소드
    public Node getSibling(Node node) {
        if(node == null || node.parent == null) {
            return null;
        }
        Node parent = node.parent;
        return parent.left == node ? parent.right : parent.left;
    }
}
