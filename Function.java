/*
 * MCS 140 - HW 14
 * an abstract class to represent a one-variable mathematical function
 * TODO: complete the methods integrate() and drawIntegral() below
 */

public abstract class Function {
  /*
   * TODO
   * computes the definite integral from a to b using a rectangle approximation
   * the argument n is the number of rectangles to be created
   * returns the sum of the areas of the rectangles (the approximate integral)
   * the method should use a left-endpoint approximation (the first left endpoint will be at x=a)
   */
  public double integrate(double a, double b, double n) {
    //TODO
    double deltaX = (b-a)/n;
    double heights = 0;
    for (int i=0;i<n-1;i++){
      heights = heights +f(a+i*deltaX);
    }
    return deltaX*heights ;
  }
  
  /*
   * TODO
   * draws the rectangle approximation of the definite integral from a to b
   * the argument n is the number of rectangles to be created
   * each rectangle has a base on the x-axis with an equal width
   * each rectangle has a height given by f(x)
   */
  public void drawIntegral(double a, double b, double n) {
    //TODO
    double deltaX = (b-a)/n;
    StdDraw.setXscale(-10, +10);
    StdDraw.setYscale(-10.0, +10.0);
    for (int i = 0; i <= n-1; i++) {
      //x-coordinates are just the interval split into N pieces
     double x = a+ i*deltaX;
      //y-coordinates calculated using the function
     double y = f(x);
       StdDraw.line(x, y, x+deltaX, y);
       StdDraw.line(x, 0, x, y);
        StdDraw.line(x+deltaX, 0, x+deltaX, y);
        
    }
    

    
  }
  
  
  
  /*******CODE BELOW IS COMPLETE AND SHOULD NOT BE MODIFIED************
  
  /*
   * a method to compute f(x), the y-value of this function
   * note: this method is abstract and must be implemented by sub-classes
   */
  public abstract double f(double x);
  
  
  /*
   * a method to print a String representation of this function
   * note: this method is abstract and must be implemented by sub-classes
   */
  public abstract String toString();
  
  
  /*
   * A method to draw a graph by connecting the points given
   * by the x-values and y-values arrays
   */
  public void drawGraph(double x[], double y[]) {
    //"connect the dots" by drawing lines between successive points in the given arrays
    for (int i=0; i<x.length-1; i++) {
      StdDraw.line(x[i],y[i], x[i+1], y[i+1]);
    }
  }
  
  /*
   * this method approximates f'(x) using the limit definition of the derivative
   * the argument h should be a small value to get a decent approximation
   */
  public double fprime(double x, double h) {
    return (f(x+h)-f(x))/h; 
  }
  
  /*
   * this method fills the given arrays with x-values and y-values
   * corresponding to points on the graph of f(x)
   * x-values start at xMin and increase by the given step size
   * until the array is full.
   */
  public void computePoints(double x[], double y[], double xStart, double step) {
    //first point
    x[0] = xStart;
    y[0] = f(xStart);
    
    //remaining points
    for (int i=1; i<=x.length-1; i++) {
      x[i] = x[i-1] + step;
      y[i] = f(x[i]);
    }
  }
}