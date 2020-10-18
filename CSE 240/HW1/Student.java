/**
 * This the first Homework assignment for CSE 240. Used in HomeworkTwo 
 * to create new students and split an entered string for a new student's
 * name.
 * 
 * Completion time: 1 hours
 *
 * @author Casey Ledbetter
 * @version (version)
 */

public class Student {
    private String firstName;
    private String lastName;

    public Student() {
        this.firstName = "foo";
        this.lastName = "bar";
    }

    public Student(String info) {
        String arr [] = info.split("/");
        this.firstName = arr[0];
        this.lastName = arr[1];
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String toString () {
        String s = "";

        if (firstName.equals("foo") && lastName.equals("bar")) {
            s += firstName + "." + lastName + ".";
        }
        else 
            s += firstName.charAt(0) + "." + lastName.charAt(0) + ".";
            return s;
    }

}
