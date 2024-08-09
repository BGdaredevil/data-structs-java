package tests;

import java.util.Objects;

public class Timer {
    String name;
    long startTime;

    long endTime;

    public Timer() {
        this("");
    }

    public Timer(String name) {
        this.name = name;
        this.startTime = System.nanoTime();
    }

    public void end() {
        this.endTime = System.nanoTime();
        double elapsed = (double) (this.endTime - this.startTime) / 1000000;
        String label = "";

        if (!Objects.equals(this.name, "")) {
            label = this.name + " ";
        }

        System.out.printf("%sRan: %.3f ms\n", label, elapsed);
    }

}
