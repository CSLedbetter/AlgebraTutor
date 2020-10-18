/**
 * This the first Homework assignment for CSE 240. It uses the
 * Student and Classroom Java files to create students and 
 * assign their seating in a classroom.
 * 
 * Completion time: .5 hours
 *
 * @author Casey Ledbetter
 * @version (version)
 */

import java.util.Scanner;

public class HomeworkTwo {
  
  public static void main(String[] args) { 
	  
    Classroom classroom; 
    Student data;
    int row, col, rowNum, columnNum; 
    String info; 
    Scanner scan = new Scanner(System.in);
    
    System.out.println ("How many rows do you want?"); 
    rowNum = scan.nextInt(); 
      
    System.out.println ("How many columns do you want?");   
    columnNum = scan.nextInt(); 

    classroom = new Classroom(rowNum, columnNum); 
    
    System.out.println ("Capture a student information (name/lastname) or enter \"Q\" to quit.");
    info = scan.next(); 

    while (!info.equalsIgnoreCase("Q")){ 

      data = new Student(info); 

      System.out.println ("Capture the row number where the student wants to sit: "); 
      row = scan.nextInt(); 
      System.out.println ("Capture the column number where the student wants to sit: "); 
      col = scan.nextInt(); 
			
      if (classroom.isValid(row, col) == false) { 
        System.out.println("\n row or column number is not valid.");    
        System.out.println ("A student " + data.getFirstName() + " " + data.getLastName() + " is not assigned to a seat."); 
      } else { 
        if (classroom.setStudentAt(row, col, data) == true){ 
          System.out.println("\n The seat at row " + row +" and column " + col + " is assigned to " + data.toString()); 
          System.out.println(classroom); 
        } else { 
          System.out.println("\n The seat at row " + row + " and column " + col + " is taken."); 
        } 
      } 

      System.out.println ("Capture a student information (name/lastname) or enter \"Q\" to quit.");
      info = scan.next(); 
    }
	  
    scan.close(); 
  } 
	
} 