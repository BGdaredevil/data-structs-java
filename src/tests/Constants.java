package tests;

import utils.BinaryNode;
import utils.GraphEdge;

public class Constants {
    public static int[] searchArr = {
            1, 3, 4, 69, 71, 81, 90, 99, 420, 1337, 69420
    };

    //     >(1)<--->(4) ---->(5)
    //    /          |       /|
    // (0)     ------|------- |
    //    \   v      v        v
    //     >(2) --> (3) <----(6)
    public static int[][] matrix = {
            {0, 3, 1, 0, 0, 0, 0}, // 0
            {0, 0, 0, 0, 1, 0, 0},
            {0, 0, 7, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 5, 0, 2, 0},
            {0, 0, 18, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0, 1},
    };

    //      (1) --- (4) ---- (5)
    //    /  |       |       /|
    // (0)   | ------|------- |
    //    \  |/      |        |
    //      (2) --- (3) ---- (6)
    public static GraphEdge[][] list1 = {
            {new GraphEdge(1, 3), new GraphEdge(2, 1)},
            {new GraphEdge(0, 3), new GraphEdge(2, 4), new GraphEdge(4, 1)},
            {new GraphEdge(1, 4), new GraphEdge(3, 7), new GraphEdge(0, 1)},
            {new GraphEdge(2, 7), new GraphEdge(4, 5), new GraphEdge(6, 1)},
            {new GraphEdge(1, 1), new GraphEdge(3, 5), new GraphEdge(5, 2)},
            {new GraphEdge(6, 1), new GraphEdge(4, 2), new GraphEdge(2, 18)},
            {new GraphEdge(3, 1), new GraphEdge(5, 1)},
    };

    //     >(1)<--->(4) ---->(5)
    //    /          |       /|
    // (0)     ------|------- |
    //    \   v      v        v
    //     >(2) --> (3) <----(6)
    public static GraphEdge[][] list2 = {
            {new GraphEdge(1, 3), new GraphEdge(2, 1)},
            {new GraphEdge(4, 1)},
            {new GraphEdge(3, 7)},
            {},
            {new GraphEdge(1, 1), new GraphEdge(3, 5), new GraphEdge(5, 2)},
            {new GraphEdge(2, 18), new GraphEdge(6, 1)},
            {new GraphEdge(3, 1)},
    };

    public static BinaryNode<Integer> tree2 = new BinaryNode<>(20,
            new BinaryNode<>(10,
                    new BinaryNode<>(5,
                            null,
                            new BinaryNode<>(7,
                                    null,
                                    null
                            )
                    ),
                    new BinaryNode<>(15,
                            null,
                            null
                    )
            ),
            new BinaryNode<>(50,
                    new BinaryNode<>(30,
                            new BinaryNode<>(29,
                                    new BinaryNode<>(21,
                                            null,
                                            null
                                    ),
                                    null
                            ),
                            new BinaryNode<>(45,
                                    null,
                                    new BinaryNode<>(49,
                                            null,
                                            null
                                    )
                            )
                    ),
                    null
            )
    );
    public static BinaryNode<Integer> tree = new BinaryNode<>(20,
            new BinaryNode<>(10,
                    new BinaryNode<>(5,
                            null,
                            new BinaryNode<>(7,
                                    null,
                                    null
                            )
                    ),
                    new BinaryNode<>(15,
                            null,
                            null
                    )
            ),
            new BinaryNode<>(50,
                    new BinaryNode<>(30,
                            new BinaryNode<>(29,
                                    null,
                                    null
                            ),
                            new BinaryNode<>(45,
                                    null,
                                    null
                            )
                    ),
                    new BinaryNode<>(100,
                            null,
                            null
                    )
            )
    );

}
