package DataStructure.StackAndQueue.Queue;

import DataStructure.StackAndQueue.Node;

import java.util.NoSuchElementException;

// 큐를 구현하시오.
public class Queue<T> {
    private Node<T> first;
    private Node<T> last;

    public void add(T item) {
        Node<T> t = new Node<T>(item);
        if(last != null) {
            last.next = t;
        }
        last = t;
        if(first == null) {
            first = last;
        }
    }

    public T remove() {
        if(first == null) {
            throw new NoSuchElementException();
        }
        T item = first.data;
        first = first.next;
        if(first == null) {
            last = null;
        }
        return item;
    }

    public T peek() {
        if(first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
