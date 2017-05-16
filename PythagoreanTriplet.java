public class PythagoreanTriplet{
  public static void main (String []args){
    int b = 0 ;
    int a = 0 ;
    int c = 0 ;
    for (b=1 ; b<1000; b++){
      for (a=1 ; a<1000; a++){
        c= 1000 -(a+b);
        if (Math.pow(c,2)== Math.pow(a,2)+Math.pow(b,2) && (b>a) && (c>b)){
          System.out.println( " the triplet is a= " + a +" and b= "+ b +" and c= "+ c);
        break;
        }
      }
    }
  }
}
