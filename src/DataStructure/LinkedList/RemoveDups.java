package DataStructure.LinkedList;

// 정렬되어 있지 않은 LinkedList의 중복값 제거 (단, 버퍼를 사용하지 않아야 함)
public class RemoveDups {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(2);
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(4);
        ll.append(2);
        ll.retrieve();
        ll.removeDups();
        ll.retrieve();
    }
}
