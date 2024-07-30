package DataStructure.StackAndQueue.SetOfStacks;

import DataStructure.StackAndQueue.MultiStacks.FullStackException;

import java.util.EmptyStackException;

public class Stack<E> {
    class Node {
        E data;
        Node below;
        Node above;

        Node(E data) {
            this.data = data;
        }
    }

    int capacity;
    int size;
    Node top;
    Node bottom;

    Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isEmpty() {return size == 0;}
    public boolean isFull() {return size == capacity;}
    public int size() {return size;}

    public void push(E d) throws FullStackException {
        if(isFull()) throw new FullStackException();

        Node n = new Node(d);
        push(n);
    }

    public void push(Node n) throws FullStackException {
        if(isFull()) throw new FullStackException();

        if(isEmpty()) {
            top = n;
            bottom = n;
        } else {
            top.above = n;
            n.below = top;
            top = n;
        }
        size++;
    }

    public E pop() {
        if(isEmpty()) throw new EmptyStackException();
        E data = top.data;
        top = top.below;
        if(top == null) {
            bottom = null;
        } else {
            top.above = null;
        }
        size--;
        return data;
    }

    public Node popBottom() {
        if(isEmpty()) throw new EmptyStackException();
        Node n = bottom;
        bottom = bottom.above;
        if(bottom == null) {
            top = null;
        } else {
            bottom.below = null;
        }
        size--;
        return n;
    }
}
