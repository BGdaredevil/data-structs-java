package tests;

import java.util.Arrays;

public class GraphBFS {
    public static boolean matrixBFS() {
        Integer[] expected = {0,1,4,5,6};
        Integer[] actual = structures.GraphBFS.matrixBFS(Constants.matrix, 0, 6);
        boolean findsPath = Arrays.equals(expected, actual);

        if (!findsPath) {
            return false;
        }

        Integer[]  res = structures.GraphBFS.matrixBFS(Constants.matrix, 6, 0);

        return res == null;
    }
    public static boolean listBFS() {
        Integer[] expected = {0,1,4,5,6};
        Integer[] actual = structures.GraphBFS.listBFS(Constants.list2, 0, 6);
        boolean findsPath = Arrays.equals(expected, actual);

        if (!findsPath) {
            return false;
        }

        Integer[]  res = structures.GraphBFS.listBFS(Constants.list2, 6, 0);

        return res == null;
    }

}
