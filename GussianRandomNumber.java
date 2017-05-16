public class GussianRandomNumber{
  public static void main (String []args){
    double U = Math.random();
    double V = Math.random();
    double Z = Math.sin( 2 * Math.PI * V)* Math.sqrt( -2 *Math.log(U));
    System.out.println( "Random Gussian variable Value is " + Z );
  }
}