package DataStructure.LinkedList;

// 주어진 두개의 단방향 LinkedList에서 교차되는 노드를 찾으시오.
// (단, 교차점은 값이 아닌 주소로 찾아야 함.)
public class GetIntersection {
    public static void main(String[] args) {
        Node n1 = new Node(5);
        Node n2 = n1.addNext(7);
        Node n3 = n2.addNext(9);
        Node n4 = n3.addNext(10);
        Node n5 = n4.addNext(7);
        Node n6 = n5.addNext(6);

        Node m1 = new Node(6);
        Node m2 = m1.addNext(8);
        Node m3 = m2.addNext(n4);

        n1.print();
        m1.print();

        Node n = getIntersection(n1, m1);

        if(n != null) {
            System.out.println("Intersection : " + n.data);
        } else {
            System.out.println("Not found");
        }
    }

    private static Node getIntersection(Node l1, Node l2) {
        int len1 = getListLength(l1);
        int len2 = getListLength(l2);

        if(len1 > len2) {
            l1 = l1.get(len1 - len2);
        } else if(len1 < len2) {
            l2 = l2.get(len2 - len1);
        }

        while(l1 != null && l2 != null) {
            if(l1 == l2) {
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return null;
    }

    private static int getListLength(Node n) {
        int total = 1;
        while(n.next != null) {
            total++;
            n = n.next;
        }
        return total;
    }
}
