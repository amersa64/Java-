 import java.util.* ;
public class Quadroot{
  public static void main (String args []){
  Scanner keyboard = new Scanner(System.in);
  System.out.println("Hello young Mathematician, Let's solve Some quadratic equations.");
  System.out.println("please type in the value for A?");
  double A = keyboard.nextDouble ();
  System.out.println("please type in the value for B?");
  double B = keyboard.nextDouble ();
  System.out.println("please type in the value for C?");
  double C = keyboard.nextDouble ();
  double Disc = Math.pow( B, 2) + (-4)*(A)*(C);
  double x1 = ((-B + Math.sqrt(Disc))/(2*A));
  double x2 = ((-B - Math.sqrt(Disc))/(2*A));
    if (Disc <0){
    System.out.println("Imaginary Solution");
  }
  else {
    System.out.println( " the Solutions are " + x1 + " and " + x2 );
     keyboard.close ();
  }}}
    