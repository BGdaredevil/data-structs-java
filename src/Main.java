import tests.BinarySearch;
import tests.LinearSearch;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        boolean result = Main.testBinarySearch();
//        boolean result = Main.testLinearSearch();
        boolean result = tests.CrystalBalls.testCrystalBalls();

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

}