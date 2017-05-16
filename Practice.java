import java.util.* ;
public class Practice {
  public static void main (String[] args){
    Scanner keyboard = new Scanner (System.in);
    System.out.println(" How many trials would you like to run? (please enter a positive integer) ");
    int NumTrials = keyboard.nextInt();
    int array [];
    array = new int [13];
    for (;NumTrials>0;NumTrials--){
      int Die1 = (int)(Math.random()*6 + 1);
      int Die2 = (int)(Math.random()*6 + 1);
      int Roll = Die1 + Die2 ;
      
      array [Roll] ++;}
    for (int Roll = 2; Roll<=12;Roll++){
      System.out.print(Roll);
      for(;array[Roll]>0;array[Roll]--){
        System.out.print("*");
      }
      System.out.println();
    }
  
  keyboard.close();
}
}
  