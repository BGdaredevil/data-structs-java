package tests;

import java.util.Arrays;

public class BubbleSort {
    public static boolean testBubbleSort() {
        int[] arrayToSort = {9, 3, 7, 4, 69, 420, 42};
        int[] expectedResult = {3, 4, 7, 9, 42, 69, 420};
        var timer = new Timer();

        structures.BubbleSort.sort(arrayToSort);
        timer.end();

        return Arrays.compare(arrayToSort, expectedResult) == 0;
    }
}
