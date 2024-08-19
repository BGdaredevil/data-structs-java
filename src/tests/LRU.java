package tests;

public class LRU {
    public static boolean runLRUTest() {
        var timer = new Timer("LRU");
        var lru = new structures.LRU<String, Integer>(3);

        if (lru.get("foo") != null) {
            return false;
        }

        lru.update("foo", 69);
        if (lru.get("foo") != 69) {
            return false;
        }

        lru.update("bar", 420);
        if (lru.get("bar") != 420) {
            return false;
        }

        lru.update("baz", 1337);
        if (lru.get("baz") != 1337) {
            return false;
        }

        lru.update("ball", 69420);

        if (lru.get("ball") != 69420) {
            return false;
        }

        if (lru.get("foo") != null) {
            return false;
        }

        if (lru.get("bar") != 420) {
            return false;
        }

        lru.update("foo", 69);

        if (lru.get("bar") != 420) {
            return false;
        }

        if (lru.get("foo") != 69) {
            return false;
        }

        if (lru.get("baz") != null) {
            return false;
        }

        timer.end();
        return true;
    }
}
