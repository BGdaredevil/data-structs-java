package structures;

import utils.CustomPoint;

import java.util.ArrayList;
import java.util.Arrays;

public class MazeSolver {

    private static int[][] directions = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1},
    };

    public static ArrayList<CustomPoint> solve(String[] maze, String wall, CustomPoint start, CustomPoint end) {
        ArrayList<CustomPoint> result = new ArrayList<>();
        boolean[][] seen = new boolean[maze.length][maze[0].length()];

        for (boolean[] booleans : seen) {
            Arrays.fill(booleans, false);
        }

        MazeSolver.walk(maze, seen, wall, start, end, result);

        return result;
    }

    private static boolean walk(String[] maze, boolean[][] seen, String wall, CustomPoint curr, CustomPoint end, ArrayList<CustomPoint> result) {
        if (curr.getY() < 0 || curr.getY() >= maze.length) {
            return false;
        }

        if (curr.getX() < 0 || curr.getX() >= maze[curr.getY()].length()) {
            return false;
        }

        String myLoc = maze[curr.getY()].split("")[curr.getX()];

        if (myLoc.equals(wall)) {
            return false;
        }

        if (curr.getX() == end.getX() && curr.getY() == end.getY()) {
            result.add(curr);
            return true;
        }

        if (seen[curr.getY()][curr.getX()]) {
            return false;
        }
        seen[curr.getY()][curr.getX()] = true;
        result.add(curr);

        for (int i = 0; i < MazeSolver.directions.length; i++) {
            int[] dir = MazeSolver.directions[i];
            CustomPoint next = new CustomPoint(dir[0] + curr.getX(), dir[1] + curr.getY());

            if (MazeSolver.walk(maze, seen, wall, next, end, result)) {
                return true;
            }
        }

        result.removeLast();

        return false;
    }
}
