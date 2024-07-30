package DataStructure.StackAndQueue.SetOfStacks;

public class SetOfStacksTest {
    public static void main(String[] args) {
        SetOfStacks sos = new SetOfStacks(3);

        sos.push(1);
        sos.push(2);
        sos.push(3);

        sos.push(4);
        sos.push(5);
        sos.push(6);

        sos.push(7);
        sos.push(8);

        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());

    }
}
