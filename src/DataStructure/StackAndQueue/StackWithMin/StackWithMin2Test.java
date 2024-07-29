package DataStructure.StackAndQueue.StackWithMin;

public class StackWithMin2Test {
    public static void main(String[] args) {
        StackWithMin2 stack = new StackWithMin2();
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        System.out.println("min: " + stack.min());
        System.out.println("pop: " + stack.pop());
        System.out.println("min: " + stack.min());
        System.out.println("pop: " + stack.pop());
        System.out.println("min: " + stack.min());
        System.out.println("pop: " + stack.pop());
        System.out.println("min: " + stack.min());
        System.out.println("pop: " + stack.pop());
    }
}
