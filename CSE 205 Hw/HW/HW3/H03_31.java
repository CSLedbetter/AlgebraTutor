// CLASS: H03_31 (Source Code File: H03_31.java)
// AUTHOR: Casey Ledbetter, csledbet, csledbet@asu.edu
public class H03_31 {

    public static int sum1toN(int num) {
        if (num == 1) {
            return num;
        } else {
            return num + sum1toN(num - 1);
        } 
    }
}