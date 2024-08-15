package tests;

import java.util.Arrays;

public class Trie {
    public static boolean testTrie() {
        structures.Trie trie = new structures.Trie();

        trie.insert("foo");
        trie.insert("fool");
        trie.insert("foolish");
        trie.insert("bar");

        String[] fooFind = Arrays.stream(trie.find("fo")).sorted().toArray(String[]::new);
        String[] expectedFooFind = {"foo", "fool", "foolish"};
        if (!Arrays.equals(fooFind, expectedFooFind)) {
            return false;
        }

        trie.delete("fool");
        String[] foolFind = Arrays.stream(trie.find("fo")).sorted().toArray(String[]::new);
        String[] expectedFoolFind = {"foo", "foolish"};

        return Arrays.equals(foolFind, expectedFoolFind);
    }
}
