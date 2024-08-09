package tests;

import utils.CustomPoint;

import java.util.ArrayList;
import java.util.Arrays;

public class MazeSolver {
    public static boolean testMazeSolver() {
        String[] maze = {
                "xxxxxxxxxx x",
                "x        x x",
                "x        x x",
                "x xxxxxxxx x",
                "x          x",
                "x xxxxxxxxxx",
        };

        ArrayList<CustomPoint> expected = new ArrayList<>(Arrays.asList(
                new CustomPoint(10, 0),      // { x: 10, y: 0 },
                new CustomPoint(10, 1),      // { x: 10, y: 1 },
                new CustomPoint(10, 2),      // { x: 10, y: 2 },
                new CustomPoint(10, 3),      // { x: 10, y: 3 },
                new CustomPoint(10, 4),      // { x: 10, y: 4 },
                new CustomPoint(9, 4),      // { x: 9, y: 4 },
                new CustomPoint(8, 4),      // { x: 8, y: 4 },
                new CustomPoint(7, 4),      // { x: 7, y: 4 },
                new CustomPoint(6, 4),      // { x: 6, y: 4 },
                new CustomPoint(5, 4),      // { x: 5, y: 4 },
                new CustomPoint(4, 4),      // { x: 4, y: 4 },
                new CustomPoint(3, 4),      // { x: 3, y: 4 },
                new CustomPoint(2, 4),      // { x: 2, y: 4 },
                new CustomPoint(1, 4),      // { x: 1, y: 4 },
                new CustomPoint(1, 5))      // { x: 1, y: 5 },
        );

        ArrayList<CustomPoint> actual = structures.MazeSolver.solve(maze, "x", new CustomPoint(10, 0), new CustomPoint(1, 5));

        while (!expected.isEmpty()) {
            CustomPoint actualItem = actual.getFirst();
            CustomPoint expectedItem = expected.getFirst();

            if (actualItem.getX() != expectedItem.getX() || actualItem.getY() != actualItem.getY()) {
                return false;
            }

            actual.removeFirst();
            expected.removeFirst();
        }

        if (!actual.isEmpty()) {
            return false;
        }


        return true;
    }
}
