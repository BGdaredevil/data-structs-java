package tests;

public class RingBuffer {
    public static boolean testRingBuffer(structures.RingBuffer<Integer> buffer) {
        var timer = new Timer("testRingBuffer");

        buffer.push(5);

        if (buffer.pop() != 5) {
            return false;
        }

        if (buffer.pop() != null) {
            return false;
        }

        buffer.push(42);
        buffer.push(9);

        if (buffer.pop() != 42) {
            return false;
        }

        if (buffer.pop() != 9) {
            return false;
        }

        if (buffer.pop() != null) {
            return false;
        }

        buffer.push(42);
        buffer.push(9);
        buffer.push(12);

        if (buffer.get(2) != 12) {
            return false;
        }

        if (buffer.get(1) != 9) {
            return false;
        }

        if (buffer.get(0) != 42) {
            return false;
        }

        buffer.push(100);
        buffer.push(101);
        buffer.push(102);
        buffer.push(103);
        buffer.push(104);
        buffer.push(105);
        buffer.push(106);
        buffer.push(107);
        buffer.push(108);

        Integer curr = buffer.pop();
        while (curr != null) {
            curr = buffer.pop();
        }

        buffer.pop();
        buffer.pop();
        buffer.pop();



        timer.end();

        return true;
    }
}
