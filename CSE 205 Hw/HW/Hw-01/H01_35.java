
// CLASS:  H01_35
// AUTHOR: Casey Ledbetter, csledbet, csledbet@asu.edu
import java.util.ArrayList; // Import any required classes so your code will build

public class H01_35 { // Remember that class name and filename have to be the same. Case matters.

    public H01_35() { // Provide a default constructor. Some exercises may require other ctors.
    }

    public ArrayList<Integer> arrayListCreate(int pLen, int pInitValue) {
        ArrayList<Integer> create = new ArrayList<>();
        for (int i = 0; i < pLen; i++) {
            create.add(pInitValue);
        }
        return create;
    }
}