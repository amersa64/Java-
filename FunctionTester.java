/*
 * MCS 140 - HW 14
 * Shyam Kurup
 * a testing program to play with the Function class and its sub-classes
 */

public class FunctionTester {
  public static void main(String args[]) {
    Function func; //a general variable to reference the function to be created
    
    //loop program until user selects option 5 to quit
    boolean done = false;
    while (!done) {
      functionMenu(); //display menu choices
      int funcChoice = StdIn.readInt();
      //create function according to user selection and run tests on it
      switch (funcChoice) {
        case 1:
          func = createLinear();
          runTest(func);
          break;
        case 2:
          func = createQuadratic();
          runTest(func);
          break;
        case 3:
          func = createSine();
          runTest(func);
          break;
        case 4:
          func = createExponential();
          runTest(func);
          break;
        case 5:
          done = true;
          break;
        default:
          System.out.println("\nInvalid selection, please choose from the given options.");
      }
    }
  } //end main
  
  // just a simple helper method to display the menu options to the user
  private static void functionMenu() {
    System.out.println("\nChoose an option:");
    System.out.println("\t1) Create a linear function");
    System.out.println("\t2) Create a quadratic function");
    System.out.println("\t3) Create a sine function");
    System.out.println("\t4) Create an exponential function");
    System.out.println("\t5) Quit");
  }
  
  
  //********helper methods to prompt the user for the necessary constants and create the desired function**********
  
  private static Function createLinear() {
    System.out.println("\nf(x) = mx+b");
    System.out.print("\tEnter m: ");
    double m = StdIn.readDouble();
    System.out.print("\tEnter b: ");
    double b = StdIn.readDouble();
    return new LinearFunction(m, b);
  }
  
  private static Function createQuadratic() {
    System.out.println("\nf(x) = ax^2+bx+c");
    System.out.print("\tEnter a: ");
    double a = StdIn.readDouble();
    System.out.print("\tEnter b: ");
    double b = StdIn.readDouble();
    System.out.print("\tEnter c: ");
    double c = StdIn.readDouble();
    return new QuadFunction(a, b, c);
  }
  
  
  private static Function createSine() {
    System.out.println("\nf(x) = A*sin(omega*(x+phi))");
    System.out.print("\tEnter A: ");
    double A = StdIn.readDouble();
    System.out.print("\tEnter omega: ");
    double omega = StdIn.readDouble();
    System.out.print("\tEnter phi: ");
    double phi = StdIn.readDouble();
    return new SinFunction(A, omega, phi);
  }
  
  private static Function createExponential() {
    System.out.println("\nf(x) = A*e^(kx)");
    System.out.print("\tEnter A: ");
    double A = StdIn.readDouble();
    System.out.print("\tEnter k: ");
    double k = StdIn.readDouble();
    return new ExponentialFunction(A, k);
  }
  
  
  /*
   * method that accepts a given function and runs a series of tests using it
   * first prompts the user for a given x-value
   * 1) evaluates the function the value
   * 2) approximates the derivative at the given x-value
   * 3) graphs the function on a "standard zoom" (-10 to 10 scale)
   * 4) approximates and visualizes the definite integral of the function between bounds specified by the user
   */
  private static void runTest(Function func) {
    System.out.println("\nTesting new function...");
    System.out.print("Enter an x-value: ");
    double x = StdIn.readDouble();
    System.out.println("f(" + x + ")=" + func.f(x));
    System.out.println("f'(" + x + ")=" + func.fprime(x,0.00001));
    System.out.println("Testing integration approximation...");
    System.out.print("Enter a lower limit for integral (between -10 and 10): ");
    double a = StdIn.readDouble();
    System.out.print("Enter an upper limit for integral (between -10 and 10): ");
    double b = StdIn.readDouble();
    System.out.print("Enter number of rectangles for approximation: ");
    double n = StdIn.readDouble();
    System.out.println("Graphing function and integral approximation...");
    
    
    StdDraw.clear();
    StdDraw.setPenColor();
    //set up the window and axes
    double xMin = -10;
    double xMax = 10;
    double yMin = -10;
    double yMax = 10;
    double stepSize = (xMax - xMin) / 500;
    StdDraw.setXscale(xMin, xMax);
    StdDraw.setYscale(yMin, yMax);
    StdDraw.line(xMin, 0, xMax, 0); //x-axis
    StdDraw.line(0, yMin, 0, yMax); //y-axis
    
    //compute points to plot for function and graph
    double x1[] = new double[500];
    double y1[] = new double[500];
    func.computePoints(x1, y1, xMin, stepSize);
    
    //draw graph, label function, draw approximating rectangles, and print out approximation to integral
    StdDraw.textLeft(-10,10, func.toString());
    StdDraw.textRight(10,-10, ("Approximate Integral of f(x) from "+a+" to "+b+" = "+func.integrate(a,b,n)) );
    func.drawGraph(x1, y1);
    StdDraw.setPenColor(StdDraw.RED);
    func.drawIntegral(a,b,n);
  }
  
} //end FunctionTester