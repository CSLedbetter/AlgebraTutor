public static int recLinearSearch(ArrayList<String> pList, String pKey, int pBeginIdx, int pEndIdx) {
    if (pBeginIdx > pEndIdx) {
        return -1;
    }
    int middle = (pBeginIdx + pEndIdx) / 2;

    if (pList.get(middle) == pKey) {
        return middle;
    } else if (pList.get(middle) < pKey) {
        return recLinearSearch(pList, pKey, pBeginIdx, middle - 1);
    }
    return recLinearSearch(pList, pKey, middle + 1, pEndIdx);
}