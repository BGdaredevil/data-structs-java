package structures;

import tests.Timer;
import utils.BinaryNode;

public class BinaryTreeBFS {
    public static <T> boolean find(BinaryNode<T> tree, T needle) {
        var timer = new Timer("BTBFS");
        CustomQueue<BinaryNode<T>> que = new CustomQueue<>();

        que.enqueue(tree);

        while (que.getLength() > 0) {
            BinaryNode<T> curr = que.deque();

            if (curr == null || curr.getValue() == null) {
                continue;
            }

            if (curr.getValue().equals(needle)) {
                timer.end();
                return true;
            }

            que.enqueue(curr.getLeft());
            que.enqueue(curr.getRight());
        }

        timer.end();
        return false;
    }
}
