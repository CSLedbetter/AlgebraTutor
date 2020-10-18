//******************************************************************************************************** 
// CLASS: Main.java
//
// DESCRIPTION
// This code will read from a file and create an ArrayList of integers which it will then perform the runs up and // runs down test. It will then output a file with the total number of runs and how many of each type of run
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Fall B 2019
// Project Number: p01
//
// AUTHOR: Casey Ledbetter, csledbet, csledbet@asu.edu //********************************************************************************************************
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws FileNotFoundException, IOException 
        int count = 1;
        String fileName = "p01-in.txt";
        int i = 0;
        ArrayList<Integer> list = readInputFile(fileName);
        ArrayList<Integer> listRunsUpCount = findRuns(list, 1);
        // ArrayList<Integer> listRunsDnCount = findRuns(list, 0);;
        // ArrayList<Integer> listRunsCount = mergeLists(listRunsUpCount,
        // listRunsDnCount);
        writeOutputFile(

    public static ArrayList<Integer> findRuns(ArrayList<Integer> List, int Dir) {
        ArrayList<Integer> runList = arrayListCreate(12, 0);
        ArrayList<Integer> list = List;
          int direction = Dir; 
          int count = 0;
        in = 0;
        in n = 0;
        Bo n = null;
 
        for (int i = 1; i < list.size(); i++) {
           ex = list.get(i);
            null) {
           (index > list.get(i - 1)) {
                if (!sign) {
                    sign = true;
                count++;
                    down++;
                    }
            } else {
            if (sign) {
                sign = false;
            count++;
            }
            }
            } else {
            if (index > list.get(i - 1))
                    sign = true;
                else
                    sign = false;
                count++;
                up++;
            }
        }

        runList.set(0, count);
        runList.set(1, up);
        runList.set(2, down);
        return runList;
    }

    // public static ArrayList<Integer> mergeLists(ArrayList<Integer>
    // pListRunsUpCount,
    // ArrayList<Integer> pListRunsDnCount) {
    // ArrayList<Integer> listRunsCount = arrayListCreate(28, 0);
    // // for (int i = 0; i < listRunsCount.size(); i++) {
    // // listRunsCount.addAll(pListRunsDnCount);
    // // listRunsCount.addAll(pListRunsUpCount);
    // // } 
    // listRunsCount.addAll(pListRunsDnCount);
    // listRunsCount.addAll(pListRunsUpCount);
    // return listRunsCount;
    // }

    public static ArrayList<Integer> arrayListCreate(int pSize, int pInitValue) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < pSize; i++) {
            list.add(pInitValue);
        }
        return list;
    }

    public static ArrayList<Integer> readInputFile(String fileName) throws FileNotFoundException, IOException {
        FileWriter output_file = new FileWriter("p01-runs.txt");
        ArrayList<Integer> tempList = arrayListCreate(0, 12);
        try {
            Scanner fileInput = new Scanner(new File(fileName));
            int line_count = 0;
            int current_line;
            while (fileInput.hasNext()) {
                line_count++;
                current_line = Integer.parseInt(fileInput.next());
                tempList.add(current_line);
            }
            fileInput.close();
            return tempList;
        } catch (FileNotFoundException pExcept) {
            System.out.println("Oops, could not open '" + fileName + "' for reading. The program is ending.");
            // Print friendly error message
            System.exit(-100);
        }
        return tempList;
    } 

            oid writeOutputFile(String fileName, ArrayList<Integer> pListRuns)
            throws FileNotFoundException, IOException {
        try {
            FileWriter output_file = new FileWriter(fileName);
            BufferedWriter outputBuffer = new BufferedWriter(output_file);
            int count = 0;
            int currentLine = 0;
            ArrayList<Integer> RunsList = pListRuns;
            for (int index = 0; index < RunsList.size(); index++) {
                count += RunsList.get(index);
            }
            outputBuffer.write("runs_total: " + RunsList.get(0));
            for (int index = 1; index < RunsList.size(); index++) {
                currentLine++;
                outputBuffer.write("\nruns_" + currentLine + ":" + RunsList.get(index));
            }
            outputBuffer.close();
        } catch (FileNotFoundException pExcept) {
            System.out.println("Oops, could not open '" + fileName + "' for reading. The program is ending.");
            // Print friendly error message
            System.exit(-200);
        }
    }
}