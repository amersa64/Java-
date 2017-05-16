import java.util.*;

public class NxN {
  public static void main(String args[]) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Making an NxN table. What should be N? ");
    int n = keyboard.nextInt();
    boolean array [][] = new boolean[n+1][n+1];
    for (int i=1;i<=n;i++){
      for (int j=1;j<=n;j++){
         array [i][j] =true; 
      }
    }
    for (int i=1; i<array.length; i++) {
      for (int j=1; j<array[i].length; j++) {
        for(int x = 2; x<=j && x<=i; x++){
          if ((i%x ==0 && j%x ==0) || (j==i)){
            array[i][j]= false;
          }
        }
      }
    }
    for (int i=1; i<array.length; i++) {
      System.out.print("\t" + i);}
    System.out.println();
    for (int i=1; i<array.length; i++) {
        System.out.print(i+ "\t");
      for (int j=1; j<array[i].length; j++) {
        if (array[i][j]==true){
          System.out.print("*"+ "\t");
        }
        else {
          System.out.print("  "+ "\t");}
        //done printing this row, move on to the next row
      }
      System.out.println();
    }
    keyboard.close();
  }
}
