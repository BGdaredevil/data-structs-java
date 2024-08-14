package structures;

import tests.Timer;
import utils.BinaryNode;

import java.util.Objects;

public class BinaryTreeDFS {

    public static <T extends Comparable<T>> boolean find(BinaryNode<T> head, T needle) {
        var timer = new Timer("BinaryTreeDFS");
        var result = dfs(head, needle);
        timer.end();

        return result;
    }

    private static <T extends Comparable<T>> boolean dfs(BinaryNode<T> head, T needle) {
        if (head == null) {
            return false;
        }

        if (head.getValue() == needle) {
            return true;
        }

        return head.getValue().compareTo(needle) < 0 ? dfs(head.getRight(), needle) : dfs(head.getLeft(), needle);
    }
}
