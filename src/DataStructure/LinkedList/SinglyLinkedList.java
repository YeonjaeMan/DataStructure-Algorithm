package DataStructure.LinkedList;

class Node {
    int data;
    Node next = null;

    public Node(int data) {
        this.data = data;
    }

    public void append(int data) {
        Node node = this;
        Node end = new Node(data);
        while(node.next != null) {
            node = node.next;
        }
        node.next = end;
    }

    public void delete(int data) {
        Node node = this;
        while(node.next != null) {
            if(node.next.data == data) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
    }

    public void retrieve() {
        Node node = this;
        while(node.next != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println(node.data);
    }
}

public class SinglyLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.retrieve();
        head.delete(2);
        head.delete(3);
        head.retrieve();
    }
}
