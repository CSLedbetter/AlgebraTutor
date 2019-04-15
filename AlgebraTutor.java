// Algebra Tutor Program will generate random number for the equations y = mx + b and ask the user to solve for the correct answer.
// The Program will run until you get 3 in a row correct and will give you your score at the end.

import java.util.Scanner;
import java.util.Random;

class AlgebraTutor {
  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    
    int correctAnswer;
    int solveFor = 1;
    int numberCorrect = 0;
    int numberIncorrect = 0;
    int totalQuestions = 0;
    int numberInRow = 0;

    while (solveFor > 0 && numberCorrect != 3) { 
            System.out.print("Select 1 to Solve for Y, 2 to Solve for M, 3 to Solve for B and 4 to quit ");
            solveFor = Integer.parseInt(userInput.nextLine());
            int y = getRandomNumberInRange(1,5);
            int m = getRandomNumberInRange(1,5);
            int x = getRandomNumberInRange(1,5);
            int b = getRandomNumberInRange(1,5);
        if (solveFor == 1) {
              int solveForY = solveForY(m, x, b);
              System.out.println("Given:\n");
              System.out.println("m = " + Integer.toString(m));
              System.out.println("x = " + Integer.toString(x));
              System.out.println("b = " + Integer.toString(b) + "\n");
              System.out.print("What is the value of y? ");
              correctAnswer = Integer.parseInt(userInput.nextLine());
              if (correctAnswer == solveForY) {
                  System.out.println("Correct!");
                  numberCorrect ++;
                  totalQuestions ++;
                  numberInRow ++;
              } else {
                  System.out.println("Sorry, that's wrong. The correct answer is " + Integer.toString(solveForY) + ".");
                  totalQuestions ++;
                  numberInRow = 0;
              }

          } else if (solveFor == 2) {
              double solveForM = solveForM(y, x, b);
              double answerDouble;
              System.out.println("Given:\n");
              System.out.println("y = " + Integer.toString(y));
              System.out.println("x = " + Integer.toString(x));
              System.out.println("b = " + Integer.toString(b) + "\n");
              System.out.print("What is the value of m? ");
              answerDouble = Double.parseDouble(userInput.nextLine());
              if (answerDouble == solveForM) {
                  System.out.println("Correct!");
                  numberCorrect ++;
                  totalQuestions ++;
                  numberInRow ++;
              } else {
                  System.out.println("Sorry, that's wrong. The correct answer is " + Double.toString(solveForM) + ".");
                  totalQuestions ++;
                  numberInRow = 0;
              }

          }  else if (solveFor == 3) {
              int solveForB = solveForB(y, m, x);
              System.out.println("Given:\n");
              System.out.println("y = " + Integer.toString(y));
              System.out.println("m = " + Integer.toString(m));
              System.out.println("x = " + Integer.toString(x) + "\n");
              System.out.print("What is the value of b? ");
              correctAnswer = Integer.parseInt(userInput.nextLine());
              if (correctAnswer == solveForB) {
                  System.out.println("Correct!");
                  numberCorrect ++;
                  totalQuestions ++;
                  numberInRow ++;
              } else {
                  System.out.println("Sorry, that's wrong. The correct answer is " + Integer.toString(solveForB) + ".");
                  totalQuestions ++;
                  numberInRow = 0;
              }

          }  else {
                int score = (numberCorrect / totalQuestions) * 100;
                System.out.println ("Your score is " + Integer.toString(score) +"%");
                return;
              }
    }
      
      int score = (numberCorrect / totalQuestions) * 100;
      System.out.println ("Your score is " + Integer.toString(score) +"%");
      return;
  }
    

  private static int getRandomNumberInRange(int minNum, int maxNum) {

	Random number = new Random();
	return number.nextInt((maxNum - minNum) + 1) + minNum;
  }
    
  public static int solveForY (int m, int x, int b) {
    int solveForY = 0;
    return solveForY = m * x + b;
 }
    
  public static double solveForM (int y, int x, int b) {
    double solveForM;
    return solveForM = Double.valueOf((y - b) / x);
 }
    
  public static int solveForB (int y, int m, int x) {
    int solveForB = 0;
    return solveForB = y - (m * x);
 }    
} //end of AlgebraTutor