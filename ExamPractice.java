import java.util.*;
public class ExamPractice{
  public static void main(String args[]) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please Enter the number of Integers you want" );
    int n = keyboard.nextInt();
    double array []= new double[n];
    for (int i=0; i<n;i++){
     System.out.println("please enter a positive integer");
      array [i]= keyboard.nextInt();
      while (array [i] <0){
        System.out.println("please Renter the last integer, IT WAS NOT A POSTIVE INTEGER");
         array [i]= keyboard.nextInt();
      }
    }
    double arrayRoot []= new double [n];
    for(int i=0;i<n;i++){
      arrayRoot[i]=Math.pow(array[i], 0.5);
    }
    for(int i=0;i<n;i++){
      System.out.println(array[i] + "\t" + arrayRoot[i]);
    }
    Arrays.sort(array);
    System.out.println(array[0] + "this is the Minimum");
    System.out.println(array[n-1]+ "this is the Maximum");
    double sum = 0;
    for(int i=0;i<n;i++){
    sum = sum + array[i];
    }
    double Ave = sum/((double)n);
    System.out.println(Ave);
      keyboard.close();
    }
  }

     
      
      