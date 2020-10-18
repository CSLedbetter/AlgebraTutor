
// CLASS: H03_57 (Source Code File: H03_57.java)
// AUTHOR: Casey Ledbetter, csledbet, csledbet@asu.edu
import java.util.ArrayList;
import java.util.List;

public class H03_57 {

    public static int recTernarySearch(ArrayList<Integer> pList, Integer pKey, int pLow, int pHigh) {
        while (pLow <= pHigh) {
            int range = pHigh - pLow;
            int oneThirdIdx = (int) Math.round(pLow + range / 3.0);
            int twoThirdIdx = (int) Math.round(pLow + range / 1.3333333333333333);
            if (pKey.equals(pList.get(oneThirdIdx))) {
                return oneThirdIdx;
            } else if (pKey.equals(pList.get(twoThirdIdx))) {
                return twoThirdIdx;
            } else if (pKey < pList.get(oneThirdIdx)) {
                return recTernarySearch(pList, pKey, pLow, oneThirdIdx - 1);
            } else if (pKey > pList.get(twoThirdIdx)) {
                return recTernarySearch(pList, pKey, twoThirdIdx + 1, pHigh);
            } else {
                return recTernarySearch(pList, pKey, twoThirdIdx + 1, oneThirdIdx - 1);
            }
        }
        return -1;
    }

}