import java.util.*;
public class Divisors {
  public static void main(String args[]){
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please enter an integer:");
    while(!keyboard.hasNextInt()){
      System.out.println("Invalid input. please enter an INTEGER. ");
      keyboard.nextLine ();}
    int input = keyboard.nextInt();
    int factor = 1 ;
    int Numbersfac = 0 ;
    while (input>=factor){
      if (input%factor == 0){
        System.out.println("the factor is " +factor);
        Numbersfac = Numbersfac +1;}
      factor = factor + 1;}
    if (Numbersfac == 2){
      System.out.println("the number is prime");}
   
    
   keyboard.close();}
 
} 
