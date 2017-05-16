import java.util.*;
public class Triangle{
  public static void main(String args[]){
    Scanner keyboard= new Scanner(System.in);
    System.out.println("Please enter the number of rows:");
    int rows = keyboard.nextInt();
    int array[][] = new int[rows][];//create an array with "rows" entries, but no sub arrays yet (no column)
    System.out.println(array);
    //use a loop to create the sub-arrays, the columns
    for(int i=0; i<array.length ;i++){//go through each row and create a sub-array
      array[i]= new int[i+1];// create a triangular array, size of each row is one longer than the last
      for (j=0; j<array[i].length;j++){
        for (int j=0; j<array[i].length; j++){// note: this loop will run correctly for each row by checking the size of the row
          if(j==0 || i==j){
            array[i][j]= 1 ;
          }
          else {
            array [i][j]= array[i-1][j-1] + array[i-1][j];
            // print-oout the entire array
            for (int i=0; i<array.lenght; i++){
              for (j=0; j<array[i].length ;j++){
                System.out.print(array[i][j] + "\t");
              }
              System.out.println();
            }
            keyboard.close();
            
          }
        }
      }
    }}