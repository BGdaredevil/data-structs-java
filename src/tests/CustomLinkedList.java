package tests;

import interfaces.CustomList;

public class CustomLinkedList {
    public static boolean testLinkedList(CustomList<Integer> list) {
        var timer = new Timer();
        list.append(5);
        list.append(7);
        list.append(9);

        if (list.get(2) != 9) {
            return false;
        }
        if (list.removeAt(1) != 7) {
            return false;
        }
        if (list.length() != 2) {
            return false;
        }

        list.append(11);
        if (list.removeAt(1) != 9) {
            return false;
        }
        if (list.remove(9) != null) {
            return false;
        }
        if (list.removeAt(0) != 5) {
            return false;
        }
        if (list.removeAt(0) != 11) {
            return false;
        }
        if (list.length() != 0) {
            return false;
        }

        list.prepend(5);
        list.prepend(7);
        list.prepend(9);
        if (list.get(2) != 5) {
            return false;
        }
        if (list.get(0) != 9) {
            return false;
        }
        if (list.remove(9) != 9) {
            return false;
        }
        if (list.length() != 2) {
            return false;
        }
        if (list.get(0) != 7) {
            return false;
        }
        timer.end();
        return true;
    }
}
