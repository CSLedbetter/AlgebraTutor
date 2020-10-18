public class H03_31_Test {
    // Declare an instance of the class under test (CUT). 
    private H03_31 mCut;
    public static void main(String[] pArgs) {
        new H03_31_Test().run();
    }

    private void run() {
    // Instantiate an object of the class under test (CUT), i.e., an instance of H03_31. 
    mCut = new H03_31();
    // Write statements to perform a test case for a few different values of n. Before // you even attempt to compile this code and test your class, use Wolfram Alpha to // determine the correct sum for each value of n. To compute the sum of the integers // from 1 to n in Wolfram Alpha, enter the command: sum 1 to n
               performTestCase(1, 1, 1);
               performTestCase(2, 2, 3);
               performTestCase(3, 10, 55);
               //... And so on for a few other values of n. Make sure to try n = 65535.
    }

    private void performTestCase(int pTestCaseNum, int pN, int pExpectedSum) {
        printTestCaseInfo(pTestCaseNum, pN, pExpectedSum);
        int actualSum = mCut.sum1toN(pN);
        if (actualSum == pExpectedSum)
            System.out.println("passed\n");
        else
            System.out.println("failed\n");
    }

    private void printTestCaseInfo(int pTestCaseNum, int pN, int pExpectedSum) {
        System.out.println("Test Case Number " + pTestCaseNum);
        System.out.print("n = " + n + ", expected sum = " + pExpectedSum + " ==> ");
    }
}