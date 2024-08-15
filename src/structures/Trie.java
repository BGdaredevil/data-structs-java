package structures;

import tests.Timer;
import utils.TrieNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Trie {
    private final int normConstant = "a".codePointAt(0);
    private TrieNode<String> head = null;

    public Trie() {
        this.head = new TrieNode<>("");
    }

    public void insert(String item) {
        var timer = new Timer(String.format("Insert %s", item));
        TrieNode<String> curr = this.head;

        for (int i = 0; i < item.length(); i++) {
            String ch = Character.toString(item.charAt(i));
            int idx = this.getIdx(ch);
            TrieNode<String>[] currChildren = curr.getChildren();
            if (currChildren[idx] == null) {
                TrieNode<String> nodeToInsert = new TrieNode<>(ch);
                nodeToInsert.setParent(curr);
                currChildren[idx] = nodeToInsert;
            }

            curr = currChildren[idx];
            if (i == item.length() - 1) {
                curr.setWord(true);
            }
        }

        timer.end();
    }

    public void delete(String item) {
        var timer = new Timer(String.format("Delete %s", item));
        TrieNode<String> curr = this.head;
        if (curr == null) {
            timer.end();

            return;
        }

        for (int i = 0; i < item.length(); i++) {
            String ch = Character.toString(item.charAt(i));
            int idx = this.getIdx(ch);
            TrieNode<String> next = curr.getChildren()[idx];

            if (next == null) {
                timer.end();

                return;
            }

            curr = next;
        }

        if (curr.isWord()) {
            curr.setWord(false);
        }

        for (int i = item.length() - 1; i <= 0; i--) {
            String ch = Character.toString(item.charAt(i));
            int idx = this.getIdx(ch);
            TrieNode<String> parent = curr.getParent();

            if (parent == null) {
                timer.end();

                return;
            }

            boolean hasNonNullChildren = Arrays.stream(curr.getChildren()).anyMatch(Objects::nonNull);

            if (hasNonNullChildren) {
                continue;
            } else {
                parent.getChildren()[idx] = null;
            }

            curr = parent;
        }

        timer.end();
    }

    public String[] find(String partial) {
        var timer = new Timer(String.format("Find %s", partial));

        ArrayList<String> results = new ArrayList<>();
        TrieNode<String> curr = this.head;
        String[] out = new String[0];

        for (int i = 0; i < partial.length(); i++) {
            String ch = Character.toString(partial.charAt(i));
            int idx = this.getIdx(ch);
            TrieNode<String> next = curr.getChildren()[idx];

            if (next == null) {
                out = results.toArray(new String[0]);
                timer.end();

                return out;
            }

            curr = next;
        }

        if (curr == null) {
            out = results.toArray(new String[0]);
            timer.end();

            return out;
        }

        this.getWords(curr, results);

        out = results.toArray(new String[0]);
        timer.end();

        return out;
    }

    private String[] getWords(TrieNode<String> node, ArrayList<String> results) {
        if (node.isWord()) {
            results.add(node.getWord());
        }

        TrieNode<String>[] children = node.getChildren();

        for (int i = 0; i < children.length; i++) {
            TrieNode<String> curr = children[i];
            if (curr != null) {
                this.getWords(curr, results);
            }
        }

        return results.toArray(new String[0]);
    }

    private int getIdx(String str) {
        return str.codePointAt(0) - this.normConstant;
    }
}
