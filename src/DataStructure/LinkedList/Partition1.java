package DataStructure.LinkedList;

// LinkedList에 있는 노드들을 x값을 기준으로 값이
// 작은 것들은 왼쪽, 큰 것들은 오른쪽, 두파트로 나누시오.
// (단, x는 오른쪽 파트 어디에 놔도 상관없음.)
public class Partition1 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(8);
        ll.append(5);
        ll.append(2);
        ll.append(7);
        ll.append(3);
        ll.retrieve();

        Node found = partition(ll.getFirst(), 5);
        while(found.next != null) {
            System.out.print(found.data + " -> ");
            found = found.next;
        }
        System.out.println(found.data);
    }

    // 방법 1. 두 줄로 세우기
    private static Node partition(Node n, int x) {
        Node s1 = null;
        Node e1 = null;
        Node s2 = null;
        Node e2 = null;

        while(n != null) {
            // 노드를 움직이기 전에 연결을 끊어야 함
            Node next = n.next;
            n.next = null;
            if(n.data >= x) {
                if(s2 == null) {
                    s2 = n;
                    e2 = n;
                } else {
                    e2.next = n;
                    e2 = n;
                }
            } else {
                if(s1 == null) {
                    s1 = n;
                    e1 = n;
                } else {
                    e1.next = n;
                    e1 = n;
                }
            }
            n = next;
        }
        if(s1 == null) {
            return s2;
        }
        e1.next = s2;
        return s1;
    }
}
