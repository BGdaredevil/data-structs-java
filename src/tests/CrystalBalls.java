package tests;

import java.util.Arrays;

public class CrystalBalls {
    public static boolean testCrystalBalls() {
        int randomIndex = (int) Math.floor(Math.random() * 10000);
        boolean[] dataOne = new boolean[10000];
        Arrays.fill(dataOne, false);
        boolean[] dataTwo = new boolean[10000];
        Arrays.fill(dataTwo, false);

        for (int i = randomIndex; i < dataOne.length; i++) {
            dataOne[i] = true;
        }

        int first = structures.CrystalBalls.find(dataOne);
        if (first != randomIndex) {
            System.out.printf("Find gave %d. Expected %d\n", first, randomIndex);
            return false;
        }

        int second = structures.CrystalBalls.find(dataTwo);
        if (second != -1) {
            System.out.printf("Find gave %d. Expected %d\n", first, randomIndex);
            return false;
        }

        System.out.println("testCrystalBalls passes");
        return true;
    }
}
