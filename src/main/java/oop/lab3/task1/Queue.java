package oop.lab3.task1;

import java.util.LinkedList;

public class Queue<T> implements IQueue<T> {
    private LinkedList<T> queue = new LinkedList<>();

    @Override
    public void enqueue(T element) {
        queue.addLast(element);
    }

    @Override
    public T dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return queue.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }
}
