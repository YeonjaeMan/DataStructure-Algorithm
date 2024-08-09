package DataStructure.TreeAndGraph.BSTtoList;

import java.util.ArrayList;
import java.util.LinkedList;

// 이진트리의 노드들을 각 레벨별로 LinkedList에 담는 알고리즘을 구현하시오.
// (예를 들어, 5개의 깊이를 가지는 트리라면 5개의 LinkedList를 만들어야 함.)
public class BinarySearchTree {
    public Node root;

    public BinarySearchTree(int size) {
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

    // 재귀호출을 통해 레벨을 함수의 인자로 받아오는 방법
    public ArrayList<LinkedList<Node>> BSTtoList() {
        ArrayList<LinkedList<Node>> lists = new ArrayList<>();
        BSTtoList(root, lists, 0);
        return lists;
    }

    public void BSTtoList(Node root, ArrayList<LinkedList<Node>> lists, int level) {
        if(root == null)
            return;
        LinkedList<Node> list;
        if(lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        BSTtoList(root.left, lists, level + 1);
        BSTtoList(root.right, lists, level + 1);
    }

    // BFS를 변형한 방법
    public ArrayList<LinkedList<Node>> BSTtoList2() {
        ArrayList<LinkedList<Node>> result = new ArrayList<>();
        LinkedList<Node> current = new LinkedList<>();
        if(root != null) {
            current.add(root);
        }
        while(current.size() > 0) {
            result.add(current);
            LinkedList<Node> parents = current;
            current = new LinkedList<>();
            for(Node parent : parents) {
                if(parent.left != null)
                    current.add(parent.left);
                if(parent.right != null)
                    current.add(parent.right);
            }
        }
        return result;
    }

    public void printList(ArrayList<LinkedList<Node>> arr) {
        for(LinkedList<Node> list : arr) {
            for(Node n : list) {
                System.out.print(n.data + " ");
            }
            System.out.println();
        }
    }
}
