/*
 * MCS 140
 * HW #12
 * Create the methods listed in the comments below.
 * Run the program with the given main method to test your code.
 * 
 * Consult the Java API, the textbook, and the sample code from lecture 
 * for information on the available methods in the String class
 */

import java.util.*; //needed to use methods in Scanner and Arrays class

public class StringMethods {
  
  /*
   * create a method called longest() that takes in three String arguments
   * return the longest String
   * for example, if the arguments are "cat", "bird", "HORSE"
   * the method return the String "HORSE"
   */
 
  //TODO: write the method here
  public static String longest(String word1,String word2,String word3){
    String longst = word1;
    if (word1.length()<word2.length())
    {longst=word2;}
    if (longst.length()<word3.length())
      {longst=word3;}
    return longst;
  }
    
  
  
  
  
  /*
   * create a method reverseOrder() that takes in three String arguments
   * first, capitalize all the words
   * then put the Strings in REVERSE alphabetical order
   * return an array of the capitalized Strings in reverse order
   * for example, if the arguments are "cat", "bird", "HORSE"
   * the method should return the array: ["HORSE", "CAT", "BIRD"]
   * 
   * hint: the .toUpperCase() method in the String class and the .sort() method in the Arrays class might be useful
   * the Arrays class is located in the java.util package
   */
 
  //TODO: write the method here
  public static String[] reverseOrder(String word1,String word2,String word3){
  String word11=word1.toUpperCase();
  String word22=word2.toUpperCase();
  String word33=word3.toUpperCase();
  String array [] = new String[] {word11,word22,word33};
  Arrays.sort(array);
  String s = array [0];
  String t = array [2];
  array [0] = t;
  array [2] = s;
  return array;
  }
  
  /*
   * create a method lastLetters() that takes in three String arguments
   * return a new String made up of the last letter of each argument, in capital letters
   * for example, if the arguments are "cat", "bird", "HORSE"
   * the method should return the String "TDE"
   */
  
  //TODO: write the method here
  
public static String lastLetters(String word1,String word2,String word3){
  String w1 =word1.substring(word1.length()-1,word1.length());
  String w2 =word2.substring(word2.length()-1,word2.length());
  String w3 =word3.substring(word3.length()-1,word3.length());
  String word = w1+w2+w3;
  String WORD = word.toUpperCase();
  return WORD;
}
  /*
   * create a method isPalindrome() that takes in a String argument
   * return a boolean that indicates if the String is a palindrome (true if it is, false if it isn't)
   * a palindrome is a String that reads the same forward and backward
   * for example, if the argument is "Racecar" the method should return true
   * the method should ignore the case of the letters, so 'R' and 'r' are considered the same for this test
   */
  
  //TODO: write the method here

  
public static boolean isPalindrome(String theword){
  boolean palindrome = false;
  if(theword.length()==1)
  {palindrome=true;}
  else if (theword.charAt(0)==theword.charAt(theword.length()-1))
    palindrome= isPalindrome(theword.substring(1,theword.length()-1)); 
  else {palindrome= false;}
  return palindrome;
  
}
  //the main method...don't modify this
  public static void main(String args[]) {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Please enter a word: ");
    String word1 = keyboard.next();
    System.out.print("Please enter another word: ");
    String word2 = keyboard.next();
    System.out.print("Enter one last word, please: ");
    String word3 = keyboard.next();
    
    System.out.println("word1: " + word1);
    System.out.println("word2: " + word2);
    System.out.println("word3: " + word3);
    
    //********this code tests the new methods********
    
    //test longest()
    System.out.println("The longest word is: " + longest(word1,word2,word3));
    System.out.println("Here are the words in reverse alphabetical order:");
    
    //test reverseOrder()
    String[] r = reverseOrder(word1,word2,word3);
    System.out.println(Arrays.toString(r));
    
    //test lastLetters()
    System.out.println("The last letters of the words forms the word: " + lastLetters(word1,word2,word3));
    
    //test isPalindrome()
    if (isPalindrome(word1)) {
      System.out.println(word1 + " is a palindrome!");
    }
    if (isPalindrome(word2)) {
      System.out.println(word2 + " is a palindrome!");
    }
    if (isPalindrome(word3)) {
      System.out.println(word3 + " is a palindrome!");
    }
    
    keyboard.close();
  } //end main
  
} //end StringMethods