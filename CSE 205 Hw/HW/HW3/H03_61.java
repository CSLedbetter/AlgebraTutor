
// CLASS: H03_61 (Source Code File: H03_61.java)
// AUTHOR: Casey Ledbetter, csledbet, csledbet@asu.edu
import java.util.ArrayList;
import java.util.List;

public class H03_61 {

    public static int recLinearSearch(ArrayList<String> pList, String pKey, int pBeginIdx, int pEndIdx) {
        if (pBeginIdx > pEndIdx) {
            return -1;
        }
        if (pList.get(pBeginIdx).equals(pKey)) {
            return pBeginIdx;
        } else {
            return recLinearSearch(pList, pKey, pBeginIdx + 1, pEndIdx);
        }
    }
}