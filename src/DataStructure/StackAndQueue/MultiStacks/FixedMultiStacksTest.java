package DataStructure.StackAndQueue.MultiStacks;

import java.util.EmptyStackException;

public class FixedMultiStacksTest {
    public static void main(String[] args) {
        FixedMultiStacks ms = new FixedMultiStacks(5);

        try {
            ms.push(0, 1);
            ms.push(0, 2);
            ms.push(0, 3);
            ms.push(0, 4);
            ms.push(0, 5);
            ms.push(0, 6);

            ms.push(1, 11);
            ms.push(1, 12);
            ms.push(1, 13);
            ms.push(1, 14);
            ms.push(1, 15);
        } catch(FullStackException e) {
            System.out.println("It's full");
        }
        
        try {
            System.out.println("Stack #0: " + ms.pop(0));
            System.out.println("Stack #0: " + ms.pop(0));
            System.out.println("Stack #0: " + ms.peek(0));
            System.out.println("Stack #0: " + ms.pop(0));
            System.out.println("Stack #0: " + ms.isEmpty(0));
            System.out.println("Stack #0: " + ms.pop(0));
            System.out.println("Stack #0: " + ms.pop(0));
            System.out.println("Stack #0: " + ms.isEmpty(0));

            System.out.println("Stack #1: " + ms.pop(1));
            System.out.println("Stack #1: " + ms.pop(1));
            System.out.println("Stack #1: " + ms.peek(1));
            System.out.println("Stack #1: " + ms.pop(1));
            System.out.println("Stack #1: " + ms.isEmpty(1));
            System.out.println("Stack #1: " + ms.pop(1));
            System.out.println("Stack #1: " + ms.pop(1));
            System.out.println("Stack #1: " + ms.isEmpty(1));
        } catch(EmptyStackException e) {
            System.out.println("It's empty");
        }
    }
}
