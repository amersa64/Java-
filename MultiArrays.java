/*
 * Shyam Kurup
 * MCS 140
 */

import java.util.*;

public class MultiArrays {
  public static void main(String args[]) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please enter the first dimension of the array: ");
    int rows = keyboard.nextInt();
    System.out.println("Please enter the second dimension of the array: ");
    int columns = keyboard.nextInt();
    
    int array[][] = new int[rows][columns];
    
    //fill the array with random integers between -10 and 10
    for (int i=0; i<array.length; i++) { //note: array.length gives the size of the first dimension (number of rows)
      for (int j=0; j<array[i].length; j++) { //note: array[i].length gives the size of the second dimension (number of columns in row #i)
        array[i][j] = (int) (Math.random()*11) * (int) (Math.pow(-1, (int)(Math.random()*2)));
        //this line generates the random number by making a number between 0 and 10 and then giving it
        //a positive or negative sign at random
      }
    }
    
    for (int i=0; i<array.length; i++) {
      for (int j=0; j<array[i].length; j++) {
        System.out.print(array[i][j] + "\t");
      }
      //done printing this row, move on to the next row
      System.out.println();
    }
    
    
    keyboard.close();
  }
}