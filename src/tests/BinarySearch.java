package tests;

public class BinarySearch {
    private structures.BinarySearch testSubject = null;


    public BinarySearch(structures.BinarySearch testSubject) {
        this.testSubject = new structures.BinarySearch();
    }

    public boolean testTheSubject() {
        for (int i = 0; i < Constants.searchArr.length; i++) {
            int testValue = Constants.searchArr[i];

            if (!testSubject.find(Constants.searchArr, testValue)) {
                System.out.printf("test subject cannot find %d\n", testValue);
                return false;
            }
        }

        System.out.println("test subject works as expected");

        return true;
    }

}
