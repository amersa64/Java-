import java.awt.* ;
public class TicTac {
  public static void main (String args[]){//this method prints the axis's
    StdDraw.setXscale(0, 3.0);
    StdDraw.setYscale(0, 3.0);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.line(0,1,3,1);
    StdDraw.line(0,2,3,2);
    StdDraw.line(1,0,1,3);
    StdDraw.line(2,0,2,3);
    int array[][]= new int[3][3];
    for(int i=0; i<3;i++){
      for(int j=0;j<3;j++){
        array[i][j] = 0;
      }
    }
    Mouse (array);
  }
  //this method prints X
  public static void PrintX (double x, double y){
    Font f = new Font("Arial", Font.BOLD,60);
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.setFont(f);
    StdDraw.text(x,y,"X");
  }
  //this method prints O
  public static void PrintO (double x, double y){
    Font f = new Font("Arial", Font.BOLD,60);
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.setFont(f);
    StdDraw.text(x,y,"O");}
  //this method checks for a winner
  public static boolean Winner(int [][]array){
    int sumc=0;
    int sumr=0;
    int diagonal2=0;
    int diagonal1=0;
    for(int i=0;i<3;i++){//checking all coloums
      sumc= (int)(array[i][0]+array[i][1]+array[i][2]);
      if(sumc == -3){
        Font f = new Font("Times New Romen", Font.BOLD,25);
        StdDraw.setFont(f);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.text(1.5,1.5,"we have a winner and it is O's",45);}
      else if (sumc==3) {//****NEED A {} BLOCK HERE *****
        StdDraw.setPenColor(StdDraw.GREEN);
        Font f = new Font("Times New Romen", Font.BOLD,25);
        StdDraw.setFont(f);
        StdDraw.text(1.5,1.5,"we have a winner and it is X's",45);}
    }
    for (int j=0;j<3;j++){//checking all rows
      sumr =(int)(array[0][j]+array[1][j]+array[2][j]);
      if(sumr == -3){
        Font f = new Font("Times New Romen", Font.BOLD,25);
        StdDraw.setFont(f);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.text(1.5,1.5,"we have a winner and it is X's",45);
      }
      else if (sumr==3){
        Font f = new Font("Times New Romen", Font.BOLD,25);
        StdDraw.setFont(f);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.text(1.5,1.5,"we have a winner and it is X's",45);
      }
    }
    diagonal1 =(int)(array[0][0]+array[1][1] +array[2][2]); 
    diagonal2 =(int)(array[0][2]+array[1][1]+array[2][0]);
    if ( diagonal1 ==3 || diagonal2==3){
      Font f = new Font("Times New Romen", Font.BOLD,25);//checking the diagonals
      StdDraw.setFont(f);
      StdDraw.setPenColor(StdDraw.GREEN);
      StdDraw.text(1.5,1.5,"we have a winner and it is X's",45);}
    else if(diagonal1 ==-3 || diagonal2 ==-3){
      Font f = new Font("Times New Romen", Font.BOLD,25);//checking the diagonals
      StdDraw.setFont(f);
      StdDraw.setPenColor(StdDraw.GREEN);
      StdDraw.text(1.5,1.5,"we have a winner and it is O's",45);}
    boolean WeHaveWinner = ((Math.abs(sumr)==3)||(Math.abs(sumc)==3)||(Math.abs(diagonal1)==3)||(Math.abs(diagonal2)==3));
    return WeHaveWinner;
  }
  public static void Mouse(int[][] array){
    boolean gameDone= false;
    for(int turns=1;turns<=9&&!gameDone;){
      while(!StdDraw.mousePressed()){}
      int Xvalue =(int) StdDraw.mouseX();
      int Yvalue =(int) StdDraw.mouseY();
      if (array[Xvalue][Yvalue]==0){
        if (turns%2==0){
          array [Xvalue][Yvalue]=-1;
          PrintO(Xvalue+0.5,Yvalue+0.5);
          System.out.println(turns);
          turns++;
          if (Winner(array)){
           gameDone = true;
          }
        }
        else{
          array [Xvalue][Yvalue]=1;
          PrintX(Xvalue+0.5,Yvalue+0.5);
          System.out.println(turns);
          turns++;
          if (Winner(array)){ 
            gameDone = true;
          }
        }
      }
    }
    if (!gameDone){
    Font f = new Font("Times New Romen", Font.BOLD,25);
    StdDraw.setFont(f);
    StdDraw.setPenColor(StdDraw.GREEN);
    StdDraw.text(1.5,1.5,"IT IS A TIE",45);}
  }
}