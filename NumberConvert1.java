import java.util.*;

public class NumberConvert1 {
  static Scanner keyboard = new Scanner(System.in);
  /*
   * Recursive method to ask for and get a positive integer from the user
   * note: uses recursion to repeat if input is not valid
   * 
   * method should use a Scanner to get the input from the user
   * method should repeat (recursively) the input request if the input is not an integer
   * method should repeat (recursively) the input request if the input is not positive
   * method should returns the input integer if it is valid
   */
  private static int getPositiveInt() {
    
    /*
     * TODO
     * Print a message asking the user to type in a positive integer and get the input
     * If the number is not valid, recursively call the method to repeat the prompt and get another input
     */
    System.out.println("please enter a positive integer");
    if (keyboard.hasNextInt()){
      int n = keyboard.nextInt();
      if (n<=0)
      {
        return getPositiveInt();
      }
      else return n;
    }
    else {
      String flush = keyboard.nextLine();
      return getPositiveInt();}}
  
//end getPositiveInt
   /*
   * Recursive method that prints the given number in the given base
   * example:  if n = 13 and base = 2 (binary) then 1101 should be displayed
   */
  private static void displayNumber(int n, int base) {
    if (n<base){
      System.out.print(n);}
    else{
      displayNumber(n/base , base);
    System.out.print(n%base);}
    /*
     * TODO
     * Complete this method USING RECURSION
     * The idea of the method is to print the result backwards recursively:
     * first, if n is greater than or equal to the base, make a recursive call to 
     * with the quotient of n and the base to print all the preceding digits
     * then use the % operator to find the remainder of n and the base and print this digit
     */
    
  
    
  } //end displayNumber
  /**********DO NOT MODIFY THE MAIN METHOD*******/
  
  public static void main(String args[]) {
    //ask user for number to convert
    int input = getPositiveInt();
    System.out.println();
    
    //this loop converts the number into each base from 2 to 9
    //for each base the loop calls the displayNumber() method to do the conversion
    for(int i=2; i<=9; i++) {
      System.out.print("converted to base " + i + " = ");
      displayNumber(input, i);
      System.out.println();
    }
    System.out.println();
    
  } //end main
  
  
} //end NumberConvert