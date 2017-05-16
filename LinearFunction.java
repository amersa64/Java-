/*
 * MCS 140 - HW 14
 * a specific sub-class of Function: the linear function representing y = mx+b
 * TODO: complete the code for this class
 */

public class LinearFunction extends Function {
  //**********Data**********
 private final double m, b;
  
  //***********constructor to set up a sine function********
  public LinearFunction(double m, double b) {
    this.m= m;
    this.b = b;
  }
  
  //***********METHODS************
  
  //overriding the abstract method for f(x) in the Function class
  public double f(double x) {
    return (m*x+b);
  }
  
  //overriding the abstract method for toString() in the Function class
  public String toString() {
    return "f(x)="+m+"x "+b;
  }
}