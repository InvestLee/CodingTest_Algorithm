import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        for (int i = 1; i<=N; i++){
            if (i%2==0){
                System.out.print(" ");
            }
            for (int j = 1; j<=2*N-1; j++){
                if (j%2==1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}