package DataStructure.LinkedList;

// 단방향 LinkedList에서 중간에 있는 노드를 삭제하시오.
// (단, 첫번째 노드가 어디있는지 모르고, 오직 삭제할 노드만 알고 있다.)
public class DeleteNode {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();

        deleteNode(ll.get(3));
        ll.retrieve();
    }

    // 삭제할 노드에 다음 노드의 정보를 복사하고, 다음 노드를 삭제한다.
    private static boolean deleteNode(Node n) {
        // 이 방법으로 첫번째 노드와 마지막 노드는 삭제할 수 없다.
        if(n == null || n.next == null) {
            return false;
        }
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }
}
