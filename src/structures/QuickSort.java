package structures;

public class QuickSort {
    public static <T extends Comparable<T>> void sort(T[] arr) {
        int startIdx = 0;
        int endIdx = arr.length - 1;

        int idx = QuickSort.rearrange(arr, startIdx, endIdx);

        QuickSort.rearrange(arr, startIdx, idx - 1);
        QuickSort.rearrange(arr, idx + 1, endIdx);
    }

    private static <T extends Comparable<T>> int rearrange(T[] arr, int startIdx, int endIdx) {
        T pivot = arr[endIdx];
        int ptr = startIdx - 1;

        for (int i = startIdx; i < endIdx; i++) {
            if (arr[i].compareTo(pivot) <= 0) {
                ptr++;
                T temp = arr[i];
                arr[i] = arr[ptr];
                arr[ptr] = temp;
            }
        }

        ptr++;
        arr[endIdx] = arr[ptr];
        arr[ptr] = pivot;

        return ptr;
    }
}
