// CLASS: H03_35 (Source Code File: H03_35.java)
// AUTHOR: Casey Ledbetter, csledbet, csledbet@asu.edu
public class H03_35 {

    public static String reverse(String str) {
        if (str.isEmpty()) {
            return str;
        } else {
            // Calling Function Recursively
            return reverse(str.substring(1)) + str.charAt(0);
        }
    }
}