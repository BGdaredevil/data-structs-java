package tests;

public class CustomStack {
    public static boolean testCustomStack(structures.CustomStack<Integer> stack) {

        stack.push(5);
        stack.push(7);
        stack.push(9);

        if (stack.pop() != 9) {
            return false;
        }
        if (stack.getLength() != 2) {
            return false;
        }

        stack.push(11);

        if (stack.pop() != 11) {
            return false;
        }
        if (stack.pop() != 7) {
            return false;
        }
        if (stack.peek() != 5) {
            return false;
        }
        if (stack.pop() != 5) {
            return false;
        }
        if (stack.pop() != null) {
            return false;
        }

        stack.push(69);
        if (stack.peek() != 69) {
            return false;
        }
        if (stack.getLength() != 1) {
            return false;
        }

        return true;
    }
}
