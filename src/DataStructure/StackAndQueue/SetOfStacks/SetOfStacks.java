package DataStructure.StackAndQueue.SetOfStacks;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

// 접시를 쌓다가 너무 높으면 무너진다. 그래서 나누어 쌓아야 안전하다.
// Stack에 데이터를 쌓다가 어느 지점에 이르면 새로운 스택에 저장하는 식으로 SetOfStacks을 구현하시오.
// 내부적으로는 여러개 스택으로 나뉘지만, push와 pop은 하나의 Stack인 것처럼 동작해야함.
// 추가적으로, 세트중 하나의 Stack을 지정해서 데이터를 꺼내올 수 있는 popAt() 함수를 만드시오.
public class SetOfStacks {
    public int capacity;
    public ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    // 마지막 스택을 가져오는 메소드
    public Stack<Integer> getLastStack() {
        // ArrayList가 비어있다면 스택이 없음
        if(stacks.isEmpty()) return null;
        return stacks.get(stacks.size() - 1);
    }

    // 스택을 추가하는 메소드
    public void addStack() {
        stacks.add(new Stack<Integer>());
    }

    // 스택을 삭제하는 메소드
    public void removeLastStack() {
        stacks.remove(stacks.size() - 1);
    }

    public void push(int data) {
        // getLastStack()으로 마지막 스택의 포인터 가져오기
        Stack<Integer> last = getLastStack();
        // 마지막 스택이 없거나 가득 찬 경우
        if(last == null || last.size() == capacity) {
            // 스택을 새로 추가하고,
            addStack();
            // 스택 포인터를 다시 마지막으로 초기화해줌
            last = getLastStack();
        }
        // 마지막 스택에 데이터 추가
        last.push(data);
    }

    public int pop() {
        // 마지막 스택 포인터 가져오기
        Stack<Integer> last = getLastStack();
        // 마지막 스택이 없거나 비어있는 경우
        if(last == null || last.isEmpty()) {
            // 예외 처리
            throw new EmptyStackException();
        }
        // 마지막 스택에서 pop
        int data = last.pop();
        // 마지막 스택이 비었다면
        if(last.isEmpty()) {
            // 마지막 스택 지우기
            removeLastStack();
        }
        return data;
    }
}
