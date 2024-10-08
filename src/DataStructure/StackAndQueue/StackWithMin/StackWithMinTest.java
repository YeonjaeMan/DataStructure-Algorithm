package DataStructure.StackAndQueue.StackWithMin;

public class StackWithMinTest {
    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        System.out.println("min: " + stack.min());
        System.out.println(stack.pop().value);
        System.out.println(stack.pop().value);
        System.out.println("min: " + stack.min());
    }
}
