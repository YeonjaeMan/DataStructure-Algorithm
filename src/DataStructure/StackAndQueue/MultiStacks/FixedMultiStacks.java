package DataStructure.StackAndQueue.MultiStacks;

import java.util.EmptyStackException;

// 고정 길이 멀티 스택
public class FixedMultiStacks {
    // 스택의 개수
    private int numOfStacks = 3;
    // 스택 한개의 크기
    private int stackSize;
    // 스택에 들어있는 값
    private int[] values;
    // 각 스택이 채워진 크기
    private int[] sizes;

    public FixedMultiStacks(int stackSize) {
        this.stackSize = stackSize;
        this.values = new int[stackSize * numOfStacks];
        this.sizes = new int[numOfStacks];
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackSize;
    }

    public int getTopIndex(int stackNum) {
        int offset = stackNum * stackSize;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

    public void push(int stackNum, int data) throws FullStackException {
        if(isFull(stackNum)) {
            throw new FullStackException();
        }
        values[getTopIndex(stackNum) + 1] = data;
        sizes[stackNum]++;
    }

    public int pop(int stackNum) {
        if(isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int top = getTopIndex(stackNum);
        int data = values[top];
        values[top] = 0;
        sizes[stackNum]--;
        return data;
    }

    public int peek(int stackNum) {
        if(isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        return values[getTopIndex(stackNum)];
    }
}
