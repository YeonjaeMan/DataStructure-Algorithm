package DataStructure.StackAndQueue.StackWithMin;

import java.util.Stack;

// Stack을 구현하는데 push와 pop과 더불어 가장 작은 값을 반환하는 min함수를 같이 구현하시오.
// (단, 모든 함수들은 O(1)의 시간만 걸려야 함.)
public class StackWithMin extends Stack<NodeWithMin> {
    public int min() {
        if(this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }

    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }
}
