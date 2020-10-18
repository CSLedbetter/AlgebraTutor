
// CLASS:  H01_31
// AUTHOR: Casey Ledbetter, csledbet, csledbet@asu.edu
import java.util.ArrayList; // Import any required classes so your code will build

public class H01_31 { // Remember that class name and filename have to be the same. Case matters.

    public H01_31() { // Provide a default constructor. Some exercises may require other ctors.
    }

    // This is the method you are asked to write for Ex. 3.1. Name it exactly as
    // requested.
    public ArrayList<Integer> arrayListInit() {
        ArrayList<Integer> list = new ArrayList<>();
        int arrayNum = 0;
        while (arrayNum < 2) {
            for (int index = 0; index < 5; index++) {
                list.add(index);
            }
            arrayNum++;
        }
        return list;
    }
}