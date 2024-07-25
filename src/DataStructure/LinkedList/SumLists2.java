package DataStructure.LinkedList;

// *심화 문제*
// LinkedList의 숫자가 거꾸로가 아니라면?
public class SumLists2 {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.append(4);
        l1.append(1);
        l1.append(9);
        l1.retrieve(); // 4 - 1 - 9 = 419

        LinkedList l2 = new LinkedList();
        l2.append(3);
        l2.append(4);
        l2.retrieve(); // 3 - 4 = 34

        // 419 + 34 = 453 ( 4 - 5 - 3 )
        Node l = sumLists(l1.get(1), l2.get(1));
        while (l.next != null) {
            System.out.print(l.data + " -> ");
            l = l.next;
        }
        System.out.println(l.data);
    }

    // 두 리스트를 더하는 메소드
    private static Node sumLists(Node l1, Node l2) {
        int len1 = listLength(l1);
        int len2 = listLength(l2);

        if (len1 > len2) {
            l2 = LPadList(l2, len1 - len2);
        } else {
            l1 = LPadList(l1, len2 - len1);
        }

        Storage storage = addLists(l1, l2);
        if (storage.carry == 1) {
            storage.result = insertBefore(storage.result, 1);
        }
        return storage.result;
    }

    // 한 자리씩 연산하는 재귀 호출 메소드
    private static Storage addLists(Node l1, Node l2) {
        if (l1 == null && l2 == null) {
            return new Storage();
        }
        Storage storage = addLists(l1.next, l2.next);
        int value = storage.carry + l1.data + l2.data;
        storage.carry = value / 10;
        storage.result = insertBefore(storage.result, value % 10);
        return storage;
    }

    // 리스트의 길이를 구하는 메소드
    private static int listLength(Node l) {
        int total = 1;
        while (l.next != null) {
            total++;
            l = l.next;
        }
        return total;
    }

    // 리스트의 빈 자리에 0을 채우는 메소드
    private static Node LPadList(Node node, int length) {
        Node head = node;
        for (int i = 0; i < length; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    // 리스트의 왼쪽에 새로운 노드를 추가해주는 메소드
    private static Node insertBefore(Node node, int data) {
        Node before = new Node(data);
        before.next = node;
        return before;
    }
}

class Storage {
    int carry = 0;
    Node result = null;
}
