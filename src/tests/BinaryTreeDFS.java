package tests;

public class BinaryTreeDFS {
    public static boolean testTreeDFS() {
        if (!structures.BinaryTreeDFS.find(Constants.tree, 45)) {
            return false;
        }

        if (!structures.BinaryTreeDFS.find(Constants.tree, 7)) {
            return false;
        }

        return !structures.BinaryTreeDFS.find(Constants.tree, 69);
    }
}
