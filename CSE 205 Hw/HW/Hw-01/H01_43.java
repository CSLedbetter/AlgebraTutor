// CLASS: MainClassName
// AUTHOR: Casey Ledbetter, csledbet, csledbet@asu.edu
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] pArgs) throws IOException {
        H01_43();
    }
    public static String H01_43 () throws IOException {
        Scanner userInput = new Scanner(System.in);
        try{
        System.out.print("What is the name of a Java source code file?\n");
        String fileName = userInput.nextLine().split("\\.")[0] + ".java";


        System.out.println("Looking for " + fileName);
        String convertToTxtFile = getFile(fileName);
        
        return convertToTxtFile;
        } finally {
          userInput.close();
        }
    }
    public static String getFile(String fileName) throws IOException {
    Scanner fileInput = new Scanner(new File(fileName));
    String fileToTxt = fileName + ".txt";

    FileWriter output_file = new FileWriter(fileToTxt);
    BufferedWriter outputBuffer = new BufferedWriter(output_file);
    try {
      int line_count = 0;
          String current_line = "";
          while(fileInput.hasNext()){
              line_count++;
              current_line = fileInput.nextLine();
              String bracket = String.format("[%03d] ", line_count); 
              outputBuffer.write(bracket + current_line + "\n");
          }
          System.out.println("Finished converting the file");
          return fileToTxt;

        } finally { 
          fileInput.close();
          outputBuffer.close();
          }
    } 
}
