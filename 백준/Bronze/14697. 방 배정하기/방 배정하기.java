import java.util.Scanner;
public class Main {
    public static void main(String args[]) {
      Scanner s=new Scanner(System.in);
      int a=s.nextInt();
      int b=s.nextInt();
      int c=s.nextInt();
      int n=s.nextInt();
      int x=0;
      
      for(int i=0;i<=n/a;i++){
          for(int j=0;j<=n/b;j++){
              for(int k=0;k<=n/c;k++){
                  if(a*i+b*j+c*k==n){
                      x++;
                      break;
                  }
              }
          }
      }
      if(x==0) System.out.print("0");
      else System.out.print("1");
    }
}