/**
 * This the first Homework assignment for CSE 240. It calculates the factorial
 * of a number and modifies arrays by either changing the even and odd positions
 * or puts them in acending order.
 * 
 * Completion time: 1 hours
 *
 * @author Casey Ledbetter
 * @version (version)
 */

public class Classroom {
    private Student seats[][] = null;

    public Classroom(int rowNum, int columnNum) {
        this.seats = new Student[rowNum][columnNum];

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < columnNum; j++) {
                seats[i][j] = new Student();
            }
        }
    }

    private Student getStudentAt(int row, int col) {
        return seats[row][col];
    }

    public boolean setStudentAt(int row, int col, Student data) {

        if (seats[row][col].getFirstName().equals("foo") && seats[row][col].getLastName().equals("bar")) {
            seats[row][col] = data;
            return true;
        } else {
            return false;
        }
    }

    public boolean isValid(int row, int col) {
        if (row < 0 || row > seats.length - 1) {
            return false;
        } else if (col < 0 || col > seats[0].length - 1) {
            return false;
        } else {
            return true;
        }
    }

    public String toString() {
        String s = "The current seating:\n";
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {

                s += seats[i][j].toString() + " ";
            }
            s += "\n";
        }

        return s;
    }

}
