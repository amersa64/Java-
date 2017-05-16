  import java.util. *;
public class test{
  public static double f(double x){
     Scanner keyboard = new Scanner(System.in);
    System.out.println("enter a value for x: ");
    x = keyboard.nextDouble();
    double y = Math.pow(Math.E, x) + Math.sin(x) - 5*Math.pow(x,3) + 2;
    keyboard.close();}
      return y ;
  public static double[][] drawGraph(double[][] Array) {
     double[] x-values ;
      double[] y-values ;
      Array [][] = x[]y[];
       for ( i = 0; i < 300; i++) {
         StdDraw.line(x[i], y[i], x[i+1], y[i+1]);}
  }
}