package tests;

import interfaces.CustomList;

public class CustomLinkedList {
    public static boolean testLinkedList(CustomList<Integer> list) {
        var timer = new Timer("list.append(5)");
        list.append(5);
        timer.end();

        timer = new Timer("list.append(7)");
        list.append(7);
        timer.end();

        timer = new Timer("list.append(9)");
        list.append(9);
        timer.end();

        timer = new Timer("list.get(2)");
        if (list.get(2) != 9) {
            return false;
        }
        timer.end();

        timer = new Timer("list.removeAt(1)");
        if (list.removeAt(1) != 7) {
            return false;
        }
        timer.end();

        timer = new Timer("list.length()");
        if (list.length() != 2) {
            return false;
        }
        timer.end();

        timer = new Timer("list.append(11)");
        list.append(11);
        timer.end();

        timer = new Timer("list.removeAt(1)");
        if (list.removeAt(1) != 9) {
            return false;
        }
        timer.end();

        timer = new Timer("list.remove(9)");
        if (list.remove(9) != null) {
            return false;
        }
        timer.end();

        timer = new Timer("list.removeAt(0)");
        if (list.removeAt(0) != 5) {
            return false;
        }
        timer.end();

        timer = new Timer("list.removeAt(0)");
        if (list.removeAt(0) != 11) {
            return false;
        }
        timer.end();

        timer = new Timer("list.length() != 0");
        if (list.length() != 0) {
            return false;
        }
        timer.end();

        timer = new Timer("list.prepend(5)");
        list.prepend(5);
        timer.end();

        timer = new Timer("list.prepend(7)");
        list.prepend(7);
        timer.end();

        timer = new Timer("list.prepend(9)");
        list.prepend(9);
        timer.end();

        timer = new Timer("list.get(2)");
        if (list.get(2) != 5) {
            return false;
        }
        timer.end();

        timer = new Timer("list.get(0)");
        if (list.get(0) != 9) {
            return false;
        }
        timer.end();

        timer = new Timer("list.remove(9)");
        if (list.remove(9) != 9) {
            return false;
        }
        timer.end();

        timer = new Timer("list.length()");
        if (list.length() != 2) {
            return false;
        }
        timer.end();

        timer = new Timer("list.get(0)");
        if (list.get(0) != 7) {
            return false;
        }
        timer.end();

        return true;
    }
}
