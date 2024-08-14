package tests;

import structures.BinaryTreeCompare;

public class TreeComparison {
    public static boolean compare() {
        if (BinaryTreeCompare.compare(Constants.tree, Constants.tree2)) {
            return false;
        }

        return BinaryTreeCompare.compare(Constants.tree, Constants.tree);
    }
}
