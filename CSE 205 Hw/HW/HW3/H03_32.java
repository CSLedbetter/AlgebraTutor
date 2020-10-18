// CLASS: H03_32 (Source Code File: H03_32.java)
// AUTHOR: Casey Ledbetter, csledbet, csledbet@asu.edu
public class H03_32 {

    public static double power(double x, int num) {
        if (num == 0) {
            return 1;
        } else {
            return  x * power(x, num-1);
        } 
    }
}