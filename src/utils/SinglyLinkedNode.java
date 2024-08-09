package utils;

import org.jetbrains.annotations.Nullable;

public class SinglyLinkedNode<T> {
    T value = null;
    SinglyLinkedNode<T> next = null;

    public SinglyLinkedNode() {
        this(null, null);
    }

    public SinglyLinkedNode(T value) {
        this(value, null);
    }

    public SinglyLinkedNode(T value, SinglyLinkedNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Nullable
    public SinglyLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(@Nullable SinglyLinkedNode<T> next) {
        this.next = next;
    }
}
