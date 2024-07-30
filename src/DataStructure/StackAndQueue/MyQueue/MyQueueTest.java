package DataStructure.StackAndQueue.MyQueue;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<Integer> q = new MyQueue<Integer>();

        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
