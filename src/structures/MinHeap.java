package structures;

import org.jetbrains.annotations.Nullable;
import tests.Timer;

import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> {
    private int length;
    private ArrayList<T> data;

    public MinHeap() {
        this(3);
    }

    public MinHeap(int capacity) {
        this.length = 0;
        this.data = new ArrayList<T>();
    }

    public void insert(T value) {
        this.data.add( value);
        this.heapifyUp(this.length);
        this.length++;
    }

    @Nullable
    public T delete() {
        if (this.length == 0) {
            return null;
        }

        T result = this.data.getFirst();
        this.length--;

        if (this.length == 0) {
            return result;
        }

        this.data.set(0, this.data.get(this.length));
        this.heapifyDown(0);

        return result;
    }

    public int getLength() {
        return this.length;
    }

    private void heapifyUp(int idx) {
        if (idx == 0) {
            return;
        }

        T currentValue = this.data.get(idx);
        int parentIdx = this.getParentIdx(idx);
        T parentVal = this.data.get(parentIdx);

        if (parentVal.compareTo(currentValue) > 0) {
            this.data.set(idx, parentVal);
            this.data.set(parentIdx, currentValue);

            this.heapifyUp(parentIdx);
        }
    }

    private void heapifyDown(int idx) {
        if (idx >= this.length) {
            return;
        }

        int leftIdx = this.getLeftChildIdx(idx);
        int rightIdx = this.getRightChildIdx(idx);

        if (leftIdx > this.length) {
            return;
        }

        T currVal = this.data.get(idx);
        T leftVal = this.data.get(leftIdx);
        T rightVal = this.data.get(rightIdx);

        if (leftVal.compareTo(rightVal) > 0 && currVal.compareTo(rightVal) > 0) {
            this.data.set(rightIdx, currVal);
            this.data.set(idx, rightVal);

            this.heapifyDown(rightIdx);
        } else if (leftVal.compareTo(rightVal) < 0 && currVal.compareTo(leftVal) > 0) {
            this.data.set(leftIdx, currVal);
            this.data.set(idx, leftVal);

            this.heapifyDown(leftIdx);
        }

    }

    private int getParentIdx(int idx) {
        return (idx - 1) / 2;
    }

    private int getLeftChildIdx(int idx) {
        return 2 * idx + 1;
    }

    private int getRightChildIdx(int idx) {
        return 2 * idx + 2;
    }
}
