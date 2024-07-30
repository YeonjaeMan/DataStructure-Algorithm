package DataStructure.StackAndQueue.SortStack;

import java.util.Stack;

// Stack을 정렬하는 함수를 만드시오.
// (단, 하나의 Stack을 추가로 사용할 수 있고, Array 등 다른 데이터 구조는 사용할 수 없음.)
public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<Integer>();

        s1.push(3);
        s1.push(5);
        s1.push(1);
        s1.push(6);

        sort(s1);

        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
    }

    private static void sort(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<Integer>();
        while(!s1.isEmpty()) {
            int tmp = s1.pop();
            while(!s2.isEmpty() && s2.peek() > tmp) {
                s1.push(s2.pop());
            }
            s2.push(tmp);
        }
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
}
