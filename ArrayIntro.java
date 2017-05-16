/*
 * Shyam Kurup
 * MCS 140
 */

import java.util.*; //needed for Scanner AND for Arrays class

public class ArrayIntro {
  public static void main(String args[]) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please enter a positive integer");
    int input = keyboard.nextInt();
    
    //create an array of double (decimal) values of the given size
    double numbers[]; //declare the variable numbers and the type of the array
    numbers = new double[input];  //create the space for the array using the given size
    
    //note: at this point there is no actual data in the array cells
    //they will default to 0, in this case
    
    //fill the array with random numbers (between 0 and 100, not including 100)
    for (int i=0; i<numbers.length; i++) { //loop through the array one cell at a time, start at index 0
      numbers[i] = Math.random() * 100;
    }
    
    //print the contents of the array
    for (int i=0; i<numbers.length; i++) {
      System.out.print(numbers[i] + ", "); //print each value, separated by commas on the same line
    }
    System.out.println(); //end the line
    
    //find the maximum value in the array and print it
    double minimum = numbers[0];
    for (int i=1; i<numbers.length; i++) { //conduct a "linear" search through the array
      if (numbers[i] < minimum) {
        minimum = numbers[i]; //a larger value is seen, so overwrite the current maximum
      }
    }
    //loop finished, so minimum should have the largest value
    System.out.println("The minimum value is: " + minimum);
    
    //compute the average of the numbers (the arithmetic mean)
    double sum = numbers[0];
    for (int i=1; i<numbers.length; i++) {
      sum += numbers[i];  //same as sum = sum + numbers[i];
    }
    double Average= sum/numbers.length ;
    //loop finished, sum contains the total sum of all the values now
    System.out.println("The average is: " + Average);
    
    Arrays.sort(numbers); //sort the entire array into ascending order of value
    //print the contents of the array
    for (int i=0; i<numbers.length; i++) {
      System.out.print(numbers[i] + ", "); //print each value, separated by commas on the same line
    }
    System.out.println(); //end the line
    if (input%2==0){
      double Median = ((numbers[(int)((input/2.0)-1)]+numbers[(int)((input/2.0))])/2);
        System.out.println(" The median is " + Median);
    }
    else {
      int MiddleNumber = (((int)(input/2.0)));
      double Median = (numbers[MiddleNumber]);
        System.out.println(" The median is " + Median);
    } 
    double total= 0;
    for (int i=0; i<numbers.length; i++) {
      double values= Math.pow((numbers[i]- Average),2);
      total += values ;
    }
    double StanderedDeviation = Math.pow(total/input, 0.5);
    System.out.println(" The Standered Deviation is " + StanderedDeviation);
    
    keyboard.close();
  }
}