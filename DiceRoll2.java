import java.util.* ;
public class DiceRoll2 {
  public static void main (String[] args){
    Scanner keyboard = new Scanner (System.in);
    System.out.println(" How many trials would you like to run? (please enter a positive integer) ");
    int NumTrials = keyboard.nextInt();
    int Roll = 0 ;
    int Value [];
    Value = new int [13];
    for (;NumTrials > 0;NumTrials=NumTrials -1 ){
      int Die1 = (int) (6.0 * Math.random())+ 1 ;
      int Die2 = (int) (6.0 * Math.random())+ 1 ;
      Roll = Die1 + Die2 ;
      Value [Roll]++;
    }
    for(Roll= 2;Roll<=12;Roll++){
      System.out.print(Roll);
      
      for(;Value[Roll]>0;Value[Roll]--){
       
        System.out.print("*");
      }
       System.out.println();
       
    }
    keyboard.close() ;
  }
}