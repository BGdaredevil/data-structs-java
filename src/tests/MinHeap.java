package tests;

public class MinHeap {
    public static boolean testMinHeap() {
        var timer = new Timer("testMinHeap");
        structures.MinHeap<Integer> heap = new structures.MinHeap<Integer>();

        if (heap.getLength() != 0) {
            return false;
        }

        heap.insert(5);
        heap.insert(3);
        heap.insert(69);
        heap.insert(420);
        heap.insert(4);
        heap.insert(1);
        heap.insert(8);
        heap.insert(7);

        if (heap.getLength() != 8) {
            return false;
        }

        if (heap.delete() != 1) {
            return false;
        }
        if (heap.delete() != 3) {
            return false;
        }
        if (heap.delete() != 4) {
            return false;
        }
        if (heap.delete() != 5) {
            return false;
        }

        if (heap.getLength() != 4) {
            return false;
        }

        if (heap.delete() != 7) {
            return false;
        }
        if (heap.delete() != 8) {
            return false;
        }
        if (heap.delete() != 69) {
            return false;
        }
        if (heap.delete() != 420) {
            return false;
        }

        if (heap.getLength() != 0) {
            return false;
        }

        timer.end();

        return true;
    }
}
