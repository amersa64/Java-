import java.util.* ;
public class Stopping{
  public static void main(String args[]){
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please enter an integer greater than 1");
    int number= keyboard.nextInt();
    boolean isPrime = true;
    for (int i=2 ; i<=number/i; i++){
      if (number % i==0){
        isPrime = false ;
        break;
      }
      if (isPrime){
        System.out.println("The number is prime.");
      }
      else{
        System.out.println("The number is not prime (composite).");
      }
      keyboard.close();
    }
  }
}