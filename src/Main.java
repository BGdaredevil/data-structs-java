import tests.BinarySearch;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        boolean result = Main.testBinarySearch();

        if (result) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }
    }

    static boolean testBinarySearch() {
        var tests = new BinarySearch(new structures.BinarySearch());

        return tests.testTheSubject();
    }
}