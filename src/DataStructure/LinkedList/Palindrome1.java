package DataStructure.LinkedList;

// LinkedList의 노드들이 회문(Palindrome)인지를 확인하는 코드를 구현하시오.
public class Palindrome1 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append('m');
        ll.append('a');
        ll.append('d');
        ll.append('a');
        ll.append('m');
        ll.retrieve(); // m a d a m

        System.out.println(isPalindrome(ll.get(1)));
    }

    // 방법 1. 거꾸로 정렬해서 비교하기
    private static boolean isPalindrome(Node head) {
        Node reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    // 거꾸로 뒤집은 리스트를 반환하는 메소드
    private static Node reverseAndClone(Node node) {
        Node head = null;
        while(node != null) {
            Node n = new Node(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    // 두 리스트의 각 노드들이 같은지 판별하는 메소드
    private static boolean isEqual(Node n1, Node n2) {
        while(n1 != null && n2 != null) {
            if(n1.data != n2.data) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1 == null && n2 == null;
    }
}
