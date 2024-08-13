package tests;

import structures.BinaryTreeTraverse;

public class BinaryTreeBFS {
    public static boolean testBTBFS() {
        if (!structures.BinaryTreeBFS.find(Constants.tree, 45)) {
            return false;
        }
        if (!structures.BinaryTreeBFS.find(Constants.tree, 7)) {
            return false;
        }

        return !structures.BinaryTreeBFS.find(Constants.tree, 69);
    }
}
