package DataStructure.StackAndQueue.Stack;

import DataStructure.StackAndQueue.Node;

import java.util.EmptyStackException;

// 스택을 구현하시오.
public class Stack<T> {
    private Node<T> top;

    public T pop() {
        if(top == null) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        Node<T> t = new Node<T>(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if(top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
