/*
 * MCS 140
 * Complete the Newton's Method visualizing program
 * by creating the static methods below labeled TODO
 * and modifying the newtonsMethod() below 
 */
public class HW10 {
  
  /*
   * Create a static method called f() to compute: f(x) = (e^x) * sin(x) - 5x^3 + 2
   * 
   * The method should take a double value as an argument (the x-value)
   * The method should return a double value (the f(x)-value)
   */
  
  //TODO: create the method here
  public static double f(double x){
    double y = Math.pow(Math.E, x) * Math.sin(x) - 5*Math.pow(x,3) + 2;
    return y ;}
  /*
   * Create a static method called drawGraph() to draw a graph by connecting the points
   * given in two (parallel) arrays representing the x-values and the y-values
   * of a set of ordered pairs on the graph
   * 
   * The method should take two arrays of double values as arguments
   * (an array of x-values and an array of y-values)
   * The method should return nothing, instead it should use StdDraw to
   * "connect the dots" with line segments
   */
  
  //TODO: create the method here
  
  public static void drawGraph(double x[],double y []) {
    for ( int i = 0; i <x.length-1; i++) {
      StdDraw.line(x[i], y[i], x[i+1], y[i+1]);}
  }
  
  /*
   * Modify newtonsMethod to draw (in red) a line connecting the point 
   * on the function at the current approximation to the point 
   * on the x-axis at the next approximation (this is a tangent line) and
   * another line connecting the point on the x-axis at the next approximation
   * to the point on the function at the next approximation.
   * 
   * So if the current approximation is x1 and the next approximation is x2
   * then draw a line connecting (x1,f(x1)) to (x2, 0) and another line 
   * connecting (x2,0) to (x2, f(x2)).
   *    
   * When drawn this should illustrate the series of tangent lines that converges
   * on the root.
   */
  public static double newtonsMethod(double guess) {
    //TODO: modify the code below to add the drawing
    //note: do not change any of the code below, just insert extra lines of code
    //to do the drawing along with the calculations
    
    System.out.println("x1 = " + guess);
    double approx = guess - f(guess)/fprime(guess, 1e-6);
    System.out.println("x2 = " + approx);
    
    
    
    int i = 3;
    while (Math.abs(approx-guess)>0.0001) {
      guess = approx;
      approx = guess - f(guess)/fprime(guess, 1e-6);
      System.out.println("x" + i + " = " + approx);
      i++;
      StdDraw.setPenColor(StdDraw.RED);
      StdDraw.line(guess, f(guess), approx ,0);
      StdDraw.line(approx, 0 , approx, f(approx));
    }
    return approx;
  }
  
  
  
  
  //*******DO NOT MODIFY THE METHOD BELOW**************
  
  /*
   * the main method is where the code begins executing
   */
  public static void main(String args[]) {
    //set up the drawing window
    double xMin = -8;
    double xMax = 8;
    double yMin = -1200;
    double yMax = 2000;
    StdDraw.setXscale(xMin,xMax);
    StdDraw.setYscale(yMin, yMax);
    
    //draw the x & y axes
    StdDraw.line(xMin,0, xMax,0);
    StdDraw.line(0,yMin, 0, yMax);
    
    //draw the function
    int N = 1000; //number of points to compute
    double deltaX = (xMax - xMin) / N; //step size between points
    double xVals[] = new double[N+1];  //array of x-values
    double yVals[] = new double[N+1]; //array of y-values
    computePoints(xVals, yVals, xMin, deltaX);
    drawGraph(xVals, yVals);
    
    //begin Newton's Method
    System.out.println("Root of f(x) is approximately: " + newtonsMethod(xMin));
  }
  
  /*
   * this method approximates f'(x) using the limit definition of the derivative
   * the argument h should be a small value to get a decent approximation
   */
  public static double fprime(double x, double h) {
    return (f(x+h)-f(x))/h; 
  }
  
  /*
   * this method fills the given arrays with x-values and y-values
   * corresponding to points on the graph of f(x)
   * x-values start at xMin and increase by the given step size
   * until the array is full.
   */
  public static void computePoints(double x[], double y[], double xStart, double step) {
    //first point
    x[0] = xStart;
    y[0] = f(xStart);
    
    //remaining points
    for (int i=1; i<=x.length-1; i++) {
      x[i] = x[i-1] + step;
      y[i] = f(x[i]);
    }
  }
  
} //end NewtonsMethodGraph