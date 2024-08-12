import structures.CustomArrayList;
import structures.DoublyLinkedList;
import structures.SinglyLinkedList;
import tests.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        boolean result = Main.testBinarySearch();
//        boolean result = Main.testLinearSearch();
//        boolean result = tests.CrystalBalls.testCrystalBalls();
//        boolean result = tests.BubbleSort.testBubbleSort();
//        boolean result = Main.testSinglyLinkedList();
//        boolean result = Main.testQueue();
//        boolean result = Main.testArrayList();
//        boolean result = Main.testRingBuffer();
//        boolean result = Main.testMazeSolver();
//        boolean result = Main.testQS();
        boolean result = Main.testDoublyLinkedList();

        if (result) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }

    }

    static boolean testLinearSearch() {
        return LinearSearch.linearlyFind();
    }
    static boolean testBinarySearch() {
        return (new BinarySearch(new structures.BinarySearch())).testTheSubject();
    }
    static boolean testSinglyLinkedList() {
        return CustomLinkedList.testLinkedList(new SinglyLinkedList<Integer>());
    }
    static boolean testDoublyLinkedList() {
        return CustomLinkedList.testLinkedList(new DoublyLinkedList<Integer>());
    }
    static boolean testArrayList() {
        return CustomLinkedList.testLinkedList(new CustomArrayList<Integer>());
    }
    static boolean testQueue() {
        return CustomQueue.testQueue(new structures.CustomQueue<Integer>());
    }
    static boolean testRingBuffer() {
        return RingBuffer.testRingBuffer(new structures.RingBuffer<Integer>());
    }
    static boolean testMazeSolver() {
        var timer = new Timer("testMazeSolver");
        var result = MazeSolver.testMazeSolver();
        timer.end();

        return result;
    }
    static boolean testQS() {
        return QuickSort.testSort();
    }
}