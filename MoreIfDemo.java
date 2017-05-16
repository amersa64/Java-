import java.util.*;
public class MoreIfDemo {
  public static void main(String args []){
    Scanner keyboard = new Scanner (System.in);
    System.out.println("Please enter an integer");
    int input = keyboard.nextInt ();
    if (input <0) {
      System.out.println("it is negative.0 is a perfect square.");
    }
    else if (input ==0){
      System.out.println("the number is 0.");
    }
    else {
      System.out.println("it is positive. ");
      int root = (int) Math.sqrt(input);
      if (root * root == input) {
        System.out.println("It is a perfect square. ");
    }
    if (input % 2 == 0) { //check wether thenumber is divisble by 2 (remainder of 0)
      System.out.println("The number is even. ");
    }
    else {
      System.out.println("The number is odd");
    keyboard.close();
  }
}
  }
}
