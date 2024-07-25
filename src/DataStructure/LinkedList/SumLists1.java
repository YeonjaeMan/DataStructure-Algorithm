package DataStructure.LinkedList;

// 어떤 숫자를 자리수별로 한개씩 LinkedList에 담았다.
// 그런데, 1의 자리가 헤더에 오도록 거꾸로 담았다.
// 이런식의 LinkedList 두개를 받아서 합산하고 같은 식으로
// LinkedList에 담아서 반환하라.
public class SumLists1 {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.append(9);
        l1.append(1);
        l1.append(4);
        l1.retrieve(); // 9 - 1 - 4 = 419

        LinkedList l2 = new LinkedList();
        l2.append(6);
        l2.append(4);
        l2.append(3);
        l2.retrieve(); // 6 - 4 - 3 = 346

        // 419 + 346 = 765 ( 5 - 6 - 7 )
        Node node = sumLists(l1.get(1), l2.get(1), 0);
        while(node.next != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println(node.data);
    }

    // 재귀 호출 방식
    private static Node sumLists(Node l1, Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        Node result = new Node();
        int value = carry;

        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }
        result.data = value % 10;

        if (l1 != null || l2 != null) {
            Node next = sumLists(l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next,
                    value >= 10 ? 1 : 0);
            result.next = next;
        }

        return result;
    }
}
