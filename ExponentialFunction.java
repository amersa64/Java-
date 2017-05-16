/*
 * MCS 140 - HW 14
 * a specific sub-class of Function: the exponential function representing y = Ae^(kx)
 * TODO: complete the code for this class
 */

public class ExponentialFunction extends Function {
  //**********Data**********
private final double A, k;
  
  //***********constructor to set up a sine function********
  public ExponentialFunction(double A, double k) {
    this.A= A;
    this.k= k;
  }
  
  //***********METHODS************
  
  //overriding the abstract method for f(x) in the Function class
  public double f(double x) {
    return A * Math.exp(k*x);
  }
  
  //overriding the abstract method for toString() in the Function class
  public String toString() {
    return "f(x)="+A+"e^("+k+"x)";
  }
}