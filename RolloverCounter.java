/*
 * MCS 140
 * HW 13
 * Write the code for the RolloverCounter class below
 * 
 * In the RolloverCounter.java file you will implement a RolloverCounter class that should include:
 1) A private variable to store the current count.
 2) Another private variable to store the maximum value this counter can count up to.
 3) A constructor that takes a single integer as an argument and uses it to set the maximum counter value.  The current count should be set to 0.
 4) An increment() method that increases the count value by 1, but sets it back to 0 if the count goes above the maximum. no arguments, returns nothing
 5) A decrement() method that decreases the count value by 1, but sets it to the maximum value if it goes below 0. no arguments, returns nothing
 6) A toString() method that returns a String representing the current count value.  no arguments.
 7) A reset() method that sets the count value back to 0.  no arguments, returns nothing.
 
 Notes:
 + This class is meant to be like the values on a car's odometer readout that tick upwards through
 the digits 0 to 9 and then roll back to 0 (but this counter could have a max different than 9)
 + The count should always be a number between 0 and the maximum value that was set when the counter was created.
 + The constructor should throw an exception if the argument for the maximum value is not a positive number (0 or less)
 */

public class RolloverCounter {
  private int count;
  private final int maximum;
  public RolloverCounter(int other){
    count = 0 ;
    maximum = other ;
    if (maximum<0)
    {throw new IllegalArgumentException("invalid argument for maximum  cannot be less than 0.");}
  }
  public void increment(){
    count = count +1;
    if (count>maximum){count=0;}
  }
  public void decrement(){
    count = count -1;
    if (count<0){count=maximum;}
  }
  public String toString(){
    return count + "";
  }
  public void reset() {
    count = 0;
  }
} //end RolloverCounter