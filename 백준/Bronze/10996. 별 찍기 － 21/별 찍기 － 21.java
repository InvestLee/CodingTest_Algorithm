import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        if (N==1){
            System.out.println("*");
        }
        else {
            for (int i = 1; i <= 2 * N; i++) {
                for (int j = 1; j <= N; j++) {
                    if ((i+j)%2==0){
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
}
