package oop.lab3.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    @Test
    public void testSize() {
        Queue<Integer> queue = new Queue<>();
        Queue<Integer> queue2 = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());
        assertEquals(0, queue2.size());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testDeque() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertNull(queue.dequeue());
    }
}
