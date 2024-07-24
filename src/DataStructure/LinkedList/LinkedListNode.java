package DataStructure.LinkedList;

// 헤더가 있는 LinkedList 실습
public class LinkedListNode {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.retrieve();
        linkedList.delete(1);
        linkedList.retrieve();
    }
}
