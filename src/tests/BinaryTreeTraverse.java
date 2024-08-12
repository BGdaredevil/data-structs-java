package tests;

public class BinaryTreeTraverse {
    public static boolean btInOrder() {
        int[] expected = {5, 7, 10, 15, 20, 29, 30, 45, 50, 100};
        int[] actual = structures.BinaryTreeTraverse.btInOrder(Constants.tree);

        return BinaryTreeTraverse.compareArr(expected, actual);
    }

    public static boolean btPreOrder() {
        int[] expected = {20, 10, 5, 7, 15, 50, 30, 29, 45, 100};
        int[] actual = structures.BinaryTreeTraverse.btPreOrder(Constants.tree);

        return BinaryTreeTraverse.compareArr(expected, actual);
    }

    public static boolean btPostOrder() {
        int[] expected = {7, 5, 15, 10, 29, 45, 30, 100, 50, 20};
        int[] actual = structures.BinaryTreeTraverse.btPostOrder(Constants.tree);

        return BinaryTreeTraverse.compareArr(expected, actual);
    }

    private static boolean compareArr(int[] expected, int[] actual) {
        if (actual.length != expected.length) {
            return false;
        }

        for (int i = 0; i < expected.length; i++) {
            int exp = expected[i];
            int act = actual[i];

            if (exp != act) {
                return false;
            }

        }

        return true;
    }
}
