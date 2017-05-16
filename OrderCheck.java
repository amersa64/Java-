public class OrderCheck {
  public static void main (String[] args){
    double x = Double.parseDouble (args [0]);
    double y = Double.parseDouble (args [1]);
    double z = Double.parseDouble (args [2]);
    Boolean AscendingOrDescending = (((x>y) && (y>z)) || ((z>y) && (y>x)));
if (AscendingOrDescending) {
  System.out.println("true");
}
else {
  System.out.println("false");
}
  }}