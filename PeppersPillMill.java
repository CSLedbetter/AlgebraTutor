import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

class TrialGroup {
    private String fileName;
    private int count, sum, sumOfSquares;
  
    public TrialGroup(String fileName) {
        LineNumberReader lineNumberReader = null;
        try {
            //Construct the LineNumberReader object
            lineNumberReader = new LineNumberReader(new FileReader(fileName));

            String line = null;
            List<Integer> list = new ArrayList<Integer>();
            int count = 0;
            while ((line = lineNumberReader.readLine()) != null) {
                list.add(new Integer(line));
                count++;
            }

            int sum = 0;
            int sumOfSquares = 0;
            for(Integer number : list)
                sum += number;
            
            for (Integer number : list)
                sumOfSquares += number * number;
            
            this.sumOfSquares = sumOfSquares;
            this.sum = sum;
            this.count = count;
            this.fileName = fileName;
            
            getFileName();
            getAverage ();
            getStandardDeviation ();
            
       }
          catch (Exception ex) {
             ex.printStackTrace();
          } 
          finally {
          //Close the LineNumberReader
             try {
                 if (lineNumberReader != null) {
                     lineNumberReader.close();
                 }
             } 
             catch (IOException ex) {
                 ex.printStackTrace();
             }
            }
        
    } 
    
    public double getAverage () {
        double average = sum / count;
        return average;
    }

    public double getStandardDeviation () {
        double average = getAverage();
        double squareOfAverage = average * average;
        double averageOfSquares = sumOfSquares / count; 
        double deviation = Math.sqrt(averageOfSquares - squareOfAverage);
       
        return deviation;
    }
    
    public String getFileName() {
        String returnName = fileName;
        return returnName;
    }
} //End of class TrialGroup



class PeppersPillMill  {
  public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      DecimalFormat decimalFormat = new DecimalFormat("0.00");
      decimalFormat.setRoundingMode(RoundingMode.UP);
      boolean bool = false;
       System.out.print("Enter file name with .dat ");    
       String data1 = input.nextLine();
       TrialGroup trialGroup1 = new TrialGroup(data1);
      
       System.out.print("Enter file name with .dat ");    
       String data2 = input.nextLine();
       TrialGroup trialGroup2 = new TrialGroup(data2);
      
       System.out.print("Enter file name with .dat ");    
       String data3 = input.nextLine();
       TrialGroup trialGroup3 = new TrialGroup(data3);
      
       System.out.print("Enter file name for output ");    
       String output = input.nextLine();
      
      

       try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(output, true));
            writer.append("Statistics:\n");
            writer.append(trialGroup1.getFileName() + ": " + trialGroup1.getAverage() + " " + decimalFormat.format(trialGroup1.getStandardDeviation() ) + "\n");
            
            writer.append(trialGroup2.getFileName() + ": " + trialGroup2.getAverage() + " " + decimalFormat.format(trialGroup2.getStandardDeviation() ) + "\n");
            
            writer.append(trialGroup3.getFileName() + ": " + trialGroup3.getAverage() + " " + decimalFormat.format(trialGroup3.getStandardDeviation() ) + "\n");
           writer.append("Results:\n");
           writer.append(trialGroup1.getFileName() + " vs. " + trialGroup2.getFileName() + " : " + bool  + "\n");
           writer.append(trialGroup1.getFileName() + " vs. " + trialGroup3.getFileName() + " : " + bool  + "\n");
           writer.append(trialGroup2.getFileName() + " vs. " + trialGroup3.getFileName() + " : " + bool  + "\n");
            

            
        writer.close();
        }
        catch (Exception ex) {
             ex.printStackTrace();
          }


  }

}