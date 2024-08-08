package structures;

public class BubbleSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    var curr = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = curr;
                }
            }
        }
    }
}
