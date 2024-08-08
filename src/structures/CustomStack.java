package structures;

import org.jetbrains.annotations.Nullable;
import utils.SinglyLinkedNode;

public class CustomStack<T> {
    private int length = 0;
    private SinglyLinkedNode<T> head = null;

    public CustomStack() {
        this.length = 0;
        this.head = null;
    }

    public int getLength() {
        return this.length;
    }

    public void push(T item) {
        var node = new SinglyLinkedNode<T>(item);
        this.length++;
//            if (this.head == null) {
//                this.head = node;
//                return;
//            }

        node.setNext(this.head);
        this.head = node;
    }

    @Nullable
    public T pop() {
        if (this.head == null) {
            return null;
        }

        T result = this.head.getValue();
        this.length--;

        if (this.head != null) {
            this.head = this.head.getNext();
        }

        return result;
    }

    @Nullable
    public T peek() {
        return this.head.getValue();
    }

//    public length: number;
//    private head?: Node<T>;
//
//    constructor() {
//        this.head = undefined;
//        this.length = 0;
//    }
//
//    push(item: T): void {
//        const node = new Node(item);
//        this.length++;
//
//        if (!this.head) {
//            this.head = node;
//
//            return;
//        }
//
//        node.next = this.head;
//        this.head = node;
//    }
//
//    pop(): T | undefined {
//        if (!this.head) {
//            return;
//        }
//
//        const item = this.head;
//        this.head = this.head?.next;
//        this.length--;
//
//        return item.value;
//    }
//
//    peek(): T | undefined {
//        return this.head?.value;
//    }
}
