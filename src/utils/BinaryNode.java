package utils;

import org.jetbrains.annotations.Nullable;

public class BinaryNode<T> {
    private T value = null;

    private BinaryNode<T> left = null;
    private BinaryNode<T> right = null;

    public BinaryNode() {
        this(null, null, null);
    }

    public BinaryNode(T value) {
        this(value, null, null);
    }

    public BinaryNode(T value, BinaryNode<T> left) {
        this(value, left, null);
    }

    public BinaryNode(T value, BinaryNode<T> left, BinaryNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    @Nullable
    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    @Nullable
    public BinaryNode<T> getLeft() {
        return this.left;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }
    @Nullable
    public BinaryNode<T> getRight() {
        return this.right;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }
}
