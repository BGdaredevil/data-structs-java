package tests;

public class CustomQueue {
    public static boolean testQueue(structures.CustomQueue<Integer> queue) {
        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(9);

        if (queue.deque() != 5) {
            return false;
        }

        if (queue.getLength() != 2) {
            return false;
        }

        queue.enqueue(11);

        if (queue.deque() != 7) {
            return false;
        }
        if (queue.deque() != 9) {
            return false;
        }
        if (queue.peek() != 11) {
            return false;
        }
        if (queue.deque() != 11) {
            return false;
        }
        if (queue.deque() != null) {
            return false;
        }
        if (queue.getLength() != 0) {
            return false;
        }

        queue.enqueue(69);

        if (queue.peek() != 69) {
            return false;
        }
        if (queue.getLength() != 1) {
            return false;
        }

        return true;
    }
}
