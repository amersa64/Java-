/*
 * MCS 140
 * HW 13
 * a program that uses the RolloverCounter class to test its functionality
 * You don't need to change anything in the program...it is just here to help you test your code in the RolloverCounter
 * 
 When this program is run the output should be:
 *************************************************
 creating new counters... 
 creating counter c1 with max value = 5... 
 creating counter c2 with max value = 3... 
 creating counter c3 with max value = -2 (this should not work)... 
 Error creating counter: java.lang.RuntimeException: invalid maximum value 
 
 incrementing the counts 10 times and printing counts... 
 c1: 1 c2: 1 
 c1: 2 c2: 2 
 c1: 3 c2: 3 
 c1: 4 c2: 0 
 c1: 5 c2: 1 
 c1: 0 c2: 2 
 c1: 1 c2: 3 
 c1: 2 c2: 0 
 c1: 3 c2: 1 
 c1: 4 c2: 2 
 
 decrementing the counts 7 times and printint counts... 
 c1: 3 c2: 1 
 c1: 2 c2: 0 
 c1: 1 c2: 3 
 c1: 0 c2: 2 
 c1: 5 c2: 1 
 c1: 4 c2: 0 
 c1: 3 c2: 3 
 
 resetting counters... 
 c1: 0 c2: 0 
 *****************************************************
 */

public class CounterTest {
  public static void main(String args[]) {
    System.out.println("creating new counters...");
    System.out.println("creating counter c1 with max value = 5...");
    RolloverCounter c1 = new RolloverCounter(5);
    System.out.println("creating counter c2 with max value = 3...");
    RolloverCounter c2 = new RolloverCounter(3);
    
    try {
      System.out.println("creating counter c3 with max value = -2 (this should not work)...");
      RolloverCounter c3 = new RolloverCounter(-2);
    } catch (Exception e) {
      System.out.println("Error creating counter: " + e);
    }
    
    System.out.println("\nincrementing the counts 10 times and printing counts...");
    for (int i=1; i<=10; i++) {
      c1.increment();
      c2.increment();
      System.out.println("c1: " + c1 + "\tc2: " + c2);
    }
    
    System.out.println("\ndecrementing the counts 7 times and printint counts...");
    for (int i=1; i<=7; i++) {
      c1.decrement();
      c2.decrement();
      System.out.println("c1: " + c1 + "\tc2: " + c2);
    }
    
    System.out.println("\nresetting counters...");
    c1.reset();
    c2.reset();
    System.out.println("c1: " + c1 + "\tc2: " + c2);
    
  } //end main
} //end CounterTest

