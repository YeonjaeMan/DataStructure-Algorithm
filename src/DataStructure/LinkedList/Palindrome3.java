package DataStructure.LinkedList;

// LinkedList의 노드들이 회문(Palindrome)인지를 확인하는 코드를 구현하시오.
public class Palindrome3 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append('m');
        ll.append('a');
        ll.append('d');
        ll.append('a');
        ll.append('m');
        ll.retrieve();

        System.out.println(isPalindrome(ll.get(1)));
    }

    // 방법 3. 재귀 호출 방법
    private static boolean isPalindrome(Node head) {
        int length = getListLength(head);
        Storage storage = isPalindromeRecursive(head, length);
        return storage.result;
    }

    private static Storage isPalindromeRecursive(Node head, int length) {
        if(head == null || length <= 0) {
            return new Storage(head, true);
        } else if(length == 1) {
            return new Storage(head.next, true);
        }
        Storage storage = isPalindromeRecursive(head.next, length - 2);
        if(!storage.result || storage.node == null) {
            return storage;
        }
        storage.result = (head.data == storage.node.data);
        storage.node = storage.node.next;
        return storage;
    }

    // 리스트의 길이를 구하는 메소드
    private static int getListLength(Node head) {
        int total = 1;
        while(head.next != null) {
            total++;
            head = head.next;
        }
        return total;
    }

    // 노드와 결과값을 저장할 클래스
    static class Storage {
        Node node;
        boolean result;

        Storage(Node n, boolean r) {
            this.node = n;
            this.result = r;
        }
    }

}
