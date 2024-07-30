package DataStructure.StackAndQueue.SetOfStacks;

import DataStructure.StackAndQueue.MultiStacks.FullStackException;

import java.util.ArrayList;
import java.util.EmptyStackException;

// 접시를 쌓다가 너무 높으면 무너진다. 그래서 나누어 쌓아야 안전하다.
// Stack에 데이터를 쌓다가 어느 지점에 이르면 새로운 스택에 저장하는 식으로 SetOfStacks을 구현하시오.
// 내부적으로는 여러개 스택으로 나뉘지만, push와 pop은 하나의 Stack인 것처럼 동작해야함.
// 추가적으로, 세트중 하나의 Stack을 지정해서 데이터를 꺼내올 수 있는 popAt() 함수를 만드시오.
public class SetOfStacks2 {
    public int capacity;
    public ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();

    public SetOfStacks2(int capacity) {
        this.capacity = capacity;
    }

    public void addStack() {
        stacks.add(new Stack<Integer>(capacity));
    }

    public void removeLastStack() {
        stacks.remove(stacks.size() - 1);
    }

    public Stack<Integer> getLastStack() {
        if(stacks.isEmpty()) return null;
        return stacks.get(stacks.size() - 1);
    }

    public void push(int data) {
        Stack<Integer> last = getLastStack();
        if(last == null || last.isFull()) {
            addStack();
            last = getLastStack();
        }
        try {
            last.push(data);
        } catch (FullStackException e) {
            System.out.println("It's full");
        }
    }

    public int pop() {
        Stack<Integer> last = getLastStack();
        if(last == null || last.isEmpty()) throw new EmptyStackException();
        int data = last.pop();
        if(last.isEmpty()) removeLastStack();
        return data;
    }

    public int popAt(int index) {
        if(stacks.size() <= 0) {
            throw new EmptyStackException();
        }
        if(index < 0 || index >= stacks.size()) {
            throw new IndexOutOfBoundsException();
        }
        Stack<Integer> stack = stacks.get(index);
        if(stacks == null || stack.isEmpty()) {
            throw new EmptyStackException();
        }
        int data = stack.pop();
        shiftLeft(index);
        return data;
    }

    public void shiftLeft(int index) {
        if(index < stacks.size() - 1) {
            Stack<Integer> right = stacks.get(index + 1);
            Stack<Integer> left = stacks.get(index);
            try {
                left.push(right.popBottom());
            } catch(FullStackException e) {
                System.out.println("It's full");
            }
            if(right.isEmpty()) {
                stacks.remove(index + 1);
            }
            shiftLeft(index + 1);
        }
    }
}
