package tests;

public class CustomMap {
    public static boolean customMap() {
        var timer = new Timer("CustomMap");
        structures.CustomMap<String, Integer> myMap = new structures.CustomMap<>();

        myMap.set("foo", 55);
        if (myMap.size() != 1) {
            timer.end();
            return false;
        }

        myMap.set("fool", 75);
        if (myMap.size() != 2) {
            timer.end();
            return false;
        }

        myMap.set("foolish", 105);
        if (myMap.size() != 3) {
            timer.end();
            return false;
        }

        myMap.set("bar", 69);
        if (myMap.size() != 4) {
            timer.end();
            return false;
        }

        if (myMap.get("bar") != 69) {
            timer.end();
            return false;
        }

        if (myMap.get("blaz") != null) {
            timer.end();
            return false;
        }

        myMap.delete("barblabr");
        if (myMap.size() != 4) {
            timer.end();
            return false;
        }

        myMap.delete("bar");
        if (myMap.size() != 3) {
            timer.end();
            return false;
        }

        var res = myMap.get("bar") == null;
        timer.end();

        return res;
    }
}
