package structures;

import tests.Timer;
import utils.BinaryNode;

public class BinaryTreeCompare {
    public static <T> boolean compare(BinaryNode<T> first, BinaryNode<T> second) {
        var timer = new Timer("tree compare");
        boolean result = makeCompare(first, second);
        timer.end();

        return result;
    }

    private static <T> boolean makeCompare(BinaryNode<T> first, BinaryNode<T> second) {
        if (first == null && second == null) {
            return true;
        }

        if (first == null || second == null) {
            return false;
        }

        if (first.getValue() != second.getValue()) {
            return false;
        }

        return BinaryTreeCompare.makeCompare(first.getLeft(), second.getLeft()) && BinaryTreeCompare.makeCompare(first.getRight(), second.getRight());

    }
}
