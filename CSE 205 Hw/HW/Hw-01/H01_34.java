
// CLASS:  H01_34
// AUTHOR: Casey Ledbetter, csledbet, csledbet@asu.edu
import java.util.ArrayList;

public class H01_34 {

    public H01_34() { // Provide a default constructor. Some exercises may require other ctors.
    }

    public Integer arrayListSum(ArrayList<Integer> pList) {
        int sum = 0;
        ArrayList<Integer> test = pList;
        for (int index = 0; index < test.size(); index++) {
            sum += test.get(index);
        }
        return sum;
    }
}
