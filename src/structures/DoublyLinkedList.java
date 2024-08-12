package structures;

import interfaces.CustomList;
import org.jetbrains.annotations.Nullable;
import utils.DoublyLinkedNode;

public class DoublyLinkedList<T> implements CustomList<T> {
    int length = 0;
    private DoublyLinkedNode<T> head = null;
    private DoublyLinkedNode<T> tail = null;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public @Nullable T removeAt(int idx) {
        if (idx < 0 || idx > this.length) {
            return null;
        }
        int count = idx;
        DoublyLinkedNode<T> curr = this.head;

        while (count > 0) {
            if (curr == null) {
                return null;
            }

            curr = curr.getNext();
            count--;
        }

        T result = curr.getValue();

        if (curr.getPrev() != null) {
            curr.getPrev().setNext(curr.getNext());
        }

        if (curr.getNext() != null) {
            curr.getNext().setPrev(curr.getPrev());
        }

        if (curr == this.head) {
            this.head = curr.getNext();
        }

        if (curr == this.tail) {
            this.tail = curr.getPrev();
        }

        this.length--;
        curr.setNext(null);
        curr.setPrev(null);

        return result;

    }

    @Override
    public @Nullable T remove(T item) {
        if (this.length == 0) {
            return null;
        }

        DoublyLinkedNode<T> curr = this.head;

        while (curr.getNext() != null) {
            if (curr.getValue() != item) {
                curr = curr.getNext();
                continue;
            }

            if (curr.getPrev() != null) {
                curr.getPrev().setNext(curr.getNext());
            }

            if (curr.getNext() != null) {
                curr.getNext().setPrev(curr.getPrev());
            }

            if (curr == this.head) {
                this.head = curr.getNext();
            }

            if (curr == this.tail) {
                this.tail = curr.getPrev();
            }

            this.length--;
            curr.setPrev(null);
            curr.setNext(null);

            return curr.getValue();
        }

        return null;
    }

    @Override
    public @Nullable T get(int idx) {
        if (idx < 0 || idx > this.length) {
            return null;
        }

        int count = idx;
        DoublyLinkedNode<T> curr = this.head;

        while (count > 0) {
            if (curr == null) {
                return null;
            }

            curr = curr.getNext();

            count--;
        }

        if (curr == null) {
            return null;
        }

        return curr.getValue();
    }

    @Override
    public void prepend(T item) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode<>(item, this.head);

        if (this.length == 0) {
            this.tail = newNode;
        }

        if (this.head != null) {
            this.head.setPrev(newNode);
        }

        this.head = newNode;
        this.length++;
    }

    @Override
    public void append(T item) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode<>(item, null, this.tail);

        if (this.length == 0) {
            this.head = newNode;
        }

        if (this.tail != null) {
            this.tail.setNext(newNode);
        }

        this.tail = newNode;
        this.length++;
    }

    @Override
    public void insertAt(T item, int idx) {
        if (idx < 0 || idx > this.length) {
            return;
        }

        DoublyLinkedNode<T> curr = this.head;
        int count = idx;

        while (count > 0) {
            if (curr == null) {
                return;
            }

            curr = curr.getNext();
            count--;
        }

        DoublyLinkedNode<T> newNode = new DoublyLinkedNode<>(item);
        this.length++;

        if (curr == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        newNode.setNext(curr.getNext());
        newNode.setPrev(curr);

        if (curr.getNext() != null) {
            curr.getNext().setPrev(newNode);
        }

        curr.setNext(newNode);
    }
}
