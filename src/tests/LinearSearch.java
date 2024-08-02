package tests;

public class LinearSearch {
    public static boolean linearlyFind() {
        for (int i = 0; i < Constants.searchArr.length; i++) {
            int testValue = Constants.searchArr[i];

            if (!structures.LinearSearch.find(Constants.searchArr, testValue)) {
                System.out.printf("test subject cannot find %d\n", testValue);
                return false;
            }
        }

        System.out.println("test subject works as expected");
        return true;
    }
}
