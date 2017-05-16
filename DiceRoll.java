import java.util.* ;
public class DiceRoll {
  public static void main (String[] args){
    Scanner keyboard = new Scanner (System.in);
    System.out.println(" How many trials would you like to run? (please enter a positive integer) ");
    int NumTrials = keyboard.nextInt();
    int N = NumTrials;
    int NumRolls = 0 ;
    int totalNumRolls = 0 ;
    for (;NumTrials > 0;NumTrials-- ){
      for(int Roll=0;Roll != 7;NumRolls++ ){
        int Die1 = (int) (6.0 * Math.random())+ 1 ;
        int Die2 = (int) (6.0 * Math.random())+ 1 ;
        Roll = Die1 + Die2 ;
      }
      System.out.println( "it took " + NumRolls + " rolls to reach 7");
      totalNumRolls+= NumRolls;
      NumRolls = 0 ;
    }
    double Average = ((1.0*totalNumRolls)/(1.0*N));
    System.out.println( "the Average is " + Average);
    keyboard.close() ;
  }
}