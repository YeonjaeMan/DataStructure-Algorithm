package DataStructure.StackAndQueue.StackWithMin;

import java.util.Stack;

// Stack을 구현하는데 push와 pop과 더불어 가장 작은 값을 반환하는 min함수를 같이 구현하시오.
// (단, 모든 함수들은 O(1)의 시간만 걸려야 함.)
public class StackWithMin2 extends Stack<Integer> {
    Stack<Integer> s2;

    public StackWithMin2() {
        s2 = new Stack<Integer>();
    }

    public int min() {
        if(s2.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return s2.peek();
        }
    }

    public void push(int value) {
        if(value < min()) {
            s2.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if(value == min()) {
            s2.pop();
        }
        return value;
    }
}
