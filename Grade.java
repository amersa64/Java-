/*
 * Shyam Kurup
 * MCS 140
 * simple branching using if,else if, else statements
 * 
 * also, introduction to using scanner for input
 */
// this program will take in a percentage score and return a letter grade based on traditional scale
import java.util.*;
public class Grade {
  public static void main (String args[]){
    Scanner keyboard = new Scanner(System.in);
    
    System.out.println("HI. What's your name?");
    String name = keyboard.next();
    System.out.println("Nice to meet you, " + name + "! What was your exam score?");
    double examScore = keyboard.nextDouble();
    System.out.println("Ok, You scored " + examScore + " on the exam." );
    System.out.print("that exam score earns you a grade of : ");
    if (examScore >= 90){
      System.out.println("A");
    }
    else if (examScore >= 80) {
      System.out.println("B and You Deserve a beating");
    }
    else if (examScore >= 70) {
      System.out.println("C you do not deserve the right to live");
    }
    else if (examScore >= 60) {
      System.out.println("D You SHALL NOT EXIST");
    }
    else{
      System.out.println(" YOU HAVE BROUGHT SHAME TO THIS FAMILY");
      
    keyboard.close ();
    }
  }}