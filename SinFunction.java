/*
 * MCS 140 - HW 14
 * Shyam Kurup
 * a specific sub-class of Function: the sin function representing y = A * sin(omega * (x + phi))
 */

public class SinFunction extends Function {
  //**********Data**********
  private final double A, omega, phi;
  
  //***********constructor to set up a sine function********
  public SinFunction(double A, double omega, double phi) {
    this.A = A;
    this.omega = omega;
    this.phi = phi;
  }
  
  //***********METHODS************
  
  //overriding the abstract method for f(x) in the Function class
  public double f(double x) {
    return A * Math.sin(omega * (x+phi));
  }
  
  //overriding the abstract method for toString() in the Function class
  public String toString() {
    return "f(x)="+A+"*sin("+omega+"*(x + "+phi+"))";
  }
}