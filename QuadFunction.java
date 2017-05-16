/*
 * MCS 140 - HW 14
 * Shyam Kurup
 * a specific sub-class of Function: the quadratic function representing y = ax^2+bx+c
 */

public class QuadFunction extends Function {
  //**********Data**********
  private final double a, b, c;
  
  //***********constructor to set up a quadratic function********
  public QuadFunction(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }
  
  //***********METHODS************
  
  //overriding the abstract method for f(x) in the Function class
  public double f(double x) {
    return a * x * x + b * x + c;
  }
  
  //overriding the abstract method for toString() in the Function class
  public String toString() {
    return "f(x)="+a+"x^2 + "+b+"x + "+c;
  }
}