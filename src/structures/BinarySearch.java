package structures;

public class BinarySearch {

    public boolean find(int[] haystack, int needle) {
        int hiIndex = haystack.length;
        int loIdx = 0;

        while (loIdx < hiIndex) {
            int protoMedian = loIdx + (hiIndex - loIdx) / 2;
            int value = haystack[protoMedian];

            if (value == needle) {
                return true;
            }

            if (value < needle) {
                loIdx = protoMedian + 1;
                continue;
            }

            hiIndex = protoMedian;
        }

        return false;
    }
}
