package structures;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class RingBuffer<T> {
    private int length;
    private int capacity;
    private int head;
    private int tail;
    private T[] store;

    public RingBuffer() {
        this(3);
    }

    public int getLength() {
        return length;
    }

    public RingBuffer(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.head = 0;
        this.tail = 0;

        this.store = (T[]) new Object[capacity];
        Arrays.fill(this.store, null);
    }

    public void push(T item) {
        if (this.length == this.capacity) {
            this.grow();
        }

        this.store[this.tail] = item;
        this.tail = (this.tail + 1) % this.capacity;

        this.length++;
    }

    @Nullable
    public T pop() {
        T item = this.store[this.head];
        this.store[this.head] = null;

        if (item != null) {
            this.length--;
            this.head = (this.head + 1) % this.capacity;
        }

        return item;
    }

    @Nullable
    public T get(int idx) {
        if (idx < 0 || idx > this.length) {
            return null;
        }

        return this.store[(this.head + idx) % this.capacity];
    }

    private void grow() {
        T[] newStore = Arrays.copyOf(this.store, this.capacity * 2);
        Arrays.fill(newStore, null);

        for (int i = 0; i < this.length; i++) {
            newStore[i] = this.store[(this.head + i) % this.capacity];
        }

        this.store = newStore;
        this.head = 0;
        this.tail = this.length;
        this.capacity = this.capacity * 2;
    }

}
