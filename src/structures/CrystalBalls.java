package structures;

public class CrystalBalls {
    public static int find(boolean[] breaks) {
        double jump = Math.sqrt(breaks.length);
        int lo = 0;

        while (lo < breaks.length) {
            int curr = Double.valueOf(Math.floor(lo + jump)).intValue();


            if (curr< breaks.length && breaks[curr]) {
                for (int i = lo; i < curr; i++) {
                    if (breaks[i]) {
                        return i;
                    }
                }
            }

            lo = curr;
        }

        return -1;
    }
}
