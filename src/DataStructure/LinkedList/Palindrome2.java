package DataStructure.LinkedList;

import java.util.Stack;

// LinkedList의 노드들이 회문(Palindrome)인지를 확인하는 코드를 구현하시오.
public class Palindrome2 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append('m');
        ll.append('a');
        ll.append('d');
        ll.append('a');
        ll.append('m');
        ll.retrieve();

        System.out.println(isPalindrome((ll.get(1))));
    }

    // 방법 2. 두 개의 포인터 (토끼와 거북이)
    private static boolean isPalindrome(Node head) {
        Node fast = head;
        Node slow = head;

        Stack<Integer> stack = new Stack<>();

        while(fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null) {
            slow = slow.next;
        }

        while(slow != null) {
            if(stack.pop() != slow.data) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
}
