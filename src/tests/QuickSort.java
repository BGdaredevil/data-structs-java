package tests;

public class QuickSort {
    public static boolean testSort() {
        Integer[] testArr = {9, 3, 7, 4, 69, 420, 42};
        Integer[] expected = {3, 4, 7, 9, 42, 69, 420};

        var timer = new Timer("Quick Sort");
        structures.QuickSort.sort(testArr);
        timer.end();

        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(testArr[i])) {
                return false;
            }
        }

        return true;
    }

}
