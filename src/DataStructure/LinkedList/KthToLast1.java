package DataStructure.LinkedList;

// 단방향 LinkedList의 끝에서 k번째 노드를 찾는 알고리즘을 구현하시오.
public class KthToLast1 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.retrieve();

        int k = 2;
        Node first = linkedList.getFirst();
        Node kth = kthToLast(first, k);
        System.out.println("Last k(" + k + ")th data is " + kth.data);
    }

    // 1. 노드의 개수를 세고 처음으로 돌아와서 마지막에서 k번째를 찾는 방법
    private static Node kthToLast(Node first, int k) {
        Node n = first;
        int total = 1;
        while(n.next != null) {
            n = n.next;
            total++;
        }
        n = first;
        for(int i = 1; i < total - k + 1; i++) {
            n = n.next;
        }
        return n;
    }
}
