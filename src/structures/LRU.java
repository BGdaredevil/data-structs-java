package structures;

import org.jetbrains.annotations.Nullable;
import utils.DoublyLinkedNode;

import java.util.HashMap;
import java.util.Objects;

public class LRU<K, V> {
    private int capacity;
    private int length;
    private DoublyLinkedNode<V> head;
    private DoublyLinkedNode<V> tail;
    private HashMap<K, DoublyLinkedNode<V>> lookup;
    private HashMap<DoublyLinkedNode<V>, K> reverseLookup;

    public LRU() {
        this(10);
    }

    public LRU(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.head = null;
        this.tail = null;
        this.lookup = new HashMap<>();
        this.reverseLookup = new HashMap<>();
    }

    @Nullable
    public V get(K key) {
        var item = this.lookup.get(key);
        if (item == null) {
            return null;
        }

        if (Objects.equals(this.head, item)) {
            return item.getValue();
        }

        this.detatch(item);
        this.prepend(item);

        return item.getValue();
    }

    public void update(K key, V value) {
        var item = this.lookup.get(key);
        if (item != null) {
            item.setValue(value);
            this.detatch(item);
            this.prepend(item);
        } else {
            var newItem = new DoublyLinkedNode<>(value);
            this.length++;
            this.prepend(newItem);
            this.lookup.put(key, newItem);
            this.reverseLookup.put(newItem, key);
            this.removeLast();
        }
    }

    private void prepend(DoublyLinkedNode<V> node) {
        if (this.head == null) {
            this.head = this.tail = node;

            return;
        }

        node.setNext(this.head);
        this.head.setPrev(node);

        this.head = node;
    }

    private void detatch(DoublyLinkedNode<V> node) {
        if (node.getPrev() != null) {
            node.getPrev().setNext(node.getNext());
        }

        if (node.getNext() != null) {
            node.getNext().setPrev(node.getPrev());
        }

        if (Objects.equals(this.head, node)) {
            this.head = this.head.getNext();
        }

        if (Objects.equals(this.tail, node)) {
            this.tail = this.tail.getPrev();
        }

        node.setNext(null);
        node.setPrev(null);
    }

    private void removeLast() {
        if (this.length <= this.capacity) {
            return;
        }

        var last = this.tail;
        this.detatch(last);
        var lastKey = this.reverseLookup.get(last);
        this.lookup.remove(lastKey);
        this.reverseLookup.remove(last);

        this.length--;
    }

}
