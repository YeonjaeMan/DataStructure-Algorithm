package DataStructure.LinkedList;

public class Node {
    int data;
    Node next = null;

    public Node() {}
    public Node(int data) {
        this.data = data;
    }

    public Node addNext(int data) {
        Node head = this;
        Node next = new Node(data);
        head.next = next;
        return next;
    }

    public Node addNext(Node node) {
        Node head = this;
        head.next = node;
        return node;
    }

    public Node get(int length) {
        Node current = this;
        for(int i = 0; i < length; i++) {
            current = current.next;
        }
        return current;
    }

    public void print() {
        Node current = this;
        while(current.next != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println(current.data);
    }
}

// 헤더가 없는 LinkedList 구현한 코드

/* public class Node {
    int data;
    Node next = null;

    Node(int d) {
        this.data = d;
    }

    void append(int d) {
        Node end = new Node(d);
        Node n = this;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    void delete(int d) {
        Node n = this;
        while(n.next != null) {
            if(n.next.data == d) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void retrieve() {
        Node n = this;
        while(n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }
} */
