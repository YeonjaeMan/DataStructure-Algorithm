package DataStructure.LinkedList;

// LinkedList에 있는 노드들을 x값을 기준으로 값이
// 작은 것들은 왼쪽, 큰 것들은 오른쪽, 두파트로 나누시오.
// (단, x는 오른쪽 파트 어디에 놔도 상관없음.)
public class Partition2 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(7);
        ll.append(2);
        ll.append(8);
        ll.append(5);
        ll.append(3);
        ll.append(4);
        ll.retrieve();

        Node n = partition(ll.get(1), 5);
        while(n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    // 방법 2. 앞뒤로 붙이기
    private static Node partition(Node n, int x) {
        Node h = n;
        Node t = n;

        while (n != null) {
            Node next = n.next;
            n.next = null;
            if (n.data >= x) {
                // tail 뒤에 붙이기
                t.next = n;
                t = n;
            } else {
                // head 앞에 붙이기
                n.next = h;
                h = n;
            }
            n = next;
        }
        // t.next = null;

        return h;
    }
}
