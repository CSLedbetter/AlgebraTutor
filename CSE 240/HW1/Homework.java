/**
 * This the first Homework assignment for CSE 240. It calculates the factorial
 * of a number and modifies arrays by either changing the even and odd positions
 * or puts them in acending order.
 * 
 * Completion time: 1 hours
 *
 * @author Casey Ledbetter
 * @version (version)
 */

public class Homework {
    // "b" in odd positions, "a" in even
    public static void initializeArray(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 != 0) {
                arr[i] = 'b';
            } else {
                arr[i] = 'a';
            }
        }
    }

    // prints the array to the terminal
    public static void printArray(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i == arr.length - 1) {
                System.out.println();
            } else {
                System.out.print(", ");
            }
        }
    }

    public static void selectionSort(char[] arr) {
        int minIndex;
        char temp;

        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = minIndex + 1; j < arr.length; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;

            temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static int factorial(int num) {
        if (num <= 2) {
            return num;
        }
        return num * factorial(num - 1);
    }

    public static void main(String[] arg) {
        char[] a = { 'a', 'b', 'c', 'd', 'x', 'y', '1', '2', '3', '4' };
        char[] b = { 'p', 'q', '9', '8', '7', '6' };
        int[] c = { 6, 0, 1 };
        // Testing initializeArray
        printArray(a);
        initializeArray(a);
        printArray(a);
        // Testing selectionSort
        printArray(b);
        selectionSort(b);
        printArray(b);
        // Testing factorial
        System.out.println(factorial(5));
        System.out.println(factorial(c[0]));
        System.out.println(factorial(c[2]));
    }
}