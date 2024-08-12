package tests;

import utils.BinaryNode;

public class Constants {
    public static int[] searchArr = {
            1, 3, 4, 69, 71, 81, 90, 99, 420, 1337, 69420
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
