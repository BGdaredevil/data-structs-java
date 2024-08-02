package structures;

public class LinearSearch {
    public static boolean find(int[] haystack, int needle) {
        boolean result = false;

        for (int i = 0; i < haystack.length; i++) {
            if (haystack[i] == needle) {
                result = true;
                return result;
            }
        }

        return result;
    }
}
