import java.util.*; 
public class BMI{
  public static void main (String args[]){
    double height = Double.parseDouble (args[0]);
    double weight = Double.parseDouble (args[1]);
    double BMI = (weight/(Math.pow(height, 2)));
      
    System.out.println("BMI for a person with body mass " + weight + " kg and height " + height + " m is " + BMI + " kg/m^2" );
  }
  public static String[] reverseOrder(String word1,String word2,String word3){
  String word11=word1.toUpperCase();
  String word22=word2.toUpperCase();
  String word33=word3.toUpperCase();
  String array [] ={word11,word22,word33};
  Arrays.sort(array);
  String s = array [0];
  String t = array [2];
  array [0] = t;
  array [2] = s;
  return array;
  }
  public static String lastLetters(String word1,String word2,String word3){
  String w1 =word1.substring(word1.length()-1,word1.length());
  String w2 =word2.substring(word2.length()-1,word2.length());
  String w3 =word3.substring(word3.length()-1,word3.length());
  String word = w1+w2+w3;
  String WORD = word.toUpperCase();
  return WORD;
}
}