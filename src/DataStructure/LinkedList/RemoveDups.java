package DataStructure.LinkedList;

class LinkedList2 {
    Node header;

    static class Node {
        int data;
        Node next = null;
    }

    public LinkedList2() {
        header = new Node();
    }

    void append(int data) {
        Node node = header;
        Node end = new Node();
        end.data = data;
        while(node.next != null) {
            node = node.next;
        }
        node.next = end;
    }

    void delete(int data) {
        Node node = header;
        while(node.next != null) {
            if(node.next.data == data) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
    }

    void retrieve() {
        Node node = header.next;
        while(node.next != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println(node.data);
    }

    // 시간 복잡도 O(n^2), 공간 복잡도 O(1)
    void removeDups() {
        Node node = header;
        while(node != null && node.next != null) {
            Node runner = node;
            while(runner.next != null) {
                if(node.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            node = node.next;
        }
    }
}

public class RemoveDups {
    public static void main(String[] args) {
        LinkedList2 linkedList = new LinkedList2();
        linkedList.append(2);
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(4);
        linkedList.append(2);
        linkedList.retrieve();
        linkedList.removeDups();
        linkedList.retrieve();
    }
}
