package DataStructure.LinkedList;

// 단방향 LinkedList의 끝에서 k번째 노드를 찾는 알고리즘을 구현하시오.
public class KthToLast3 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();

        int k = 3;
        Node found = kthToLast(ll.getFirst(), k);
        System.out.println(found.data);
    }

    // 3. 포인터 사용
    // 시간 복잡도 : O(N)
    // 공간 복잡도 : O(1)
    private static Node kthToLast(Node first, int k) {
        Node p1 = first;
        Node p2 = first;
        for(int i = 0; i < k; i++) {
            if(p1 == null) return null;
            p1 = p1.next;
        }
        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
