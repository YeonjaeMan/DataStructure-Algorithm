package DataStructure.LinkedList;

class LinkedList {
    Node header;

    static class Node {
        int data;
        Node next = null;
    }

    LinkedList() {
        header = new Node();
    }

    public void append(int data) {
        Node node = header;
        Node end = new Node();
        end.data = data;
        while(node.next != null) {
            node = node.next;
        }
        node.next = end;
    }

    public void delete(int data) {
        Node node = header;
        while(node.next != null) {
            if(node.next.data == data) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
    }

    public void retrieve() {
        Node node = header.next;
        while(node.next != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println(node.data);
    }
}

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
