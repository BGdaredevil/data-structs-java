package structures;

import interfaces.CustomList;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
    private int length;
    private int capacity;
    private T[] store;

    public CustomArrayList() {
        this(10);
    }

    public CustomArrayList(int capacity) {
        this.capacity = capacity;
        this.length = 0;

        this.store = (T[]) new Object[capacity];
        Arrays.fill(this.store, null);
    }

    public void prepend(T item) {
        this.insertAt(item, 0);
    }

    public void append(T item) {
        if (this.capacity == this.length) {
            this.grow();
        }

        this.store[this.length] = item;
        this.length++;
    }

    public void insertAt(T item, int idx) {
        while (idx >= this.capacity) {
            this.grow();
        }

        if (this.length + 1 > this.capacity) {
            this.grow();
        }

        T temp = this.store[idx];
        this.store[idx] = item;

        for (int i = idx + 1; i < this.capacity; i++) {
            T curr = this.store[i];
            this.store[i] = temp;
            temp = curr;
        }

        this.length++;
    }

    @Nullable
    public T remove(T item) {
        T foundItem = null;
        int itemIdx = -1;

        for (int i = 0; i < this.length; i++) {
            T curr = this.store[i];
            if (curr == item) {
                foundItem = curr;
                itemIdx = i;
                break;
            }
        }

        if (foundItem == null) {
            return null;
        }

        return this.removeAt(itemIdx);
    }

    @Override
    public int length() {
        return this.length;
    }

    @Nullable
    public T removeAt(int idx) {
        if (idx < 0 || idx > this.length) {
            return null;
        }

        T result = this.store[idx];

        for (int i = idx; i < this.length - 1; i++) {
            this.store[i] = this.store[i + 1];
        }

        this.length--;
        this.store[this.length] = null;

        return result;

    }

    @Nullable
    public T get(int idx) {
        if (idx < 0 || idx > this.length) {
            return null;
        }

        return this.store[idx];
    }

    private void grow() {
        this.capacity = this.capacity * 2;

        this.store = Arrays.copyOf(this.store, this.capacity);
    }

}

