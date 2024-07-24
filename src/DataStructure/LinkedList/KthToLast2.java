package DataStructure.LinkedList;

// 단방향 LinkedList의 끝에서 k번째 노드를 찾는 알고리즘을 구현하시오.
public class KthToLast2 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.retrieve();

        int k = 3;
        Reference r = new Reference();
        Node found = kthToLast(linkedList.header.next, k, r);
        System.out.println(found.data);
    }

    static class Reference {
        public int count = 0;
    }

    // 2. 재귀 호출 방법
    // 시간 복잡도 : O(N)
    // 공간 복잡도 : O(N)
    private static Node kthToLast(Node n, int k, Reference r) {
        if(n == null) {
            return null;
        }
        Node found = kthToLast(n.next, k, r);
        r.count++;
        if(r.count == k) {
            return n;
        }
        return found;
    }
}
