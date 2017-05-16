import java.util.*;
public class BeaufortScaleforce {
  public static void main (String []args){
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please enter wind speed (in knots)");
    int input = keyboard.nextInt();
    if (input < 0){
      System.out.println (" invalid wind speed");}
    else if (input <= 1){
      System.out.println (" the Water condtion is : Water is like a mirror. Cannot sail. ");
      System.out.println ("Beaufort Scale force is 0 ");}
    else if (input <= 3) {
        System.out.println (" the Water condtion is : Small ripples on water. Enough wind for a light Spinnaker. ");
      System.out.println ("Beaufort Scale force is 1 ");}
      else if ( input <= 6) {
        System.out.println (" the Water condtion is : Small wavelets. Wind now fills sail. ");
      System.out.println ("Beaufort Scale force is 2 ");}
      else if ( input <= 10) {
        System.out.println (" the Water condtion is : Large wavelets. Sailboats start to heel. ");
      System.out.println ("Beaufort Scale force is 3 ");}
      else if ( input <= 16) {
        System.out.println (" the Water condtion is : Good working breeze. Saiboats at hull speed, full sail. ");
      System.out.println ("Beaufort Scale force is 4 ");}
      else if ( input <= 21) {
        System.out.println (" the Water condtion is : Numerous whitecaps. Time to shorten sails. ");
      System.out.println ("Beaufort Scale force is 5 ");}
      else if ( input <= 27) {
        System.out.println (" the Water condtion is : Whitecaps eveywhere. Sailboats start to head ashore. ");
      System.out.println ("Beaufort Scale force is 6 ");}
      else if ( input <= 33) {
        System.out.println (" the Water condtion is : Numerous whitecaps. Time to shorten sails. ");
      System.out.println ("Beaufort Scale force is 7 ");}
      else if ( input <= 40) {
        System.out.println (" the Water condtion is : Foam in well marked streaks. All boats now head in. ");
      System.out.println ("Beaufort Scale force is 8 ");}
      else if ( input <= 47) {
        System.out.println (" the Water condtion is : Low visibility due to spray. ");
      System.out.println ("Beaufort Scale force is 9 ");}
      else if ( input <= 55) {
        System.out.println (" the Water condtion is : High seas over 8 metres. ");
      System.out.println ("Beaufort Scale force is 10 ");}
      else if ( input < 63) {
        System.out.println (" the Water condtion is : High seas over 10 metres. ");
      System.out.println ("Beaufort Scale force is 11 ");}
      else if ( input >= 63) {
        System.out.println (" the Water condtion is : High seas over 14 metres. ");
      System.out.println ("Beaufort Scale force is 12 ");}
      
   keyboard.close(); }}