package utils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TrieNode<T> {
    private T value;
    private TrieNode<T> parent;
    private TrieNode<T>[] children;
    private boolean isWord;

    public TrieNode(T value) {
        this.value = value;
        this.children = (TrieNode<T>[]) Array.newInstance(getClass(), 26);
        Arrays.fill(this.children, null);
        this.isWord = false;
        this.parent = null;
    }

    public T getValue() {
        return this.value;
    }


    public TrieNode<T> getParent() {
        return this.parent;
    }

    public void setParent(TrieNode<T> parent) {
        this.parent = parent;
    }

    public TrieNode<T>[] getChildren() {
        return this.children;
    }


    public boolean isWord() {
        return this.isWord;
    }

    public void setWord(boolean word) {
        this.isWord = word;
    }

    public String getWord() {
        StringBuilder result = new StringBuilder();
        TrieNode<T> curr = this;

        while (curr != null) {
            result.append(curr.value);
            curr = curr.parent;
        }

        return result.reverse().toString();
    }

}
