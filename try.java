import java.util.*; 

public class Try {
  public static String reverseOrder(String word1,String word2,String word3){
  word11=word1.toUpperCase();
  word22=word2.toUpperCase();
  word33=word3.toUpperCase();
  String array [] = new String[3];
  array[] = [word11,word22,word33];
  Arrays.sort(array);
  String s = array [0];
  String t = array [2];
  array [0] = t;
  array [2] = s;
  return array;
  }
  System.out.println(reverseOrder());
}