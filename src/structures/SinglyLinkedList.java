package structures;

import interfaces.CustomList;
import org.jetbrains.annotations.Nullable;
import utils.SinglyLinkedNode;

public class SinglyLinkedList<T> implements CustomList<T> {
    private SinglyLinkedNode<T> head = null;
    protected int length = 0;

    public SinglyLinkedList() {
        this.head = null;
        this.length = 0;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public T removeAt(int idx) {
        if (idx >= this.length || idx < 0) {
            return null;
        }

        SinglyLinkedNode<T> curr = this.head;

        if (curr == null) {
            return null;
        }

        if (idx == 0) {
            this.head = curr.getNext();
            this.length--;

            return curr.getValue();
        }

        while (idx > 1) {
            curr = curr.getNext();
            idx--;
        }

        var node = curr.getNext();
        curr.setNext(node.getNext());

        this.length--;

        return node.getValue();
    }

    @Override
    public T remove(T item) {
        boolean found = false;
        SinglyLinkedNode<T> prev = this.head;
        SinglyLinkedNode<T> curr = this.head;

        while (curr.getNext() != null) {
            T currVal = curr.getValue();

            if (currVal == item) {
                found = true;
                break;
            } else {
                prev = curr;
                curr = curr.getNext();
            }
        }

        if (!found) {
            return null;
        }

        if (prev != null) {
            prev.setNext(curr.getNext());
        }

        if (curr == this.head) {
            this.head = curr.getNext();
        }

        this.length--;

        return curr.getValue();

    }

    @Override
    public T get(int idx) {
        if (idx >= this.length || idx < 0) {
            return null;
        }

        SinglyLinkedNode<T> curr = this.head;

        if (curr == null) {
            return null;
        }

        while (idx > 0) {
            curr = curr.getNext();
            idx--;
        }

        return curr.getValue();
    }

    @Override
    public void prepend(T item) {
        this.head = new SinglyLinkedNode<T>(item, this.head);
        this.length++;
    }

    @Override
    public void append(T item) {
        SinglyLinkedNode<T> newNode = new SinglyLinkedNode<>(item);
        SinglyLinkedNode<T> current = this.head;
        this.length++;

        if (current == null) {
            this.head = newNode;
            return;
        }

        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(newNode);
    }

    @Override
    public void insertAt(T item, int idx) {
        if (idx < 0 || idx >= this.length) {
            return;
        }

        SinglyLinkedNode<T> newNode = new SinglyLinkedNode<>(item);
        this.length++;

        int currIdx = idx;
        SinglyLinkedNode<T> curr = this.head;

        while (currIdx > 1) {
            curr = curr.getNext();
            currIdx--;
        }

        if (curr == null) {
            this.head = newNode;
            return;
        }

        SinglyLinkedNode<T> currNext = curr.getNext();
        curr.setNext(newNode);
        newNode.setNext(currNext);
    }
}
