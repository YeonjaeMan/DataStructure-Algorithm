package DataStructure.LinkedList;

public class LinkedList {
    Node header;

    LinkedList() {
        header = new Node();
    }

    // k번째 노드를 반환하는 메소드
    public Node get(int k) {
        Node n = header;
        for(int i = 0; i < k; i++) {
            n = n.next;
        }
        return n;
    }

    // LinkedList의 첫번째 노드를 반환하는 메소드
    public Node getFirst() {
        return this.header.next;
    }

    // LinkedList의 맨 뒤에 Node를 추가하는 메소드
    public void append(int d) {
        Node n = header;
        Node end = new Node();
        end.data = d;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    // LinkedList의 노드를 삭제하는 메소드
    public void delete(int d) {
        Node n = header;
        while(n.next != null) {
            if(n.next.data == d) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    // LinkedList를 출력하는 메소드
    public void retrieve() {
        Node n = header.next;
        while(n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    // LinkedList의 중복값을 제거해주는 메소드
    public void removeDups() {
        Node n = header;
        while(n != null && n.next != null) {
            Node r = n;
            while(r.next != null) {
                if(n.data == r.next.data) {
                    r.next = r.next.next;
                } else {
                    r = r.next;
                }
            }
            n = n.next;
        }
    }
}
