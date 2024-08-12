package utils;

import org.jetbrains.annotations.Nullable;

public class DoublyLinkedNode<T> {
    T value = null;
    DoublyLinkedNode<T> next = null;
    DoublyLinkedNode<T> prev = null;

    public DoublyLinkedNode() {
        this(null, null, null);
    }

    public DoublyLinkedNode(T value) {
        this(value, null, null);
    }

    public DoublyLinkedNode(T value, DoublyLinkedNode<T> next) {
        this(value, next, null);
    }

    public DoublyLinkedNode(T value, DoublyLinkedNode<T> next, DoublyLinkedNode<T> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    @Nullable
    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Nullable
    public DoublyLinkedNode<T> getNext() {
        return this.next;
    }

    public void setNext(DoublyLinkedNode<T> next) {
        this.next = next;
    }

    @Nullable
    public DoublyLinkedNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedNode<T> prev) {
        this.prev = prev;
    }
}
