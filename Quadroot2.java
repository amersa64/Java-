import java.util.* ;
public class Quadroot2{
  public static void main (String args []){
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Hello young Mathematician, Let's solve Some quadratic equations.");
    System.out.println("please type in the value for A?");
    double A = keyboard.nextDouble ();
    System.out.println("please type in the value for B?");
    double B = keyboard.nextDouble ();
    System.out.println("please type in the value for C?");
    double C = keyboard.nextDouble ();
    System.out.println("please enter N to state how many partitions do you want the graph to have");
    int N = keyboard.nextInt ();
    System.out.println("please Pay close attention to the drawing, if large numbers are entered");
    double Disc = Math.pow( B, 2) + (-4)*(A)*(C);
    double x1 = ((-B + Math.sqrt(Disc))/(2*A));
    double x2 = ((-B - Math.sqrt(Disc))/(2*A));
    double vertex = (Math.pow(B,2)/(4*A))-(Math.pow(B,2)/(2*A))+C;
    if (Disc <0){
      System.out.println("Imaginary Solution");
    }
    else {
      System.out.println( " the Solutions are ");
      System.out.printf("%3.3f",x1);
      System.out.print(" and ");
      System.out.printf("%3.3f",x2);
      System.out.println();
      double[] x = new double[N+2];
      double[] y = new double[N+2];
      double xmin;
      double xmax;
      double ymin;
      double ymax;
      if (x1>x2){
        xmax = x1+5 ;
        xmin = x2-5 ;}
      else {
        xmax = x2+5 ;
        xmin = x1-5 ;}
      if (vertex > 0){
        ymin = -5 ;
        ymax = vertex +5 ;
      }
      else {
        ymin = vertex-5;
        ymax = 5;
      }
      int i = 1;
      x[0] = xmin;
      y [0] =A*Math.pow(xmin,2) + B*xmin + C;
      for (; i <= N; i++) {
        
        x[i]= x[i-1] + ((xmax-xmin)/N);
        y[i] = A*Math.pow(x[i],2) + B*x[i] + C;
      }
      /*
       System.out.println("x " + xmin +"\t"+ xmax);
       System.out.println("y " +ymin+"\t" + ymax);
       
       for ( i=0; i<=N;i++){
       System.out.println(x[i]+ "\t" + y[i]);}*/
      StdDraw.setXscale(xmin, xmax);
      StdDraw.setYscale(ymin, ymax);
      for ( i = 0; i < N; i++) {
        StdDraw.line(x[i], y[i], x[i+1], y[i+1]);
      }
      StdDraw.setPenColor(StdDraw.RED);
      StdDraw.line(xmin,0,xmax,0);
      StdDraw.line(0,ymin,0,ymax);
      keyboard.close ();
      StdDraw.setPenColor(StdDraw.GREEN); 
      StdDraw.filledCircle(x1, 0, 0.5);
      StdDraw.filledCircle(x2, 0, 0.5);
      StdDraw.setPenColor(StdDraw.YELLOW); 
      StdDraw.filledCircle((-B/(2*A)), vertex, 0.5);
    }
  }
}
