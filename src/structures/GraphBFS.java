package structures;

import org.jetbrains.annotations.Nullable;
import tests.Timer;
import utils.GraphEdge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class GraphBFS {
    @Nullable
    public static Integer[] matrixBFS(int[][] graph, int start, int needle) {
        var timer = new Timer("matrixBFS");
        Boolean[] seen = new Boolean[graph.length];
        Arrays.fill(seen, false);
        Integer[] path = new Integer[graph.length];
        Arrays.fill(path, -1);
//        CustomQueue<Integer> que = new CustomQueue<>(); // works but 2ms slower
        ArrayList<Integer> que = new ArrayList<>();
//        que.enqueue(start);
        que.add(start);
        seen[start] = true;

        do {
//            var curr = que.deque();
            var curr = que.removeFirst();

            if (curr == needle) {
                break;
            }

            int[] edges = graph[curr];
            for (int i = 0; i < edges.length; i++) {
                if (edges[i] == 0) {
                    continue;
                }

                if (seen[i]) {
                    continue;
                }

                seen[i] = true;
                path[i] = curr;

//                que.enqueue(i);
                que.add(i);
            }

            seen[curr] = true;
//        } while (que.getLength() > 0);
        } while (!que.isEmpty());

        int point = needle;
        ArrayList<Integer> result = new ArrayList<>();

        if (path[point] == -1) {
            timer.end();
            return null;
        }

        while (path[point] != -1) {
            result.add(point);
            point = path[point];
        }

        result.add(start);
        Integer[] out = result.reversed().toArray(Integer[]::new);
        timer.end();

        return out;
    }

    @Nullable
    public static Integer[] listBFS(GraphEdge[][] graph, int start, int needle) {
        var timer = new Timer("listBFS");
        Boolean[] seen = new Boolean[graph.length];
        Arrays.fill(seen, false);
        Integer[] path = new Integer[graph.length];
        Arrays.fill(path, -1);
        ArrayList<Integer> que = new ArrayList<>();
        que.add(start);
        seen[start] = true;

        do {
            var currentNode = que.removeFirst();
            if (currentNode == needle) {
                break;
            }

            var connectedNodes = graph[currentNode];

            for (int i = 0; i < connectedNodes.length; i++) {
                var node = connectedNodes[i];
                if (seen[node.to]) {
                    continue;
                }

                path[node.to] = currentNode;
                seen[node.to] = true;
                que.add(node.to);
            }

            seen[currentNode] = true;
        } while (!que.isEmpty());

        int point = needle;
        ArrayList<Integer> result = new ArrayList<>();

        if (path[point] == -1) {
            timer.end();
            return null;
        }

        while (path[point] != -1) {
            result.add(point);
            point = path[point];
        }

        result.add(start);
        Integer[] out = result.reversed().toArray(Integer[]::new);
        timer.end();

        return out;
    }

    @Nullable
    public static Integer[] listDFS(GraphEdge[][] graph, int start, int needle) {
        var timer = new Timer("listDFS");
        Boolean[] seen = new Boolean[graph.length];
        Arrays.fill(seen, false);
        ArrayList<Integer> path = new ArrayList<>();
        boolean foundPath = GraphBFS.walk(graph, start, needle, seen, path);
        var out = foundPath ? path.toArray(Integer[]::new) : null;
        timer.end();

        return out;
    }

    private static boolean walk(GraphEdge[][] graph, int node, int needle, Boolean[] seen, ArrayList<Integer> path) {
        if (seen[node]) {
            return false;
        }

        seen[node] = true;
        path.add(node);
        if (node == needle) {
            return true;
        }

        var reachableNodes = graph[node];
        for (int i = 0; i < reachableNodes.length; i++) {
            var currNode = reachableNodes[i];
            if (GraphBFS.walk(graph, currNode.to, needle, seen, path)) {
                return true;
            }
        }

        path.removeLast();

        return false;
    }

    @Nullable
    public static Integer[] listDijkstraShortestPath(int start, int end, GraphEdge[][] graph) {
        var timer = new Timer("listDijkstraShortestPath");

        Boolean[] seen = new Boolean[graph.length];
        Integer[] distances = new Integer[graph.length];
        Integer[] path = new Integer[graph.length];

        Arrays.fill(seen, false);
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(path, -1);

        distances[start] = 0;

        while (hasUnvisited(seen, distances)) {
            int lo = getClosestUnvisited(seen, distances);
            seen[lo] = true;
            GraphEdge[] visibleNodes = graph[lo];
            for (int i = 0; i < visibleNodes.length; i++) {
                var node = visibleNodes[i];
                if (seen[node.to]) {
                    continue;
                }

                int newDist = distances[lo] + node.weight;
                if (newDist < distances[node.to]) {
                    path[node.to] = lo;
                    distances[node.to] = newDist;
                }
            }
        }

        int point = end;
        ArrayList<Integer> result = new ArrayList<>();

        if (path[point] == -1) {
            timer.end();
            return null;
        }

        while (path[point] != -1) {
            result.add(point);
            point = path[point];
        }

        result.add(start);
        Integer[] out = result.reversed().toArray(Integer[]::new);
        timer.end();

        return out;
    }

    private static int getClosestUnvisited(Boolean[] seen, Integer[] dists) {
        int distance = Integer.MAX_VALUE;
        int loIdx = -1;

        for (int i = 0; i < seen.length; i++) {
            if (seen[i]) {
                continue;
            }

            if (dists[i] < Integer.MAX_VALUE && distance > dists[i]) {
                distance = dists[i];
                loIdx = i;
            }
        }

        return loIdx;
    }

    private static boolean hasUnvisited(Boolean[] seen, Integer[] dists) {
        boolean res = false;
        for (int i = 0; i < seen.length; i++) {
            if (!seen[i] && dists[i] < Integer.MAX_VALUE) {
                res = true;
                return res;
            }
        }

        return res;
    }
}
