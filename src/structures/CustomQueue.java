package structures;

import org.jetbrains.annotations.Nullable;
import utils.SinglyLinkedNode;

public class CustomQueue<T> {
    private int length;
    private SinglyLinkedNode<T> head = null;

    public int getLength() {
        return this.length;
    }

    private SinglyLinkedNode<T> tail = null;

    public CustomQueue() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void enqueue(T item) {
        var node = new SinglyLinkedNode<T>(item);

        if (this.length == 0) {
            this.head = node;
            this.tail = node;
            this.length++;

            return;
        }

        this.tail.setNext(node);
        this.tail = node;
        this.length++;
    }

    @Nullable
    public T deque() {
        if (this.head == null) {
            return null;
        }

        var node = this.head;
        this.head = this.head.getNext();

        this.length--;
        if (this.length == 0) {
            this.tail = null;
        }

        return node.getValue();

    }

    @Nullable
    public T peek() {
        return this.head.getValue();
    }

}
