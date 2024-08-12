package structures;

import tests.Timer;
import utils.BinaryNode;

import java.util.ArrayList;

public class BinaryTreeTraverse {
    public static int[] btInOrder(BinaryNode<Integer> tree) {
        ArrayList<Integer> results = new ArrayList<>();

        var timer = new Timer("btInOrder");
        BinaryTreeTraverse.traverseInOrder(results, tree);
        timer.end();

        return results.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void traverseInOrder(ArrayList<Integer> results, BinaryNode<Integer> node) {
        if (node == null) {
            return;
        }

        BinaryTreeTraverse.traverseInOrder(results, node.getLeft());
        BinaryTreeTraverse.visitNode(results, node);
        BinaryTreeTraverse.traverseInOrder(results, node.getRight());
    }

    public static int[] btPreOrder(BinaryNode<Integer> tree) {
        ArrayList<Integer> results = new ArrayList<>();

        var timer = new Timer("btPreOrder");
        BinaryTreeTraverse.traversePreOrder(results, tree);
        timer.end();

        return results.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void traversePreOrder(ArrayList<Integer> results, BinaryNode<Integer> node) {
        if (node == null) {
            return;
        }

        BinaryTreeTraverse.visitNode(results, node);
        BinaryTreeTraverse.traversePreOrder(results, node.getLeft());
        BinaryTreeTraverse.traversePreOrder(results, node.getRight());
    }

    public static int[] btPostOrder(BinaryNode<Integer> tree) {
        ArrayList<Integer> results = new ArrayList<>();

        var timer = new Timer("btPostOrder");
        BinaryTreeTraverse.traversePostOrder(results, tree);
        timer.end();

        return results.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void traversePostOrder(ArrayList<Integer> results, BinaryNode<Integer> node) {
        if (node == null) {
            return;
        }

        BinaryTreeTraverse.traversePostOrder(results, node.getLeft());
        BinaryTreeTraverse.traversePostOrder(results, node.getRight());
        BinaryTreeTraverse.visitNode(results, node);
    }

    private static void visitNode(ArrayList<Integer> results, BinaryNode<Integer> node) {
        results.add(node.getValue());
    }
}
